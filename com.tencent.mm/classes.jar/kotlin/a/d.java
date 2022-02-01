package kotlin.a;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.a.b;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractMutableCollection;", "E", "", "Ljava/util/AbstractCollection;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class d<E>
  extends AbstractCollection<E>
  implements Collection<E>, b
{
  public abstract int getSize();
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.d
 * JD-Core Version:    0.7.0.1
 */