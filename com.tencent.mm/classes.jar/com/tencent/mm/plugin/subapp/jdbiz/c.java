package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class c
{
  public String cDI = "";
  public long fSm = 0L;
  public String iconUrl = "";
  public String jumpUrl = "";
  public String sWA = "";
  public String sWB = "";
  public boolean sWC = false;
  public boolean sWD = false;
  public String sWE = "";
  public String sWF = "";
  public long sWG;
  public long sWH;
  public long sWI;
  public long sWJ;
  public String sWK = "";
  public String sWL = "";
  public String sWM = "";
  public String sWN = "";
  public String sWO = "";
  public String sWP = "";
  public int sWQ = 0;
  public long startTime;
  public String title = "";
  
  private void af(Map<String, String> paramMap)
  {
    AppMethodBeat.i(25194);
    if (paramMap == null)
    {
      AppMethodBeat.o(25194);
      return;
    }
    this.sWA = bo.bf((String)paramMap.get(".sysmsg.biztype"), "");
    this.sWK = bo.bf((String)paramMap.get(".sysmsg.alert"), "");
    this.sWB = bo.bf((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = bo.apW((String)paramMap.get(".sysmsg.starttime"));
    this.fSm = bo.apW((String)paramMap.get(".sysmsg.expiretime"));
    this.title = bo.bf((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = bo.bf((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bo.bf((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.sWO = bo.bf((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.sWP = bo.bf((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.sWQ = bo.apV((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.sWG = bo.apW((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.sWH = bo.apW((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.sWE = bo.bf((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.sWF = bo.bf((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.sWI = bo.apW((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.sWJ = bo.apW((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.sWC = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.sWD = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.sWL = bo.bf((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.sWM = bo.bf((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.sWN = bo.bf((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(25194);
  }
  
  public static c cGB()
  {
    AppMethodBeat.i(25192);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(327942, "");
    c localc = new c();
    ab.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.abg(str);
    AppMethodBeat.o(25192);
    return localc;
  }
  
  private void init()
  {
    this.sWA = "";
    this.sWB = "";
    this.fSm = 0L;
    this.sWE = "";
    this.sWC = false;
    this.sWD = false;
    this.sWL = "";
    this.sWM = "";
    this.sWN = "";
    this.sWK = "";
    this.jumpUrl = "";
    this.cDI = "";
  }
  
  public final String SU()
  {
    AppMethodBeat.i(25200);
    String str = bo.bf(this.cDI, "");
    AppMethodBeat.o(25200);
    return str;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(25199);
    if (paramc == null)
    {
      AppMethodBeat.o(25199);
      return true;
    }
    if (!bo.bf(this.sWB, "").equals(bo.bf(paramc.sWB, "")))
    {
      AppMethodBeat.o(25199);
      return true;
    }
    AppMethodBeat.o(25199);
    return false;
  }
  
  public final void abg(String paramString)
  {
    AppMethodBeat.i(25193);
    init();
    this.cDI = paramString;
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25193);
      return;
    }
    ab.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    af(br.F(paramString, "sysmsg"));
    AppMethodBeat.o(25193);
  }
  
  public final boolean bzK()
  {
    AppMethodBeat.i(25196);
    if ((this.fSm != 0L) && (this.fSm < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(25196);
      return true;
    }
    AppMethodBeat.o(25196);
    return false;
  }
  
  public final boolean cGC()
  {
    AppMethodBeat.i(153651);
    if (this.sWG < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(153651);
      return true;
    }
    AppMethodBeat.o(153651);
    return false;
  }
  
  public final boolean cGD()
  {
    AppMethodBeat.i(153652);
    if ((this.sWH != 0L) && (this.sWH < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(153652);
      return true;
    }
    AppMethodBeat.o(153652);
    return false;
  }
  
  public final boolean isStart()
  {
    AppMethodBeat.i(25195);
    if (this.startTime < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(25195);
      return true;
    }
    AppMethodBeat.o(25195);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */