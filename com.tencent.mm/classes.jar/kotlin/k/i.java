package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.ai;

@Metadata(d1={""}, d2={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class i
  extends ai
{
  private final long NFM;
  private final long aixA;
  private long aixB;
  private boolean aqS;
  
  public i(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(129314);
    this.NFM = paramLong3;
    this.aixA = paramLong2;
    if (this.NFM > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.aqS = bool;
        if (!this.aqS) {
          break label80;
        }
      }
    }
    for (;;)
    {
      this.aixB = paramLong1;
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
      paramLong1 = this.aixA;
    }
  }
  
  public final long Zn()
  {
    AppMethodBeat.i(129313);
    long l = this.aixB;
    if (l == this.aixA)
    {
      if (!this.aqS)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129313);
        throw localThrowable;
      }
      this.aqS = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129313);
      return l;
      this.aixB += this.NFM;
    }
  }
  
  public final boolean hasNext()
  {
    return this.aqS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.i
 * JD-Core Version:    0.7.0.1
 */