package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusher$6
  implements Runnable
{
  TXLivePusher$6(TXLivePusher paramTXLivePusher, String paramString1, String paramString2) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = 0;
    localTXRecordResult.descMsg = "record success";
    localTXRecordResult.videoPath = this.val$videoFilePath;
    localTXRecordResult.coverPath = this.val$coverPath;
    if (TXLivePusher.access$600(this.this$0) != null) {
      TXLivePusher.access$600(this.this$0).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(TXLivePusher.access$700(), "record complete success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.6
 * JD-Core Version:    0.7.0.1
 */