package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.i.d.a;
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
  implements bd, d.a
{
  private a FJC;
  private c FJD;
  Map<String, Integer> FJE;
  private o.a appForegroundListener;
  private IListener gmC;
  
  public d()
  {
    AppMethodBeat.i(28881);
    this.FJC = null;
    this.FJD = null;
    this.FJE = new HashMap();
    this.appForegroundListener = new d.1(this);
    this.gmC = new d.2(this);
    Log.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + Util.getStack());
    AppMethodBeat.o(28881);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(28890);
    g.aAf().azk();
    d locald = fsQ();
    if (locald.FJD == null) {
      locald.FJD = c.fsN();
    }
    Log.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { locald.FJD.aBz(), paramc.aBz() });
    if (!paramc.a(locald.FJD))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      AppMethodBeat.o(28890);
      return;
    }
    if ((!Util.isNullOrNil(paramc.FJp)) || (paramc.FJo))
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327939, "1");
    }
    if (paramc.FJn)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327938, "1");
    }
    for (;;)
    {
      locald.FJD = paramc;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327942, paramc.dWG);
      locald.fsW();
      g.aAh().azQ().set(ar.a.Ojv, Boolean.TRUE);
      AppMethodBeat.o(28890);
      return;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327938, "");
    }
  }
  
  public static String fO(String paramString, int paramInt)
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
  
  public static d fsQ()
  {
    AppMethodBeat.i(28882);
    d locald2 = (d)com.tencent.mm.pluginsdk.i.d.JYo;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      com.tencent.mm.pluginsdk.i.d.JYo = locald1;
    }
    AppMethodBeat.o(28882);
    return locald1;
  }
  
  public static boolean fsR()
  {
    AppMethodBeat.i(28885);
    bg.aVF();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.azQ().get(327939, ""));
    AppMethodBeat.o(28885);
    return bool;
  }
  
  public static boolean fsS()
  {
    AppMethodBeat.i(28886);
    bg.aVF();
    boolean bool = "1".equals((String)com.tencent.mm.model.c.azQ().get(327938, ""));
    AppMethodBeat.o(28886);
    return bool;
  }
  
  public static void fsT()
  {
    AppMethodBeat.i(28887);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(327938, "");
    AppMethodBeat.o(28887);
  }
  
  public static void fsU()
  {
    AppMethodBeat.i(28888);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(327939, "");
    AppMethodBeat.o(28888);
  }
  
  private void fsW()
  {
    AppMethodBeat.i(28891);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28880);
        lb locallb = new lb();
        EventCenter.instance.publish(locallb);
        AppMethodBeat.o(28880);
      }
    });
    AppMethodBeat.o(28891);
  }
  
  public static void fsX()
  {
    AppMethodBeat.i(28892);
    if (bg.aAc())
    {
      fsQ();
      if (!fsR())
      {
        fsQ();
        if (!fsS()) {}
      }
      else
      {
        c localc = fsQ().fsV();
        if (((!Util.isNullOrNil(localc.FJp)) || (localc.FJo)) && (localc.dMp()))
        {
          Log.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
          fsQ();
          fsT();
          fsQ();
          fsU();
          fsQ().fsW();
        }
      }
    }
    AppMethodBeat.o(28892);
  }
  
  public static String fsZ()
  {
    AppMethodBeat.i(28895);
    String str;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      str = h.aqJ().getValue("JDEntranceConfigName");
    }
    for (;;)
    {
      AppMethodBeat.o(28895);
      return str;
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        str = h.aqJ().getValue("JDEntranceConfigNameHKTW");
      } else {
        str = h.aqJ().getValue("JDEntranceConfigNameEN");
      }
    }
  }
  
  public static String fta()
  {
    AppMethodBeat.i(28896);
    String str = h.aqJ().getValue("JDEntranceConfigJumpUrl");
    AppMethodBeat.o(28896);
    return str;
  }
  
  private static b ftb()
  {
    AppMethodBeat.i(232066);
    b localb = new b();
    localb.username = h.aqJ().getValue("JDEntranceConfigJumpWeAppUsername");
    localb.path = h.aqJ().getValue("JDEntranceConfigJumpWeAppPath");
    localb.version = h.aqJ().getInt("JDEntranceConfigJumpWeAppVersion", 0);
    AppMethodBeat.o(232066);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final c fsV()
  {
    AppMethodBeat.i(28889);
    if (this.FJD == null) {
      this.FJD = c.fsN();
    }
    c localc = this.FJD;
    AppMethodBeat.o(28889);
    return localc;
  }
  
  public final boolean fsY()
  {
    AppMethodBeat.i(28894);
    String str1 = fsZ();
    String str2 = fta();
    String str3 = h.aqJ().getValue("JDEntranceConfigJumpWeAppUsername");
    if ((!Util.isNullOrNil(str1)) && ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str3))))
    {
      AppMethodBeat.o(28894);
      return true;
    }
    AppMethodBeat.o(28894);
    return false;
  }
  
  public final String ftc()
  {
    int j = 1;
    AppMethodBeat.i(28897);
    Object localObject2 = "";
    c localc = fsV();
    int i = j;
    Object localObject1 = localObject2;
    if (fsR())
    {
      if ((localc.dMp()) || (!"3".equals(localc.FJl)) || (Util.isNullOrNil(localc.jumpUrl))) {
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
      if ("2".equals(localc.FJl))
      {
        j = i;
        localObject2 = localObject1;
        if (!Util.isNullOrNil(localc.jumpUrl))
        {
          j = i;
          localObject2 = localObject1;
          if (localc.fsO())
          {
            j = i;
            localObject2 = localObject1;
            if (!localc.fsP())
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
      localObject1 = fO((String)localObject2, j);
      AppMethodBeat.o(28897);
      return localObject1;
      label184:
      i = j;
      localObject1 = localObject2;
      if (localc.FJo)
      {
        i = 2;
        localObject1 = localObject2;
      }
    }
    localObject1 = fta();
    AppMethodBeat.o(28897);
    return localObject1;
  }
  
  public final b ftd()
  {
    AppMethodBeat.i(28898);
    b localb = new b();
    Object localObject = fsV();
    if ((fsR()) && (!((c)localObject).dMp()) && ("3".equals(((c)localObject).FJl)))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).FJl, ((c)localObject).FJz, ((c)localObject).FJA, Integer.valueOf(((c)localObject).FJB) });
      localb.username = ((c)localObject).FJz;
      localb.path = ((c)localObject).FJA;
      localb.version = ((c)localObject).FJB;
    }
    if (("2".equals(((c)localObject).FJl)) && (((c)localObject).fsO()) && (!((c)localObject).fsP()))
    {
      Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", new Object[] { ((c)localObject).FJl, ((c)localObject).FJz, ((c)localObject).FJA, Integer.valueOf(((c)localObject).FJB) });
      localb.username = ((c)localObject).FJz;
      localb.path = ((c)localObject).FJA;
      localb.version = ((c)localObject).FJB;
    }
    localObject = localb;
    if (!localb.isValid()) {
      localObject = ftb();
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
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.FJC == null) {
      this.FJC = new a();
    }
    this.appForegroundListener.alive();
    bg.getSysCmdMsgExtension().a("jd", this.FJC, true);
    EventCenter.instance.addListener(this.gmC);
    AppMethodBeat.o(28883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28884);
    Log.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    this.appForegroundListener.dead();
    if (this.FJC != null)
    {
      a locala = this.FJC;
      EventCenter.instance.removeListener(locala.FJi);
      bg.getSysCmdMsgExtension().b("jd", this.FJC, true);
    }
    this.FJE.clear();
    this.FJC = null;
    EventCenter.instance.removeListener(this.gmC);
    AppMethodBeat.o(28884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d
 * JD-Core Version:    0.7.0.1
 */