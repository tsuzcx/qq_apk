package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_INFO_DEVICE_MODEL", "", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "TAG", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "queryGpuDeviceModel", "queryGpuRating", "plugin-voip_release"})
public final class b$a
{
  public static int elF()
  {
    AppMethodBeat.i(208612);
    try
    {
      int j = elH();
      i = j;
      if (j == -1)
      {
        new b().elD();
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        int i = -1;
      }
    }
    AppMethodBeat.o(208612);
    return i;
  }
  
  public static String elG()
  {
    AppMethodBeat.i(208613);
    try
    {
      String str2 = elI();
      str1 = str2;
      if (str2 == null)
      {
        new b().elD();
        str1 = str2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        ac.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        Object localObject = null;
      }
    }
    AppMethodBeat.o(208613);
    return str1;
  }
  
  static int elH()
  {
    AppMethodBeat.i(208614);
    if (g.agM())
    {
      int i = ai.getContext().getSharedPreferences(ai.eUX(), 0).getInt("gpu_info_rating", -1);
      AppMethodBeat.o(208614);
      return i;
    }
    AppMethodBeat.o(208614);
    return -1;
  }
  
  static String elI()
  {
    AppMethodBeat.i(208615);
    if (g.agM())
    {
      String str = ai.getContext().getSharedPreferences(ai.eUX(), 0).getString("gpu_info_device_model", null);
      AppMethodBeat.o(208615);
      return str;
    }
    AppMethodBeat.o(208615);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b.a
 * JD-Core Version:    0.7.0.1
 */