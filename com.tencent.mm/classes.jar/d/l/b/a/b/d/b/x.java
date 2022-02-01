package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.ab;
import java.util.Collection;

public final class x
  implements w<k>
{
  public static final x JES;
  
  static
  {
    AppMethodBeat.i(58268);
    JES = new x();
    AppMethodBeat.o(58268);
  }
  
  public final ab W(ab paramab)
  {
    AppMethodBeat.i(58270);
    d.g.b.k.h(paramab, "kotlinType");
    d.g.b.k.h(paramab, "kotlinType");
    AppMethodBeat.o(58270);
    return null;
  }
  
  public final void a(ab paramab, e parame)
  {
    AppMethodBeat.i(58267);
    d.g.b.k.h(paramab, "kotlinType");
    d.g.b.k.h(parame, "descriptor");
    AppMethodBeat.o(58267);
  }
  
  public final ab t(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(58264);
    d.g.b.k.h(paramCollection, "types");
    paramCollection = (Throwable)new AssertionError("There should be no intersection type in existing descriptors, but found: " + j.a((Iterable)paramCollection, null, null, null, 0, null, null, 63));
    AppMethodBeat.o(58264);
    throw paramCollection;
  }
  
  public final String u(e parame)
  {
    AppMethodBeat.i(58266);
    d.g.b.k.h(parame, "classDescriptor");
    AppMethodBeat.o(58266);
    return null;
  }
  
  public final String v(e parame)
  {
    AppMethodBeat.i(58269);
    d.g.b.k.h(parame, "classDescriptor");
    d.g.b.k.h(parame, "classDescriptor");
    AppMethodBeat.o(58269);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */