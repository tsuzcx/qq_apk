package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public final class d
{
  public int EpA = 0;
  public int EpB = 0;
  public int Epz = 0;
  public long endTime;
  public int gkU = 0;
  public int scene;
  public long startTime;
  
  public final void XB(int paramInt)
  {
    this.EpB += paramInt;
  }
  
  public final void eUV()
  {
    this.Epz += 1;
  }
  
  public final void eUW()
  {
    this.EpA += 1;
  }
  
  public final void report()
  {
    AppMethodBeat.i(103135);
    long l = this.endTime - this.startTime;
    String str;
    if (az.isWifi(ak.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ae.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.gkU), Integer.valueOf(this.Epz), Integer.valueOf(this.EpA), Long.valueOf(l), Integer.valueOf(this.EpB), str });
      g.yxI.f(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.gkU), Integer.valueOf(this.Epz), Integer.valueOf(this.EpA), Long.valueOf(l), Integer.valueOf(this.EpB), str });
      AppMethodBeat.o(103135);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.g.d
 * JD-Core Version:    0.7.0.1
 */