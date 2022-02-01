package com.tencent.mm.plugin.sns.ad.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean hcg()
  {
    AppMethodBeat.i(309745);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIg, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(309745);
        return true;
      }
      AppMethodBeat.o(309745);
      return false;
    }
    finally
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localObject.toString());
      AppMethodBeat.o(309745);
    }
    return false;
  }
  
  public static boolean hch()
  {
    AppMethodBeat.i(309760);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIi, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(309760);
        return true;
      }
      AppMethodBeat.o(309760);
      return false;
    }
    finally
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localObject.toString());
      AppMethodBeat.o(309760);
    }
    return false;
  }
  
  public static boolean hci()
  {
    AppMethodBeat.i(309774);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIj, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(309774);
        return true;
      }
      AppMethodBeat.o(309774);
      return false;
    }
    finally
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localObject.toString());
      AppMethodBeat.o(309774);
    }
    return false;
  }
  
  public static boolean hcj()
  {
    AppMethodBeat.i(309784);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIh, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(309784);
        return true;
      }
      AppMethodBeat.o(309784);
      return false;
    }
    finally
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localObject.toString());
      AppMethodBeat.o(309784);
    }
    return false;
  }
  
  public static boolean hck()
  {
    AppMethodBeat.i(309796);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIk, 1);
      Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportHarmonyOSInfo is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(309796);
        return true;
      }
      AppMethodBeat.o(309796);
      return false;
    }
    finally
    {
      Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", localObject.toString());
      AppMethodBeat.o(309796);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.b
 * JD-Core Version:    0.7.0.1
 */