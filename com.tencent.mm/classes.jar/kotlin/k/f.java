package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.ah;

@Metadata(d1={""}, d2={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class f
  extends ah
{
  private final int aixu;
  private int aixv;
  private boolean aqS;
  private final int rBp;
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.rBp = paramInt3;
    this.aixu = paramInt2;
    if (this.rBp > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.aqS = bool;
        if (!this.aqS) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.aixv = paramInt1;
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
      paramInt1 = this.aixu;
    }
  }
  
  public final int Zo()
  {
    AppMethodBeat.i(129303);
    int i = this.aixv;
    if (i == this.aixu)
    {
      if (!this.aqS)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.aqS = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.aixv += this.rBp;
    }
  }
  
  public final boolean hasNext()
  {
    return this.aqS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.f
 * JD-Core Version:    0.7.0.1
 */