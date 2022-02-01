package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ac;
import d.l;
import java.util.NoSuchElementException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class f
  extends ac
{
  private boolean JhL;
  private final long JhR;
  private long JhS;
  private final long vfC;
  
  public f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.vfC = paramLong3;
    this.JhR = paramLong2;
    if (this.vfC > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.JhL = bool;
        if (!this.JhL) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.JhS = paramLong1;
      AppMethodBeat.o(129314);
      return;
      bool = false;
      break;
      if (paramLong1 >= paramLong2) {
        break;
      }
      bool = false;
      break;
      label80:
      paramLong1 = this.JhR;
    }
  }
  
  public final boolean hasNext()
  {
    return this.JhL;
  }
  
  public final long nextLong()
  {
    AppMethodBeat.i(129313);
    long l = this.JhS;
    if (l == this.JhR)
    {
      if (!this.JhL)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.JhL = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.JhS += this.vfC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.f
 * JD-Core Version:    0.7.0.1
 */