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
    t.a(this.Pa).lock();
    Object localObject;
    try
    {
      boolean bool = t.b(this.Pa);
      if (!bool) {
        return;
      }
      if (paramb.kv())
      {
        t.a(this.Pa, new android.support.v4.b.a(t.c(this.Pa).size()));
        paramb = t.c(this.Pa).values().iterator();
        while (paramb.hasNext())
        {
          localObject = (s)paramb.next();
          t.d(this.Pa).put(((s)localObject).gT(), ConnectionResult.IQ);
        }
      }
      if (!(paramb.getException() instanceof ac)) {
        break label435;
      }
    }
    finally
    {
      t.a(this.Pa).unlock();
    }
    paramb = (ac)paramb.getException();
    if (t.e(this.Pa))
    {
      t.a(this.Pa, new android.support.v4.b.a(t.c(this.Pa).size()));
      localObject = t.c(this.Pa).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        s locals = (s)((Iterator)localObject).next();
        ef localef = locals.gT();
        ConnectionResult localConnectionResult = paramb.a(locals);
        if (t.a(this.Pa, locals, localConnectionResult)) {
          t.d(this.Pa).put(localef, new ConnectionResult(16));
        } else {
          t.d(this.Pa).put(localef, localConnectionResult);
        }
      }
    }
    t.a(this.Pa, paramb.gR());
    t.a(this.Pa, t.f(this.Pa));
    if (t.g(this.Pa) != null)
    {
      t.d(this.Pa).putAll(t.g(this.Pa));
      t.a(this.Pa, t.f(this.Pa));
    }
    if (t.h(this.Pa) == null)
    {
      t.i(this.Pa);
      t.j(this.Pa);
    }
    for (;;)
    {
      t.m(this.Pa).signalAll();
      t.a(this.Pa).unlock();
      return;
      label435:
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramb.getException());
      t.a(this.Pa, Collections.emptyMap());
      t.a(this.Pa, new ConnectionResult(8));
      break;
      t.k(this.Pa);
      t.l(this.Pa).g(t.h(this.Pa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.u
 * JD-Core Version:    0.7.0.1
 */