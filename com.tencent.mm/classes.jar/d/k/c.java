package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.l;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class c
  extends ab
{
  private final int MMk;
  private boolean MMl;
  private int MMm;
  private final int kuN;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.kuN = paramInt3;
    this.MMk = paramInt2;
    if (this.kuN > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.MMl = bool;
        if (!this.MMl) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.MMm = paramInt1;
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
      paramInt1 = this.MMk;
    }
  }
  
  public final boolean hasNext()
  {
    return this.MMl;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(129303);
    int i = this.MMm;
    if (i == this.MMk)
    {
      if (!this.MMl)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.MMl = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.MMm += this.kuN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.c
 * JD-Core Version:    0.7.0.1
 */