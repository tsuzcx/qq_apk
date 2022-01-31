package com.tencent.rtmp;

public abstract interface TXLivePlayer$ITXAudioRawDataListener
{
  public abstract void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onPcmDataAvailable(byte[] paramArrayOfByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener
 * JD-Core Version:    0.7.0.1
 */