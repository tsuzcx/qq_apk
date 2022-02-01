package kotlin.a;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.a.g;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class f<K, V>
  extends AbstractMap<K, V>
  implements Map<K, V>, g
{
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return qH();
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public final Set<K> keySet()
  {
    return qI();
  }
  
  public abstract Set qH();
  
  public Set qI()
  {
    return super.keySet();
  }
  
  public Collection qJ()
  {
    return super.values();
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public final Collection<V> values()
  {
    return qJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.a.f
 * JD-Core Version:    0.7.0.1
 */