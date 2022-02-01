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
import com.tencent.mm.g.a.qb;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public final class f
  implements SensorEventListener
{
  private static long Fjs = 0L;
  private static long Fjt = 0L;
  private static long Fju = 0L;
  private static long Fjv = 0L;
  private static long Fjw = 0L;
  private static long Fjx = 0L;
  private static long Fjy = 0L;
  private static long Fjz = 0L;
  private IListener<qb> FjA;
  private boolean Fjm;
  private Sensor sensor;
  private SensorManager sensorManager;
  
  public f()
  {
    AppMethodBeat.i(149309);
    this.Fjm = false;
    this.FjA = new IListener() {};
    if (d.oD(28))
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.FjA.alive();
    }
    boolean bool;
    if ((k.hg(MMApplicationContext.getContext())) && (k.fmJ()))
    {
      bool = true;
      this.Fjm = bool;
      Log.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.Fjm) });
      if (this.Fjm) {
        fmr();
      }
      Fjz = 0L;
    }
    for (;;)
    {
      try
      {
        if (!s.YS(a.FiU)) {
          continue;
        }
        localObject = new i(a.FiU);
        Fjv = ((i)localObject).getLong(202, 0L) * 10000L;
        Fjt = ((i)localObject).getLong(201, 0L);
        Fjs = ((i)localObject).getLong(203, 0L);
        Fjw = ((i)localObject).getLong(204, 0L);
        Fjy = ((i)localObject).getLong(209, 0L);
        Fju = Fjt;
        Fjx = Fjw;
        j.aRF(fmu());
        s.deleteFile(a.FiU);
        Log.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(Fjt), k.AF(Fjv) });
      }
      catch (Exception localException)
      {
        Object localObject;
        Fjv = 0L;
        Fjw = 0L;
        Fjx = 0L;
        Fjy = 0L;
        Fjs = 0L;
        Fjt = 0L;
        Fju = 0L;
        Log.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        continue;
        long[] arrayOfLong = new long[7];
        continue;
      }
      if (Fjv != k.fmH())
      {
        Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", new Object[] { k.AF(Fjv) });
        Fjv = 0L;
        Fjw = 0L;
        Fjx = 0L;
        Fjy = 0L;
        Fjs = 0L;
        Fjt = 0L;
        Fju = 0L;
      }
      AppMethodBeat.o(149309);
      return;
      bool = false;
      break;
      localObject = j.fmD();
      Log.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject)) {
        continue;
      }
      localObject = k.aRG((String)localObject);
      Fjv = localObject[0];
      Fjw = localObject[1];
      Fjx = localObject[2];
      Fjy = localObject[3];
      Fjs = localObject[4];
      Fjt = localObject[5];
      Fju = localObject[6];
    }
  }
  
  private void fmq()
  {
    AppMethodBeat.i(149315);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      Log.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149315);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149315);
    }
  }
  
  private boolean fmr()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = g.fmy();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          fmq();
        }
        Log.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(149314);
        return bool;
      }
      Log.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(149314);
    return false;
  }
  
  public static long fms()
  {
    return Fjt;
  }
  
  public static long fmt()
  {
    return Fjv;
  }
  
  private static String fmu()
  {
    AppMethodBeat.i(149312);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(Fjv), Long.valueOf(Fjw), Long.valueOf(Fjx), Long.valueOf(Fjy), Long.valueOf(Fjs), Long.valueOf(Fjt), Long.valueOf(Fju) });
    AppMethodBeat.o(149312);
    return str;
  }
  
  private static void fmv()
  {
    AppMethodBeat.i(149313);
    Log.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
    Intent localIntent = new Intent();
    localIntent.setPackage(MMApplicationContext.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.plugin.sport.uploadstep");
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(149313);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(149311);
    JSONObject localJSONObject = g.fmy();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      fmq();
      Log.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = k.fmH();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (Fjv != l1)
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { k.AF(l1), k.AF(Fjv) });
      Fjs = paramLong1;
      Fjt = 0L;
      Fju = 0L;
      Fjv = l1;
      Fjw = l4;
      Fjx = l4;
      Fjy = paramLong2;
      j.aRF(fmu());
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - Fjx) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - Fjx) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - Fjy / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - Fjy / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= Fjw) {
        break label641;
      }
      Log.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), k.AF(l2), Long.valueOf(Fjw) });
      l3 = paramLong1 - Fju;
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
        Log.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(Fjz), Long.valueOf(Fjt), Long.valueOf(Fju) });
        Fjt += l1;
        Fjz += l1;
        if ((l4 - Fjw > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - Fju > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          Fjw = l4;
          Fju = paramLong1;
          Fjs = paramLong1;
          Fjx = l4;
          Fjy = paramLong2;
          paramString = fmu();
          Log.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          j.aRF(paramString);
          if (Fjz >= 500L)
          {
            fmv();
            Fjz = 0L;
          }
          AppMethodBeat.o(149311);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < Fjs)
          {
            Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(Fjs), Long.valueOf(Fju) });
            Fjs = paramLong1;
            Fju = paramLong1;
            bool = true;
          }
          if ((paramLong1 - Fjs >= l6 * j) && (paramLong1 - Fjs >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - Fjs;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        Fjs = paramLong1;
        Fjx = l4;
        Fjy = paramLong2;
        AppMethodBeat.o(149311);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean fmp()
  {
    AppMethodBeat.i(149316);
    if ((k.hg(MMApplicationContext.getContext())) && (k.fmJ())) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fjm = bool;
      if (!this.Fjm) {
        break;
      }
      fmq();
      bool = fmr();
      AppMethodBeat.o(149316);
      return bool;
    }
    fmq();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    Log.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((MMApplicationContext.isMMProcessExist()) && (!SportForegroundService.fmG()))
    {
      Log.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
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
        Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149310);
        return;
      }
    }
    Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.f
 * JD-Core Version:    0.7.0.1
 */