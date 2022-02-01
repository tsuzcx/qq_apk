package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FitScUtil
{
  static
  {
    AppMethodBeat.i(231379);
    System.loadLibrary("tsmsc");
    AppMethodBeat.o(231379);
  }
  
  public native byte[] certEncrypt(String paramString, byte[] paramArrayOfByte);
  
  public native byte[] certSign(String paramString, byte[] paramArrayOfByte);
  
  public native boolean certVerify(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public native boolean clearAllCert();
  
  public native boolean clearAllValue();
  
  public native boolean clearCert(String paramString);
  
  public native boolean clearToken(String paramString);
  
  public native boolean clearValue(String paramString);
  
  public native String encryptPass(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt);
  
  public native long[] getCertExpireTime(String paramString);
  
  public native int getLastError();
  
  public native String getToken(String paramString, boolean paramBoolean);
  
  public native int getTokenCount(String paramString);
  
  public native String getTokenHeader(String paramString);
  
  public native byte[] getValue(String paramString);
  
  public native String getVersion();
  
  public native boolean hasCert(String paramString);
  
  public native boolean hasValue(String paramString);
  
  public native boolean importCert(String paramString1, String paramString2);
  
  public native boolean init(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public native String makeCsr();
  
  public native byte[] md5(byte[] paramArrayOfByte);
  
  public native void release();
  
  public native boolean setToken(String paramString1, String paramString2);
  
  public native boolean setValue(String paramString, byte[] paramArrayOfByte);
  
  public native byte[] sha1(byte[] paramArrayOfByte);
  
  public native byte[] sha256(byte[] paramArrayOfByte);
  
  public native byte[] sm3(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.ndk.FitScUtil
 * JD-Core Version:    0.7.0.1
 */