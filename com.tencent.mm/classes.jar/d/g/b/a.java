package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
final class a<T>
  implements d.g.b.a.a, Iterator<T>
{
  private final T[] KUx;
  private int index;
  
  public a(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129329);
    this.KUx = paramArrayOfT;
    AppMethodBeat.o(129329);
  }
  
  public final boolean hasNext()
  {
    return this.index < this.KUx.length;
  }
  
  public final T next()
  {
    AppMethodBeat.i(129328);
    try
    {
      Object localObject = this.KUx;
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
 * Qualified Name:     d.g.b.a
 * JD-Core Version:    0.7.0.1
 */