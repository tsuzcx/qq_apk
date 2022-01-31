package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class b
{
  public long endTime;
  public int kbM;
  public int kbq = 10000;
  public long size;
  public long startTime;
  public int uYB;
  public boolean uYC;
  public String uYD;
  
  public final void IE()
  {
    int i = 0;
    AppMethodBeat.i(139649);
    long l = this.endTime - this.startTime;
    String str;
    if (at.isWifi(ah.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ab.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.uYB), Boolean.valueOf(this.uYC), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.kbM), this.uYD });
      h localh = h.qsU;
      int j = this.uYB;
      if (this.uYC) {
        i = 1;
      }
      localh.e(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.kbM), this.uYD, Integer.valueOf(this.kbq) });
      AppMethodBeat.o(139649);
      return;
      if (at.is4G(ah.getContext())) {
        str = "4g";
      } else if (at.is3G(ah.getContext())) {
        str = "3g";
      } else if (at.is2G(ah.getContext())) {
        str = "2g";
      } else {
        str = "none";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.b
 * JD-Core Version:    0.7.0.1
 */