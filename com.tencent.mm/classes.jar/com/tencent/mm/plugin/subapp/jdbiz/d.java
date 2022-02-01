package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.pluginsdk.g.f;
import com.tencent.mm.pluginsdk.g.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements aw, f.a
{
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c fjL;
  private a yCE;
  private c yCF;
  Map<String, Integer> yCG;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.yCE = null;
    this.yCF = null;
    this.yCG = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28878);
        if (f.BRH != null)
        {
          d.dLT();
          d.dMa();
        }
        AppMethodBeat.o(28878);
      }
    };
    this.fjL = new com.tencent.mm.sdk.b.c() {};
    ad.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bt.eGN());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    com.tencent.mm.kernel.g.afz().aeD();
    d locald = dLT();
    if (locald.yCF == null) {
      locald.yCF = c.dLQ();
    }
    ad.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.yCF.agO(), paramc.agO() });
    if (!paramc.a(locald.yCF))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!bt.isNullOrNil(paramc.yCr)) || (paramc.yCq))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(327939, "1");
    }
    if (paramc.yCp)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(327938, "1");
    }
    for (;;)
    {
      locald.yCF = paramc;
      az.arV();
      com.tencent.mm.model.c.afk().set(327942, paramc.duk);
      locald.dLZ();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvO, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      az.arV();
      com.tencent.mm.model.c.afk().set(327938, "");
    }
  }
  
  public static d dLT()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)f.BRH;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      f.BRH = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean dLU()
  {
    AppMethodBeat.i(28885);
    az.arV();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.afk().get(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean dLV()
  {
    AppMethodBeat.i(28886);
    az.arV();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.afk().get(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void dLW()
  {
    AppMethodBeat.i(28887);
    az.arV();
    com.tencent.mm.model.c.afk().set(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void dLX()
  {
    AppMethodBeat.i(28888);
    az.arV();
    com.tencent.mm.model.c.afk().set(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void dLZ()
  {
    AppMethodBeat.i(28891);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        jv localjv = new jv();
        com.tencent.mm.sdk.b.a.ESL.l(localjv);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void dMa()
  {
    AppMethodBeat.i(28892);
    if (az.afw())
    {
      dLT();
      if (!dLU())
      {
        dLT();
        if (!dLV()) {}
      }
      else
      {
        c localc = dLT().dLY();
        if (((!bt.isNullOrNil(localc.yCr)) || (localc.yCq)) && (localc.cva()))
        {
          ad.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          dLT();
          dLW();
          dLT();
          dLX();
          dLT().dLZ();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String dMc()
  {
    AppMethodBeat.i(28895);
    String str;
    if (ac.eFr()) {
      str = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (ac.eFs()) {
        str = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String dMd()
  {
    AppMethodBeat.i(28896);
    String str = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  public static String eH(String paramString, int paramInt)
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
  
  public final c dLY()
  {
    AppMethodBeat.i(28889);
    if (this.yCF == null) {
      this.yCF = c.dLQ();
    }
    c localc = this.yCF;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean dMb()
  {
    AppMethodBeat.i(28894);
    String str1 = dMc();
    String str2 = dMd();
    String str3 = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!bt.isNullOrNil(str1)) && ((!bt.isNullOrNil(str2)) || (!bt.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public final String dMe()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = dLY();
    int i = j;
    Object localObject1 = localObject2;
    if (dLU())
    {
      if ((localc.cva()) || (!"3".equals(localc.yCn)) || (bt.isNullOrNil(localc.jumpUrl))) {
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
      if ("2".equals(localc.yCn))
      {
        j = i;
        localObject2 = localObject1;
        if (!bt.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.dLR())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.dLS())
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
      localObject1 = eH((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.yCq)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = dMd();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b dMf()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = dLY();
    if ((dLU()) && (!((c)localObject).cva()) && ("3".equals(((c)localObject).yCn)))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).yCn, ((c)localObject).yCB, ((c)localObject).yCC, Integer.valueOf(((c)localObject).yCD) });
      localb.username = ((c)localObject).yCB;
      localb.path = ((c)localObject).yCC;
      localb.version = ((c)localObject).yCD;
    }
    if (("2".equals(((c)localObject).yCn)) && (((c)localObject).dLR()) && (!((c)localObject).dLS()))
    {
      ad.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).yCn, ((c)localObject).yCB, ((c)localObject).yCC, Integer.valueOf(((c)localObject).yCD) });
      localb.username = ((c)localObject).yCB;
      localb.path = ((c)localObject).yCC;
      localb.version = ((c)localObject).yCD;
    }
    localObject = localb;
    if (!localb.isValid())
    {
      localObject = new b();
      ((b)localObject).username = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigJumpWeAppUsername");
      ((b)localObject).path = com.tencent.mm.m.g.Zd().getValue("JDEntranceConfigJumpWeAppPath");
      ((b)localObject).version = com.tencent.mm.m.g.Zd().getInt("JDEntranceConfigJumpWeAppVersion", 0);
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
    if (this.yCE == null) {
      this.yCE = new a();
    }
    this.appForegroundListener.alive();
    az.getSysCmdMsgExtension().a("jd", this.yCE, true);
    com.tencent.mm.sdk.b.a.ESL.c(this.fjL);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    ad.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.yCE != null)
    {
      a locala = this.yCE;
      com.tencent.mm.sdk.b.a.ESL.d(locala.yCk);
      az.getSysCmdMsgExtension().b("jd", this.yCE, true);
    }
    this.yCG.clear();
    this.yCE = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.fjL);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */