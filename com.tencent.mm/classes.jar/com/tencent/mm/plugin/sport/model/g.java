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
import com.tencent.mm.g.a.oz;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public final class g
  implements SensorEventListener
{
  private static long zpb = 0L;
  private static long zpc = 0L;
  private static long zpd = 0L;
  private static long zpe = 0L;
  private static long zpf = 0L;
  private static long zpg = 0L;
  private static long zph = 0L;
  private static long zpi = 0L;
  private Sensor sensor;
  private SensorManager sensorManager;
  private boolean zoT;
  private c<oz> zpj;
  
  public g()
  {
    AppMethodBeat.i(149309);
    this.zoT = false;
    this.zpj = new c() {};
    if (d.kZ(28))
    {
      ac.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.zpj.alive();
    }
    boolean bool;
    if ((l.gn(ai.getContext())) && (l.dUn()))
    {
      bool = true;
      this.zoT = bool;
      ac.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.zoT) });
      if (this.zoT) {
        dTV();
      }
      zpi = 0L;
    }
    for (;;)
    {
      try
      {
        if (i.eA(a.zoD))
        {
          localObject = new j(a.zoD);
          zpe = ((j)localObject).getLong(202, 0L) * 10000L;
          zpc = ((j)localObject).getLong(201, 0L);
          zpb = ((j)localObject).getLong(203, 0L);
          zpf = ((j)localObject).getLong(204, 0L);
          zph = ((j)localObject).getLong(209, 0L);
          zpd = zpc;
          zpg = zpf;
          k.awk(dTY());
          i.deleteFile(a.zoD);
          ac.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(zpc), l.qn(zpe) });
          AppMethodBeat.o(149309);
          return;
          bool = false;
          break;
        }
        Object localObject = k.dUh();
        ac.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
        if (!bs.isNullOrNil((String)localObject))
        {
          localObject = l.awl((String)localObject);
          zpe = localObject[0];
          zpf = localObject[1];
          zpg = localObject[2];
          zph = localObject[3];
          zpb = localObject[4];
          zpc = localObject[5];
          zpd = localObject[6];
        }
        else
        {
          long[] arrayOfLong = new long[7];
        }
      }
      catch (Exception localException)
      {
        zpe = 0L;
        zpf = 0L;
        zpg = 0L;
        zph = 0L;
        zpb = 0L;
        zpc = 0L;
        zpd = 0L;
        ac.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        AppMethodBeat.o(149309);
        return;
      }
    }
  }
  
  private void dTU()
  {
    AppMethodBeat.i(149315);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ac.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149315);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149315);
    }
  }
  
  private boolean dTV()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (ai.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ac.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = h.dUc();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          dTU();
        }
        ac.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(149314);
        return bool;
      }
      ac.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(149314);
    return false;
  }
  
  public static long dTW()
  {
    return zpc;
  }
  
  public static long dTX()
  {
    return zpe;
  }
  
  private static String dTY()
  {
    AppMethodBeat.i(149312);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(zpe), Long.valueOf(zpf), Long.valueOf(zpg), Long.valueOf(zph), Long.valueOf(zpb), Long.valueOf(zpc), Long.valueOf(zpd) });
    AppMethodBeat.o(149312);
    return str;
  }
  
  private static void dTZ()
  {
    AppMethodBeat.i(149313);
    ac.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
    Intent localIntent = new Intent();
    localIntent.setPackage(ai.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.plugin.sport.uploadstep");
    ai.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(149313);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(149311);
    JSONObject localJSONObject = h.dUc();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      dTU();
      ac.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = l.dUl();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (zpe != l1)
    {
      ac.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { l.qn(l1), l.qn(zpe) });
      zpb = paramLong1;
      zpc = 0L;
      zpd = 0L;
      zpe = l1;
      zpf = l4;
      zpg = l4;
      zph = paramLong2;
      k.awk(dTY());
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - zpg) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - zpg) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - zph / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - zph / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= zpf) {
        break label641;
      }
      ac.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), l.qn(l2), Long.valueOf(zpf) });
      l3 = paramLong1 - zpd;
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
        ac.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(zpi), Long.valueOf(zpc), Long.valueOf(zpd) });
        zpc += l1;
        zpi += l1;
        if ((l4 - zpf > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - zpd > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          zpf = l4;
          zpd = paramLong1;
          zpb = paramLong1;
          zpg = l4;
          zph = paramLong2;
          paramString = dTY();
          ac.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          k.awk(paramString);
          if (zpi >= 500L)
          {
            dTZ();
            zpi = 0L;
          }
          AppMethodBeat.o(149311);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < zpb)
          {
            ac.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(zpb), Long.valueOf(zpd) });
            zpb = paramLong1;
            zpd = paramLong1;
            bool = true;
          }
          if ((paramLong1 - zpb >= l6 * j) && (paramLong1 - zpb >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - zpb;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        zpb = paramLong1;
        zpg = l4;
        zph = paramLong2;
        AppMethodBeat.o(149311);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean dTT()
  {
    AppMethodBeat.i(149316);
    if ((l.gn(ai.getContext())) && (l.dUn())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zoT = bool;
      if (!this.zoT) {
        break;
      }
      dTU();
      bool = dTV();
      AppMethodBeat.o(149316);
      return bool;
    }
    dTU();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    ac.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((ai.eVi()) && (!SportForegroundService.dUk()))
    {
      ac.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      ac.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
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
        ac.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149310);
        return;
      }
    }
    ac.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      ac.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.g
 * JD-Core Version:    0.7.0.1
 */