package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

class TXLivePusher$8
  implements Runnable
{
  TXLivePusher$8(TXLivePusher paramTXLivePusher, long paramLong) {}
  
  public void run()
  {
    AppMethodBeat.i(65928);
    if (TXLivePusher.access$600(this.this$0) != null) {
      TXLivePusher.access$600(this.this$0).onRecordProgress(this.val$progress);
    }
    AppMethodBeat.o(65928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.8
 * JD-Core Version:    0.7.0.1
 */