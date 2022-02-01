package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.a;

public final class f
  extends i
{
  private final h TJU;
  
  public f(h paramh)
  {
    AppMethodBeat.i(60210);
    this.TJU = paramh;
    AppMethodBeat.o(60210);
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, a parama)
  {
    AppMethodBeat.i(60205);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = this.TJU.c(paramf, parama);
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
        paramf = (kotlin.l.b.a.b.b.h)parama;
        AppMethodBeat.o(60205);
        return paramf;
      }
      if (!(paramf instanceof ar)) {
        paramf = null;
      }
      for (;;)
      {
        paramf = (kotlin.l.b.a.b.b.h)paramf;
        AppMethodBeat.o(60205);
        return paramf;
        AppMethodBeat.o(60205);
        return null;
      }
    }
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCa()
  {
    AppMethodBeat.i(60207);
    Set localSet = this.TJU.hCa();
    AppMethodBeat.o(60207);
    return localSet;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCb()
  {
    AppMethodBeat.i(60208);
    Set localSet = this.TJU.hCb();
    AppMethodBeat.o(60208);
    return localSet;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60209);
    String str = "Classes from " + this.TJU;
    AppMethodBeat.o(60209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.f
 * JD-Core Version:    0.7.0.1
 */