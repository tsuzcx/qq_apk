package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class n
{
  public static o ptK;
  
  public static boolean L(long paramLong1, long paramLong2)
  {
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = g.bLn().optJSONObject("stepCountUploadConfig");
      l1 = l2;
      if (localJSONObject != null)
      {
        int i = localJSONObject.optInt("backgroundTimeInterval", 60);
        l1 = i * 60 * 1000L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
      }
    }
    return paramLong2 - paramLong1 >= l1;
  }
  
  public static boolean M(long paramLong1, long paramLong2)
  {
    j = 500;
    if ((paramLong1 == 0L) && (paramLong2 > 0L)) {
      return true;
    }
    try
    {
      JSONObject localJSONObject = g.bLn().optJSONObject("stepCountUploadConfig");
      i = j;
      if (localJSONObject != null) {
        i = localJSONObject.optInt("backgroundStepCountInterval", 500);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
      }
    }
    return paramLong2 - paramLong1 >= i;
  }
  
  public static boolean bKY()
  {
    ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl("gh_43f2581f6fd6");
    if (localad != null) {}
    for (boolean bool = a.gR(localad.field_type);; bool = false)
    {
      if (!bool) {
        y.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public static boolean bLu()
  {
    boolean bool = true;
    if (g.bLn().optInt("extStepApiSwitch") != 1)
    {
      y.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      bool = false;
    }
    return bool;
  }
  
  public static final String ce(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }
  
  public static boolean ej(Context paramContext)
  {
    if (d.gG(19))
    {
      y.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
      return false;
    }
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter"))
    {
      y.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
      return false;
    }
    if (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(19) == null)
    {
      y.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
      return false;
    }
    if (g.bLn().optInt("deviceStepSwitch") != 1)
    {
      y.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.n
 * JD-Core Version:    0.7.0.1
 */