package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class c
{
  public long endTime;
  public int evn = 0;
  public int scene;
  public long startTime;
  public int uYE = 0;
  public int uYF = 0;
  public int uYG = 0;
  
  public final void IE()
  {
    AppMethodBeat.i(80444);
    long l = this.endTime - this.startTime;
    String str;
    if (at.isWifi(ah.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ab.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.evn), Integer.valueOf(this.uYE), Integer.valueOf(this.uYF), Long.valueOf(l), Integer.valueOf(this.uYG), str });
      h.qsU.e(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.evn), Integer.valueOf(this.uYE), Integer.valueOf(this.uYF), Long.valueOf(l), Integer.valueOf(this.uYG), str });
      AppMethodBeat.o(80444);
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
  
  public final void Ka(int paramInt)
  {
    this.uYG += paramInt;
  }
  
  public final void dcP()
  {
    this.uYE += 1;
  }
  
  public final void dcQ()
  {
    this.uYF += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.c
 * JD-Core Version:    0.7.0.1
 */