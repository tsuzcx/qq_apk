package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.b.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ac;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class u
  implements com.google.android.gms.b.a<Void>
{
  private u(t paramt) {}
  
  public final void a(b<Void> paramb)
  {
    t.a(this.Nl).lock();
    Object localObject;
    try
    {
      boolean bool = t.b(this.Nl);
      if (!bool) {
        return;
      }
      if (paramb.km())
      {
        t.a(this.Nl, new android.support.v4.b.a(t.c(this.Nl).size()));
        paramb = t.c(this.Nl).values().iterator();
        while (paramb.hasNext())
        {
          localObject = (s)paramb.next();
          t.d(this.Nl).put(((s)localObject).gJ(), ConnectionResult.Hb);
        }
      }
      if (!(paramb.getException() instanceof ac)) {
        break label435;
      }
    }
    finally
    {
      t.a(this.Nl).unlock();
    }
    paramb = (ac)paramb.getException();
    if (t.e(this.Nl))
    {
      t.a(this.Nl, new android.support.v4.b.a(t.c(this.Nl).size()));
      localObject = t.c(this.Nl).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        s locals = (s)((Iterator)localObject).next();
        ef localef = locals.gJ();
        ConnectionResult localConnectionResult = paramb.a(locals);
        if (t.a(this.Nl, locals, localConnectionResult)) {
          t.d(this.Nl).put(localef, new ConnectionResult(16));
        } else {
          t.d(this.Nl).put(localef, localConnectionResult);
        }
      }
    }
    t.a(this.Nl, paramb.gH());
    t.a(this.Nl, t.f(this.Nl));
    if (t.g(this.Nl) != null)
    {
      t.d(this.Nl).putAll(t.g(this.Nl));
      t.a(this.Nl, t.f(this.Nl));
    }
    if (t.h(this.Nl) == null)
    {
      t.i(this.Nl);
      t.j(this.Nl);
    }
    for (;;)
    {
      t.m(this.Nl).signalAll();
      t.a(this.Nl).unlock();
      return;
      label435:
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramb.getException());
      t.a(this.Nl, Collections.emptyMap());
      t.a(this.Nl, new ConnectionResult(8));
      break;
      t.k(this.Nl);
      t.l(this.Nl).g(t.h(this.Nl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.u
 * JD-Core Version:    0.7.0.1
 */