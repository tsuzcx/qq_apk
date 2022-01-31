package com.tencent.mm.sdk.platformtools;

import android.hardware.SensorListener;

final class bb$a
  implements SensorListener
{
  private Runnable bFJ;
  private float[] rYr = { 0.0F, 0.0F, 0.0F };
  
  public bb$a(Runnable paramRunnable)
  {
    this.bFJ = paramRunnable;
  }
  
  public final void onAccuracyChanged(int paramInt1, int paramInt2) {}
  
  public final void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    paramInt = 0;
    int j;
    for (int i = 0; paramInt < 3; i = j)
    {
      arrayOfFloat[paramInt] = Math.abs(paramArrayOfFloat[paramInt] - this.rYr[paramInt]);
      j = i;
      if (this.rYr[paramInt] != 0.0F)
      {
        j = i;
        if (arrayOfFloat[paramInt] > 1.0F)
        {
          j = 1;
          y.d("MicroMsg.ShakeManager", "isONShake:" + arrayOfFloat[paramInt]);
        }
      }
      this.rYr[paramInt] = paramArrayOfFloat[paramInt];
      paramInt += 1;
    }
    if (i != 0) {
      this.bFJ.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb.a
 * JD-Core Version:    0.7.0.1
 */