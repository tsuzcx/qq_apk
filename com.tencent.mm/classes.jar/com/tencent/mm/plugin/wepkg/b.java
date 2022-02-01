package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static Map<String, g> CZl;
  private static int CZm;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    CZl = new HashMap();
    enable = true;
    CZm = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void Ql(String paramString)
  {
    AppMethodBeat.i(110527);
    CZl.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  private static boolean aEO(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!AppBrandMainProcessService.bed())
    {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, d.aFy(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Wj(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static g aEP(String paramString)
  {
    AppMethodBeat.i(199863);
    if ((bs.isNullOrNil(paramString)) || (!CZl.containsKey(paramString)))
    {
      AppMethodBeat.o(199863);
      return null;
    }
    paramString = (g)CZl.get(paramString);
    AppMethodBeat.o(199863);
    return paramString;
  }
  
  public static g aEQ(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = d.aFy(paramString);
    if (CZl.containsKey(str1))
    {
      g localg = (g)CZl.get(str1);
      String str2 = d.aFz(paramString);
      if ((localg != null) && (localg.DaU != null) && (str2.equalsIgnoreCase(localg.DaU.DbG)))
      {
        ac.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localg.DaU.fYR, localg.DaU.version });
        AppMethodBeat.o(110530);
        return localg;
      }
    }
    paramString = com.tencent.mm.plugin.wepkg.model.h.aFp(paramString);
    if (paramString.eJc()) {
      CZl.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static String aER(String paramString)
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
      ac.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
      AppMethodBeat.o(110532);
    }
    return null;
  }
  
  public static String aES(String paramString)
  {
    AppMethodBeat.i(110533);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(bs.nullAsNil(a.eIB())))
    {
      paramString = a.eIC();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (g)CZl.get(paramString);
    if ((paramString != null) && (paramString.DaU != null))
    {
      paramString = paramString.DaU.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  public static void bYw()
  {
    AppMethodBeat.i(110522);
    eIE();
    a.bYw();
    AppMethodBeat.o(110522);
  }
  
  public static g cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    ac.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!aEO(paramString))
    {
      ac.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.h.wUl.dB(859, 36);
      paramString = new g(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = eII();
    if (i != 0)
    {
      ac.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new g(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = d.aFy(paramString);
    if (paramBoolean)
    {
      ac.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      d.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.CZn;
          HashSet localHashSet = new HashSet();
          if (!bs.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!bs.isNullOrNil(a.eIB())) {
            localHashSet.add(a.eIB());
          }
          WepkgVersionUpdater.a(localHashSet, 0, false);
          AppMethodBeat.o(110521);
        }
      });
    }
    if (bs.isNullOrNil(str))
    {
      paramString = new g(9, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    paramString = aEQ(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void eIE()
  {
    AppMethodBeat.i(110523);
    if (!AppBrandMainProcessService.bed()) {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void eIF()
  {
    AppMethodBeat.i(110525);
    if (CZm == 0) {
      a.tX();
    }
    CZm += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int eIG()
  {
    return CZm;
  }
  
  public static void eIH()
  {
    AppMethodBeat.i(110526);
    int i = CZm - 1;
    CZm = i;
    if (i == 0)
    {
      CZl.clear();
      a.tX();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int eII()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.cOw())
    {
      ac.i("MicroMsg.WePkgLoader", "config wepkg disable");
      enable = false;
      AppMethodBeat.o(184498);
      return 12;
    }
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("we_pkg_sp", 4);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
    {
      ac.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
      enable = false;
      AppMethodBeat.o(184498);
      return 11;
    }
    AppMethodBeat.o(184498);
    return 0;
  }
  
  public static void eIJ()
  {
    enable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */