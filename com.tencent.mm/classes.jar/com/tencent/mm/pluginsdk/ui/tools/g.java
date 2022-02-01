package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class g
  implements w.a
{
  public static g Cmw = null;
  private SensorEventListener BpP;
  private float[] Cms;
  int Cmt;
  int Cmu;
  private SensorManager Cmv;
  public boolean hasInit;
  
  public g()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.Cms = new float[3];
    this.Cmt = -10000;
    this.Cmu = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void eAK()
  {
    AppMethodBeat.i(152391);
    ad.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.Cmv != null) && (this.BpP != null))
    {
      ad.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.Cmv.unregisterListener(this.BpP);
      this.Cmv = null;
      this.BpP = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final int eAJ()
  {
    AppMethodBeat.i(152388);
    ad.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.Cmt);
    int i = this.Cmt;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final void ekM()
  {
    AppMethodBeat.i(152392);
    Cmw = null;
    eAK();
    AppMethodBeat.o(152392);
  }
  
  public final void ekN()
  {
    AppMethodBeat.i(152394);
    eAK();
    AppMethodBeat.o(152394);
  }
  
  public final void gD(Context paramContext)
  {
    AppMethodBeat.i(152393);
    hl(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    AppMethodBeat.i(152389);
    ad.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.Cmu);
    int i = this.Cmu;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final void hl(Context paramContext)
  {
    AppMethodBeat.i(152390);
    ad.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      ad.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.Cmv == null) {
      this.Cmv = ((SensorManager)aj.getContext().getSystemService("sensor"));
    }
    if (this.BpP == null) {
      this.BpP = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
          AppMethodBeat.i(152386);
          ad.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
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
            if (g.this.Cmt == -10000) {
              g.this.Cmt = ((int)g.a(g.this)[0]);
            }
            for (;;)
            {
              if (g.this.Cmt == 0) {
                g.this.Cmt = 1;
              }
              if (g.this.Cmt == 365) {
                g.this.Cmt = 364;
              }
              if (g.this.Cmu != -10000) {
                break;
              }
              g.this.Cmu = ((int)g.a(g.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((g.a(g.this)[0] - g.this.Cmt > 300.0F) || (g.a(g.this)[0] - g.this.Cmt < -300.0F)) {
                g.this.Cmt = ((int)g.a(g.this)[0]);
              } else {
                g.this.Cmt = ((int)(g.this.Cmt * 0.6D + g.a(g.this)[0] * 0.4D));
              }
            }
            if (g.a(g.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (g.a(g.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              g.this.Cmu = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (g.a(g.this)[1] > 89.0F)
            {
              g.this.Cmu = 89;
              AppMethodBeat.o(152385);
              return;
            }
            g.this.Cmu = ((int)(g.this.Cmu * 0.6D + g.a(g.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.Cmv.registerListener(this.BpP, this.Cmv.getDefaultSensor(3), 3);
    this.hasInit = true;
    ad.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */