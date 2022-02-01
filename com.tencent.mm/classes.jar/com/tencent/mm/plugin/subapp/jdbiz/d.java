package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cd;
import com.tencent.mm.pluginsdk.i.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements ax, g.a
{
  private a Bht;
  private c Bhu;
  Map<String, Integer> Bhv;
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c fFn;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.Bht = null;
    this.Bhu = null;
    this.Bhv = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28878);
        if (com.tencent.mm.pluginsdk.i.g.EPa != null)
        {
          d.emI();
          d.emP();
        }
        AppMethodBeat.o(28878);
      }
    };
    this.fFn = new d.2(this);
    ad.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bt.flS());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    com.tencent.mm.kernel.g.ajA().aiF();
    d locald = emI();
    if (locald.Bhu == null) {
      locald.Bhu = c.emF();
    }
    ad.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.Bhu.akR(), paramc.akR() });
    if (!paramc.a(locald.Bhu))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!bt.isNullOrNil(paramc.Bhg)) || (paramc.Bhf))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327939, "1");
    }
    if (paramc.Bhe)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327938, "1");
    }
    for (;;)
    {
      locald.Bhu = paramc;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327942, paramc.dDP);
      locald.emO();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGo, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327938, "");
    }
  }
  
  public static d emI()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)com.tencent.mm.pluginsdk.i.g.EPa;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.pluginsdk.i.g.EPa = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean emJ()
  {
    AppMethodBeat.i(28885);
    ba.aBQ();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ajl().get(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean emK()
  {
    AppMethodBeat.i(28886);
    ba.aBQ();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ajl().get(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void emL()
  {
    AppMethodBeat.i(28887);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void emM()
  {
    AppMethodBeat.i(28888);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void emO()
  {
    AppMethodBeat.i(28891);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        kl localkl = new kl();
        com.tencent.mm.sdk.b.a.IbL.l(localkl);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void emP()
  {
    AppMethodBeat.i(28892);
    if (ba.ajx())
    {
      emI();
      if (!emJ())
      {
        emI();
        if (!emK()) {}
      }
      else
      {
        c localc = emI().emN();
        if (((!bt.isNullOrNil(localc.Bhg)) || (localc.Bhf)) && (localc.cQB()))
        {
          ad.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          emI();
          emL();
          emI();
          emM();
          emI().emO();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String emR()
  {
    AppMethodBeat.i(28895);
    String str;
    if (ac.fkp()) {
      str = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (ac.fkq()) {
        str = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String emS()
  {
    AppMethodBeat.i(28896);
    String str = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  private static b emT()
  {
    AppMethodBeat.i(193356);
    b localb = new b();
    localb.username = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigJumpWeAppUsername");
    localb.path = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigJumpWeAppPath");
    localb.version = com.tencent.mm.n.g.acA().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    AppMethodBeat.o(193356);
    return localb;
  }
  
  public static String fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(28893);
    String str = paramString;
    if (-1 == paramString.indexOf('#')) {
      if (-1 != paramString.indexOf('?')) {
        break label61;
      }
    }
    label61:
    for (str = paramString + "?wc_scene=" + paramInt;; str = paramString + "&wc_scene=" + paramInt)
    {
      AppMethodBeat.o(28893);
      return str;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final c emN()
  {
    AppMethodBeat.i(28889);
    if (this.Bhu == null) {
      this.Bhu = c.emF();
    }
    c localc = this.Bhu;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean emQ()
  {
    AppMethodBeat.i(28894);
    String str1 = emR();
    String str2 = emS();
    String str3 = com.tencent.mm.n.g.acA().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!bt.isNullOrNil(str1)) && ((!bt.isNullOrNil(str2)) || (!bt.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public final String emU()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = emN();
    int i = j;
    Object localObject1 = localObject2;
    if (emJ())
    {
      if ((localc.cQB()) || (!"3".equals(localc.Bhc)) || (bt.isNullOrNil(localc.jumpUrl))) {
        break label184;
      }
      ad.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localc.jumpUrl });
      localObject1 = localc.jumpUrl;
      i = 6;
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localc.Bhc))
      {
        j = i;
        localObject2 = localObject1;
        if (!bt.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.emG())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.emH())
            {
              localObject2 = localc.jumpUrl;
              j = 3;
            }
          }
        }
      }
      if (bt.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = fh((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.Bhf)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = emS();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b emV()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = emN();
    if ((emJ()) && (!((c)localObject).cQB()) && ("3".equals(((c)localObject).Bhc)))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).Bhc, ((c)localObject).Bhq, ((c)localObject).Bhr, Integer.valueOf(((c)localObject).Bhs) });
      localb.username = ((c)localObject).Bhq;
      localb.path = ((c)localObject).Bhr;
      localb.version = ((c)localObject).Bhs;
    }
    if (("2".equals(((c)localObject).Bhc)) && (((c)localObject).emG()) && (!((c)localObject).emH()))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).Bhc, ((c)localObject).Bhq, ((c)localObject).Bhr, Integer.valueOf(((c)localObject).Bhs) });
      localb.username = ((c)localObject).Bhq;
      localb.path = ((c)localObject).Bhr;
      localb.version = ((c)localObject).Bhs;
    }
    localObject = localb;
    if (!localb.isValid()) {
      localObject = emT();
    }
    AppMethodBeat.o(28898);
    return localObject;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28883);
    ad.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.Bht == null) {
      this.Bht = new a();
    }
    this.appForegroundListener.alive();
    ba.getSysCmdMsgExtension().a("jd", this.Bht, true);
    com.tencent.mm.sdk.b.a.IbL.c(this.fFn);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    ad.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.Bht != null)
    {
      a locala = this.Bht;
      com.tencent.mm.sdk.b.a.IbL.d(locala.BgZ);
      ba.getSysCmdMsgExtension().b("jd", this.Bht, true);
    }
    this.Bhv.clear();
    this.Bht = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.fFn);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */