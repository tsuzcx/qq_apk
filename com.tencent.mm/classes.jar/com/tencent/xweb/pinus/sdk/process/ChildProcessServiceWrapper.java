package com.tencent.xweb.pinus.sdk.process;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.pinus.sdk.JNIUtils;
import com.tencent.xweb.pinus.sdk.library_loader.Linker;
import com.tencent.xweb.util.m;
import dalvik.system.InMemoryDexClassLoader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;

public class ChildProcessServiceWrapper
{
  public static final String EXTRA_APK_VERSION = "org.chromium.base.process_launcher.extra.apk_version";
  private static final int PRE_CONNECTION_CODE_CRASH_DUMP_FD = 2;
  private static final int PRE_CONNECTION_CODE_CUSTOM_FONT_FD = 3;
  private static final int PRE_CONNECTION_CODE_DEX_FD = 0;
  private static final int PRE_CONNECTION_CODE_SO_FD = 1;
  private static final String TAG = "ChildProcessServiceWrapper";
  private ClassLoader mClassLoader;
  private Object mService;
  
  static
  {
    AppMethodBeat.i(213543);
    if (!ChildProcessServiceWrapper.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(213543);
      return;
    }
  }
  
  public ChildProcessServiceWrapper(Intent paramIntent, Service paramService, Context paramContext)
  {
    AppMethodBeat.i(213536);
    Object localObject1 = paramIntent.getExtras();
    paramIntent = ((Bundle)localObject1).getString("org.chromium.base.process_launcher.extra.apk_version", "");
    localObject1 = ((Bundle)localObject1).getBinder("preConnection");
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      boolean bool;
      try
      {
        bool = isIsolatedProcess();
        if (!bool) {
          break label637;
        }
        try
        {
          ((IBinder)localObject1).transact(2, localParcel1, localParcel2, 0);
          if (localParcel2.readInt() != 1) {
            break label772;
          }
          bool = true;
          Log.i("ChildProcessServiceWrapper", "CrashRecordFileDescriptor: exist:".concat(String.valueOf(bool)));
          if (bool)
          {
            localObject2 = (ParcelFileDescriptor)localParcel2.readParcelable(getClass().getClassLoader());
            ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)localParcel2.readParcelable(getClass().getClassLoader());
            SandBoxHelper.listener.setCrashRecordFileDescriptor((ParcelFileDescriptor)localObject2, localParcelFileDescriptor);
          }
        }
        finally
        {
          try
          {
            Object localObject2;
            ((IBinder)localObject1).transact(3, localParcel1, localParcel2, 0);
            if (localParcel2.readInt() != 1) {
              break label778;
            }
            bool = true;
            Log.i("ChildProcessServiceWrapper", "cunstom font : exist:".concat(String.valueOf(bool)));
            if (bool)
            {
              paramIntent = (ParcelFileDescriptor)localParcel2.readParcelable(getClass().getClassLoader());
              this.mClassLoader.loadClass("com.tencent.xweb.XWebCommJni").getMethod("SetCustomFontFD", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramIntent.detachFd()) });
            }
            AppMethodBeat.o(213536);
            return;
          }
          finally {}
          localObject3 = finally;
          Log.e("ChildProcessServiceWrapper", "CrashRecordFileDescriptor: Exception:".concat(String.valueOf(localObject3)));
          continue;
        }
        ((IBinder)localObject1).transact(0, localParcel1, localParcel2, 0);
        localObject2 = (ParcelFileDescriptor)localParcel2.readParcelable(getClass().getClassLoader());
        Os.lseek(((ParcelFileDescriptor)localObject2).getFileDescriptor(), 0L, OsConstants.SEEK_SET);
        localObject2 = readDexFileFromApk(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)localObject2));
        if (Build.VERSION.SDK_INT >= 27)
        {
          this.mClassLoader = new InMemoryDexClassLoader((ByteBuffer[])localObject2, ClassLoader.getSystemClassLoader());
          JNIUtils.setClassLoader(this.mClassLoader);
          this.mService = this.mClassLoader.loadClass("com.tencent.xweb.pinus.ChildProcessServiceHelper").getMethod("create", new Class[] { Service.class, Context.class }).invoke(null, new Object[] { paramService, paramContext });
          ((IBinder)localObject1).transact(1, localParcel1, localParcel2, 0);
          paramService = (ParcelFileDescriptor)localParcel2.readParcelable(getClass().getClassLoader());
          Os.lseek(paramService.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
          Linker.getInstance().loadLibraryByFd("app_xwalk_" + paramIntent + "/extracted_xwalkcore/libxwebcore.so", false, paramService.detachFd(), true);
        }
        if (Build.VERSION.SDK_INT != 26) {
          break label570;
        }
      }
      finally
      {
        Log.e("ChildProcessServiceWrapper", "ChildProcessServiceWrapper, error:".concat(String.valueOf(paramIntent)));
        AppMethodBeat.o(213536);
        return;
      }
      this.mClassLoader = ClassLoader.getSystemClassLoader();
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        this.mClassLoader = new InMemoryDexClassLoader(localObject3[i], this.mClassLoader);
        i += 1;
      }
      continue;
      label570:
      Log.e("ChildProcessServiceWrapper", "ChildProcessServiceWrapper: Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
      if (!$assertionsDisabled)
      {
        paramIntent = new AssertionError();
        AppMethodBeat.o(213536);
        throw paramIntent;
        label637:
        XWalkEnvironment.init(paramContext);
        this.mClassLoader = m.df(Integer.valueOf(paramIntent).intValue(), true);
        JNIUtils.setClassLoader(this.mClassLoader);
        this.mService = this.mClassLoader.loadClass("com.tencent.xweb.pinus.ChildProcessServiceHelper").getMethod("create", new Class[] { Service.class, Context.class }).invoke(null, new Object[] { paramService, paramContext });
        paramIntent = XWalkFileUtil.getExtractedCoreDir(Integer.valueOf(paramIntent).intValue()) + File.separator + "libxwebcore.so";
        Log.i("ChildProcessServiceWrapper", "ChildProcessServiceWrapper: libPath:".concat(String.valueOf(paramIntent)));
        System.load(paramIntent);
        AppMethodBeat.o(213536);
        return;
        label772:
        bool = false;
        continue;
        label778:
        bool = false;
      }
    }
  }
  
  public static boolean isIsolatedProcess()
  {
    AppMethodBeat.i(213503);
    RuntimeException localRuntimeException;
    try
    {
      boolean bool = ((Boolean)Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
      AppMethodBeat.o(213503);
      return bool;
    }
    finally
    {
      localRuntimeException = new RuntimeException(localThrowable);
      AppMethodBeat.o(213503);
    }
  }
  
  public static ByteBuffer[] readDexFileFromApk(FileInputStream paramFileInputStream)
  {
    AppMethodBeat.i(213515);
    ArrayList localArrayList = new ArrayList();
    paramFileInputStream = new ZipInputStream(new BufferedInputStream(paramFileInputStream));
    for (;;)
    {
      Object localObject = paramFileInputStream.getNextEntry();
      if (localObject == null)
      {
        paramFileInputStream.close();
        paramFileInputStream.close();
        paramFileInputStream = new ByteBuffer[localArrayList.size()];
        localArrayList.toArray(paramFileInputStream);
        AppMethodBeat.o(213515);
        return paramFileInputStream;
      }
      if (((ZipEntry)localObject).getName().endsWith(".dex"))
      {
        localObject = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramFileInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
        }
        localArrayList.add(ByteBuffer.wrap(((ByteArrayOutputStream)localObject).toByteArray()));
      }
      paramFileInputStream.closeEntry();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(213567);
    try
    {
      paramIntent = (IBinder)this.mClassLoader.loadClass("org.chromium.base.process_launcher.ChildProcessService").getMethod("onBind", new Class[] { Intent.class }).invoke(this.mService, new Object[] { paramIntent });
      AppMethodBeat.o(213567);
      return paramIntent;
    }
    catch (ClassNotFoundException paramIntent)
    {
      Log.e("ChildProcessServiceWrapper", "onBind, error:".concat(String.valueOf(paramIntent)));
      AppMethodBeat.o(213567);
      return null;
    }
    catch (IllegalAccessException paramIntent)
    {
      break label59;
    }
    catch (NoSuchMethodException paramIntent)
    {
      break label59;
    }
    catch (InvocationTargetException paramIntent)
    {
      label59:
      break label59;
    }
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(213551);
    try
    {
      this.mClassLoader.loadClass("org.chromium.base.process_launcher.ChildProcessService").getMethod("onCreate", new Class[0]).invoke(this.mService, new Object[0]);
      AppMethodBeat.o(213551);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("ChildProcessServiceWrapper", "onCreate, error:".concat(String.valueOf(localClassNotFoundException)));
      AppMethodBeat.o(213551);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label46;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label46;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label46:
      break label46;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213558);
    try
    {
      this.mClassLoader.loadClass("org.chromium.base.process_launcher.ChildProcessService").getMethod("onDestroy", new Class[0]).invoke(this.mService, new Object[0]);
      AppMethodBeat.o(213558);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("ChildProcessServiceWrapper", "onDestroy, error:".concat(String.valueOf(localClassNotFoundException)));
      AppMethodBeat.o(213558);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label46;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label46;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label46:
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.process.ChildProcessServiceWrapper
 * JD-Core Version:    0.7.0.1
 */