package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
{
  public int BbE = 0;
  public int BbF = 0;
  public int BbG = 0;
  public long endTime;
  public int fLq = 0;
  public int scene;
  public long startTime;
  
  public final void SX(int paramInt)
  {
    this.BbG += paramInt;
  }
  
  public final void emU()
  {
    this.BbE += 1;
  }
  
  public final void emV()
  {
    this.BbF += 1;
  }
  
  public final void report()
  {
    AppMethodBeat.i(103135);
    long l = this.endTime - this.startTime;
    String str;
    if (ay.isWifi(aj.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ad.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.fLq), Integer.valueOf(this.BbE), Integer.valueOf(this.BbF), Long.valueOf(l), Integer.valueOf(this.BbG), str });
      h.vKh.f(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.fLq), Integer.valueOf(this.BbE), Integer.valueOf(this.BbF), Long.valueOf(l), Integer.valueOf(this.BbG), str });
      AppMethodBeat.o(103135);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.g.d
 * JD-Core Version:    0.7.0.1
 */