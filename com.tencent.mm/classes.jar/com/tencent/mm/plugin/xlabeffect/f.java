package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class f
{
  private static int QPt = 0;
  private static int QPu = 0;
  private static int QPv = 0;
  private static int QPw = 0;
  private static int QPx = 0;
  private static int QQA = 0;
  public static final f QQB;
  private static int QQz = 0;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static m<? super Integer, ? super Integer, x> ldm;
  private static int yCP;
  
  static
  {
    AppMethodBeat.i(184222);
    QQB = new f();
    TAG = "MicroMsg.XLabEffectConfig";
    QPt = 65;
    QPv = 60;
    QPw = 100;
    QPx = 30;
    yCP = 20;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("xlab_effect_config");
    Log.i(TAG, "config is : " + QPt + ", " + QPu + ", " + QPv + ", " + QPw + ", " + QPx);
    QQz = localMultiProcessMMKV.getInt("start_count", QQz);
    QQA = localMultiProcessMMKV.getInt("end_count", QQA);
    Log.i(TAG, "count track is : " + QQz + ", " + QQA);
    AppMethodBeat.o(184222);
  }
  
  public static int aMs()
  {
    return QPt;
  }
  
  public static int aMt()
  {
    return QPu;
  }
  
  public static int aMu()
  {
    return QPv;
  }
  
  public static int aMv()
  {
    return QPw;
  }
  
  public static int aMw()
  {
    return QPx;
  }
  
  public static int aMx()
  {
    return yCP;
  }
  
  public static void b(m<? super Integer, ? super Integer, x> paramm)
  {
    ldm = paramm;
  }
  
  public static void hfe()
  {
    AppMethodBeat.i(184219);
    QQz += 1;
    MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("start_count", QQz);
    AppMethodBeat.o(184219);
  }
  
  public static void hff()
  {
    AppMethodBeat.i(184220);
    QQA += 1;
    MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("end_count", QQA);
    AppMethodBeat.o(184220);
  }
  
  public static int hfg()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    MultiProcessMMKV.getMMKV("xlab_effect_config");
    boolean bool;
    if (QQz - QQA < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label85;
      }
      h.IzE.el(1012, 101);
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
      h.IzE.el(1012, 102);
    }
    label99:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void lR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    Log.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = MultiProcessMMKV.getMMKV("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = ldm;
      if (localObject == null) {
        break;
      }
      ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      QPt = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_smooth", QPt);
      continue;
      QPu = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_morph", QPu);
      continue;
      QPv = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("face_morph", QPv);
      continue;
      QPw = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_bright", QPw);
      continue;
      QPx = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_bright", QPx);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.f
 * JD-Core Version:    0.7.0.1
 */