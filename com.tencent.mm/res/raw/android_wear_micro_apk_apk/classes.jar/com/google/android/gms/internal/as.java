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
  private Set<Scope> GR = null;
  private final ef<?> HW;
  private final j MW;
  private ak NE = null;
  private boolean OM = false;
  
  public as(j paramj, ef<?> paramef)
  {
    this.MW = paramef;
    Object localObject;
    this.HW = localObject;
  }
  
  private void iX()
  {
    if ((this.OM) && (this.NE != null)) {
      this.MW.a(this.NE, this.GR);
    }
  }
  
  public final void b(ak paramak, Set<Scope> paramSet)
  {
    if ((paramak == null) || (paramSet == null))
    {
      Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
      k(new ConnectionResult(4));
      return;
    }
    this.NE = paramak;
    this.GR = paramSet;
    iX();
  }
  
  public final void c(final ConnectionResult paramConnectionResult)
  {
    aq.a(this.OB).post(new Runnable()
    {
      public final void run()
      {
        if (paramConnectionResult.gm())
        {
          as.a(as.this);
          if (as.b(as.this).gs())
          {
            as.c(as.this);
            return;
          }
          as.b(as.this).a(null, Collections.emptySet());
          return;
        }
        ((ar)aq.j(as.this.OB).get(as.d(as.this))).a(paramConnectionResult);
      }
    });
  }
  
  public final void k(ConnectionResult paramConnectionResult)
  {
    ((ar)aq.j(this.OB).get(this.HW)).k(paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.as
 * JD-Core Version:    0.7.0.1
 */