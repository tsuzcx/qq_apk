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
import com.tencent.mm.g.a.oq;
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
  private static long ycb = 0L;
  private static long ycc = 0L;
  private static long ycd = 0L;
  private static long yce = 0L;
  private static long ycf = 0L;
  private static long ycg = 0L;
  private static long ych = 0L;
  private static long yci = 0L;
  private Sensor sensor;
  private SensorManager sensorManager;
  private boolean ybT;
  private c<oq> ycj;
  
  public g()
  {
    AppMethodBeat.i(149309);
    this.ybT = false;
    this.ycj = new c() {};
    if (d.lf(28))
    {
      ad.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.ycj.alive();
    }
    boolean bool;
    if ((l.gb(aj.getContext())) && (l.dFM()))
    {
      bool = true;
      this.ybT = bool;
      ad.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.ybT) });
      if (this.ybT) {
        dFu();
      }
      yci = 0L;
    }
    for (;;)
    {
      try
      {
        if (i.eK(a.ybD))
        {
          localObject = new j(a.ybD);
          yce = ((j)localObject).getLong(202, 0L) * 10000L;
          ycc = ((j)localObject).getLong(201, 0L);
          ycb = ((j)localObject).getLong(203, 0L);
          ycf = ((j)localObject).getLong(204, 0L);
          ych = ((j)localObject).getLong(209, 0L);
          ycd = ycc;
          ycg = ycf;
          k.arb(dFx());
          i.deleteFile(a.ybD);
          ad.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(ycc), l.mz(yce) });
          AppMethodBeat.o(149309);
          return;
          bool = false;
          break;
        }
        Object localObject = k.dFG();
        ad.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
        if (!bt.isNullOrNil((String)localObject))
        {
          localObject = l.arc((String)localObject);
          yce = localObject[0];
          ycf = localObject[1];
          ycg = localObject[2];
          ych = localObject[3];
          ycb = localObject[4];
          ycc = localObject[5];
          ycd = localObject[6];
        }
        else
        {
          long[] arrayOfLong = new long[7];
        }
      }
      catch (Exception localException)
      {
        yce = 0L;
        ycf = 0L;
        ycg = 0L;
        ych = 0L;
        ycb = 0L;
        ycc = 0L;
        ycd = 0L;
        ad.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        AppMethodBeat.o(149309);
        return;
      }
    }
  }
  
  private void dFt()
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
  
  private boolean dFu()
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
        JSONObject localJSONObject = h.dFB();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          dFt();
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
  
  public static long dFv()
  {
    return ycc;
  }
  
  public static long dFw()
  {
    return yce;
  }
  
  private static String dFx()
  {
    AppMethodBeat.i(149312);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(yce), Long.valueOf(ycf), Long.valueOf(ycg), Long.valueOf(ych), Long.valueOf(ycb), Long.valueOf(ycc), Long.valueOf(ycd) });
    AppMethodBeat.o(149312);
    return str;
  }
  
  private static void dFy()
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
    JSONObject localJSONObject = h.dFB();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      dFt();
      ad.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(149311);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = l.dFK();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(149311);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (yce != l1)
    {
      ad.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { l.mz(l1), l.mz(yce) });
      ycb = paramLong1;
      ycc = 0L;
      ycd = 0L;
      yce = l1;
      ycf = l4;
      ycg = l4;
      ych = paramLong2;
      k.arb(dFx());
      AppMethodBeat.o(149311);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - ycg) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - ycg) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - ych / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - ych / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= ycf) {
        break label641;
      }
      ad.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), l.mz(l2), Long.valueOf(ycf) });
      l3 = paramLong1 - ycd;
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
        ad.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(yci), Long.valueOf(ycc), Long.valueOf(ycd) });
        ycc += l1;
        yci += l1;
        if ((l4 - ycf > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - ycd > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          ycf = l4;
          ycd = paramLong1;
          ycb = paramLong1;
          ycg = l4;
          ych = paramLong2;
          paramString = dFx();
          ad.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          k.arb(paramString);
          if (yci >= 500L)
          {
            dFy();
            yci = 0L;
          }
          AppMethodBeat.o(149311);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < ycb)
          {
            ad.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(ycb), Long.valueOf(ycd) });
            ycb = paramLong1;
            ycd = paramLong1;
            bool = true;
          }
          if ((paramLong1 - ycb >= l6 * j) && (paramLong1 - ycb >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - ycb;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        ycb = paramLong1;
        ycg = l4;
        ych = paramLong2;
        AppMethodBeat.o(149311);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean dFs()
  {
    AppMethodBeat.i(149316);
    if ((l.gb(aj.getContext())) && (l.dFM())) {}
    for (boolean bool = true;; bool = false)
    {
      this.ybT = bool;
      if (!this.ybT) {
        break;
      }
      dFt();
      bool = dFu();
      AppMethodBeat.o(149316);
      return bool;
    }
    dFt();
    AppMethodBeat.o(149316);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    ad.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((aj.eFN()) && (!SportForegroundService.dFJ()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.g
 * JD-Core Version:    0.7.0.1
 */