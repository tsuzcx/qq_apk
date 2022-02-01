package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
  extends c
{
  private final Object f = new Object();
  private ExecutorService g = Executors.newFixedThreadPool(2);
  private volatile Handler h;
  
  public final void a(Runnable paramRunnable)
  {
    this.g.execute(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (this.h == null) {}
    synchronized (this.f)
    {
      if (this.h == null) {
        this.h = new Handler(Looper.getMainLooper());
      }
      this.h.post(paramRunnable);
      return;
    }
  }
  
  public final boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.a.b
 * JD-Core Version:    0.7.0.1
 */