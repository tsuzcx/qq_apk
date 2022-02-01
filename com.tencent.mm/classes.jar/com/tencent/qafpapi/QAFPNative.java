package com.tencent.qafpapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public class QAFPNative
{
  static
  {
    AppMethodBeat.i(39594);
    QAFPNative.class.getClassLoader();
    k.DA("wechatQAFP");
    AppMethodBeat.o(39594);
  }
  
  public static native int QAFPGetAudioFingerPrint(byte[] paramArrayOfByte);
  
  public static native int QAFPGetAudioFingerPrintTV(byte[] paramArrayOfByte);
  
  public static native int QAFPGetVersion();
  
  public static native int QAFPInit();
  
  public static native int QAFPProcess(byte[] paramArrayOfByte, int paramInt);
  
  public static native int QAFPProcessTV(byte[] paramArrayOfByte, int paramInt);
  
  public static native int QAFPRelease();
  
  public static native int QAFPReset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.qafpapi.QAFPNative
 * JD-Core Version:    0.7.0.1
 */