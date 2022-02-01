package kotlin.a;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.a.h;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractMutableSet;", "E", "", "Ljava/util/AbstractSet;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class g<E>
  extends AbstractSet<E>
  implements Set<E>, h
{
  public abstract int getSize();
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.g
 * JD-Core Version:    0.7.0.1
 */