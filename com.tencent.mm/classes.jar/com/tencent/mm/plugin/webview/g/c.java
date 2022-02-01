package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class c
{
  public int CtN;
  public boolean CtO;
  public String CtP;
  public long endTime;
  public int nGQ;
  public int nuJ = 10000;
  public long size;
  public long startTime;
  
  public final void report()
  {
    int i = 0;
    AppMethodBeat.i(103134);
    long l = this.endTime - this.startTime;
    String str;
    if (ax.isWifi(ai.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ac.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.CtN), Boolean.valueOf(this.CtO), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.nGQ), this.CtP });
      h localh = h.wUl;
      int j = this.CtN;
      if (this.CtO) {
        i = 1;
      }
      localh.f(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.nGQ), this.CtP, Integer.valueOf(this.nuJ) });
      AppMethodBeat.o(103134);
      return;
      if (ax.is4G(ai.getContext())) {
        str = "4g";
      } else if (ax.is3G(ai.getContext())) {
        str = "3g";
      } else if (ax.is2G(ai.getContext())) {
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