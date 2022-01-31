package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Looper;
import android.os.Process;

final class q$b
  implements Runnable
{
  private final Runnable eKD;
  
  private q$b(Runnable paramRunnable)
  {
    this.eKD = paramRunnable;
  }
  
  public final void run()
  {
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
        Process.setThreadPriority(10);
      }
      if (this.eKD != null) {
        this.eKD.run();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.q.b
 * JD-Core Version:    0.7.0.1
 */