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
import com.tencent.mm.g.a.pj;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class g
  implements SensorEventListener
{
  private static long AYA = 0L;
  private static long AYB = 0L;
  private static long AYC = 0L;
  private static long AYD = 0L;
  private static long AYE = 0L;
  private static long AYF = 0L;
  private static long AYy = 0L;
  private static long AYz = 0L;
  private c<pj> AYG;
  private boolean AYq;
  private Sensor sensor;
  private SensorManager sensorManager;
  
  public g()
  {
    AppMethodBeat.i(149309);
    this.AYq = false;
    this.AYG = new c() {};
    if (d.lA(28))
    {
      ae.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.AYG.alive();
    }
    boolean bool;
    if ((l.gv(ak.getContext())) && (l.ekj()))
    {
      bool = true;
      this.AYq = bool;
      ae.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.AYq) });
      if (this.AYq) {
        ejR();
      }
      AYF = 0L;
    }
    for (;;)
    {
      try
      {
        if (!o.fB(a.AYa)) {
          continue;
        }
        localObject = new j(a.AYa);
        AYB = ((j)localObject).getLong(202, 0L) * 10000L;
        AYz = ((j)localObject).getLong(201, 0L);
        AYy = ((j)localObject).getLong(203, 0L);
        AYC = ((j)localObject).getLong(204, 0L);
        AYE = ((j)localObject).getLong(209, 0L);
        AYA = AYz;
        AYD = AYC;
        k.aCJ(ejU());
        o.deleteFile(a.AYa);
        ae.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(AYz), l.sz(AYB) });
      }
      catch (Exception localException)
      {
        Object localObject;
        AYB = 0L;
        AYC = 0L;
        AYD = 0L;
        AYE = 0L;
        AYy = 0L;
        AYz = 0L;
        AYA = 0L;
        ae.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        continue;
        long[] arrayOfLong = new long[7];
        continue;
      }
      if (AYB != l.ekh())
      {
        ae.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", new Object[] { l.sz(AYB) });
        AYB = 0L;
        AYC = 0L;
        AYD = 0L;
        AYE = 0L;
        AYy = 0L;
        AYz = 0L;
        AYA = 0L;
      }
      AppMethodBeat.o(149309);
      return;
      bool = false;
      break;
      localObject = k.ekd();
      ae.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
      if (bu.isNullOrNil((String)localObject)) {
        continue;
      }
      localObject = l.aCK((String)localObject);
      AYB = localObject[0];
      AYC = localObject[1];
      AYD = localObject[2];
      AYE = localObject[3];
      AYy = localObject[4];
      AYz = localObject[5];
      AYA = localObject[6];
    }
  }
  
  private void ejQ()
  {
    AppMethodBeat.i(149315);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ae.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149315);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149315);
    }
  }
  
  private boolean ejR()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (ak.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ae.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = h.ejY();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          ejQ();
        }
        ae.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(149314);
        return bool;
      }
      ae.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(149314);
    return false;
  }
  
  public static long ejS()
  {
    return AYz;
  }
  
  public static long ejT()
  {
    return AYB;
  }
  
  private static String ejU()
  {
    AppMethodBeat.i(149312);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(AYB), Long.valueOf(AYC), Long.valueOf(AYD), Long.valueOf(AYE), Long.valueOf(AYy), Long.valueOf(AYz), Long.valueOf(AYA) });
    AppMethodBeat.o(149312);
    return str;
  }
  
  private static void ejV()
  {
    AppMethodBeat.i(149313);
    ae.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
    Intent localIntent = new Intent();
    localIntent.setPackage(ak.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.plugin.sport.uploadstep");
    ak.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(149313);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(149311);
    JSONObject localJSONObject = h.ejY();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      ejQ();
      ae.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = l.ekh();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (AYB != l1)
    {
      ae.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { l.sz(l1), l.sz(AYB) });
      AYy = paramLong1;
      AYz = 0L;
      AYA = 0L;
      AYB = l1;
      AYC = l4;
      AYD = l4;
      AYE = paramLong2;
      k.aCJ(ejU());
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - AYD) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - AYD) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - AYE / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - AYE / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= AYC) {
        break label641;
      }
      ae.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), l.sz(l2), Long.valueOf(AYC) });
      l3 = paramLong1 - AYA;
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
        ae.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(AYF), Long.valueOf(AYz), Long.valueOf(AYA) });
        AYz += l1;
        AYF += l1;
        if ((l4 - AYC > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - AYA > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          AYC = l4;
          AYA = paramLong1;
          AYy = paramLong1;
          AYD = l4;
          AYE = paramLong2;
          paramString = ejU();
          ae.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          k.aCJ(paramString);
          if (AYF >= 500L)
          {
            ejV();
            AYF = 0L;
          }
          AppMethodBeat.o(149311);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < AYy)
          {
            ae.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(AYy), Long.valueOf(AYA) });
            AYy = paramLong1;
            AYA = paramLong1;
            bool = true;
          }
          if ((paramLong1 - AYy >= l6 * j) && (paramLong1 - AYy >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - AYy;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        AYy = paramLong1;
        AYD = l4;
        AYE = paramLong2;
        AppMethodBeat.o(149311);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean ejP()
  {
    AppMethodBeat.i(149316);
    if ((l.gv(ak.getContext())) && (l.ekj())) {}
    for (boolean bool = true;; bool = false)
    {
      this.AYq = bool;
      if (!this.AYq) {
        break;
      }
      ejQ();
      bool = ejR();
      AppMethodBeat.o(149316);
      return bool;
    }
    ejQ();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    ae.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((ak.foJ()) && (!SportForegroundService.ekg()))
    {
      ae.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      ae.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
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
        ae.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149310);
        return;
      }
    }
    ae.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      ae.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
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