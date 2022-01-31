package com.tencent.mm.plugin.webview.preload;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public long endTime;
  public int iks = 0;
  public int rjx = 0;
  public int rjy = 0;
  public int rjz = 0;
  public int scene;
  public long startTime;
  
  public final void Ck(int paramInt)
  {
    this.rjz += paramInt;
  }
  
  public final void ccU()
  {
    this.rjx += 1;
  }
  
  public final void ccV()
  {
    this.rjy += 1;
  }
  
  public final void wn()
  {
    long l = this.endTime - this.startTime;
    String str;
    if (aq.isWifi(ae.getContext())) {
      str = "wifi";
    }
    for (;;)
    {
      y.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.iks), Integer.valueOf(this.rjx), Integer.valueOf(this.rjy), Long.valueOf(l), Integer.valueOf(this.rjz), str });
      h.nFQ.f(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.iks), Integer.valueOf(this.rjx), Integer.valueOf(this.rjy), Long.valueOf(l), Integer.valueOf(this.rjz), str });
      return;
      if (aq.is4G(ae.getContext())) {
        str = "4g";
      } else if (aq.is3G(ae.getContext())) {
        str = "3g";
      } else if (aq.is2G(ae.getContext())) {
        str = "2g";
      } else {
        str = "none";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.e
 * JD-Core Version:    0.7.0.1
 */