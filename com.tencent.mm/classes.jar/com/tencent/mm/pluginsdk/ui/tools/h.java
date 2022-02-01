package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class h
  implements z.a
{
  public static h YsP = null;
  private SensorEventListener Xjc;
  private float[] YsM;
  int YsN;
  private SensorManager YsO;
  public boolean hasInit;
  int pitch;
  
  public h()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.YsM = new float[3];
    this.YsN = -10000;
    this.pitch = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void iOw()
  {
    AppMethodBeat.i(152391);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.YsO != null) && (this.Xjc != null))
    {
      Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.YsO.unregisterListener(this.Xjc);
      this.YsO = null;
      this.Xjc = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int iOu()
  {
    AppMethodBeat.i(152388);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.YsN);
    int i = this.YsN;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final int iOv()
  {
    AppMethodBeat.i(152389);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.pitch);
    int i = this.pitch;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final void itU()
  {
    AppMethodBeat.i(152392);
    YsP = null;
    iOw();
    AppMethodBeat.o(152392);
  }
  
  public final void itV()
  {
    AppMethodBeat.i(152394);
    iOw();
    AppMethodBeat.o(152394);
  }
  
  public final void kP(Context paramContext)
  {
    AppMethodBeat.i(152393);
    lD(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final void lD(Context paramContext)
  {
    AppMethodBeat.i(152390);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      Log.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.YsO == null) {
      this.YsO = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    }
    if (this.Xjc == null) {
      this.Xjc = new SensorEventListener()
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
            h.a(h.this)[0] = paramAnonymousSensorEvent.values[0];
            h.a(h.this)[1] = paramAnonymousSensorEvent.values[1];
            h.a(h.this)[2] = paramAnonymousSensorEvent.values[2];
            if (h.this.YsN == -10000) {
              h.this.YsN = ((int)h.a(h.this)[0]);
            }
            for (;;)
            {
              if (h.this.YsN == 0) {
                h.this.YsN = 1;
              }
              if (h.this.YsN == 365) {
                h.this.YsN = 364;
              }
              if (h.this.pitch != -10000) {
                break;
              }
              h.this.pitch = ((int)h.a(h.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((h.a(h.this)[0] - h.this.YsN > 300.0F) || (h.a(h.this)[0] - h.this.YsN < -300.0F)) {
                h.this.YsN = ((int)h.a(h.this)[0]);
              } else {
                h.this.YsN = ((int)(h.this.YsN * 0.6D + h.a(h.this)[0] * 0.4D));
              }
            }
            if (h.a(h.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (h.a(h.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              h.this.pitch = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (h.a(h.this)[1] > 89.0F)
            {
              h.this.pitch = 89;
              AppMethodBeat.o(152385);
              return;
            }
            h.this.pitch = ((int)(h.this.pitch * 0.6D + h.a(h.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.YsO.registerListener(this.Xjc, this.YsO.getDefaultSensor(3), 3);
    this.hasInit = true;
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */