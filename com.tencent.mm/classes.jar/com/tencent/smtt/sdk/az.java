package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m.a;

class az
  implements m.a
{
  az(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramInt);
    if (paramInt < 300) {
      TbsLogReport.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.az
 * JD-Core Version:    0.7.0.1
 */