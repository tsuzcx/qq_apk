package com.tencent.mm.sdk.platformtools;

import android.hardware.SensorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bk$a
  implements SensorListener
{
  private Runnable callback;
  private float[] mPrev;
  
  public bk$a(Runnable paramRunnable)
  {
    AppMethodBeat.i(157830);
    this.mPrev = new float[] { 0.0F, 0.0F, 0.0F };
    this.callback = paramRunnable;
    AppMethodBeat.o(157830);
  }
  
  public final void onAccuracyChanged(int paramInt1, int paramInt2) {}
  
  public final void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
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
          ad.d("MicroMsg.ShakeManager", "isONShake:" + arrayOfFloat[paramInt]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bk.a
 * JD-Core Version:    0.7.0.1
 */