package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.m.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class c
  implements ar, f.b
{
  private com.tencent.mm.sdk.b.c dii = new c.1(this);
  private a pvn = null;
  private b pvo = null;
  Map<String, Integer> pvp = new HashMap();
  
  public c()
  {
    y.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bk.csb());
  }
  
  public static void b(b paramb)
  {
    com.tencent.mm.kernel.g.DN().CX();
    c localc = bLK();
    if (localc.pvo == null) {
      localc.pvo = b.bLC();
    }
    y.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { localc.pvo.bLE(), paramb.bLE() });
    if (!paramb.a(localc.pvo))
    {
      y.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      return;
    }
    if ((!bk.bl(paramb.pvd)) || (paramb.pvc))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(327939, "1");
    }
    if (paramb.pvb)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(327938, "1");
    }
    for (;;)
    {
      localc.pvo = paramb;
      au.Hx();
      com.tencent.mm.model.c.Dz().o(327942, paramb.bVV);
      localc.bLQ();
      return;
      au.Hx();
      com.tencent.mm.model.c.Dz().o(327938, "");
    }
  }
  
  public static c bLK()
  {
    c localc2 = (c)f.rVL;
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      f.rVL = localc1;
    }
    return localc1;
  }
  
  private void bLQ()
  {
    new ah(Looper.getMainLooper()).post(new c.2(this));
  }
  
  public static boolean bLS()
  {
    String str1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigName");
    String str2 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigIconUrl");
    String str3 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigJumpUrl");
    return (!bk.bl(str1)) && (!bk.bl(str2)) && (!bk.bl(str3));
  }
  
  public static String cz(String paramString, int paramInt)
  {
    String str = paramString;
    if (-1 == paramString.indexOf('#'))
    {
      if (-1 == paramString.indexOf('?')) {
        str = paramString + "?wc_scene=" + paramInt;
      }
    }
    else {
      return str;
    }
    return paramString + "&wc_scene=" + paramInt;
  }
  
  public final boolean bLL()
  {
    au.Hx();
    return "1".equals((String)com.tencent.mm.model.c.Dz().get(327939, ""));
  }
  
  public final boolean bLM()
  {
    au.Hx();
    return "1".equals((String)com.tencent.mm.model.c.Dz().get(327938, ""));
  }
  
  public final void bLN()
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(327938, "");
  }
  
  public final void bLO()
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(327939, "");
  }
  
  public final b bLP()
  {
    if (this.pvo == null) {
      this.pvo = b.bLC();
    }
    return this.pvo;
  }
  
  public final void bLR()
  {
    if ((au.DK()) && ((bLK().bLL()) || (bLK().bLM())))
    {
      b localb = bLK().bLP();
      if (((!bk.bl(localb.pvd)) || (localb.pvc)) && (localb.bLD()))
      {
        y.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
        bLK().bLN();
        bLK().bLO();
        bLK().bLQ();
      }
    }
  }
  
  public final String bLT()
  {
    int m = 1;
    String str1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigJumpUrl");
    if (bk.bl(str1)) {
      return null;
    }
    b localb = bLP();
    int i;
    if (bLL()) {
      if ((!localb.bLD()) && ("3".equals(localb.puZ)) && (!bk.bl(localb.jumpUrl)))
      {
        y.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localb.jumpUrl });
        str1 = localb.jumpUrl;
        i = 6;
      }
    }
    for (;;)
    {
      int j = i;
      String str2 = str1;
      if ("2".equals(localb.puZ))
      {
        j = i;
        str2 = str1;
        if (!bk.bl(localb.jumpUrl))
        {
          if (localb.pvf >= System.currentTimeMillis() / 1000L) {
            break label231;
          }
          k = 1;
          label153:
          j = i;
          str2 = str1;
          if (k != 0) {
            if ((localb.pvg == 0L) || (localb.pvg >= System.currentTimeMillis() / 1000L)) {
              break label236;
            }
          }
        }
      }
      label231:
      label236:
      for (int k = m;; k = 0)
      {
        j = i;
        str2 = str1;
        if (k == 0)
        {
          str2 = localb.jumpUrl;
          j = 3;
        }
        return cz(str2, j);
        if (!localb.pvc) {
          break label241;
        }
        i = 2;
        break;
        k = 0;
        break label153;
      }
      label241:
      i = 1;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.pvn == null) {
      this.pvn = new a();
    }
    au.getSysCmdMsgExtension().a("jd", this.pvn, true);
    com.tencent.mm.sdk.b.a.udP.c(this.dii);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    if (this.pvn != null)
    {
      a locala = this.pvn;
      com.tencent.mm.sdk.b.a.udP.d(locala.puW);
      au.getSysCmdMsgExtension().b("jd", this.pvn, true);
    }
    this.pvp.clear();
    this.pvn = null;
    com.tencent.mm.sdk.b.a.udP.d(this.dii);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.c
 * JD-Core Version:    0.7.0.1
 */