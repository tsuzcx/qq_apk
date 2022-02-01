package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ac;
import d.l;
import java.util.NoSuchElementException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class f
  extends ac
{
  private boolean KVf;
  private final long KVl;
  private long KVm;
  private final long woo;
  
  public f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.woo = paramLong3;
    this.KVl = paramLong2;
    if (this.woo > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.KVf = bool;
        if (!this.KVf) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.KVm = paramLong1;
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
      paramLong1 = this.KVl;
    }
  }
  
  public final boolean hasNext()
  {
    return this.KVf;
  }
  
  public final long nextLong()
  {
    AppMethodBeat.i(129313);
    long l = this.KVm;
    if (l == this.KVl)
    {
      if (!this.KVf)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.KVf = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.KVm += this.woo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.f
 * JD-Core Version:    0.7.0.1
 */