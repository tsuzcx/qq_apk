package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static boolean enable;
  private static Map<String, f> vEv;
  private static int vEw;
  
  static
  {
    AppMethodBeat.i(63363);
    vEv = new HashMap();
    enable = true;
    vEw = 0;
    AppMethodBeat.o(63363);
  }
  
  public static void Ey(String paramString)
  {
    AppMethodBeat.i(63356);
    vEv.remove(paramString);
    AppMethodBeat.o(63356);
  }
  
  private static boolean ake(String paramString)
  {
    AppMethodBeat.i(63353);
    if (!WepkgMainProcessService.isLive())
    {
      d.b("", new b.2());
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, d.akM(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Lq(10));
      AppMethodBeat.o(63353);
      return false;
    }
    AppMethodBeat.o(63353);
    return true;
  }
  
  public static boolean akf(String paramString)
  {
    AppMethodBeat.i(63357);
    boolean bool = vEv.containsKey(paramString);
    AppMethodBeat.o(63357);
    return bool;
  }
  
  public static f akg(String paramString)
  {
    AppMethodBeat.i(63359);
    String str1 = d.akM(paramString);
    if (vEv.containsKey(str1))
    {
      f localf = (f)vEv.get(str1);
      String str2 = d.akN(paramString);
      if ((localf != null) && (localf.vGb != null) && (str2.equalsIgnoreCase(localf.vGb.vGN)))
      {
        ab.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { localf.vGb.ezY, localf.vGb.version });
        AppMethodBeat.o(63359);
        return localf;
      }
    }
    paramString = g.akD(paramString);
    if (paramString != null) {
      vEv.put(str1, paramString);
    }
    AppMethodBeat.o(63359);
    return paramString;
  }
  
  public static String akh(String paramString)
  {
    AppMethodBeat.i(63361);
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("wepkg_rid");
      AppMethodBeat.o(63361);
      return str;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
      AppMethodBeat.o(63361);
    }
    return null;
  }
  
  public static String aki(String paramString)
  {
    AppMethodBeat.i(63362);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63362);
      return "";
    }
    if (paramString.equals(bo.nullAsNil(a.dkb())))
    {
      paramString = a.dkc();
      AppMethodBeat.o(63362);
      return paramString;
    }
    paramString = (f)vEv.get(paramString);
    if ((paramString != null) && (paramString.vGb != null))
    {
      paramString = paramString.vGb.version;
      AppMethodBeat.o(63362);
      return paramString;
    }
    AppMethodBeat.o(63362);
    return "";
  }
  
  public static f bU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63358);
    ab.d("MicroMsg.WePkgLoader", "load, url: %s", new Object[] { paramString });
    if (!ake(paramString))
    {
      ab.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
      h.qsU.cT(859, 36);
      AppMethodBeat.o(63358);
      return null;
    }
    if (!enable())
    {
      ab.e("MicroMsg.WePkgLoader", "load enable false");
      AppMethodBeat.o(63358);
      return null;
    }
    String str = d.akM(paramString);
    if (paramBoolean)
    {
      ab.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      d.aNS().ac(new b.3(str));
    }
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(63358);
      return null;
    }
    paramString = akg(paramString);
    AppMethodBeat.o(63358);
    return paramString;
  }
  
  public static void bjT()
  {
    AppMethodBeat.i(63351);
    dke();
    a.bjT();
    AppMethodBeat.o(63351);
  }
  
  public static void dke()
  {
    AppMethodBeat.i(63352);
    if (!WepkgMainProcessService.isLive()) {
      d.b("", new b.1());
    }
    AppMethodBeat.o(63352);
  }
  
  public static void dkf()
  {
    AppMethodBeat.i(63354);
    if (vEw == 0) {
      a.ph();
    }
    vEw += 1;
    AppMethodBeat.o(63354);
  }
  
  public static int dkg()
  {
    return vEw;
  }
  
  public static void dkh()
  {
    AppMethodBeat.i(63355);
    int i = vEw - 1;
    vEw = i;
    if (i == 0)
    {
      vEv.clear();
      a.ph();
    }
    AppMethodBeat.o(63355);
  }
  
  public static void dki()
  {
    enable = false;
  }
  
  public static boolean enable()
  {
    AppMethodBeat.i(63360);
    if (!enable)
    {
      AppMethodBeat.o(63360);
      return false;
    }
    if (com.tencent.mm.plugin.game.commlib.a.bFd())
    {
      ab.i("MicroMsg.WePkgLoader", "config wepkg disable");
      enable = false;
      AppMethodBeat.o(63360);
      return false;
    }
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
    {
      ab.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
      enable = false;
      AppMethodBeat.o(63360);
      return false;
    }
    AppMethodBeat.o(63360);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */