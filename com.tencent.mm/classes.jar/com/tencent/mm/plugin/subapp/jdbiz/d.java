package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.mx;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.pluginsdk.platformtools.d.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements be, d.a
{
  private a SEP;
  private c SEQ;
  Map<String, Integer> SER;
  private q.a appForegroundListener;
  private IListener lsH;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.SEP = null;
    this.SEQ = null;
    this.SER = new HashMap();
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28878);
        if (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null)
        {
          d.hAI();
          d.hAP();
        }
        AppMethodBeat.o(28878);
      }
    };
    this.lsH = new SubCoreJDBiz.2(this, com.tencent.mm.app.f.hfK);
    Log.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + Util.getStack());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    h.baC().aZJ();
    d locald = hAI();
    if (locald.SEQ == null) {
      locald.SEQ = c.hAF();
    }
    Log.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.SEQ.bbZ(), paramc.bbZ() });
    if (!paramc.a(locald.SEQ))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!Util.isNullOrNil(paramc.SEC)) || (paramc.SEB))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327939, "1");
    }
    if (paramc.SEA)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327938, "1");
    }
    for (;;)
    {
      locald.SEQ = paramc;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327942, paramc.hWn);
      locald.hAO();
      h.baE().ban().set(at.a.acZy, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327938, "");
    }
  }
  
  public static d hAI()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)com.tencent.mm.pluginsdk.platformtools.d.XUQ;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.pluginsdk.platformtools.d.XUQ = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean hAJ()
  {
    AppMethodBeat.i(28885);
    bh.bCz();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ban().d(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean hAK()
  {
    AppMethodBeat.i(28886);
    bh.bCz();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.ban().d(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void hAL()
  {
    AppMethodBeat.i(28887);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void hAM()
  {
    AppMethodBeat.i(28888);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void hAO()
  {
    AppMethodBeat.i(28891);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        new mx().publish();
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void hAP()
  {
    AppMethodBeat.i(28892);
    if (bh.baz())
    {
      hAI();
      if (!hAJ())
      {
        hAI();
        if (!hAK()) {}
      }
      else
      {
        c localc = hAI().hAN();
        if (((!Util.isNullOrNil(localc.SEC)) || (localc.SEB)) && (localc.dgl()))
        {
          Log.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          hAI();
          hAL();
          hAI();
          hAM();
          hAI().hAO();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String hAR()
  {
    AppMethodBeat.i(28895);
    String str;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      str = i.aRC().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        str = i.aRC().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = i.aRC().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String hAS()
  {
    AppMethodBeat.i(28896);
    String str = i.aRC().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  private static b hAT()
  {
    AppMethodBeat.i(291995);
    b localb = new b();
    localb.username = i.aRC().getValue("JDEntranceConfigJumpWeAppUsername");
    localb.path = i.aRC().getValue("JDEntranceConfigJumpWeAppPath");
    localb.version = i.aRC().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    AppMethodBeat.o(291995);
    return localb;
  }
  
  public static String hm(String paramString, int paramInt)
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
  
  public final c hAN()
  {
    AppMethodBeat.i(28889);
    if (this.SEQ == null) {
      this.SEQ = c.hAF();
    }
    c localc = this.SEQ;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean hAQ()
  {
    AppMethodBeat.i(28894);
    String str1 = hAR();
    String str2 = hAS();
    String str3 = i.aRC().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!Util.isNullOrNil(str1)) && ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public final String hAU()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = hAN();
    int i = j;
    Object localObject1 = localObject2;
    if (hAJ())
    {
      if ((localc.dgl()) || (!"3".equals(localc.SEz)) || (Util.isNullOrNil(localc.jumpUrl))) {
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
      if ("2".equals(localc.SEz))
      {
        j = i;
        localObject2 = localObject1;
        if (!Util.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.hAG())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.hAH())
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
      localObject1 = hm((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.SEB)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = hAS();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b hAV()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = hAN();
    if ((hAJ()) && (!((c)localObject).dgl()) && ("3".equals(((c)localObject).SEz)))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).SEz, ((c)localObject).SEM, ((c)localObject).SEN, Integer.valueOf(((c)localObject).SEO) });
      localb.username = ((c)localObject).SEM;
      localb.path = ((c)localObject).SEN;
      localb.version = ((c)localObject).SEO;
    }
    if (("2".equals(((c)localObject).SEz)) && (((c)localObject).hAG()) && (!((c)localObject).hAH()))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).SEz, ((c)localObject).SEM, ((c)localObject).SEN, Integer.valueOf(((c)localObject).SEO) });
      localb.username = ((c)localObject).SEM;
      localb.path = ((c)localObject).SEN;
      localb.version = ((c)localObject).SEO;
    }
    localObject = localb;
    if (!localb.isValid()) {
      localObject = hAT();
    }
    AppMethodBeat.o(28898);
    return localObject;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28883);
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.SEP == null) {
      this.SEP = new a();
    }
    this.appForegroundListener.alive();
    bh.getSysCmdMsgExtension().a("jd", this.SEP, true);
    this.lsH.alive();
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.SEP != null)
    {
      this.SEP.SEw.dead();
      bh.getSysCmdMsgExtension().b("jd", this.SEP, true);
    }
    this.SER.clear();
    this.SEP = null;
    this.lsH.dead();
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */