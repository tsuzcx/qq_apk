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
  private final Object Ms;
  private final WeakReference<p> Mu;
  private z<? super R, ? extends w> Po;
  private bp<? extends w> Pp;
  private volatile y<? super R> Pq;
  private t<R> Pr;
  private Status Ps;
  private final bq Pt;
  private boolean Pu;
  
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
    synchronized (this.Ms)
    {
      this.Ps = paramStatus;
      f(this.Ps);
      return;
    }
  }
  
  private void f(Status paramStatus)
  {
    synchronized (this.Ms)
    {
      if (this.Po != null)
      {
        d.e(paramStatus, "onFailure must not return null");
        this.Pp.e(paramStatus);
      }
      while (!jg()) {
        return;
      }
      paramStatus = this.Pq;
    }
  }
  
  private boolean jg()
  {
    p localp = (p)this.Mu.get();
    return (this.Pq != null) && (localp != null);
  }
  
  public final void a(t<?> paramt)
  {
    synchronized (this.Ms)
    {
      this.Pr = paramt;
      if ((this.Po != null) || (this.Pq != null))
      {
        paramt = (p)this.Mu.get();
        if ((!this.Pu) && (this.Po != null) && (paramt != null))
        {
          paramt.a(this);
          this.Pu = true;
        }
        if (this.Ps == null) {
          break label83;
        }
        f(this.Ps);
      }
      label83:
      while (this.Pr == null) {
        return;
      }
      this.Pr.a(this);
    }
  }
  
  public final void a(final R paramR)
  {
    synchronized (this.Ms)
    {
      if (paramR.gC().gm())
      {
        if (this.Po != null) {
          bj.iG().submit(new Runnable()
          {
            public final void run()
            {
              try
              {
                k.Mr.set(Boolean.valueOf(true));
                Object localObject1 = bp.c(bp.this).gD();
                bp.d(bp.this).sendMessage(bp.d(bp.this).obtainMessage(0, localObject1));
                k.Mr.set(Boolean.valueOf(false));
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
                k.Mr.set(Boolean.valueOf(false));
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
          if (jg()) {
            paramR = this.Pq;
          }
        }
      }
      e(paramR.gC());
      d(paramR);
    }
  }
  
  final void jf()
  {
    this.Pq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bp
 * JD-Core Version:    0.7.0.1
 */