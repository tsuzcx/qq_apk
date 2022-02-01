package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public final class c
{
  public int Epw;
  public boolean Epx;
  public String Epy;
  public long endTime;
  public int obQ = 10000;
  public int opt;
  public long size;
  public long startTime;
  
  public final void report()
  {
    int i = 0;
    AppMethodBeat.i(103134);
    long l = this.endTime - this.startTime;
    String str;
    if (az.isWifi(ak.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ae.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.Epw), Boolean.valueOf(this.Epx), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.opt), this.Epy });
      g localg = g.yxI;
      int j = this.Epw;
      if (this.Epx) {
        i = 1;
      }
      localg.f(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.opt), this.Epy, Integer.valueOf(this.obQ) });
      AppMethodBeat.o(103134);
      return;
      if (az.is5G(ak.getContext())) {
        str = "5g";
      } else if (az.is4G(ak.getContext())) {
        str = "4g";
      } else if (az.is3G(ak.getContext())) {
        str = "3g";
      } else if (az.is2G(ak.getContext())) {
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