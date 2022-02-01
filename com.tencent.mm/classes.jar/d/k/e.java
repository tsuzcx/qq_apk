package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.l;
import java.util.NoSuchElementException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class e
  extends ab
{
  private final int Njp;
  private boolean Njq;
  private int Njr;
  private final int kyd;
  
  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.kyd = paramInt3;
    this.Njp = paramInt2;
    if (this.kyd > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.Njq = bool;
        if (!this.Njq) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.Njr = paramInt1;
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
      paramInt1 = this.Njp;
    }
  }
  
  public final boolean hasNext()
  {
    return this.Njq;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(129303);
    int i = this.Njr;
    if (i == this.Njp)
    {
      if (!this.Njq)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.Njq = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.Njr += this.kyd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.e
 * JD-Core Version:    0.7.0.1
 */