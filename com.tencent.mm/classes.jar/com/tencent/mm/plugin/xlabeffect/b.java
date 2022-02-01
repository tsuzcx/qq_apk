package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.m;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class b
{
  private static int BLY = 0;
  private static int BLZ = 0;
  public static final b BMa;
  private static final String TAG = "MicroMsg.XLabEffectConfig";
  private static m<? super Integer, ? super Integer, y> gzp;
  private static int vil;
  private static int vim;
  private static int vin;
  private static int vio;
  private static int vip;
  
  static
  {
    AppMethodBeat.i(184222);
    BMa = new b();
    TAG = "MicroMsg.XLabEffectConfig";
    vil = 45;
    vim = 10;
    vin = 10;
    vio = 20;
    vip = 40;
    ax localax = ax.aFC("xlab_effect_config");
    ad.i(TAG, "config is : " + vil + ", " + vim + ", " + vin + ", " + vio + ", " + vip);
    BLY = localax.getInt("start_count", BLY);
    BLZ = localax.getInt("end_count", BLZ);
    ad.i(TAG, "count track is : " + BLY + ", " + BLZ);
    AppMethodBeat.o(184222);
  }
  
  public static void b(m<? super Integer, ? super Integer, y> paramm)
  {
    gzp = paramm;
  }
  
  public static int euc()
  {
    return vil;
  }
  
  public static int eud()
  {
    return vim;
  }
  
  public static int eue()
  {
    return vin;
  }
  
  public static int euf()
  {
    return vio;
  }
  
  public static int eug()
  {
    return vip;
  }
  
  public static void euh()
  {
    AppMethodBeat.i(184219);
    BLY += 1;
    ax.aFC("xlab_effect_config").putInt("start_count", BLY);
    AppMethodBeat.o(184219);
  }
  
  public static void eui()
  {
    AppMethodBeat.i(184220);
    BLZ += 1;
    ax.aFC("xlab_effect_config").putInt("end_count", BLZ);
    AppMethodBeat.o(184220);
  }
  
  public static int euj()
  {
    int i = 0;
    AppMethodBeat.i(184221);
    ax.aFC("xlab_effect_config");
    boolean bool;
    if (BLY - BLZ < 3)
    {
      bool = true;
      if (bool) {
        i = 1;
      }
      if (i == 0) {
        break label78;
      }
      h.vKh.dB(1012, 101);
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
      h.vKh.dB(1012, 102);
    }
    label92:
    AppMethodBeat.o(184221);
    return 1;
  }
  
  public static void iJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(184218);
    ad.i(TAG, "setConfig: " + paramInt1 + ", " + paramInt2);
    Object localObject = ax.aFC("xlab_effect_config");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localObject = gzp;
      if (localObject == null) {
        break;
      }
      ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(184218);
      return;
      vil = paramInt2;
      ((ax)localObject).putInt("skin_smooth", vil);
      continue;
      vim = paramInt2;
      ((ax)localObject).putInt("eye_morph", vim);
      continue;
      vin = paramInt2;
      ((ax)localObject).putInt("face_morph", vin);
      continue;
      vio = paramInt2;
      ((ax)localObject).putInt("skin_bright", vio);
      continue;
      vip = paramInt2;
      ((ax)localObject).putInt("eye_bright", vip);
    }
    AppMethodBeat.o(184218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.b
 * JD-Core Version:    0.7.0.1
 */