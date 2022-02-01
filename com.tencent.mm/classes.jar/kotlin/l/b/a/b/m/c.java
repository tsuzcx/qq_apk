package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.r;

public final class c
{
  public static final c ajoO;
  
  static
  {
    AppMethodBeat.i(60571);
    ajoO = new c();
    AppMethodBeat.o(60571);
  }
  
  public static boolean a(g paramg, k paramk1, k paramk2)
  {
    AppMethodBeat.i(191601);
    s.u(paramg, "context");
    s.u(paramk1, "subType");
    s.u(paramk2, "superType");
    r localr = paramg.kAz();
    if (f.ajoT)
    {
      if ((localr.h(paramk1)) || (localr.k(localr.l(paramk1))) || (paramg.w((i)paramk1))) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError(s.X("Not singleClassifierType and not intersection subType: ", paramk1));
        AppMethodBeat.o(191601);
        throw paramg;
      }
      if ((localr.h(paramk2)) || (paramg.w((i)paramk2))) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError(s.X("Not singleClassifierType superType: ", paramk2));
        AppMethodBeat.o(191601);
        throw paramg;
      }
    }
    if (localr.f(paramk2))
    {
      AppMethodBeat.o(191601);
      return true;
    }
    if (localr.h((i)paramk1))
    {
      AppMethodBeat.o(191601);
      return true;
    }
    if (((paramk1 instanceof d)) && (localr.c((d)paramk1)))
    {
      AppMethodBeat.o(191601);
      return true;
    }
    if (a(paramg, paramk1, (g.b)g.b.b.ajpc))
    {
      AppMethodBeat.o(191601);
      return true;
    }
    if (localr.h((i)paramk2))
    {
      AppMethodBeat.o(191601);
      return false;
    }
    if (a(paramg, paramk2, (g.b)g.b.d.ajpe))
    {
      AppMethodBeat.o(191601);
      return false;
    }
    if (localr.d(paramk1))
    {
      AppMethodBeat.o(191601);
      return false;
    }
    boolean bool = a(paramg, paramk1, localr.l(paramk2));
    AppMethodBeat.o(191601);
    return bool;
  }
  
  private static boolean a(g paramg, k paramk, o paramo)
  {
    AppMethodBeat.i(60570);
    s.u(paramg, "context");
    s.u(paramk, "start");
    s.u(paramo, "end");
    r localr = paramg.kAz();
    if (b(paramg, paramk, paramo))
    {
      AppMethodBeat.o(60570);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.ajoW;
    s.checkNotNull(localArrayDeque);
    Set localSet = paramg.ajoX;
    s.checkNotNull(localSet);
    localArrayDeque.push(paramk);
    label224:
    label355:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label357;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramk + ". Supertypes = " + p.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60570);
        throw paramg;
      }
      Object localObject1 = (k)localArrayDeque.pop();
      s.s(localObject1, "current");
      if (localSet.add(localObject1))
      {
        g.b localb;
        label237:
        label241:
        Object localObject2;
        if (localr.f((k)localObject1))
        {
          localb = (g.b)g.b.c.ajpd;
          if (s.p(localb, g.b.c.ajpd)) {
            break label335;
          }
          i = 1;
          if (i == 0) {
            break label340;
          }
          if (localb == null) {
            break label344;
          }
          localObject2 = paramg.kAz();
          localObject1 = ((r)localObject2).o(((r)localObject2).l((k)localObject1)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label355;
          }
          localObject2 = localb.a(paramg, (i)((Iterator)localObject1).next());
          if (b(paramg, (k)localObject2, paramo))
          {
            paramg.clear();
            AppMethodBeat.o(60570);
            return true;
            localb = (g.b)g.b.b.ajpc;
            break label224;
            i = 0;
            break label237;
            localb = null;
            break label241;
            break;
          }
          localArrayDeque.add(localObject2);
        }
      }
    }
    label335:
    label340:
    label344:
    label357:
    paramg.clear();
    AppMethodBeat.o(60570);
    return false;
  }
  
  public static boolean a(g paramg, k paramk, g.b paramb)
  {
    AppMethodBeat.i(60569);
    s.u(paramg, "<this>");
    s.u(paramk, "type");
    s.u(paramb, "supertypesPolicy");
    r localr = paramg.kAz();
    if (((localr.d(paramk)) && (!localr.f(paramk))) || (localr.h((i)paramk))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60569);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.ajoW;
    s.checkNotNull(localArrayDeque);
    Set localSet = paramg.ajoX;
    s.checkNotNull(localSet);
    localArrayDeque.push(paramk);
    label262:
    label275:
    label279:
    label408:
    label412:
    label419:
    label428:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label430;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramk + ". Supertypes = " + p.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60569);
        throw paramg;
      }
      Object localObject1 = (k)localArrayDeque.pop();
      s.s(localObject1, "current");
      if (localSet.add(localObject1))
      {
        g.b localb;
        Object localObject2;
        if (localr.f((k)localObject1))
        {
          localb = (g.b)g.b.c.ajpd;
          if (s.p(localb, g.b.c.ajpd)) {
            break label403;
          }
          i = 1;
          if (i == 0) {
            break label408;
          }
          if (localb == null) {
            break label412;
          }
          localObject2 = paramg.kAz();
          localObject1 = ((r)localObject2).o(((r)localObject2).l((k)localObject1)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label428;
          }
          localObject2 = localb.a(paramg, (i)((Iterator)localObject1).next());
          if (((localr.d((k)localObject2)) && (!localr.f((k)localObject2))) || (localr.h((i)localObject2))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label419;
            }
            paramg.clear();
            AppMethodBeat.o(60569);
            return true;
            localb = paramb;
            break label262;
            i = 0;
            break label275;
            localb = null;
            break label279;
            break;
          }
          localArrayDeque.add(localObject2);
        }
      }
    }
    label403:
    label430:
    paramg.clear();
    AppMethodBeat.o(60569);
    return false;
  }
  
  private static boolean b(g paramg, k paramk, o paramo)
  {
    AppMethodBeat.i(191607);
    r localr = paramg.kAz();
    if (localr.l((i)paramk))
    {
      AppMethodBeat.o(191607);
      return true;
    }
    if (localr.f(paramk))
    {
      AppMethodBeat.o(191607);
      return false;
    }
    if ((paramg.kAB()) && (localr.i(paramk)))
    {
      AppMethodBeat.o(191607);
      return true;
    }
    boolean bool = localr.a(localr.l(paramk), paramo);
    AppMethodBeat.o(191607);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.c
 * JD-Core Version:    0.7.0.1
 */