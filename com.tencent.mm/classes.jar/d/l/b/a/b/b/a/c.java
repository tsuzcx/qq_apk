package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.u;
import java.util.Map;

public abstract interface c
{
  public abstract an ghI();
  
  public abstract Map<f, g<?>> gjK();
  
  public abstract b gjg();
  
  public abstract ab gju();
  
  public static final class a
  {
    public static b b(c paramc)
    {
      AppMethodBeat.i(56927);
      paramc = a.l(paramc);
      if (paramc != null)
      {
        if (!u.L((l)paramc)) {}
        while (paramc != null)
        {
          paramc = a.I((l)paramc);
          AppMethodBeat.o(56927);
          return paramc;
          paramc = null;
        }
      }
      AppMethodBeat.o(56927);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.a.c
 * JD-Core Version:    0.7.0.1
 */