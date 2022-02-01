package com.tencent.qqpinyin.voicerecoapi;

public class TRSpeexNative
{
  public native int nativeTRSpeexDecode(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2);
  
  public native long nativeTRSpeexDecodeInit();
  
  public native int nativeTRSpeexDecodeRelease(long paramLong);
  
  native int nativeTRSpeexEncode(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2);
  
  native long nativeTRSpeexInit();
  
  native int nativeTRSpeexRelease(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.TRSpeexNative
 * JD-Core Version:    0.7.0.1
 */