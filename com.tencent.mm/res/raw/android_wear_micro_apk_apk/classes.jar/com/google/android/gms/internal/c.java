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
  private final a<ef<?>, ConnectionResult> HT = new a();
  private final com.google.android.gms.b.c<Void> Mc = new com.google.android.gms.b.c();
  private int Md;
  private boolean Me = false;
  
  public c(Iterable<? extends ad<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      ad localad = (ad)paramIterable.next();
      this.HT.put(localad.gJ(), null);
    }
    this.Md = this.HT.keySet().size();
  }
  
  public final void a(ef<?> paramef, ConnectionResult paramConnectionResult)
  {
    this.HT.put(paramef, paramConnectionResult);
    this.Md -= 1;
    if (!paramConnectionResult.gm()) {
      this.Me = true;
    }
    if (this.Md == 0)
    {
      if (this.Me)
      {
        paramef = new ac(this.HT);
        this.Mc.a(paramef);
      }
    }
    else {
      return;
    }
    this.Mc.kn();
  }
  
  public final Set<ef<?>> hZ()
  {
    return this.HT.keySet();
  }
  
  public final b<Void> ia()
  {
    return this.Mc.ia();
  }
  
  public final void ib()
  {
    this.Mc.kn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.c
 * JD-Core Version:    0.7.0.1
 */