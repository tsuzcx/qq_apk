package com.tencent.nativecrash;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  public static final int DEFAULT_FULL_FLAGS = -1;
  public static final int DEFAULT_SHORT_FLAGS = 1867;
  public static final int DUMP_ABORT_MESSAGE = 1024;
  public static final int DUMP_FILE_DESCRIPTORS = 2048;
  public static final int DUMP_JAVA_STACK = 64;
  public static final int DUMP_MAPPINGS = 32;
  public static final int DUMP_OTHER_THREADS = 128;
  public static final int DUMP_PRESET_CUSTOM = 256;
  public static final int DUMP_PROCESS = 1;
  public static final int DUMP_REALTIME_CUSTOM = 512;
  public static final int DUMP_REGISTER = 4;
  public static final int DUMP_SIGNAL = 2;
  public static final int DUMP_STACK = 8;
  public static final int DUMP_STACK_MEMORY = 16;
  private static final String TAG = "NativeCrash";
  private static final Charset UTF8;
  private static ANRCallback mANRCallback;
  private static CrashCallback mCrashCallback;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(40117);
    UTF8 = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static ANRCallback anrCallback()
  {
    return mANRCallback;
  }
  
  public static ANRCallback anrCallback(ANRCallback paramANRCallback)
  {
    ANRCallback localANRCallback = mANRCallback;
    mANRCallback = paramANRCallback;
    return localANRCallback;
  }
  
  public static CrashCallback crashCallback()
  {
    return mCrashCallback;
  }
  
  public static CrashCallback crashCallback(CrashCallback paramCrashCallback)
  {
    CrashCallback localCrashCallback = mCrashCallback;
    mCrashCallback = paramCrashCallback;
    return localCrashCallback;
  }
  
  public static void customInfo(String paramString)
  {
    AppMethodBeat.i(40114);
    if (paramString == null)
    {
      AppMethodBeat.o(40114);
      return;
    }
    if (!paramString.endsWith("\n")) {}
    for (paramString = paramString + "";; paramString = paramString + '\000')
    {
      nativeCustomInfo(paramString.getBytes(UTF8));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static void init(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210421);
    init(paramString, paramInt1, paramInt2, false);
    AppMethodBeat.o(210421);
  }
  
  public static void init(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(210424);
    if (!InitializationProbe.libLoaded)
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatcrash");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/nativecrash/NativeCrash", "init", "(Ljava/lang/String;IIZ)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/nativecrash/NativeCrash", "init", "(Ljava/lang/String;IIZ)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    }
    nativeInit(paramString, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(210424);
  }
  
  public static void init(ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210428);
    if (!InitializationProbe.libLoaded)
    {
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG("wechatcrash");
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/nativecrash/NativeCrash", "init", "([Landroid/os/ParcelFileDescriptor;II)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/nativecrash/NativeCrash", "init", "([Landroid/os/ParcelFileDescriptor;II)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    }
    Object localObject1 = new int[paramArrayOfParcelFileDescriptor.length];
    int i = 0;
    if (i < paramArrayOfParcelFileDescriptor.length)
    {
      if (paramArrayOfParcelFileDescriptor[i] == null) {}
      for (int j = -1;; j = paramArrayOfParcelFileDescriptor[i].getFd())
      {
        localObject1[i] = j;
        i += 1;
        break;
      }
    }
    nativeInitFd((int[])localObject1, paramInt1, paramInt2);
    AppMethodBeat.o(210428);
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nativeInitFd(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  private static native void nativeReserveMemory();
  
  private static native void nativeResetCustomInfo();
  
  private static boolean onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(210439);
    try
    {
      return (mANRCallback != null) && (mANRCallback.onANRDumped(paramInt, paramString));
    }
    finally
    {
      AppMethodBeat.o(210439);
    }
  }
  
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210436);
    try
    {
      return (mCrashCallback != null) && (mCrashCallback.onCrashDumped(paramInt, paramString1, paramString2));
    }
    finally
    {
      AppMethodBeat.o(210436);
    }
  }
  
  public static void reserveMemory()
  {
    AppMethodBeat.i(210433);
    nativeReserveMemory();
    AppMethodBeat.o(210433);
  }
  
  public static void resetCustomInfo()
  {
    AppMethodBeat.i(40115);
    nativeResetCustomInfo();
    AppMethodBeat.o(40115);
  }
  
  public static abstract interface ANRCallback
  {
    public abstract boolean onANRDumped(int paramInt, String paramString);
  }
  
  public static abstract interface CrashCallback
  {
    public abstract boolean onCrashDumped(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */