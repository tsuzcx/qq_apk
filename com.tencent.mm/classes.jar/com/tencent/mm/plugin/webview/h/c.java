package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class c
{
  public int PZm;
  public boolean PZn;
  public String PZo;
  public long endTime;
  public int sNh;
  public long size;
  public long startTime;
  public int svv = 10000;
  
  public final void report()
  {
    int i = 0;
    AppMethodBeat.i(103134);
    long l = this.endTime - this.startTime;
    String str;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      Log.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", new Object[] { Integer.valueOf(this.PZm), Boolean.valueOf(this.PZn), Long.valueOf(l), Long.valueOf(this.size), str, Integer.valueOf(this.sNh), this.PZo });
      h localh = h.IzE;
      int j = this.PZm;
      if (this.PZn) {
        i = 1;
      }
      localh.a(15870, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Math.min(l, 3600000L)), Long.valueOf(this.size), str, Integer.valueOf(this.sNh), this.PZo, Integer.valueOf(this.svv) });
      AppMethodBeat.o(103134);
      return;
      if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
        str = "5g";
      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        str = "4g";
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        str = "3g";
      } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        str = "2g";
      } else {
        str = "none";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.c
 * JD-Core Version:    0.7.0.1
 */