package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ab;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.c.a;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.r;
import kotlin.l.b.a.b.m.c.v;
import kotlin.l.b.a.b.m.c.w;

public final class f
{
  public static final f ajoS;
  public static boolean ajoT;
  
  static
  {
    AppMethodBeat.i(60589);
    ajoS = new f();
    AppMethodBeat.o(60589);
  }
  
  private static boolean a(r paramr, i parami)
  {
    AppMethodBeat.i(191618);
    if ((paramr.h(paramr.q(parami))) && (!paramr.i(parami)) && (!paramr.h(parami)) && (s.p(paramr.l(paramr.n(parami)), paramr.l(paramr.r(parami)))))
    {
      AppMethodBeat.o(191618);
      return true;
    }
    AppMethodBeat.o(191618);
    return false;
  }
  
  private static boolean a(r paramr, i parami1, i parami2, o paramo)
  {
    AppMethodBeat.i(191611);
    parami1 = paramr.c(parami1);
    if ((!(parami1 instanceof kotlin.l.b.a.b.m.c.d)) || (paramr.b((kotlin.l.b.a.b.m.c.d)parami1)) || (!paramr.c(paramr.a(paramr.e((kotlin.l.b.a.b.m.c.d)parami1)))))
    {
      AppMethodBeat.o(191611);
      return false;
    }
    if (paramr.a((kotlin.l.b.a.b.m.c.d)parami1) != b.ajrC)
    {
      AppMethodBeat.o(191611);
      return false;
    }
    parami1 = paramr.q(parami2);
    if ((parami1 instanceof v)) {}
    for (parami1 = (v)parami1; parami1 == null; parami1 = null)
    {
      AppMethodBeat.o(191611);
      return false;
    }
    parami1 = paramr.a(parami1);
    if ((parami1 != null) && (paramr.a(parami1, paramo) == true))
    {
      AppMethodBeat.o(191611);
      return true;
    }
    AppMethodBeat.o(191611);
    return false;
  }
  
  private static final boolean a(r paramr, g paramg, k paramk1, k paramk2, boolean paramBoolean)
  {
    AppMethodBeat.i(191629);
    paramk1 = (Iterable)paramr.k(paramk1);
    if ((!(paramk1 instanceof Collection)) || (!((Collection)paramk1).isEmpty()))
    {
      paramk1 = paramk1.iterator();
      while (paramk1.hasNext())
      {
        i locali = (i)paramk1.next();
        if ((s.p(paramr.q(locali), paramr.l(paramk2))) || ((paramBoolean) && (a(paramg, (i)paramk2, locali)))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(191629);
          return true;
        }
      }
    }
    AppMethodBeat.o(191629);
    return false;
  }
  
