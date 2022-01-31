package com.tencent.rtmp;

public abstract interface TXLivePusher$AudioCustomProcessListener
{
  public abstract void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener
 * JD-Core Version:    0.7.0.1
 */