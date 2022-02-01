package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class g
  implements w.a
{
  public static g DEN = null;
  private SensorEventListener CHV;
  private float[] DEJ;
  int DEK;
  int DEL;
  private SensorManager DEM;
  public boolean hasInit;
  
  public g()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.DEJ = new float[3];
    this.DEK = -10000;
    this.DEL = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void eQe()
  {
    AppMethodBeat.i(152391);
    ac.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.DEM != null) && (this.CHV != null))
    {
      ac.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.DEM.unregisterListener(this.CHV);
      this.DEM = null;
      this.CHV = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final void eAi()
  {
    AppMethodBeat.i(152392);
    DEN = null;
    eQe();
    AppMethodBeat.o(152392);
  }
  
  public final void eAj()
  {
    AppMethodBeat.i(152394);
    eQe();
    AppMethodBeat.o(152394);
  }
  
  public final int eQd()
  {
    AppMethodBeat.i(152388);
    ac.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.DEK);
    int i = this.DEK;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final void gO(Context paramContext)
  {
    AppMethodBeat.i(152393);
    hw(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    AppMethodBeat.i(152389);
    ac.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.DEL);
    int i = this.DEL;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final void hw(Context paramContext)
  {
    AppMethodBeat.i(152390);
    ac.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      ac.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.DEM == null) {
      this.DEM = ((SensorManager)ai.getContext().getSystemService("sensor"));
    }
    if (this.CHV == null) {
      this.CHV = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
          AppMethodBeat.i(152386);
          ac.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
          AppMethodBeat.o(152386);
        }
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          AppMethodBeat.i(152385);
          if (paramAnonymousSensorEvent.sensor.getType() == 3)
          {
            g.a(g.this)[0] = paramAnonymousSensorEvent.values[0];
            g.a(g.this)[1] = paramAnonymousSensorEvent.values[1];
            g.a(g.this)[2] = paramAnonymousSensorEvent.values[2];
            if (g.this.DEK == -10000) {
              g.this.DEK = ((int)g.a(g.this)[0]);
            }
            for (;;)
            {
              if (g.this.DEK == 0) {
                g.this.DEK = 1;
              }
              if (g.this.DEK == 365) {
                g.this.DEK = 364;
              }
              if (g.this.DEL != -10000) {
                break;
              }
              g.this.DEL = ((int)g.a(g.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((g.a(g.this)[0] - g.this.DEK > 300.0F) || (g.a(g.this)[0] - g.this.DEK < -300.0F)) {
                g.this.DEK = ((int)g.a(g.this)[0]);
              } else {
                g.this.DEK = ((int)(g.this.DEK * 0.6D + g.a(g.this)[0] * 0.4D));
              }
            }
            if (g.a(g.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (g.a(g.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              g.this.DEL = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (g.a(g.this)[1] > 89.0F)
            {
              g.this.DEL = 89;
              AppMethodBeat.o(152385);
              return;
            }
            g.this.DEL = ((int)(g.this.DEL * 0.6D + g.a(g.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.DEM.registerListener(this.CHV, this.DEM.getDefaultSensor(3), 3);
    this.hasInit = true;
    ac.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */