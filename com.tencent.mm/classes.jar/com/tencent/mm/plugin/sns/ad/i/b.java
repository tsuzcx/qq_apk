package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean fLM()
  {
    AppMethodBeat.i(261408);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvk, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(261408);
        return true;
      }
      AppMethodBeat.o(261408);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(261408);
    }
    return false;
  }
  
  public static boolean fLN()
  {
    AppMethodBeat.i(261410);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvm, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(261410);
        return true;
      }
      AppMethodBeat.o(261410);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(261410);
    }
    return false;
  }
  
  public static boolean fLO()
  {
    AppMethodBeat.i(261412);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvn, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(261412);
        return true;
      }
      AppMethodBeat.o(261412);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(261412);
    }
    return false;
  }
  
  public static boolean fLP()
  {
    AppMethodBeat.i(261414);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvl, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(261414);
        return true;
      }
      AppMethodBeat.o(261414);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(261414);
    }
    return false;
  }
  
  public static boolean fLQ()
  {
    AppMethodBeat.i(261415);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvo, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportHarmonyOSInfo is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(261415);
        return true;
      }
      AppMethodBeat.o(261415);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(261415);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.b
 * JD-Core Version:    0.7.0.1
 */