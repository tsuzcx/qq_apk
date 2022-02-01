package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static int JLA;
  private static Map<String, com.tencent.mm.plugin.wepkg.model.h> JLz;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    JLz = new HashMap();
    enable = true;
    JLA = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void aer(String paramString)
  {
    AppMethodBeat.i(110527);
    JLz.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  private static boolean bcb(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!AppBrandMainProcessService.isLive())
    {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h bcc(String paramString)
  {
    AppMethodBeat.i(200145);
    if ((Util.isNullOrNil(paramString)) || (!JLz.containsKey(paramString)))
    {
      AppMethodBeat.o(200145);
      return null;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.h)JLz.get(paramString);
    AppMethodBeat.o(200145);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h bcd(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
    if (JLz.containsKey(str1))
    {
      com.tencent.mm.plugin.wepkg.model.h localh = (com.tencent.mm.plugin.wepkg.model.h)JLz.get(str1);
      String str2 = com.tencent.mm.plugin.wepkg.utils.d.bcP(paramString);
      if ((localh != null) && (localh.JNh != null) && (str2.equalsIgnoreCase(localh.JNh.domain)))
      {
        Log.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localh.JNh.hhD, localh.JNh.version });
        AppMethodBeat.o(110530);
        return localh;
      }
    }
    paramString = i.bcF(paramString);
    if (paramString.dTL()) {
      JLz.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static String bce(String paramString)
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
      Log.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
      AppMethodBeat.o(110532);
    }
    return null;
  }
  
  public static String bcf(String paramString)
  {
    AppMethodBeat.i(110533);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(Util.nullAsNil(a.gkm())))
    {
      paramString = a.gkn();
      AppMethodBeat.o(110533);
      return paramString;
    }
    if (paramString.equals("jscore_lib"))
    {
      paramString = b.gkn();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.h)JLz.get(paramString);
    if ((paramString != null) && (paramString.JNh != null))
    {
      paramString = paramString.JNh.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  public static void cCf()
  {
    AppMethodBeat.i(110522);
    gkp();
    a.cCf();
    AppMethodBeat.o(110522);
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h cU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    Log.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!bcb(paramString))
    {
      Log.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.h.CyF.dN(859, 36);
      paramString = new com.tencent.mm.plugin.wepkg.model.h(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = gkt();
    if (i != 0)
    {
      Log.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new com.tencent.mm.plugin.wepkg.model.h(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
    if (paramBoolean)
    {
      Log.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.JLB;
          HashSet localHashSet = new HashSet();
          if (!Util.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!Util.isNullOrNil(a.gkm())) {
            localHashSet.add(a.gkm());
          }
          WepkgVersionUpdater.a(localHashSet, 0, false);
          AppMethodBeat.o(110521);
        }
      });
    }
    if (Util.isNullOrNil(str))
    {
      paramString = new com.tencent.mm.plugin.wepkg.model.h(9, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    paramString = bcd(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void gkp()
  {
    AppMethodBeat.i(110523);
    if (!AppBrandMainProcessService.isLive()) {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void gkq()
  {
    AppMethodBeat.i(110525);
    if (JLA == 0) {
      a.vC();
    }
    JLA += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int gkr()
  {
    return JLA;
  }
  
  public static void gks()
  {
    AppMethodBeat.i(110526);
    int i = JLA - 1;
    JLA = i;
    if (i == 0)
    {
      JLz.clear();
      a.vC();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int gkt()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.dSV())
    {
      Log.i("MicroMsg.WePkgLoader", "config wepkg disable");
      enable = false;
      AppMethodBeat.o(184498);
      return 12;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
    {
      Log.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
      enable = false;
      AppMethodBeat.o(184498);
      return 11;
    }
    AppMethodBeat.o(184498);
    return 0;
  }
  
  public static void gku()
  {
    enable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d
 * JD-Core Version:    0.7.0.1
 */