package com.tencent.smtt.sandbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.IGpuProcessCallback.Stub;
import org.chromium.content.common.SurfaceWrapper;

@JNINamespace("content")
public class SandboxContentChildProcessServiceDelegate
  implements ChildProcessServiceDelegate
{
  private static final String TAG = "ContentCPSDelegate";
  private int mCpuCount;
  private long mCpuFeatures;
  private SparseArray<String> mFdsIdsToKeys;
  private IGpuProcessCallback mGpuCallback;
  private ChildProcessService mService = null;
  
  static
  {
    AppMethodBeat.i(53784);
    if (!SandboxContentChildProcessServiceDelegate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(53784);
      return;
    }
  }
  
  private void forwardSurfaceTextureForSurfaceRequest(UnguessableToken paramUnguessableToken, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(53779);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    if (this.mGpuCallback == null)
    {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      AppMethodBeat.o(53779);
      return;
    }
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    try
    {
      this.mGpuCallback.forwardSurfaceForSurfaceRequest(paramUnguessableToken, paramSurfaceTexture);
      this.mGpuCallback.invokeMiscMethod("invokeX5Core", new Bundle());
      return;
    }
    catch (RemoteException paramUnguessableToken)
    {
      Log.e("ContentCPSDelegate", "Unable to call forwardSurfaceForSurfaceRequest: %s", new Object[] { paramUnguessableToken });
      return;
    }
    finally
    {
      paramSurfaceTexture.release();
      AppMethodBeat.o(53779);
    }
  }
  
  private Surface getViewSurface(int paramInt)
  {
    AppMethodBeat.i(53780);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    if (this.mGpuCallback == null)
    {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      AppMethodBeat.o(53780);
      return null;
    }
    try
    {
      Object localObject = this.mGpuCallback.getViewSurface(paramInt);
      if (localObject != null)
      {
        localObject = ((SurfaceWrapper)localObject).getSurface();
        AppMethodBeat.o(53780);
        return localObject;
      }
      AppMethodBeat.o(53780);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("ContentCPSDelegate", "Unable to call getViewSurface: %s", new Object[] { localRemoteException });
      AppMethodBeat.o(53780);
    }
    return null;
  }
  
  private static native void nativeExitChildProcess();
  
  private native void nativeInitChildProcess(int paramInt, long paramLong);
  
  private static native void nativeInitCommandLine(String[] paramArrayOfString);
  
  private static native int nativeInvoke(String paramString, String[] paramArrayOfString);
  
  private static native void nativeRegisterFileDescriptors(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  
  private native void nativeRetrieveFileDescriptorsIdsToKeys();
  
  private native void nativeShutdownMainThread();
  
  private static native int nativeStartContentMain();
  
  private void setFileDescriptorsIdsToKeys(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(53778);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    if ((!$assertionsDisabled) && (paramArrayOfInt.length != paramArrayOfString.length))
    {
      paramArrayOfInt = new AssertionError();
      AppMethodBeat.o(53778);
      throw paramArrayOfInt;
    }
    if ((!$assertionsDisabled) && (this.mFdsIdsToKeys != null))
    {
      paramArrayOfInt = new AssertionError();
      AppMethodBeat.o(53778);
      throw paramArrayOfInt;
    }
    this.mFdsIdsToKeys = new SparseArray();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      this.mFdsIdsToKeys.put(paramArrayOfInt[i], paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(53778);
  }
  
  public void ExitChildProcess()
  {
    AppMethodBeat.i(53782);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    nativeExitChildProcess();
    AppMethodBeat.o(53782);
  }
  
  public void RegisterFileDescriptors(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(53781);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    nativeRegisterFileDescriptors(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfLong1, paramArrayOfLong2);
    AppMethodBeat.o(53781);
  }
  
  public SparseArray<String> getFileDescriptorsIdsToKeys()
  {
    AppMethodBeat.i(53772);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    if ((!$assertionsDisabled) && (this.mFdsIdsToKeys == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(53772);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mFdsIdsToKeys;
    AppMethodBeat.o(53772);
    return localObject;
  }
  
  public void initCommandLine(String[] paramArrayOfString)
  {
    AppMethodBeat.i(53774);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] args: " + Arrays.toString(paramArrayOfString));
    nativeInitCommandLine(paramArrayOfString);
    AppMethodBeat.o(53774);
  }
  
  public String invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(53783);
    Log.d("ContentCPSDelegate", "invokeMiscMethod -- method: " + paramString + ", bundle: " + paramBundle);
    String str = null;
    if (paramString.equals("lazyLoadLibrary"))
    {
      paramString = paramBundle.getString("libraryName");
      str = String.valueOf(this.mService.lazyLoadLibraryByName(paramString));
    }
    AppMethodBeat.o(53783);
    return str;
  }
  
  public boolean loadNativeLibrary(Context paramContext)
  {
    AppMethodBeat.i(53771);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] hostContext: " + paramContext);
    AppMethodBeat.o(53771);
    return true;
  }
  
  public void onBeforeMain()
  {
    AppMethodBeat.i(53773);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    nativeInitChildProcess(this.mCpuCount, this.mCpuFeatures);
    AppMethodBeat.o(53773);
  }
  
  public void onConnectionSetup(Bundle paramBundle, List<IBinder> paramList)
  {
    AppMethodBeat.i(53769);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] connectionBundle: " + paramBundle + " clientInterfaces: " + paramList);
    if ((paramList != null) && (!paramList.isEmpty())) {}
    for (paramList = IGpuProcessCallback.Stub.asInterface((IBinder)paramList.get(0));; paramList = null)
    {
      this.mGpuCallback = paramList;
      this.mCpuCount = paramBundle.getInt("com.google.android.apps.chrome.extra.cpu_count");
      this.mCpuFeatures = paramBundle.getLong("com.google.android.apps.chrome.extra.cpu_features");
      if (($assertionsDisabled) || (this.mCpuCount > 0)) {
        break;
      }
      paramBundle = new AssertionError();
      AppMethodBeat.o(53769);
      throw paramBundle;
    }
    AppMethodBeat.o(53769);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53775);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    nativeShutdownMainThread();
    AppMethodBeat.o(53775);
  }
  
  public void onServiceBound(Intent paramIntent)
  {
    AppMethodBeat.i(53768);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] intent: " + paramIntent);
    AppMethodBeat.o(53768);
  }
  
  public void onServiceCreated()
  {
    AppMethodBeat.i(53767);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] ...");
    AppMethodBeat.o(53767);
  }
  
  public void preloadNativeLibrary(Context paramContext)
  {
    AppMethodBeat.i(53770);
    Log.i("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] hostContext: " + paramContext, new Object[0]);
    AppMethodBeat.o(53770);
  }
  
  public void runMain()
  {
    AppMethodBeat.i(53776);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    RuntimeException localRuntimeException = new RuntimeException("ContentMain.start un-implemented!");
    AppMethodBeat.o(53776);
    throw localRuntimeException;
  }
  
  public void setService(ChildProcessService paramChildProcessService)
  {
    this.mService = paramChildProcessService;
  }
  
  public void startContentMainRunner()
  {
    AppMethodBeat.i(53777);
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    int i = nativeStartContentMain();
    Log.d("ContentCPSDelegate", "[" + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName() + "] result: " + i);
    AppMethodBeat.o(53777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sandbox.SandboxContentChildProcessServiceDelegate
 * JD-Core Version:    0.7.0.1
 */