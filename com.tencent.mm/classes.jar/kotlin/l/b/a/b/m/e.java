package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.a;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.t;

public final class e
{
  public static boolean TNk;
  public static final e TNl;
  
  static
  {
    AppMethodBeat.i(60589);
    TNl = new e();
    AppMethodBeat.o(60589);
  }
  
  private static Boolean a(g paramg, kotlin.l.b.a.b.m.c.j paramj1, kotlin.l.b.a.b.m.c.j paramj2)
  {
    AppMethodBeat.i(60581);
    if ((!paramg.c(paramj1)) && (!paramg.c(paramj2)))
    {
      AppMethodBeat.o(60581);
      return null;
    }
    a locala = new a(paramg);
    if ((paramg.c(paramj1)) && (paramg.c(paramj2)))
    {
      paramg = Boolean.TRUE;
      AppMethodBeat.o(60581);
      return paramg;
    }
    if (paramg.c(paramj1))
    {
      if (locala.a(paramj1, paramj2, false))
      {
        paramg = Boolean.TRUE;
        AppMethodBeat.o(60581);
        return paramg;
      }
    }
    else if ((paramg.c(paramj2)) && (locala.a(paramj2, paramj1, true)))
    {
      paramg = Boolean.TRUE;
      AppMethodBeat.o(60581);
      return paramg;
    }
    AppMethodBeat.o(60581);
    return null;
  }
  
  private static boolean a(g paramg, kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60585);
    if ((paramg.g(paramg.d(paramh))) && (!paramg.g(paramh)) && (!paramg.h(paramh)) && (p.j(paramg.i(paramg.e(paramh)), paramg.i(paramg.f(paramh)))))
    {
      AppMethodBeat.o(60585);
      return true;
    }
    AppMethodBeat.o(60585);
    return false;
  }
  
  public static boolean a(g paramg, kotlin.l.b.a.b.m.c.h paramh1, kotlin.l.b.a.b.m.c.h paramh2)
  {
    boolean bool = false;
    AppMethodBeat.i(60579);
    p.h(paramg, "context");
    p.h(paramh1, "subType");
    p.h(paramh2, "superType");
    if (paramh1 == paramh2)
    {
      AppMethodBeat.o(60579);
      return true;
    }
    e locale = TNl;
    kotlin.l.b.a.b.m.c.h localh = paramg.a(paramg.b(paramh1));
    paramh2 = paramg.a(paramg.b(paramh2));
    kotlin.l.b.a.b.m.c.j localj = paramg.e(localh);
    Object localObject1 = paramg.f(paramh2);
    if ((paramg.n((kotlin.l.b.a.b.m.c.h)localj)) || (paramg.n((kotlin.l.b.a.b.m.c.h)localObject1))) {
      if (paramg.hLv()) {
        paramh1 = Boolean.TRUE;
      }
    }
    while (paramh1 != null)
    {
      bool = paramh1.booleanValue();
      g.a(localh, paramh2);
      AppMethodBeat.o(60579);
      return bool;
      if ((paramg.h(localj)) && (!paramg.h((kotlin.l.b.a.b.m.c.j)localObject1)))
      {
        paramh1 = Boolean.FALSE;
      }
      else
      {
        paramh1 = Boolean.valueOf(d.TNj.a((kotlin.l.b.a.b.m.c.q)paramg, (kotlin.l.b.a.b.m.c.h)paramg.a(localj, false), (kotlin.l.b.a.b.m.c.h)paramg.a((kotlin.l.b.a.b.m.c.j)localObject1, false)));
        continue;
        if ((paramg.e(localj)) || (paramg.e((kotlin.l.b.a.b.m.c.j)localObject1)))
        {
          paramh1 = Boolean.valueOf(paramg.hLw());
        }
        else
        {
          Object localObject2 = paramg.f((kotlin.l.b.a.b.m.c.j)localObject1);
          if (localObject2 != null)
          {
            paramh1 = paramg.a((kotlin.l.b.a.b.m.c.d)localObject2);
            label250:
            if ((localObject2 != null) && (paramh1 != null))
            {
              p.h(localj, "subType");
              p.h(localObject2, "superType");
              localObject2 = g.a.TNs;
            }
            switch (f.haE[localObject2.ordinal()])
            {
            default: 
              label308:
              paramh1 = paramg.i((kotlin.l.b.a.b.m.c.j)localObject1);
              if (!paramg.i(paramh1)) {
                break label503;
              }
              if (paramg.h((kotlin.l.b.a.b.m.c.j)localObject1)) {
                break;
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if ((!aa.SXc) || (i != 0)) {
              break label419;
            }
            paramg = (Throwable)new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(60579);
            throw paramg;
            paramh1 = null;
            break label250;
            paramh1 = Boolean.valueOf(a(paramg, (kotlin.l.b.a.b.m.c.h)localj, paramh1));
            break;
            if (!a(paramg, (kotlin.l.b.a.b.m.c.h)localj, paramh1)) {
              break label308;
            }
            paramh1 = Boolean.TRUE;
            break;
          }
          label419:
          paramh1 = (Iterable)paramg.k(paramh1);
          if ((!(paramh1 instanceof Collection)) || (!((Collection)paramh1).isEmpty()))
          {
            paramh1 = paramh1.iterator();
            do
            {
              if (!paramh1.hasNext()) {
                break;
              }
              localObject1 = (kotlin.l.b.a.b.m.c.h)paramh1.next();
            } while (a(paramg, (kotlin.l.b.a.b.m.c.h)localj, (kotlin.l.b.a.b.m.c.h)localObject1));
          }
          for (;;)
          {
            paramh1 = Boolean.valueOf(bool);
            break;
            bool = true;
          }
          label503:
          paramh1 = null;
        }
      }
    }
    g.a(localh, paramh2);
    bool = locale.b(paramg, paramg.e(localh), paramg.f(paramh2));
    AppMethodBeat.o(60579);
    return bool;
  }
  
  private static boolean a(g paramg, kotlin.l.b.a.b.m.c.j paramj)
  {
    AppMethodBeat.i(60582);
    Object localObject1 = paramg.i(paramj);
    if (paramg.l((n)localObject1))
    {
      boolean bool = paramg.o((n)localObject1);
      AppMethodBeat.o(60582);
      return bool;
    }
    if (paramg.o(paramg.i(paramj)))
    {
      AppMethodBeat.o(60582);
      return true;
    }
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.TNp;
    if (localArrayDeque == null) {
      p.hyc();
    }
    Set localSet = paramg.TNq;
    if (localSet == null) {
      p.hyc();
    }
    localArrayDeque.push(paramj);
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
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + kotlin.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60582);
        throw paramg;
      }
      Object localObject2 = (kotlin.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.g(localObject2, "current");
      if (localSet.add(localObject2))
      {
        if (paramg.b((kotlin.l.b.a.b.m.c.j)localObject2))
        {
          localObject1 = (g.b)g.b.c.TNw;
          label238:
          if (!(p.j(localObject1, g.b.c.TNw) ^ true)) {
            break label336;
          }
          label251:
          if (localObject1 == null) {
            break label340;
          }
          localObject2 = paramg.k(paramg.i((kotlin.l.b.a.b.m.c.j)localObject2)).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label351;
          }
          kotlin.l.b.a.b.m.c.j localj = ((g.b)localObject1).b(paramg, (kotlin.l.b.a.b.m.c.h)((Iterator)localObject2).next());
          if (paramg.o(paramg.i(localj)))
          {
            paramg.clear();
            AppMethodBeat.o(60582);
            return true;
            localObject1 = (g.b)g.b.b.TNv;
            break label238;
            localObject1 = null;
            break label251;
            break;
          }
          localArrayDeque.add(localj);
        }
      }
    }
    label353:
    paramg.clear();
    AppMethodBeat.o(60582);
    return false;
  }
  
  private static boolean a(g paramg, l paraml, kotlin.l.b.a.b.m.c.j paramj)
  {
    AppMethodBeat.i(60584);
    p.h(paramg, "$this$isSubtypeForSameConstructor");
    p.h(paraml, "capturedSubArguments");
    p.h(paramj, "superType");
    n localn = paramg.i(paramj);
    int k = paramg.j(localn);
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramg.a((kotlin.l.b.a.b.m.c.h)paramj, i);
      if (!paramg.a((kotlin.l.b.a.b.m.c.m)localObject2))
      {
        kotlin.l.b.a.b.m.c.h localh1 = paramg.c((kotlin.l.b.a.b.m.c.m)localObject2);
        Object localObject1 = paramg.a(paraml, i);
        if (paramg.b((kotlin.l.b.a.b.m.c.m)localObject1) == t.TPV) {}
        for (int j = 1; (aa.SXc) && (j == 0); j = 0)
        {
          paramg = (Throwable)new AssertionError("Incorrect sub argument: ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(60584);
          throw paramg;
        }
        kotlin.l.b.a.b.m.c.h localh2 = paramg.c((kotlin.l.b.a.b.m.c.m)localObject1);
        localObject1 = paramg.b(paramg.a(localn, i));
        localObject2 = paramg.b((kotlin.l.b.a.b.m.c.m)localObject2);
        p.h(localObject1, "declared");
        p.h(localObject2, "useSite");
        if (localObject1 == t.TPV) {}
        label204:
        boolean bool;
        for (localObject1 = localObject2; localObject1 == null; localObject1 = null)
        {
          bool = paramg.hLv();
          AppMethodBeat.o(60584);
          return bool;
          if ((localObject2 == t.TPV) || (localObject1 == localObject2)) {
            break label204;
          }
        }
        if (paramg.TNn > 100)
        {
          paramg = (Throwable)new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(localh2)).toString());
          AppMethodBeat.o(60584);
          throw paramg;
        }
        paramg.TNn += 1;
        switch (f.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          paramg = new kotlin.m();
          AppMethodBeat.o(60584);
          throw paramg;
        case 1: 
          bool = b(paramg, localh2, localh1);
        }
        for (;;)
        {
          paramg.TNn -= 1;
          if (bool) {
            break;
          }
          AppMethodBeat.o(60584);
          return false;
          bool = a(paramg, localh2, localh1);
          continue;
          bool = a(paramg, localh1, localh2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(60584);
    return true;
  }
  
  public static boolean b(g paramg, kotlin.l.b.a.b.m.c.h paramh1, kotlin.l.b.a.b.m.c.h paramh2)
  {
    AppMethodBeat.i(60580);
    p.h(paramg, "context");
    p.h(paramh1, "a");
    p.h(paramh2, "b");
    if (paramh1 == paramh2)
    {
      AppMethodBeat.o(60580);
      return true;
    }
    if ((a(paramg, paramh1)) && (a(paramg, paramh2)))
    {
      kotlin.l.b.a.b.m.c.h localh1 = paramg.b(paramh1);
      kotlin.l.b.a.b.m.c.h localh2 = paramg.b(paramh2);
      kotlin.l.b.a.b.m.c.j localj = paramg.e(localh1);
      if (!paramg.a(paramg.d(localh1), paramg.d(localh2)))
      {
        AppMethodBeat.o(60580);
        return false;
      }
      if (paramg.q((kotlin.l.b.a.b.m.c.h)localj) == 0)
      {
        if ((paramg.i(localh1)) || (paramg.i(localh2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        if (paramg.h(localj) == paramg.h(paramg.e(localh2)))
        {
          AppMethodBeat.o(60580);
          return true;
        }
        AppMethodBeat.o(60580);
        return false;
      }
    }
    if ((a(paramg, paramh1, paramh2)) && (a(paramg, paramh2, paramh1)))
    {
      AppMethodBeat.o(60580);
      return true;
    }
    AppMethodBeat.o(60580);
    return false;
  }
  
  private final boolean b(g paramg, kotlin.l.b.a.b.m.c.j paramj1, kotlin.l.b.a.b.m.c.j paramj2)
  {
    AppMethodBeat.i(60583);
    int i;
    if (TNk)
    {
      if ((paramg.k(paramj1)) || (paramg.i(paramg.i(paramj1))) || (paramg.c((kotlin.l.b.a.b.m.c.h)paramj1))) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(paramj1)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
      if ((paramg.k(paramj2)) || (paramg.c((kotlin.l.b.a.b.m.c.h)paramj2))) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(paramj2)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
    }
    Object localObject = c.TNi;
    p.h(paramg, "context");
    p.h(paramj1, "subType");
    p.h(paramj2, "superType");
    if (TNk)
    {
      if ((paramg.k(paramj1)) || (paramg.i(paramg.i(paramj1))) || (paramg.c((kotlin.l.b.a.b.m.c.h)paramj1))) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(paramj1)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
      if ((paramg.k(paramj2)) || (paramg.c((kotlin.l.b.a.b.m.c.h)paramj2))) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramg = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(paramj2)));
        AppMethodBeat.o(60583);
        throw paramg;
      }
    }
    boolean bool;
    if (paramg.h(paramj2)) {
      bool = true;
    }
    while (!bool)
    {
      AppMethodBeat.o(60583);
      return false;
      if (paramg.h((kotlin.l.b.a.b.m.c.h)paramj1)) {
        bool = true;
      } else if (c.a(paramg, paramj1, (g.b)g.b.b.TNv)) {
        bool = true;
      } else if (paramg.h((kotlin.l.b.a.b.m.c.h)paramj2)) {
        bool = false;
      } else if (c.a(paramg, paramj2, (g.b)g.b.d.TNx)) {
        bool = false;
      } else if (paramg.b(paramj1)) {
        bool = false;
      } else {
        bool = c.a(paramg, paramj1, paramg.i(paramj2));
      }
    }
    localObject = a(paramg, paramg.e((kotlin.l.b.a.b.m.c.h)paramj1), paramg.f((kotlin.l.b.a.b.m.c.h)paramj2));
    if (localObject != null)
    {
      bool = ((Boolean)localObject).booleanValue();
      g.a((kotlin.l.b.a.b.m.c.h)paramj1, (kotlin.l.b.a.b.m.c.h)paramj2);
      AppMethodBeat.o(60583);
      return bool;
    }
    n localn = paramg.i(paramj2);
    if ((paramg.b(paramg.i(paramj1), localn)) && (paramg.j(localn) == 0))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    if (paramg.n(paramg.i(paramj2)))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    List localList = e(paramg, paramj1, localn);
    a locala;
    int m;
    int j;
    switch (localList.size())
    {
    default: 
      locala = new a(paramg.j(localn));
      i = 0;
      m = paramg.j(localn);
      j = 0;
    }
    while (j < m)
    {
      Collection localCollection;
      Iterator localIterator;
      if ((i != 0) || (paramg.b(paramg.a(localn, j)) != t.TPU))
      {
        i = 1;
        if (i == 0)
        {
          localObject = (Iterable)localList;
          localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
          localIterator = ((Iterable)localObject).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label928;
          }
          kotlin.l.b.a.b.m.c.j localj = (kotlin.l.b.a.b.m.c.j)localIterator.next();
          localObject = paramg.a(localj, j);
          int k;
          if (localObject != null)
          {
            if (paramg.b((kotlin.l.b.a.b.m.c.m)localObject) != t.TPV) {
              break label903;
            }
            k = 1;
            label770:
            if (k == 0) {
              break label909;
            }
          }
          for (;;)
          {
            if (localObject != null)
            {
              localObject = paramg.c((kotlin.l.b.a.b.m.c.m)localObject);
              if (localObject != null) {
                break label915;
              }
            }
            paramg = (Throwable)new IllegalStateException(("Incorrect type: " + localj + ", subType: " + paramj1 + ", superType: " + paramj2).toString());
            AppMethodBeat.o(60583);
            throw paramg;
            bool = a(paramg, paramj1);
            AppMethodBeat.o(60583);
            return bool;
            bool = a(paramg, paramg.j((kotlin.l.b.a.b.m.c.j)kotlin.a.j.ks(localList)), paramj2);
            AppMethodBeat.o(60583);
            return bool;
            i = 0;
            break;
            label903:
            k = 0;
            break label770;
            label909:
            localObject = null;
          }
          label915:
          localCollection.add(localObject);
        }
        label928:
        locala.add(paramg.r(paramg.kJ((List)localCollection)));
      }
      j += 1;
    }
    if ((i == 0) && (a(paramg, (l)locala, paramj2)))
    {
      AppMethodBeat.o(60583);
      return true;
    }
    paramj1 = (Iterable)localList;
    if ((!(paramj1 instanceof Collection)) || (!((Collection)paramj1).isEmpty()))
    {
      paramj1 = paramj1.iterator();
      while (paramj1.hasNext()) {
        if (a(paramg, paramg.j((kotlin.l.b.a.b.m.c.j)paramj1.next()), paramj2))
        {
          AppMethodBeat.o(60583);
          return true;
        }
      }
    }
    AppMethodBeat.o(60583);
    return false;
  }
  
  private static List<kotlin.l.b.a.b.m.c.j> c(g paramg, kotlin.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(60586);
    Object localObject1 = paramg.a(paramj, paramn);
    if (localObject1 != null)
    {
      AppMethodBeat.o(60586);
      return localObject1;
    }
    if ((!paramg.l(paramn)) && (paramg.b(paramj)))
    {
      paramg = (List)v.SXr;
      AppMethodBeat.o(60586);
      return paramg;
    }
    if (paramg.m(paramn)) {
      if (paramg.a(paramg.i(paramj), paramn))
      {
        paramg = paramg.a(paramj, b.TPP);
        if (paramg != null) {
          break label480;
        }
      }
    }
    for (;;)
    {
      paramg = kotlin.a.j.listOf(paramj);
      AppMethodBeat.o(60586);
      return paramg;
      paramg = (List)v.SXr;
      AppMethodBeat.o(60586);
      return paramg;
      List localList = (List)new kotlin.l.b.a.b.o.h();
      paramg.initialize();
      ArrayDeque localArrayDeque = paramg.TNp;
      if (localArrayDeque == null) {
        p.hyc();
      }
      Set localSet = paramg.TNq;
      if (localSet == null) {
        p.hyc();
      }
      localArrayDeque.push(paramj);
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
          paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + kotlin.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
          AppMethodBeat.o(60586);
          throw paramg;
        }
        Object localObject2 = (kotlin.l.b.a.b.m.c.j)localArrayDeque.pop();
        p.g(localObject2, "current");
        if (localSet.add(localObject2))
        {
          kotlin.l.b.a.b.m.c.j localj = paramg.a((kotlin.l.b.a.b.m.c.j)localObject2, b.TPP);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = localObject2;
          }
          if (paramg.a(paramg.i((kotlin.l.b.a.b.m.c.j)localObject1), paramn))
          {
            localList.add(localObject1);
            localObject1 = (g.b)g.b.c.TNw;
            label357:
            if (!(p.j(localObject1, g.b.c.TNw) ^ true)) {
              break label461;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label465;
            }
            localObject2 = paramg.k(paramg.i((kotlin.l.b.a.b.m.c.j)localObject2)).iterator();
            while (((Iterator)localObject2).hasNext()) {
              localArrayDeque.add(((g.b)localObject1).b(paramg, (kotlin.l.b.a.b.m.c.h)((Iterator)localObject2).next()));
            }
            break;
            if (paramg.q((kotlin.l.b.a.b.m.c.h)localObject1) == 0)
            {
              localObject1 = (g.b)g.b.b.TNv;
              break label357;
            }
            localObject1 = paramg.a((kotlin.l.b.a.b.m.c.j)localObject1);
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
      paramj = paramg;
    }
  }
  
  private static List<kotlin.l.b.a.b.m.c.j> d(g paramg, kotlin.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(60587);
    paramj = c(paramg, paramj, paramn);
    if (paramj.size() >= 2)
    {
      Object localObject1 = (Iterable)paramj;
      paramn = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label128:
      label157:
      label167:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        l locall = paramg.j((kotlin.l.b.a.b.m.c.j)localObject2);
        kotlin.l.b.a.b.m.c.q localq = (kotlin.l.b.a.b.m.c.q)paramg;
        int k = localq.a(locall);
        i = 0;
        label98:
        int j;
        if (i < k) {
          if (paramg.p(paramg.c(localq.a(locall, i))) == null)
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
          paramn.add(localObject2);
          break;
          j = 0;
          break label128;
          i += 1;
          break label98;
        }
      }
      paramg = (List)paramn;
      if (!((Collection)paramg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(60587);
        return paramg;
      }
    }
    AppMethodBeat.o(60587);
    return paramj;
  }
  
  private static List<kotlin.l.b.a.b.m.c.j> e(g paramg, kotlin.l.b.a.b.m.c.j paramj, n paramn)
  {
    AppMethodBeat.i(60588);
    p.h(paramg, "$this$findCorrespondingSupertypes");
    p.h(paramj, "subType");
    p.h(paramn, "superConstructor");
    if (paramg.b(paramj))
    {
      paramg = d(paramg, paramj, paramn);
      AppMethodBeat.o(60588);
      return paramg;
    }
    if ((!paramg.l(paramn)) && (!paramg.h(paramn)))
    {
      paramg = c(paramg, paramj, paramn);
      AppMethodBeat.o(60588);
      return paramg;
    }
    Object localObject2 = new kotlin.l.b.a.b.o.h();
    paramg.initialize();
    ArrayDeque localArrayDeque = paramg.TNp;
    if (localArrayDeque == null) {
      p.hyc();
    }
    Set localSet = paramg.TNq;
    if (localSet == null) {
      p.hyc();
    }
    localArrayDeque.push(paramj);
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
        paramg = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramj + ". Supertypes = " + kotlin.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(60588);
        throw paramg;
      }
      Object localObject3 = (kotlin.l.b.a.b.m.c.j)localArrayDeque.pop();
      p.g(localObject3, "current");
      if (localSet.add(localObject3))
      {
        if (paramg.b((kotlin.l.b.a.b.m.c.j)localObject3))
        {
          ((kotlin.l.b.a.b.o.h)localObject2).add(localObject3);
          localObject1 = (g.b)g.b.c.TNw;
          if (!(p.j(localObject1, g.b.c.TNw) ^ true)) {
            break label363;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label367;
          }
          localObject3 = paramg.k(paramg.i((kotlin.l.b.a.b.m.c.j)localObject3)).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localArrayDeque.add(((g.b)localObject1).b(paramg, (kotlin.l.b.a.b.m.c.h)((Iterator)localObject3).next()));
          }
          break;
          localObject1 = (g.b)g.b.b.TNv;
          break label282;
          localObject1 = null;
        }
      }
    }
    label369:
    paramg.clear();
    Object localObject1 = (Iterable)localObject2;
    paramj = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (kotlin.l.b.a.b.m.c.j)((Iterator)localObject1).next();
      p.g(localObject2, "it");
      kotlin.a.j.a(paramj, (Iterable)d(paramg, (kotlin.l.b.a.b.m.c.j)localObject2, paramn));
    }
    paramg = (List)paramj;
    AppMethodBeat.o(60588);
    return paramg;
  }
  
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<kotlin.l.b.a.b.m.c.j, kotlin.l.b.a.b.m.c.j, Boolean, Boolean>
  {
    a(g paramg)
    {
      super();
    }
    
    public final boolean a(kotlin.l.b.a.b.m.c.j paramj1, kotlin.l.b.a.b.m.c.j paramj2, boolean paramBoolean)
    {
      AppMethodBeat.i(186268);
      p.h(paramj1, "integerLiteralType");
      p.h(paramj2, "type");
      paramj1 = (Iterable)this.TNm.d(paramj1);
      if ((!(paramj1 instanceof Collection)) || (!((Collection)paramj1).isEmpty()))
      {
        paramj1 = paramj1.iterator();
        while (paramj1.hasNext())
        {
          kotlin.l.b.a.b.m.c.h localh = (kotlin.l.b.a.b.m.c.h)paramj1.next();
          if (!p.j(this.TNm.d(localh), this.TNm.i(paramj2)))
          {
            if (!paramBoolean) {
              break label138;
            }
            e locale = e.TNl;
            if (!e.a(this.TNm, (kotlin.l.b.a.b.m.c.h)paramj2, localh)) {
              break label138;
            }
          }
          label138:
          for (int i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(186268);
            return true;
          }
        }
      }
      AppMethodBeat.o(186268);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.e
 * JD-Core Version:    0.7.0.1
 */