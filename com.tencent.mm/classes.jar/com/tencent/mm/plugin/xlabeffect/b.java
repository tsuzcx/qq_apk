package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.a.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class b
{
  private static int Dei = 0;
  private static int Dej = 0;
  public static final b Dek;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static m<? super Integer, ? super Integer, y> gZM;
  private static int wqV;
  private static int wqW;
  private static int wqX;
  private static int wqY;
  private static int wqZ;
  
  static
  {
    AppMethodBeat.i(184222);
    Dek = new b();
    TAG = "MicroMsg.XLabEffectConfig";
    wqV = 45;
    wqW = 10;
    wqX = 10;
    wqY = 20;
    wqZ = 40;
    aw localaw = aw.aKT("xlab_effect_config");
    ac.i(TAG, "config is : " + wqV + ", " + wqW + ", " + wqX + ", " + wqY + ", " + wqZ);
    Dei = localaw.getInt("start_count", Dei);
    Dej = localaw.getInt("end_count", Dej);
    ac.i(TAG, "count track is : " + Dei + ", " + Dej);
    AppMethodBeat.o(184222);
  }
  
  public static void b(m<? super Integer, ? super Integer, y> paramm)
  {
    gZM = paramm;
  }
  
  public static void eJA()
  {
    AppMethodBeat.i(184219);
    Dei += 1;
    aw.aKT("xlab_effect_config").putInt("start_count", Dei);
    AppMethodBeat.o(184219);
  }
  
  public static void eJB()
  {
    AppMethodBeat.i(184220);
    Dej += 1;
    aw.aKT("xlab_effect_config").putInt("end_count", Dej);
    AppMethodBeat.o(184220);
  }
  
  public static int eJC()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    aw.aKT("xlab_effect_config");
    boolean bool;
    if (Dei - Dej < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label78;
      }
      h.wUl.dB(1012, 101);
    }
    for (;;)
    {
      ac.i(TAG, "getNumOfThread: true, ".concat(String.valueOf(bool)));
      if (i == 0) {
        break label92;
      }
      AppMethodBeat.o(184221);
      return 2;
      bool = false;
      break;
      label78:
      h.wUl.dB(1012, 102);
    }
    label92:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static int eJv()
  {
    return wqV;
  }
  
  public static int eJw()
  {
    return wqW;
  }
  
  public static int eJx()
  {
    return wqX;
  }
  
  public static int eJy()
  {
    return wqY;
  }
  
  public static int eJz()
  {
    return wqZ;
  }
  
  public static void iW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    ac.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = aw.aKT("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = gZM;
      if (localObject == null) {
        break;
      }
      ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      wqV = paramInt2;
      ((aw)localObject).putInt("skin_smooth", wqV);
      continue;
      wqW = paramInt2;
      ((aw)localObject).putInt("eye_morph", wqW);
      continue;
      wqX = paramInt2;
      ((aw)localObject).putInt("face_morph", wqX);
      continue;
      wqY = paramInt2;
      ((aw)localObject).putInt("skin_bright", wqY);
      continue;
      wqZ = paramInt2;
      ((aw)localObject).putInt("eye_bright", wqZ);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.b
 * JD-Core Version:    0.7.0.1
 */