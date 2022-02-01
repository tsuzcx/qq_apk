package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class c
{
  public String Mdj = "";
  public boolean Mdk = false;
  public boolean Mdl = false;
  public String Mdm = "";
  public String Mdn = "";
  public long Mdo;
  public long Mdp;
  public long Mdq;
  public long Mdr;
  public String Mds = "";
  public String Mdt = "";
  public String Mdu = "";
  public String Mdv = "";
  public String Mdw = "";
  public String Mdx = "";
  public int Mdy = 0;
  public String fQs = "";
  public String iconUrl = "";
  public String jumpUrl = "";
  public long mcX = 0L;
  public String oym = "";
  public long startTime;
  public String title = "";
  
  private void aM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(28871);
    if (paramMap == null)
    {
      AppMethodBeat.o(28871);
      return;
    }
    this.Mdj = Util.nullAs((String)paramMap.get(".sysmsg.biztype"), "");
    this.Mds = Util.nullAs((String)paramMap.get(".sysmsg.alert"), "");
    this.oym = Util.nullAs((String)paramMap.get(".sysmsg.activityid"), "");
    this.startTime = Util.safeParseLong((String)paramMap.get(".sysmsg.starttime"));
    this.mcX = Util.safeParseLong((String)paramMap.get(".sysmsg.expiretime"));
    this.title = Util.nullAs((String)paramMap.get(".sysmsg.content.title"), "");
    this.iconUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.icon"), "");
    this.jumpUrl = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpurl"), "");
    this.Mdw = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.username"), "");
    this.Mdx = Util.nullAs((String)paramMap.get(".sysmsg.content.jumpweapp.path"), "");
    this.Mdy = Util.safeParseInt((String)paramMap.get(".sysmsg.content.jumpweapp.version"));
    this.Mdo = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlstarttime"));
    this.Mdp = Util.safeParseLong((String)paramMap.get(".sysmsg.content.urlexpiretime"));
    this.Mdm = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcelltitle"), "");
    this.Mdn = Util.nullAs((String)paramMap.get(".sysmsg.content.jdcellicon"), "");
    this.Mdq = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titlestarttime"));
    this.Mdr = Util.safeParseLong((String)paramMap.get(".sysmsg.content.titleexpiretime"));
    this.Mdk = "1".equals(paramMap.get(".sysmsg.content.findshowreddot"));
    this.Mdl = "1".equals(paramMap.get(".sysmsg.content.jdcellshowred"));
    this.Mdt = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewtitle"), "");
    this.Mdu = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewconfirm"), "");
    this.Mdv = Util.nullAs((String)paramMap.get(".sysmsg.content.alertviewcancel"), "");
    AppMethodBeat.o(28871);
  }
  
  public static c ghm()
  {
    AppMethodBeat.i(28869);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().b(327942, "");
    c localc = new c();
    Log.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
    localc.feed(str);
    AppMethodBeat.o(28869);
    return localc;
  }
  
  private void init()
  {
    this.Mdj = "";
    this.oym = "";
    this.mcX = 0L;
    this.Mdm = "";
    this.Mdk = false;
    this.Mdl = false;
    this.Mdt = "";
    this.Mdu = "";
    this.Mdv = "";
    this.Mds = "";
    this.jumpUrl = "";
    this.fQs = "";
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(28876);
    if (paramc == null)
    {
      AppMethodBeat.o(28876);
      return true;
    }
    if (!Util.nullAs(this.oym, "").equals(Util.nullAs(paramc.oym, "")))
    {
      AppMethodBeat.o(28876);
      return true;
    }
    AppMethodBeat.o(28876);
    return false;
  }
  
  public final String aJc()
  {
    AppMethodBeat.i(28877);
    String str = Util.nullAs(this.fQs, "");
    AppMethodBeat.o(28877);
    return str;
  }
  
  public final boolean eqj()
  {
    AppMethodBeat.i(28873);
    if ((this.mcX != 0L) && (this.mcX < System.currentTimeMillis() / 1000L))
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
    this.fQs = paramString;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28870);
      return;
    }
    Log.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
    aM(XmlParser.parseXml(paramString, "sysmsg", null));
    AppMethodBeat.o(28870);
  }
  
  public final boolean ghn()
  {
    AppMethodBeat.i(28874);
    if (this.Mdo < System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(28874);
      return true;
    }
    AppMethodBeat.o(28874);
    return false;
  }
  
  public final boolean gho()
  {
    AppMethodBeat.i(28875);
    if ((this.Mdp != 0L) && (this.Mdp < System.currentTimeMillis() / 1000L))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */