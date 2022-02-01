package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private long Fjk;
  private long Fjl;
  private boolean Fjm;
  private Sensor sensor;
  private SensorManager sensorManager;
  
  public c()
  {
    AppMethodBeat.i(149294);
    this.Fjk = 0L;
    this.Fjl = 0L;
    if ((k.hg(MMApplicationContext.getContext())) && (k.fmg())) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fjm = bool;
      Log.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.Fjm) });
      if (this.Fjm) {
        fmr();
      }
      AppMethodBeat.o(149294);
      return;
    }
  }
  
  private boolean fmr()
  {
    AppMethodBeat.i(149297);
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
          Log.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149297);
          return false;
        }
        JSONObject localJSONObject = g.fmy();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool)
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnQ, Integer.valueOf(1));
          fmq();
        }
        for (;;)
        {
          Log.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(149297);
          return bool;
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnQ, Integer.valueOf(0));
        }
        AppMethodBeat.o(149297);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
    }
    for (;;)
    {
      return false;
      Log.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
    }
  }
  
  public final boolean fmp()
  {
    AppMethodBeat.i(149295);
    if ((k.hg(MMApplicationContext.getContext())) && (k.fmg())) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fjm = bool;
      if (!this.Fjm) {
        break;
      }
      fmq();
      bool = fmr();
      AppMethodBeat.o(149295);
      return bool;
    }
    fmq();
    AppMethodBeat.o(149295);
    return false;
  }
  
  public final void fmq()
  {
    AppMethodBeat.i(149296);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      Log.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149296);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149296);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149293);
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      final long l1 = paramSensorEvent.values[0];
      long l2 = paramSensorEvent.timestamp;
      Log.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      if ((Math.abs(l1 - this.Fjk) >= 20L) || (System.currentTimeMillis() - this.Fjl >= 60000L))
      {
        Log.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.Fjk = l1;
        this.Fjl = System.currentTimeMillis();
        h.RTc.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149292);
            try
            {
              Uri localUri = Uri.parse("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_SPORT());
              MMApplicationContext.getContext().getContentResolver().query(localUri, null, "Key_mmSensorChange", new String[] { String.valueOf(l1), String.valueOf(this.Fjo) }, null);
              AppMethodBeat.o(149292);
              return;
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(149292);
            }
          }
        }, "Sport.onSensorChange");
      }
      AppMethodBeat.o(149293);
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
        Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149293);
        return;
      }
    }
    Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int i = 0;
    int j = 0;
    while (j < k)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c
 * JD-Core Version:    0.7.0.1
 */