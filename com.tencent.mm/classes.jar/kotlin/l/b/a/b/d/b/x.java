package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ad;

public final class x
  implements w<j>
{
  public static final x aiXg;
  
  static
  {
    AppMethodBeat.i(58268);
    aiXg = new x();
    AppMethodBeat.o(58268);
  }
  
  public final ad M(ad paramad)
  {
    AppMethodBeat.i(58270);
    s.u(this, "this");
    s.u(paramad, "kotlinType");
    AppMethodBeat.o(58270);
    return null;
  }
  
  public final ad N(Collection<? extends ad> paramCollection)
  {
    AppMethodBeat.i(58264);
    s.u(paramCollection, "types");
    paramCollection = new AssertionError(s.X("There should be no intersection type in existing descriptors, but found: ", p.a((Iterable)paramCollection, null, null, null, 0, null, null, 63)));
    AppMethodBeat.o(58264);
    throw paramCollection;
  }
  
  public final void a(ad paramad, e parame)
  {
    AppMethodBeat.i(58267);
    s.u(paramad, "kotlinType");
    s.u(parame, "descriptor");
    AppMethodBeat.o(58267);
  }
  
  public final boolean ksY()
  {
    AppMethodBeat.i(191939);
    s.u(this, "this");
    AppMethodBeat.o(191939);
    return true;
  }
  
  public final String v(e parame)
  {
    AppMethodBeat.i(58266);
    s.u(parame, "classDescriptor");
    AppMethodBeat.o(58266);
    return null;
  }
  
  public final String w(e parame)
  {
    AppMethodBeat.i(58269);
    s.u(this, "this");
    s.u(parame, "classDescriptor");
    AppMethodBeat.o(58269);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */