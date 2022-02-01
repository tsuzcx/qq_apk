package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ac;
import d.l;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class f
  extends ac
{
  private boolean MMl;
  private final long MMr;
  private long MMs;
  private final long xwe;
  
  public f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.xwe = paramLong3;
    this.MMr = paramLong2;
    if (this.xwe > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.MMl = bool;
        if (!this.MMl) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.MMs = paramLong1;
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
      paramLong1 = this.MMr;
    }
  }
  
  public final boolean hasNext()
  {
    return this.MMl;
  }
  
  public final long nextLong()
  {
    AppMethodBeat.i(129313);
    long l = this.MMs;
    if (l == this.MMr)
    {
      if (!this.MMl)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.MMl = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.MMs += this.xwe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.f
 * JD-Core Version:    0.7.0.1
 */