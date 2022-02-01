package kotlin.a;

import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class e<E>
  extends AbstractList<E>
  implements List<E>, kotlin.g.b.a.e
{
  public abstract int getSize();
  
  public final E remove(int paramInt)
  {
    return removeAt(paramInt);
  }
  
  public abstract E removeAt(int paramInt);
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.e
 * JD-Core Version:    0.7.0.1
 */