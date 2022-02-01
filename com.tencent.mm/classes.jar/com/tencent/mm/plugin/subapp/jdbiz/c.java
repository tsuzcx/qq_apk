package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.util.Map;

public final class c
{
  public String drV = "";
  public long hVx = 0L;
  public String iconUrl = "";
  public String jumpUrl = "";
  public long startTime;
  public String title = "";
  public String zPB = "";
  public String zPC = "";
  public boolean zPD = false;
  public boolean zPE = false;
  public String zPF = "";
  public String zPG = "";
  public long zPH;
  public long zPI;
  public long zPJ;
  public long zPK;
  public String zPL = "";
  public String zPM = "";
  public String zPN = "";
  public String zPO = "";
  public String zPP = "";
  public String zPQ = "";
  public int zPR = 0;
  
  private void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.zPB = bs.bG((String)paramMap.get(".sysmsg.biztype"), "");
    this.zPL = bs.bG((String)paramMap.get(".sysmsg.alert"), "");
    this.zPC = bs.bG((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = bs.aLz((String)paramMap.get(".sysmsg.starttime"));
    this.hVx = bs.aLz((String)paramMap.get(".sysmsg.expiretime"));
    this.title = bs.bG((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = bs.bG((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bs.bG((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.zPP = bs.bG((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.zPQ = bs.bG((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.zPR = bs.aLy((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.zPH = bs.aLz((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.zPI = bs.aLz((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.zPF = bs.bG((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.zPG = bs.bG((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.zPJ = bs.aLz((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.zPK = bs.aLz((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.zPD = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.zPE = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.zPM = bs.bG((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.zPN = bs.bG((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.zPO = bs.bG((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c eaq()
  {
    AppMethodBeat.i(28869);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(327942, "");
    c localc = new c();
    ac.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.auB(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.zPB = "";
    this.zPC = "";
    this.hVx = 0L;
    this.zPF = "";
    this.zPD = false;
    this.zPE = false;
    this.zPM = "";
    this.zPN = "";
    this.zPO = "";
    this.zPL = "";
    this.jumpUrl = "";
    this.drV = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!bs.bG(this.zPC, "").equals(bs.bG(paramc.zPC, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String aif()
  {
    AppMethodBeat.i(28877);
    String str = bs.bG(this.drV, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final void auB(String paramString)
  {
    AppMethodBeat.i(28870);
    init();
    this.drV = paramString;
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    ac.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aL(bv.L(paramString, "sysmsg"));
    AppMethodBeat.o(28870);
  }
  
  public final boolean cIm()
  {
    AppMethodBeat.i(28873);
    if ((this.hVx != 0L) && (this.hVx < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28873);
      return true;
    }
    AppMethodBeat.o(28873);
    return false;
  }
  
  public final boolean ear()
  {
    AppMethodBeat.i(28874);
    if (this.zPH < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean eas()
  {
    AppMethodBeat.i(28875);
    if ((this.zPI != 0L) && (this.zPI < System.currentTimeMillis() / 1000L))
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