package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  implements y.a
{
  public static i Kvp = null;
  private SensorEventListener Jtm;
  private float[] Kvl;
  int Kvm;
  int Kvn;
  private SensorManager Kvo;
  public boolean hasInit;
  
  public i()
  {
    AppMethodBeat.i(152387);
    this.hasInit = false;
    this.Kvl = new float[3];
    this.Kvm = -10000;
    this.Kvn = -10000;
    AppMethodBeat.o(152387);
  }
  
  private void gsx()
  {
    AppMethodBeat.i(152391);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.Kvo != null) && (this.Jtm != null))
    {
      Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.Kvo.unregisterListener(this.Jtm);
      this.Kvo = null;
      this.Jtm = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(152391);
  }
  
  public final void gbt()
  {
    AppMethodBeat.i(152392);
    Kvp = null;
    gsx();
    AppMethodBeat.o(152392);
  }
  
  public final void gbu()
  {
    AppMethodBeat.i(152394);
    gsx();
    AppMethodBeat.o(152394);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    AppMethodBeat.i(152389);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.Kvn);
    int i = this.Kvn;
    AppMethodBeat.o(152389);
    return i;
  }
  
  public final int gsw()
  {
    AppMethodBeat.i(152388);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.Kvm);
    int i = this.Kvm;
    AppMethodBeat.o(152388);
    return i;
  }
  
  public final void hU(Context paramContext)
  {
    AppMethodBeat.i(152393);
    iB(paramContext);
    AppMethodBeat.o(152393);
  }
  
  public final void iB(Context paramContext)
  {
    AppMethodBeat.i(152390);
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      Log.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(152390);
      return;
    }
    if (this.Kvo == null) {
      this.Kvo = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    }
    if (this.Jtm == null) {
      this.Jtm = new SensorEventListener()
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
            i.a(i.this)[0] = paramAnonymousSensorEvent.values[0];
            i.a(i.this)[1] = paramAnonymousSensorEvent.values[1];
            i.a(i.this)[2] = paramAnonymousSensorEvent.values[2];
            if (i.this.Kvm == -10000) {
              i.this.Kvm = ((int)i.a(i.this)[0]);
            }
            for (;;)
            {
              if (i.this.Kvm == 0) {
                i.this.Kvm = 1;
              }
              if (i.this.Kvm == 365) {
                i.this.Kvm = 364;
              }
              if (i.this.Kvn != -10000) {
                break;
              }
              i.this.Kvn = ((int)i.a(i.this)[1]);
              AppMethodBeat.o(152385);
              return;
              if ((i.a(i.this)[0] - i.this.Kvm > 300.0F) || (i.a(i.this)[0] - i.this.Kvm < -300.0F)) {
                i.this.Kvm = ((int)i.a(i.this)[0]);
              } else {
                i.this.Kvm = ((int)(i.this.Kvm * 0.6D + i.a(i.this)[0] * 0.4D));
              }
            }
            if (i.a(i.this)[1] < -68.0F)
            {
              int j = (int)(-68.0D + (i.a(i.this)[1] + 68.0F) / 1.5D);
              int i = j;
              if (j < -89) {
                i = -89;
              }
              i.this.Kvn = i;
              AppMethodBeat.o(152385);
              return;
            }
            if (i.a(i.this)[1] > 89.0F)
            {
              i.this.Kvn = 89;
              AppMethodBeat.o(152385);
              return;
            }
            i.this.Kvn = ((int)(i.this.Kvn * 0.6D + i.a(i.this)[1] * 0.4D));
          }
          AppMethodBeat.o(152385);
        }
      };
    }
    boolean bool = this.Kvo.registerListener(this.Jtm, this.Kvo.getDefaultSensor(3), 3);
    this.hasInit = true;
    Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(152390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */