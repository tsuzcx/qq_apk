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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static Map<String, com.tencent.mm.plugin.wepkg.model.g> EVF;
  private static int EVG;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    EVF = new HashMap();
    enable = true;
    EVG = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void UD(String paramString)
  {
    AppMethodBeat.i(110527);
    EVF.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  private static boolean aLK(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!AppBrandMainProcessService.bip())
    {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g aLL(String paramString)
  {
    AppMethodBeat.i(209373);
    if ((bu.isNullOrNil(paramString)) || (!EVF.containsKey(paramString)))
    {
      AppMethodBeat.o(209373);
      return null;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.g)EVF.get(paramString);
    AppMethodBeat.o(209373);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g aLM(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
    if (EVF.containsKey(str1))
    {
      com.tencent.mm.plugin.wepkg.model.g localg = (com.tencent.mm.plugin.wepkg.model.g)EVF.get(str1);
      String str2 = com.tencent.mm.plugin.wepkg.utils.d.aMv(paramString);
      if ((localg != null) && (localg.EXp != null) && (str2.equalsIgnoreCase(localg.EXp.EYb)))
      {
        ae.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localg.EXp.guO, localg.EXp.version });
        AppMethodBeat.o(110530);
        return localg;
      }
    }
    paramString = h.aMl(paramString);
    if (paramString.fbH()) {
      EVF.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static String aLN(String paramString)
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
      ae.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
      AppMethodBeat.o(110532);
    }
    return null;
  }
  
  public static String aLO(String paramString)
  {
    AppMethodBeat.i(110533);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(bu.nullAsNil(a.fbg())))
    {
      paramString = a.fbh();
      AppMethodBeat.o(110533);
      return paramString;
    }
    if (paramString.equals("jscore_lib"))
    {
      if (b.EVz == null)
      {
        AppMethodBeat.o(110533);
        return null;
      }
      paramString = b.EVz.fbr();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.g)EVF.get(paramString);
    if ((paramString != null) && (paramString.EXp != null))
    {
      paramString = paramString.EXp.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  public static void cep()
  {
    AppMethodBeat.i(110522);
    fbj();
    a.cep();
    AppMethodBeat.o(110522);
  }
  
  public static com.tencent.mm.plugin.wepkg.model.g cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    ae.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!aLK(paramString))
    {
      ae.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.g.yxI.dD(859, 36);
      paramString = new com.tencent.mm.plugin.wepkg.model.g(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = fbn();
    if (i != 0)
    {
      ae.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new com.tencent.mm.plugin.wepkg.model.g(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
    if (paramBoolean)
    {
      ae.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.wepkg.utils.d.caq().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.EVH;
          HashSet localHashSet = new HashSet();
          if (!bu.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!bu.isNullOrNil(a.fbg())) {
            localHashSet.add(a.fbg());
          }
          WepkgVersionUpdater.a(localHashSet, 0, false);
          AppMethodBeat.o(110521);
        }
      });
    }
    if (bu.isNullOrNil(str))
    {
      paramString = new com.tencent.mm.plugin.wepkg.model.g(9, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    paramString = aLM(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void fbj()
  {
    AppMethodBeat.i(110523);
    if (!AppBrandMainProcessService.bip()) {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void fbk()
  {
    AppMethodBeat.i(110525);
    if (EVG == 0) {
      a.vw();
    }
    EVG += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int fbl()
  {
    return EVG;
  }
  
  public static void fbm()
  {
    AppMethodBeat.i(110526);
    int i = EVG - 1;
    EVG = i;
    if (i == 0)
    {
      EVF.clear();
      a.vw();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int fbn()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.cZv())
    {
      ae.i("MicroMsg.WePkgLoader", "config wepkg disable");
      enable = false;
      AppMethodBeat.o(184498);
      return 12;
    }
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("we_pkg_sp", 4);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
    {
      ae.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
      enable = false;
      AppMethodBeat.o(184498);
      return 11;
    }
    AppMethodBeat.o(184498);
    return 0;
  }
  
  public static void fbo()
  {
    enable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */