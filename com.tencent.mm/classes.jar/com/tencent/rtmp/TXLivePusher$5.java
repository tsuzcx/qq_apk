package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusher$5
  implements Runnable
{
  TXLivePusher$5(TXLivePusher paramTXLivePusher) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = -1;
    localTXRecordResult.descMsg = "record video failed";
    if (TXLivePusher.access$600(this.this$0) != null) {
      TXLivePusher.access$600(this.this$0).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(TXLivePusher.access$700(), "record complete fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.5
 * JD-Core Version:    0.7.0.1
 */