package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static Map<String, com.tencent.mm.plugin.wepkg.model.g> EDj;
  private static int EDk;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    EDj = new HashMap();
    enable = true;
    EDk = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void TT(String paramString)
  {
    AppMethodBeat.i(110527);
    EDj.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  private static boolean aKo(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!AppBrandMainProcessService.bhH())
    {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g aKp(String paramString)
  {
    AppMethodBeat.i(214445);
    if ((bt.isNullOrNil(paramString)) || (!EDj.containsKey(paramString)))
    {
      AppMethodBeat.o(214445);
      return null;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.g)EDj.get(paramString);
    AppMethodBeat.o(214445);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g aKq(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
    if (EDj.containsKey(str1))
    {
      com.tencent.mm.plugin.wepkg.model.g localg = (com.tencent.mm.plugin.wepkg.model.g)EDj.get(str1);
      String str2 = com.tencent.mm.plugin.wepkg.utils.d.aKZ(paramString);
      if ((localg != null) && (localg.EET != null) && (str2.equalsIgnoreCase(localg.EET.EFF)))
      {
        ad.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localg.EET.gsn, localg.EET.version });
        AppMethodBeat.o(110530);
        return localg;
      }
    }
    paramString = h.aKP(paramString);
    if (paramString.eXV()) {
      EDj.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static String aKr(String paramString)
  {
    AppMethodBeat.i(110532);
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("wepkg_rid");
      AppMethodBeat.o(110532);
      return str;
    }
    catch (Exception localException)
    {
      ad.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
      AppMethodBeat.o(110532);
    }
    return null;
  }
  
  public static String aKs(String paramString)
  {
    AppMethodBeat.i(110533);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(bt.nullAsNil(a.eXu())))
    {
      paramString = a.eXv();
      AppMethodBeat.o(110533);
      return paramString;
    }
    if (paramString.equals("jscore_lib"))
    {
      if (b.EDd == null)
      {
        AppMethodBeat.o(110533);
        return null;
      }
      paramString = b.EDd.eXF();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.g)EDj.get(paramString);
    if ((paramString != null) && (paramString.EET != null))
    {
      paramString = paramString.EET.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  public static void cda()
  {
    AppMethodBeat.i(110522);
    eXx();
    a.cda();
    AppMethodBeat.o(110522);
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g cv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    ad.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!aKo(paramString))
    {
      ad.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.g.yhR.dD(859, 36);
      paramString = new com.tencent.mm.plugin.wepkg.model.g(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = eXB();
    if (i != 0)
    {
      ad.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new com.tencent.mm.plugin.wepkg.model.g(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
    if (paramBoolean)
    {
      ad.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.wepkg.utils.d.bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.EDl;
          HashSet localHashSet = new HashSet();
          if (!bt.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!bt.isNullOrNil(a.eXu())) {
            localHashSet.add(a.eXu());
          }
          WepkgVersionUpdater.a(localHashSet, 0, false);
          AppMethodBeat.o(110521);
        }
      });
    }
    if (bt.isNullOrNil(str))
    {
      paramString = new com.tencent.mm.plugin.wepkg.model.g(9, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    paramString = aKq(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void eXA()
  {
    AppMethodBeat.i(110526);
    int i = EDk - 1;
    EDk = i;
    if (i == 0)
    {
      EDj.clear();
      a.vw();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int eXB()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.cWR())
    {
      ad.i("MicroMsg.WePkgLoader", "config wepkg disable");
      enable = false;
      AppMethodBeat.o(184498);
      return 12;
    }
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("we_pkg_sp", 4);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
    {
      ad.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
      enable = false;
      AppMethodBeat.o(184498);
      return 11;
    }
    AppMethodBeat.o(184498);
    return 0;
  }
  
  public static void eXC()
  {
    enable = false;
  }
  
  public static void eXx()
  {
    AppMethodBeat.i(110523);
    if (!AppBrandMainProcessService.bhH()) {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void eXy()
  {
    AppMethodBeat.i(110525);
    if (EDk == 0) {
      a.vw();
    }
    EDk += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int eXz()
  {
    return EDk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */