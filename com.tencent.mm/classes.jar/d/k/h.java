package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ac;
import d.l;
import java.util.NoSuchElementException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class h
  extends ac
{
  private boolean Njq;
  private final long Njw;
  private long Njx;
  private final long xMb;
  
  public h(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.xMb = paramLong3;
    this.Njw = paramLong2;
    if (this.xMb > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.Njq = bool;
        if (!this.Njq) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.Njx = paramLong1;
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
      paramLong1 = this.Njw;
    }
  }
  
  public final boolean hasNext()
  {
    return this.Njq;
  }
  
  public final long nextLong()
  {
    AppMethodBeat.i(129313);
    long l = this.Njx;
    if (l == this.Njw)
    {
      if (!this.Njq)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.Njq = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.Njx += this.xMb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.h
 * JD-Core Version:    0.7.0.1
 */