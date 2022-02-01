package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;

public final class c
{
  private static final LinkedHashSet<kotlin.l.b.a.b.f.a> Tcy;
  public static final c Tcz;
  
  static
  {
    AppMethodBeat.i(56653);
    Tcz = new c();
    Object localObject1 = h.TeC;
    p.g(localObject1, "PrimitiveType.NUMBER_TYPES");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(g.c((h)((Iterator)localObject2).next()));
    }
    localObject2 = (Iterable)j.b((Collection)j.b((Collection)j.b((Collection)localObject1, g.TcO.TcY.hJj()), g.TcO.Tda.hJj()), g.TcO.Tdj.hJj());
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(kotlin.l.b.a.b.f.a.p((b)((Iterator)localObject2).next()));
    }
    Tcy = (LinkedHashSet)localObject1;
    AppMethodBeat.o(56653);
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(56652);
    p.h(parame, "classDescriptor");
    if (kotlin.l.b.a.b.j.c.u((l)parame))
    {
      Iterable localIterable = (Iterable)Tcy;
      parame = kotlin.l.b.a.b.j.d.a.c((kotlin.l.b.a.b.b.h)parame);
      if (parame != null) {}
      for (parame = parame.hJb(); j.a(localIterable, parame); parame = null)
      {
        AppMethodBeat.o(56652);
        return true;
      }
    }
    AppMethodBeat.o(56652);
    return false;
  }
  
  public static Set<kotlin.l.b.a.b.f.a> hza()
  {
    AppMethodBeat.i(56651);
    Set localSet = Collections.unmodifiableSet((Set)Tcy);
    p.g(localSet, "Collections.unmodifiableSet(classIds)");
    AppMethodBeat.o(56651);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */