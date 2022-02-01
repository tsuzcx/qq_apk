package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.l;
import kotlin.m.h;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"})
final class c
  implements h<String>
{
  final BufferedReader bzE;
  
  public c(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(129277);
    this.bzE = paramBufferedReader;
    AppMethodBeat.o(129277);
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(129276);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129276);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/io/LinesSequence$iterator$1", "", "", "done", "", "nextValue", "hasNext", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<String>, a
  {
    private String SYf;
    private boolean done;
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129264);
      if ((this.SYf == null) && (!this.done))
      {
        this.SYf = this.SYg.bzE.readLine();
        if (this.SYf == null) {
          this.done = true;
        }
      }
      if (this.SYf != null)
      {
        AppMethodBeat.o(129264);
        return true;
      }
      AppMethodBeat.o(129264);
      return false;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129266);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129266);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.f.c
 * JD-Core Version:    0.7.0.1
 */