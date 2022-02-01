package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.l;
import java.util.NoSuchElementException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class c
  extends ab
{
  private final int JhK;
  private boolean JhL;
  private int JhM;
  private final int jzV;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.jzV = paramInt3;
    this.JhK = paramInt2;
    if (this.jzV > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.JhL = bool;
        if (!this.JhL) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.JhM = paramInt1;
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
      paramInt1 = this.JhK;
    }
  }
  
  public final boolean hasNext()
  {
    return this.JhL;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(129303);
    int i = this.JhM;
    if (i == this.JhK)
    {
      if (!this.JhL)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.JhL = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.JhM += this.jzV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.c
 * JD-Core Version:    0.7.0.1
 */