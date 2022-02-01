package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.m.c.h;
import d.l.b.a.b.m.c.n;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static final c NBi;
  
  static
  {
    AppMethodBeat.i(60571);
    NBi = new c();
    AppMethodBeat.o(60571);
  }
  
  static boolean a(g paramg, d.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(60570);
    p.h(paramg, "$this$hasPathByNotMarkedNullableNodes");
    p.h(paramj, "start");
    p.h(paramn, "end");
    if (b(paramg, paramj, paramn))
    {
      AppMethodBeat.o(60570);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.NBp;
    if (localArrayDeque == null) {
      p.gfZ();
    }
    Set localSet = paramg.NBq;
    if (localSet == null) {
      p.gfZ();
    }
    localArrayDeque.push(paramj);
    label316:
    label320:
    label331:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label333;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + d.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60570);
        throw paramg;
      }
      Object localObject = (d.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.g(localObject, "current");
      if (localSet.add(localObject))
      {
        g.b localb;
        if (paramg.h((d.l.b.a.b.m.c.j)localObject))
        {
          localb = (g.b)g.b.c.NBw;
          label221:
          if (!(p.i(localb, g.b.c.NBw) ^ true)) {
            break label316;
          }
          label234:
          if (localb == null) {
            break label320;
          }
          localObject = paramg.k(paramg.i((d.l.b.a.b.m.c.j)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label331;
          }
          d.l.b.a.b.m.c.j localj = localb.b(paramg, (h)((Iterator)localObject).next());
          if (b(paramg, localj, paramn))
          {
            paramg.clear();
            AppMethodBeat.o(60570);
            return true;
            localb = (g.b)g.b.b.NBv;
            break label221;
            localb = null;
            break label234;
            break;
          }
          localArrayDeque.add(localj);
        }
      }
    }
    label333:
    paramg.clear();
    AppMethodBeat.o(60570);
    return false;
  }
  
  public static boolean a(g paramg, d.l.b.a.b.m.c.j paramj, g.b paramb)
  {
    AppMethodBeat.i(60569);
    p.h(paramg, "$this$hasNotNullSupertype");
    p.h(paramj, "type");
    p.h(paramb, "supertypesPolicy");
    if (((paramg.b(paramj)) && (!paramg.h(paramj))) || (paramg.h((h)paramj))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60569);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.NBp;
    if (localArrayDeque == null) {
      p.gfZ();
    }
    Set localSet = paramg.NBq;
    if (localSet == null) {
      p.gfZ();
    }
    localArrayDeque.push(paramj);
    label386:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label388;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + d.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60569);
        throw paramg;
      }
      Object localObject = (d.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.g(localObject, "current");
      if (localSet.add(localObject))
      {
        g.b localb;
        if (paramg.h((d.l.b.a.b.m.c.j)localObject))
        {
          localb = (g.b)g.b.c.NBw;
          label250:
          if (!(p.i(localb, g.b.c.NBw) ^ true)) {
            break label366;
          }
          label263:
          if (localb == null) {
            break label370;
          }
          localObject = paramg.k(paramg.i((d.l.b.a.b.m.c.j)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label386;
          }
          d.l.b.a.b.m.c.j localj = localb.b(paramg, (h)((Iterator)localObject).next());
          if (((paramg.b(localj)) && (!paramg.h(localj))) || (paramg.h((h)localj))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label377;
            }
            paramg.clear();
            AppMethodBeat.o(60569);
            return true;
            localb = paramb;
            break label250;
            label366:
            localb = null;
            break label263;
            label370:
            break;
          }
          label377:
          localArrayDeque.add(localj);
        }
      }
    }
    label388:
    paramg.clear();
    AppMethodBeat.o(60569);
    return false;
  }
  
  private static boolean b(g paramg, d.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(187789);
    if (paramg.j((h)paramj))
    {
      AppMethodBeat.o(187789);
      return true;
    }
    if (paramg.h(paramj))
    {
      AppMethodBeat.o(187789);
      return false;
    }
    if ((paramg.gtR()) && (paramg.e(paramj)))
    {
      AppMethodBeat.o(187789);
      return true;
    }
    boolean bool = paramg.b(paramg.i(paramj), paramn);
    AppMethodBeat.o(187789);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.c
 * JD-Core Version:    0.7.0.1
 */