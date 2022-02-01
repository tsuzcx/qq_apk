package android.arch.lifecycle;

import android.arch.a.b.a;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public final class j
  extends e
{
  private a<h, k> N = new a();
  private g O;
  private final WeakReference<i> P;
  private int Q = 0;
  private boolean R = false;
  private boolean S = false;
  private ArrayList<g> T = new ArrayList();
  
  public j(i parami)
  {
    this.P = new WeakReference(parami);
    this.O = g.I;
  }
  
  static g a(g paramg1, g paramg2)
  {
    if ((paramg2 != null) && (paramg2.compareTo(paramg1) < 0)) {
      return paramg2;
    }
    return paramg1;
  }
  
  private void a(i parami)
  {
    android.arch.a.b.f localf = this.N.c();
    while ((localf.hasNext()) && (!this.S))
    {
      Map.Entry localEntry = (Map.Entry)localf.next();
      k localk = (k)localEntry.getValue();
      while ((localk.O.compareTo(this.O) < 0) && (!this.S) && (this.N.contains(localEntry.getKey())))
      {
        d(localk.O);
        localk.b(parami, e(localk.O));
        j();
      }
    }
  }
  
  static g b(f paramf)
  {
    switch (1.G[paramf.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(paramf)));
    case 1: 
    case 2: 
      return g.J;
    case 3: 
    case 4: 
      return g.K;
    case 5: 
      return g.L;
    }
    return g.H;
  }
  
  private void b(i parami)
  {
    Iterator localIterator = this.N.descendingIterator();
    while ((localIterator.hasNext()) && (!this.S))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      k localk = (k)localEntry.getValue();
      if ((localk.O.compareTo(this.O) > 0) && (!this.S) && (this.N.contains(localEntry.getKey())))
      {
        Object localObject = localk.O;
        switch (1.U[localObject.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(localObject)));
        case 1: 
          throw new IllegalArgumentException();
        case 2: 
          localObject = f.ON_DESTROY;
        case 3: 
        case 4: 
          for (;;)
          {
            d(b((f)localObject));
            localk.b(parami, (f)localObject);
            j();
            break;
            localObject = f.ON_STOP;
            continue;
            localObject = f.ON_PAUSE;
          }
        }
        throw new IllegalArgumentException();
      }
    }
  }
  
  private g c(h paramh)
  {
    paramh = this.N.b(paramh);
    if (paramh != null)
    {
      paramh = ((k)paramh.getValue()).O;
      if (this.T.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (g localg = (g)this.T.get(this.T.size() - 1);; localg = null)
    {
      return a(a(this.O, paramh), localg);
      paramh = null;
      break;
    }
  }
  
  private void c(g paramg)
  {
    if (this.O == paramg) {
      return;
    }
    this.O = paramg;
    if ((this.R) || (this.Q != 0))
    {
      this.S = true;
      return;
    }
    this.R = true;
    sync();
    this.R = false;
  }
  
  private void d(g paramg)
  {
    this.T.add(paramg);
  }
  
  private static f e(g paramg)
  {
    switch (1.U[paramg.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramg)));
    case 1: 
    case 5: 
      return f.ON_CREATE;
    case 2: 
      return f.ON_START;
    case 3: 
      return f.ON_RESUME;
    }
    throw new IllegalArgumentException();
  }
  
  private boolean i()
  {
    if (this.N.size() == 0) {
      return true;
    }
    g localg1 = ((k)this.N.d().getValue()).O;
    g localg2 = ((k)this.N.e().getValue()).O;
    return (localg1 == localg2) && (this.O == localg2);
  }
  
  private void j()
  {
    this.T.remove(this.T.size() - 1);
  }
  
  private void sync()
  {
    i locali = (i)this.P.get();
    if (locali == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!i())
    {
      this.S = false;
      if (this.O.compareTo(((k)this.N.d().getValue()).O) < 0) {
        b(locali);
      }
      Map.Entry localEntry = this.N.e();
      if ((!this.S) && (localEntry != null) && (this.O.compareTo(((k)localEntry.getValue()).O) > 0)) {
        a(locali);
      }
    }
    this.S = false;
  }
  
  public final void a(f paramf)
  {
    c(b(paramf));
  }
  
  public final void a(h paramh)
  {
    g localg;
    k localk;
    if (this.O == g.H)
    {
      localg = g.H;
      localk = new k(paramh, localg);
      if ((k)this.N.putIfAbsent(paramh, localk) == null) {
        break label49;
      }
    }
    label49:
    i locali;
    do
    {
      return;
      localg = g.I;
      break;
      locali = (i)this.P.get();
    } while (locali == null);
    if ((this.Q != 0) || (this.R)) {}
    for (int i = 1;; i = 0)
    {
      localg = c(paramh);
      this.Q += 1;
      while ((localk.O.compareTo(localg) < 0) && (this.N.contains(paramh)))
      {
        d(localk.O);
        localk.b(locali, e(localk.O));
        j();
        localg = c(paramh);
      }
    }
    if (i == 0) {
      sync();
    }
    this.Q -= 1;
  }
  
  public final void b(g paramg)
  {
    c(paramg);
  }
  
  public final void b(h paramh)
  {
    this.N.remove(paramh);
  }
  
  public final g g()
  {
    return this.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.j
 * JD-Core Version:    0.7.0.1
 */