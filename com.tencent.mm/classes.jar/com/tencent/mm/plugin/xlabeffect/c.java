package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.a.m;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class c
{
  private static int FaE = 0;
  private static int FaF = 0;
  public static final c FaG;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static m<? super Integer, ? super Integer, z> huG;
  private static int xOI;
  private static int xOJ;
  private static int xOK;
  private static int xOL;
  private static int xOM;
  
  static
  {
    AppMethodBeat.i(184222);
    FaG = new c();
    TAG = "MicroMsg.XLabEffectConfig";
    xOI = 65;
    xOK = 60;
    xOL = 100;
    xOM = 30;
    ay localay = ay.aRW("xlab_effect_config");
    ae.i(TAG, "config is : " + xOI + ", " + xOJ + ", " + xOK + ", " + xOL + ", " + xOM);
    FaE = localay.getInt("start_count", FaE);
    FaF = localay.getInt("end_count", FaF);
    ae.i(TAG, "count track is : " + FaE + ", " + FaF);
    AppMethodBeat.o(184222);
  }
  
  public static void b(m<? super Integer, ? super Integer, z> paramm)
  {
    huG = paramm;
  }
  
  public static int fcb()
  {
    return xOI;
  }
  
  public static int fcc()
  {
    return xOJ;
  }
  
  public static int fcd()
  {
    return xOK;
  }
  
  public static int fce()
  {
    return xOL;
  }
  
  public static int fcf()
  {
    return xOM;
  }
  
  public static void fcg()
  {
    AppMethodBeat.i(184219);
    FaE += 1;
    ay.aRW("xlab_effect_config").putInt("start_count", FaE);
    AppMethodBeat.o(184219);
  }
  
  public static void fch()
  {
    AppMethodBeat.i(184220);
    FaF += 1;
    ay.aRW("xlab_effect_config").putInt("end_count", FaF);
    AppMethodBeat.o(184220);
  }
  
  public static int fci()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    ay.aRW("xlab_effect_config");
    boolean bool;
    if (FaE - FaF < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label78;
      }
      g.yxI.dD(1012, 101);
    }
    for (;;)
    {
      ae.i(TAG, "getNumOfThread: true, ".concat(String.valueOf(bool)));
      if (i == 0) {
        break label92;
      }
      AppMethodBeat.o(184221);
      return 2;
      bool = false;
      break;
      label78:
      g.yxI.dD(1012, 102);
    }
    label92:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void jn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    ae.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = ay.aRW("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = huG;
      if (localObject == null) {
        break;
      }
      ((m)localObject).p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      xOI = paramInt2;
      ((ay)localObject).putInt("skin_smooth", xOI);
      continue;
      xOJ = paramInt2;
      ((ay)localObject).putInt("eye_morph", xOJ);
      continue;
      xOK = paramInt2;
      ((ay)localObject).putInt("face_morph", xOK);
      continue;
      xOL = paramInt2;
      ((ay)localObject).putInt("skin_bright", xOL);
      continue;
      xOM = paramInt2;
      ((ay)localObject).putInt("eye_bright", xOM);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */