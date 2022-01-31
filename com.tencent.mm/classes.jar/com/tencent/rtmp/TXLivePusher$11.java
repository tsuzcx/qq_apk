package com.tencent.rtmp;

import android.os.Bundle;

class TXLivePusher$11
  implements Runnable
{
  TXLivePusher$11(TXLivePusher paramTXLivePusher, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (TXLivePusher.access$1000(this.this$0) != null) {
      TXLivePusher.access$1000(this.this$0).onPushEvent(this.val$finalEvent, this.val$param);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.11
 * JD-Core Version:    0.7.0.1
 */