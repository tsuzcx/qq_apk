package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends q<K, V>
  implements Map<K, V>
{
  g<K, V> iP;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  private g<K, V> be()
  {
    if (this.iP == null) {
      this.iP = new g()
      {
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          a locala = a.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = locala.iZ[paramAnonymousInt];
          locala.iZ[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void a(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final Object b(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.iZ[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final int bf()
        {
          return a.this.e;
        }
        
        protected final Map<K, V> bg()
        {
          return a.this;
        }
        
        protected final void bh()
        {
          a.this.clear();
        }
        
        protected final int j(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int k(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final void p(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
      };
    }
    return this.iP;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    g localg = be();
    if (localg.jm == null) {
      localg.jm = new i(localg);
    }
    return localg.jm;
  }
  
  public Set<K> keySet()
  {
    return be().bk();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(this.e + paramMap.size());
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
    g localg = be();
    if (localg.jo == null) {
      localg.jo = new l(localg);
    }
    return localg.jo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.a
 * JD-Core Version:    0.7.0.1
 */