  private static boolean a(g paramg, i parami1, i parami2)
  {
    int i = 0;
    boolean bool = false;
    AppMethodBeat.i(191595);
    s.u(paramg, "context");
    s.u(parami1, "subType");
    s.u(parami2, "superType");
    if (parami1 == parami2)
    {
      AppMethodBeat.o(191595);
      return true;
    }
    s.u(parami1, "subType");
    s.u(parami2, "superType");
    r localr1 = paramg.kAz();
    i locali1 = paramg.u(paramg.t(parami1));
    i locali2 = paramg.u(paramg.t(parami2));
    k localk = localr1.n(locali1);
    parami1 = localr1.r(locali2);
    r localr2 = paramg.kAz();
    if ((localr2.j((i)localk)) || (localr2.j((i)parami1))) {
      if (paramg.kAA()) {
        parami1 = Boolean.TRUE;
      }
    }
    while (parami1 != null)
    {
      bool = parami1.booleanValue();
      g.a(locali1, locali2);
      AppMethodBeat.o(191595);
      return bool;
      if ((localr2.f(localk)) && (!localr2.f(parami1)))
      {
        parami1 = Boolean.FALSE;
      }
      else
      {
        parami1 = Boolean.valueOf(d.ajoP.a(localr2, (i)localr2.a(localk, false), (i)localr2.a(parami1, false)));
        continue;
        label283:
        Object localObject1;
        label301:
        label323:
        label370:
        Object localObject2;
        if ((localr2.j(localk)) && (localr2.j(parami1)))
        {
          parami2 = localr2.c(localk);
          if (parami2 == null)
          {
            parami2 = localk;
            localObject1 = localr2.c(parami1);
            if (localObject1 != null) {
              break label370;
            }
            localObject1 = parami1;
            if (localr2.l(parami2) == localr2.l((k)localObject1)) {
              break label396;
            }
            i = 0;
            if ((i == 0) && (!paramg.kAB())) {
              break label463;
            }
          }
          label396:
          label463:
          for (bool = true;; bool = false)
          {
            parami1 = Boolean.valueOf(bool);
            break;
            localObject1 = localr2.a(parami2);
            parami2 = (i)localObject1;
            if (localObject1 != null) {
              break label283;
            }
            parami2 = localk;
            break label283;
            localObject2 = localr2.a((kotlin.l.b.a.b.m.c.e)localObject1);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label301;
            }
            localObject1 = parami1;
            break label301;
            if ((!localr2.h((i)localk)) && (localr2.h((i)parami1)))
            {
              i = 0;
              break label323;
            }
            if ((localr2.f(localk)) && (!localr2.f(parami1)))
            {
              i = 0;
              break label323;
            }
            i = 1;
            break label323;
          }
        }
        if ((localr2.i(localk)) || (localr2.i(parami1)))
        {
          parami1 = Boolean.valueOf(paramg.kAB());
        }
        else
        {
          parami2 = localr2.c(parami1);
          if (parami2 == null)
          {
            parami2 = parami1;
            label518:
            localObject2 = localr2.b(parami2);
            if (localObject2 != null) {
              break label706;
            }
            localObject1 = null;
            label536:
            if ((localObject2 != null) && (localObject1 != null))
            {
              if (!localr2.f(parami1)) {
                break label720;
              }
              parami2 = localr2.s((i)localObject1);
              label567:
              s.u(localk, "subType");
              s.u(localObject2, "superType");
              localObject1 = g.a.ajoZ;
            }
            switch (a.avl[localObject1.ordinal()])
            {
            default: 
              label616:
              parami2 = localr2.l(parami1);
              if (!localr2.k(parami2)) {
                break label877;
              }
              if (localr2.f(parami1)) {
                break;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if ((!ak.aiuY) || (i != 0)) {
              break label792;
            }
            paramg = (Throwable)new AssertionError(s.X("Intersection type should not be marked nullable!: ", parami1));
            AppMethodBeat.o(191595);
            throw paramg;
            localObject1 = localr2.a(parami2);
            parami2 = (i)localObject1;
            if (localObject1 != null) {
              break label518;
            }
            parami2 = parami1;
            break label518;
            label706:
            localObject1 = localr2.d((kotlin.l.b.a.b.m.c.d)localObject2);
            break label536;
            label720:
            parami2 = (i)localObject1;
            if (!localr2.h((i)parami1)) {
              break label567;
            }
            parami2 = localr2.o((i)localObject1);
            break label567;
            parami1 = Boolean.valueOf(a(paramg, (i)localk, parami2));
            break;
            if (!a(paramg, (i)localk, parami2)) {
              break label616;
            }
            parami1 = Boolean.TRUE;
            break;
          }
          label792:
          parami1 = (Iterable)localr2.o(parami2);
          if ((!(parami1 instanceof Collection)) || (!((Collection)parami1).isEmpty()))
          {
            parami1 = parami1.iterator();
            do
            {
              if (!parami1.hasNext()) {
                break;
              }
              parami2 = (i)parami1.next();
            } while (b(paramg, (i)localk, parami2));
          }
          for (;;)
          {
            parami1 = Boolean.valueOf(bool);
            break;
            bool = true;
          }
          label877:
          parami2 = localr2.l(localk);
          if (!(localk instanceof kotlin.l.b.a.b.m.c.d))
          {
            if (!localr2.k(parami2)) {
              break label1027;
            }
            parami2 = (Iterable)localr2.o(parami2);
            if (((parami2 instanceof Collection)) && (((Collection)parami2).isEmpty())) {
              break label1022;
            }
            parami2 = parami2.iterator();
            do
            {
              if (!parami2.hasNext()) {
                break;
              }
            } while (((i)parami2.next() instanceof kotlin.l.b.a.b.m.c.d));
          }
          for (;;)
          {
            if (i == 0) {
              break label1027;
            }
            parami2 = ajoS.c(paramg.kAz(), (i)parami1, (i)localk);
            if ((parami2 == null) || (!localr2.a(parami2, localr2.l(parami1)))) {
              break label1027;
            }
            parami1 = Boolean.TRUE;
            break;
            label1022:
            i = 1;
          }
          label1027:
          parami1 = null;
        }
      }
    }
    parami1 = g.a(locali1, locali2);
    if (parami1 != null)
    {
      bool = parami1.booleanValue();
      AppMethodBeat.o(191595);
      return bool;
    }
    bool = c(paramg, localr1.n(locali1), localr1.r(locali2));
    AppMethodBeat.o(191595);
    return bool;
  }
  
  private static boolean a(g paramg, k paramk)
  {
    AppMethodBeat.i(60582);
    r localr = paramg.kAz();
    Object localObject1 = localr.l(paramk);
    if (localr.f((o)localObject1))
    {
      boolean bool = localr.l((o)localObject1);
      AppMethodBeat.o(60582);
      return bool;
    }
    if (localr.l(localr.l(paramk)))
    {
      AppMethodBeat.o(60582);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.ajoW;
    s.checkNotNull(localArrayDeque);
    Set localSet = paramg.ajoX;
    s.checkNotNull(localSet);
    localArrayDeque.push(paramk);
    label261:
    label391:
    label402:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label404;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramk + ". Supertypes = " + kotlin.a.p.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60582);
        throw paramg;
      }
      Object localObject2 = (k)localArrayDeque.pop();
      s.s(localObject2, "current");
      if (localSet.add(localObject2))
      {
        label274:
        label278:
        Object localObject3;
        if (localr.d((k)localObject2))
        {
          localObject1 = (g.b)g.b.c.ajpd;
          if (s.p(localObject1, g.b.c.ajpd)) {
            break label382;
          }
          i = 1;
          if (i == 0) {
            break label387;
          }
          if (localObject1 == null) {
            break label391;
          }
          localObject3 = paramg.kAz();
          localObject2 = ((r)localObject3).o(((r)localObject3).l((k)localObject2)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label402;
          }
          localObject3 = ((g.b)localObject1).a(paramg, (i)((Iterator)localObject2).next());
          if (localr.l(localr.l((k)localObject3)))
          {
            paramg.clear();
            AppMethodBeat.o(60582);
            return true;
            localObject1 = (g.b)g.b.b.ajpc;
            break label261;
            label382:
            i = 0;
            break label274;
            localObject1 = null;
            break label278;
            break;
          }
          localArrayDeque.add(localObject3);
        }
      }
    }
    label387:
    label404:
    paramg.clear();
    AppMethodBeat.o(60582);
    return false;
  }
  
  private static boolean a(g paramg, m paramm, k paramk)
  {
    AppMethodBeat.i(60584);
    s.u(paramg, "<this>");
    s.u(paramm, "capturedSubArguments");
    s.u(paramk, "superType");
    r localr = paramg.kAz();
    o localo = localr.l(paramk);
    int i = localr.a(paramm);
    int m = localr.n(localo);
    if ((i != m) || (i != localr.a((i)paramk)))
    {
      AppMethodBeat.o(60584);
      return false;
    }
    if (m > 0) {}
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      Object localObject1 = localr.a((i)paramk, i);
      if (!localr.c((n)localObject1))
      {
        i locali1 = localr.a((n)localObject1);
        Object localObject2 = localr.a(paramm, i);
        if (localr.b((n)localObject2) == w.ajrJ) {}
        for (int j = 1; (ak.aiuY) && (j == 0); j = 0)
        {
          paramg = (Throwable)new AssertionError(s.X("Incorrect sub argument: ", localObject2));
          AppMethodBeat.o(60584);
          throw paramg;
        }
        i locali2 = localr.a((n)localObject2);
        localObject2 = localr.b(localr.a(localo, i));
        w localw = localr.b((n)localObject1);
        s.u(localObject2, "declared");
        s.u(localw, "useSite");
        if (localObject2 == w.ajrJ) {
          localObject1 = localw;
        }
        boolean bool;
        while (localObject1 == null)
        {
          bool = paramg.kAA();
          AppMethodBeat.o(60584);
          return bool;
          localObject1 = localObject2;
          if (localw != w.ajrJ)
          {
            localObject1 = localObject2;
            if (localObject2 != localw) {
              localObject1 = null;
            }
          }
        }
        if (localObject1 == w.ajrJ) {
          if ((a(localr, locali2, locali1, localo)) || (a(localr, locali1, locali2, localo))) {
            i = 1;
          }
        }
        while (i == 0) {
          if (paramg.ajoU > 100)
          {
            paramg = (Throwable)new IllegalStateException(s.X("Arguments depth is too high. Some related argument: ", locali2).toString());
            AppMethodBeat.o(60584);
            throw paramg;
            i = 0;
            continue;
            i = 0;
          }
          else
          {
            paramg.ajoU += 1;
            switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
            {
            default: 
              paramg = new kotlin.p();
              AppMethodBeat.o(60584);
              throw paramg;
            case 1: 
              bool = c(paramg, locali2, locali1);
            }
            for (;;)
            {
              paramg.ajoU -= 1;
              if (bool) {
                break;
              }
              AppMethodBeat.o(60584);
              return false;
              bool = b(paramg, locali2, locali1);
              continue;
              bool = b(paramg, locali1, locali2);
            }
          }
        }
      }
      if (k >= m)
      {
        AppMethodBeat.o(60584);
        return true;
      }
    }
  }
  
  private static Boolean b(g paramg, k paramk1, k paramk2)
  {
    AppMethodBeat.i(191605);
    r localr = paramg.kAz();
    if ((!localr.e(paramk1)) && (!localr.e(paramk2)))
    {
      AppMethodBeat.o(191605);
      return null;
    }
    if ((localr.e(paramk1)) && (localr.e(paramk2)))
    {
      paramg = Boolean.TRUE;
      AppMethodBeat.o(191605);
      return paramg;
    }
    if (localr.e(paramk1))
    {
      if (a(localr, paramg, paramk1, paramk2, false))
      {
        paramg = Boolean.TRUE;
        AppMethodBeat.o(191605);
        return paramg;
      }
    }
    else if (localr.e(paramk2))
    {
      Object localObject = localr.l(paramk1);
      if ((localObject instanceof h))
      {
        localObject = (Iterable)localr.o((o)localObject);
        if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
        {
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            k localk = localr.c((i)((Iterator)localObject).next());
            if ((localk != null) && (localr.e(localk) == true))
            {
              i = 1;
              label233:
              if (i == 0) {
                break label276;
              }
              i = 1;
              label239:
              if (i == 0) {
                break label283;
              }
            }
          }
        }
      }
      label276:
      label283:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!a(localr, paramg, paramk2, paramk1, true))) {
          break label288;
        }
        paramg = Boolean.TRUE;
        AppMethodBeat.o(191605);
        return paramg;
        i = 0;
        break label233;
        break;
        i = 0;
        break label239;
      }
    }
    label288:
    AppMethodBeat.o(191605);
    return null;
  }
  
  private static List<k> c(g paramg, k paramk, o paramo)
  {
    AppMethodBeat.i(60586);
    r localr = paramg.kAz();
    Object localObject1 = localr.a(paramk, paramo);
    if (localObject1 != null)
    {
      AppMethodBeat.o(60586);
      return localObject1;
    }
    if ((!localr.f(paramo)) && (localr.d(paramk)))
    {
      paramg = (List)ab.aivy;
      AppMethodBeat.o(60586);
      return paramg;
    }
    if (localr.g(paramo))
    {
      if (localr.a(localr.l(paramk), paramo))
      {
        paramg = localr.a(paramk, b.ajrC);
        if (paramg == null) {}
        for (;;)
        {
          paramg = kotlin.a.p.listOf(paramk);
          AppMethodBeat.o(60586);
          return paramg;
          paramk = paramg;
        }
      }
      paramg = (List)ab.aivy;
      AppMethodBeat.o(60586);
      return paramg;
    }
    List localList = (List)new kotlin.l.b.a.b.o.e();
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.ajoW;
    s.checkNotNull(localArrayDeque);
    Set localSet = paramg.ajoX;
    s.checkNotNull(localSet);
    localArrayDeque.push(paramk);
    label393:
    label525:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label527;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramk + ". Supertypes = " + kotlin.a.p.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60586);
        throw paramg;
      }
      Object localObject2 = (k)localArrayDeque.pop();
      s.s(localObject2, "current");
      if (localSet.add(localObject2))
      {
        Object localObject3 = localr.a((k)localObject2, b.ajrC);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = localObject2;
        }
        if (localr.a(localr.l((k)localObject1), paramo))
        {
          localList.add(localObject1);
          localObject1 = (g.b)g.b.c.ajpd;
          if (s.p(localObject1, g.b.c.ajpd)) {
            break label516;
          }
          i = 1;
          label406:
          if (i == 0) {
            break label521;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label525;
          }
          localObject3 = paramg.kAz();
          localObject2 = ((r)localObject3).o(((r)localObject3).l((k)localObject2)).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayDeque.add(((g.b)localObject1).a(paramg, (i)((Iterator)localObject2).next()));
          }
          break;
          if (localr.a((i)localObject1) == 0)
          {
            localObject1 = (g.b)g.b.b.ajpc;
            break label393;
          }
          localObject1 = paramg.m((k)localObject1);
          break label393;
          i = 0;
          break label406;
          localObject1 = null;
        }
      }
    }
    label516:
    label521:
    label527:
    paramg.clear();
    AppMethodBeat.o(60586);
    return localList;
  }
  
  private final kotlin.l.b.a.b.m.c.p c(r paramr, i parami1, i parami2)
  {
    AppMethodBeat.i(191621);
    int m = paramr.a(parami1);
    if (m > 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      Object localObject = paramr.a(parami1, i);
      if (!paramr.c((n)localObject))
      {
        j = 1;
        if (j == 0) {
          break label179;
        }
        label59:
        if (localObject != null) {
          break label185;
        }
        localObject = null;
        label67:
        if (localObject == null) {
          break label228;
        }
        if ((!paramr.g((i)paramr.n((i)localObject))) || (!paramr.g((i)paramr.n(parami2)))) {
          break label198;
        }
      }
      label179:
      label185:
      label198:
      for (int j = 1;; j = 0)
      {
        if ((!s.p(localObject, parami2)) && ((j == 0) || (!s.p(paramr.q((i)localObject), paramr.q(parami2))))) {
          break label204;
        }
        paramr = paramr.a(paramr.q(parami1), i);
        AppMethodBeat.o(191621);
        return paramr;
        j = 0;
        break;
        localObject = null;
        break label59;
        localObject = paramr.a((n)localObject);
        break label67;
      }
      label204:
      localObject = c(paramr, (i)localObject, parami2);
      if (localObject != null)
      {
        AppMethodBeat.o(191621);
        return localObject;
      }
      label228:
      if (k >= m)
      {
        AppMethodBeat.o(191621);
        return null;
      }
    }
  }
  
  public static boolean c(g paramg, i parami1, i parami2)
  {
    AppMethodBeat.i(60580);
    s.u(paramg, "context");
    s.u(parami1, "a");
    s.u(parami2, "b");
    r localr = paramg.kAz();
    if (parami1 == parami2)
    {
      AppMethodBeat.o(60580);
      return true;
    }
    if ((a(localr, parami1)) && (a(localr, parami2)))
    {
      i locali1 = paramg.u(paramg.t(parami1));
      i locali2 = paramg.u(paramg.t(parami2));
      k localk = localr.n(locali1);
      if (!localr.a(localr.q(locali1), localr.q(locali2)))
      {
        AppMethodBeat.o(60580);
        return false;
      }
      if (localr.a((i)localk) == 0)
      {
        if ((localr.f(locali1)) || (localr.f(locali2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        if (localr.f(localk) == localr.f(localr.n(locali2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        AppMethodBeat.o(60580);
        return false;
      }
    }
    if ((a(paramg, parami1, parami2)) && (a(paramg, parami2, parami1)))
    {
      AppMethodBeat.o(60580);
      return true;
    }
    AppMethodBeat.o(60580);
    return false;
  }
  
  private static boolean c(g paramg, k paramk1, k paramk2)
  {
    AppMethodBeat.i(60583);
    r localr = paramg.kAz();
    int i;
    if (ajoT)
    {
      if ((localr.h(paramk1)) || (localr.k(localr.l(paramk1))) || (paramg.w((i)paramk1))) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError(s.X("Not singleClassifierType and not intersection subType: ", paramk1));
        AppMethodBeat.o(60583);
        throw paramg;
      }
      if ((localr.h(paramk2)) || (paramg.w((i)paramk2))) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError(s.X("Not singleClassifierType superType: ", paramk2));
        AppMethodBeat.o(60583);
        throw paramg;
      }
    }
    Object localObject1 = c.ajoO;
    if (!c.a(paramg, paramk1, paramk2))
    {
      AppMethodBeat.o(60583);
      return false;
    }
    localObject1 = b(paramg, localr.n((i)paramk1), localr.r((i)paramk2));
    boolean bool;
    if (localObject1 != null)
    {
      bool = ((Boolean)localObject1).booleanValue();
      g.a((i)paramk1, (i)paramk2);
      AppMethodBeat.o(60583);
      return bool;
    }
    o localo = localr.l(paramk2);
    if ((localr.a(localr.l(paramk1), localo)) && (localr.n(localo) == 0))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    if (localr.e(localr.l(paramk2)))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    localObject1 = (Iterable)e(paramg, paramk1, localo);
    Object localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject1 = (k)((Iterator)localObject4).next();
      localObject2 = localr.c(paramg.u((i)localObject1));
      if (localObject2 == null) {}
      for (;;)
      {
        ((Collection)localObject3).add(localObject1);
        break;
        localObject1 = localObject2;
      }
    }
    Object localObject2 = (List)localObject3;
    int k;
    int n;
    int j;
    switch (((List)localObject2).size())
    {
    default: 
      localObject3 = new a(localr.n(localo));
      i = 0;
      k = 0;
      n = localr.n(localo);
      if (n > 0)
      {
        j = 0;
        i = k;
      }
      break;
    }
    for (;;)
    {
      int m = j + 1;
      Iterator localIterator;
      if ((i != 0) || (localr.b(localr.a(localo, j)) != w.ajrI))
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = (Iterable)localObject2;
          localObject4 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localIterator = ((Iterable)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label821;
          }
          k localk = (k)localIterator.next();
          localObject1 = localr.a(localk, j);
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 != null) {
              break label808;
            }
            paramg = (Throwable)new IllegalStateException(("Incorrect type: " + localk + ", subType: " + paramk1 + ", superType: " + paramk2).toString());
            AppMethodBeat.o(60583);
            throw paramg;
            bool = a(paramg, paramk1);
            AppMethodBeat.o(60583);
            return bool;
            bool = a(paramg, localr.a((k)kotlin.a.p.oK((List)localObject2)), paramk2);
            AppMethodBeat.o(60583);
            return bool;
            i = 0;
            break;
            if (localr.b((n)localObject1) == w.ajrJ)
            {
              k = 1;
              label766:
              if (k == 0) {
                break label788;
              }
            }
            for (;;)
            {
              if (localObject1 != null) {
                break label794;
              }
              localObject1 = null;
              break;
              k = 0;
              break label766;
              label788:
              localObject1 = null;
            }
            label794:
            localObject1 = localr.a((n)localObject1);
          }
          label808:
          ((Collection)localObject4).add(localObject1);
        }
        label821:
        ((a)localObject3).add(localr.d(localr.pd((List)localObject4)));
      }
      if (m >= n)
      {
        if ((i == 0) && (a(paramg, (m)localObject3, paramk2)))
        {
          AppMethodBeat.o(60583);
          return true;
        }
        paramk1 = (Iterable)localObject2;
        if (!((Collection)paramk1).isEmpty())
        {
          paramk1 = paramk1.iterator();
          while (paramk1.hasNext()) {
            if (a(paramg, localr.a((k)paramk1.next()), paramk2))
            {
              AppMethodBeat.o(60583);
              return true;
            }
          }
        }
        AppMethodBeat.o(60583);
        return false;
      }
      j = m;
    }
  }
  
  private static List<k> d(g paramg, k paramk, o paramo)
  {
    AppMethodBeat.i(60587);
    paramk = c(paramg, paramk, paramo);
    paramg = paramg.kAz();
    if (paramk.size() >= 2)
    {
      Object localObject1 = (Iterable)paramk;
      paramo = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label131:
      label160:
      label170:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        m localm = paramg.a((k)localObject2);
        int k = paramg.a(localm);
        i = 0;
        label98:
        int j;
        if (i < k) {
          if (paramg.b(paramg.a(paramg.a(localm, i))) == null)
          {
            j = 1;
            if (j != 0) {
              break label160;
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label170;
          }
          paramo.add(localObject2);
          break;
          j = 0;
          break label131;
          i += 1;
          break label98;
        }
      }
      paramg = (List)paramo;
      if (!((Collection)paramg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(60587);
        return paramg;
      }
    }
    AppMethodBeat.o(60587);
    return paramk;
  }
  
  private static List<k> e(g paramg, k paramk, o paramo)
  {
    AppMethodBeat.i(60588);
    s.u(paramg, "context");
    s.u(paramk, "subType");
    s.u(paramo, "superConstructor");
    Object localObject2 = paramg.kAz();
    if (((r)localObject2).d(paramk))
    {
      paramg = d(paramg, paramk, paramo);
      AppMethodBeat.o(60588);
      return paramg;
    }
    if ((!((r)localObject2).f(paramo)) && (!((r)localObject2).j(paramo)))
    {
      paramg = c(paramg, paramk, paramo);
      AppMethodBeat.o(60588);
      return paramg;
    }
    kotlin.l.b.a.b.o.e locale = new kotlin.l.b.a.b.o.e();
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.ajoW;
    s.checkNotNull(localArrayDeque);
    Set localSet = paramg.ajoX;
    s.checkNotNull(localSet);
    localArrayDeque.push(paramk);
    label391:
    label396:
    label400:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label402;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramk + ". Supertypes = " + kotlin.a.p.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60588);
        throw paramg;
      }
      Object localObject3 = (k)localArrayDeque.pop();
      s.s(localObject3, "current");
      if (localSet.add(localObject3))
      {
        if (((r)localObject2).d((k)localObject3))
        {
          locale.add(localObject3);
          localObject1 = (g.b)g.b.c.ajpd;
          label294:
          if (s.p(localObject1, g.b.c.ajpd)) {
            break label391;
          }
          i = 1;
          label307:
          if (i == 0) {
            break label396;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label400;
          }
          r localr = paramg.kAz();
          localObject3 = localr.o(localr.l((k)localObject3)).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localArrayDeque.add(((g.b)localObject1).a(paramg, (i)((Iterator)localObject3).next()));
          }
          break;
          localObject1 = (g.b)g.b.b.ajpc;
          break label294;
          i = 0;
          break label307;
          localObject1 = null;
        }
      }
    }
    label402:
    paramg.clear();
    Object localObject1 = (Iterable)locale;
    paramk = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k)((Iterator)localObject1).next();
      s.s(localObject2, "it");
      kotlin.a.p.a(paramk, (Iterable)d(paramg, (k)localObject2, paramo));
    }
    paramg = (List)paramk;
    AppMethodBeat.o(60588);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.f
 * JD-Core Version:    0.7.0.1
 */