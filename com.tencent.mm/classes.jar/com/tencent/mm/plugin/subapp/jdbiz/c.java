package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class c
{
  public String duk = "";
  public long huV = 0L;
  public String iconUrl = "";
  public String jumpUrl = "";
  public long startTime;
  public String title = "";
  public String yCA = "";
  public String yCB = "";
  public String yCC = "";
  public int yCD = 0;
  public String yCn = "";
  public String yCo = "";
  public boolean yCp = false;
  public boolean yCq = false;
  public String yCr = "";
  public String yCs = "";
  public long yCt;
  public long yCu;
  public long yCv;
  public long yCw;
  public String yCx = "";
  public String yCy = "";
  public String yCz = "";
  
  private void aH(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.yCn = bt.by((String)paramMap.get(".sysmsg.biztype"), "");
    this.yCx = bt.by((String)paramMap.get(".sysmsg.alert"), "");
    this.yCo = bt.by((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = bt.aGi((String)paramMap.get(".sysmsg.starttime"));
    this.huV = bt.aGi((String)paramMap.get(".sysmsg.expiretime"));
    this.title = bt.by((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = bt.by((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bt.by((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.yCB = bt.by((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.yCC = bt.by((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.yCD = bt.aGh((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.yCt = bt.aGi((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.yCu = bt.aGi((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.yCr = bt.by((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.yCs = bt.by((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.yCv = bt.aGi((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.yCw = bt.aGi((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.yCp = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.yCq = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.yCy = bt.by((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.yCz = bt.by((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.yCA = bt.by((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c dLQ()
  {
    AppMethodBeat.i(28869);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(327942, "");
    c localc = new c();
    ad.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.apq(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.yCn = "";
    this.yCo = "";
    this.huV = 0L;
    this.yCr = "";
    this.yCp = false;
    this.yCq = false;
    this.yCy = "";
    this.yCz = "";
    this.yCA = "";
    this.yCx = "";
    this.jumpUrl = "";
    this.duk = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!bt.by(this.yCo, "").equals(bt.by(paramc.yCo, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String agO()
  {
    AppMethodBeat.i(28877);
    String str = bt.by(this.duk, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final void apq(String paramString)
  {
    AppMethodBeat.i(28870);
    init();
    this.duk = paramString;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    ad.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aH(bw.K(paramString, "sysmsg"));
    AppMethodBeat.o(28870);
  }
  
  public final boolean cva()
  {
    AppMethodBeat.i(28873);
    if ((this.huV != 0L) && (this.huV < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28873);
      return true;
    }
    AppMethodBeat.o(28873);
    return false;
  }
  
  public final boolean dLR()
  {
    AppMethodBeat.i(28874);
    if (this.yCt < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean dLS()
  {
    AppMethodBeat.i(28875);
    if ((this.yCu != 0L) && (this.yCu < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28875);
      return true;
    }
    AppMethodBeat.o(28875);
    return false;
  }
  
  public final boolean isStart()
  {
    AppMethodBeat.i(28872);
    if (this.startTime < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28872);
      return true;
    }
    AppMethodBeat.o(28872);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */