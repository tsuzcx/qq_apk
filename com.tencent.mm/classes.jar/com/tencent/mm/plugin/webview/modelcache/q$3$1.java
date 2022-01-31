package com.tencent.mm.plugin.webview.modelcache;

import android.os.Looper;
import android.os.Process;

final class q$3$1
  implements Runnable
{
  q$3$1(q.3 param3, Runnable paramRunnable) {}
  
  public final void run()
  {
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
        Process.setThreadPriority(10);
      }
      if (this.dGX != null) {
        this.dGX.run();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.q.3.1
 * JD-Core Version:    0.7.0.1
 */