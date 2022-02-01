package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseGpuCrop", "isUseGpuRgb2Yuv", "isUseNewVoipRenderer", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class h
{
  public static final h CCW;
  
  static
  {
    AppMethodBeat.i(210419);
    CCW = new h();
    AppMethodBeat.o(210419);
  }
  
  private static boolean aFe(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(210418);
    i locali = new i(paramString);
    int i = locali.optInt("code");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(paramString)));
    paramString = b.CCB;
    paramString = b.a.eCZ();
    if (!bu.isNullOrNil(paramString)) {
      for (;;)
      {
        try
        {
          paramString = new i(paramString);
          if (i == 0) {
            continue;
          }
          if (i != paramString.optInt("code")) {
            continue;
          }
          bool1 = bool2;
          if (bool2)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoipRendererHelper", "code is fit true cause code fit");
            bool1 = bool2;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)paramString, "checkPermissionByGpuInfo error", new Object[0]);
          bool1 = false;
          continue;
          bool2 = false;
          continue;
        }
        AppMethodBeat.o(210418);
        return bool1;
        bool2 = false;
        continue;
        if ((!p.i(locali.optString("vendor"), paramString.optString("vendor"))) || (!p.i(locali.optString("name"), paramString.optString("name"))) || (!p.i(locali.optString("version"), paramString.optString("version")))) {
          continue;
        }
        bool2 = bool1;
        bool1 = bool2;
        if (bool2)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoipRendererHelper", "code is fit true cause name and vendor and version fit");
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(210418);
    return false;
  }
  
  public static final boolean eDn()
  {
    AppMethodBeat.i(210412);
    if (j.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(210412);
      return true;
    }
    boolean bool;
    switch (com.tencent.mm.compatible.deviceinfo.ae.geX.gbR)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDP, false);
      AppMethodBeat.o(210412);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDP, false);
      AppMethodBeat.o(210412);
      return bool;
    case 2: 
      AppMethodBeat.o(210412);
      return false;
    }
    AppMethodBeat.o(210412);
    return true;
  }
  
  public static boolean eDo()
  {
    AppMethodBeat.i(210413);
    if (j.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(210413);
      return true;
    }
    switch (com.tencent.mm.compatible.deviceinfo.ae.geX.gbS)
    {
    default: 
      if ((eDp()) || (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDU, false)))
      {
        AppMethodBeat.o(210413);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(210413);
      return false;
    case 1: 
      AppMethodBeat.o(210413);
      return true;
    }
    AppMethodBeat.o(210413);
    return false;
  }
  
  public static boolean eDp()
  {
    AppMethodBeat.i(210414);
    if (j.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(210414);
      return true;
    }
    switch (com.tencent.mm.compatible.deviceinfo.ae.geX.gbT)
    {
    default: 
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDV, false);
      AppMethodBeat.o(210414);
      return bool;
    case 2: 
      AppMethodBeat.o(210414);
      return false;
    }
    AppMethodBeat.o(210414);
    return true;
  }
  
  public static final int eDq()
  {
    AppMethodBeat.i(210415);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDT, 1);
    AppMethodBeat.o(210415);
    return i;
  }
  
  public static final boolean eDr()
  {
    AppMethodBeat.i(210416);
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDS, false)) && (!eDs()))
    {
      b.a locala = b.CCB;
      int i = b.a.eCY();
      int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDQ, 50);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(210416);
        return true;
      }
    }
    AppMethodBeat.o(210416);
    return false;
  }
  
  private static boolean eDs()
  {
    AppMethodBeat.i(210417);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDR, "");
    p.g(localObject, "remoteRatingLimited");
    localObject = ((Iterable)n.b((CharSequence)localObject, new char[] { ';' })).iterator();
    boolean bool = false;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (bool)
        {
          AppMethodBeat.o(210417);
          return true;
        }
        if (bu.isNullOrNil(str)) {
          break label130;
        }
        try
        {
          bool = aFe(str);
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)localException, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
          bool = false;
        }
      }
    }
    label130:
    for (;;)
    {
      break;
      AppMethodBeat.o(210417);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.h
 * JD-Core Version:    0.7.0.1
 */