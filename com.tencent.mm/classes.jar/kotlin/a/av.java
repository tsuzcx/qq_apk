package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.x;

@Metadata(d1={""}, d2={"Lkotlin/collections/UByteIterator;", "", "Lkotlin/UByte;", "()V", "next", "next-w2LRezQ", "()B", "nextUByte", "nextUByte-w2LRezQ", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class av
  implements Iterator<x>, a
{
  public abstract byte kkQ();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.a.av
 * JD-Core Version:    0.7.0.1
 */