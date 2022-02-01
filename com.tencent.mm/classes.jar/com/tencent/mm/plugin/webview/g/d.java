package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
{
  public int DXx = 0;
  public int DXy = 0;
  public int DXz = 0;
  public long endTime;
  public int giC = 0;
  public int scene;
  public long startTime;
  
  public final void WV(int paramInt)
  {
    this.DXz += paramInt;
  }
  
  public final void eRj()
  {
    this.DXx += 1;
  }
  
  public final void eRk()
  {
    this.DXy += 1;
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
      ad.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.giC), Integer.valueOf(this.DXx), Integer.valueOf(this.DXy), Long.valueOf(l), Integer.valueOf(this.DXz), str });
      g.yhR.f(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.giC), Integer.valueOf(this.DXx), Integer.valueOf(this.DXy), Long.valueOf(l), Integer.valueOf(this.DXz), str });
      AppMethodBeat.o(103135);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.g.d
 * JD-Core Version:    0.7.0.1
 */