package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ShakeManager
{
  private static final String TAG = "MicroMsg.ShakeManager";
  private ShakeSensorListener listener;
  private SensorManager manager;
  
  public ShakeManager(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.manager = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public boolean startShake(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.manager == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.manager.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.listener = new ShakeSensorListener(paramRunnable);
      this.manager.registerListener(this.listener, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public void stopShake()
  {
    AppMethodBeat.i(157834);
    if ((this.manager != null) && (this.listener != null)) {
      this.manager.unregisterListener(this.listener, 2);
    }
    AppMethodBeat.o(157834);
  }
  
  static class ShakeSensorListener
    implements SensorListener
  {
    private Runnable callback;
    private float[] mPrev;
    
    public ShakeSensorListener(Runnable paramRunnable)
    {
      AppMethodBeat.i(157830);
      this.mPrev = new float[] { 0.0F, 0.0F, 0.0F };
      this.callback = paramRunnable;
      AppMethodBeat.o(157830);
    }
    
    public void onAccuracyChanged(int paramInt1, int paramInt2) {}
    
    public void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(157831);
      float[] arrayOfFloat = new float[3];
      paramInt = 0;
      int j;
      for (int i = 0; paramInt < 3; i = j)
      {
        arrayOfFloat[paramInt] = Math.abs(paramArrayOfFloat[paramInt] - this.mPrev[paramInt]);
        j = i;
        if (this.mPrev[paramInt] != 0.0F)
        {
          j = i;
          if (arrayOfFloat[paramInt] > 1.0F)
          {
            j = 1;
            Log.d("MicroMsg.ShakeManager", "isONShake:" + arrayOfFloat[paramInt]);
          }
        }
        this.mPrev[paramInt] = paramArrayOfFloat[paramInt];
        paramInt += 1;
      }
      if (i != 0) {
        this.callback.run();
      }
      AppMethodBeat.o(157831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ShakeManager
 * JD-Core Version:    0.7.0.1
 */