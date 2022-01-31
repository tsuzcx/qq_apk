package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;

public final class a
{
  private static f vEq;
  private static boolean vEr = false;
  
  public static void akc(String paramString)
  {
    AppMethodBeat.i(63341);
    if (dkb().equals(paramString)) {
      vEr = true;
    }
    AppMethodBeat.o(63341);
  }
  
  public static s akd(String paramString)
  {
    AppMethodBeat.i(63344);
    if ((!b.enable()) || (vEq == null))
    {
      ab.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
      AppMethodBeat.o(63344);
      return null;
    }
    paramString = vEq.akB(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(63344);
      return paramString;
    }
    AppMethodBeat.o(63344);
    return null;
  }
  
  public static void bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63342);
    if ((dkb().equals(paramString)) && ((vEr) || (b.dkg() == 0)))
    {
      vEr = false;
      if (paramBoolean) {
        ph();
      }
    }
    AppMethodBeat.o(63342);
  }
  
  public static void bjT()
  {
    AppMethodBeat.i(63340);
    ph();
    AppMethodBeat.o(63340);
  }
  
  public static String dkb()
  {
    AppMethodBeat.i(63339);
    String str = com.tencent.mm.plugin.game.commlib.a.bFe();
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(63339);
      return str;
    }
    AppMethodBeat.o(63339);
    return "commlib";
  }
  
  public static String dkc()
  {
    if ((vEq != null) && (vEq.vGb != null)) {
      return vEq.vGb.version;
    }
    return "";
  }
  
  public static void ph()
  {
    AppMethodBeat.i(63343);
    ab.i("MicroMsg.CommJsLoader", "load");
    h.a(dkb(), new com.tencent.mm.plugin.wepkg.model.a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(63338);
        paramAnonymousBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramAnonymousBaseWepkgProcessTask).vGb;
        if (paramAnonymousBaseWepkgProcessTask == null)
        {
          ab.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
          a.a(null);
          AppMethodBeat.o(63338);
          return;
        }
        if (paramAnonymousBaseWepkgProcessTask.version == null)
        {
          ab.e("MicroMsg.CommJsLoader", "version is null");
          a.a(null);
          AppMethodBeat.o(63338);
          return;
        }
        if ((a.dkd() != null) && (paramAnonymousBaseWepkgProcessTask.version.equals(a.dkd().vGb.version)))
        {
          AppMethodBeat.o(63338);
          return;
        }
        if (!paramAnonymousBaseWepkgProcessTask.vGQ)
        {
          ab.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
          AppMethodBeat.o(63338);
          return;
        }
        com.tencent.mm.plugin.wepkg.model.e locale = g.a(a.dkb(), paramAnonymousBaseWepkgProcessTask.version, paramAnonymousBaseWepkgProcessTask.gUy, paramAnonymousBaseWepkgProcessTask.cqq, paramAnonymousBaseWepkgProcessTask.vGO);
        if ((locale == null) || (bo.isNullOrNil(paramAnonymousBaseWepkgProcessTask.gUy)) || (!com.tencent.mm.a.e.cN(paramAnonymousBaseWepkgProcessTask.gUy)))
        {
          ab.e("MicroMsg.CommJsLoader", "path not exist");
          AppMethodBeat.o(63338);
          return;
        }
        a.a(new f(paramAnonymousBaseWepkgProcessTask, locale, null));
        AppMethodBeat.o(63338);
      }
    });
    AppMethodBeat.o(63343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a
 * JD-Core Version:    0.7.0.1
 */