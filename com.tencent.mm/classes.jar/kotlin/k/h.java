package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ac;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class h
  extends ac
{
  private final long BMh;
  private boolean SYY;
  private final long SZe;
  private long SZf;
  
  public h(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.BMh = paramLong3;
    this.SZe = paramLong2;
    if (this.BMh > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.SYY = bool;
        if (!this.SYY) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.SZf = paramLong1;
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
      paramLong1 = this.SZe;
    }
  }
  
  public final boolean hasNext()
  {
    return this.SYY;
  }
  
  public final long nextLong()
  {
    AppMethodBeat.i(129313);
    long l = this.SZf;
    if (l == this.SZe)
    {
      if (!this.SYY)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.SYY = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.SZf += this.BMh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.h
 * JD-Core Version:    0.7.0.1
 */