package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import java.util.Map;

public final class c
{
  public String Bhc = "";
  public String Bhd = "";
  public boolean Bhe = false;
  public boolean Bhf = false;
  public String Bhg = "";
  public String Bhh = "";
  public long Bhi;
  public long Bhj;
  public long Bhk;
  public long Bhl;
  public String Bhm = "";
  public String Bhn = "";
  public String Bho = "";
  public String Bhp = "";
  public String Bhq = "";
  public String Bhr = "";
  public int Bhs = 0;
  public String dDP = "";
  public String iconUrl = "";
  public long ioS = 0L;
  public String jumpUrl = "";
  public long startTime;
  public String title = "";
  
  private void aO(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.Bhc = bt.bI((String)paramMap.get(".sysmsg.biztype"), "");
    this.Bhm = bt.bI((String)paramMap.get(".sysmsg.alert"), "");
    this.Bhd = bt.bI((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = bt.aRf((String)paramMap.get(".sysmsg.starttime"));
    this.ioS = bt.aRf((String)paramMap.get(".sysmsg.expiretime"));
    this.title = bt.bI((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = bt.bI((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bt.bI((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.Bhq = bt.bI((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.Bhr = bt.bI((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.Bhs = bt.aRe((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.Bhi = bt.aRf((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.Bhj = bt.aRf((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.Bhg = bt.bI((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.Bhh = bt.bI((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.Bhk = bt.aRf((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.Bhl = bt.aRf((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.Bhe = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.Bhf = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.Bhn = bt.bI((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.Bho = bt.bI((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.Bhp = bt.bI((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c emF()
  {
    AppMethodBeat.i(28869);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(327942, "");
    c localc = new c();
    ad.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.azH(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.Bhc = "";
    this.Bhd = "";
    this.ioS = 0L;
    this.Bhg = "";
    this.Bhe = false;
    this.Bhf = false;
    this.Bhn = "";
    this.Bho = "";
    this.Bhp = "";
    this.Bhm = "";
    this.jumpUrl = "";
    this.dDP = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!bt.bI(this.Bhd, "").equals(bt.bI(paramc.Bhd, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String akR()
  {
    AppMethodBeat.i(28877);
    String str = bt.bI(this.dDP, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final void azH(String paramString)
  {
    AppMethodBeat.i(28870);
    init();
    this.dDP = paramString;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    ad.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aO(bw.M(paramString, "sysmsg"));
    AppMethodBeat.o(28870);
  }
  
  public final boolean cQB()
  {
    AppMethodBeat.i(28873);
    if ((this.ioS != 0L) && (this.ioS < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28873);
      return true;
    }
    AppMethodBeat.o(28873);
    return false;
  }
  
  public final boolean emG()
  {
    AppMethodBeat.i(28874);
    if (this.Bhi < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean emH()
  {
    AppMethodBeat.i(28875);
    if ((this.Bhj != 0L) && (this.Bhj < System.currentTimeMillis() / 1000L))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */