package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.aa;
import d.l.b.a.b.m.c.a;
import d.l.b.a.b.m.c.b;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.p;
import d.l.b.a.b.m.c.s;
import d.l.b.a.b.o.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class e
{
  public static boolean LKl;
  public static final e LKm;
  
  static
  {
    AppMethodBeat.i(60589);
    LKm = new e();
    AppMethodBeat.o(60589);
  }
  
  private static Boolean a(g paramg, i parami1, i parami2)
  {
    AppMethodBeat.i(60581);
    if ((!paramg.c(parami1)) && (!paramg.c(parami2)))
    {
      AppMethodBeat.o(60581);
      return null;
    }
    a locala = new a(paramg);
    if ((paramg.c(parami1)) && (paramg.c(parami2)))
    {
      paramg = Boolean.TRUE;
      AppMethodBeat.o(60581);
      return paramg;
    }
    if (paramg.c(parami1))
    {
      if (locala.a(parami1, parami2))
      {
        paramg = Boolean.TRUE;
        AppMethodBeat.o(60581);
        return paramg;
      }
    }
    else if ((paramg.c(parami2)) && (locala.a(parami2, parami1)))
    {
      paramg = Boolean.TRUE;
      AppMethodBeat.o(60581);
      return paramg;
    }
    AppMethodBeat.o(60581);
    return null;
  }
  
  private static boolean a(g paramg, d.l.b.a.b.m.c.g paramg1)
  {
    AppMethodBeat.i(60585);
    if ((paramg.g(paramg.d(paramg1))) && (!paramg.g(paramg1)) && (!paramg.h(paramg1)) && (d.g.b.k.g(paramg.i(paramg.e(paramg1)), paramg.i(paramg.f(paramg1)))))
    {
      AppMethodBeat.o(60585);
      return true;
    }
    AppMethodBeat.o(60585);
    return false;
  }
  
  public static boolean a(g paramg, d.l.b.a.b.m.c.g paramg1, d.l.b.a.b.m.c.g paramg2)
  {
    boolean bool = false;
    AppMethodBeat.i(60579);
    d.g.b.k.h(paramg, "context");
    d.g.b.k.h(paramg1, "subType");
    d.g.b.k.h(paramg2, "superType");
    if (paramg1 == paramg2)
    {
      AppMethodBeat.o(60579);
      return true;
    }
    d.l.b.a.b.m.c.g localg = paramg.a(paramg.b(paramg1));
    paramg2 = paramg.a(paramg.b(paramg2));
    i locali = paramg.e(localg);
    Object localObject1 = paramg.f(paramg2);
    if ((paramg.n((d.l.b.a.b.m.c.g)locali)) || (paramg.n((d.l.b.a.b.m.c.g)localObject1))) {
      if (paramg.gcr()) {
        paramg1 = Boolean.TRUE;
      }
    }
    while (paramg1 != null)
    {
      bool = paramg1.booleanValue();
      g.a(localg, paramg2);
      AppMethodBeat.o(60579);
      return bool;
      if ((paramg.h(locali)) && (!paramg.h((i)localObject1)))
      {
        paramg1 = Boolean.FALSE;
      }
      else
      {
        paramg1 = Boolean.valueOf(d.LKk.a((p)paramg, (d.l.b.a.b.m.c.g)paramg.a(locali, false), (d.l.b.a.b.m.c.g)paramg.a((i)localObject1, false)));
        continue;
        if ((paramg.e(locali)) || (paramg.e((i)localObject1)))
        {
          paramg1 = Boolean.TRUE;
        }
        else
        {
          Object localObject2 = paramg.f((i)localObject1);
          if (localObject2 != null)
          {
            paramg1 = paramg.a((d.l.b.a.b.m.c.c)localObject2);
            label241:
            if ((localObject2 != null) && (paramg1 != null))
            {
              d.g.b.k.h(locali, "subType");
              d.g.b.k.h(localObject2, "superType");
              localObject2 = g.a.LKt;
            }
            switch (f.wec[localObject2.ordinal()])
            {
            default: 
              label300:
              paramg1 = paramg.i((i)localObject1);
              if (!paramg.i(paramg1)) {
                break label495;
              }
              if (paramg.h((i)localObject1)) {
                break;
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if ((!aa.KTq) || (i != 0)) {
              break label411;
            }
            paramg = (Throwable)new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(60579);
            throw paramg;
            paramg1 = null;
            break label241;
            paramg1 = Boolean.valueOf(a(paramg, (d.l.b.a.b.m.c.g)locali, paramg1));
            break;
            if (!a(paramg, (d.l.b.a.b.m.c.g)locali, paramg1)) {
              break label300;
            }
            paramg1 = Boolean.TRUE;
            break;
          }
          label411:
          paramg1 = (Iterable)paramg.k(paramg1);
          if ((!(paramg1 instanceof Collection)) || (!((Collection)paramg1).isEmpty()))
          {
            paramg1 = paramg1.iterator();
            do
            {
              if (!paramg1.hasNext()) {
                break;
              }
              localObject1 = (d.l.b.a.b.m.c.g)paramg1.next();
            } while (a(paramg, (d.l.b.a.b.m.c.g)locali, (d.l.b.a.b.m.c.g)localObject1));
          }
          for (;;)
          {
            paramg1 = Boolean.valueOf(bool);
            break;
            bool = true;
          }
          label495:
          paramg1 = null;
        }
      }
    }
    g.a(localg, paramg2);
    bool = b(paramg, paramg.e(localg), paramg.f(paramg2));
    AppMethodBeat.o(60579);
    return bool;
  }
  
  private static boolean a(g paramg, i parami)
  {
    AppMethodBeat.i(60582);
    Object localObject1 = paramg.i(parami);
    if (paramg.l((d.l.b.a.b.m.c.m)localObject1))
    {
      boolean bool = paramg.o((d.l.b.a.b.m.c.m)localObject1);
      AppMethodBeat.o(60582);
      return bool;
    }
    if (paramg.o(paramg.i(parami)))
    {
      AppMethodBeat.o(60582);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.LKq;
    if (localArrayDeque == null) {
      d.g.b.k.fOy();
    }
    Set localSet = paramg.LKr;
    if (localSet == null) {
      d.g.b.k.fOy();
    }
    localArrayDeque.push(parami);
    label336:
    label340:
    label351:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label353;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + parami + ". Supertypes = " + j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60582);
        throw paramg;
      }
      Object localObject2 = (i)localArrayDeque.pop();
      d.g.b.k.g(localObject2, "current");
      if (localSet.add(localObject2))
      {
        if (paramg.b((i)localObject2))
        {
          localObject1 = (g.c)g.c.c.LKC;
          label238:
          if (!(d.g.b.k.g(localObject1, g.c.c.LKC) ^ true)) {
            break label336;
          }
          label251:
          if (localObject1 == null) {
            break label340;
          }
          localObject2 = paramg.k(paramg.i((i)localObject2)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label351;
          }
          i locali = ((g.c)localObject1).b(paramg, (d.l.b.a.b.m.c.g)((Iterator)localObject2).next());
          if (paramg.o(paramg.i(locali)))
          {
            paramg.clear();
            AppMethodBeat.o(60582);
            return true;
            localObject1 = (g.c)g.c.b.LKB;
            break label238;
            localObject1 = null;
            break label251;
            break;
          }
          localArrayDeque.add(locali);
        }
      }
    }
    label353:
    paramg.clear();
    AppMethodBeat.o(60582);
    return false;
  }
  
  private static boolean a(g paramg, d.l.b.a.b.m.c.k paramk, i parami)
  {
    AppMethodBeat.i(60584);
    d.g.b.k.h(paramg, "$this$isSubtypeForSameConstructor");
    d.g.b.k.h(paramk, "capturedSubArguments");
    d.g.b.k.h(parami, "superType");
    d.l.b.a.b.m.c.m localm = paramg.i(parami);
    int k = paramg.j(localm);
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramg.a((d.l.b.a.b.m.c.g)parami, i);
      if (!paramg.a((d.l.b.a.b.m.c.l)localObject2))
      {
        d.l.b.a.b.m.c.g localg1 = paramg.c((d.l.b.a.b.m.c.l)localObject2);
        Object localObject1 = paramg.a(paramk, i);
        if (paramg.b((d.l.b.a.b.m.c.l)localObject1) == s.LMZ) {}
        for (int j = 1; (aa.KTq) && (j == 0); j = 0)
        {
          paramg = (Throwable)new AssertionError("Incorrect sub argument: ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(60584);
          throw paramg;
        }
        d.l.b.a.b.m.c.g localg2 = paramg.c((d.l.b.a.b.m.c.l)localObject1);
        localObject1 = paramg.b(paramg.a(localm, i));
        localObject2 = paramg.b((d.l.b.a.b.m.c.l)localObject2);
        d.g.b.k.h(localObject1, "declared");
        d.g.b.k.h(localObject2, "useSite");
        if (localObject1 == s.LMZ) {}
        label204:
        boolean bool;
        for (localObject1 = localObject2; localObject1 == null; localObject1 = null)
        {
          bool = paramg.gcr();
          AppMethodBeat.o(60584);
          return bool;
          if ((localObject2 == s.LMZ) || (localObject1 == localObject2)) {
            break label204;
          }
        }
        if (paramg.LKo > 100)
        {
          paramg = (Throwable)new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(localg2)).toString());
          AppMethodBeat.o(60584);
          throw paramg;
        }
        paramg.LKo += 1;
        switch (f.fTL[localObject1.ordinal()])
        {
        default: 
          paramg = new d.m();
          AppMethodBeat.o(60584);
          throw paramg;
        case 1: 
          bool = b(paramg, localg2, localg1);
        }
        for (;;)
        {
          paramg.LKo -= 1;
          if (bool) {
            break;
          }
          AppMethodBeat.o(60584);
          return false;
          bool = a(paramg, localg2, localg1);
          continue;
          bool = a(paramg, localg1, localg2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(60584);
    return true;
  }
  
  private static List<i> b(g paramg, i parami, d.l.b.a.b.m.c.m paramm)
  {
    AppMethodBeat.i(60586);
    Object localObject1 = paramg.a(parami, paramm);
    if (localObject1 != null)
    {
      AppMethodBeat.o(60586);
      return localObject1;
    }
    if ((!paramg.l(paramm)) && (paramg.b(parami)))
    {
      paramg = (List)v.KTF;
      AppMethodBeat.o(60586);
      return paramg;
    }
    if (paramg.m(paramm)) {
      if (paramg.a(paramg.i(parami), paramm))
      {
        paramg = paramg.a(parami, b.LMT);
        if (paramg != null) {
          break label480;
        }
      }
    }
    for (;;)
    {
      paramg = j.listOf(parami);
      AppMethodBeat.o(60586);
      return paramg;
      paramg = (List)v.KTF;
      AppMethodBeat.o(60586);
      return paramg;
      List localList = (List)new h();
      paramg.initialize();
      ArrayDeque localArrayDeque = paramg.LKq;
      if (localArrayDeque == null) {
        d.g.b.k.fOy();
      }
      Set localSet = paramg.LKr;
      if (localSet == null) {
        d.g.b.k.fOy();
      }
      localArrayDeque.push(parami);
      label461:
      label465:
      for (;;)
      {
        if (!((Collection)localArrayDeque).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label467;
          }
          if (localSet.size() <= 1000) {
            break;
          }
          paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + parami + ". Supertypes = " + j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
          AppMethodBeat.o(60586);
          throw paramg;
        }
        Object localObject2 = (i)localArrayDeque.pop();
        d.g.b.k.g(localObject2, "current");
        if (localSet.add(localObject2))
        {
          i locali = paramg.a((i)localObject2, b.LMT);
          localObject1 = locali;
          if (locali == null) {
            localObject1 = localObject2;
          }
          if (paramg.a(paramg.i((i)localObject1), paramm))
          {
            localList.add(localObject1);
            localObject1 = (g.c)g.c.c.LKC;
            label357:
            if (!(d.g.b.k.g(localObject1, g.c.c.LKC) ^ true)) {
              break label461;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label465;
            }
            localObject2 = paramg.k(paramg.i((i)localObject2)).iterator();
            while (((Iterator)localObject2).hasNext()) {
              localArrayDeque.add(((g.c)localObject1).b(paramg, (d.l.b.a.b.m.c.g)((Iterator)localObject2).next()));
            }
            break;
            if (paramg.q((d.l.b.a.b.m.c.g)localObject1) == 0)
            {
              localObject1 = (g.c)g.c.b.LKB;
              break label357;
            }
            localObject1 = paramg.a((i)localObject1);
            break label357;
            localObject1 = null;
          }
        }
      }
      label467:
      paramg.clear();
      AppMethodBeat.o(60586);
      return localList;
      label480:
      parami = paramg;
    }
  }
  
  public static boolean b(g paramg, d.l.b.a.b.m.c.g paramg1, d.l.b.a.b.m.c.g paramg2)
  {
    AppMethodBeat.i(60580);
    d.g.b.k.h(paramg, "context");
    d.g.b.k.h(paramg1, "a");
    d.g.b.k.h(paramg2, "b");
    if (paramg1 == paramg2)
    {
      AppMethodBeat.o(60580);
      return true;
    }
    if ((a(paramg, paramg1)) && (a(paramg, paramg2)))
    {
      d.l.b.a.b.m.c.g localg1 = paramg.b(paramg1);
      d.l.b.a.b.m.c.g localg2 = paramg.b(paramg2);
      i locali = paramg.e(localg1);
      if (!paramg.a(paramg.d(localg1), paramg.d(localg2)))
      {
        AppMethodBeat.o(60580);
        return false;
      }
      if (paramg.q((d.l.b.a.b.m.c.g)locali) == 0)
      {
        if ((paramg.i(localg1)) || (paramg.i(localg2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        if (paramg.h(locali) == paramg.h(paramg.e(localg2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        AppMethodBeat.o(60580);
        return false;
      }
    }
    if ((a(paramg, paramg1, paramg2)) && (a(paramg, paramg2, paramg1)))
    {
      AppMethodBeat.o(60580);
      return true;
    }
    AppMethodBeat.o(60580);
    return false;
  }
  
  private static boolean b(g paramg, i parami1, i parami2)
  {
    AppMethodBeat.i(60583);
    int i;
    if (LKl)
    {
      if ((paramg.k(parami1)) || (paramg.i(paramg.i(parami1))) || (paramg.c((d.l.b.a.b.m.c.g)parami1))) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(parami1)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
      if ((paramg.k(parami2)) || (paramg.c((d.l.b.a.b.m.c.g)parami2))) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(parami2)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
    }
    Object localObject1 = c.LKj;
    d.g.b.k.h(paramg, "context");
    d.g.b.k.h(parami1, "subType");
    d.g.b.k.h(parami2, "superType");
    if (LKl)
    {
      if ((paramg.k(parami1)) || (paramg.i(paramg.i(parami1))) || (paramg.c((d.l.b.a.b.m.c.g)parami1))) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(parami1)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
      if ((paramg.k(parami2)) || (paramg.c((d.l.b.a.b.m.c.g)parami2))) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(parami2)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
    }
    if (paramg.h(parami2)) {
      bool = true;
    }
    while (!bool)
    {
      AppMethodBeat.o(60583);
      return false;
      if (paramg.h((d.l.b.a.b.m.c.g)parami1)) {
        bool = true;
      } else if (c.a(paramg, parami1, (g.c)g.c.b.LKB)) {
        bool = true;
      } else if (paramg.h((d.l.b.a.b.m.c.g)parami2)) {
        bool = false;
      } else if (c.a(paramg, parami2, (g.c)g.c.d.LKD)) {
        bool = false;
      } else if (paramg.b(parami1)) {
        bool = false;
      } else {
        bool = c.a(paramg, parami1, paramg.i(parami2));
      }
    }
    localObject1 = a(paramg, paramg.e((d.l.b.a.b.m.c.g)parami1), paramg.f((d.l.b.a.b.m.c.g)parami2));
    if (localObject1 != null)
    {
      bool = ((Boolean)localObject1).booleanValue();
      g.a((d.l.b.a.b.m.c.g)parami1, (d.l.b.a.b.m.c.g)parami2);
      AppMethodBeat.o(60583);
      return bool;
    }
    localObject1 = paramg.i(parami2);
    if ((paramg.b(paramg.i(parami1), (d.l.b.a.b.m.c.m)localObject1)) && (paramg.j((d.l.b.a.b.m.c.m)localObject1) == 0))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    if (paramg.n(paramg.i(parami2)))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    List localList = d(paramg, parami1, (d.l.b.a.b.m.c.m)localObject1);
    Object localObject2;
    int k;
    switch (localList.size())
    {
    default: 
      localObject2 = g.b.LKz;
      switch (f.cfA[localObject2.ordinal()])
      {
      default: 
        localObject2 = g.b.LKz;
        localObject2 = new a(paramg.j((d.l.b.a.b.m.c.m)localObject1));
        k = paramg.j((d.l.b.a.b.m.c.m)localObject1);
        i = 0;
      }
      break;
    }
    for (;;)
    {
      if (i >= k) {
        break label1072;
      }
      localObject1 = (Iterable)localList;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1046;
        }
        i locali = (i)localIterator.next();
        localObject1 = paramg.a(locali, i);
        int j;
        if (localObject1 != null)
        {
          if (paramg.b((d.l.b.a.b.m.c.l)localObject1) != s.LMZ) {
            break label1021;
          }
          j = 1;
          label770:
          if (j == 0) {
            break label1027;
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject1 = paramg.c((d.l.b.a.b.m.c.l)localObject1);
            if (localObject1 != null) {
              break label1033;
            }
          }
          paramg = (Throwable)new IllegalStateException(("Incorrect type: " + locali + ", subType: " + parami1 + ", superType: " + parami2).toString());
          AppMethodBeat.o(60583);
          throw paramg;
          bool = a(paramg, parami1);
          AppMethodBeat.o(60583);
          return bool;
          bool = a(paramg, paramg.j((i)j.iO(localList)), parami2);
          AppMethodBeat.o(60583);
          return bool;
          AppMethodBeat.o(60583);
          return false;
          bool = a(paramg, paramg.j((i)j.iO(localList)), parami2);
          AppMethodBeat.o(60583);
          return bool;
          localObject2 = (Iterable)localList;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (!a(paramg, paramg.j((i)((Iterator)localObject2).next()), parami2));
          }
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(60583);
            return true;
          }
          break;
          label1021:
          j = 0;
          break label770;
          label1027:
          localObject1 = null;
        }
        label1033:
        localCollection.add(localObject1);
      }
      label1046:
      ((a)localObject2).add(paramg.r(paramg.jg((List)localCollection)));
      i += 1;
    }
    label1072:
    boolean bool = a(paramg, (d.l.b.a.b.m.c.k)localObject2, parami2);
    AppMethodBeat.o(60583);
    return bool;
  }
  
  private static List<i> c(g paramg, i parami, d.l.b.a.b.m.c.m paramm)
  {
    AppMethodBeat.i(60587);
    parami = b(paramg, parami, paramm);
    if (parami.size() >= 2)
    {
      Object localObject1 = (Iterable)parami;
      paramm = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label128:
      label157:
      label167:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        d.l.b.a.b.m.c.k localk = paramg.j((i)localObject2);
        p localp = (p)paramg;
        int k = localp.a(localk);
        i = 0;
        label98:
        int j;
        if (i < k) {
          if (paramg.p(paramg.c(localp.a(localk, i))) == null)
          {
            j = 1;
            if (j != 0) {
              break label157;
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label167;
          }
          paramm.add(localObject2);
          break;
          j = 0;
          break label128;
          i += 1;
          break label98;
        }
      }
      paramg = (List)paramm;
      if (!((Collection)paramg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(60587);
        return paramg;
      }
    }
    AppMethodBeat.o(60587);
    return parami;
  }
  
  private static List<i> d(g paramg, i parami, d.l.b.a.b.m.c.m paramm)
  {
    AppMethodBeat.i(60588);
    d.g.b.k.h(paramg, "$this$findCorrespondingSupertypes");
    d.g.b.k.h(parami, "subType");
    d.g.b.k.h(paramm, "superConstructor");
    if (paramg.b(parami))
    {
      paramg = c(paramg, parami, paramm);
      AppMethodBeat.o(60588);
      return paramg;
    }
    if ((!paramg.l(paramm)) && (!paramg.h(paramm)))
    {
      paramg = b(paramg, parami, paramm);
      AppMethodBeat.o(60588);
      return paramg;
    }
    Object localObject2 = new h();
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.LKq;
    if (localArrayDeque == null) {
      d.g.b.k.fOy();
    }
    Set localSet = paramg.LKr;
    if (localSet == null) {
      d.g.b.k.fOy();
    }
    localArrayDeque.push(parami);
    label282:
    label363:
    label367:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label369;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + parami + ". Supertypes = " + j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60588);
        throw paramg;
      }
      Object localObject3 = (i)localArrayDeque.pop();
      d.g.b.k.g(localObject3, "current");
      if (localSet.add(localObject3))
      {
        if (paramg.b((i)localObject3))
        {
          ((h)localObject2).add(localObject3);
          localObject1 = (g.c)g.c.c.LKC;
          if (!(d.g.b.k.g(localObject1, g.c.c.LKC) ^ true)) {
            break label363;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label367;
          }
          localObject3 = paramg.k(paramg.i((i)localObject3)).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localArrayDeque.add(((g.c)localObject1).b(paramg, (d.l.b.a.b.m.c.g)((Iterator)localObject3).next()));
          }
          break;
          localObject1 = (g.c)g.c.b.LKB;
          break label282;
          localObject1 = null;
        }
      }
    }
    label369:
    paramg.clear();
    Object localObject1 = (Iterable)localObject2;
    parami = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      d.g.b.k.g(localObject2, "it");
      j.a(parami, (Iterable)c(paramg, (i)localObject2, paramm));
    }
    paramg = (List)parami;
    AppMethodBeat.o(60588);
    return paramg;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.m<i, i, Boolean>
  {
    a(g paramg)
    {
      super();
    }
    
    public final boolean a(i parami1, i parami2)
    {
      AppMethodBeat.i(60578);
      d.g.b.k.h(parami1, "integerLiteralType");
      d.g.b.k.h(parami2, "type");
      parami1 = (Iterable)this.LKn.d(parami1);
      if ((!(parami1 instanceof Collection)) || (!((Collection)parami1).isEmpty()))
      {
        parami1 = parami1.iterator();
        while (parami1.hasNext())
        {
          d.l.b.a.b.m.c.g localg = (d.l.b.a.b.m.c.g)parami1.next();
          if (d.g.b.k.g(this.LKn.d(localg), this.LKn.i(parami2)))
          {
            AppMethodBeat.o(60578);
            return true;
          }
        }
      }
      AppMethodBeat.o(60578);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.e
 * JD-Core Version:    0.7.0.1
 */