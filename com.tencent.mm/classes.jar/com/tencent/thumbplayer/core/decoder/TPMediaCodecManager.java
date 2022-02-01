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
    AppMethodBeat.i(193777);
    mCodecList = new SparseArray();
    codecNum = new AtomicInteger(0);
    AppMethodBeat.o(193777);
  }
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    AppMethodBeat.i(193774);
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(193774);
    }
  }
  
  @TPMethodCalledByNative
  public static int createMediaCodec(boolean paramBoolean)
  {
    AppMethodBeat.i(193757);
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    if (paramBoolean) {}
    for (Object localObject = new TPMediaCodecAudioDecoder();; localObject = new TPMediaCodecVideoDecoder())
    {
      addCodecToList(i, (ITPMediaCodecDecoder)localObject);
      AppMethodBeat.o(193757);
      return i;
    }
  }
  
  @TPMethodCalledByNative
  public static int flushMediaCodec(int paramInt)
  {
    AppMethodBeat.i(193766);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      AppMethodBeat.o(193766);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.flush();
    AppMethodBeat.o(193766);
    return paramInt;
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    AppMethodBeat.i(193776);
    try
    {
      ITPMediaCodecDecoder localITPMediaCodecDecoder1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localITPMediaCodecDecoder1 == null)
      {
        TPNativeLog.printLog(3, "TPMediaCodecManager", "No such codec by id:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(193776);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(193776);
    }
    AppMethodBeat.o(193776);
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
    AppMethodBeat.i(193759);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      AppMethodBeat.o(193759);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(193759);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(193759);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5)
  {
    AppMethodBeat.i(193758);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      AppMethodBeat.o(193758);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5))
    {
      AppMethodBeat.o(193758);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(193758);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    AppMethodBeat.i(193762);
    Object localObject = getCodecById(paramInt);
    if (localObject == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      AppMethodBeat.o(193762);
      return null;
    }
    localObject = ((ITPMediaCodecDecoder)localObject).dequeueOutputBuffer();
    AppMethodBeat.o(193762);
    return localObject;
  }
  
  @TPMethodCalledByNative
  public static int releaseMediaCodec(int paramInt)
  {
    AppMethodBeat.i(193764);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      AppMethodBeat.o(193764);
      return 3;
    }
    removeCodecFromList(paramInt);
    paramInt = localITPMediaCodecDecoder.release();
    AppMethodBeat.o(193764);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(193763);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      AppMethodBeat.o(193763);
      return 3;
    }
    paramInt1 = localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
    AppMethodBeat.o(193763);
    return paramInt1;
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    AppMethodBeat.i(193775);
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(193775);
    }
  }
  
  @TPMethodCalledByNative
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(193761);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      AppMethodBeat.o(193761);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    AppMethodBeat.o(193761);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(193773);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(193773);
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
    AppMethodBeat.o(193773);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(193769);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      AppMethodBeat.o(193769);
      return false;
    }
    paramBoolean = localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
    AppMethodBeat.o(193769);
    return paramBoolean;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193771);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      AppMethodBeat.o(193771);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
    AppMethodBeat.o(193771);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193767);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      AppMethodBeat.o(193767);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
    AppMethodBeat.o(193767);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(193768);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      AppMethodBeat.o(193768);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
    AppMethodBeat.o(193768);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(193772);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(193772);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
    AppMethodBeat.o(193772);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(193770);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      AppMethodBeat.o(193770);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
    AppMethodBeat.o(193770);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(193760);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      AppMethodBeat.o(193760);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOutputSurface(paramSurface);
    AppMethodBeat.o(193760);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int signalEndOfStream(int paramInt)
  {
    AppMethodBeat.i(193765);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      AppMethodBeat.o(193765);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.signalEndOfStream();
    AppMethodBeat.o(193765);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */