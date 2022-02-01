package com.tencent.mm.pluginsdk.l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public class d
{
  private a XXu;
  private SensorManager manager;
  
  public d()
  {
    AppMethodBeat.i(152093);
    this.manager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(152093);
  }
  
  private boolean hdF()
  {
    AppMethodBeat.i(152098);
    if (this.manager == null)
    {
      Log.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
      AppMethodBeat.o(152098);
      return false;
    }
    List localList = this.manager.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      AppMethodBeat.o(152098);
      return true;
    }
    AppMethodBeat.o(152098);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152095);
    cuD();
    if (hdF())
    {
      this.XXu = parama;
      this.manager.registerListener(this.XXu, this.manager.getDefaultSensor(1), 1);
      AppMethodBeat.o(152095);
      return;
    }
    Log.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    AppMethodBeat.o(152095);
  }
  
  public final void cuD()
  {
    AppMethodBeat.i(152096);
    if (this.XXu != null)
    {
      this.XXu.onRelease();
      this.manager.unregisterListener(this.XXu, this.manager.getDefaultSensor(1));
      this.XXu = null;
    }
    AppMethodBeat.o(152096);
  }
  
  public final boolean hdD()
  {
    return this.XXu != null;
  }
  
  public final boolean hdE()
  {
    AppMethodBeat.i(152097);
    if (hdF())
    {
      AppMethodBeat.o(152097);
      return true;
    }
    AppMethodBeat.o(152097);
    return false;
  }
  
  public final void iJU()
  {
    AppMethodBeat.i(152094);
    if (this.XXu != null) {
      this.XXu.reset();
    }
    AppMethodBeat.o(152094);
  }
  
  public static abstract class a
    implements SensorEventListener
  {
    private static final String LG_E510 = "LG-E510";
    private static final String TAG = "MicroMsg.ShakeSensorListener";
    private static int THREAHOLD = 5;
    private float[] mPrev = new float[3];
    private final float[] mScale = { 2.0F, 2.5F, 0.5F };
    
    static
    {
      if (q.aPo().equals("LG-E510")) {
        THREAHOLD = 4;
      }
    }
    
    private float selfAdaptation(float paramFloat)
    {
      if (paramFloat >= 4.0F) {
        Log.v("MicroMsg.ShakeSensorListener", "result:" + paramFloat + " THREAHOLD:" + THREAHOLD);
      }
      if (THREAHOLD >= 9) {}
      int i;
      do
      {
        return paramFloat;
        if (paramFloat >= 14.0F)
        {
          THREAHOLD = 9;
          return paramFloat;
        }
        i = (int)paramFloat;
      } while (THREAHOLD >= i - 4);
      THREAHOLD = i - 4;
      return paramFloat;
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public abstract void onRelease();
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float[] arrayOfFloat1 = new float[3];
      float[] arrayOfFloat2 = paramSensorEvent.values;
      int i = 0;
      int j = 0;
      while (i < 3)
      {
        arrayOfFloat1[i] = Math.round(this.mScale[i] * (arrayOfFloat2[i] - this.mPrev[i]) * 0.45F);
        if (selfAdaptation(Math.abs(arrayOfFloat1[i])) > THREAHOLD) {
          j = 1;
        }
        this.mPrev[i] = arrayOfFloat2[i];
        i += 1;
      }
      if (j != 0)
      {
        Log.d("MicroMsg.ShakeSensorListener", "sensorChanged " + paramSensorEvent.sensor.getName() + " (" + arrayOfFloat2[0] + ", " + arrayOfFloat2[1] + ", " + arrayOfFloat2[2] + ") diff(" + arrayOfFloat1[0] + " " + arrayOfFloat1[1] + " " + arrayOfFloat1[2] + ")");
        onShake(true);
        onShake(paramSensorEvent.values);
      }
    }
    
    public abstract void onShake(boolean paramBoolean);
    
    public void onShake(float[] paramArrayOfFloat) {}
    
    public void reset()
    {
      Log.d("MicroMsg.ShakeSensorListener", "reset threadHold");
      THREAHOLD = 5;
      if (q.aPo().equals("LG-E510")) {
        THREAHOLD = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.d
 * JD-Core Version:    0.7.0.1
 */