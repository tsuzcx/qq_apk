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
        t.b(this.Nl, new android.support.v4.b.a(t.n(this.Nl).size()));
        paramb = t.n(this.Nl).values().iterator();
        while (paramb.hasNext())
        {
          localObject = (s)paramb.next();
          t.g(this.Nl).put(((s)localObject).gJ(), ConnectionResult.Hb);
        }
      }
      if (!(paramb.getException() instanceof ac)) {
        break label405;
      }
    }
    finally
    {
      t.a(this.Nl).unlock();
    }
    paramb = (ac)paramb.getException();
    if (t.e(this.Nl))
    {
      t.b(this.Nl, new android.support.v4.b.a(t.n(this.Nl).size()));
      localObject = t.n(this.Nl).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        s locals = (s)((Iterator)localObject).next();
        ef localef = locals.gJ();
        ConnectionResult localConnectionResult = paramb.a(locals);
        if (t.a(this.Nl, locals, localConnectionResult)) {
          t.g(this.Nl).put(localef, new ConnectionResult(16));
        } else {
          t.g(this.Nl).put(localef, localConnectionResult);
        }
      }
    }
    t.b(this.Nl, paramb.gH());
    for (;;)
    {
      if (this.Nl.isConnected())
      {
        t.d(this.Nl).putAll(t.g(this.Nl));
        if (t.f(this.Nl) == null)
        {
          t.i(this.Nl);
          t.j(this.Nl);
          t.m(this.Nl).signalAll();
        }
      }
      t.a(this.Nl).unlock();
      return;
      label405:
      Log.e("ConnectionlessGAC", "Unexpected availability exception", paramb.getException());
      t.b(this.Nl, Collections.emptyMap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.7.0.1
 */