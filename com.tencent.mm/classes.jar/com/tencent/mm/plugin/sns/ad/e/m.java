package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.j;

public final class m
{
  private final float DsZ;
  private final long Dta;
  private final int Dtb;
  public Sensor Dtc;
  public boolean Dtd;
  volatile double Dte;
  volatile long Dtf;
  public volatile long Dtg;
  public SensorEventListener Dth;
  public a Dti;
  public SensorManager mSensorManager;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(201945);
    this.DsZ = 1.0E-009F;
    this.Dta = 1000000L;
    this.Dtb = 5;
    this.Dtd = false;
    this.Dte = 0.0D;
    this.Dtf = 0L;
    this.Dtg = 0L;
    this.Dth = new SensorEventListener()
    {
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        AppMethodBeat.i(201944);
        if (paramAnonymousSensorEvent.sensor.getType() == 4)
        {
          long l = Math.floor(paramAnonymousSensorEvent.values[2] * 1000000.0F);
          if ((m.this.Dtg == 0L) && (l != 0L)) {
            m.this.Dtg = l;
          }
          if (m.this.Dtg == l)
          {
            AppMethodBeat.o(201944);
            return;
          }
          if (m.this.Dtf != 0L)
          {
            float f = (float)(paramAnonymousSensorEvent.timestamp - m.this.Dtf);
            m.this.Dtf = paramAnonymousSensorEvent.timestamp;
            if (Math.abs(paramAnonymousSensorEvent.values[2]) >= 5.0F)
            {
              if (m.this.Dti != null) {
                m.this.Dti.eWR();
              }
              AppMethodBeat.o(201944);
              return;
            }
            m.this.Dte += f * 1.0E-009F * paramAnonymousSensorEvent.values[2];
            f = (float)Math.toDegrees(m.this.Dte);
            if (m.this.Dti != null) {
              m.this.Dti.bS(f);
            }
            AppMethodBeat.o(201944);
            return;
          }
          m.this.Dtf = paramAnonymousSensorEvent.timestamp;
        }
        AppMethodBeat.o(201944);
      }
    };
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.Dtc = this.mSensorManager.getDefaultSensor(4);
    if (this.Dtc == null)
    {
      new StringBuilder("device has no Gyroscope sensor, model=").append(Build.MODEL).append(", brand=").append(Build.BRAND);
      uJ(false);
      AppMethodBeat.o(201945);
      return;
    }
    uJ(true);
    AppMethodBeat.o(201945);
  }
  
  private static void uJ(boolean paramBoolean)
  {
    AppMethodBeat.i(201946);
    if (paramBoolean)
    {
      h.CyF.dN(1572, 1);
      j.b(j.DEd, "", 1, 1, "");
      AppMethodBeat.o(201946);
      return;
    }
    h.CyF.dN(1572, 2);
    j.b(j.DEd, "", 1, 2, "");
    AppMethodBeat.o(201946);
  }
  
  public final void reset()
  {
    this.Dtf = 0L;
    this.Dte = 0.0D;
  }
  
  public static abstract interface a
  {
    public abstract void bS(float paramFloat);
    
    public abstract void eWR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.m
 * JD-Core Version:    0.7.0.1
 */