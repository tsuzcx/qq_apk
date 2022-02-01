package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
{
  public int JcF = 0;
  public int JcG = 0;
  public int JcH = 0;
  public long endTime;
  public int gVP = 0;
  public int scene;
  public long startTime;
  
  public final void agj(int paramInt)
  {
    this.JcH += paramInt;
  }
  
  public final void gdK()
  {
    this.JcF += 1;
  }
  
  public final void gdL()
  {
    this.JcG += 1;
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
      Log.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.gVP), Integer.valueOf(this.JcF), Integer.valueOf(this.JcG), Long.valueOf(l), Integer.valueOf(this.JcH), str });
      h.CyF.a(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.gVP), Integer.valueOf(this.JcF), Integer.valueOf(this.JcG), Long.valueOf(l), Integer.valueOf(this.JcH), str });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.d
 * JD-Core Version:    0.7.0.1
 */