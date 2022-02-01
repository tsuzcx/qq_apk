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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceResponse;

public final class a
{
  private static g BGY;
  private static boolean BGZ = false;
  
  public static void azv(String paramString)
  {
    AppMethodBeat.i(110512);
    if (eti().equals(paramString)) {
      BGZ = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse azw(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((b.etp() != 0) || (BGY == null))
    {
      ad.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = BGY.azV(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void bRh()
  {
    AppMethodBeat.i(110511);
    tP();
    AppMethodBeat.o(110511);
  }
  
  public static void ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((eti().equals(paramString)) && ((BGZ) || (b.etn() == 0)))
    {
      BGZ = false;
      if (paramBoolean) {
        tP();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String eti()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.rOm != null) {
      if (com.tencent.mm.plugin.game.commlib.a.rOm.sbJ == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.rOm.sbJ.sag; !bt.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.cBk();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String etj()
  {
    if ((BGY != null) && (BGY.BIL != null)) {
      return BGY.BIL.version;
    }
    return "";
  }
  
  public static void tP()
  {
    AppMethodBeat.i(110514);
    ad.i("MicroMsg.CommJsLoader", "load");
    com.tencent.mm.plugin.wepkg.model.i.a(eti(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).BIL;
        if (paramAnonymousBaseWepkgProcessTask == null)
        {
          ad.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if (paramAnonymousBaseWepkgProcessTask.version == null)
        {
          ad.e("MicroMsg.CommJsLoader", "version is null");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        if ((a.etk() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.etk().BIL.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.BJA)
        {
          ad.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          AppMethodBeat.o(110509);
          return;
        }
        f localf = h.b(a.eti(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.BJy);
        if ((localf == null) || (bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!com.tencent.mm.vfs.i.eK(paramAnonymousBaseWepkgProcessTask.pkgPath)))
        {
          ad.e("MicroMsg.CommJsLoader", "path not exist");
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