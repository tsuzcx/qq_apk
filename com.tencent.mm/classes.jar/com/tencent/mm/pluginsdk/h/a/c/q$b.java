package com.tencent.mm.pluginsdk.h.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$b
  implements Runnable
{
  private final Runnable cvK;
  
  private q$b(Runnable paramRunnable)
  {
    this.cvK = paramRunnable;
  }
  
  public final void run()
  {
    AppMethodBeat.i(152058);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
        Process.setThreadPriority(10);
      }
      if (this.cvK != null) {
        this.cvK.run();
      }
      AppMethodBeat.o(152058);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.q.b
 * JD-Core Version:    0.7.0.1
 */