package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class b<T>
  implements Iterator<T>, a
{
  private final T[] aivD;
  private int index;
  
  public b(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129329);
    this.aivD = paramArrayOfT;
    AppMethodBeat.o(129329);
  }
  
  public final boolean hasNext()
  {
    return this.index < this.aivD.length;
  }
  
  public final T next()
  {
    AppMethodBeat.i(129328);
    try
    {
      Object localObject = this.aivD;
      int i = this.index;
      this.index = (i + 1);
      localObject = localObject[i];
      AppMethodBeat.o(129328);
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      Throwable localThrowable = (Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(129328);
      throw localThrowable;
    }
  }
  
  public final void remove()
  {
    AppMethodBeat.i(129330);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129330);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.b
 * JD-Core Version:    0.7.0.1
 */