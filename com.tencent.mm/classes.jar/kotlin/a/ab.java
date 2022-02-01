package kotlin.a;

import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/collections/IntIterator;", "", "", "()V", "next", "()Ljava/lang/Integer;", "nextInt", "kotlin-stdlib"})
public abstract class ab
  implements Iterator<Integer>, a
{
  public abstract int nextInt();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ab
 * JD-Core Version:    0.7.0.1
 */