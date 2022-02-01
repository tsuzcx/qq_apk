package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.z;

@Metadata(d1={""}, d2={"Lkotlin/collections/UIntIterator;", "", "Lkotlin/UInt;", "()V", "next", "next-pVg5ArA", "()I", "nextUInt", "nextUInt-pVg5ArA", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class aw
  implements Iterator<z>, a
{
  public abstract int kkR();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.aw
 * JD-Core Version:    0.7.0.1
 */