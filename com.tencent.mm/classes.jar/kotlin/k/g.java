package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ac;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class g
  extends ac
{
  private final long HIt;
  private final long aaBY;
  private long aaBZ;
  private boolean zca;
  
  public g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.HIt = paramLong3;
    this.aaBY = paramLong2;
    if (this.HIt > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.zca = bool;
        if (!this.zca) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.aaBZ = paramLong1;
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
      paramLong1 = this.aaBY;
    }
  }
  
  public final boolean hasNext()
  {
    return this.zca;
  }
  
  public final long zC()
  {
    AppMethodBeat.i(129313);
    long l = this.aaBZ;
    if (l == this.aaBY)
    {
      if (!this.zca)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.zca = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.aaBZ += this.HIt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.g
 * JD-Core Version:    0.7.0.1
 */