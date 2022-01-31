package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  implements l
{
  private k Xs;
  private ConcurrentHashMap<Runnable, WeakReference<n>> Xt = new ConcurrentHashMap();
  private int Xu;
  private LinkedList<WeakReference<n>> Xv = new LinkedList();
  private String Xw = null;
  
  public j()
  {
    this.Xs = new k(this);
    if (this.Xs.getLooper().getThread().getName().equals("initThread")) {
      f.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { q.lq() });
    }
  }
  
  public j(Looper paramLooper)
  {
    this.Xs = new k(paramLooper, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      f.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { q.lq() });
    }
  }
  
  public final void a(Runnable paramRunnable, n paramn)
  {
    this.Xt.put(paramRunnable, new WeakReference(paramn));
  }
  
  public final void b(Runnable paramRunnable, n paramn)
  {
    WeakReference localWeakReference = (WeakReference)this.Xt.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramn))
    {
      this.Xt.remove(paramRunnable);
      if (this.Xu > 0)
      {
        if (this.Xv.size() == this.Xu) {
          this.Xv.pop();
        }
        this.Xv.add(localWeakReference);
      }
    }
  }
  
  public final boolean c(Runnable paramRunnable)
  {
    return this.Xs.postDelayed(paramRunnable, 10000L);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return this.Xs.post(paramRunnable);
  }
  
  public final String toString()
  {
    if (this.Xw == null) {
      this.Xw = ("MMHandler(" + getClass().getName() + ")");
    }
    return this.Xw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */