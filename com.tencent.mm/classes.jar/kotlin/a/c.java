package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class c<K, V>
  implements Map<K, V>, kotlin.g.b.a.a
{
  public static final c.a aivg = new c.a((byte)0);
  private volatile Set<? extends K> aive;
  private volatile Collection<? extends V> aivf;
  
  private final String ca(Object paramObject)
  {
    if (paramObject == (c)this) {
      return "(this Map)";
    }
    return String.valueOf(paramObject);
  }
  
  private final Map.Entry<K, V> hq(K paramK)
  {
    Iterator localIterator = ((Iterable)entrySet()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((Map.Entry)localObject).getKey(), paramK));
    for (paramK = localObject;; paramK = null) {
      return (Map.Entry)paramK;
    }
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return hq(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    Object localObject = (Iterable)entrySet();
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (s.p(((Map.Entry)((Iterator)localObject).next()).getValue(), paramObject)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return qH();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == (c)this) {
      return true;
    }
    if (!(paramObject instanceof Map)) {
      return false;
    }
    if (size() != ((Map)paramObject).size()) {
      return false;
    }
    paramObject = (Iterable)((Map)paramObject).entrySet();
    if ((!(paramObject instanceof Collection)) || (!((Collection)paramObject).isEmpty()))
    {
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        Object localObject2 = (Map.Entry)paramObject.next();
        int i;
        if (!(localObject2 instanceof Map.Entry)) {
          i = 0;
        }
        while (i == 0)
        {
          return false;
          Object localObject1 = ((Map.Entry)localObject2).getKey();
          localObject2 = ((Map.Entry)localObject2).getValue();
          Object localObject3 = ((Map)this).get(localObject1);
          if ((s.p(localObject2, localObject3) ^ true)) {
            i = 0;
          } else if ((localObject3 == null) && (!((Map)this).containsKey(localObject1))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
    }
    return true;
  }
  
  public V get(Object paramObject)
  {
    paramObject = hq(paramObject);
    if (paramObject != null) {
      return paramObject.getValue();
    }
    return null;
  }
  
  public int getSize()
  {
    return entrySet().size();
  }
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final Set<K> keySet()
  {
    return qI();
  }
  
  public V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public abstract Set qH();
  
  public Set<K> qI()
  {
    if (this.aive == null) {
      this.aive = ((Set)new b(this));
    }
    Set localSet = this.aive;
    s.checkNotNull(localSet);
    return localSet;
  }
  
  public Collection<V> qJ()
  {
    if (this.aivf == null) {
      this.aivf = ((Collection)new d(this));
    }
    Collection localCollection = this.aivf;
    s.checkNotNull(localCollection);
    return localCollection;
  }
  
  public V remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public String toString()
  {
    return p.a((Iterable)entrySet(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (b)new c(this), 24);
  }
  
  public final Collection<V> values()
  {
    return qJ();
  }
  
  @Metadata(d1={""}, d2={"kotlin/collections/AbstractMap$keys$1", "Lkotlin/collections/AbstractSet;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class b
    extends h<K>
  {
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(191015);
      boolean bool = this.aivh.containsKey(paramObject);
      AppMethodBeat.o(191015);
      return bool;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(191031);
      int i = this.aivh.size();
      AppMethodBeat.o(191031);
      return i;
    }
    
    public final Iterator<K> iterator()
    {
      AppMethodBeat.i(191023);
      Iterator localIterator = (Iterator)new c.b.a(this.aivh.entrySet().iterator());
      AppMethodBeat.o(191023);
      return localIterator;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "K", "V", "it", "", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements b<Map.Entry<? extends K, ? extends V>, CharSequence>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/collections/AbstractMap$values$1", "Lkotlin/collections/AbstractCollection;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class d
    extends a<V>
  {
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(191016);
      boolean bool = this.aivh.containsValue(paramObject);
      AppMethodBeat.o(191016);
      return bool;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(191030);
      int i = this.aivh.size();
      AppMethodBeat.o(191030);
      return i;
    }
    
    public final Iterator<V> iterator()
    {
      AppMethodBeat.i(191022);
      Iterator localIterator = (Iterator)new c.d.a(this.aivh.entrySet().iterator());
      AppMethodBeat.o(191022);
      return localIterator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.c
 * JD-Core Version:    0.7.0.1
 */