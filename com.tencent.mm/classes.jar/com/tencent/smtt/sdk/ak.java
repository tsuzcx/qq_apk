package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m.a;
import java.util.Map;

final class ak
  implements m.a
{
  ak(TbsDownloadConfig paramTbsDownloadConfig, boolean paramBoolean) {}
  
  public final void a(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramInt);
    if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramInt == 200))
    {
      this.a.a.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
      this.a.a.put("request_fail", Long.valueOf(0L));
      this.a.a.put("count_request_fail_in_24hours", Long.valueOf(0L));
      this.a.commit();
    }
    if (paramInt >= 300)
    {
      if (this.b) {
        this.a.setDownloadInterruptCode(-107);
      }
    }
    else {
      return;
    }
    this.a.setDownloadInterruptCode(-207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.ak
 * JD-Core Version:    0.7.0.1
 */