package d.a;

import d.g.b.a.e;
import d.l;
import java.util.AbstractList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public abstract class c<E>
  extends AbstractList<E>
  implements e, List<E>
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
 * Qualified Name:     d.a.c
 * JD-Core Version:    0.7.0.1
 */