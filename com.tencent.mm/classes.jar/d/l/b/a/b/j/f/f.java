package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.e;
import d.l.b.a.b.c.a.a;
import java.util.Set;

public final class f
  extends i
{
  private final h NUY;
  
  public f(h paramh)
  {
    AppMethodBeat.i(60210);
    this.NUY = paramh;
    AppMethodBeat.o(60210);
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, a parama)
  {
    AppMethodBeat.i(60205);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = this.NUY.c(paramf, parama);
    if (paramf != null) {
      if ((paramf instanceof e)) {
        break label97;
      }
    }
    label97:
    for (parama = null;; parama = paramf)
    {
      parama = (e)parama;
      if (parama != null)
      {
        paramf = (d.l.b.a.b.b.h)parama;
        AppMethodBeat.o(60205);
        return paramf;
      }
      if (!(paramf instanceof ar)) {
        paramf = null;
      }
      for (;;)
      {
        paramf = (d.l.b.a.b.b.h)paramf;
        AppMethodBeat.o(60205);
        return paramf;
        AppMethodBeat.o(60205);
        return null;
      }
    }
  }
  
  public final Set<d.l.b.a.b.f.f> goy()
  {
    AppMethodBeat.i(60207);
    Set localSet = this.NUY.goy();
    AppMethodBeat.o(60207);
    return localSet;
  }
  
  public final Set<d.l.b.a.b.f.f> goz()
  {
    AppMethodBeat.i(60208);
    Set localSet = this.NUY.goz();
    AppMethodBeat.o(60208);
    return localSet;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60209);
    String str = "Classes from " + this.NUY;
    AppMethodBeat.o(60209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.f
 * JD-Core Version:    0.7.0.1
 */