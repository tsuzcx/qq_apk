package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class c
{
  public int BbB;
  public boolean BbC;
  public String BbD;
  public long endTime;
  public int mSu = 10000;
  public int nee;
  public long size;
  public long startTime;
  
  public final void report()
  {
    int i = 0;
    AppMethodBeat.i(103134);
    long l = this.endTime - this.startTime;
    String str;
    if (ay.isWifi(aj.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ad.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.BbB), Boolean.valueOf(this.BbC), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.nee), this.BbD });
      h localh = h.vKh;
      int j = this.BbB;
      if (this.BbC) {
        i = 1;
      }
      localh.f(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.nee), this.BbD, Integer.valueOf(this.mSu) });
      AppMethodBeat.o(103134);
      return;
      if (ay.is4G(aj.getContext())) {
        str = "4g";
      } else if (ay.is3G(aj.getContext())) {
        str = "3g";
      } else if (ay.is2G(aj.getContext())) {
        str = "2g";
      } else {
        str = "none";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.c
 * JD-Core Version:    0.7.0.1
 */