package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static g EVx;
  private static boolean EVy = false;
  
  public static void aLI(String paramString)
  {
    AppMethodBeat.i(110512);
    if (fbg().equals(paramString)) {
      EVy = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse aLJ(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((c.fbn() != 0) || (EVx == null))
    {
      ae.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = EVx.aMi(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void cep()
  {
    AppMethodBeat.i(110511);
    vw();
    AppMethodBeat.o(110511);
  }
  
  public static void cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((fbg().equals(paramString)) && ((EVy) || (c.fbl() == 0)))
    {
      EVy = false;
      if (paramBoolean) {
        vw();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String fbg()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.udz != null) {
      if (com.tencent.mm.plugin.game.commlib.a.udz.utb == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.udz.utb.urm; !bu.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.cZs();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String fbh()
  {
    if ((EVx != null) && (EVx.EXp != null)) {
      return EVx.EXp.version;
    }
    return "";
  }
  
  public static void vw()
  {
    AppMethodBeat.i(110514);
    ae.i("MicroMsg.CommJsLoader", "load");
    i.a(fbg(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).EXp;
        if (paramAnonymousBaseWepkgProcessTask == null)
        {
          ae.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if (paramAnonymousBaseWepkgProcessTask.version == null)
        {
          ae.e("MicroMsg.CommJsLoader", "version is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if ((a.fbi() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.fbi().EXp.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.EYe)
        {
          ae.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        f localf = h.b(a.fbg(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.EYc);
        if ((localf == null) || (bu.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!o.fB(paramAnonymousBaseWepkgProcessTask.pkgPath)))
        {
          ae.e("MicroMsg.CommJsLoader", "path not exist");
          a.a(null);
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