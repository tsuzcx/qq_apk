package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.s;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static h QKK;
  private static boolean QKL = false;
  
  public static void bnZ(String paramString)
  {
    AppMethodBeat.i(110512);
    if (hed().equals(paramString)) {
      QKL = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse boa(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((e.hek() != 0) || (QKK == null))
    {
      Log.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = QKK.boB(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void cQJ()
  {
    AppMethodBeat.i(110511);
    tA();
    AppMethodBeat.o(110511);
  }
  
  public static void dh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((hed().equals(paramString)) && ((QKL) || (e.hei() == 0)))
    {
      QKL = false;
      if (paramBoolean) {
        tA();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String hed()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.Czb != null) {
      if (com.tencent.mm.plugin.game.commlib.a.Czb.CommJsLib == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.Czb.CommJsLib.CNL; !Util.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.ewa();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String hee()
  {
    if ((QKK != null) && (QKK.QMA != null)) {
      return QKK.QMA.version;
    }
    return "";
  }
  
  public static void tA()
  {
    AppMethodBeat.i(110514);
    Log.i("MicroMsg.CommJsLoader", "load");
    j.a(hed(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).QMA;
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
        if ((a.hef() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.hef().QMA.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.QNo)
        {
          Log.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        g localg = i.a(a.hed(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.QNm);
        if ((localg == null) || (Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!u.agG(paramAnonymousBaseWepkgProcessTask.pkgPath)))
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