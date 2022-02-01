package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static boolean eYe()
  {
    AppMethodBeat.i(192748);
    try
    {
      int i = ((b)g.af(b.class)).a(b.a.rPd, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(192748);
        return true;
      }
      AppMethodBeat.o(192748);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(192748);
    }
    return false;
  }
  
  public static boolean eYf()
  {
    AppMethodBeat.i(192749);
    try
    {
      int i = ((b)g.af(b.class)).a(b.a.rPf, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(192749);
        return true;
      }
      AppMethodBeat.o(192749);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(192749);
    }
    return false;
  }
  
  public static boolean eYg()
  {
    AppMethodBeat.i(192750);
    try
    {
      int i = ((b)g.af(b.class)).a(b.a.rPg, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(192750);
        return true;
      }
      AppMethodBeat.o(192750);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(192750);
    }
    return false;
  }
  
  public static boolean eYh()
  {
    AppMethodBeat.i(192751);
    try
    {
      int i = ((b)g.af(b.class)).a(b.a.rPe, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(192751);
        return true;
      }
      AppMethodBeat.o(192751);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localThrowable.toString());
      AppMethodBeat.o(192751);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.a
 * JD-Core Version:    0.7.0.1
 */