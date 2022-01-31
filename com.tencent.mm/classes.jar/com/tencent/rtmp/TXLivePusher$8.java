package com.tencent.rtmp;

import android.graphics.Bitmap;

class TXLivePusher$8
  implements Runnable
{
  TXLivePusher$8(TXLivePusher paramTXLivePusher, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$listener != null) {
      this.val$listener.onSnapshot(this.val$bmp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.8
 * JD-Core Version:    0.7.0.1
 */