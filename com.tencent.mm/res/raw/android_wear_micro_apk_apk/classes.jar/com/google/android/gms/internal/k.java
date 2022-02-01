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
  static final ThreadLocal<Boolean> Og = new ThreadLocal() {};
  private Status JH;
  private final CountDownLatch KA = new CountDownLatch(1);
  private final Object Oh = new Object();
  protected final l<R> Oi;
  protected final WeakReference<p> Oj;
  private final ArrayList<u> Ok = new ArrayList();
  private x<? super R> Ol;
  private final AtomicReference<bs> Om = new AtomicReference();
  private R On;
  private m Oo;
  private volatile boolean Op;
  private boolean Oq;
  private boolean Or;
  private an Os;
  private volatile bp<R> Ot;
  private boolean Ou = false;
  
  @Deprecated
  k()
  {
    this.Oi = new l(Looper.getMainLooper());
    this.Oj = new WeakReference(null);
  }
  
  protected k(p paramp)
  {
    if (paramp != null) {}
    for (Looper localLooper = paramp.getLooper();; localLooper = Looper.getMainLooper())
    {
      this.Oi = new l(localLooper);
      this.Oj = new WeakReference(paramp);
      return;
    }
  }
  
  private boolean aB()
  {
    return this.KA.getCount() == 0L;
  }
  
  private void c(R paramR)
  {
    this.On = paramR;
    this.Os = null;
    this.KA.countDown();
    this.JH = this.On.gM();
    if (this.Oq) {
      this.Ol = null;
    }
    for (;;)
    {
      paramR = this.Ok.iterator();
      while (paramR.hasNext()) {
        ((u)paramR.next()).gL();
      }
      if (this.Ol == null)
      {
        if ((this.On instanceof v)) {
          this.Oo = new m(this, (byte)0);
        }
      }
      else
      {
        this.Oi.removeMessages(2);
        this.Oi.a(this.Ol, iq());
      }
    }
    this.Ok.clear();
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
  
  private R iq()
  {
    boolean bool = true;
    synchronized (this.Oh)
    {
      if (!this.Op)
      {
        d.a(bool, "Result has already been consumed.");
        d.a(aB(), "Result is not ready.");
        w localw = this.On;
        this.On = null;
        this.Ol = null;
        this.Op = true;
        ??? = (bs)this.Om.getAndSet(null);
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
    synchronized (this.Oh)
    {
      boolean bool = this.Oq;
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
      if (!this.Op)
      {
        bool1 = true;
        label38:
        d.a(bool1, "Result has already been consumed.");
        if (this.Ot != null) {
          break label108;
        }
        bool1 = bool2;
        d.a(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.KA.await(paramLong, paramTimeUnit)) {
          b(Status.JD);
        }
        d.a(aB(), "Result is not ready.");
        return iq();
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
          b(Status.JB);
        }
      }
    }
  }
  
  public final void a(u paramu)
  {
    d.b(true, "Callback cannot be null.");
    synchronized (this.Oh)
    {
      if (aB())
      {
        paramu.gL();
        return;
      }
      this.Ok.add(paramu);
    }
  }
  
  public final void a(x<? super R> paramx)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Oh)
      {
        if (this.Op) {
          break label90;
        }
        bool1 = true;
        d.a(bool1, "Result has already been consumed.");
        if (this.Ot != null) {
          break label95;
        }
        bool1 = bool2;
        d.a(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if (aB())
        {
          this.Oi.a(paramx, iq());
          return;
        }
      }
      this.Ol = paramx;
      continue;
      label90:
      boolean bool1 = false;
      continue;
      label95:
      bool1 = false;
    }
  }
  
  public final void a(bs parambs)
  {
    this.Om.set(parambs);
  }
  
  public final void b(Status paramStatus)
  {
    synchronized (this.Oh)
    {
      if (!aB())
      {
        b(c(paramStatus));
        this.Or = true;
      }
      return;
    }
  }
  
  public final void b(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Oh)
      {
        if ((!this.Or) && (!this.Oq))
        {
          if ((!aB()) || (!aB()))
          {
            bool1 = true;
            d.a(bool1, "Results have already been set");
            if (this.Op) {
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
    synchronized (this.Oh)
    {
      if ((this.Oq) || (this.Op)) {
        return;
      }
      d(this.On);
      this.Oq = true;
      c(c(Status.JE));
      return;
    }
  }
  
  public final boolean io()
  {
    synchronized (this.Oh)
    {
      if (((p)this.Oj.get() == null) || (!this.Ou)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public final void ip()
  {
    if ((this.Ou) || (((Boolean)Og.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ou = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.k
 * JD-Core Version:    0.7.0.1
 */