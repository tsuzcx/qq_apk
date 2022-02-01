package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class c
{
  public int DXu;
  public boolean DXv;
  public String DXw;
  public long endTime;
  public int nWh = 10000;
  public int ojt;
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
      ad.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.DXu), Boolean.valueOf(this.DXv), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.ojt), this.DXw });
      g localg = g.yhR;
      int j = this.DXu;
      if (this.DXv) {
        i = 1;
      }
      localg.f(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.ojt), this.DXw, Integer.valueOf(this.nWh) });
      AppMethodBeat.o(103134);
      return;
      if (ay.is5G(aj.getContext())) {
        str = "5g";
      } else if (ay.is4G(aj.getContext())) {
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