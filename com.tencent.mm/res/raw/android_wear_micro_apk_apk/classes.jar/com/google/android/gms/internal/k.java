package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.internal.an;
import com.google.android.gms.common.internal.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class k<R extends w>
  extends t<R>
{
  static final ThreadLocal<Boolean> Mr = new ThreadLocal() {};
  private Status HS;
  private final CountDownLatch IL = new CountDownLatch(1);
  private volatile boolean MA;
  private boolean MB;
  private boolean MC;
  private an MD;
  private volatile bp<R> ME;
  private boolean MF = false;
  private final Object Ms = new Object();
  protected final l<R> Mt;
  protected final WeakReference<p> Mu;
  private final ArrayList<u> Mv = new ArrayList();
  private x<? super R> Mw;
  private final AtomicReference<bs> Mx = new AtomicReference();
  private R My;
  private m Mz;
  
  @Deprecated
  k()
  {
    this.Mt = new l(Looper.getMainLooper());
    this.Mu = new WeakReference(null);
  }
  
  protected k(p paramp)
  {
    if (paramp != null) {}
    for (Looper localLooper = paramp.getLooper();; localLooper = Looper.getMainLooper())
    {
      this.Mt = new l(localLooper);
      this.Mu = new WeakReference(paramp);
      return;
    }
  }
  
  private boolean am()
  {
    return this.IL.getCount() == 0L;
  }
  
  private void c(R paramR)
  {
    this.My = paramR;
    this.MD = null;
    this.IL.countDown();
    this.HS = this.My.gC();
    if (this.MB) {
      this.Mw = null;
    }
    for (;;)
    {
      paramR = this.Mv.iterator();
      while (paramR.hasNext()) {
        ((u)paramR.next()).gB();
      }
      if (this.Mw == null)
      {
        if ((this.My instanceof v)) {
          this.Mz = new m(this, (byte)0);
        }
      }
      else
      {
        this.Mt.removeMessages(2);
        this.Mt.a(this.Mw, ii());
      }
    }
    this.Mv.clear();
  }
  
  public static void d(w paramw)
  {
    if ((paramw instanceof v)) {}
    try
    {
      ((v)paramw).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramw = String.valueOf(paramw);
      Log.w("BasePendingResult", String.valueOf(paramw).length() + 18 + "Unable to release " + paramw, localRuntimeException);
    }
  }
  
  private R ii()
  {
    boolean bool = true;
    synchronized (this.Ms)
    {
      if (!this.MA)
      {
        d.a(bool, "Result has already been consumed.");
        d.a(am(), "Result is not ready.");
        w localw = this.My;
        this.My = null;
        this.Mw = null;
        this.MA = true;
        ??? = (bs)this.Mx.getAndSet(null);
        if (??? != null) {
          ((bs)???).c(this);
        }
        return localw;
      }
      bool = false;
    }
  }
  
  private boolean isCanceled()
  {
    synchronized (this.Ms)
    {
      boolean bool = this.MB;
      return bool;
    }
  }
  
  public final R a(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      d.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.MA)
      {
        bool1 = true;
        label38:
        d.a(bool1, "Result has already been consumed.");
        if (this.ME != null) {
          break label108;
        }
        bool1 = bool2;
        d.a(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.IL.await(paramLong, paramTimeUnit)) {
          b(Status.HO);
        }
        d.a(am(), "Result is not ready.");
        return ii();
        bool1 = false;
        continue;
        bool1 = false;
        break label38;
        label108:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          b(Status.HM);
        }
      }
    }
  }
  
  public final void a(u paramu)
  {
    d.b(true, "Callback cannot be null.");
    synchronized (this.Ms)
    {
      if (am())
      {
        paramu.gB();
        return;
      }
      this.Mv.add(paramu);
    }
  }
  
  public final void a(x<? super R> paramx)
  {
    boolean bool2 = true;
    Object localObject = this.Ms;
    if (paramx == null) {}
    try
    {
      this.Mw = null;
      return;
    }
    finally {}
    if (!this.MA)
    {
      bool1 = true;
      d.a(bool1, "Result has already been consumed.");
      if (this.ME != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d.a(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (am()) {
      this.Mt.a(paramx, ii());
    }
    for (;;)
    {
      return;
      this.Mw = paramx;
    }
  }
  
  public final void a(bs parambs)
  {
    this.Mx.set(parambs);
  }
  
  public final void b(Status paramStatus)
  {
    synchronized (this.Ms)
    {
      if (!am())
      {
        b(c(paramStatus));
        this.MC = true;
      }
      return;
    }
  }
  
  public final void b(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Ms)
      {
        if ((!this.MC) && (!this.MB))
        {
          if ((!am()) || (!am()))
          {
            bool1 = true;
            d.a(bool1, "Results have already been set");
            if (this.MA) {
              break label92;
            }
            bool1 = bool2;
            d.a(bool1, "Result has already been consumed");
            c(paramR);
          }
        }
        else
        {
          d(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label92:
      bool1 = false;
    }
  }
  
  protected abstract R c(Status paramStatus);
  
  public final void cancel()
  {
    synchronized (this.Ms)
    {
      if ((this.MB) || (this.MA)) {
        return;
      }
      d(this.My);
      this.MB = true;
      c(c(Status.HP));
      return;
    }
  }
  
  public final boolean ig()
  {
    synchronized (this.Ms)
    {
      if (((p)this.Mu.get() == null) || (!this.MF)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public final void ih()
  {
    if ((this.MF) || (((Boolean)Mr.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.MF = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.k
 * JD-Core Version:    0.7.0.1
 */