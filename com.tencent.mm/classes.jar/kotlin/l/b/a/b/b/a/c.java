package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.v;

public abstract interface c
{
  public abstract av knm();
  
  public abstract ad koG();
  
  public abstract kotlin.l.b.a.b.f.c koY();
  
  public abstract Map<f, g<?>> kpA();
  
  public static final class a
  {
    public static kotlin.l.b.a.b.f.c b(c paramc)
    {
      AppMethodBeat.i(56927);
      s.u(paramc, "this");
      paramc = a.j(paramc);
      if (paramc == null)
      {
        AppMethodBeat.o(56927);
        return null;
      }
      if (!v.L((l)paramc)) {}
      while (paramc == null)
      {
        AppMethodBeat.o(56927);
        return null;
        paramc = null;
      }
      paramc = a.I((l)paramc);
      AppMethodBeat.o(56927);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.c
 * JD-Core Version:    0.7.0.1
 */