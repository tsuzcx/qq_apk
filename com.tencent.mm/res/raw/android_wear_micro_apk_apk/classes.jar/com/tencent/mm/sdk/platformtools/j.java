package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  implements l
{
  private com.tencent.mm.sdk.a Zu;
  private ConcurrentHashMap<Runnable, WeakReference<n>> Zv = new ConcurrentHashMap();
  private int Zw;
  private LinkedList<WeakReference<n>> Zx = new LinkedList();
  private String Zy = null;
  
  public j()
  {
    if (Looper.myLooper() == null)
    {
      f.b("MicroMsg.MMHandler", "[MMHandler] myLooper() == null loopTag:%s", new Object[] { com.tencent.mm.sdk.b.a.getTag() });
      this.Zu = new com.tencent.mm.sdk.a(q.l(com.tencent.mm.sdk.b.a.getTag(), "MicroMsg.MMHandler"), this);
    }
    do
    {
      return;
      this.Zu = new com.tencent.mm.sdk.a(this);
    } while (!this.Zu.lm().getThread().getName().equals("initThread"));
    f.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { q.lC() });
  }
  
  public j(Looper paramLooper)
  {
    this.Zu = new com.tencent.mm.sdk.a(paramLooper, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      f.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { q.lC() });
    }
  }
  
  public final void a(Runnable paramRunnable, n paramn)
  {
    this.Zv.put(paramRunnable, new WeakReference(paramn));
  }
  
  public final void b(Runnable paramRunnable, n paramn)
  {
    WeakReference localWeakReference = (WeakReference)this.Zv.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramn))
    {
      this.Zv.remove(paramRunnable);
      if (this.Zw > 0)
      {
        if (this.Zx.size() == this.Zw) {
          this.Zx.pop();
        }
        this.Zx.add(localWeakReference);
      }
    }
  }
  
  public final boolean e(Runnable paramRunnable)
  {
    return this.Zu.postDelayed(paramRunnable, 10000L);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return this.Zu.post(paramRunnable);
  }
  
  public final String toString()
  {
    if (this.Zy == null) {
      this.Zy = ("MMHandler(" + getClass().getName() + ")");
    }
    return this.Zy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */