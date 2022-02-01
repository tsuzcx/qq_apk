package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class c
{
  public static final c JRA;
  private static int JRy = 0;
  private static int JRz = 0;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static int hDb;
  private static int hDc;
  private static int hDd;
  private static int hDe;
  private static int hDf;
  private static int hDg;
  private static m<? super Integer, ? super Integer, x> ioh;
  
  static
  {
    AppMethodBeat.i(184222);
    JRA = new c();
    TAG = "MicroMsg.XLabEffectConfig";
    hDb = 65;
    hDd = 60;
    hDe = 100;
    hDf = 30;
    hDg = 20;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("xlab_effect_config");
    Log.i(TAG, "config is : " + hDb + ", " + hDc + ", " + hDd + ", " + hDe + ", " + hDf);
    JRy = localMultiProcessMMKV.getInt("start_count", JRy);
    JRz = localMultiProcessMMKV.getInt("end_count", JRz);
    Log.i(TAG, "count track is : " + JRy + ", " + JRz);
    AppMethodBeat.o(184222);
  }
  
  public static int aEl()
  {
    return hDb;
  }
  
  public static int aEm()
  {
    return hDc;
  }
  
  public static int aEn()
  {
    return hDd;
  }
  
  public static int aEo()
  {
    return hDe;
  }
  
  public static int aEp()
  {
    return hDf;
  }
  
  public static int aEq()
  {
    return hDg;
  }
  
  public static void b(m<? super Integer, ? super Integer, x> paramm)
  {
    ioh = paramm;
  }
  
  public static void glp()
  {
    AppMethodBeat.i(184219);
    JRy += 1;
    MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("start_count", JRy);
    AppMethodBeat.o(184219);
  }
  
  public static void glq()
  {
    AppMethodBeat.i(184220);
    JRz += 1;
    MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("end_count", JRz);
    AppMethodBeat.o(184220);
  }
  
  public static int glr()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    MultiProcessMMKV.getMMKV("xlab_effect_config");
    boolean bool;
    if (JRy - JRz < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label85;
      }
      h.CyF.dN(1012, 101);
    }
    for (;;)
    {
      Log.i(TAG, "getNumOfThread: true, " + bool);
      if (i == 0) {
        break label99;
      }
      AppMethodBeat.o(184221);
      return 2;
      bool = false;
      break;
      label85:
      h.CyF.dN(1012, 102);
    }
    label99:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void ky(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    Log.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = MultiProcessMMKV.getMMKV("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = ioh;
      if (localObject == null) {
        break;
      }
      ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      hDb = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_smooth", hDb);
      continue;
      hDc = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_morph", hDc);
      continue;
      hDd = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("face_morph", hDd);
      continue;
      hDe = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_bright", hDe);
      continue;
      hDf = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_bright", hDf);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */