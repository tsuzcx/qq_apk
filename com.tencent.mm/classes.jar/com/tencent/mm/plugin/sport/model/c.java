package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private Sensor sensor;
  private SensorManager sensorManager;
  private long spw;
  private long spx;
  private boolean spy;
  
  public c()
  {
    AppMethodBeat.i(93653);
    this.spw = 0L;
    this.spx = 0L;
    if ((n.fa(ah.getContext())) && (n.cyu())) {}
    for (boolean bool = true;; bool = false)
    {
      this.spy = bool;
      ab.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.spy) });
      if (this.spy) {
        cyH();
      }
      AppMethodBeat.o(93653);
      return;
    }
  }
  
  private boolean cyH()
  {
    AppMethodBeat.i(93656);
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
          ab.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(93656);
          return false;
        }
        JSONObject localJSONObject = h.cyP();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          cyG();
        }
        ab.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(93656);
        return bool;
      }
      ab.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(93656);
    return false;
  }
  
  public final boolean cyF()
  {
    AppMethodBeat.i(93654);
    if ((n.fa(ah.getContext())) && (n.cyu())) {}
    for (boolean bool = true;; bool = false)
    {
      this.spy = bool;
      if (!this.spy) {
        break;
      }
      cyG();
      bool = cyH();
      AppMethodBeat.o(93654);
      return bool;
    }
    cyG();
    AppMethodBeat.o(93654);
    return false;
  }
  
  public final void cyG()
  {
    AppMethodBeat.i(93655);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ah.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ab.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(93655);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93655);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(93652);
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      final long l1 = paramSensorEvent.values[0];
      long l2 = paramSensorEvent.timestamp;
      ab.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      if ((Math.abs(l1 - this.spw) >= 20L) || (System.currentTimeMillis() - this.spx >= 60000L))
      {
        ab.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.spw = l1;
        this.spx = System.currentTimeMillis();
        d.ysm.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(93651);
            try
            {
              Uri localUri = Uri.parse("content://com.tencent.mm.plugin.sport");
              ah.getContext().getContentResolver().query(localUri, null, "Key_mmSensorChange", new String[] { String.valueOf(l1), String.valueOf(this.spA) }, null);
              AppMethodBeat.o(93651);
              return;
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(93651);
            }
          }
        }, "Sport.onSensorChange");
      }
      AppMethodBeat.o(93652);
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
        ab.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(93652);
        return;
      }
    }
    ab.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int i = 0;
    int j = 0;
    while (j < k)
    {
      ab.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(93652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c
 * JD-Core Version:    0.7.0.1
 */