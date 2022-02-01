package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.m;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static final c LKj;
  
  static
  {
    AppMethodBeat.i(60571);
    LKj = new c();
    AppMethodBeat.o(60571);
  }
  
  static boolean a(g paramg, i parami, m paramm)
  {
    AppMethodBeat.i(60570);
    k.h(paramg, "$this$hasPathByNotMarkedNullableNodes");
    k.h(parami, "start");
    k.h(paramm, "end");
    if ((paramg.j((d.l.b.a.b.m.c.g)parami)) || ((!paramg.h(parami)) && (paramg.b(paramg.i(parami), paramm)))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60570);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.LKq;
    if (localArrayDeque == null) {
      k.fOy();
    }
    Set localSet = paramg.LKr;
    if (localSet == null) {
      k.fOy();
    }
    localArrayDeque.push(parami);
    label268:
    label401:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label403;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + parami + ". Supertypes = " + j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60570);
        throw paramg;
      }
      Object localObject = (i)localArrayDeque.pop();
      k.g(localObject, "current");
      if (localSet.add(localObject))
      {
        g.c localc;
        if (paramg.h((i)localObject))
        {
          localc = (g.c)g.c.c.LKC;
          label255:
          if (!(k.g(localc, g.c.c.LKC) ^ true)) {
            break label381;
          }
          if (localc == null) {
            break label385;
          }
          localObject = paramg.k(paramg.i((i)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label401;
          }
          i locali = localc.b(paramg, (d.l.b.a.b.m.c.g)((Iterator)localObject).next());
          if ((paramg.j((d.l.b.a.b.m.c.g)locali)) || ((!paramg.h(locali)) && (paramg.b(paramg.i(locali), paramm)))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label392;
            }
            paramg.clear();
            AppMethodBeat.o(60570);
            return true;
            localc = (g.c)g.c.b.LKB;
            break label255;
            label381:
            localc = null;
            break label268;
            break;
          }
          localArrayDeque.add(locali);
        }
      }
    }
    label385:
    label392:
    label403:
    paramg.clear();
    AppMethodBeat.o(60570);
    return false;
  }
  
  public static boolean a(g paramg, i parami, g.c paramc)
  {
    AppMethodBeat.i(60569);
    k.h(paramg, "$this$hasNotNullSupertype");
    k.h(parami, "type");
    k.h(paramc, "supertypesPolicy");
    if (((paramg.b(parami)) && (!paramg.h(parami))) || (paramg.h((d.l.b.a.b.m.c.g)parami))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60569);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.LKq;
    if (localArrayDeque == null) {
      k.fOy();
    }
    Set localSet = paramg.LKr;
    if (localSet == null) {
      k.fOy();
    }
    localArrayDeque.push(parami);
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
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + parami + ". Supertypes = " + j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60569);
        throw paramg;
      }
      Object localObject = (i)localArrayDeque.pop();
      k.g(localObject, "current");
      if (localSet.add(localObject))
      {
        g.c localc;
        if (paramg.h((i)localObject))
        {
          localc = (g.c)g.c.c.LKC;
          label250:
          if (!(k.g(localc, g.c.c.LKC) ^ true)) {
            break label366;
          }
          label263:
          if (localc == null) {
            break label370;
          }
          localObject = paramg.k(paramg.i((i)localObject)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label386;
          }
          i locali = localc.b(paramg, (d.l.b.a.b.m.c.g)((Iterator)localObject).next());
          if (((paramg.b(locali)) && (!paramg.h(locali))) || (paramg.h((d.l.b.a.b.m.c.g)locali))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label377;
            }
            paramg.clear();
            AppMethodBeat.o(60569);
            return true;
            localc = paramc;
            break label250;
            label366:
            localc = null;
            break label263;
            label370:
            break;
          }
          label377:
          localArrayDeque.add(locali);
        }
      }
    }
    label388:
    paramg.clear();
    AppMethodBeat.o(60569);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.c
 * JD-Core Version:    0.7.0.1
 */