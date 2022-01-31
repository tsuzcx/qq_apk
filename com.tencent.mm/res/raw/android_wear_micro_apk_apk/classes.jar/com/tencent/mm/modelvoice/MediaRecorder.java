package com.tencent.mm.modelvoice;

public class MediaRecorder
{
  public static native int SilkDecInit(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public static native int SilkDecUnInit();
  
  public static native int SilkDoDec(byte[] paramArrayOfByte, short paramShort);
  
  public static native int SilkDoEnc(byte[] paramArrayOfByte1, short paramShort, byte[] paramArrayOfByte2, short[] paramArrayOfShort, boolean paramBoolean);
  
  public static native int SilkEncInit(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int SilkEncUnInit();
  
  public static native int SilkGetEncSampleRate(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoice.MediaRecorder
 * JD-Core Version:    0.7.0.1
 */