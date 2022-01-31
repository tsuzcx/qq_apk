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
    AppMethodBeat.i(139035);
    if (!SandboxContentChildProcessServiceDelegate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(139035);
      return;
    }
  }
  
  @CalledByNative
  private void forwardSurfaceTextureForSurfaceRequest(UnguessableToken paramUnguessableToken, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139030);
    if (this.mGpuCallback == null)
    {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      AppMethodBeat.o(139030);
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
      AppMethodBeat.o(139030);
    }
  }
  
  @CalledByNative
  private Surface getViewSurface(int paramInt)
  {
    AppMethodBeat.i(139031);
    if (this.mGpuCallback == null)
    {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      AppMethodBeat.o(139031);
      return null;
    }
    try
    {
      Object localObject = this.mGpuCallback.getViewSurface(paramInt);
      if (localObject != null)
      {
        localObject = ((SurfaceWrapper)localObject).getSurface();
        AppMethodBeat.o(139031);
        return localObject;
      }
      AppMethodBeat.o(139031);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("ContentCPSDelegate", "Unable to call getViewSurface: %s", new Object[] { localRemoteException });
      AppMethodBeat.o(139031);
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
  
  @CalledByNative
  private void setFileDescriptorsIdsToKeys(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(139029);
    if ((!$assertionsDisabled) && (paramArrayOfInt.length != paramArrayOfString.length))
    {
      paramArrayOfInt = new AssertionError();
      AppMethodBeat.o(139029);
      throw paramArrayOfInt;
    }
    if ((!$assertionsDisabled) && (this.mFdsIdsToKeys != null))
    {
      paramArrayOfInt = new AssertionError();
      AppMethodBeat.o(139029);
      throw paramArrayOfInt;
    }
    this.mFdsIdsToKeys = new SparseArray();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      this.mFdsIdsToKeys.put(paramArrayOfInt[i], paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(139029);
  }
  
  public void ExitChildProcess()
  {
    AppMethodBeat.i(139033);
    nativeExitChildProcess();
    AppMethodBeat.o(139033);
  }
  
  public void RegisterFileDescriptors(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(139032);
    nativeRegisterFileDescriptors(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfLong1, paramArrayOfLong2);
    AppMethodBeat.o(139032);
  }
  
  public SparseArray<String> getFileDescriptorsIdsToKeys()
  {
    AppMethodBeat.i(139023);
    if ((!$assertionsDisabled) && (this.mFdsIdsToKeys == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(139023);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mFdsIdsToKeys;
    AppMethodBeat.o(139023);
    return localObject;
  }
  
  public void initCommandLine(String[] paramArrayOfString)
  {
    AppMethodBeat.i(139025);
    nativeInitCommandLine(paramArrayOfString);
    AppMethodBeat.o(139025);
  }
  
  @CalledByNative
  public String invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(139034);
    String str = null;
    if (paramString.equals("lazyLoadLibrary"))
    {
      paramString = paramBundle.getString("libraryName");
      str = String.valueOf(this.mService.lazyLoadLibraryByName(paramString));
    }
    AppMethodBeat.o(139034);
    return str;
  }
  
  public boolean loadNativeLibrary(Context paramContext)
  {
    return true;
  }
  
  public void onBeforeMain()
  {
    AppMethodBeat.i(139024);
    nativeInitChildProcess(this.mCpuCount, this.mCpuFeatures);
    AppMethodBeat.o(139024);
  }
  
  public void onConnectionSetup(Bundle paramBundle, List<IBinder> paramList)
  {
    AppMethodBeat.i(139022);
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
      AppMethodBeat.o(139022);
      throw paramBundle;
    }
    AppMethodBeat.o(139022);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(139026);
    nativeShutdownMainThread();
    AppMethodBeat.o(139026);
  }
  
  public void onServiceBound(Intent paramIntent) {}
  
  public void onServiceCreated() {}
  
  public void preloadNativeLibrary(Context paramContext) {}
  
  public void runMain()
  {
    AppMethodBeat.i(139027);
    RuntimeException localRuntimeException = new RuntimeException("ContentMain.start un-implemented!");
    AppMethodBeat.o(139027);
    throw localRuntimeException;
  }
  
  public void setService(ChildProcessService paramChildProcessService)
  {
    this.mService = paramChildProcessService;
  }
  
  public void startContentMainRunner()
  {
    AppMethodBeat.i(139028);
    nativeStartContentMain();
    AppMethodBeat.o(139028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sandbox.SandboxContentChildProcessServiceDelegate
 * JD-Core Version:    0.7.0.1
 */