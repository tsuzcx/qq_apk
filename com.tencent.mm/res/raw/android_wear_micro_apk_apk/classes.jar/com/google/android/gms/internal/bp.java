package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.aa;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.common.api.y;
import com.google.android.gms.common.api.z;
import com.google.android.gms.common.internal.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class bp<R extends w>
  extends aa<R>
  implements x<R>
{
  private final Object Oh;
  private final WeakReference<p> Oj;
  private z<? super R, ? extends w> Rd;
  private bp<? extends w> Re;
  private volatile y<? super R> Rf;
  private t<R> Rg;
  private Status Rh;
  private final bq Ri;
  private boolean Rj;
  
  private static void d(w paramw)
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
      Log.w("TransformedResultImpl", String.valueOf(paramw).length() + 18 + "Unable to release " + paramw, localRuntimeException);
    }
  }
  
  private void e(Status paramStatus)
  {
    synchronized (this.Oh)
    {
      this.Rh = paramStatus;
      f(this.Rh);
      return;
    }
  }
  
  private void f(Status paramStatus)
  {
    synchronized (this.Oh)
    {
      if (this.Rd != null)
      {
        d.g(paramStatus, "onFailure must not return null");
        this.Re.e(paramStatus);
      }
      while (!jp()) {
        return;
      }
      paramStatus = this.Rf;
    }
  }
  
  private boolean jp()
  {
    p localp = (p)this.Oj.get();
    return (this.Rf != null) && (localp != null);
  }
  
  public final void a(t<?> paramt)
  {
    synchronized (this.Oh)
    {
      this.Rg = paramt;
      if ((this.Rd != null) || (this.Rf != null))
      {
        paramt = (p)this.Oj.get();
        if ((!this.Rj) && (this.Rd != null) && (paramt != null))
        {
          paramt.a(this);
          this.Rj = true;
        }
        if (this.Rh == null) {
          break label83;
        }
        f(this.Rh);
      }
      label83:
      while (this.Rg == null) {
        return;
      }
      this.Rg.a(this);
    }
  }
  
  public final void a(final R paramR)
  {
    synchronized (this.Oh)
    {
      if (paramR.gM().gw())
      {
        if (this.Rd != null) {
          bj.iO().submit(new Runnable()
          {
            public final void run()
            {
              try
              {
                k.Og.set(Boolean.TRUE);
                Object localObject1 = bp.c(bp.this).gN();
                bp.d(bp.this).sendMessage(bp.d(bp.this).obtainMessage(0, localObject1));
                k.Og.set(Boolean.FALSE);
                bp.e(paramR);
                localObject1 = (p)bp.e(bp.this).get();
                if (localObject1 != null) {
                  ((p)localObject1).b(bp.this);
                }
                return;
              }
              catch (RuntimeException localRuntimeException)
              {
                bp.d(bp.this).sendMessage(bp.d(bp.this).obtainMessage(1, localRuntimeException));
                p localp1;
                return;
              }
              finally
              {
                k.Og.set(Boolean.FALSE);
                bp.e(paramR);
                p localp2 = (p)bp.e(bp.this).get();
                if (localp2 != null) {
                  localp2.b(bp.this);
                }
              }
            }
          });
        }
        for (;;)
        {
          return;
          if (jp()) {
            paramR = this.Rf;
          }
        }
      }
      e(paramR.gM());
      d(paramR);
    }
  }
  
  final void jo()
  {
    this.Rf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bp
 * JD-Core Version:    0.7.0.1
 */