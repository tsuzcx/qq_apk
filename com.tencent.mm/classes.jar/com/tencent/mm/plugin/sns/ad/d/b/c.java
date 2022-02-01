package com.tencent.mm.plugin.sns.ad.d.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class c
  implements a
{
  private Sensor Mug;
  private final long PPl;
  private boolean PPn;
  volatile long PPo;
  private SensorEventListener PPr;
  WeakReference<a.a> PPs;
  private final float PPu;
  private final int PPv;
  volatile double PPw;
  volatile long PPx;
  private SensorManager mSensorManager;
  
  public c(Context paramContext, Sensor paramSensor)
  {
    AppMethodBeat.i(310081);
    this.PPu = 1.0E-009F;
    this.PPl = 1000000L;
    this.PPv = 5;
    this.PPn = false;
    this.PPw = 0.0D;
    this.PPx = 0L;
    this.PPo = 0L;
    this.PPr = new SensorEventListener()
    {
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        AppMethodBeat.i(310086);
        if (paramAnonymousSensorEvent.sensor.getType() == 4)
        {
          long l = Math.floor(paramAnonymousSensorEvent.values[2] * 1000000.0F);
          if ((c.this.PPo == 0L) && (l != 0L))
          {
            Log.d("TwistGyrosImpl", "set initValue");
            c.this.PPo = l;
          }
          if (c.this.PPo == l)
          {
            AppMethodBeat.o(310086);
            return;
          }
          if (c.this.PPx != 0L)
          {
            float f1 = (float)(paramAnonymousSensorEvent.timestamp - c.this.PPx);
            c.this.PPx = paramAnonymousSensorEvent.timestamp;
            float f2 = Math.abs(paramAnonymousSensorEvent.values[2]);
            a.a locala = null;
            if (c.this.PPs != null) {
              locala = (a.a)c.this.PPs.get();
            }
            if (f2 >= 5.0F)
            {
              if (locala != null)
              {
                locala.hab();
                AppMethodBeat.o(310086);
                return;
              }
              Log.e("TwistGyrosImpl", "listener is null, release sensor");
              c.this.setEnabled(false);
              AppMethodBeat.o(310086);
              return;
            }
            c localc = c.this;
            localc.PPw = (1.0E-009F * f1 * paramAnonymousSensorEvent.values[2] + localc.PPw);
            f1 = (float)Math.toDegrees(c.this.PPw);
            if (locala != null)
            {
              locala.df(f1);
              AppMethodBeat.o(310086);
              return;
            }
            Log.e("TwistGyrosImpl", "listener is null, release sensor");
            c.this.setEnabled(false);
            AppMethodBeat.o(310086);
            return;
          }
          c.this.PPx = paramAnonymousSensorEvent.timestamp;
        }
        AppMethodBeat.o(310086);
      }
    };
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.Mug = paramSensor;
    AppMethodBeat.o(310081);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(310104);
    this.PPs = new WeakReference(parama);
    AppMethodBeat.o(310104);
  }
  
  public final boolean haa()
  {
    return this.PPn;
  }
  
  public final void reset()
  {
    this.PPx = 0L;
    this.PPw = 0.0D;
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(310099);
    if (this.Mug == null)
    {
      AppMethodBeat.o(310099);
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
        Log.d("TwistGyrosImpl", "reset initTimestamp");
        this.mSensorManager.registerListener(this.PPr, this.Mug, 1);
        this.PPn = true;
        AppMethodBeat.o(310099);
        return;
      }
      finally
      {
        Log.e("TwistGyrosImpl", "setEnabled exp=" + localObject.toString());
        AppMethodBeat.o(310099);
        return;
      }
    }
    else
    {
      this.mSensorManager.unregisterListener(this.PPr);
      this.PPn = false;
    }
    label116:
    AppMethodBeat.o(310099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b.c
 * JD-Core Version:    0.7.0.1
 */