package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.m.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class d
  implements at, f.a
{
  private j.a appForegroundListener;
  private com.tencent.mm.sdk.b.c dZC;
  private a sWR;
  private c sWS;
  Map<String, Integer> sWT;
  
  public d()
  {
    AppMethodBeat.i(25204);
    this.sWR = null;
    this.sWS = null;
    this.sWT = new HashMap();
    this.appForegroundListener = new j.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(153653);
        if (f.vMG != null)
        {
          d.cGE();
          d.cGL();
        }
        AppMethodBeat.o(153653);
      }
    };
    this.dZC = new d.2(this);
    ab.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bo.dtY());
    AppMethodBeat.o(25204);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(25213);
    com.tencent.mm.kernel.g.RJ().QQ();
    d locald = cGE();
    if (locald.sWS == null) {
      locald.sWS = c.cGB();
    }
    ab.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.sWS.SU(), paramc.SU() });
    if (!paramc.a(locald.sWS))
    {
      ab.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(25213);
      return;
    }
    if ((!bo.isNullOrNil(paramc.sWE)) || (paramc.sWD))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327939, "1");
    }
    if (paramc.sWC)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327938, "1");
    }
    for (;;)
    {
      locald.sWS = paramc;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327942, paramc.cDI);
      locald.cGK();
      AppMethodBeat.o(25213);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327938, "");
    }
  }
  
  public static d cGE()
  {
    AppMethodBeat.i(25205);
    d locald2 = (d)f.vMG;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      f.vMG = locald1;
    }
    AppMethodBeat.o(25205);
    return locald1;
  }
  
  public static boolean cGF()
  {
    AppMethodBeat.i(25208);
    aw.aaz();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.Ru().get(327939, ""));
    AppMethodBeat.o(25208);
    return bool;
  }
  
  public static boolean cGG()
  {
    AppMethodBeat.i(25209);
    aw.aaz();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.Ru().get(327938, ""));
    AppMethodBeat.o(25209);
    return bool;
  }
  
  public static void cGH()
  {
    AppMethodBeat.i(25210);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(327938, "");
    AppMethodBeat.o(25210);
  }
  
  public static void cGI()
  {
    AppMethodBeat.i(25211);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(327939, "");
    AppMethodBeat.o(25211);
  }
  
  private void cGK()
  {
    AppMethodBeat.i(25214);
    new ak(Looper.getMainLooper()).post(new d.3(this));
    AppMethodBeat.o(25214);
  }
  
  public static void cGL()
  {
    AppMethodBeat.i(25215);
    if (aw.RG())
    {
      cGE();
      if (!cGF())
      {
        cGE();
        if (!cGG()) {}
      }
      else
      {
        c localc = cGE().cGJ();
        if (((!bo.isNullOrNil(localc.sWE)) || (localc.sWD)) && (localc.bzK()))
        {
          ab.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          cGE();
          cGH();
          cGE();
          cGI();
          cGE().cGK();
        }
      }
    }
    AppMethodBeat.o(25215);
  }
  
  public static String cGN()
  {
    AppMethodBeat.i(153658);
    String str;
    if (aa.dsD()) {
      str = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(153658);
      return str;
      if (aa.dsE()) {
        str = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String cGO()
  {
    AppMethodBeat.i(153659);
    String str = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(153659);
    return str;
  }
  
  public static String dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(25216);
    String str = paramString;
    if (-1 == paramString.indexOf('#')) {
      if (-1 != paramString.indexOf('?')) {
        break label61;
      }
    }
    label61:
    for (str = paramString + "?wc_scene=" + paramInt;; str = paramString + "&wc_scene=" + paramInt)
    {
      AppMethodBeat.o(25216);
      return str;
    }
  }
  
  public final c cGJ()
  {
    AppMethodBeat.i(25212);
    if (this.sWS == null) {
      this.sWS = c.cGB();
    }
    c localc = this.sWS;
    AppMethodBeat.o(25212);
    return localc;
  }
  
  public final boolean cGM()
  {
    AppMethodBeat.i(153657);
    String str1 = cGN();
    String str2 = cGO();
    String str3 = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!bo.isNullOrNil(str1)) && ((!bo.isNullOrNil(str2)) || (!bo.isNullOrNil(str3))))
    {
      AppMethodBeat.o(153657);
      return true;
    }
    AppMethodBeat.o(153657);
    return false;
  }
  
  public final String cGP()
  {
    int j = 1;
    AppMethodBeat.i(153660);
    Object localObject2 = "";
    c localc = cGJ();
    int i = j;
    Object localObject1 = localObject2;
    if (cGF())
    {
      if ((localc.bzK()) || (!"3".equals(localc.sWA)) || (bo.isNullOrNil(localc.jumpUrl))) {
        break label184;
      }
      ab.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localc.jumpUrl });
      localObject1 = localc.jumpUrl;
      i = 6;
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localc.sWA))
      {
        j = i;
        localObject2 = localObject1;
        if (!bo.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.cGC())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.cGD())
            {
              localObject2 = localc.jumpUrl;
              j = 3;
            }
          }
        }
      }
      if (bo.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = dz((String)localObject2, j);
      AppMethodBeat.o(153660);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.sWD)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = cGO();
    AppMethodBeat.o(153660);
    return localObject1;
  }
  
  public final b cGQ()
  {
    AppMethodBeat.i(153661);
    b localb = new b();
    Object localObject = cGJ();
    if ((cGF()) && (!((c)localObject).bzK()) && ("3".equals(((c)localObject).sWA)))
    {
      ab.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).sWA, ((c)localObject).sWO, ((c)localObject).sWP, Integer.valueOf(((c)localObject).sWQ) });
      localb.username = ((c)localObject).sWO;
      localb.path = ((c)localObject).sWP;
      localb.version = ((c)localObject).sWQ;
    }
    if (("2".equals(((c)localObject).sWA)) && (((c)localObject).cGC()) && (!((c)localObject).cGD()))
    {
      ab.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).sWA, ((c)localObject).sWO, ((c)localObject).sWP, Integer.valueOf(((c)localObject).sWQ) });
      localb.username = ((c)localObject).sWO;
      localb.path = ((c)localObject).sWP;
      localb.version = ((c)localObject).sWQ;
    }
    localObject = localb;
    if (!localb.isValid())
    {
      localObject = new b();
      ((b)localObject).username = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigJumpWeAppUsername");
      ((b)localObject).path = com.tencent.mm.m.g.Nq().getValue("JDEntranceConfigJumpWeAppPath");
      ((b)localObject).version = com.tencent.mm.m.g.Nq().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    }
    AppMethodBeat.o(153661);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25206);
    ab.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.sWR == null) {
      this.sWR = new a();
    }
    this.appForegroundListener.alive();
    aw.getSysCmdMsgExtension().a("jd", this.sWR, true);
    com.tencent.mm.sdk.b.a.ymk.c(this.dZC);
    AppMethodBeat.o(25206);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(25207);
    ab.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.sWR != null)
    {
      a locala = this.sWR;
      com.tencent.mm.sdk.b.a.ymk.d(locala.sWx);
      aw.getSysCmdMsgExtension().b("jd", this.sWR, true);
    }
    this.sWT.clear();
    this.sWR = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.dZC);
    AppMethodBeat.o(25207);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */