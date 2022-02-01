package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ab;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/collections/ULongIterator;", "", "Lkotlin/ULong;", "()V", "next", "next-s-VKNKU", "()J", "nextULong", "nextULong-s-VKNKU", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class ax
  implements Iterator<ab>, a
{
  public abstract long kkS();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.ax
 * JD-Core Version:    0.7.0.1
 */