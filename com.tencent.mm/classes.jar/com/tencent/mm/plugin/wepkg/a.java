package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.o;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static g CZf;
  private static boolean CZg = false;
  
  public static void aEM(String paramString)
  {
    AppMethodBeat.i(110512);
    if (eIB().equals(paramString)) {
      CZg = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse aEN(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((b.eII() != 0) || (CZf == null))
    {
      ac.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = CZf.aFn(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void bYw()
  {
    AppMethodBeat.i(110511);
    tX();
    AppMethodBeat.o(110511);
  }
  
  public static void co(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((eIB().equals(paramString)) && ((CZg) || (b.eIG() == 0)))
    {
      CZg = false;
      if (paramBoolean) {
        tX();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String eIB()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.sWd != null) {
      if (com.tencent.mm.plugin.game.commlib.a.sWd.tjD == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.sWd.tjD.thZ; !bs.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.cOt();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String eIC()
  {
    if ((CZf != null) && (CZf.DaU != null)) {
      return CZf.DaU.version;
    }
    return "";
  }
  
  public static void tX()
  {
    AppMethodBeat.i(110514);
    ac.i("MicroMsg.CommJsLoader", "load");
    com.tencent.mm.plugin.wepkg.model.i.a(eIB(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).DaU;
        if (paramAnonymousBaseWepkgProcessTask == null)
        {
          ac.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if (paramAnonymousBaseWepkgProcessTask.version == null)
        {
          ac.e("MicroMsg.CommJsLoader", "version is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if ((a.eID() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.eID().DaU.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.DbJ)
        {
          ac.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          AppMethodBeat.o(110509);
          return;
        }
        f localf = h.b(a.eIB(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.DbH);
        if ((localf == null) || (bs.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!com.tencent.mm.vfs.i.eA(paramAnonymousBaseWepkgProcessTask.pkgPath)))
        {
          ac.e("MicroMsg.CommJsLoader", "path not exist");
          AppMethodBeat.o(110509);
          return;
        }
        a.a(new g(paramAnonymousBaseWepkgProcessTask, localf, null));
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