package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class g
  implements w.a
{
  public static g FCr = null;
  private SensorEventListener EDL;
  private float[] FCn;
  int FCo;
  int FCp;
  private SensorManager FCq;
  public boolean hasInit;
  
  public g()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.FCn = new float[3];
    this.FCo = -10000;
    this.FCp = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void fiW()
  {
    AppMethodBeat.i(152391);
    ae.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.FCq != null) && (this.EDL != null))
    {
      ae.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.FCq.unregisterListener(this.EDL);
      this.FCq = null;
      this.EDL = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final void eSH()
  {
    AppMethodBeat.i(152392);
    FCr = null;
    fiW();
    AppMethodBeat.o(152392);
  }
  
  public final void eSI()
  {
    AppMethodBeat.i(152394);
    fiW();
    AppMethodBeat.o(152394);
  }
  
  public final int fiV()
  {
    AppMethodBeat.i(152388);
    ae.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.FCo);
    int i = this.FCo;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final void gZ(Context paramContext)
  {
    AppMethodBeat.i(152393);
    hH(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    AppMethodBeat.i(152389);
    ae.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.FCp);
    int i = this.FCp;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final void hH(Context paramContext)
  {
    AppMethodBeat.i(152390);
    ae.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      ae.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.FCq == null) {
      this.FCq = ((SensorManager)ak.getContext().getSystemService("sensor"));
    }
    if (this.EDL == null) {
      this.EDL = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
          AppMethodBeat.i(152386);
          ae.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
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
            if (g.this.FCo == -10000) {
              g.this.FCo = ((int)g.a(g.this)[0]);
            }
            for (;;)
            {
              if (g.this.FCo == 0) {
                g.this.FCo = 1;
              }
              if (g.this.FCo == 365) {
                g.this.FCo = 364;
              }
              if (g.this.FCp != -10000) {
                break;
              }
              g.this.FCp = ((int)g.a(g.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((g.a(g.this)[0] - g.this.FCo > 300.0F) || (g.a(g.this)[0] - g.this.FCo < -300.0F)) {
                g.this.FCo = ((int)g.a(g.this)[0]);
              } else {
                g.this.FCo = ((int)(g.this.FCo * 0.6D + g.a(g.this)[0] * 0.4D));
              }
            }
            if (g.a(g.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (g.a(g.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              g.this.FCp = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (g.a(g.this)[1] > 89.0F)
            {
              g.this.FCp = 89;
              AppMethodBeat.o(152385);
              return;
            }
            g.this.FCp = ((int)(g.this.FCp * 0.6D + g.a(g.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.FCq.registerListener(this.EDL, this.FCq.getDefaultSensor(3), 3);
    this.hasInit = true;
    ae.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */