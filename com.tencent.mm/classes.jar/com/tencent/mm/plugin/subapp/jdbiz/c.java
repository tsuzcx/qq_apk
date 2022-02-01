package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.Map;

public final class c
{
  public boolean SEA = false;
  public boolean SEB = false;
  public String SEC = "";
  public String SED = "";
  public long SEE;
  public long SEF;
  public long SEG;
  public long SEH;
  public String SEI = "";
  public String SEJ = "";
  public String SEK = "";
  public String SEL = "";
  public String SEM = "";
  public String SEN = "";
  public int SEO = 0;
  public String SEz = "";
  public String hWn = "";
  public String iconUrl = "";
  public String jumpUrl = "";
  public long ofU = 0L;
  public String rBJ = "";
  public long startTime;
  public String title = "";
  
  private void bd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.SEz = Util.nullAs((String)paramMap.get(".sysmsg.biztype"), "");
    this.SEI = Util.nullAs((String)paramMap.get(".sysmsg.alert"), "");
    this.rBJ = Util.nullAs((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = Util.safeParseLong((String)paramMap.get(".sysmsg.starttime"));
    this.ofU = Util.safeParseLong((String)paramMap.get(".sysmsg.expiretime"));
    this.title = Util.nullAs((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.SEM = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.SEN = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.SEO = Util.safeParseInt((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.SEE = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.SEF = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.SEC = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.SED = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.SEG = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.SEH = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.SEA = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.SEB = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.SEJ = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.SEK = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.SEL = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c hAF()
  {
    AppMethodBeat.i(28869);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().d(327942, "");
    c localc = new c();
    Log.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.feed(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.SEz = "";
    this.rBJ = "";
    this.ofU = 0L;
    this.SEC = "";
    this.SEA = false;
    this.SEB = false;
    this.SEJ = "";
    this.SEK = "";
    this.SEL = "";
    this.SEI = "";
    this.jumpUrl = "";
    this.hWn = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!Util.nullAs(this.rBJ, "").equals(Util.nullAs(paramc.rBJ, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String bbZ()
  {
    AppMethodBeat.i(28877);
    String str = Util.nullAs(this.hWn, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final boolean dgl()
  {
    AppMethodBeat.i(28873);
    if ((this.ofU != 0L) && (this.ofU < System.currentTimeMillis() / 1000L))
    {
      AppMethodBeat.o(28873);
      return true;
    }
    AppMethodBeat.o(28873);
    return false;
  }
  
  public final void feed(String paramString)
  {
    AppMethodBeat.i(28870);
    init();
    this.hWn = paramString;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    Log.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    bd(XmlParser.parseXml(paramString, "sysmsg", null));
    AppMethodBeat.o(28870);
  }
  
  public final boolean hAG()
  {
    AppMethodBeat.i(28874);
    if (this.SEE < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean hAH()
  {
    AppMethodBeat.i(28875);
    if ((this.SEF != 0L) && (this.SEF < System.currentTimeMillis() / 1000L))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */