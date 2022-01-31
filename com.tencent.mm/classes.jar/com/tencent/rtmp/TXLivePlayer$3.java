package com.tencent.rtmp;

import android.graphics.Bitmap;

class TXLivePlayer$3
  implements Runnable
{
  TXLivePlayer$3(TXLivePlayer paramTXLivePlayer, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$listener != null) {
      this.val$listener.onSnapshot(this.val$bmp);
    }
    TXLivePlayer.access$202(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer.3
 * JD-Core Version:    0.7.0.1
 */