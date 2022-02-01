package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.k.a.q;

public final class i
  implements q
{
  public static final i aiME;
  
  static
  {
    AppMethodBeat.i(57381);
    aiME = new i();
    AppMethodBeat.o(57381);
  }
  
  public final void a(e parame, List<String> paramList)
  {
    AppMethodBeat.i(57379);
    s.u(parame, "descriptor");
    s.u(paramList, "unresolvedSuperClasses");
    parame = new IllegalStateException("Incomplete hierarchy for class " + parame.kok() + ", unresolved classes " + paramList);
    AppMethodBeat.o(57379);
    throw parame;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(57380);
    s.u(paramb, "descriptor");
    paramb = new IllegalStateException(s.X("Cannot infer visibility for ", paramb));
    AppMethodBeat.o(57380);
    throw paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.i
 * JD-Core Version:    0.7.0.1
 */