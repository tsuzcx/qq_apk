package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class d
{
  public int CtQ = 0;
  public int CtR = 0;
  public int CtS = 0;
  public long endTime;
  public int fPc = 0;
  public int scene;
  public long startTime;
  
  public final void Vf(int paramInt)
  {
    this.CtS += paramInt;
  }
  
  public final void eCp()
  {
    this.CtQ += 1;
  }
  
  public final void eCq()
  {
    this.CtR += 1;
  }
  
  public final void report()
  {
    AppMethodBeat.i(103135);
    long l = this.endTime - this.startTime;
    String str;
    if (ax.isWifi(ai.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      ac.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.fPc), Integer.valueOf(this.CtQ), Integer.valueOf(this.CtR), Long.valueOf(l), Integer.valueOf(this.CtS), str });
      h.wUl.f(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.fPc), Integer.valueOf(this.CtQ), Integer.valueOf(this.CtR), Long.valueOf(l), Integer.valueOf(this.CtS), str });
      AppMethodBeat.o(103135);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.g.d
 * JD-Core Version:    0.7.0.1
 */