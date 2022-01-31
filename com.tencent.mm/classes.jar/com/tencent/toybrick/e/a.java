package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a BxY;
  private a BxZ;
  private Handler Bya;
  private HandlerThread mThread;
  
  static
  {
    AppMethodBeat.i(113227);
    BxY = new a();
    AppMethodBeat.o(113227);
  }
  
  public static a dWP()
  {
    return BxY;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(113226);
    if (this.BxZ == null)
    {
      if ((this.mThread == null) || (!this.mThread.isAlive()))
      {
        this.mThread = new HandlerThread("WhenHandler");
        this.mThread.start();
        this.Bya = new Handler(this.mThread.getLooper());
      }
      this.Bya.post(paramRunnable);
    }
    AppMethodBeat.o(113226);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.toybrick.e.a
 * JD-Core Version:    0.7.0.1
 */