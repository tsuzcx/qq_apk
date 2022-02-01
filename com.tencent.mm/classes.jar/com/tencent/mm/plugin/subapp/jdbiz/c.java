package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class c
{
  public String FJA = "";
  public int FJB = 0;
  public String FJl = "";
  public String FJm = "";
  public boolean FJn = false;
  public boolean FJo = false;
  public String FJp = "";
  public String FJq = "";
  public long FJr;
  public long FJs;
  public long FJt;
  public long FJu;
  public String FJv = "";
  public String FJw = "";
  public String FJx = "";
  public String FJy = "";
  public String FJz = "";
  public String dWG = "";
  public String iconUrl = "";
  public long jmW = 0L;
  public String jumpUrl = "";
  public long startTime;
  public String title = "";
  
  private void aS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.FJl = Util.nullAs((String)paramMap.get(".sysmsg.biztype"), "");
    this.FJv = Util.nullAs((String)paramMap.get(".sysmsg.alert"), "");
    this.FJm = Util.nullAs((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = Util.safeParseLong((String)paramMap.get(".sysmsg.starttime"));
    this.jmW = Util.safeParseLong((String)paramMap.get(".sysmsg.expiretime"));
    this.title = Util.nullAs((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.FJz = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.FJA = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.FJB = Util.safeParseInt((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.FJr = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.FJs = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.FJp = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.FJq = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.FJt = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.FJu = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.FJn = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.FJo = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.FJw = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.FJx = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.FJy = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c fsN()
  {
    AppMethodBeat.i(28869);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(327942, "");
    c localc = new c();
    Log.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.feed(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.FJl = "";
    this.FJm = "";
    this.jmW = 0L;
    this.FJp = "";
    this.FJn = false;
    this.FJo = false;
    this.FJw = "";
    this.FJx = "";
    this.FJy = "";
    this.FJv = "";
    this.jumpUrl = "";
    this.dWG = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!Util.nullAs(this.FJm, "").equals(Util.nullAs(paramc.FJm, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String aBz()
  {
    AppMethodBeat.i(28877);
    String str = Util.nullAs(this.dWG, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final boolean dMp()
  {
    AppMethodBeat.i(28873);
    if ((this.jmW != 0L) && (this.jmW < System.currentTimeMillis() / 1000L))
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
    this.dWG = paramString;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    Log.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aS(XmlParser.parseXml(paramString, "sysmsg", null));
    AppMethodBeat.o(28870);
  }
  
  public final boolean fsO()
  {
    AppMethodBeat.i(28874);
    if (this.FJr < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean fsP()
  {
    AppMethodBeat.i(28875);
    if ((this.FJs != 0L) && (this.FJs < System.currentTimeMillis() / 1000L))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */