package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bd;

public abstract interface c$l
{
  public abstract void a(bd parambd, int paramInt1, int paramInt2, StringBuilder paramStringBuilder);
  
  public abstract void a(bd parambd, StringBuilder paramStringBuilder);
  
  public abstract void f(StringBuilder paramStringBuilder);
  
  public abstract void g(StringBuilder paramStringBuilder);
  
  public static final class a
    implements c.l
  {
    public static final a ajgN;
    
    static
    {
      AppMethodBeat.i(59681);
      ajgN = new a();
      AppMethodBeat.o(59681);
    }
    
    public final void a(bd parambd, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59680);
      s.u(parambd, "parameter");
      s.u(paramStringBuilder, "builder");
      if (paramInt1 != paramInt2 - 1) {
        paramStringBuilder.append(", ");
      }
      AppMethodBeat.o(59680);
    }
    
    public final void a(bd parambd, StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59679);
      s.u(parambd, "parameter");
      s.u(paramStringBuilder, "builder");
      AppMethodBeat.o(59679);
    }
    
    public final void f(StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59677);
      s.u(paramStringBuilder, "builder");
      paramStringBuilder.append("(");
      AppMethodBeat.o(59677);
    }
    
    public final void g(StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59678);
      s.u(paramStringBuilder, "builder");
      paramStringBuilder.append(")");
      AppMethodBeat.o(59678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.i.c.l
 * JD-Core Version:    0.7.0.1
 */