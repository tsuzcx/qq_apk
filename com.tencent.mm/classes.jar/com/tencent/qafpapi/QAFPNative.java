package com.tencent.qafpapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public class QAFPNative
{
  static
  {
    AppMethodBeat.i(35387);
    k.a("wechatQAFP", QAFPNative.class.getClassLoader());
    AppMethodBeat.o(35387);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qafpapi.QAFPNative
 * JD-Core Version:    0.7.0.1
 */