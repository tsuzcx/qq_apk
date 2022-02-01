package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;

public final class x
{
  public static final a a(c paramc, int paramInt)
  {
    AppMethodBeat.i(60342);
    p.h(paramc, "$this$getClassId");
    paramc = a.dT(paramc.avl(paramInt), paramc.avm(paramInt));
    p.g(paramc, "ClassId.fromString(getQu… isLocalClassName(index))");
    AppMethodBeat.o(60342);
    return paramc;
  }
  
  public static final f b(c paramc, int paramInt)
  {
    AppMethodBeat.i(60343);
    p.h(paramc, "$this$getName");
    paramc = f.bub(paramc.getString(paramInt));
    p.g(paramc, "Name.guessByFirstCharacter(getString(index))");
    AppMethodBeat.o(60343);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.x
 * JD-Core Version:    0.7.0.1
 */