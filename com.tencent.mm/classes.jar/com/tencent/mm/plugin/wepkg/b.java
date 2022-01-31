package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static boolean bIU = true;
  private static Map<String, com.tencent.mm.plugin.wepkg.model.d> rNR = new HashMap();
  private static int rNS = 0;
  
  private static boolean UL(String paramString)
  {
    if (!WepkgMainProcessService.isLive())
    {
      com.tencent.mm.plugin.wepkg.utils.d.a("", new b.2());
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString), null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(10));
      return false;
    }
    return true;
  }
  
  public static com.tencent.mm.plugin.wepkg.model.d UM(String paramString)
  {
    String str1 = com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString);
    com.tencent.mm.plugin.wepkg.model.d locald;
    if (rNR.containsKey(str1))
    {
      locald = (com.tencent.mm.plugin.wepkg.model.d)rNR.get(str1);
      String str2 = com.tencent.mm.plugin.wepkg.utils.d.Vr(paramString);
      if ((locald != null) && (locald.rPj != null) && (str2.equalsIgnoreCase(locald.rPj.ceG)))
      {
        y.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", new Object[] { locald.rPj.dCD, locald.rPj.version });
        paramString = locald;
      }
    }
    do
    {
      return paramString;
      locald = e.Ve(paramString);
      paramString = locald;
    } while (locald == null);
    rNR.put(str1, locald);
    return locald;
  }
  
  public static String UN(String paramString)
  {
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("wepkg_rid");
      return str;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", new Object[] { paramString, localException.getMessage() });
    }
    return null;
  }
  
  public static String UO(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    if (paramString.equals(bk.pm(a.cjz()))) {
      return a.cjC();
    }
    paramString = (com.tencent.mm.plugin.wepkg.model.d)rNR.get(paramString);
    if ((paramString != null) && (paramString.rPj != null)) {
      return paramString.rPj.version;
    }
    return "";
  }
  
  public static void aGq()
  {
    if (!WepkgMainProcessService.isLive()) {
      com.tencent.mm.plugin.wepkg.utils.d.a("", new b.1());
    }
    a.aGq();
  }
  
  public static com.tencent.mm.plugin.wepkg.model.d bt(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (!UL(paramString)) {
      y.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
    }
    Object localObject;
    do
    {
      return null;
      if (!bIU) {}
      while (i == 0)
      {
        y.e("MicroMsg.WePkgLoader", "load enable false");
        return null;
        if (com.tencent.mm.plugin.game.commlib.a.aYo())
        {
          y.i("MicroMsg.WePkgLoader", "config wepkg disable");
          bIU = false;
        }
        else
        {
          localObject = ae.getContext().getSharedPreferences("we_pkg_sp", 4);
          if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false)))
          {
            y.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
            bIU = false;
          }
          else
          {
            i = 1;
          }
        }
      }
      localObject = com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString);
      if (paramBoolean) {
        com.tencent.mm.plugin.wepkg.utils.d.DS().O(new b.3((String)localObject));
      }
    } while (bk.bl((String)localObject));
    return UM(paramString);
  }
  
  public static void cjE()
  {
    if (rNS == 0) {
      a.mT();
    }
    rNS += 1;
  }
  
  public static int cjF()
  {
    return rNS;
  }
  
  public static void cjG()
  {
    int i = rNS - 1;
    rNS = i;
    if (i == 0)
    {
      rNR.clear();
      a.mT();
    }
  }
  
  public static void cjH()
  {
    bIU = false;
  }
  
  public static void vW(String paramString)
  {
    rNR.remove(Integer.valueOf(paramString.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */