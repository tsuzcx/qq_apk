package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ab;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class d
  extends ab
{
  private final int aaBS;
  private int aaBT;
  private final int oxQ;
  private boolean zca;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.oxQ = paramInt3;
    this.aaBS = paramInt2;
    if (this.oxQ > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.zca = bool;
        if (!this.zca) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.aaBT = paramInt1;
      AppMethodBeat.o(129304);
      return;
      bool = false;
      break;
      if (paramInt1 >= paramInt2) {
        break;
      }
      bool = false;
      break;
      label75:
      paramInt1 = this.aaBS;
    }
  }
  
  public final boolean hasNext()
  {
    return this.zca;
  }
  
  public final int zD()
  {
    AppMethodBeat.i(129303);
    int i = this.aaBT;
    if (i == this.aaBS)
    {
      if (!this.zca)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.zca = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.aaBT += this.oxQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.d
 * JD-Core Version:    0.7.0.1
 */