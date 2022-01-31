package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;

public final class a
{
  private static final String rNM = com.tencent.mm.loader.a.b.dOP + "wepkg/";
  private static com.tencent.mm.plugin.wepkg.model.d rNN;
  
  public static qp Dv(int paramInt)
  {
    if (bk.bl(cjz())) {}
    qp localqp;
    do
    {
      return null;
      localqp = new qp();
      localqp.kSE = cjz();
      if ((rNN == null) || (rNN.rPj == null)) {
        break;
      }
    } while (com.tencent.mm.plugin.wepkg.utils.d.aqv() < rNN.rPj.rPX);
    WepkgVersionUpdater.Vv(cjz());
    for (localqp.hQE = rNN.rPj.version;; localqp.hQE = "")
    {
      localqp.pyo = paramInt;
      return localqp;
    }
  }
  
  private static m UK(String paramString)
  {
    return new m("", "utf-8", new a.2(paramString));
  }
  
  public static void aGq()
  {
    com.tencent.mm.plugin.wepkg.event.b.a(new a.1());
  }
  
  public static String cjA()
  {
    return rNM + "/" + cjz() + "/";
  }
  
  public static String cjB()
  {
    return rNM;
  }
  
  public static String cjC()
  {
    if ((rNN != null) && (rNN.rPj != null)) {
      return rNN.rPj.version;
    }
    return "";
  }
  
  public static String cjz()
  {
    String str = com.tencent.mm.plugin.game.commlib.a.aYp();
    if (!bk.bl(str)) {
      return str;
    }
    return "commlib";
  }
  
  public static m fJ(String paramString1, String paramString2)
  {
    if (rNN == null)
    {
      y.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      paramString2 = UK(paramString1);
    }
    m localm;
    do
    {
      return paramString2;
      localm = rNN.Vd(paramString2);
      paramString2 = localm;
    } while (localm != null);
    return UK(paramString1);
  }
  
  public static void mT()
  {
    WepkgVersion localWepkgVersion = f.Vk(cjz());
    if (localWepkgVersion == null)
    {
      y.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
      rNN = null;
    }
    do
    {
      return;
      if (localWepkgVersion.version == null)
      {
        y.e("MicroMsg.CommJsLoader", "version is null");
        rNN = null;
        return;
      }
    } while ((rNN != null) && (localWepkgVersion.version.equals(rNN.rPj.version)));
    if (!localWepkgVersion.rPY)
    {
      y.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
      return;
    }
    c localc = com.tencent.mm.plugin.wepkg.model.e.a(cjz(), localWepkgVersion.version, localWepkgVersion.fCl, localWepkgVersion.bIW, localWepkgVersion.rPW);
    if ((localc == null) || (bk.bl(localWepkgVersion.fCl)) || (!com.tencent.mm.a.e.bK(localWepkgVersion.fCl)))
    {
      y.e("MicroMsg.CommJsLoader", "path not exist");
      return;
    }
    rNN = new com.tencent.mm.plugin.wepkg.model.d(localWepkgVersion, localc, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a
 * JD-Core Version:    0.7.0.1
 */