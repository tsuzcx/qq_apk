package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/collections/IntIterator;", "", "", "()V", "next", "()Ljava/lang/Integer;", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class ah
  implements Iterator<Integer>, a
{
  public abstract int Zo();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ah
 * JD-Core Version:    0.7.0.1
 */