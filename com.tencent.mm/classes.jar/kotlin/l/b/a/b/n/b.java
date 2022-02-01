package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.x;

public abstract interface b
{
  public abstract String getDescription();
  
  public abstract boolean h(x paramx);
  
  public abstract String i(x paramx);
  
  public static final class a
  {
    public static String a(b paramb, x paramx)
    {
      AppMethodBeat.i(61278);
      s.u(paramb, "this");
      s.u(paramx, "functionDescriptor");
      if (!paramb.h(paramx))
      {
        paramb = paramb.getDescription();
        AppMethodBeat.o(61278);
        return paramb;
      }
      AppMethodBeat.o(61278);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.b
 * JD-Core Version:    0.7.0.1
 */