package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.r;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static h JLr;
  private static boolean JLs = false;
  
  public static void bbZ(String paramString)
  {
    AppMethodBeat.i(110512);
    if (gkm().equals(paramString)) {
      JLs = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse bca(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((d.gkt() != 0) || (JLr == null))
    {
      Log.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = JLr.bcB(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void cCf()
  {
    AppMethodBeat.i(110511);
    vC();
    AppMethodBeat.o(110511);
  }
  
  public static void cT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((gkm().equals(paramString)) && ((JLs) || (d.gkr() == 0)))
    {
      JLs = false;
      if (paramBoolean) {
        vC();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String gkm()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
      if (com.tencent.mm.plugin.game.commlib.a.xvl.CommJsLib == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.xvl.CommJsLib.xJD; !Util.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.dSS();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String gkn()
  {
    if ((JLr != null) && (JLr.JNh != null)) {
      return JLr.JNh.version;
    }
    return "";
  }
  
  public static void vC()
  {
    AppMethodBeat.i(110514);
    Log.i("MicroMsg.CommJsLoader", "load");
    j.a(gkm(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).JNh;
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
        if ((a.gko() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.gko().JNh.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.JNV)
        {
          Log.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        g localg = i.a(a.gkm(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.JNT);
        if ((localg == null) || (Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!s.YS(paramAnonymousBaseWepkgProcessTask.pkgPath)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a
 * JD-Core Version:    0.7.0.1
 */