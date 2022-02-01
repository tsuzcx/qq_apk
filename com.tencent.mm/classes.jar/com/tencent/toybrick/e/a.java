package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a MGk;
  private a MGl;
  private Handler MGm;
  private HandlerThread mThread;
  
  static
  {
    AppMethodBeat.i(159964);
    MGk = new a();
    AppMethodBeat.o(159964);
  }
  
  public static a gdh()
  {
    return MGk;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(159963);
    if (this.MGl == null)
    {
      if ((this.mThread == null) || (!this.mThread.isAlive()))
      {
        this.mThread = new HandlerThread("WhenHandler");
        this.mThread.start();
        this.MGm = new Handler(this.mThread.getLooper());
      }
      this.MGm.post(paramRunnable);
    }
    AppMethodBeat.o(159963);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.e.a
 * JD-Core Version:    0.7.0.1
 */