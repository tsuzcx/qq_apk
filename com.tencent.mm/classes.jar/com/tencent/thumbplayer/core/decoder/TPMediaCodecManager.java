package com.tencent.thumbplayer.core.decoder;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.atomic.AtomicInteger;

public class TPMediaCodecManager
{
  private static final String TAG = "TPMediaCodecManager";
  private static AtomicInteger codecNum;
  private static SparseArray<ITPMediaCodecDecoder> mCodecList;
  
  static
  {
    AppMethodBeat.i(220559);
    mCodecList = new SparseArray();
    codecNum = new AtomicInteger(0);
    AppMethodBeat.o(220559);
  }
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    AppMethodBeat.i(220556);
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(220556);
    }
  }
  
  @TPMethodCalledByNative
  public static int createMediaCodec(boolean paramBoolean)
  {
    AppMethodBeat.i(220539);
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    if (paramBoolean) {}
    for (Object localObject = new TPMediaCodecAudioDecoder();; localObject = new TPMediaCodecVideoDecoder())
    {
      addCodecToList(i, (ITPMediaCodecDecoder)localObject);
      AppMethodBeat.o(220539);
      return i;
    }
  }
  
  @TPMethodCalledByNative
  public static int flushMediaCodec(int paramInt)
  {
    AppMethodBeat.i(220548);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      AppMethodBeat.o(220548);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.flush();
    AppMethodBeat.o(220548);
    return paramInt;
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    AppMethodBeat.i(220558);
    try
    {
      ITPMediaCodecDecoder localITPMediaCodecDecoder1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localITPMediaCodecDecoder1 == null)
      {
        TPNativeLog.printLog(3, "TPMediaCodecManager", "No such codec by id:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(220558);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(220558);
    }
    AppMethodBeat.o(220558);
    return localITPMediaCodecDecoder2;
  }
  
  @TPMethodCalledByNative
  public static int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  @TPMethodCalledByNative
  public static boolean initAudioMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(220541);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      AppMethodBeat.o(220541);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(220541);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(220541);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5)
  {
    AppMethodBeat.i(220540);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      AppMethodBeat.o(220540);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5))
    {
      AppMethodBeat.o(220540);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(220540);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    AppMethodBeat.i(220544);
    Object localObject = getCodecById(paramInt);
    if (localObject == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      AppMethodBeat.o(220544);
      return null;
    }
    localObject = ((ITPMediaCodecDecoder)localObject).dequeueOutputBuffer();
    AppMethodBeat.o(220544);
    return localObject;
  }
  
  @TPMethodCalledByNative
  public static int releaseMediaCodec(int paramInt)
  {
    AppMethodBeat.i(220546);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      AppMethodBeat.o(220546);
      return 3;
    }
    removeCodecFromList(paramInt);
    paramInt = localITPMediaCodecDecoder.release();
    AppMethodBeat.o(220546);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(220545);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      AppMethodBeat.o(220545);
      return 3;
    }
    paramInt1 = localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
    AppMethodBeat.o(220545);
    return paramInt1;
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    AppMethodBeat.i(220557);
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(220557);
    }
  }
  
  @TPMethodCalledByNative
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(220543);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      AppMethodBeat.o(220543);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    AppMethodBeat.o(220543);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(220555);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(220555);
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
    AppMethodBeat.o(220555);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(220551);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      AppMethodBeat.o(220551);
      return false;
    }
    paramBoolean = localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
    AppMethodBeat.o(220551);
    return paramBoolean;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220553);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      AppMethodBeat.o(220553);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
    AppMethodBeat.o(220553);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220549);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      AppMethodBeat.o(220549);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
    AppMethodBeat.o(220549);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220550);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      AppMethodBeat.o(220550);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
    AppMethodBeat.o(220550);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(220554);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(220554);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
    AppMethodBeat.o(220554);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(220552);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      AppMethodBeat.o(220552);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
    AppMethodBeat.o(220552);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(220542);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      AppMethodBeat.o(220542);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOutputSurface(paramSurface);
    AppMethodBeat.o(220542);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int signalEndOfStream(int paramInt)
  {
    AppMethodBeat.i(220547);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      AppMethodBeat.o(220547);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.signalEndOfStream();
    AppMethodBeat.o(220547);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */