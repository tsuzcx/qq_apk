package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.k.d;
import com.tencent.mm.media.k.d.a;
import com.tencent.mm.media.widget.d.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingSTFilterValue", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseGpuCrop", "isUseGpuRgb2Yuv", "isUseNewCameraModular", "isUseNewVoipRenderer", "isUseRemovePreviewCallback", "isVoipUseCameraApi2", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class g
{
  public static final g NXO;
  
  static
  {
    AppMethodBeat.i(236530);
    NXO = new g();
    AppMethodBeat.o(236530);
  }
  
  private static boolean bgk(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(236527);
    i locali = new i(paramString);
    int i = locali.optInt("code");
    Log.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(paramString)));
    paramString = d.law.aVJ();
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
        AppMethodBeat.o(236527);
        return bool1;
        bool2 = false;
        continue;
        if ((!p.h(locali.optString("vendor"), paramString.optString("vendor"))) || (!p.h(locali.optString("name"), paramString.optString("name"))) || (!p.h(locali.optString("version"), paramString.optString("version")))) {
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
    AppMethodBeat.o(236527);
    return false;
  }
  
  public static final boolean gCD()
  {
    AppMethodBeat.i(236510);
    boolean bool;
    switch (af.juS.jrw)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vDB, false);
      AppMethodBeat.o(236510);
      return bool;
    case -1: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236510);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vDB, false);
      AppMethodBeat.o(236510);
      return bool;
    case 2: 
      AppMethodBeat.o(236510);
      return false;
    }
    AppMethodBeat.o(236510);
    return true;
  }
  
  public static final boolean gCE()
  {
    AppMethodBeat.i(236512);
    switch (af.juS.jrF)
    {
    case 0: 
    default: 
      AppMethodBeat.o(236512);
      return false;
    case -1: 
      if (c.f(Integer.valueOf(12)))
      {
        AppMethodBeat.o(236512);
        return true;
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236512);
        return true;
      }
      AppMethodBeat.o(236512);
      return false;
    case 2: 
      AppMethodBeat.o(236512);
      return false;
    }
    AppMethodBeat.o(236512);
    return true;
  }
  
  public static final boolean gCF()
  {
    AppMethodBeat.i(236514);
    if ((gCG()) && (gCE()))
    {
      AppMethodBeat.o(236514);
      return true;
    }
    boolean bool;
    switch (af.juS.jrE)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vDC, false);
      AppMethodBeat.o(236514);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236514);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vDC, false);
      AppMethodBeat.o(236514);
      return bool;
    case 2: 
      AppMethodBeat.o(236514);
      return false;
    }
    AppMethodBeat.o(236514);
    return true;
  }
  
  public static final boolean gCG()
  {
    AppMethodBeat.i(236516);
    boolean bool;
    switch (af.juS.jrG)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vDD, false);
      AppMethodBeat.o(236516);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(236516);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vDD, false);
      AppMethodBeat.o(236516);
      return bool;
    case 2: 
      AppMethodBeat.o(236516);
      return false;
    }
    AppMethodBeat.o(236516);
    return true;
  }
  
  public static boolean gCH()
  {
    AppMethodBeat.i(236517);
    switch (af.juS.jrH)
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236517);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(236517);
      return false;
    case 1: 
      AppMethodBeat.o(236517);
      return true;
    }
    if ((gCI()) || (((b)h.ae(b.class)).a(b.a.vDI, false)))
    {
      AppMethodBeat.o(236517);
      return true;
    }
    AppMethodBeat.o(236517);
    return false;
  }
  
  public static boolean gCI()
  {
    AppMethodBeat.i(236518);
    switch (af.juS.jrI)
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        AppMethodBeat.o(236518);
        return true;
      }
      break;
    case 2: 
      AppMethodBeat.o(236518);
      return false;
    case 1: 
      AppMethodBeat.o(236518);
      return true;
    }
    boolean bool = ((b)h.ae(b.class)).a(b.a.vDJ, false);
    AppMethodBeat.o(236518);
    return bool;
  }
  
  public static final int gCJ()
  {
    AppMethodBeat.i(236519);
    int i = ((b)h.ae(b.class)).a(b.a.vDH, 1);
    AppMethodBeat.o(236519);
    return i;
  }
  
  public static final boolean gCK()
  {
    AppMethodBeat.i(236521);
    if ((((b)h.ae(b.class)).a(b.a.vDG, false)) && (!gCL()))
    {
      int i = d.law.aVI();
      int j = ((b)h.ae(b.class)).a(b.a.vDE, 50);
      Log.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(236521);
        return true;
      }
    }
    AppMethodBeat.o(236521);
    return false;
  }
  
  private static boolean gCL()
  {
    AppMethodBeat.i(236523);
    Object localObject = ((b)h.ae(b.class)).a(b.a.vDF, "");
    p.j(localObject, "remoteRatingLimited");
    localObject = ((Iterable)n.a((CharSequence)localObject, new char[] { ';' })).iterator();
    boolean bool = false;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (bool)
        {
          AppMethodBeat.o(236523);
          return true;
        }
        if (Util.isNullOrNil(str)) {
          break label135;
        }
        try
        {
          bool = bgk(str);
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
      AppMethodBeat.o(236523);
      return bool;
    }
  }
  
  public static final boolean gCM()
  {
    AppMethodBeat.i(236525);
    if (((b)h.ae(b.class)).a(b.a.vDO, 0) != 0)
    {
      AppMethodBeat.o(236525);
      return true;
    }
    AppMethodBeat.o(236525);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.g
 * JD-Core Version:    0.7.0.1
 */