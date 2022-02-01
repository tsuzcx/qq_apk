package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.l;

public final class r
{
  public static int JzW = 0;
  public static int JzX = 0;
  private final float JzO;
  private final long JzP;
  private final int JzQ;
  public Sensor JzR;
  public boolean JzS;
  private volatile double JzT;
  private volatile long JzU;
  public volatile long JzV;
  public SensorEventListener JzY;
  public a JzZ;
  public SensorManager mSensorManager;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(266159);
    this.JzO = 1.0E-009F;
    this.JzP = 1000000L;
    this.JzQ = 5;
    this.JzS = false;
    this.JzT = 0.0D;
    this.JzU = 0L;
    this.JzV = 0L;
    this.JzY = new SensorEventListener()
    {
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        AppMethodBeat.i(262871);
        if (paramAnonymousSensorEvent.sensor.getType() == 4)
        {
          long l = Math.floor(paramAnonymousSensorEvent.values[2] * 1000000.0F);
          if ((r.a(r.this) == 0L) && (l != 0L)) {
            r.a(r.this, l);
          }
          if (r.a(r.this) == l)
          {
            AppMethodBeat.o(262871);
            return;
          }
          if (r.b(r.this) != 0L)
          {
            float f = (float)(paramAnonymousSensorEvent.timestamp - r.b(r.this));
            r.b(r.this, paramAnonymousSensorEvent.timestamp);
            if (Math.abs(paramAnonymousSensorEvent.values[2]) >= 5.0F)
            {
              if (r.c(r.this) != null) {
                r.c(r.this).fKc();
              }
              AppMethodBeat.o(262871);
              return;
            }
            r.a(r.this, r.d(r.this) + f * 1.0E-009F * paramAnonymousSensorEvent.values[2]);
            f = (float)Math.toDegrees(r.d(r.this));
            if (r.c(r.this) != null) {
              r.c(r.this).bZ(f);
            }
            AppMethodBeat.o(262871);
            return;
          }
          r.b(r.this, paramAnonymousSensorEvent.timestamp);
        }
        AppMethodBeat.o(262871);
      }
    };
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.JzR = this.mSensorManager.getDefaultSensor(4);
    try
    {
      long l1 = System.currentTimeMillis();
      if ((JzW == 0) && (this.mSensorManager.getDefaultSensor(1) != null)) {
        JzW = 1;
      }
      if ((JzX == 0) && (this.mSensorManager.getDefaultSensor(9) != null)) {
        JzX = 1;
      }
      long l2 = System.currentTimeMillis();
      new StringBuilder("get sensor cost=").append(l2 - l1);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        new StringBuilder("get sensor exp=").append(paramContext.toString());
      }
      yh(true);
      AppMethodBeat.o(266159);
    }
    if (this.JzR == null)
    {
      new StringBuilder("device has no Gyroscope sensor, model=").append(Build.MODEL).append(", brand=").append(Build.BRAND);
      yh(false);
      AppMethodBeat.o(266159);
      return;
    }
  }
  
  private static void yh(boolean paramBoolean)
  {
    AppMethodBeat.i(266160);
    if (paramBoolean)
    {
      h.IzE.el(1572, 1);
      l.a(l.JQM, "", 1, 1, "");
      AppMethodBeat.o(266160);
      return;
    }
    h.IzE.el(1572, 2);
    l.a(l.JQM, "", 1, 2, "");
    AppMethodBeat.o(266160);
  }
  
  public final void reset()
  {
    this.JzU = 0L;
    this.JzT = 0.0D;
  }
  
  public static abstract interface a
  {
    public abstract void bZ(float paramFloat);
    
    public abstract void fKc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.r
 * JD-Core Version:    0.7.0.1
 */