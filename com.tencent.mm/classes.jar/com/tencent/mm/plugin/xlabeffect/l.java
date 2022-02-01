package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private static int DpI;
  private static final String TAG;
  private static int XKs;
  private static int XKt;
  private static int XKu;
  private static int XKv;
  private static int XKw;
  public static final l XMn;
  static int XMo;
  static int XMp;
  private static m<? super Integer, ? super Integer, ah> nIa;
  
  static
  {
    AppMethodBeat.i(184222);
    XMn = new l();
    TAG = "MicroMsg.XLabEffectConfig";
    XKs = 65;
    XKu = 60;
    XKv = 100;
    XKw = 30;
    DpI = 20;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("xlab_effect_config");
    Log.i(TAG, "config is : " + XKs + ", " + XKt + ", " + XKu + ", " + XKv + ", " + XKw);
    XMo = localMultiProcessMMKV.getInt("start_count", XMo);
    XMp = localMultiProcessMMKV.getInt("end_count", XMp);
    Log.i(TAG, "count track is : " + XMo + ", " + XMp);
    AppMethodBeat.o(184222);
  }
  
  private l()
  {
    AppMethodBeat.i(184219);
    AppMethodBeat.o(184219);
  }
  
  public static int bfU()
  {
    return XKs;
  }
  
  public static int bfV()
  {
    return XKt;
  }
  
  public static int bfW()
  {
    return XKu;
  }
  
  public static int bfX()
  {
    return XKv;
  }
  
  public static int bfY()
  {
    return XKw;
  }
  
  public static int bfZ()
  {
    return DpI;
  }
  
  public static void i(m<? super Integer, ? super Integer, ah> paramm)
  {
    nIa = paramm;
  }
  
  public static int iGf()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    MultiProcessMMKV.getMMKV("xlab_effect_config");
    boolean bool;
    if (XMo - XMp < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label85;
      }
      h.OAn.kJ(1012, 101);
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
      h.OAn.kJ(1012, 102);
    }
    label99:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void nD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    Log.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = MultiProcessMMKV.getMMKV("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = nIa;
      if (localObject != null) {
        ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(184218);
      return;
      XKs = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_smooth", XKs);
      continue;
      XKt = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_morph", XKt);
      continue;
      XKu = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("face_morph", XKu);
      continue;
      XKv = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("skin_bright", XKv);
      continue;
      XKw = paramInt2;
      ((MultiProcessMMKV)localObject).putInt("eye_bright", XKw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.l
 * JD-Core Version:    0.7.0.1
 */