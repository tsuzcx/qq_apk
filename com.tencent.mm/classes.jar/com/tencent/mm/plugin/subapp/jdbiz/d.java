package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.ls;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements be, d.a
{
  private c MdA;
  Map<String, Integer> MdB;
  private a Mdz;
  private o.a appForegroundListener;
  private IListener iQL;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.Mdz = null;
    this.MdA = null;
    this.MdB = new HashMap();
    this.appForegroundListener = new d.1(this);
    this.iQL = new d.2(this);
    Log.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + Util.getStack());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    com.tencent.mm.kernel.h.aHE().aGH();
    d locald = ghp();
    if (locald.MdA == null) {
      locald.MdA = c.ghm();
    }
    Log.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.MdA.aJc(), paramc.aJc() });
    if (!paramc.a(locald.MdA))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!Util.isNullOrNil(paramc.Mdm)) || (paramc.Mdl))
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327939, "1");
    }
    if (paramc.Mdk)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327938, "1");
    }
    for (;;)
    {
      locald.MdA = paramc;
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327942, paramc.fQs);
      locald.ghv();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxL, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327938, "");
    }
  }
  
  private static b ghA()
  {
    AppMethodBeat.i(218435);
    b localb = new b();
    localb.username = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigJumpWeAppUsername");
    localb.path = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigJumpWeAppPath");
    localb.version = com.tencent.mm.n.h.axc().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    AppMethodBeat.o(218435);
    return localb;
  }
  
  public static d ghp()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)com.tencent.mm.pluginsdk.j.d.QYQ;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.pluginsdk.j.d.QYQ = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean ghq()
  {
    AppMethodBeat.i(28885);
    bh.beI();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.aHp().b(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean ghr()
  {
    AppMethodBeat.i(28886);
    bh.beI();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.aHp().b(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void ghs()
  {
    AppMethodBeat.i(28887);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void ght()
  {
    AppMethodBeat.i(28888);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void ghv()
  {
    AppMethodBeat.i(28891);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        ls localls = new ls();
        EventCenter.instance.publish(localls);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void ghw()
  {
    AppMethodBeat.i(28892);
    if (bh.aHB())
    {
      ghp();
      if (!ghq())
      {
        ghp();
        if (!ghr()) {}
      }
      else
      {
        c localc = ghp().ghu();
        if (((!Util.isNullOrNil(localc.Mdm)) || (localc.Mdl)) && (localc.eqj()))
        {
          Log.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          ghp();
          ghs();
          ghp();
          ght();
          ghp().ghv();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String ghy()
  {
    AppMethodBeat.i(28895);
    String str;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      str = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        str = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String ghz()
  {
    AppMethodBeat.i(28896);
    String str = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  public static String gs(String paramString, int paramInt)
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
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final String ghB()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = ghu();
    int i = j;
    Object localObject1 = localObject2;
    if (ghq())
    {
      if ((localc.eqj()) || (!"3".equals(localc.Mdj)) || (Util.isNullOrNil(localc.jumpUrl))) {
        break label184;
      }
      Log.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localc.jumpUrl });
      localObject1 = localc.jumpUrl;
      i = 6;
    }
    for (;;)
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localc.Mdj))
      {
        j = i;
        localObject2 = localObject1;
        if (!Util.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.ghn())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.gho())
            {
              localObject2 = localc.jumpUrl;
              j = 3;
            }
          }
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = gs((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.Mdl)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = ghz();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b ghC()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = ghu();
    if ((ghq()) && (!((c)localObject).eqj()) && ("3".equals(((c)localObject).Mdj)))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).Mdj, ((c)localObject).Mdw, ((c)localObject).Mdx, Integer.valueOf(((c)localObject).Mdy) });
      localb.username = ((c)localObject).Mdw;
      localb.path = ((c)localObject).Mdx;
      localb.version = ((c)localObject).Mdy;
    }
    if (("2".equals(((c)localObject).Mdj)) && (((c)localObject).ghn()) && (!((c)localObject).gho()))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).Mdj, ((c)localObject).Mdw, ((c)localObject).Mdx, Integer.valueOf(((c)localObject).Mdy) });
      localb.username = ((c)localObject).Mdw;
      localb.path = ((c)localObject).Mdx;
      localb.version = ((c)localObject).Mdy;
    }
    localObject = localb;
    if (!localb.isValid()) {
      localObject = ghA();
    }
    AppMethodBeat.o(28898);
    return localObject;
  }
  
  public final c ghu()
  {
    AppMethodBeat.i(28889);
    if (this.MdA == null) {
      this.MdA = c.ghm();
    }
    c localc = this.MdA;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean ghx()
  {
    AppMethodBeat.i(28894);
    String str1 = ghy();
    String str2 = ghz();
    String str3 = com.tencent.mm.n.h.axc().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!Util.isNullOrNil(str1)) && ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28883);
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.Mdz == null) {
      this.Mdz = new a();
    }
    this.appForegroundListener.alive();
    bh.getSysCmdMsgExtension().a("jd", this.Mdz, true);
    EventCenter.instance.addListener(this.iQL);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.Mdz != null)
    {
      a locala = this.Mdz;
      EventCenter.instance.removeListener(locala.Mdg);
      bh.getSysCmdMsgExtension().b("jd", this.Mdz, true);
    }
    this.MdB.clear();
    this.Mdz = null;
    EventCenter.instance.removeListener(this.iQL);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */