package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;
import java.util.Map;

final class al
  implements n.a
{
  al(TbsDownloadConfig paramTbsDownloadConfig, boolean paramBoolean) {}
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(139252);
    long l = System.currentTimeMillis();
    this.a.a.put("last_check", Long.valueOf(l));
    this.a.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=".concat(String.valueOf(paramInt)));
    if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramInt == 200))
    {
      this.a.a.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
      this.a.a.put("request_fail", Long.valueOf(0L));
      this.a.a.put("count_request_fail_in_24hours", Long.valueOf(0L));
      this.a.commit();
    }
    if (paramInt >= 300)
    {
      if (this.b)
      {
        this.a.setDownloadInterruptCode(-107);
        AppMethodBeat.o(139252);
        return;
      }
      this.a.setDownloadInterruptCode(-207);
    }
    AppMethodBeat.o(139252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.al
 * JD-Core Version:    0.7.0.1
 */