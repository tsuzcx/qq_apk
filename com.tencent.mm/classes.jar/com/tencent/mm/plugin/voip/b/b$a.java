package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_INFO_DEVICE_MODEL", "", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "TAG", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "plugin-voip_release"})
public final class b$a
{
  public static int ezp()
  {
    AppMethodBeat.i(215927);
    try
    {
      int j = aj.getContext().getSharedPreferences(aj.fkC(), 0).getInt("gpu_info_rating", -1);
      i = j;
      if (j == -1)
      {
        new b().ezn();
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        int i = -1;
      }
    }
    AppMethodBeat.o(215927);
    return i;
  }
  
  public static int ezq()
  {
    AppMethodBeat.i(215926);
    try
    {
      int j = ezs();
      i = j;
      if (j == -1)
      {
        new b().ezn();
        i = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        int i = -1;
      }
    }
    AppMethodBeat.o(215926);
    return i;
  }
  
  public static String ezr()
  {
    AppMethodBeat.i(215928);
    try
    {
      String str2 = ezt();
      str1 = str2;
      if (str2 == null)
      {
        new b().ezn();
        str1 = str2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        ad.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        Object localObject = null;
      }
    }
    AppMethodBeat.o(215928);
    return str1;
  }
  
  static int ezs()
  {
    AppMethodBeat.i(215929);
    if (g.ajx())
    {
      int i = aj.getContext().getSharedPreferences(aj.fkC(), 0).getInt("gpu_info_rating", -1);
      AppMethodBeat.o(215929);
      return i;
    }
    AppMethodBeat.o(215929);
    return -1;
  }
  
  static String ezt()
  {
    AppMethodBeat.i(215930);
    if (g.ajx())
    {
      String str = aj.getContext().getSharedPreferences(aj.fkC(), 0).getString("gpu_info_device_model", null);
      AppMethodBeat.o(215930);
      return str;
    }
    AppMethodBeat.o(215930);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b.a
 * JD-Core Version:    0.7.0.1
 */