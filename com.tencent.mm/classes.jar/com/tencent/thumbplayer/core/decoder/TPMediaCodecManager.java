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
    AppMethodBeat.i(223572);
    mCodecList = new SparseArray();
    codecNum = new AtomicInteger(0);
    AppMethodBeat.o(223572);
  }
  
  private static native void _onMediaCodecException(int paramInt, String paramString);
  
  private static native void _onMediaCodecReady(int paramInt, String paramString);
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    AppMethodBeat.i(223560);
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(223560);
    }
  }
  
  @TPMethodCalledByNative
  public static int createMediaCodec(boolean paramBoolean)
  {
    AppMethodBeat.i(223513);
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    if (paramBoolean) {}
    for (Object localObject = new TPMediaCodecAudioDecoder(i);; localObject = new TPMediaCodecVideoDecoder(i))
    {
      addCodecToList(i, (ITPMediaCodecDecoder)localObject);
      AppMethodBeat.o(223513);
      return i;
    }
  }
  
  @TPMethodCalledByNative
  public static int flushMediaCodec(int paramInt)
  {
    AppMethodBeat.i(223537);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      AppMethodBeat.o(223537);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.flush();
    AppMethodBeat.o(223537);
    return paramInt;
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    AppMethodBeat.i(223569);
    try
    {
      ITPMediaCodecDecoder localITPMediaCodecDecoder1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localITPMediaCodecDecoder1 == null)
      {
        TPNativeLog.printLog(3, "TPMediaCodecManager", "No such codec by id:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(223569);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(223569);
    }
    AppMethodBeat.o(223569);
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
    AppMethodBeat.i(223521);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      AppMethodBeat.o(223521);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(223521);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(223521);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(223516);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      AppMethodBeat.o(223516);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5, paramInt6, paramInt7))
    {
      AppMethodBeat.o(223516);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(223516);
    return bool;
  }
  
  public static void onMediaCodecException(int paramInt, String paramString)
  {
    AppMethodBeat.i(223558);
    _onMediaCodecException(paramInt, paramString);
    AppMethodBeat.o(223558);
  }
  
  public static void onMediaCodecReady(int paramInt, String paramString)
  {
    AppMethodBeat.i(223556);
    _onMediaCodecReady(paramInt, paramString);
    AppMethodBeat.o(223556);
  }
  
  @TPMethodCalledByNative
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    AppMethodBeat.i(223528);
    Object localObject = getCodecById(paramInt);
    if (localObject == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      AppMethodBeat.o(223528);
      return null;
    }
    localObject = ((ITPMediaCodecDecoder)localObject).dequeueOutputBuffer();
    AppMethodBeat.o(223528);
    return localObject;
  }
  
  @TPMethodCalledByNative
  public static int releaseMediaCodec(int paramInt)
  {
    AppMethodBeat.i(223532);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      AppMethodBeat.o(223532);
      return 3;
    }
    removeCodecFromList(paramInt);
    paramInt = localITPMediaCodecDecoder.release();
    AppMethodBeat.o(223532);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(223529);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      AppMethodBeat.o(223529);
      return 3;
    }
    paramInt1 = localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
    AppMethodBeat.o(223529);
    return paramInt1;
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    AppMethodBeat.i(223563);
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(223563);
    }
  }
  
  @TPMethodCalledByNative
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(223526);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      AppMethodBeat.o(223526);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    AppMethodBeat.o(223526);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(223551);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(223551);
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
    AppMethodBeat.o(223551);
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecOperateRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(223554);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecOperateRate failed!");
      AppMethodBeat.o(223554);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOperateRate(paramFloat);
    AppMethodBeat.o(223554);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(223544);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      AppMethodBeat.o(223544);
      return false;
    }
    paramBoolean = localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
    AppMethodBeat.o(223544);
    return paramBoolean;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223547);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      AppMethodBeat.o(223547);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
    AppMethodBeat.o(223547);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(223540);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      AppMethodBeat.o(223540);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
    AppMethodBeat.o(223540);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(223543);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      AppMethodBeat.o(223543);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
    AppMethodBeat.o(223543);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(223549);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(223549);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
    AppMethodBeat.o(223549);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(223546);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      AppMethodBeat.o(223546);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
    AppMethodBeat.o(223546);
    return bool;
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(223524);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      AppMethodBeat.o(223524);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOutputSurface(paramSurface);
    AppMethodBeat.o(223524);
    return paramInt;
  }
  
  @TPMethodCalledByNative
  public static int signalEndOfStream(int paramInt)
  {
    AppMethodBeat.i(223535);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      AppMethodBeat.o(223535);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.signalEndOfStream();
    AppMethodBeat.o(223535);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */