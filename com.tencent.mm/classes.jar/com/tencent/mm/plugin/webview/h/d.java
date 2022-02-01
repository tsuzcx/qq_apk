package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
{
  public int PZp = 0;
  public int PZq = 0;
  public int PZr = 0;
  public long endTime;
  public int jGL = 0;
  public int scene;
  public long startTime;
  
  public final void anY(int paramInt)
  {
    this.PZr += paramInt;
  }
  
  public final void gWL()
  {
    this.PZp += 1;
  }
  
  public final void gWM()
  {
    this.PZq += 1;
  }
  
  public final void report()
  {
    AppMethodBeat.i(103135);
    long l = this.endTime - this.startTime;
    String str;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      Log.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.jGL), Integer.valueOf(this.PZp), Integer.valueOf(this.PZq), Long.valueOf(l), Integer.valueOf(this.PZr), str });
      h.IzE.a(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.jGL), Integer.valueOf(this.PZp), Integer.valueOf(this.PZq), Long.valueOf(l), Integer.valueOf(this.PZr), str });
      AppMethodBeat.o(103135);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.h.d
 * JD-Core Version:    0.7.0.1
 */