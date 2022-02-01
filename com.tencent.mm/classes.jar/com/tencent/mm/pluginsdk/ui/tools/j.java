package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  implements aa.a
{
  public static j RwC = null;
  private SensorEventListener QqL;
  int RwA;
  private SensorManager RwB;
  private float[] Rwy;
  int Rwz;
  public boolean hasInit;
  
  public j()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.Rwy = new float[3];
    this.Rwz = -10000;
    this.RwA = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void hnE()
  {
    AppMethodBeat.i(152391);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.RwB != null) && (this.QqL != null))
    {
      Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.RwB.unregisterListener(this.QqL);
      this.RwB = null;
      this.QqL = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final void gUn()
  {
    AppMethodBeat.i(152392);
    RwC = null;
    hnE();
    AppMethodBeat.o(152392);
  }
  
  public final void gUo()
  {
    AppMethodBeat.i(152394);
    hnE();
    AppMethodBeat.o(152394);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int hnC()
  {
    AppMethodBeat.i(152388);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.Rwz);
    int i = this.Rwz;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final int hnD()
  {
    AppMethodBeat.i(152389);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.RwA);
    int i = this.RwA;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final void iZ(Context paramContext)
  {
    AppMethodBeat.i(152393);
    jE(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final void jE(Context paramContext)
  {
    AppMethodBeat.i(152390);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      Log.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.RwB == null) {
      this.RwB = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    }
    if (this.QqL == null) {
      this.QqL = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
          AppMethodBeat.i(152386);
          Log.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
          AppMethodBeat.o(152386);
        }
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          AppMethodBeat.i(152385);
          if (paramAnonymousSensorEvent.sensor.getType() == 3)
          {
            j.a(j.this)[0] = paramAnonymousSensorEvent.values[0];
            j.a(j.this)[1] = paramAnonymousSensorEvent.values[1];
            j.a(j.this)[2] = paramAnonymousSensorEvent.values[2];
            if (j.this.Rwz == -10000) {
              j.this.Rwz = ((int)j.a(j.this)[0]);
            }
            for (;;)
            {
              if (j.this.Rwz == 0) {
                j.this.Rwz = 1;
              }
              if (j.this.Rwz == 365) {
                j.this.Rwz = 364;
              }
              if (j.this.RwA != -10000) {
                break;
              }
              j.this.RwA = ((int)j.a(j.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((j.a(j.this)[0] - j.this.Rwz > 300.0F) || (j.a(j.this)[0] - j.this.Rwz < -300.0F)) {
                j.this.Rwz = ((int)j.a(j.this)[0]);
              } else {
                j.this.Rwz = ((int)(j.this.Rwz * 0.6D + j.a(j.this)[0] * 0.4D));
              }
            }
            if (j.a(j.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (j.a(j.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              j.this.RwA = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (j.a(j.this)[1] > 89.0F)
            {
              j.this.RwA = 89;
              AppMethodBeat.o(152385);
              return;
            }
            j.this.RwA = ((int)(j.this.RwA * 0.6D + j.a(j.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.RwB.registerListener(this.QqL, this.RwB.getDefaultSensor(3), 3);
    this.hasInit = true;
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */