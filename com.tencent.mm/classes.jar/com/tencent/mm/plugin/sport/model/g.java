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
import com.tencent.mm.g.a.nd;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.json.JSONObject;

public final class g
  implements SensorEventListener
{
  private static long spH = 0L;
  private static long spI = 0L;
  private static long spJ = 0L;
  private static long spK = 0L;
  private static long spL = 0L;
  private static long spM = 0L;
  private static long spN = 0L;
  private static long spO = 0L;
  private Sensor sensor;
  private SensorManager sensorManager;
  private c<nd> spP;
  private boolean spy;
  
  public g()
  {
    AppMethodBeat.i(93668);
    this.spy = false;
    this.spP = new g.1(this);
    if (d.fv(28))
    {
      ab.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.spP.alive();
    }
    boolean bool;
    if ((n.fa(ah.getContext())) && (n.cza()))
    {
      bool = true;
      this.spy = bool;
      ab.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.spy) });
      if (this.spy) {
        cyH();
      }
      spO = 0L;
    }
    for (;;)
    {
      try
      {
        if (e.cN(a.spi))
        {
          localObject = new j(a.spi);
          spK = ((j)localObject).getLong(202, 0L) * 10000L;
          spI = ((j)localObject).getLong(201, 0L);
          spH = ((j)localObject).getLong(203, 0L);
          spL = ((j)localObject).getLong(204, 0L);
          spN = ((j)localObject).getLong(209, 0L);
          spJ = spI;
          spM = spL;
          k.acy(cyL());
          e.deleteFile(a.spi);
          ab.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", new Object[] { Long.valueOf(spI), n.ha(spK) });
          AppMethodBeat.o(93668);
          return;
          bool = false;
          break;
        }
        Object localObject = k.cyU();
        ab.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", new Object[] { localObject });
        if (!bo.isNullOrNil((String)localObject))
        {
          localObject = n.acz((String)localObject);
          spK = localObject[0];
          spL = localObject[1];
          spM = localObject[2];
          spN = localObject[3];
          spH = localObject[4];
          spI = localObject[5];
          spJ = localObject[6];
        }
        else
        {
          long[] arrayOfLong = new long[7];
        }
      }
      catch (Exception localException)
      {
        spK = 0L;
        spL = 0L;
        spM = 0L;
        spN = 0L;
        spH = 0L;
        spI = 0L;
        spJ = 0L;
        ab.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", localException, "PushSportStepDetector constructor", new Object[0]);
        AppMethodBeat.o(93668);
        return;
      }
    }
  }
  
  private void cyG()
  {
    AppMethodBeat.i(93674);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ah.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ab.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(93674);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93674);
    }
  }
  
  private boolean cyH()
  {
    AppMethodBeat.i(93673);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ah.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ab.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(93673);
          return false;
        }
        JSONObject localJSONObject = h.cyP();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          cyG();
        }
        ab.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(93673);
        return bool;
      }
      ab.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(93673);
    return false;
  }
  
  public static long cyJ()
  {
    return spI;
  }
  
  public static long cyK()
  {
    return spK;
  }
  
  private static String cyL()
  {
    AppMethodBeat.i(93671);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[] { Long.valueOf(spK), Long.valueOf(spL), Long.valueOf(spM), Long.valueOf(spN), Long.valueOf(spH), Long.valueOf(spI), Long.valueOf(spJ) });
    AppMethodBeat.o(93671);
    return str;
  }
  
  private static void cyM()
  {
    AppMethodBeat.i(93672);
    ab.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
    Intent localIntent = new Intent();
    localIntent.setPackage(ah.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.plugin.sport.uploadstep");
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(93672);
  }
  
  public final void b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(93670);
    JSONObject localJSONObject = h.cyP();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      cyG();
      ab.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
      AppMethodBeat.o(93670);
      return;
    }
    int j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
    long l1 = n.cyY();
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(93670);
      return;
    }
    long l4 = System.currentTimeMillis();
    if (spK != l1)
    {
      ab.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { n.ha(l1), n.ha(spK) });
      spH = paramLong1;
      spI = 0L;
      spJ = 0L;
      spK = l1;
      spL = l4;
      spM = l4;
      spN = paramLong2;
      k.acy(cyL());
      AppMethodBeat.o(93670);
      return;
    }
    long l2 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    l1 = 0L;
    long l3 = (l4 - spM) / 300000L;
    int i;
    long l5;
    label254:
    long l6;
    boolean bool;
    Object localObject1;
    if ((l4 - spM) % 300000L > 0L)
    {
      i = 1;
      l5 = l3 + i;
      l3 = (paramLong2 / 1000000L - spN / 1000000L) / 300000L;
      if ((paramLong2 / 1000000L - spN / 1000000L) % 300000L <= 0L) {
        break label635;
      }
      i = 1;
      l6 = l3 + i;
      bool = false;
      localObject1 = "";
      if (l2 <= spL) {
        break label641;
      }
      ab.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), n.ha(l2), Long.valueOf(spL) });
      l3 = paramLong1 - spJ;
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
        ab.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { paramString, localObject1, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(spO), Long.valueOf(spI), Long.valueOf(spJ) });
        spI += l1;
        spO += l1;
        if ((l4 - spL > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (paramLong1 - spJ > localJSONObject.optInt("stepCounterSaveStep")) || (bool))
        {
          spL = l4;
          spJ = paramLong1;
          spH = paramLong1;
          spM = l4;
          spN = paramLong2;
          paramString = cyL();
          ab.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", new Object[] { paramString });
          k.acy(paramString);
          if (spO >= 500L)
          {
            cyM();
            spO = 0L;
          }
          AppMethodBeat.o(93670);
          return;
          i = 0;
          break;
          label635:
          i = 0;
          break label254;
          if (paramLong1 < spH)
          {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(spH), Long.valueOf(spJ) });
            spH = paramLong1;
            spJ = paramLong1;
            bool = true;
          }
          if ((paramLong1 - spH >= l6 * j) && (paramLong1 - spH >= l5 * j)) {
            break label762;
          }
          l1 = paramLong1 - spH;
          localObject1 = "normalIncrease Valid Step";
          continue;
        }
        spH = paramLong1;
        spM = l4;
        spN = paramLong2;
        AppMethodBeat.o(93670);
        return;
        label762:
        localObject1 = "";
      }
    }
  }
  
  public final boolean cyF()
  {
    AppMethodBeat.i(93675);
    if ((n.fa(ah.getContext())) && (n.cza())) {}
    for (boolean bool = true;; bool = false)
    {
      this.spy = bool;
      if (!this.spy) {
        break;
      }
      cyG();
      bool = cyH();
      AppMethodBeat.o(93675);
      return bool;
    }
    cyG();
    AppMethodBeat.o(93675);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(93669);
    ab.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if ((ah.dsZ()) && (!SportForegroundService.cyX()))
    {
      ab.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
      AppMethodBeat.o(93669);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      ab.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
      b(paramSensorEvent.values[0], paramSensorEvent.timestamp, "PUSH");
      AppMethodBeat.o(93669);
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
        ab.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(93669);
        return;
      }
    }
    ab.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      ab.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(93669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.g
 * JD-Core Version:    0.7.0.1
 */