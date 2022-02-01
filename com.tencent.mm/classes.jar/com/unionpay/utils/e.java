package com.unionpay.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static String a()
  {
    AppMethodBeat.i(207312);
    Object localObject = "";
    try
    {
      String str = Build.getRadioVersion();
      localObject = str;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    AppMethodBeat.o(207312);
    return localObject;
  }
  
  public static Location pm(Context paramContext)
  {
    AppMethodBeat.i(207321);
    Object localObject = (LocationManager)paramContext.getSystemService("location");
    for (;;)
    {
      try
      {
        if (((LocationManager)localObject).isProviderEnabled("gps"))
        {
          paramContext = ((LocationManager)localObject).getLastKnownLocation("gps");
          if (paramContext != null) {
            continue;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
        continue;
      }
      try
      {
        if (!((LocationManager)localObject).isProviderEnabled("network")) {
          continue;
        }
        localObject = ((LocationManager)localObject).getLastKnownLocation("network");
        paramContext = (Context)localObject;
      }
      catch (Exception localException)
      {
        continue;
        paramContext = null;
        continue;
      }
      AppMethodBeat.o(207321);
      return paramContext;
      if (!((LocationManager)localObject).isProviderEnabled("network")) {
        continue;
      }
      paramContext = ((LocationManager)localObject).getLastKnownLocation("network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.utils.e
 * JD-Core Version:    0.7.0.1
 */