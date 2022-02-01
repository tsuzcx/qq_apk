package com.google.android.gms.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class as
  implements r, bm
{
  private Set<Scope> IG = null;
  private final ef<?> JL;
  private final j OL;
  private ak Pt = null;
  private boolean QB = false;
  
  public as(j paramj, ef<?> paramef)
  {
    this.OL = paramef;
    Object localObject;
    this.JL = localObject;
  }
  
  private void jg()
  {
    if ((this.QB) && (this.Pt != null)) {
      this.OL.a(this.Pt, this.IG);
    }
  }
  
  public final void b(ak paramak, Set<Scope> paramSet)
  {
    if ((paramak == null) || (paramSet == null))
    {
      Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
      l(new ConnectionResult(4));
      return;
    }
    this.Pt = paramak;
    this.IG = paramSet;
    jg();
  }
  
  public final void c(final ConnectionResult paramConnectionResult)
  {
    aq.a(this.Qq).post(new Runnable()
    {
      public final void run()
      {
        if (paramConnectionResult.gw())
        {
          as.a(as.this);
          if (as.b(as.this).gC())
          {
            as.c(as.this);
            return;
          }
          as.b(as.this).a(null, Collections.emptySet());
          return;
        }
        ((ar)aq.j(as.this.Qq).get(as.d(as.this))).a(paramConnectionResult);
      }
    });
  }
  
  public final void l(ConnectionResult paramConnectionResult)
  {
    ((ar)aq.j(this.Qq).get(this.JL)).l(paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.as
 * JD-Core Version:    0.7.0.1
 */