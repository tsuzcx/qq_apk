package android.arch.lifecycle;

import android.arch.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public final class f
  extends b
{
  private boolean A = false;
  private ArrayList<d> B = new ArrayList();
  private a<Object, g> t = new a();
  private d u;
  private final e v;
  private int w = 0;
  private boolean z = false;
  
  public f(e parame)
  {
    this.v = parame;
    this.u = d.o;
  }
  
  static d b(c paramc)
  {
    switch (1.C[paramc.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + paramc);
    case 1: 
    case 2: 
      return d.p;
    case 3: 
    case 4: 
      return d.q;
    case 5: 
      return d.r;
    }
    return d.n;
  }
  
  private void b(d paramd)
  {
    this.B.add(paramd);
  }
  
  private void e()
  {
    this.B.remove(this.B.size() - 1);
  }
  
  private void f()
  {
    android.arch.a.a.f localf = this.t.a();
    while ((localf.hasNext()) && (!this.A))
    {
      Map.Entry localEntry = (Map.Entry)localf.next();
      g localg = (g)localEntry.getValue();
      if ((localg.u.compareTo(this.u) < 0) && (!this.A) && (this.t.contains(localEntry.getKey())))
      {
        b(localg.u);
        e locale = this.v;
        Object localObject = localg.u;
        switch (1.D[localObject.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value " + localObject);
        case 1: 
        case 5: 
          localObject = c.ON_CREATE;
        case 2: 
        case 3: 
          for (;;)
          {
            localg.b(locale, (c)localObject);
            e();
            break;
            localObject = c.ON_START;
            continue;
            localObject = c.ON_RESUME;
          }
        }
        throw new IllegalArgumentException();
      }
    }
  }
  
  public final void a(c paramc)
  {
    this.u = b(paramc);
    if ((this.z) || (this.w != 0))
    {
      this.A = true;
      return;
    }
    this.z = true;
    for (;;)
    {
      int i;
      if (this.t.size() == 0) {
        i = 1;
      }
      g localg;
      for (;;)
      {
        if (i != 0) {
          break label408;
        }
        this.A = false;
        if (this.u.compareTo(((g)this.t.b().getValue()).u) >= 0) {
          break;
        }
        Object localObject = this.t.descendingIterator();
        Map.Entry localEntry;
        do
        {
          if ((!((Iterator)localObject).hasNext()) || (this.A)) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          localg = (g)localEntry.getValue();
        } while ((localg.u.compareTo(this.u) <= 0) || (this.A) || (!this.t.contains(localEntry.getKey())));
        paramc = localg.u;
        switch (1.D[paramc.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value " + paramc);
          paramc = ((g)this.t.b().getValue()).u;
          localObject = ((g)this.t.c().getValue()).u;
          if ((paramc == localObject) && (this.u == localObject)) {
            i = 1;
          } else {
            i = 0;
          }
          break;
        }
      }
      throw new IllegalArgumentException();
      paramc = c.ON_DESTROY;
      for (;;)
      {
        b(b(paramc));
        localg.b(this.v, paramc);
        e();
        break;
        paramc = c.ON_STOP;
        continue;
        paramc = c.ON_PAUSE;
      }
      throw new IllegalArgumentException();
      paramc = this.t.c();
      if ((!this.A) && (paramc != null) && (this.u.compareTo(((g)paramc.getValue()).u) > 0)) {
        f();
      }
    }
    label408:
    this.A = false;
    this.z = false;
  }
  
  public final void a(d paramd)
  {
    this.u = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.f
 * JD-Core Version:    0.7.0.1
 */