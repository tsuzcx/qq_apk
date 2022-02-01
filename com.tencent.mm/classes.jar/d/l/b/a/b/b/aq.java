package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.y;
import java.util.Collection;

public abstract interface aq
{
  public abstract Collection<ab> a(at paramat, Collection<? extends ab> paramCollection, b<? super at, ? extends Iterable<? extends ab>> paramb, b<? super ab, y> paramb1);
  
  public static final class a
    implements aq
  {
    public static final a JqL;
    
    static
    {
      AppMethodBeat.i(56886);
      JqL = new a();
      AppMethodBeat.o(56886);
    }
    
    public final Collection<ab> a(at paramat, Collection<? extends ab> paramCollection, b<? super at, ? extends Iterable<? extends ab>> paramb, b<? super ab, y> paramb1)
    {
      AppMethodBeat.i(56885);
      k.h(paramat, "currentTypeConstructor");
      k.h(paramCollection, "superTypes");
      k.h(paramb, "neighbors");
      k.h(paramb1, "reportLoop");
      AppMethodBeat.o(56885);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.b.aq
 * JD-Core Version:    0.7.0.1
 */