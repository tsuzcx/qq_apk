package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.t;

public abstract interface b
{
  public abstract String getDescription();
  
  public abstract boolean h(t paramt);
  
  public abstract String i(t paramt);
  
  public static final class a
  {
    public static String a(b paramb, t paramt)
    {
      AppMethodBeat.i(61278);
      k.h(paramt, "functionDescriptor");
      if (!paramb.h(paramt))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.n.b
 * JD-Core Version:    0.7.0.1
 */