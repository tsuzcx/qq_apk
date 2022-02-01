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
import com.tencent.mm.f.a.qz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class h
  implements SensorEventListener
{
  private static long LxR = 0L;
  private static long LxS = 0L;
  private static long LxT = 0L;
  private static long LxU = 0L;
  private static long LxV = 0L;
  private static long LxW = 0L;
  private static long LxX = 0L;
  private static long LxY = 0L;
  private Sensor LxM;
  private boolean LxN;
  private IListener<qz> LxZ;
  private SensorManager sensorManager;
  
  public h()
  {
    AppMethodBeat.i(149309);
    this.LxN = false;
    this.LxZ = new h.1(this);
    if (d.qV(28))
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.LxZ.alive();
    }
    if ((n.ih(MMApplicationContext.getContext())) && (n.gbc())) {}
    for (boolean bool = true;; bool = false)
    {
      this.LxN = bool;
      Log.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.LxN) });
      if (this.LxN) {
        gaO();
      }
      LxY = 0L;
      Object localObject = m.Lyn;
      localObject = m.gaZ();
      LxU = ((m.a)localObject).LxU;
      LxV = ((m.a)localObject).LxV;
      LxW = ((m.a)localObject).LxW;
      LxX = ((m.a)localObject).LxX;
      LxR = ((m.a)localObject).LxR;
      LxS = ((m.a)localObject).LxS;
      LxT = ((m.a)localObject).LxT;
      if (LxU != n.gba())
      {
        Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", new Object[] { n.GN(LxU) });
        LxU = 0L;
        LxV = 0L;
        LxW = 0L;
        LxX = 0L;
        LxR = 0L;
        LxS = 0L;
        LxT = 0L;
      }
      AppMethodBeat.o(149309);
      return;
    }
  }
  
  private void gaN()
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
  
  private boolean gaO()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.LxM = this.sensorManager.getDefaultSensor(19);
        if (this.LxM == null)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = k.gaS();
        boolean bool = this.sensorManager.registerListener(this, this.LxM, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          gaN();
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
  
  private static void gaP()
  {
    AppMethodBeat.i(221588);
    m.a locala = new m.a();
    locala.LxU = LxU;
    locala.LxV = LxV;
    locala.LxW = LxW;
    locala.LxX = LxX;
    locala.LxR = LxR;
    locala.LxS = LxS;
    locala.LxT = LxT;
    m localm = m.Lyn;
    m.a(locala);
    AppMethodBeat.o(221588);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(149311);
    JSONObject localJSONObject = k.gaS();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      gaN();
      Log.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = n.gba();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (LxU != l1)
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { n.GN(l1), n.GN(LxU) });
      LxR = paramLong1;
      LxS = 0L;
      LxT = 0L;
      LxU = l1;
      LxV = l4;
      LxW = l4;
      LxX = paramLong2;
      gaP();
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - LxW) / 300000L;
    int i;
    long l5;
    label251:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - LxW) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - LxX / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - LxX / 1000000L) % 300000L <= 0L) {
        break label651;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= LxV) {
        break label657;
      }
      Log.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), n.GN(l2), Long.valueOf(LxV) });
      l3 = paramLong1 - LxT;
      if ((l3 <= 0L) || ((l3 >= j * l6) && (l3 >= j * l5))) {
        break label794;
      }
      localObject1 = "rebootIncrease Valid Step diffStep > 0";
    }
    label651:
    label657:
    label787:
    label794:
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
        Log.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(LxY), Long.valueOf(LxS), Long.valueOf(LxT) });
        LxS += l1;
        LxY += l1;
        if ((l4 - LxV <= localJSONObject.optInt("stepCounterSaveInterval", 60000)) && (paramLong1 - LxT <= localJSONObject.optInt("stepCounterSaveStep")) && (!bool)) {
          break label774;
        }
        LxV = l4;
        LxT = paramLong1;
        LxR = paramLong1;
        LxW = l4;
        LxX = paramLong2;
        gaP();
        if (LxY < 500L) {
          break label787;
        }
        Log.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
        paramString = new Intent();
        paramString.setPackage(MMApplicationContext.getContext().getPackageName());
        paramString.setAction("com.tencent.mm.plugin.sport.uploadstep");
        MMApplicationContext.getContext().sendBroadcast(paramString);
        LxY = 0L;
        AppMethodBeat.o(149311);
        return;
        i = 0;
        break;
        i = 0;
        break label251;
        if (paramLong1 < LxR)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(LxR), Long.valueOf(LxT) });
          LxR = paramLong1;
          LxT = paramLong1;
          bool = true;
        }
        if ((paramLong1 - LxR < l6 * j) || (paramLong1 - LxR < l5 * j))
        {
          l1 = paramLong1 - LxR;
          localObject1 = "normalIncrease Valid Step";
        }
        else
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", "increase step too large, not like a person");
          localObject1 = "";
        }
      }
      LxR = paramLong1;
      LxW = l4;
      LxX = paramLong2;
      AppMethodBeat.o(149311);
      return;
    }
  }
  
  public final boolean gaM()
  {
    AppMethodBeat.i(149316);
    if ((n.ih(MMApplicationContext.getContext())) && (n.gbc())) {}
    for (boolean bool = true;; bool = false)
    {
      this.LxN = bool;
      if (!this.LxN) {
        break;
      }
      gaN();
      bool = gaO();
      AppMethodBeat.o(149316);
      return bool;
    }
    gaN();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    Log.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if (MMApplicationContext.isMMProcessExist())
    {
      Log.v("MicroMsg.Sport.PushSportStepDetector", "mm process exist, use mm process data");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      com.tencent.e.h.ZvG.d(new i(System.currentTimeMillis(), paramSensorEvent.values[0], paramSensorEvent.timestamp, "PUSH"), "PushUpdateStepTag");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */