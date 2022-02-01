package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.km;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf;
import com.tencent.mm.pluginsdk.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements az, g.a
{
  private a ByR;
  private c ByS;
  Map<String, Integer> ByT;
  private o.a appForegroundListener;
  private com.tencent.mm.sdk.b.c fHr;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.ByR = null;
    this.ByS = null;
    this.ByT = new HashMap();
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28878);
        if (com.tencent.mm.pluginsdk.i.g.Fhv != null)
        {
          d.eqr();
          d.eqy();
        }
        AppMethodBeat.o(28878);
      }
    };
    this.fHr = new d.2(this);
    ae.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bu.fpN());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    com.tencent.mm.kernel.g.ajP().aiU();
    d locald = eqr();
    if (locald.ByS == null) {
      locald.ByS = c.eqo();
    }
    ae.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.ByS.alg(), paramc.alg() });
    if (!paramc.a(locald.ByS))
    {
      ae.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!bu.isNullOrNil(paramc.ByE)) || (paramc.ByD))
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327939, "1");
    }
    if (paramc.ByC)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327938, "1");
    }
    for (;;)
    {
      locald.ByS = paramc;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327942, paramc.dEU);
      locald.eqx();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaO, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327938, "");
    }
  }
  
  public static String eqA()
  {
    AppMethodBeat.i(28895);
    String str;
    if (ad.foj()) {
      str = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (ad.fok()) {
        str = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String eqB()
  {
    AppMethodBeat.i(28896);
    String str = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  private static b eqC()
  {
    AppMethodBeat.i(186631);
    b localb = new b();
    localb.username = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigJumpWeAppUsername");
    localb.path = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigJumpWeAppPath");
    localb.version = com.tencent.mm.n.g.acL().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    AppMethodBeat.o(186631);
    return localb;
  }
  
  public static d eqr()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)com.tencent.mm.pluginsdk.i.g.Fhv;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.pluginsdk.i.g.Fhv = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean eqs()
  {
    AppMethodBeat.i(28885);
    bc.aCg();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ajA().get(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean eqt()
  {
    AppMethodBeat.i(28886);
    bc.aCg();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ajA().get(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void equ()
  {
    AppMethodBeat.i(28887);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void eqv()
  {
    AppMethodBeat.i(28888);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void eqx()
  {
    AppMethodBeat.i(28891);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        km localkm = new km();
        com.tencent.mm.sdk.b.a.IvT.l(localkm);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void eqy()
  {
    AppMethodBeat.i(28892);
    if (bc.ajM())
    {
      eqr();
      if (!eqs())
      {
        eqr();
        if (!eqt()) {}
      }
      else
      {
        c localc = eqr().eqw();
        if (((!bu.isNullOrNil(localc.ByE)) || (localc.ByD)) && (localc.cTg()))
        {
          ae.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          eqr();
          equ();
          eqr();
          eqv();
          eqr().eqx();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String fq(String paramString, int paramInt)
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
  
  public final String eqD()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = eqw();
    int i = j;
    Object localObject1 = localObject2;
    if (eqs())
    {
      if ((localc.cTg()) || (!"3".equals(localc.ByA)) || (bu.isNullOrNil(localc.jumpUrl))) {
        break label184;
      }
      ae.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localc.jumpUrl });
      localObject1 = localc.jumpUrl;
      i = 6;
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localc.ByA))
      {
        j = i;
        localObject2 = localObject1;
        if (!bu.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.eqp())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.eqq())
            {
              localObject2 = localc.jumpUrl;
              j = 3;
            }
          }
        }
      }
      if (bu.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = fq((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.ByD)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = eqB();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b eqE()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = eqw();
    if ((eqs()) && (!((c)localObject).cTg()) && ("3".equals(((c)localObject).ByA)))
    {
      ae.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).ByA, ((c)localObject).ByO, ((c)localObject).ByP, Integer.valueOf(((c)localObject).ByQ) });
      localb.username = ((c)localObject).ByO;
      localb.path = ((c)localObject).ByP;
      localb.version = ((c)localObject).ByQ;
    }
    if (("2".equals(((c)localObject).ByA)) && (((c)localObject).eqp()) && (!((c)localObject).eqq()))
    {
      ae.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).ByA, ((c)localObject).ByO, ((c)localObject).ByP, Integer.valueOf(((c)localObject).ByQ) });
      localb.username = ((c)localObject).ByO;
      localb.path = ((c)localObject).ByP;
      localb.version = ((c)localObject).ByQ;
    }
    localObject = localb;
    if (!localb.isValid()) {
      localObject = eqC();
    }
    AppMethodBeat.o(28898);
    return localObject;
  }
  
  public final c eqw()
  {
    AppMethodBeat.i(28889);
    if (this.ByS == null) {
      this.ByS = c.eqo();
    }
    c localc = this.ByS;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean eqz()
  {
    AppMethodBeat.i(28894);
    String str1 = eqA();
    String str2 = eqB();
    String str3 = com.tencent.mm.n.g.acL().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!bu.isNullOrNil(str1)) && ((!bu.isNullOrNil(str2)) || (!bu.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28883);
    ae.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.ByR == null) {
      this.ByR = new a();
    }
    this.appForegroundListener.alive();
    bc.getSysCmdMsgExtension().a("jd", this.ByR, true);
    com.tencent.mm.sdk.b.a.IvT.c(this.fHr);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    ae.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.ByR != null)
    {
      a locala = this.ByR;
      com.tencent.mm.sdk.b.a.IvT.d(locala.Byx);
      bc.getSysCmdMsgExtension().b("jd", this.ByR, true);
    }
    this.ByT.clear();
    this.ByR = null;
    com.tencent.mm.sdk.b.a.IvT.d(this.fHr);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */