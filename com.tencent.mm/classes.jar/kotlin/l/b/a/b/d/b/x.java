package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;

public final class x
  implements w<k>
{
  public static final x aaYK;
  
  static
  {
    AppMethodBeat.i(58268);
    aaYK = new x();
    AppMethodBeat.o(58268);
  }
  
  public final ab V(ab paramab)
  {
    AppMethodBeat.i(58270);
    p.k(paramab, "kotlinType");
    p.k(paramab, "kotlinType");
    AppMethodBeat.o(58270);
    return null;
  }
  
  public final void a(ab paramab, e parame)
  {
    AppMethodBeat.i(58267);
    p.k(paramab, "kotlinType");
    p.k(parame, "descriptor");
    AppMethodBeat.o(58267);
  }
  
  public final String u(e parame)
  {
    AppMethodBeat.i(58266);
    p.k(parame, "classDescriptor");
    AppMethodBeat.o(58266);
    return null;
  }
  
  public final String v(e parame)
  {
    AppMethodBeat.i(58269);
    p.k(parame, "classDescriptor");
    p.k(parame, "classDescriptor");
    AppMethodBeat.o(58269);
    return null;
  }
  
  public final ab w(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(58264);
    p.k(paramCollection, "types");
    paramCollection = (Throwable)new AssertionError("There should be no intersection type in existing descriptors, but found: " + j.a((Iterable)paramCollection, null, null, null, 0, null, null, 63));
    AppMethodBeat.o(58264);
    throw paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */