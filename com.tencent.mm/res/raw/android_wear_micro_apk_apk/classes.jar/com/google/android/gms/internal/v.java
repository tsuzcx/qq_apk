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

final class v
  implements com.google.android.gms.b.a<Void>
{
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
        t.b(this.Pa, new android.support.v4.b.a(t.n(this.Pa).size()));
        paramb = t.n(this.Pa).values().iterator();
        while (paramb.hasNext())
        {
          localObject = (s)paramb.next();
          t.g(this.Pa).put(((s)localObject).gT(), ConnectionResult.IQ);
        }
      }
      if (!(paramb.getException() instanceof ac)) {
        break label405;
      }
    }
    finally
    {
      t.a(this.Pa).unlock();
    }
    paramb = (ac)paramb.getException();
    if (t.e(this.Pa))
    {
      t.b(this.Pa, new android.support.v4.b.a(t.n(this.Pa).size()));
      localObject = t.n(this.Pa).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        s locals = (s)((Iterator)localObject).next();
        ef localef = locals.gT();
        ConnectionResult localConnectionResult = paramb.a(locals);
        if (t.a(this.Pa, locals, localConnectionResult)) {
          t.g(this.Pa).put(localef, new ConnectionResult(16));
        } else {
          t.g(this.Pa).put(localef, localConnectionResult);
        }
      }
    }
    t.b(this.Pa, paramb.gR());
    for (;;)
    {
      if (this.Pa.isConnected())
      {
        t.d(this.Pa).putAll(t.g(this.Pa));
        if (t.f(this.Pa) == null)
        {
          t.i(this.Pa);
          t.j(this.Pa);
          t.m(this.Pa).signalAll();
        }
      }
      t.a(this.Pa).unlock();
      return;
      label405:
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramb.getException());
      t.b(this.Pa, Collections.emptyMap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.7.0.1
 */