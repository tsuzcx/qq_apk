package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.av;

public final class c$l$a
  implements c.l
{
  public static final a Nts;
  
  static
  {
    AppMethodBeat.i(59681);
    Nts = new a();
    AppMethodBeat.o(59681);
  }
  
  public final void a(av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59680);
    p.h(paramav, "parameter");
    p.h(paramStringBuilder, "builder");
    if (paramInt1 != paramInt2 - 1) {
      paramStringBuilder.append(", ");
    }
    AppMethodBeat.o(59680);
  }
  
  public final void a(av paramav, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59679);
    p.h(paramav, "parameter");
    p.h(paramStringBuilder, "builder");
    AppMethodBeat.o(59679);
  }
  
  public final void e(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59677);
    p.h(paramStringBuilder, "builder");
    paramStringBuilder.append("(");
    AppMethodBeat.o(59677);
  }
  
  public final void f(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59678);
    p.h(paramStringBuilder, "builder");
    paramStringBuilder.append(")");
    AppMethodBeat.o(59678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.i.c.l.a
 * JD-Core Version:    0.7.0.1
 */