package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.m.h;

@Metadata(d1={""}, d2={"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class c
  implements h<String>
{
  private final BufferedReader dcZ;
  
  public c(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(129277);
    this.dcZ = paramBufferedReader;
    AppMethodBeat.o(129277);
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(129276);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129276);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/io/LinesSequence$iterator$1", "", "", "done", "", "nextValue", "hasNext", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<String>, a
  {
    private String aiwC;
    private boolean done;
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129264);
      if ((this.aiwC == null) && (!this.done))
      {
        this.aiwC = c.a(this.aiwD).readLine();
        if (this.aiwC == null) {
          this.done = true;
        }
      }
      if (this.aiwC != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.f.c
 * JD-Core Version:    0.7.0.1
 */