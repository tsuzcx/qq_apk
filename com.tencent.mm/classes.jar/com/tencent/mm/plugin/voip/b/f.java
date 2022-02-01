package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import d.l;
import d.n.n;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseNewVoipRenderer", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class f
{
  public static final f AMe;
  
  static
  {
    AppMethodBeat.i(208667);
    AMe = new f();
    AppMethodBeat.o(208667);
  }
  
  private static boolean ayD(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(208666);
    i locali = new i(paramString);
    int i = locali.optInt("code");
    ac.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(paramString)));
    paramString = b.ALR;
    paramString = b.a.elG();
    if (!bs.isNullOrNil(paramString)) {
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
            ac.i("MicroMsg.VoipRendererHelper", "code is fit true cause code fit");
            bool1 = bool2;
          }
        }
        catch (Exception paramString)
        {
          ac.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)paramString, "checkPermissionByGpuInfo error", new Object[0]);
          bool1 = false;
          continue;
          bool2 = false;
          continue;
        }
        AppMethodBeat.o(208666);
        return bool1;
        bool2 = false;
        continue;
        if ((!d.g.b.k.g(locali.optString("vendor"), paramString.optString("vendor"))) || (!d.g.b.k.g(locali.optString("name"), paramString.optString("name"))) || (!d.g.b.k.g(locali.optString("version"), paramString.optString("version")))) {
          continue;
        }
        bool2 = bool1;
        bool1 = bool2;
        if (bool2)
        {
          ac.i("MicroMsg.VoipRendererHelper", "code is fit true cause name and vendor and version fit");
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(208666);
    return false;
  }
  
  public static final boolean elM()
  {
    AppMethodBeat.i(208662);
    if (h.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(208662);
      return true;
    }
    boolean bool;
    switch (ae.fJo.fGl)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSr, false);
      AppMethodBeat.o(208662);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSr, false);
      AppMethodBeat.o(208662);
      return bool;
    case 2: 
      AppMethodBeat.o(208662);
      return false;
    }
    AppMethodBeat.o(208662);
    return true;
  }
  
  public static final int elN()
  {
    AppMethodBeat.i(208663);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSv, 1);
    AppMethodBeat.o(208663);
    return i;
  }
  
  public static final boolean elO()
  {
    AppMethodBeat.i(208664);
    if ((((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSu, false)) && (!elP()))
    {
      b.a locala = b.ALR;
      int i = b.a.elF();
      int j = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSs, 50);
      ac.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(208664);
        return true;
      }
    }
    AppMethodBeat.o(208664);
    return false;
  }
  
  private static boolean elP()
  {
    AppMethodBeat.i(208665);
    Object localObject = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSt, "");
    d.g.b.k.g(localObject, "remoteRatingLimited");
    localObject = ((Iterable)n.b((CharSequence)localObject, new char[] { ';' })).iterator();
    boolean bool = false;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (bool)
        {
          AppMethodBeat.o(208665);
          return true;
        }
        if (bs.isNullOrNil(str)) {
          break label129;
        }
        try
        {
          bool = ayD(str);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)localException, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
          bool = false;
        }
      }
    }
    label129:
    for (;;)
    {
      break;
      AppMethodBeat.o(208665);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.f
 * JD-Core Version:    0.7.0.1
 */