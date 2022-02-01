package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static Map<String, com.tencent.mm.plugin.wepkg.model.h> QKS;
  private static int QKT;
  private static boolean enable;
  
  static
  {
    AppMethodBeat.i(110534);
    QKS = new HashMap();
    enable = true;
    QKT = 0;
    AppMethodBeat.o(110534);
  }
  
  public static void aml(String paramString)
  {
    AppMethodBeat.i(110527);
    QKS.remove(paramString);
    AppMethodBeat.o(110527);
  }
  
  private static boolean bob(String paramString)
  {
    AppMethodBeat.i(110524);
    if (!com.tencent.mm.plugin.appbrand.ipc.b.isLive())
    {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, d.boN(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(10));
      AppMethodBeat.o(110524);
      return false;
    }
    AppMethodBeat.o(110524);
    return true;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h boc(String paramString)
  {
    AppMethodBeat.i(195212);
    if ((Util.isNullOrNil(paramString)) || (!QKS.containsKey(paramString)))
    {
      AppMethodBeat.o(195212);
      return null;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.h)QKS.get(paramString);
    AppMethodBeat.o(195212);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h bod(String paramString)
  {
    AppMethodBeat.i(110530);
    String str1 = d.boN(paramString);
    if (QKS.containsKey(str1))
    {
      com.tencent.mm.plugin.wepkg.model.h localh = (com.tencent.mm.plugin.wepkg.model.h)QKS.get(str1);
      String str2 = d.boO(paramString);
      if ((localh != null) && (localh.QMA != null) && (str2.equalsIgnoreCase(localh.QMA.domain)))
      {
        Log.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localh.QMA.jTB, localh.QMA.version });
        AppMethodBeat.o(110530);
        return localh;
      }
    }
    paramString = i.boE(paramString);
    if (paramString.ewT()) {
      QKS.put(str1, paramString);
    }
    AppMethodBeat.o(110530);
    return paramString;
  }
  
  public static String boe(String paramString)
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
  
  public static String bof(String paramString)
  {
    AppMethodBeat.i(110533);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110533);
      return "";
    }
    if (paramString.equals(Util.nullAsNil(a.hed())))
    {
      paramString = a.hee();
      AppMethodBeat.o(110533);
      return paramString;
    }
    if (paramString.equals("jscore_lib"))
    {
      paramString = b.hee();
      AppMethodBeat.o(110533);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.h)QKS.get(paramString);
    if ((paramString != null) && (paramString.QMA != null))
    {
      paramString = paramString.QMA.version;
      AppMethodBeat.o(110533);
      return paramString;
    }
    AppMethodBeat.o(110533);
    return "";
  }
  
  public static void cQJ()
  {
    AppMethodBeat.i(110522);
    heg();
    a.cQJ();
    AppMethodBeat.o(110522);
  }
  
  public static com.tencent.mm.plugin.wepkg.model.h di(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110529);
    Log.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!bob(paramString))
    {
      Log.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      com.tencent.mm.plugin.report.service.h.IzE.el(859, 36);
      paramString = new com.tencent.mm.plugin.wepkg.model.h(10, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    int i = hek();
    if (i != 0)
    {
      Log.e("MicroMsg.WePkgLoader", "load enable false");
      paramString = new com.tencent.mm.plugin.wepkg.model.h(i, false, "");
      AppMethodBeat.o(110529);
      return paramString;
    }
    String str = d.boN(paramString);
    if (paramBoolean)
    {
      Log.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      d.cMC().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110521);
          String str = this.QKU;
          HashSet localHashSet = new HashSet();
          if (!Util.isNullOrNil(str)) {
            localHashSet.add(str);
          }
          if (!Util.isNullOrNil(a.hed())) {
            localHashSet.add(a.hed());
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
    paramString = bod(paramString);
    AppMethodBeat.o(110529);
    return paramString;
  }
  
  public static void heg()
  {
    AppMethodBeat.i(110523);
    if (!com.tencent.mm.plugin.appbrand.ipc.b.isLive()) {
      d.b("", new com.tencent.mm.plugin.wepkg.model.a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
      });
    }
    AppMethodBeat.o(110523);
  }
  
  public static void heh()
  {
    AppMethodBeat.i(110525);
    if (QKT == 0) {
      a.tA();
    }
    QKT += 1;
    AppMethodBeat.o(110525);
  }
  
  public static int hei()
  {
    return QKT;
  }
  
  public static void hej()
  {
    AppMethodBeat.i(110526);
    int i = QKT - 1;
    QKT = i;
    if (i == 0)
    {
      QKS.clear();
      a.tA();
    }
    AppMethodBeat.o(110526);
  }
  
  public static int hek()
  {
    AppMethodBeat.i(184498);
    if (!enable)
    {
      AppMethodBeat.o(184498);
      return 12;
    }
    if (com.tencent.mm.plugin.game.commlib.a.ewd())
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
  
  public static void hel()
  {
    enable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.e
 * JD-Core Version:    0.7.0.1
 */