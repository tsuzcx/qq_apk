package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseGpuCrop", "isUseGpuRgb2Yuv", "isUseNewVoipRenderer", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class h
{
  public static final h Cls;
  
  static
  {
    AppMethodBeat.i(215998);
    Cls = new h();
    AppMethodBeat.o(215998);
  }
  
  private static boolean aDL(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(215997);
    com.tencent.mm.ac.i locali = new com.tencent.mm.ac.i(paramString);
    int i = locali.optInt("code");
    ad.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(paramString)));
    paramString = b.CkW;
    paramString = b.a.ezr();
    if (!bt.isNullOrNil(paramString)) {
      for (;;)
      {
        try
        {
          paramString = new com.tencent.mm.ac.i(paramString);
          if (i == 0) {
            continue;
          }
          if (i != paramString.optInt("code")) {
            continue;
          }
          bool1 = bool2;
          if (bool2)
          {
            ad.i("MicroMsg.VoipRendererHelper", "code is fit true cause code fit");
            bool1 = bool2;
          }
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)paramString, "checkPermissionByGpuInfo error", new Object[0]);
          bool1 = false;
          continue;
          bool2 = false;
          continue;
        }
        AppMethodBeat.o(215997);
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
          ad.i("MicroMsg.VoipRendererHelper", "code is fit true cause name and vendor and version fit");
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(215997);
    return false;
  }
  
  public static final boolean ezF()
  {
    AppMethodBeat.i(215991);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(215991);
      return true;
    }
    boolean bool;
    switch (ae.gcP.fZK)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwP, false);
      AppMethodBeat.o(215991);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwP, false);
      AppMethodBeat.o(215991);
      return bool;
    case 2: 
      AppMethodBeat.o(215991);
      return false;
    }
    AppMethodBeat.o(215991);
    return true;
  }
  
  public static boolean ezG()
  {
    AppMethodBeat.i(215992);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(215992);
      return true;
    }
    switch (ae.gcP.jKr)
    {
    default: 
      if ((ezH()) || (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwU, false)))
      {
        AppMethodBeat.o(215992);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(215992);
      return false;
    case 1: 
      AppMethodBeat.o(215992);
      return true;
    }
    AppMethodBeat.o(215992);
    return false;
  }
  
  public static boolean ezH()
  {
    AppMethodBeat.i(215993);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(215993);
      return true;
    }
    switch (ae.gcP.jLV)
    {
    default: 
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwV, false);
      AppMethodBeat.o(215993);
      return bool;
    case 2: 
      AppMethodBeat.o(215993);
      return false;
    }
    AppMethodBeat.o(215993);
    return true;
  }
  
  public static final int ezI()
  {
    AppMethodBeat.i(215994);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwT, 1);
    AppMethodBeat.o(215994);
    return i;
  }
  
  public static final boolean ezJ()
  {
    AppMethodBeat.i(215995);
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwS, false)) && (!ezK()))
    {
      b.a locala = b.CkW;
      int i = b.a.ezq();
      int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwQ, 50);
      ad.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(215995);
        return true;
      }
    }
    AppMethodBeat.o(215995);
    return false;
  }
  
  private static boolean ezK()
  {
    AppMethodBeat.i(215996);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwR, "");
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
          AppMethodBeat.o(215996);
          return true;
        }
        if (bt.isNullOrNil(str)) {
          break label130;
        }
        try
        {
          bool = aDL(str);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)localException, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
          bool = false;
        }
      }
    }
    label130:
    for (;;)
    {
      break;
      AppMethodBeat.o(215996);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.h
 * JD-Core Version:    0.7.0.1
 */