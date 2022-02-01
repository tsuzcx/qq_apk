package d.a;

import d.g.b.a.a;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/collections/IntIterator;", "", "", "()V", "next", "()Ljava/lang/Integer;", "nextInt", "kotlin-stdlib"})
public abstract class ab
  implements a, Iterator<Integer>
{
  public abstract int nextInt();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.ab
 * JD-Core Version:    0.7.0.1
 */