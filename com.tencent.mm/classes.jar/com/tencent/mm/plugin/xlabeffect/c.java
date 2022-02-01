package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.m;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class c
{
  private static int EIh = 0;
  private static int EIi = 0;
  public static final c EIj;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static m<? super Integer, ? super Integer, z> hrS;
  private static int xyM;
  private static int xyN;
  private static int xyO;
  private static int xyP;
  private static int xyQ;
  
  static
  {
    AppMethodBeat.i(184222);
    EIj = new c();
    TAG = "MicroMsg.XLabEffectConfig";
    xyM = 45;
    xyN = 10;
    xyO = 10;
    xyP = 20;
    xyQ = 40;
    ax localax = ax.aQz("xlab_effect_config");
    ad.i(TAG, "config is : " + xyM + ", " + xyN + ", " + xyO + ", " + xyP + ", " + xyQ);
    EIh = localax.getInt("start_count", EIh);
    EIi = localax.getInt("end_count", EIi);
    ad.i(TAG, "count track is : " + EIh + ", " + EIi);
    AppMethodBeat.o(184222);
  }
  
  public static void b(m<? super Integer, ? super Integer, z> paramm)
  {
    hrS = paramm;
  }
  
  public static int eYo()
  {
    return xyM;
  }
  
  public static int eYp()
  {
    return xyN;
  }
  
  public static int eYq()
  {
    return xyO;
  }
  
  public static int eYr()
  {
    return xyP;
  }
  
  public static int eYs()
  {
    return xyQ;
  }
  
  public static void eYt()
  {
    AppMethodBeat.i(184219);
    EIh += 1;
    ax.aQz("xlab_effect_config").putInt("start_count", EIh);
    AppMethodBeat.o(184219);
  }
  
  public static void eYu()
  {
    AppMethodBeat.i(184220);
    EIi += 1;
    ax.aQz("xlab_effect_config").putInt("end_count", EIi);
    AppMethodBeat.o(184220);
  }
  
  public static int eYv()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    ax.aQz("xlab_effect_config");
    boolean bool;
    if (EIh - EIi < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label78;
      }
      g.yhR.dD(1012, 101);
    }
    for (;;)
    {
      ad.i(TAG, "getNumOfThread: true, ".concat(String.valueOf(bool)));
      if (i == 0) {
        break label92;
      }
      AppMethodBeat.o(184221);
      return 2;
      bool = false;
      break;
      label78:
      g.yhR.dD(1012, 102);
    }
    label92:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    ad.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = ax.aQz("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = hrS;
      if (localObject == null) {
        break;
      }
      ((m)localObject).p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      xyM = paramInt2;
      ((ax)localObject).putInt("skin_smooth", xyM);
      continue;
      xyN = paramInt2;
      ((ax)localObject).putInt("eye_morph", xyN);
      continue;
      xyO = paramInt2;
      ((ax)localObject).putInt("face_morph", xyO);
      continue;
      xyP = paramInt2;
      ((ax)localObject).putInt("skin_bright", xyP);
      continue;
      xyQ = paramInt2;
      ((ax)localObject).putInt("eye_bright", xyQ);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */