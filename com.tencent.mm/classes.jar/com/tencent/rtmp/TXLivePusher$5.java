package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TXLivePusher$5
  implements Runnable
{
  TXLivePusher$5(TXLivePusher paramTXLivePusher, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(65929);
    if (TXLivePusher.access$500(this.this$0) != null) {
      TXLivePusher.access$500(this.this$0).setLogText(null, this.val$param, this.val$event);
    }
    AppMethodBeat.o(65929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.5
 * JD-Core Version:    0.7.0.1
 */