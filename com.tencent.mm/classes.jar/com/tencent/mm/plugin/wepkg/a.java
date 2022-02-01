package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.t;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static h XEj;
  private static boolean XEk = false;
  
  public static void Td()
  {
    AppMethodBeat.i(110514);
    Log.i("MicroMsg.CommJsLoader", "load");
    j.a(iEL(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).XFY;
        if (paramAnonymousBaseWepkgProcessTask == null)
        {
          Log.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if (paramAnonymousBaseWepkgProcessTask.version == null)
        {
          Log.e("MicroMsg.CommJsLoader", "version is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if ((a.iEN() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.iEN().XFY.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.XGM)
        {
          Log.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        g localg = i.b(a.iEL(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.XGK);
        if ((localg == null) || (Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!y.ZC(paramAnonymousBaseWepkgProcessTask.pkgPath)))
        {
          Log.e("MicroMsg.CommJsLoader", "path not exist");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        a.a(new h(paramAnonymousBaseWepkgProcessTask, localg, null));
        AppMethodBeat.o(110509);
      }
    });
    AppMethodBeat.o(110514);
  }
  
  public static void bnN(String paramString)
  {
    AppMethodBeat.i(110512);
    if (iEL().equals(paramString)) {
      XEk = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse bnO(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((e.iES() != 0) || (XEj == null))
    {
      Log.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = XEj.bop(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void dR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((iEL().equals(paramString)) && ((XEk) || (e.iEQ() == 0)))
    {
      XEk = false;
      if (paramBoolean) {
        Td();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static void dvc()
  {
    AppMethodBeat.i(110511);
    Td();
    AppMethodBeat.o(110511);
  }
  
  public static String iEL()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.IsN != null) {
      if (com.tencent.mm.plugin.game.commlib.a.IsN.CommJsLib == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.IsN.CommJsLib.IHV; !Util.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.fDQ();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String iEM()
  {
    if ((XEj != null) && (XEj.XFY != null)) {
      return XEj.XFY.version;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a
 * JD-Core Version:    0.7.0.1
 */