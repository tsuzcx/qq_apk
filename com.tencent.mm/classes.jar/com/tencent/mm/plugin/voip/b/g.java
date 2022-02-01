package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.media.k.d;
import com.tencent.mm.media.k.d.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseGpuCrop", "isUseGpuRgb2Yuv", "isUseNewCameraModular", "isUseNewVoipRenderer", "isUseRemovePreviewCallback", "isVoipUseCameraApi2", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class g
{
  public static final g HgZ;
  
  static
  {
    AppMethodBeat.i(236080);
    HgZ = new g();
    AppMethodBeat.o(236080);
  }
  
  private static boolean aUC(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(236079);
    i locali = new i(paramString);
    int i = locali.optInt("code");
    Log.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(paramString)));
    paramString = d.ilx.aNf();
    if (!Util.isNullOrNil(paramString)) {
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
            Log.i("MicroMsg.VoipRendererHelper", "code is fit true cause code fit");
            bool1 = bool2;
          }
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)paramString, "checkPermissionByGpuInfo error", new Object[0]);
          bool1 = false;
          continue;
          bool2 = false;
          continue;
        }
        AppMethodBeat.o(236079);
        return bool1;
        bool2 = false;
        continue;
        if ((!p.j(locali.optString("vendor"), paramString.optString("vendor"))) || (!p.j(locali.optString("name"), paramString.optString("name"))) || (!p.j(locali.optString("version"), paramString.optString("version")))) {
          continue;
        }
        bool2 = bool1;
        bool1 = bool2;
        if (bool2)
        {
          Log.i("MicroMsg.VoipRendererHelper", "code is fit true cause name and vendor and version fit");
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(236079);
    return false;
  }
  
  public static final boolean fKe()
  {
    AppMethodBeat.i(236070);
    boolean bool;
    switch (ae.gKE.gHk)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWP, false);
      AppMethodBeat.o(236070);
      return bool;
    case -1: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236070);
        return true;
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWP, false);
      AppMethodBeat.o(236070);
      return bool;
    case 2: 
      AppMethodBeat.o(236070);
      return false;
    }
    AppMethodBeat.o(236070);
    return true;
  }
  
  public static final boolean fKf()
  {
    AppMethodBeat.i(236071);
    switch (ae.gKE.gHo)
    {
    case 0: 
    default: 
      AppMethodBeat.o(236071);
      return false;
    case -1: 
      if (com.tencent.mm.media.widget.d.b.rG(12))
      {
        AppMethodBeat.o(236071);
        return true;
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236071);
        return true;
      }
      AppMethodBeat.o(236071);
      return false;
    case 2: 
      AppMethodBeat.o(236071);
      return false;
    }
    AppMethodBeat.o(236071);
    return true;
  }
  
  public static final boolean fKg()
  {
    AppMethodBeat.i(236072);
    if ((fKh()) && (fKf()))
    {
      AppMethodBeat.o(236072);
      return true;
    }
    boolean bool;
    switch (ae.gKE.gHn)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWQ, false);
      AppMethodBeat.o(236072);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236072);
        return true;
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWQ, false);
      AppMethodBeat.o(236072);
      return bool;
    case 2: 
      AppMethodBeat.o(236072);
      return false;
    }
    AppMethodBeat.o(236072);
    return true;
  }
  
  public static final boolean fKh()
  {
    AppMethodBeat.i(236073);
    boolean bool;
    switch (ae.gKE.gHp)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWR, false);
      AppMethodBeat.o(236073);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236073);
        return true;
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWR, false);
      AppMethodBeat.o(236073);
      return bool;
    case 2: 
      AppMethodBeat.o(236073);
      return false;
    }
    AppMethodBeat.o(236073);
    return true;
  }
  
  public static boolean fKi()
  {
    AppMethodBeat.i(236074);
    switch (ae.gKE.gHq)
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236074);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(236074);
      return false;
    case 1: 
      AppMethodBeat.o(236074);
      return true;
    }
    if ((fKj()) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWW, false)))
    {
      AppMethodBeat.o(236074);
      return true;
    }
    AppMethodBeat.o(236074);
    return false;
  }
  
  public static boolean fKj()
  {
    AppMethodBeat.i(236075);
    switch (ae.gKE.gHr)
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236075);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(236075);
      return false;
    case 1: 
      AppMethodBeat.o(236075);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWX, false);
    AppMethodBeat.o(236075);
    return bool;
  }
  
  public static final int fKk()
  {
    AppMethodBeat.i(236076);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWV, 1);
    AppMethodBeat.o(236076);
    return i;
  }
  
  public static final boolean fKl()
  {
    AppMethodBeat.i(236077);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWU, false)) && (!fKm()))
    {
      int i = d.ilx.aNe();
      int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWS, 50);
      Log.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(236077);
        return true;
      }
    }
    AppMethodBeat.o(236077);
    return false;
  }
  
  private static boolean fKm()
  {
    AppMethodBeat.i(236078);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWT, "");
    p.g(localObject, "remoteRatingLimited");
    localObject = ((Iterable)n.a((CharSequence)localObject, new char[] { ';' })).iterator();
    boolean bool = false;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (bool)
        {
          AppMethodBeat.o(236078);
          return true;
        }
        if (Util.isNullOrNil(str)) {
          break label135;
        }
        try
        {
          bool = aUC(str);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)localException, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
          bool = false;
        }
      }
    }
    label135:
    for (;;)
    {
      break;
      AppMethodBeat.o(236078);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.g
 * JD-Core Version:    0.7.0.1
 */