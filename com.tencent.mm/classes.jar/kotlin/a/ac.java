package kotlin.a;

import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/collections/LongIterator;", "", "", "()V", "next", "()Ljava/lang/Long;", "nextLong", "kotlin-stdlib"})
public abstract class ac
  implements Iterator<Long>, a
{
  public abstract long nextLong();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ac
 * JD-Core Version:    0.7.0.1
 */