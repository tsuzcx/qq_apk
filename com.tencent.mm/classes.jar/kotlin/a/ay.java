package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ae;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/collections/UShortIterator;", "", "Lkotlin/UShort;", "()V", "next", "next-Mh2AYeg", "()S", "nextUShort", "nextUShort-Mh2AYeg", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class ay
  implements Iterator<ae>, a
{
  public abstract short kkT();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.a.ay
 * JD-Core Version:    0.7.0.1
 */