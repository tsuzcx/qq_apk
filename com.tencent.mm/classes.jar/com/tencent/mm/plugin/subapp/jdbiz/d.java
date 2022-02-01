package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.pluginsdk.g.f;
import com.tencent.mm.pluginsdk.g.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements aw, f.a
{
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c fnf;
  private a zPS;
  private c zPT;
  Map<String, Integer> zPU;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.zPS = null;
    this.zPT = null;
    this.zPU = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28878);
        if (f.DjX != null)
        {
          d.eat();
          d.eaA();
        }
        AppMethodBeat.o(28878);
      }
    };
    this.fnf = new com.tencent.mm.sdk.b.c() {};
    ac.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bs.eWi());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    com.tencent.mm.kernel.g.agP().afT();
    d locald = eat();
    if (locald.zPT == null) {
      locald.zPT = c.eaq();
    }
    ac.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.zPT.aif(), paramc.aif() });
    if (!paramc.a(locald.zPT))
    {
      ac.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!bs.isNullOrNil(paramc.zPF)) || (paramc.zPE))
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(327939, "1");
    }
    if (paramc.zPD)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(327938, "1");
    }
    for (;;)
    {
      locald.zPT = paramc;
      az.ayM();
      com.tencent.mm.model.c.agA().set(327942, paramc.drV);
      locald.eaz();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTI, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      az.ayM();
      com.tencent.mm.model.c.agA().set(327938, "");
    }
  }
  
  public static String eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(28893);
    String str = paramString;
    if (-1 == paramString.indexOf('#')) {
      if (-1 != paramString.indexOf('?')) {
        break label60;
      }
    }
    label60:
    for (str = paramString + "?wc_scene=" + paramInt;; str = paramString + "&wc_scene=" + paramInt)
    {
      AppMethodBeat.o(28893);
      return str;
    }
  }
  
  public static void eaA()
  {
    AppMethodBeat.i(28892);
    if (az.agM())
    {
      eat();
      if (!eau())
      {
        eat();
        if (!eav()) {}
      }
      else
      {
        c localc = eat().eay();
        if (((!bs.isNullOrNil(localc.zPF)) || (localc.zPE)) && (localc.cIm()))
        {
          ac.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          eat();
          eaw();
          eat();
          eax();
          eat().eaz();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String eaC()
  {
    AppMethodBeat.i(28895);
    String str;
    if (ab.eUL()) {
      str = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (ab.eUM()) {
        str = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String eaD()
  {
    AppMethodBeat.i(28896);
    String str = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  public static d eat()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)f.DjX;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      f.DjX = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean eau()
  {
    AppMethodBeat.i(28885);
    az.ayM();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.agA().get(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean eav()
  {
    AppMethodBeat.i(28886);
    az.ayM();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.agA().get(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void eaw()
  {
    AppMethodBeat.i(28887);
    az.ayM();
    com.tencent.mm.model.c.agA().set(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void eax()
  {
    AppMethodBeat.i(28888);
    az.ayM();
    com.tencent.mm.model.c.agA().set(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void eaz()
  {
    AppMethodBeat.i(28891);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        kd localkd = new kd();
        com.tencent.mm.sdk.b.a.GpY.l(localkd);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final boolean eaB()
  {
    AppMethodBeat.i(28894);
    String str1 = eaC();
    String str2 = eaD();
    String str3 = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!bs.isNullOrNil(str1)) && ((!bs.isNullOrNil(str2)) || (!bs.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public final String eaE()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = eay();
    int i = j;
    Object localObject1 = localObject2;
    if (eau())
    {
      if ((localc.cIm()) || (!"3".equals(localc.zPB)) || (bs.isNullOrNil(localc.jumpUrl))) {
        break label184;
      }
      ac.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localc.jumpUrl });
      localObject1 = localc.jumpUrl;
      i = 6;
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localc.zPB))
      {
        j = i;
        localObject2 = localObject1;
        if (!bs.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.ear())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.eas())
            {
              localObject2 = localc.jumpUrl;
              j = 3;
            }
          }
        }
      }
      if (bs.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = eP((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.zPE)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = eaD();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b eaF()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = eay();
    if ((eau()) && (!((c)localObject).cIm()) && ("3".equals(((c)localObject).zPB)))
    {
      ac.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).zPB, ((c)localObject).zPP, ((c)localObject).zPQ, Integer.valueOf(((c)localObject).zPR) });
      localb.username = ((c)localObject).zPP;
      localb.path = ((c)localObject).zPQ;
      localb.version = ((c)localObject).zPR;
    }
    if (("2".equals(((c)localObject).zPB)) && (((c)localObject).ear()) && (!((c)localObject).eas()))
    {
      ac.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).zPB, ((c)localObject).zPP, ((c)localObject).zPQ, Integer.valueOf(((c)localObject).zPR) });
      localb.username = ((c)localObject).zPP;
      localb.path = ((c)localObject).zPQ;
      localb.version = ((c)localObject).zPR;
    }
    localObject = localb;
    if (!localb.isValid())
    {
      localObject = new b();
      ((b)localObject).username = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigJumpWeAppUsername");
      ((b)localObject).path = com.tencent.mm.m.g.ZY().getValue("JDEntranceConfigJumpWeAppPath");
      ((b)localObject).version = com.tencent.mm.m.g.ZY().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    }
    AppMethodBeat.o(28898);
    return localObject;
  }
  
  public final c eay()
  {
    AppMethodBeat.i(28889);
    if (this.zPT == null) {
      this.zPT = c.eaq();
    }
    c localc = this.zPT;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28883);
    ac.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.zPS == null) {
      this.zPS = new a();
    }
    this.appForegroundListener.alive();
    az.getSysCmdMsgExtension().a("jd", this.zPS, true);
    com.tencent.mm.sdk.b.a.GpY.c(this.fnf);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    ac.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.zPS != null)
    {
      a locala = this.zPS;
      com.tencent.mm.sdk.b.a.GpY.d(locala.zPy);
      az.getSysCmdMsgExtension().b("jd", this.zPS, true);
    }
    this.zPU.clear();
    this.zPS = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.fnf);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */