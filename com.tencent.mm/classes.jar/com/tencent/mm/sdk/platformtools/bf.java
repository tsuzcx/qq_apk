package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bf
{
  private SensorManager vPg;
  private a yqu;
  
  public bf(Context paramContext)
  {
    AppMethodBeat.i(52272);
    this.vPg = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(52272);
  }
  
  public final boolean ai(Runnable paramRunnable)
  {
    AppMethodBeat.i(52273);
    if (this.vPg == null)
    {
      AppMethodBeat.o(52273);
      return false;
    }
    List localList = this.vPg.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.yqu = new a(paramRunnable);
      this.vPg.registerListener(this.yqu, 2, 3);
      AppMethodBeat.o(52273);
      return true;
    }
    AppMethodBeat.o(52273);
    return false;
  }
  
  public final void dtK()
  {
    AppMethodBeat.i(52274);
    if ((this.vPg != null) && (this.yqu != null)) {
      this.vPg.unregisterListener(this.yqu, 2);
    }
    AppMethodBeat.o(52274);
  }
  
  static final class a
    implements SensorListener
  {
    private Runnable callback;
    private float[] mPrev;
    
    public a(Runnable paramRunnable)
    {
      AppMethodBeat.i(52270);
      this.mPrev = new float[] { 0.0F, 0.0F, 0.0F };
      this.callback = paramRunnable;
      AppMethodBeat.o(52270);
    }
    
    public final void onAccuracyChanged(int paramInt1, int paramInt2) {}
    
    public final void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(52271);
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
            ab.d("MicroMsg.ShakeManager", "isONShake:" + arrayOfFloat[paramInt]);
          }
        }
        this.mPrev[paramInt] = paramArrayOfFloat[paramInt];
        paramInt += 1;
      }
      if (i != 0) {
        this.callback.run();
      }
      AppMethodBeat.o(52271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bf
 * JD-Core Version:    0.7.0.1
 */