package com.tencent.threadpool.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.j.a;

public final class i
  implements g
{
  private Handler handler;
  
  public i()
  {
    AppMethodBeat.i(183314);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(183314);
  }
  
  public final void ayG()
  {
    AppMethodBeat.i(183317);
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(183317);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183315);
    if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId())
    {
      paramRunnable.run();
      AppMethodBeat.o(183315);
      return;
    }
    this.handler.post(paramRunnable);
    AppMethodBeat.o(183315);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183316);
    String str = a.jZz().tag;
    AppMethodBeat.o(183316);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.e.i
 * JD-Core Version:    0.7.0.1
 */