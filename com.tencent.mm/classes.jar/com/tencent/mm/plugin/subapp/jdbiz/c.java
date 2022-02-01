package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.util.Map;

public final class c
{
  public String ByA = "";
  public String ByB = "";
  public boolean ByC = false;
  public boolean ByD = false;
  public String ByE = "";
  public String ByF = "";
  public long ByG;
  public long ByH;
  public long ByI;
  public long ByJ;
  public String ByK = "";
  public String ByL = "";
  public String ByM = "";
  public String ByN = "";
  public String ByO = "";
  public String ByP = "";
  public int ByQ = 0;
  public String dEU = "";
  public String iconUrl = "";
  public long irN = 0L;
  public String jumpUrl = "";
  public long startTime;
  public String title = "";
  
  private void aU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.ByA = bu.bI((String)paramMap.get(".sysmsg.biztype"), "");
    this.ByK = bu.bI((String)paramMap.get(".sysmsg.alert"), "");
    this.ByB = bu.bI((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = bu.aSC((String)paramMap.get(".sysmsg.starttime"));
    this.irN = bu.aSC((String)paramMap.get(".sysmsg.expiretime"));
    this.title = bu.bI((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = bu.bI((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bu.bI((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.ByO = bu.bI((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.ByP = bu.bI((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.ByQ = bu.aSB((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.ByG = bu.aSC((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.ByH = bu.aSC((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.ByE = bu.bI((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.ByF = bu.bI((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.ByI = bu.aSC((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.ByJ = bu.aSC((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.ByC = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.ByD = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.ByL = bu.bI((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.ByM = bu.bI((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.ByN = bu.bI((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c eqo()
  {
    AppMethodBeat.i(28869);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(327942, "");
    c localc = new c();
    ae.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.aAY(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.ByA = "";
    this.ByB = "";
    this.irN = 0L;
    this.ByE = "";
    this.ByC = false;
    this.ByD = false;
    this.ByL = "";
    this.ByM = "";
    this.ByN = "";
    this.ByK = "";
    this.jumpUrl = "";
    this.dEU = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!bu.bI(this.ByB, "").equals(bu.bI(paramc.ByB, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final void aAY(String paramString)
  {
    AppMethodBeat.i(28870);
    init();
    this.dEU = paramString;
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    ae.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aU(bx.M(paramString, "sysmsg"));
    AppMethodBeat.o(28870);
  }
  
  public final String alg()
  {
    AppMethodBeat.i(28877);
    String str = bu.bI(this.dEU, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final boolean cTg()
  {
    AppMethodBeat.i(28873);
    if ((this.irN != 0L) && (this.irN < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28873);
      return true;
    }
    AppMethodBeat.o(28873);
    return false;
  }
  
  public final boolean eqp()
  {
    AppMethodBeat.i(28874);
    if (this.ByG < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean eqq()
  {
    AppMethodBeat.i(28875);
    if ((this.ByH != 0L) && (this.ByH < System.currentTimeMillis() / 1000L))
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