package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public static boolean ftl()
  {
    AppMethodBeat.i(221438);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.xLv, 1);
      ad.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(221438);
        return true;
      }
      AppMethodBeat.o(221438);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(221438);
    }
    return false;
  }
  
  public static boolean ftm()
  {
    AppMethodBeat.i(221439);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.zbA, 1);
      ad.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(221439);
        return true;
      }
      AppMethodBeat.o(221439);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(221439);
    }
    return false;
  }
  
  public static boolean ftn()
  {
    AppMethodBeat.i(221440);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.znd, 1);
      ad.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(221440);
        return true;
      }
      AppMethodBeat.o(221440);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(221440);
    }
    return false;
  }
  
  public static boolean fto()
  {
    AppMethodBeat.i(221441);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.yWL, 1);
      ad.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(221441);
        return true;
      }
      AppMethodBeat.o(221441);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(221441);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.e
 * JD-Core Version:    0.7.0.1
 */