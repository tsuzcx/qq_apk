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
  private static final LinkedHashSet<kotlin.l.b.a.b.f.a> aaFs;
  public static final c aaFt;
  
  static
  {
    AppMethodBeat.i(56653);
    aaFt = new c();
    Object localObject1 = h.aaHw;
    p.j(localObject1, "PrimitiveType.NUMBER_TYPES");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(g.c((h)((Iterator)localObject2).next()));
    }
    localObject2 = (Iterable)j.b((Collection)j.b((Collection)j.b((Collection)localObject1, g.aaFI.aaFS.iND()), g.aaFI.aaFU.iND()), g.aaFI.aaGd.iND());
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(kotlin.l.b.a.b.f.a.p((b)((Iterator)localObject2).next()));
    }
    aaFs = (LinkedHashSet)localObject1;
    AppMethodBeat.o(56653);
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(56652);
    p.k(parame, "classDescriptor");
    if (kotlin.l.b.a.b.j.c.u((l)parame))
    {
      Iterable localIterable = (Iterable)aaFs;
      parame = kotlin.l.b.a.b.j.d.a.c((kotlin.l.b.a.b.b.h)parame);
      if (parame != null) {}
      for (parame = parame.iNv(); j.a(localIterable, parame); parame = null)
      {
        AppMethodBeat.o(56652);
        return true;
      }
    }
    AppMethodBeat.o(56652);
    return false;
  }
  
  public static Set<kotlin.l.b.a.b.f.a> iDm()
  {
    AppMethodBeat.i(56651);
    Set localSet = Collections.unmodifiableSet((Set)aaFs);
    p.j(localSet, "Collections.unmodifiableSet(classIds)");
    AppMethodBeat.o(56651);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */