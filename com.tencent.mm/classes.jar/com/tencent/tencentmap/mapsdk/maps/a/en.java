package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class en<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private int a;
  private c<K, V> b;
  private c<K, V> c;
  private c<K, V> d;
  
  public en()
  {
    AppMethodBeat.i(98798);
    this.a = 0;
    AppMethodBeat.o(98798);
  }
  
  private void a(c<K, V> paramc)
  {
    AppMethodBeat.i(147615);
    c.a(paramc, true);
    while ((paramc != null) && (paramc != this.b) && (c.e(c.d(paramc)) == true))
    {
      Object localObject;
      if (c.d(paramc) == d(b(b(paramc))))
      {
        localObject = e(b(b(paramc)));
        if (c((c)localObject) == true)
        {
          a(b(paramc), false);
          a((c)localObject, false);
          a(b(b(paramc)), true);
          paramc = b(b(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == e(b(paramc)))
          {
            localObject = b(paramc);
            g((c)localObject);
          }
          a(b((c)localObject), false);
          a(b(b((c)localObject)), true);
          h(b(b((c)localObject)));
          paramc = (c<K, V>)localObject;
        }
      }
      else
      {
        localObject = d(b(b(paramc)));
        if (c((c)localObject) == true)
        {
          a(b(paramc), false);
          a((c)localObject, false);
          a(b(b(paramc)), true);
          paramc = b(b(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == d(b(paramc)))
          {
            localObject = b(paramc);
            h((c)localObject);
          }
          a(b((c)localObject), false);
          a(b(b((c)localObject)), true);
          g(b(b((c)localObject)));
          paramc = (c<K, V>)localObject;
        }
      }
    }
    c.a(this.b, false);
    AppMethodBeat.o(147615);
  }
  
  private static <K extends Comparable<K>, V> void a(c<K, V> paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(147620);
    if (paramc != null) {
      c.a(paramc, paramBoolean);
    }
    AppMethodBeat.o(147620);
  }
  
  private static <K extends Comparable<K>, V> c<K, V> b(c<K, V> paramc)
  {
    AppMethodBeat.i(147616);
    if (paramc != null)
    {
      paramc = c.d(paramc);
      AppMethodBeat.o(147616);
      return paramc;
    }
    AppMethodBeat.o(147616);
    return null;
  }
  
  private V b(K paramK, V paramV)
  {
    AppMethodBeat.i(147614);
    c localc;
    for (Object localObject = this.b;; localObject = localc)
    {
      int i = paramK.compareTo(c.a((c)localObject));
      if (i < 0)
      {
        localc = c.b((c)localObject);
        if (localc != null) {
          continue;
        }
        this.a += 1;
        paramK = new c((c)localObject, this.d, paramK, paramV);
        if (i >= 0) {
          break label136;
        }
        c.a((c)localObject, paramK);
      }
      for (;;)
      {
        c.c(this.d, paramK);
        this.d = paramK;
        a(paramK);
        AppMethodBeat.o(147614);
        return null;
        if (i > 0)
        {
          localc = c.c((c)localObject);
          break;
        }
        paramK = ((c)localObject).getValue();
        ((c)localObject).setValue(paramV);
        AppMethodBeat.o(147614);
        return paramK;
        label136:
        if (i > 0) {
          c.b((c)localObject, paramK);
        }
      }
    }
  }
  
  private c<K, V> c(K paramK)
  {
    AppMethodBeat.i(147628);
    if (paramK != null)
    {
      c localc = this.b;
      while (localc != null)
      {
        int i = paramK.compareTo(c.a(localc));
        if (i < 0)
        {
          localc = c.b(localc);
        }
        else if (i > 0)
        {
          localc = c.c(localc);
        }
        else
        {
          AppMethodBeat.o(147628);
          return localc;
        }
      }
    }
    AppMethodBeat.o(147628);
    return null;
  }
  
  private static <K extends Comparable<K>, V> boolean c(c<K, V> paramc)
  {
    AppMethodBeat.i(147617);
    if (paramc != null)
    {
      boolean bool = c.e(paramc);
      AppMethodBeat.o(147617);
      return bool;
    }
    AppMethodBeat.o(147617);
    return false;
  }
  
  private static <K extends Comparable<K>, V> c<K, V> d(c<K, V> paramc)
  {
    AppMethodBeat.i(147618);
    if (paramc != null)
    {
      paramc = c.b(paramc);
      AppMethodBeat.o(147618);
      return paramc;
    }
    AppMethodBeat.o(147618);
    return null;
  }
  
  private static <K extends Comparable<K>, V> c<K, V> e(c<K, V> paramc)
  {
    AppMethodBeat.i(147619);
    if (paramc != null)
    {
      paramc = c.c(paramc);
      AppMethodBeat.o(147619);
      return paramc;
    }
    AppMethodBeat.o(147619);
    return null;
  }
  
  private static <K extends Comparable<K>, V> c<K, V> f(c<K, V> paramc)
  {
    AppMethodBeat.i(147621);
    if (paramc == null)
    {
      AppMethodBeat.o(147621);
      return null;
    }
    if (c.c(paramc) != null)
    {
      for (paramc = c.c(paramc); c.b(paramc) != null; paramc = c.b(paramc)) {}
      AppMethodBeat.o(147621);
      return paramc;
    }
    c localc1 = c.d(paramc);
    c<K, V> localc = paramc;
    for (paramc = localc1; (paramc != null) && (localc == c.c(paramc)); paramc = localc1)
    {
      localc1 = c.d(paramc);
      localc = paramc;
    }
    AppMethodBeat.o(147621);
    return paramc;
  }
  
  private void g(c<K, V> paramc)
  {
    AppMethodBeat.i(147622);
    c localc;
    if (paramc != null)
    {
      localc = c.c(paramc);
      c.b(paramc, c.b(localc));
      if (c.b(localc) != null) {
        c.d(c.b(localc), paramc);
      }
      c.d(localc, c.d(paramc));
      if (c.d(paramc) != null) {
        break label78;
      }
      this.b = localc;
    }
    for (;;)
    {
      c.a(localc, paramc);
      c.d(paramc, localc);
      AppMethodBeat.o(147622);
      return;
      label78:
      if (c.b(c.d(paramc)) == paramc) {
        c.a(c.d(paramc), localc);
      } else {
        c.b(c.d(paramc), localc);
      }
    }
  }
  
  private void h(c<K, V> paramc)
  {
    AppMethodBeat.i(147623);
    c localc;
    if (paramc != null)
    {
      localc = c.b(paramc);
      c.a(paramc, c.c(localc));
      if (c.c(localc) != null) {
        c.d(c.c(localc), paramc);
      }
      c.d(localc, c.d(paramc));
      if (c.d(paramc) != null) {
        break label78;
      }
      this.b = localc;
    }
    for (;;)
    {
      c.b(localc, paramc);
      c.d(paramc, localc);
      AppMethodBeat.o(147623);
      return;
      label78:
      if (c.c(c.d(paramc)) == paramc) {
        c.b(c.d(paramc), localc);
      } else {
        c.a(c.d(paramc), localc);
      }
    }
  }
  
  private void i(c<K, V> paramc)
  {
    AppMethodBeat.i(147625);
    Object localObject = paramc;
    if (c.b(paramc) != null)
    {
      localObject = paramc;
      if (c.c(paramc) != null)
      {
        localObject = f(paramc);
        c.a(paramc, c.a((c)localObject));
        c.a(paramc, c.f((c)localObject));
      }
    }
    if (c.b((c)localObject) != null)
    {
      paramc = c.b((c)localObject);
      if (paramc == null) {
        break label162;
      }
      c.d(paramc, c.d((c)localObject));
      if (c.d((c)localObject) != null) {
        break label127;
      }
      this.b = paramc;
    }
    for (;;)
    {
      c.a((c)localObject, null);
      c.b((c)localObject, null);
      c.d((c)localObject, null);
      if (c.e((c)localObject)) {
        break label225;
      }
      k(paramc);
      AppMethodBeat.o(147625);
      return;
      paramc = c.c((c)localObject);
      break;
      label127:
      if (localObject == c.b(c.d((c)localObject))) {
        c.a(c.d((c)localObject), paramc);
      } else {
        c.b(c.d((c)localObject), paramc);
      }
    }
    label162:
    if (c.d((c)localObject) == null)
    {
      this.b = null;
      AppMethodBeat.o(147625);
      return;
    }
    if (!c.e((c)localObject)) {
      k((c)localObject);
    }
    if (c.d((c)localObject) != null)
    {
      if (localObject != c.b(c.d((c)localObject))) {
        break label231;
      }
      c.a(c.d((c)localObject), null);
    }
    for (;;)
    {
      c.d((c)localObject, null);
      label225:
      AppMethodBeat.o(147625);
      return;
      label231:
      if (localObject == c.c(c.d((c)localObject))) {
        c.b(c.d((c)localObject), null);
      }
    }
  }
  
  private void j(c<K, V> paramc)
  {
    AppMethodBeat.i(147626);
    if (paramc == this.c) {
      this.c = c.g(paramc);
    }
    if (paramc == this.d) {
      this.d = c.h(paramc);
    }
    c localc = c.h(paramc);
    paramc = c.g(paramc);
    if (localc != null) {
      c.c(localc, paramc);
    }
    if (paramc != null) {
      c.e(paramc, localc);
    }
    AppMethodBeat.o(147626);
  }
  
  private void k(c<K, V> paramc)
  {
    AppMethodBeat.i(147627);
    while ((paramc != this.b) && (!c(paramc)))
    {
      Object localObject2;
      Object localObject1;
      if (paramc == d(b(paramc)))
      {
        localObject2 = e(b(paramc));
        localObject1 = localObject2;
        if (c((c)localObject2) == true)
        {
          a((c)localObject2, false);
          a(b(paramc), true);
          g(b(paramc));
          localObject1 = e(b(paramc));
        }
        if ((!c(d((c)localObject1))) && (!c(e((c)localObject1))))
        {
          a((c)localObject1, true);
          paramc = b(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!c(e((c)localObject1)))
          {
            a(d((c)localObject1), false);
            a((c)localObject1, true);
            h((c)localObject1);
            localObject2 = e(b(paramc));
          }
          a((c)localObject2, c(b(paramc)));
          a(b(paramc), false);
          a(e((c)localObject2), false);
          g(b(paramc));
          paramc = this.b;
        }
      }
      else
      {
        localObject2 = d(b(paramc));
        localObject1 = localObject2;
        if (c((c)localObject2) == true)
        {
          a((c)localObject2, false);
          a(b(paramc), true);
          h(b(paramc));
          localObject1 = d(b(paramc));
        }
        if ((!c(e((c)localObject1))) && (!c(d((c)localObject1))))
        {
          a((c)localObject1, true);
          paramc = b(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!c(d((c)localObject1)))
          {
            a(e((c)localObject1), false);
            a((c)localObject1, true);
            g((c)localObject1);
            localObject2 = d(b(paramc));
          }
          a((c)localObject2, c(b(paramc)));
          a(b(paramc), false);
          a(d((c)localObject2), false);
          h(b(paramc));
          paramc = this.b;
        }
      }
    }
    a(paramc, false);
    AppMethodBeat.o(147627);
  }
  
  public V a(K paramK)
  {
    AppMethodBeat.i(147612);
    paramK = c(paramK);
    if (paramK == null)
    {
      AppMethodBeat.o(147612);
      return null;
    }
    paramK = paramK.getValue();
    AppMethodBeat.o(147612);
    return paramK;
  }
  
  public V a(K paramK, V paramV)
  {
    AppMethodBeat.i(147613);
    eh.a(paramK);
    if (this.b == null)
    {
      this.b = new c(null, null, paramK, paramV);
      this.c = this.b;
      this.d = this.b;
      this.a += 1;
      AppMethodBeat.o(147613);
      return null;
    }
    paramK = b(paramK, paramV);
    AppMethodBeat.o(147613);
    return paramK;
  }
  
  public V b(K paramK)
  {
    AppMethodBeat.i(147624);
    paramK = c(paramK);
    if (paramK == null)
    {
      AppMethodBeat.o(147624);
      return null;
    }
    this.a -= 1;
    Object localObject = paramK.getValue();
    j(paramK);
    i(paramK);
    AppMethodBeat.o(147624);
    return localObject;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(147611);
    a locala = new a();
    AppMethodBeat.o(147611);
    return locala;
  }
  
  public int size()
  {
    return this.a;
  }
  
  class a
    extends AbstractSet<Map.Entry<K, V>>
  {
    a() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      AppMethodBeat.i(147602);
      en.b localb = new en.b(en.this, en.a(en.this), null);
      AppMethodBeat.o(147602);
      return localb;
    }
    
    public int size()
    {
      AppMethodBeat.i(147603);
      int i = en.this.size();
      AppMethodBeat.o(147603);
      return i;
    }
  }
  
  static class c<K extends Comparable<K>, V>
    implements Map.Entry<K, V>
  {
    private K a;
    private V b;
    private c<K, V> c;
    private c<K, V> d;
    private c<K, V> e;
    private boolean f = false;
    private c<K, V> g;
    private c<K, V> h;
    
    c(c<K, V> paramc1, c<K, V> paramc2, K paramK, V paramV)
    {
      this.c = paramc1;
      this.h = paramc2;
      this.a = paramK;
      this.b = paramV;
    }
    
    public K a()
    {
      return this.a;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(147607);
      if (!(paramObject instanceof Map.Entry))
      {
        AppMethodBeat.o(147607);
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      Object localObject = paramObject.getValue();
      if (this.a.equals(paramObject.getKey())) {
        if (this.b == null)
        {
          if (localObject != null) {}
        }
        else {
          while (this.b.equals(localObject))
          {
            AppMethodBeat.o(147607);
            return true;
          }
        }
      }
      AppMethodBeat.o(147607);
      return false;
    }
    
    public V getValue()
    {
      return this.b;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(147608);
      int j = this.a.hashCode();
      if (this.b == null) {}
      for (int i = 0;; i = this.b.hashCode())
      {
        AppMethodBeat.o(147608);
        return i ^ j;
      }
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.b;
      this.b = paramV;
      return localObject;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(147609);
      String str = this.a + "=" + this.b;
      AppMethodBeat.o(147609);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.en
 * JD-Core Version:    0.7.0.1
 */