package kotlin.l.b.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.c.a.c.a;

public final class a
{
  public static final void a(kotlin.l.b.a.b.c.a.c paramc, b paramb, ah paramah, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57522);
    s.u(paramc, "<this>");
    s.u(paramb, "from");
    s.u(paramah, "scopeOwner");
    s.u(paramf, "name");
    paramah = paramah.koY().PF();
    s.s(paramah, "scopeOwner.fqName.asString()");
    paramf = paramf.PF();
    s.s(paramf, "name.asString()");
    s.u(paramc, "<this>");
    s.u(paramb, "from");
    s.u(paramah, "packageFqName");
    s.u(paramf, "name");
    kotlin.l.b.a.b.c.a.a locala;
    if (paramc != c.a.aiNu)
    {
      locala = paramb.kro();
      if (locala != null) {
        if (!paramc.krp()) {
          break label142;
        }
      }
    }
    for (paramb = locala.krn();; paramb = kotlin.l.b.a.b.c.a.e.krq())
    {
      paramc.a(locala.getFilePath(), paramb, paramah, kotlin.l.b.a.b.c.a.f.aiNV, paramf);
      AppMethodBeat.o(57522);
      return;
      label142:
      paramb = kotlin.l.b.a.b.c.a.e.aiNT;
    }
  }
  
  public static final void a(kotlin.l.b.a.b.c.a.c paramc, b paramb, kotlin.l.b.a.b.b.e parame, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57521);
    s.u(paramc, "<this>");
    s.u(paramb, "from");
    s.u(parame, "scopeOwner");
    s.u(paramf, "name");
    if (paramc == c.a.aiNu)
    {
      AppMethodBeat.o(57521);
      return;
    }
    Object localObject = paramb.kro();
    if (localObject == null)
    {
      AppMethodBeat.o(57521);
      return;
    }
    if (paramc.krp()) {}
    for (paramb = ((kotlin.l.b.a.b.c.a.a)localObject).krn();; paramb = kotlin.l.b.a.b.c.a.e.krq())
    {
      localObject = ((kotlin.l.b.a.b.c.a.a)localObject).getFilePath();
      parame = kotlin.l.b.a.b.j.d.n((l)parame).PF();
      s.s(parame, "getFqName(scopeOwner).asString()");
      kotlin.l.b.a.b.c.a.f localf = kotlin.l.b.a.b.c.a.f.aiNW;
      paramf = paramf.PF();
      s.s(paramf, "name.asString()");
      paramc.a((String)localObject, paramb, parame, localf, paramf);
      AppMethodBeat.o(57521);
      return;
      paramb = kotlin.l.b.a.b.c.a.e.aiNT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */