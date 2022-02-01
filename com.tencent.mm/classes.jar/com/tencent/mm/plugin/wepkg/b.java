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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static Map<String, g> BHd;
  private static int BHe;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    BHd = new HashMap();
    enable = true;
    BHe = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void Mf(String paramString)
  {
    AppMethodBeat.i(110527);
    BHd.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  public static String azA(String paramString)
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
  
  public static String azB(String paramString)
  {
    AppMethodBeat.i(110533);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(bt.nullAsNil(a.eti())))
    {
      paramString = a.etj();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (g)BHd.get(paramString);
    if ((paramString != null) && (paramString.BIL != null))
    {
      paramString = paramString.BIL.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  private static boolean azx(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!AppBrandMainProcessService.aXf())
    {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, d.aAg(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static g azy(String paramString)
  {
    AppMethodBeat.i(192615);
    if ((bt.isNullOrNil(paramString)) || (!BHd.containsKey(paramString)))
    {
      AppMethodBeat.o(192615);
      return null;
    }
    paramString = (g)BHd.get(paramString);
    AppMethodBeat.o(192615);
    return paramString;
  }
  
  public static g azz(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = d.aAg(paramString);
    if (BHd.containsKey(str1))
    {
      g localg = (g)BHd.get(str1);
      String str2 = d.aAh(paramString);
      if ((localg != null) && (localg.BIL != null) && (str2.equalsIgnoreCase(localg.BIL.BJx)))
      {
        ad.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localg.BIL.fUW, localg.BIL.version });
        AppMethodBeat.o(110530);
        return localg;
      }
    }
    paramString = com.tencent.mm.plugin.wepkg.model.h.azX(paramString);
    if (paramString.etJ()) {
      BHd.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static void bRh()
  {
    AppMethodBeat.i(110522);
    etl();
    a.bRh();
    AppMethodBeat.o(110522);
  }
  
  public static g cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    ad.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!azx(paramString))
    {
      ad.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.h.vKh.dB(859, 36);
      paramString = new g(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = etp();
    if (i != 0)
    {
      ad.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new g(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = d.aAg(paramString);
    if (paramBoolean)
    {
      ad.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      d.bNl().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.BHf;
          HashSet localHashSet = new HashSet();
          if (!bt.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!bt.isNullOrNil(a.eti())) {
            localHashSet.add(a.eti());
          }
          WepkgVersionUpdater.a(localHashSet, 0, false);
          AppMethodBeat.o(110521);
        }
      });
    }
    if (bt.isNullOrNil(str))
    {
      paramString = new g(9, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    paramString = azz(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void etl()
  {
    AppMethodBeat.i(110523);
    if (!AppBrandMainProcessService.aXf()) {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void etm()
  {
    AppMethodBeat.i(110525);
    if (BHe == 0) {
      a.tP();
    }
    BHe += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int etn()
  {
    return BHe;
  }
  
  public static void eto()
  {
    AppMethodBeat.i(110526);
    int i = BHe - 1;
    BHe = i;
    if (i == 0)
    {
      BHd.clear();
      a.tP();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int etp()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.cBn())
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
  
  public static void etq()
  {
    enable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */