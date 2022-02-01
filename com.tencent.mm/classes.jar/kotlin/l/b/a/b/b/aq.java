package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.x;

public abstract interface aq
{
  public abstract Collection<ab> a(at paramat, Collection<? extends ab> paramCollection, b<? super at, ? extends Iterable<? extends ab>> paramb, b<? super ab, x> paramb1);
  
  public static final class a
    implements aq
  {
    public static final a ThM;
    
    static
    {
      AppMethodBeat.i(56886);
      ThM = new a();
      AppMethodBeat.o(56886);
    }
    
    public final Collection<ab> a(at paramat, Collection<? extends ab> paramCollection, b<? super at, ? extends Iterable<? extends ab>> paramb, b<? super ab, x> paramb1)
    {
      AppMethodBeat.i(56885);
      p.h(paramat, "currentTypeConstructor");
      p.h(paramCollection, "superTypes");
      p.h(paramb, "neighbors");
      p.h(paramb1, "reportLoop");
      AppMethodBeat.o(56885);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aq
 * JD-Core Version:    0.7.0.1
 */