package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public final class g
  implements SensorEventListener
{
  private static long AGV = 0L;
  private static long AGW = 0L;
  private static long AGX = 0L;
  private static long AGY = 0L;
  private static long AGZ = 0L;
  private static long AHa = 0L;
  private static long AHb = 0L;
  private static long AHc = 0L;
  private boolean AGN;
  private c<pi> AHd;
  private Sensor sensor;
  private SensorManager sensorManager;
  
  public g()
  {
    AppMethodBeat.i(149309);
    this.AGN = false;
    this.AHd = new c() {};
    if (d.ly(28))
    {
      ad.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.AHd.alive();
    }
    boolean bool;
    if ((l.gq(aj.getContext())) && (l.egB()))
    {
      bool = true;
      this.AGN = bool;
      ad.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.AGN) });
      if (this.AGN) {
        egj();
      }
      AHc = 0L;
    }
    for (;;)
    {
      try
      {
        if (!i.fv(a.AGx)) {
          continue;
        }
        localObject = new j(a.AGx);
        AGY = ((j)localObject).getLong(202, 0L) * 10000L;
        AGW = ((j)localObject).getLong(201, 0L);
        AGV = ((j)localObject).getLong(203, 0L);
        AGZ = ((j)localObject).getLong(204, 0L);
        AHb = ((j)localObject).getLong(209, 0L);
        AGX = AGW;
        AHa = AGZ;
        k.aBq(egm());
        i.deleteFile(a.AGx);
        ad.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(AGW), l.sm(AGY) });
      }
      catch (Exception localException)
      {
        Object localObject;
        AGY = 0L;
        AGZ = 0L;
        AHa = 0L;
        AHb = 0L;
        AGV = 0L;
        AGW = 0L;
        AGX = 0L;
        ad.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        continue;
        long[] arrayOfLong = new long[7];
        continue;
      }
      if (AGY != l.egz())
      {
        ad.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", new Object[] { l.sm(AGY) });
        AGY = 0L;
        AGZ = 0L;
        AHa = 0L;
        AHb = 0L;
        AGV = 0L;
        AGW = 0L;
        AGX = 0L;
      }
      AppMethodBeat.o(149309);
      return;
      bool = false;
      break;
      localObject = k.egv();
      ad.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
      if (bt.isNullOrNil((String)localObject)) {
        continue;
      }
      localObject = l.aBr((String)localObject);
      AGY = localObject[0];
      AGZ = localObject[1];
      AHa = localObject[2];
      AHb = localObject[3];
      AGV = localObject[4];
      AGW = localObject[5];
      AGX = localObject[6];
    }
  }
  
  private void egi()
  {
    AppMethodBeat.i(149315);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ad.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149315);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149315);
    }
  }
  
  private boolean egj()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (aj.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ad.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = h.egq();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          egi();
        }
        ad.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(149314);
        return bool;
      }
      ad.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(149314);
    return false;
  }
  
  public static long egk()
  {
    return AGW;
  }
  
  public static long egl()
  {
    return AGY;
  }
  
  private static String egm()
  {
    AppMethodBeat.i(149312);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(AGY), Long.valueOf(AGZ), Long.valueOf(AHa), Long.valueOf(AHb), Long.valueOf(AGV), Long.valueOf(AGW), Long.valueOf(AGX) });
    AppMethodBeat.o(149312);
    return str;
  }
  
  private static void egn()
  {
    AppMethodBeat.i(149313);
    ad.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
    Intent localIntent = new Intent();
    localIntent.setPackage(aj.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.plugin.sport.uploadstep");
    aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(149313);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(149311);
    JSONObject localJSONObject = h.egq();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      egi();
      ad.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = l.egz();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (AGY != l1)
    {
      ad.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { l.sm(l1), l.sm(AGY) });
      AGV = paramLong1;
      AGW = 0L;
      AGX = 0L;
      AGY = l1;
      AGZ = l4;
      AHa = l4;
      AHb = paramLong2;
      k.aBq(egm());
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - AHa) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - AHa) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - AHb / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - AHb / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= AGZ) {
        break label641;
      }
      ad.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), l.sm(l2), Long.valueOf(AGZ) });
      l3 = paramLong1 - AGX;
      if ((l3 <= 0L) || ((l3 >= j * l6) && (l3 >= j * l5))) {
        break label770;
      }
      localObject1 = "rebootIncrease Valid Step diffStep > 0";
    }
    label641:
    label770:
    for (l1 = l3;; l1 = 0L)
    {
      l2 = l1;
      Object localObject2 = localObject1;
      if (l3 < 0L) {
        if (paramLong1 >= j * l6)
        {
          l2 = l1;
          localObject2 = localObject1;
          if (paramLong1 >= j * l5) {}
        }
        else
        {
          localObject2 = "rebootIncrease Valid Step diffStep < 0";
          l2 = paramLong1;
        }
      }
      l1 = l2;
      localObject1 = localObject2;
      bool = true;
      for (;;)
      {
        ad.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(AHc), Long.valueOf(AGW), Long.valueOf(AGX) });
        AGW += l1;
        AHc += l1;
        if ((l4 - AGZ > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - AGX > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          AGZ = l4;
          AGX = paramLong1;
          AGV = paramLong1;
          AHa = l4;
          AHb = paramLong2;
          paramString = egm();
          ad.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          k.aBq(paramString);
          if (AHc >= 500L)
          {
            egn();
            AHc = 0L;
          }
          AppMethodBeat.o(149311);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < AGV)
          {
            ad.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(AGV), Long.valueOf(AGX) });
            AGV = paramLong1;
            AGX = paramLong1;
            bool = true;
          }
          if ((paramLong1 - AGV >= l6 * j) && (paramLong1 - AGV >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - AGV;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        AGV = paramLong1;
        AHa = l4;
        AHb = paramLong2;
        AppMethodBeat.o(149311);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean egh()
  {
    AppMethodBeat.i(149316);
    if ((l.gq(aj.getContext())) && (l.egB())) {}
    for (boolean bool = true;; bool = false)
    {
      this.AGN = bool;
      if (!this.AGN) {
        break;
      }
      egi();
      bool = egj();
      AppMethodBeat.o(149316);
      return bool;
    }
    egi();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    ad.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((aj.fkO()) && (!SportForegroundService.egy()))
    {
      ad.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      ad.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
      b(paramSensorEvent.values[0], paramSensorEvent.timestamp, "PUSH");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      if (paramSensorEvent == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramSensorEvent != null) {
          bool2 = true;
        }
        ad.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149310);
        return;
      }
    }
    ad.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      ad.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.g
 * JD-Core Version:    0.7.0.1
 */