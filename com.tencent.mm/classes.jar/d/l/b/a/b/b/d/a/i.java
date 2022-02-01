package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.k.a.r;
import java.util.List;

public final class i
  implements r
{
  public static final i JvK;
  
  static
  {
    AppMethodBeat.i(57381);
    JvK = new i();
    AppMethodBeat.o(57381);
  }
  
  public final void a(e parame, List<String> paramList)
  {
    AppMethodBeat.i(57379);
    k.h(parame, "descriptor");
    k.h(paramList, "unresolvedSuperClasses");
    parame = (Throwable)new IllegalStateException("Incomplete hierarchy for class " + parame.fyB() + ", unresolved classes " + paramList);
    AppMethodBeat.o(57379);
    throw parame;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(57380);
    k.h(paramb, "descriptor");
    paramb = (Throwable)new IllegalStateException("Cannot infer visibility for ".concat(String.valueOf(paramb)));
    AppMethodBeat.o(57380);
    throw paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.i
 * JD-Core Version:    0.7.0.1
 */