package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.l;
import java.util.NoSuchElementException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class c
  extends ab
{
  private final int KVe;
  private boolean KVf;
  private int KVg;
  private final int kar;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.kar = paramInt3;
    this.KVe = paramInt2;
    if (this.kar > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.KVf = bool;
        if (!this.KVf) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.KVg = paramInt1;
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
      paramInt1 = this.KVe;
    }
  }
  
  public final boolean hasNext()
  {
    return this.KVf;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(129303);
    int i = this.KVg;
    if (i == this.KVe)
    {
      if (!this.KVf)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.KVf = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.KVg += this.kar;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.c
 * JD-Core Version:    0.7.0.1
 */