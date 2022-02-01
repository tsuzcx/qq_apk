package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends r<K, V>
  implements Map<K, V>
{
  g<K, V> kN;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  private g<K, V> bv()
  {
    if (this.kN == null) {
      this.kN = new g()
      {
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          a locala = a.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = locala.kW[paramAnonymousInt];
          locala.kW[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final Object b(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.kW[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final void b(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int bw()
        {
          return a.this.m;
        }
        
        protected final Map<K, V> bx()
        {
          return a.this;
        }
        
        protected final void by()
        {
          a.this.clear();
        }
        
        protected final int q(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int r(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final void z(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
      };
    }
    return this.kN;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    g localg = bv();
    if (localg.lj == null) {
      localg.lj = new i(localg);
    }
    return localg.lj;
  }
  
  public Set<K> keySet()
  {
    return bv().bB();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(this.m + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    return g.a(this, paramCollection);
  }
  
  public Collection<V> values()
  {
    g localg = bv();
    if (localg.ll == null) {
      localg.ll = new l(localg);
    }
    return localg.ll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.a
 * JD-Core Version:    0.7.0.1
 */