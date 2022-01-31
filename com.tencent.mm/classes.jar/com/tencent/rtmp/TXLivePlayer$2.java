package com.tencent.rtmp;

import com.tencent.liteav.o;

class TXLivePlayer$2
  implements o
{
  TXLivePlayer$2(TXLivePlayer paramTXLivePlayer, TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener) {}
  
  public void onVideoRawDataAvailable(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.val$listener.onVideoRawDataAvailable(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */