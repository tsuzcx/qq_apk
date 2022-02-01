package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.n;

public final class c
{
  public static final c abpK;
  
  static
  {
    AppMethodBeat.i(60571);
    abpK = new c();
    AppMethodBeat.o(60571);
  }
  
  static boolean a(g paramg, kotlin.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(60570);
    p.k(paramg, "$this$hasPathByNotMarkedNullableNodes");
    p.k(paramj, "start");
    p.k(paramn, "end");
    if (b(paramg, paramj, paramn))
    {
      AppMethodBeat.o(60570);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.abpR;
    if (localArrayDeque == null) {
      p.iCn();
    }
    Set localSet = paramg.abpS;
    if (localSet == null) {
      p.iCn();
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
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + kotlin.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60570);
        throw paramg;
      }
      Object localObject = (kotlin.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.j(localObject, "current");
      if (localSet.add(localObject))
      {
        g.b localb;
        if (paramg.h((kotlin.l.b.a.b.m.c.j)localObject))
        {
          localb = (g.b)g.b.c.abpY;
          label221:
          if (!(p.h(localb, g.b.c.abpY) ^ true)) {
            break label316;
          }
          label234:
          if (localb == null) {
            break label320;
          }
          localObject = paramg.k(paramg.i((kotlin.l.b.a.b.m.c.j)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label331;
          }
          kotlin.l.b.a.b.m.c.j localj = localb.b(paramg, (h)((Iterator)localObject).next());
          if (b(paramg, localj, paramn))
          {
            paramg.clear();
            AppMethodBeat.o(60570);
            return true;
            localb = (g.b)g.b.b.abpX;
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
  
  public static boolean a(g paramg, kotlin.l.b.a.b.m.c.j paramj, g.b paramb)
  {
    AppMethodBeat.i(60569);
    p.k(paramg, "$this$hasNotNullSupertype");
    p.k(paramj, "type");
    p.k(paramb, "supertypesPolicy");
    if (((paramg.b(paramj)) && (!paramg.h(paramj))) || (paramg.h((h)paramj))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60569);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.abpR;
    if (localArrayDeque == null) {
      p.iCn();
    }
    Set localSet = paramg.abpS;
    if (localSet == null) {
      p.iCn();
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
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + kotlin.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60569);
        throw paramg;
      }
      Object localObject = (kotlin.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.j(localObject, "current");
      if (localSet.add(localObject))
      {
        g.b localb;
        if (paramg.h((kotlin.l.b.a.b.m.c.j)localObject))
        {
          localb = (g.b)g.b.c.abpY;
          label250:
          if (!(p.h(localb, g.b.c.abpY) ^ true)) {
            break label366;
          }
          label263:
          if (localb == null) {
            break label370;
          }
          localObject = paramg.k(paramg.i((kotlin.l.b.a.b.m.c.j)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label386;
          }
          kotlin.l.b.a.b.m.c.j localj = localb.b(paramg, (h)((Iterator)localObject).next());
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
  
  private static boolean b(g paramg, kotlin.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(269719);
    if (paramg.j((h)paramj))
    {
      AppMethodBeat.o(269719);
      return true;
    }
    if (paramg.h(paramj))
    {
      AppMethodBeat.o(269719);
      return false;
    }
    if ((paramg.iPP()) && (paramg.e(paramj)))
    {
      AppMethodBeat.o(269719);
      return true;
    }
    boolean bool = paramg.b(paramg.i(paramj), paramn);
    AppMethodBeat.o(269719);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.c
 * JD-Core Version:    0.7.0.1
 */