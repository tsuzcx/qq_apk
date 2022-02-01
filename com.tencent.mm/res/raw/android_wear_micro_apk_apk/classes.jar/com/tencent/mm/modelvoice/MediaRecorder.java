package com.tencent.mm.modelvoice;

public class MediaRecorder
{
  public static long WZ = 0L;
  public static long Xa = 0L;
  
  public static native int SetVoiceSilkControl(int paramInt1, int paramInt2, long paramLong);
  
  public static native int SetVoiceSilkDecControl(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong);
  
  public static native long SilkDecInit(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong);
  
  public static native int SilkDecUnInit(long paramLong);
  
  public static native int SilkDoDec(byte[] paramArrayOfByte, short paramShort, long paramLong);
  
  public static native int SilkDoEnc(byte[] paramArrayOfByte1, short paramShort, byte[] paramArrayOfByte2, short[] paramArrayOfShort, boolean paramBoolean, long paramLong);
  
  public static native long SilkEncInit(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static native int SilkEncUnInit(long paramLong);
  
  public static native int SilkGetEncSampleRate(byte[] paramArrayOfByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoice.MediaRecorder
 * JD-Core Version:    0.7.0.1
 */