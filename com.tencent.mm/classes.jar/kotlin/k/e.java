package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ab;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class e
  extends ab
{
  private final int SYX;
  private boolean SYY;
  private int SYZ;
  private final int lCq;
  
  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129304);
    this.lCq = paramInt3;
    this.SYX = paramInt2;
    if (this.lCq > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.SYY = bool;
        if (!this.SYY) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.SYZ = paramInt1;
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
      paramInt1 = this.SYX;
    }
  }
  
  public final boolean hasNext()
  {
    return this.SYY;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(129303);
    int i = this.SYZ;
    if (i == this.SYX)
    {
      if (!this.SYY)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129303);
        throw localThrowable;
      }
      this.SYY = false;
    }
    for (;;)
    {
      AppMethodBeat.o(129303);
      return i;
      this.SYZ += this.lCq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.e
 * JD-Core Version:    0.7.0.1
 */