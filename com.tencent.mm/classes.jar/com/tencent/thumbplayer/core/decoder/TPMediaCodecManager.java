package com.tencent.thumbplayer.core.decoder;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.atomic.AtomicInteger;

public class TPMediaCodecManager
{
  private static final String TAG = "TPMediaCodecManager";
  private static AtomicInteger codecNum;
  private static SparseArray<ITPMediaCodecDecoder> mCodecList;
  
  static
  {
    AppMethodBeat.i(227703);
    mCodecList = new SparseArray();
    codecNum = new AtomicInteger(0);
    AppMethodBeat.o(227703);
  }
  
  private static native void _onMediaCodecException(int paramInt, String paramString);
  
  private static native void _onMediaCodecReady(int paramInt, String paramString);
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    AppMethodBeat.i(227684);
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(227684);
    }
  }
  
  public static int createMediaCodec(boolean paramBoolean)
  {
    AppMethodBeat.i(227526);
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    if (paramBoolean) {}
    for (Object localObject = new TPMediaCodecAudioDecoder(i);; localObject = new TPMediaCodecVideoDecoder(i))
    {
      addCodecToList(i, (ITPMediaCodecDecoder)localObject);
      AppMethodBeat.o(227526);
      return i;
    }
  }
  
  public static int flushMediaCodec(int paramInt)
  {
    AppMethodBeat.i(227595);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      AppMethodBeat.o(227595);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.flush();
    AppMethodBeat.o(227595);
    return paramInt;
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    AppMethodBeat.i(227696);
    try
    {
      ITPMediaCodecDecoder localITPMediaCodecDecoder1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localITPMediaCodecDecoder1 == null)
      {
        TPNativeLog.printLog(3, "TPMediaCodecManager", "No such codec by id:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(227696);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(227696);
    }
    AppMethodBeat.o(227696);
    return localITPMediaCodecDecoder2;
  }
  
  public static int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static boolean initAudioMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(227541);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      AppMethodBeat.o(227541);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(227541);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(227541);
    return bool;
  }
  
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(227533);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      AppMethodBeat.o(227533);
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5, paramInt6, paramInt7))
    {
      AppMethodBeat.o(227533);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.startDecoder();
    AppMethodBeat.o(227533);
    return bool;
  }
  
  public static void onMediaCodecException(int paramInt, String paramString)
  {
    AppMethodBeat.i(227674);
    _onMediaCodecException(paramInt, paramString);
    AppMethodBeat.o(227674);
  }
  
  public static void onMediaCodecReady(int paramInt, String paramString)
  {
    AppMethodBeat.i(227669);
    _onMediaCodecReady(paramInt, paramString);
    AppMethodBeat.o(227669);
  }
  
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    AppMethodBeat.i(227562);
    Object localObject = getCodecById(paramInt);
    if (localObject == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      AppMethodBeat.o(227562);
      return null;
    }
    localObject = ((ITPMediaCodecDecoder)localObject).dequeueOutputBuffer();
    AppMethodBeat.o(227562);
    return localObject;
  }
  
  public static int releaseMediaCodec(int paramInt)
  {
    AppMethodBeat.i(227577);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      AppMethodBeat.o(227577);
      return 3;
    }
    removeCodecFromList(paramInt);
    paramInt = localITPMediaCodecDecoder.release();
    AppMethodBeat.o(227577);
    return paramInt;
  }
  
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(227570);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      AppMethodBeat.o(227570);
      return 3;
    }
    paramInt1 = localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
    AppMethodBeat.o(227570);
    return paramInt1;
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    AppMethodBeat.i(227690);
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(227690);
    }
  }
  
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(227553);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      AppMethodBeat.o(227553);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    AppMethodBeat.o(227553);
    return paramInt;
  }
  
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    AppMethodBeat.i(227647);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(227647);
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
    AppMethodBeat.o(227647);
  }
  
  public static int setMediaCodecOperateRate(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(227654);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecOperateRate failed!");
      AppMethodBeat.o(227654);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOperateRate(paramFloat);
    AppMethodBeat.o(227654);
    return paramInt;
  }
  
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(227617);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      AppMethodBeat.o(227617);
      return false;
    }
    paramBoolean = localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
    AppMethodBeat.o(227617);
    return paramBoolean;
  }
  
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227632);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      AppMethodBeat.o(227632);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
    AppMethodBeat.o(227632);
    return bool;
  }
  
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227603);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      AppMethodBeat.o(227603);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
    AppMethodBeat.o(227603);
    return bool;
  }
  
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(227610);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      AppMethodBeat.o(227610);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
    AppMethodBeat.o(227610);
    return bool;
  }
  
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(227638);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      AppMethodBeat.o(227638);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
    AppMethodBeat.o(227638);
    return bool;
  }
  
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(227626);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      AppMethodBeat.o(227626);
      return false;
    }
    boolean bool = localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
    AppMethodBeat.o(227626);
    return bool;
  }
  
  public static int setMediaCodecSharpenSwitch(int paramInt)
  {
    AppMethodBeat.i(227658);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSharpenSwitch failed!");
      AppMethodBeat.o(227658);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setSharpenSwitch();
    AppMethodBeat.o(227658);
    return paramInt;
  }
  
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(227547);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      AppMethodBeat.o(227547);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.setOutputSurface(paramSurface);
    AppMethodBeat.o(227547);
    return paramInt;
  }
  
  public static int signalEndOfStream(int paramInt)
  {
    AppMethodBeat.i(227586);
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      AppMethodBeat.o(227586);
      return 3;
    }
    paramInt = localITPMediaCodecDecoder.signalEndOfStream();
    AppMethodBeat.o(227586);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */