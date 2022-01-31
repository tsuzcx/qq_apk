package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class b
  implements f.a
{
  public String bVV = "";
  public long eCv = 0L;
  public String iconUrl = "";
  public String jumpUrl = "";
  public String puZ = "";
  public String pva = "";
  public boolean pvb = false;
  public boolean pvc = false;
  public String pvd = "";
  public String pve = "";
  public long pvf;
  public long pvg;
  public long pvh;
  public long pvi;
  public String pvj = "";
  public String pvk = "";
  public String pvl = "";
  public String pvm = "";
  public long startTime;
  public String title = "";
  
  public static b bLC()
  {
    au.Hx();
    String str = (String)c.Dz().get(327942, "");
    b localb = new b();
    y.i("MicroMsg.JdMsgContent", " create xml : " + str);
    localb.Om(str);
    return localb;
  }
  
  public final void Om(String paramString)
  {
    this.puZ = "";
    this.pva = "";
    this.eCv = 0L;
    this.pvd = "";
    this.pvb = false;
    this.pvc = false;
    this.pvk = "";
    this.pvl = "";
    this.pvm = "";
    this.pvj = "";
    this.jumpUrl = "";
    this.bVV = "";
    this.bVV = paramString;
    if (bk.bl(paramString)) {}
    do
    {
      return;
      y.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[] { paramString });
      paramString = bn.s(paramString, "sysmsg");
    } while (paramString == null);
    this.puZ = bk.aM((String)paramString.get(".sysmsg.biztype"), "");
    this.pvj = bk.aM((String)paramString.get(".sysmsg.alert"), "");
    this.pva = bk.aM((String)paramString.get(".sysmsg.activityid"), "");
    this.startTime = bk.ZS((String)paramString.get(".sysmsg.starttime"));
    this.eCv = bk.ZS((String)paramString.get(".sysmsg.expiretime"));
    this.title = bk.aM((String)paramString.get(".sysmsg.content.title"), "");
    this.iconUrl = bk.aM((String)paramString.get(".sysmsg.content.icon"), "");
    this.jumpUrl = bk.aM((String)paramString.get(".sysmsg.content.jumpurl"), "");
    this.pvf = bk.ZS((String)paramString.get(".sysmsg.content.urlstarttime"));
    this.pvg = bk.ZS((String)paramString.get(".sysmsg.content.urlexpiretime"));
    this.pvd = bk.aM((String)paramString.get(".sysmsg.content.jdcelltitle"), "");
    this.pve = bk.aM((String)paramString.get(".sysmsg.content.jdcellicon"), "");
    this.pvh = bk.ZS((String)paramString.get(".sysmsg.content.titlestarttime"));
    this.pvi = bk.ZS((String)paramString.get(".sysmsg.content.titleexpiretime"));
    this.pvb = "1".equals(paramString.get(".sysmsg.content.findshowreddot"));
    this.pvc = "1".equals(paramString.get(".sysmsg.content.jdcellshowred"));
    this.pvk = bk.aM((String)paramString.get(".sysmsg.content.alertviewtitle"), "");
    this.pvl = bk.aM((String)paramString.get(".sysmsg.content.alertviewconfirm"), "");
    this.pvm = bk.aM((String)paramString.get(".sysmsg.content.alertviewcancel"), "");
  }
  
  public final boolean a(b paramb)
  {
    if (paramb == null) {}
    while (!bk.aM(this.pva, "").equals(bk.aM(paramb.pva, ""))) {
      return true;
    }
    return false;
  }
  
  public final boolean aiS()
  {
    return this.startTime < System.currentTimeMillis() / 1000L;
  }
  
  public final boolean bLD()
  {
    return (this.eCv != 0L) && (this.eCv < System.currentTimeMillis() / 1000L);
  }
  
  public final String bLE()
  {
    return bk.aM(this.bVV, "");
  }
  
  public final String bLF()
  {
    return this.pva;
  }
  
  public final String bLG()
  {
    return this.pvd;
  }
  
  public final boolean bLH()
  {
    return this.pvc;
  }
  
  public final String bLI()
  {
    return this.puZ;
  }
  
  public final String bLJ()
  {
    return this.jumpUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.b
 * JD-Core Version:    0.7.0.1
 */