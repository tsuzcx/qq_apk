package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class b
{
  private a QiV;
  private SensorManager manager;
  
  public b()
  {
    AppMethodBeat.i(310531);
    this.manager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(310531);
  }
  
  private boolean hdF()
  {
    AppMethodBeat.i(310540);
    if (this.manager == null)
    {
      Log.e("MicroMsg.SnsAdShakeSensor", "cannot init sensor manager");
      AppMethodBeat.o(310540);
      return false;
    }
    List localList = this.manager.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      AppMethodBeat.o(310540);
      return true;
    }
    AppMethodBeat.o(310540);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(310555);
    cuD();
    if (hdF())
    {
      this.QiV = parama;
      this.manager.registerListener(this.QiV, this.manager.getDefaultSensor(1), 1);
      AppMethodBeat.o(310555);
      return;
    }
    Log.e("MicroMsg.SnsAdShakeSensor", "no sensor found for shake detection");
    AppMethodBeat.o(310555);
  }
  
  public final void cuD()
  {
    AppMethodBeat.i(310562);
    if (this.QiV != null)
    {
      this.QiV.onRelease();
      this.manager.unregisterListener(this.QiV, this.manager.getDefaultSensor(1));
      this.QiV = null;
    }
    AppMethodBeat.o(310562);
  }
  
  public final boolean hdD()
  {
    return this.QiV != null;
  }
  
  public final boolean hdE()
  {
    AppMethodBeat.i(310567);
    if (hdF())
    {
      AppMethodBeat.o(310567);
      return true;
    }
    AppMethodBeat.o(310567);
    return false;
  }
  
  public static abstract class a
    implements SensorEventListener
  {
    private static int QiY = 5;
    private int QiW = 5;
    private int QiX = 9;
    private float[] mPrev = new float[3];
    private final float[] mScale = { 2.0F, 2.5F, 0.5F };
    
    static
    {
      if (Build.MODEL.equals("LG-E510")) {
        QiY = 4;
      }
    }
    
    public a(int paramInt1, int paramInt2)
    {
      this.QiW = paramInt1;
      this.QiX = paramInt2;
      QiY = this.QiW;
      Log.i("MicroMsg.ShakeSensorListener", "ShakeSensorListener, min=" + this.QiW + ", max=" + this.QiX + ", sThreshold=" + QiY);
    }
    
    public abstract void hdB();
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public abstract void onRelease();
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float[] arrayOfFloat1 = new float[3];
      float[] arrayOfFloat2 = paramSensorEvent.values;
      int i = 0;
      int j = 0;
      if (i < 3)
      {
        arrayOfFloat1[i] = Math.round(this.mScale[i] * (arrayOfFloat2[i] - this.mPrev[i]) * 0.45F);
        float f = Math.abs(arrayOfFloat1[i]);
        if (QiY < this.QiX)
        {
          if (f < 14.0F) {
            break label150;
          }
          QiY = this.QiX;
        }
        for (;;)
        {
          if (f > 4.0F) {
            Log.d("MicroMsg.ShakeSensorListener", "selfAdaptation, result=" + f + " sThreshold=" + QiY);
          }
          if (f > QiY) {
            j = 1;
          }
          this.mPrev[i] = arrayOfFloat2[i];
          i += 1;
          break;
          label150:
          int k = (int)f;
          if (QiY < k - 4) {
            QiY = k - 4;
          }
        }
      }
      if (j != 0)
      {
        Log.d("MicroMsg.ShakeSensorListener", "sensorChanged " + paramSensorEvent.sensor.getName() + " (" + arrayOfFloat2[0] + ", " + arrayOfFloat2[1] + ", " + arrayOfFloat2[2] + ") diff(" + arrayOfFloat1[0] + " " + arrayOfFloat1[1] + " " + arrayOfFloat1[2] + ")");
        hdB();
        paramSensorEvent = paramSensorEvent.values;
      }
    }
    
    public final void reset()
    {
      Log.i("MicroMsg.ShakeSensorListener", "reset threadHold");
      QiY = this.QiW;
      if (Build.MODEL.equals("LG-E510")) {
        QiY = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.b
 * JD-Core Version:    0.7.0.1
 */