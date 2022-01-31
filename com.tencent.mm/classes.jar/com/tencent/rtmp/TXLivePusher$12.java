package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLivePusher$12
  implements Runnable
{
  TXLivePusher$12(TXLivePusher paramTXLivePusher, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    AppMethodBeat.i(146980);
    if (TXLivePusher.access$1000(this.this$0) != null) {
      TXLivePusher.access$1000(this.this$0).onPushEvent(this.val$finalEvent, this.val$param);
    }
    AppMethodBeat.o(146980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.12
 * JD-Core Version:    0.7.0.1
 */