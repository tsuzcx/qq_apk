package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static boolean dVA()
  {
    AppMethodBeat.i(218286);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.qxp, 1);
      ae.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(218286);
        return true;
      }
      AppMethodBeat.o(218286);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(218286);
    }
    return false;
  }
  
  public static boolean dVB()
  {
    AppMethodBeat.i(218287);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.qxn, 1);
      ae.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(218287);
        return true;
      }
      AppMethodBeat.o(218287);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(218287);
    }
    return false;
  }
  
  public static boolean dVy()
  {
    AppMethodBeat.i(218284);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.qxm, 1);
      ae.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(218284);
        return true;
      }
      AppMethodBeat.o(218284);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(218284);
    }
    return false;
  }
  
  public static boolean dVz()
  {
    AppMethodBeat.i(218285);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.qxo, 1);
      ae.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(218285);
        return true;
      }
      AppMethodBeat.o(218285);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(218285);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.a
 * JD-Core Version:    0.7.0.1
 */