package com.google.android.gms.internal;

import android.support.v4.b.a;
import com.google.android.gms.b.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ac;
import com.google.android.gms.common.api.ad;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  private final a<ef<?>, ConnectionResult> JI = new a();
  private final com.google.android.gms.b.c<Void> NR = new com.google.android.gms.b.c();
  private int NS;
  private boolean NT = false;
  
  public c(Iterable<? extends ad<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      ad localad = (ad)paramIterable.next();
      this.JI.put(localad.gT(), null);
    }
    this.NS = this.JI.keySet().size();
  }
  
  public final void a(ef<?> paramef, ConnectionResult paramConnectionResult)
  {
    this.JI.put(paramef, paramConnectionResult);
    this.NS -= 1;
    if (!paramConnectionResult.gw()) {
      this.NT = true;
    }
    if (this.NS == 0)
    {
      if (this.NT)
      {
        paramef = new ac(this.JI);
        this.NR.a(paramef);
      }
    }
    else {
      return;
    }
    this.NR.kw();
  }
  
  public final Set<ef<?>> ih()
  {
    return this.JI.keySet();
  }
  
  public final b<Void> ii()
  {
    return this.NR.ii();
  }
  
  public final void ij()
  {
    this.NR.kw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.c
 * JD-Core Version:    0.7.0.1
 */