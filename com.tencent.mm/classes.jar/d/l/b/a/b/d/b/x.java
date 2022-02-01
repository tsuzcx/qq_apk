package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.ab;
import java.util.Collection;

public final class x
  implements w<k>
{
  public static final x NGo;
  
  static
  {
    AppMethodBeat.i(58268);
    NGo = new x();
    AppMethodBeat.o(58268);
  }
  
  public final ab W(ab paramab)
  {
    AppMethodBeat.i(58270);
    p.h(paramab, "kotlinType");
    p.h(paramab, "kotlinType");
    AppMethodBeat.o(58270);
    return null;
  }
  
  public final void a(ab paramab, e parame)
  {
    AppMethodBeat.i(58267);
    p.h(paramab, "kotlinType");
    p.h(parame, "descriptor");
    AppMethodBeat.o(58267);
  }
  
  public final String u(e parame)
  {
    AppMethodBeat.i(58266);
    p.h(parame, "classDescriptor");
    AppMethodBeat.o(58266);
    return null;
  }
  
  public final ab v(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(58264);
    p.h(paramCollection, "types");
    paramCollection = (Throwable)new AssertionError("There should be no intersection type in existing descriptors, but found: " + j.a((Iterable)paramCollection, null, null, null, 0, null, null, 63));
    AppMethodBeat.o(58264);
    throw paramCollection;
  }
  
  public final String v(e parame)
  {
    AppMethodBeat.i(58269);
    p.h(parame, "classDescriptor");
    p.h(parame, "classDescriptor");
    AppMethodBeat.o(58269);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */