package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bb;
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
  private static g EDb;
  private static boolean EDc = false;
  
  public static void aKm(String paramString)
  {
    AppMethodBeat.i(110512);
    if (eXu().equals(paramString)) {
      EDc = true;
    }
    AppMethodBeat.o(110512);
  }
  
  public static WebResourceResponse aKn(String paramString)
  {
    AppMethodBeat.i(110515);
    if ((c.eXB() != 0) || (EDb == null))
    {
      ad.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(110515);
      return null;
    }
    paramString = EDb.aKM(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(110515);
      return paramString;
    }
    AppMethodBeat.o(110515);
    return null;
  }
  
  public static void cda()
  {
    AppMethodBeat.i(110511);
    vw();
    AppMethodBeat.o(110511);
  }
  
  public static void cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110513);
    if ((eXu().equals(paramString)) && ((EDc) || (c.eXz() == 0)))
    {
      EDc = false;
      if (paramBoolean) {
        vw();
      }
    }
    AppMethodBeat.o(110513);
  }
  
  public static String eXu()
  {
    AppMethodBeat.i(110510);
    if (com.tencent.mm.plugin.game.commlib.a.tSI != null) {
      if (com.tencent.mm.plugin.game.commlib.a.tSI.uhD == null) {
        break label47;
      }
    }
    label47:
    for (String str = com.tencent.mm.plugin.game.commlib.a.tSI.uhD.ufQ; !bt.isNullOrNil(str); str = null)
    {
      AppMethodBeat.o(110510);
      return str;
      com.tencent.mm.plugin.game.commlib.a.cWO();
    }
    AppMethodBeat.o(110510);
    return "commlib";
  }
  
  public static String eXv()
  {
    if ((EDb != null) && (EDb.EET != null)) {
      return EDb.EET.version;
    }
    return "";
  }
  
  public static void vw()
  {
    AppMethodBeat.i(110514);
    ad.i("MicroMsg.CommJsLoader", "load");
    com.tencent.mm.plugin.wepkg.model.i.a(eXu(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110509);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).EET;
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
        if ((a.eXw() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.eXw().EET.version)))
        {
          AppMethodBeat.o(110509);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.EFI)
        {
          ad.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          a.a(null);
          AppMethodBeat.o(110509);
          return;
        }
        f localf = h.b(a.eXu(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.pkgPath, paramAnonymousBaseWepkgProcessTask.md5, paramAnonymousBaseWepkgProcessTask.EFG);
        if ((localf == null) || (bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)) || (!com.tencent.mm.vfs.i.fv(paramAnonymousBaseWepkgProcessTask.pkgPath)))
        {
          ad.e("MicroMsg.CommJsLoader", "path not exist");
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