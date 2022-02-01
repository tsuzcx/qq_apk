package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
{
  public int WQd = 0;
  public int WQe = 0;
  public int WQf = 0;
  public long endTime;
  public int scene;
  public long startTime;
  public int wrD = 0;
  
  private static String getNetWorkType()
  {
    AppMethodBeat.i(294655);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(294655);
      return "wifi";
    }
    if (NetStatusUtil.is5G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(294655);
      return "5g";
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(294655);
      return "4g";
    }
    if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(294655);
      return "3g";
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(294655);
      return "2g";
    }
    AppMethodBeat.o(294655);
    return "none";
  }
  
  public final void atQ(int paramInt)
  {
    this.WQf += paramInt;
  }
  
  public final void iwB()
  {
    this.WQd += 1;
  }
  
  public final void iwC()
  {
    this.WQe += 1;
  }
  
  public final void report()
  {
    AppMethodBeat.i(103135);
    long l = this.endTime - this.startTime;
    String str = getNetWorkType();
    Log.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.wrD), Integer.valueOf(this.WQd), Integer.valueOf(this.WQe), Long.valueOf(l), Integer.valueOf(this.WQf), str });
    h.OAn.b(15871, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.wrD), Integer.valueOf(this.WQd), Integer.valueOf(this.WQe), Long.valueOf(l), Integer.valueOf(this.WQf), str });
    AppMethodBeat.o(103135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.d
 * JD-Core Version:    0.7.0.1
 */