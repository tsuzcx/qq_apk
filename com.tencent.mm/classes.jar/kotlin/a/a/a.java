package kotlin.a.a;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V>
  extends g<E>
{
  public abstract boolean b(Map.Entry<? extends K, ? extends V> paramEntry);
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    s.u(paramObject, "element");
    return b(paramObject);
  }
  
  public boolean m(Map.Entry paramEntry)
  {
    return super.remove(paramEntry);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    return m((Map.Entry)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.a
 * JD-Core Version:    0.7.0.1
 */