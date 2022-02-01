package com.tencent.mm.plugin.sns.ad.d.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class b
  implements a
{
  private Sensor Mug;
  private final long PPl;
  private final float PPm;
  private boolean PPn;
  volatile long PPo;
  float PPp;
  float PPq;
  private SensorEventListener PPr;
  WeakReference<a.a> PPs;
  private SensorManager mSensorManager;
  
  public b(Context paramContext, Sensor paramSensor)
  {
    AppMethodBeat.i(310092);
    this.PPl = 1000000L;
    this.PPm = 9.8F;
    this.PPn = false;
    this.PPo = 0L;
    this.PPp = 0.0F;
    this.PPq = 0.0F;
    this.PPr = new SensorEventListener()
    {
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        double d1 = 1.0D;
        AppMethodBeat.i(310082);
        float f;
        double d2;
        if (paramAnonymousSensorEvent.sensor.getType() == 9)
        {
          f = paramAnonymousSensorEvent.values[0];
          float[] arrayOfFloat = paramAnonymousSensorEvent.values;
          arrayOfFloat = paramAnonymousSensorEvent.values;
          long l = Math.floor(paramAnonymousSensorEvent.values[0] * 1000000.0F);
          if ((b.this.PPo == 0L) && (l != 0L))
          {
            Log.d("TwistGravityImpl", "set initValue");
            b.this.PPo = l;
          }
          if (b.this.PPo == l)
          {
            AppMethodBeat.o(310082);
            return;
          }
          d2 = f / 9.8F;
          if (d2 < 1.0D) {}
        }
        for (;;)
        {
          f = (float)Math.toDegrees(Math.asin(d1));
          if (b.this.PPp == 0.0F) {
            b.this.PPp = f;
          }
          b.this.PPq = (f - b.this.PPp);
          paramAnonymousSensorEvent = null;
          if (b.this.PPs != null) {
            paramAnonymousSensorEvent = (a.a)b.this.PPs.get();
          }
          if (paramAnonymousSensorEvent != null)
          {
            paramAnonymousSensorEvent.df(b.this.PPq);
            AppMethodBeat.o(310082);
            return;
            if (d2 <= -1.0D) {
              d1 = -1.0D;
            }
          }
          else
          {
            Log.e("TwistGravityImpl", "listener is null, release sensor");
            b.this.setEnabled(false);
            AppMethodBeat.o(310082);
            return;
          }
          d1 = d2;
        }
      }
    };
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.Mug = paramSensor;
    AppMethodBeat.o(310092);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(310110);
    this.PPs = new WeakReference(parama);
    AppMethodBeat.o(310110);
  }
  
  public final boolean haa()
  {
    return this.PPn;
  }
  
  public final void reset()
  {
    this.PPp = 0.0F;
    this.PPq = 0.0F;
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(310108);
    if (this.Mug == null)
    {
      AppMethodBeat.o(310108);
      return;
    }
    if (paramBoolean)
    {
      try
      {
        if (this.PPn) {
          break label116;
        }
        this.PPo = 0L;
        Log.d("TwistGravityImpl", "reset initTimestamp");
        this.mSensorManager.registerListener(this.PPr, this.Mug, 1);
        this.PPn = true;
        AppMethodBeat.o(310108);
        return;
      }
      finally
      {
        Log.e("TwistGravityImpl", "setEnabled exp=" + localObject.toString());
        AppMethodBeat.o(310108);
        return;
      }
    }
    else
    {
      this.mSensorManager.unregisterListener(this.PPr);
      this.PPn = false;
    }
    label116:
    AppMethodBeat.o(310108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b.b
 * JD-Core Version:    0.7.0.1
 */