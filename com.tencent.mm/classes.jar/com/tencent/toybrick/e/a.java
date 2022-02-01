package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a Ktm;
  private a Ktn;
  private Handler Kto;
  private HandlerThread mThread;
  
  static
  {
    AppMethodBeat.i(159964);
    Ktm = new a();
    AppMethodBeat.o(159964);
  }
  
  public static a fHr()
  {
    return Ktm;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(159963);
    if (this.Ktn == null)
    {
      if ((this.mThread == null) || (!this.mThread.isAlive()))
      {
        this.mThread = new HandlerThread("WhenHandler");
        this.mThread.start();
        this.Kto = new Handler(this.mThread.getLooper());
      }
      this.Kto.post(paramRunnable);
    }
    AppMethodBeat.o(159963);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.e.a
 * JD-Core Version:    0.7.0.1
 */