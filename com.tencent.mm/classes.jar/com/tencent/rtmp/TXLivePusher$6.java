package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusher$6
  implements Runnable
{
  TXLivePusher$6(TXLivePusher paramTXLivePusher) {}
  
  public void run()
  {
    AppMethodBeat.i(65933);
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = -1;
    localTXRecordResult.descMsg = "record video failed";
    if (TXLivePusher.access$600(this.this$0) != null) {
      TXLivePusher.access$600(this.this$0).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(TXLivePusher.access$700(), "record complete fail");
    AppMethodBeat.o(65933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.6
 * JD-Core Version:    0.7.0.1
 */