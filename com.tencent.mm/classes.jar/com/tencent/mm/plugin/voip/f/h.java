package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.media.util.d;
import com.tencent.mm.media.util.d.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.util.b.a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "isTalkbackEnabled", "", "kotlin.jvm.PlatformType", "()Ljava/lang/Boolean;", "isTalkbackEnabled$delegate", "Lkotlin/Lazy;", "isUseFlutterVoip", "cameraReleaseAsync", "cameraRetryTimeout", "", "checkEncodeUseSurface", "checkPermissionByGpuInfo", "remoteInfo", "checkVoipEncoderMode", "chooseVoIPUIStrategy", "getFaceBeautyParams", "getXSettingSTFilterValue", "getXSettingVoipBeautyValue", "initVoIPUIStrategy", "", "isAllowToUseFaceBeauty", "isForbiddenUseNewRender", "isNotAllowToUseFaceBeautyByGPUInfo", "isReadyForUseAvcEncodeSurface", "isUseGLContextOpt", "isUseGpuCrop", "isUseNewCameraModular", "isVoipUseCameraApi2", "isXSettingAllowToCheckGpu", "voipSetRingtoneEntrance", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h ULL;
  private static boolean ULM;
  private static final j ULN;
  
  static
  {
    AppMethodBeat.i(292673);
    ULL = new h();
    ULN = kotlin.k.cm((a)h.a.ULO);
    AppMethodBeat.o(292673);
  }
  
  private static boolean bfO(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(292643);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i(paramString);
    int i = locali.optInt("code");
    Log.i("MicroMsg.VoipRendererHelper", s.X("gpu faceBeauty black list is ", paramString));
    paramString = d.nFC.bqq();
    if (!Util.isNullOrNil(paramString)) {
      for (;;)
      {
        try
        {
          paramString = new com.tencent.mm.ad.i(paramString);
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
        AppMethodBeat.o(292643);
        return bool1;
        bool2 = false;
        continue;
        if ((!s.p(locali.optString("vendor"), paramString.optString("vendor"))) || (!s.p(locali.optString("name"), paramString.optString("name"))) || (!s.p(locali.optString("version"), paramString.optString("version")))) {
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
    AppMethodBeat.o(292643);
    return false;
  }
  
  public static final boolean ibA()
  {
    AppMethodBeat.i(292574);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsI, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsI, 0) == 3)
      {
        AppMethodBeat.o(292574);
        return true;
      }
      AppMethodBeat.o(292574);
      return false;
    }
    switch (af.lYj.lUV)
    {
    case 0: 
    default: 
      AppMethodBeat.o(292574);
      return false;
    case -1: 
      boolean bool = com.tencent.mm.media.widget.d.c.f(Integer.valueOf(12));
      AppMethodBeat.o(292574);
      return bool;
    case 2: 
      AppMethodBeat.o(292574);
      return false;
    }
    AppMethodBeat.o(292574);
    return true;
  }
  
  public static final boolean ibB()
  {
    AppMethodBeat.i(292579);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsI, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsI, 0) != 1)
      {
        AppMethodBeat.o(292579);
        return true;
      }
      AppMethodBeat.o(292579);
      return false;
    }
    boolean bool;
    switch (af.lYj.lUW)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySu, false);
      AppMethodBeat.o(292579);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySu, false);
      AppMethodBeat.o(292579);
      return bool;
    case 2: 
      AppMethodBeat.o(292579);
      return false;
    }
    AppMethodBeat.o(292579);
    return true;
  }
  
  public static boolean ibC()
  {
    AppMethodBeat.i(292587);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsG, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsG, 0) == 2)
      {
        AppMethodBeat.o(292587);
        return true;
      }
      AppMethodBeat.o(292587);
      return false;
    }
    switch (af.lYj.lUY)
    {
    default: 
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySA, false);
      AppMethodBeat.o(292587);
      return bool;
    case 2: 
      AppMethodBeat.o(292587);
      return false;
    }
    AppMethodBeat.o(292587);
    return true;
  }
  
  public static final int ibD()
  {
    AppMethodBeat.i(292596);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySz, 1);
    AppMethodBeat.o(292596);
    return i;
  }
  
  public static final int ibE()
  {
    AppMethodBeat.i(292604);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsG, -1) != -1)
    {
      locali = com.tencent.mm.util.i.agtt;
      i = com.tencent.mm.util.i.a(b.a.agsG, -1);
      AppMethodBeat.o(292604);
      return i;
    }
    int i = af.lXY.lTz;
    AppMethodBeat.o(292604);
    return i;
  }
  
  public static final boolean ibF()
  {
    AppMethodBeat.i(292611);
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySx, false)) && (!ibG()))
    {
      int i = d.nFC.bqn();
      int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySv, 50);
      Log.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + i + " and remote limited is " + j);
      if (i >= j)
      {
        AppMethodBeat.o(292611);
        return true;
      }
    }
    AppMethodBeat.o(292611);
    return false;
  }
  
  private static boolean ibG()
  {
    AppMethodBeat.i(292622);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySw, "");
    s.s(localObject, "remoteRatingLimited");
    localObject = ((Iterable)n.a((CharSequence)localObject, new char[] { ';' }, 0, 6)).iterator();
    boolean bool = false;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (bool)
        {
          AppMethodBeat.o(292622);
          return true;
        }
        if (Util.isNullOrNil(str)) {
          break label138;
        }
        try
        {
          bool = bfO(str);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.VoipRendererHelper", (Throwable)localException, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
          bool = false;
        }
      }
    }
    label138:
    for (;;)
    {
      break;
      AppMethodBeat.o(292622);
      return bool;
    }
  }
  
  public static final boolean ibH()
  {
    AppMethodBeat.i(292629);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySP, 0) != 0)
    {
      AppMethodBeat.o(292629);
      return true;
    }
    AppMethodBeat.o(292629);
    return false;
  }
  
  public static final boolean ibI()
  {
    AppMethodBeat.i(292650);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    int i = com.tencent.mm.util.i.a(b.a.agsN, 0);
    if (i != 0)
    {
      if (i == 1)
      {
        AppMethodBeat.o(292650);
        return true;
      }
      AppMethodBeat.o(292650);
      return false;
    }
    boolean bool;
    switch (af.lYj.lUT)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySy, false);
      AppMethodBeat.o(292650);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySy, false);
      AppMethodBeat.o(292650);
      return bool;
    case 2: 
      AppMethodBeat.o(292650);
      return false;
    }
    AppMethodBeat.o(292650);
    return true;
  }
  
  public static boolean ibJ()
  {
    AppMethodBeat.i(292657);
    e locale = e.ULA;
    if ((e.ibd()) && (ibI()) && (e.ULD == 2))
    {
      AppMethodBeat.o(292657);
      return true;
    }
    AppMethodBeat.o(292657);
    return false;
  }
  
  public static final int ibK()
  {
    AppMethodBeat.i(292663);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsN, 0) == 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsO, 0) != 2) {}
    }
    else
    {
      AppMethodBeat.o(292663);
      return 1;
    }
    locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsO, 0) == 1)
    {
      AppMethodBeat.o(292663);
      return 2;
    }
    switch (af.lYj.lUU)
    {
    case 0: 
    default: 
      AppMethodBeat.o(292663);
      return 0;
    case -1: 
      AppMethodBeat.o(292663);
      return 0;
    case 1: 
      AppMethodBeat.o(292663);
      return 1;
    }
    AppMethodBeat.o(292663);
    return 2;
  }
  
  public static final int ibu()
  {
    AppMethodBeat.i(292525);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySd, 10);
    AppMethodBeat.o(292525);
    return i * 1000;
  }
  
  public static final boolean ibv()
  {
    AppMethodBeat.i(292532);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsF, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsF, 0) == 1)
      {
        AppMethodBeat.o(292532);
        return true;
      }
      AppMethodBeat.o(292532);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySc, true);
    AppMethodBeat.o(292532);
    return bool;
  }
  
  public static final boolean ibw()
  {
    AppMethodBeat.i(292539);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRX, true);
    AppMethodBeat.o(292539);
    return bool;
  }
  
  public static final boolean ibx()
  {
    AppMethodBeat.i(292545);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsQ, 0) != 0)
    {
      locali = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsQ, 0) == 1)
      {
        AppMethodBeat.o(292545);
        return true;
      }
      AppMethodBeat.o(292545);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySH, false);
    AppMethodBeat.o(292545);
    return bool;
  }
  
  public static final void iby()
  {
    boolean bool = true;
    AppMethodBeat.i(292555);
    Object localObject = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agsE, 0) != 0)
    {
      localObject = com.tencent.mm.util.i.agtt;
      if (com.tencent.mm.util.i.a(b.a.agsE, 0) != 1) {}
    }
    for (;;)
    {
      ULM = bool;
      AppMethodBeat.o(292555);
      return;
      bool = false;
      continue;
      if (!BuildInfo.IS_FLAVOR_RED)
      {
        localObject = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
        if (((com.tencent.mm.plugin.expt.b.c)localObject).a(c.a.ySJ, false))
        {
          Boolean localBoolean = (Boolean)ULN.getValue();
          s.s(localBoolean, "isTalkbackEnabled");
          if (localBoolean.booleanValue())
          {
            bool = false;
            continue;
          }
        }
        if ((((com.tencent.mm.plugin.expt.b.c)localObject).a(c.a.ySK, false)) && (aw.jkS()))
        {
          Log.i("MicroMsg.VoipRendererHelper", "in special case, do not use flutter! inMagicWindowMode:" + aw.jkS() + ", inFoldEnv:" + aw.jkQ());
          bool = false;
        }
        else
        {
          bool = ((com.tencent.mm.plugin.expt.b.c)localObject).a(c.a.ySG, false);
        }
      }
    }
  }
  
  public static final boolean ibz()
  {
    return ULM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.h
 * JD-Core Version:    0.7.0.1
 */