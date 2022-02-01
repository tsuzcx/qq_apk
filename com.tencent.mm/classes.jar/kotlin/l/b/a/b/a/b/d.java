package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.d.a;

public final class d
{
  public static final d aiFp;
  
  static
  {
    AppMethodBeat.i(191475);
    aiFp = new d();
    AppMethodBeat.o(191475);
  }
  
  public static boolean h(e parame)
  {
    AppMethodBeat.i(191462);
    s.u(parame, "mutable");
    c localc = c.aiEX;
    boolean bool = c.f(kotlin.l.b.a.b.j.d.n((l)parame));
    AppMethodBeat.o(191462);
    return bool;
  }
  
  public static boolean i(e parame)
  {
    AppMethodBeat.i(191466);
    s.u(parame, "readOnly");
    c localc = c.aiEX;
    boolean bool = c.g(kotlin.l.b.a.b.j.d.n((l)parame));
    AppMethodBeat.o(191466);
    return bool;
  }
  
  public static e j(e parame)
  {
    AppMethodBeat.i(191472);
    s.u(parame, "readOnly");
    Object localObject = kotlin.l.b.a.b.j.d.n((l)parame);
    c localc = c.aiEX;
    localObject = c.e((kotlin.l.b.a.b.f.d)localObject);
    if (localObject == null)
    {
      parame = new IllegalArgumentException("Given class " + parame + " is not a " + "read-only" + " collection");
      AppMethodBeat.o(191472);
      throw parame;
    }
    parame = a.G((l)parame).a((kotlin.l.b.a.b.f.c)localObject);
    s.s(parame, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
    AppMethodBeat.o(191472);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */