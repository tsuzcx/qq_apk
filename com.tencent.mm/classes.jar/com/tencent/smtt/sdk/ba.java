package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class ba
  implements n.a
{
  ba(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(64539);
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:".concat(String.valueOf(paramInt)));
    if (paramInt < 300) {
      TbsLogReport.b(this.a);
    }
    AppMethodBeat.o(64539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.ba
 * JD-Core Version:    0.7.0.1
 */