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
    AppMethodBeat.i(189921);
    mCodecList = new SparseArray();
    codecNum = new AtomicInteger(0);
    AppMethodBeat.o(189921);
  }
  
  private static native void _onMediaCodecException(int paramInt, String paramString);
  
  private static native void _onMediaCodecReady(int paramInt, String paramString);
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    AppMethodBeat.i(189918);
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(189918);
    }
  }
  
  @TPMethodCalledByNative
  public static int createMediaCodec(boolean paramBoolean)
  {
    AppMethodBeat.i(189898);
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    if (paramBoolean) {}
    for (Object localObject = new TPMediaCodecAudioDecoder(i);; localObject = new TPMediaCodecVideoDecoder(i))
    {
      addCodecToList(i, (ITPMediaCodecDecoder)localObject);
      AppMethodBeat.o(189898);
      return i;
    }
  }
  
  @TPMethodCalledByNative
  public static int flushMediaCodec(int paramInt)
  {
    AppMethodBeat.i(189907);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      AppMethodBeat.o(189907);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.flush();
    AppMethodBeat.o(189907);
    return paramInt;
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    AppMethodBeat.i(189920);
    try
    {
      ITPMediaCodecDecoder localITPMediaCodecDecoder1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localITPMediaCodecDecoder1 == null)
      {
        TPNativeLog.printLog(3, "TPMediaCodecManager", "No such codec by id:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(189920);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(189920);
    }
    AppMethodBeat.o(189920);
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
    AppMethodBeat.i(189900);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      AppMethodBeat.o(189900);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(189900);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(189900);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(189899);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      AppMethodBeat.o(189899);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5, paramInt6, paramInt7))
    {
      AppMethodBeat.o(189899);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(189899);
    return bool;
  }
  
  public static void onMediaCodecException(int paramInt, String paramString)
  {
    AppMethodBeat.i(189917);
    _onMediaCodecException(paramInt, paramString);
    AppMethodBeat.o(189917);
  }
  
  public static void onMediaCodecReady(int paramInt, String paramString)
  {
    AppMethodBeat.i(189916);
    _onMediaCodecReady(paramInt, paramString);
    AppMethodBeat.o(189916);
  }
  
  @TPMethodCalledByNative
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    AppMethodBeat.i(189903);
    Object localObject = getCodecById(paramInt);
    if (localObject == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      AppMethodBeat.o(189903);
      return null;
    }
    localObject = ((ITPMediaCodecDecoder)localObject).dequeueOutputBuffer();
    AppMethodBeat.o(189903);
    return localObject;
  }
  
  @TPMethodCalledByNative
  public static int releaseMediaCodec(int paramInt)
  {
    AppMethodBeat.i(189905);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      AppMethodBeat.o(189905);
      return 3;
    }
    removeCodecFromList(paramInt);
    paramInt = localITPMediaCodecDecoder.release();
    AppMethodBeat.o(189905);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(189904);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      AppMethodBeat.o(189904);
      return 3;
    }
    paramInt1 = localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
    AppMethodBeat.o(189904);
    return paramInt1;
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    AppMethodBeat.i(189919);
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(189919);
    }
  }
  
  @TPMethodCalledByNative
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(189902);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      AppMethodBeat.o(189902);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    AppMethodBeat.o(189902);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(189914);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(189914);
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
    AppMethodBeat.o(189914);
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecOperateRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(189915);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecOperateRate failed!");
      AppMethodBeat.o(189915);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOperateRate(paramFloat);
    AppMethodBeat.o(189915);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(189910);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      AppMethodBeat.o(189910);
      return false;
    }
    paramBoolean = localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
    AppMethodBeat.o(189910);
    return paramBoolean;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189912);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      AppMethodBeat.o(189912);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
    AppMethodBeat.o(189912);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189908);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      AppMethodBeat.o(189908);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
    AppMethodBeat.o(189908);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(189909);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      AppMethodBeat.o(189909);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
    AppMethodBeat.o(189909);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(189913);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(189913);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
    AppMethodBeat.o(189913);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(189911);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      AppMethodBeat.o(189911);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
    AppMethodBeat.o(189911);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(189901);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      AppMethodBeat.o(189901);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOutputSurface(paramSurface);
    AppMethodBeat.o(189901);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int signalEndOfStream(int paramInt)
  {
    AppMethodBeat.i(189906);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      AppMethodBeat.o(189906);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.signalEndOfStream();
    AppMethodBeat.o(189906);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */