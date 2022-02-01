package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.v;
import kotlin.m;
import kotlin.t;
import kotlin.z;

public final class s
{
  private static final b aaXN;
  private static final b aaXO;
  
  static
  {
    AppMethodBeat.i(58143);
    kotlin.l.b.a.b.f.b localb = kotlin.l.b.a.b.d.a.p.aaSn;
    kotlin.g.b.p.j(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    aaXN = new b(localb);
    localb = kotlin.l.b.a.b.d.a.p.aaSo;
    kotlin.g.b.p.j(localb, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
    aaXO = new b(localb);
    AppMethodBeat.o(58143);
  }
  
  public static final boolean T(ab paramab)
  {
    AppMethodBeat.i(58132);
    kotlin.g.b.p.k(paramab, "$this$hasEnhancedNullability");
    boolean bool = a((bb)kotlin.l.b.a.b.m.a.s.abrU, (kotlin.l.b.a.b.m.c.h)paramab);
    AppMethodBeat.o(58132);
    return bool;
  }
  
  private static final c<kotlin.l.b.a.b.b.h> a(kotlin.l.b.a.b.b.h paramh, d paramd, q paramq)
  {
    AppMethodBeat.i(58141);
    if (!a(paramq))
    {
      paramh = fu(paramh);
      AppMethodBeat.o(58141);
      return paramh;
    }
    if (!(paramh instanceof e))
    {
      paramh = fu(paramh);
      AppMethodBeat.o(58141);
      return paramh;
    }
    kotlin.l.b.a.b.a.b.c localc = kotlin.l.b.a.b.a.b.c.aaIT;
    paramd = paramd.aaWE;
    if (paramd == null) {}
    do
    {
      do
      {
        for (;;)
        {
          paramh = fu(paramh);
          AppMethodBeat.o(58141);
          return paramh;
          switch (t.$EnumSwitchMapping$0[paramd.ordinal()])
          {
          }
        }
      } while ((paramq != q.aaXJ) || (!kotlin.l.b.a.b.a.b.c.h((e)paramh)));
      paramh = fw(kotlin.l.b.a.b.a.b.c.j((e)paramh));
      AppMethodBeat.o(58141);
      return paramh;
    } while ((paramq != q.aaXK) || (!kotlin.l.b.a.b.a.b.c.i((e)paramh)));
    paramh = fw(kotlin.l.b.a.b.a.b.c.k((e)paramh));
    AppMethodBeat.o(58141);
    return paramh;
  }
  
  private static final c<Boolean> a(ab paramab, d paramd, q paramq)
  {
    AppMethodBeat.i(58142);
    if (!a(paramq))
    {
      paramab = fu(Boolean.valueOf(paramab.iIu()));
      AppMethodBeat.o(58142);
      return paramab;
    }
    paramd = paramd.aaWD;
    if (paramd == null) {}
    for (;;)
    {
      paramab = fu(Boolean.valueOf(paramab.iIu()));
      AppMethodBeat.o(58142);
      return paramab;
      switch (t.jLJ[paramd.ordinal()])
      {
      }
    }
    paramab = fv(Boolean.TRUE);
    AppMethodBeat.o(58142);
    return paramab;
    paramab = fv(Boolean.FALSE);
    AppMethodBeat.o(58142);
    return paramab;
  }
  
  private static final k a(bg parambg, kotlin.g.a.b<? super Integer, d> paramb, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(58134);
    if (ad.ap((ab)parambg))
    {
      parambg = new k((ab)parambg, 1, false);
      AppMethodBeat.o(58134);
      return parambg;
    }
    o localo1;
    o localo2;
    if ((parambg instanceof v))
    {
      localo1 = a(((v)parambg).abqv, paramb, paramInt, q.aaXJ);
      localo2 = a(((v)parambg).abqw, paramb, paramInt, q.aaXK);
      if (localo1.aaXj == localo2.aaXj) {}
      for (paramInt = 1; (z.aazO) && (paramInt == 0); paramInt = 0)
      {
        parambg = (Throwable)new AssertionError("Different tree sizes of bounds: lower = (" + ((v)parambg).abqv + ", " + localo1.aaXj + "), upper = (" + ((v)parambg).abqw + ", " + localo2.aaXj + ')');
        AppMethodBeat.o(58134);
        throw parambg;
      }
      if ((localo1.aaXk) || (localo2.aaXk)) {
        bool = true;
      }
      paramb = be.aJ((ab)localo1.aaXH);
      if (paramb != null) {
        break label369;
      }
      paramb = be.aJ((ab)localo2.aaXH);
    }
    label369:
    for (;;)
    {
      if (!bool)
      {
        parambg = new k((ab)parambg, localo1.aaXj, bool);
        AppMethodBeat.o(58134);
        return parambg;
      }
      if ((parambg instanceof kotlin.l.b.a.b.d.a.c.b.g)) {}
      for (parambg = (bg)new kotlin.l.b.a.b.d.a.c.b.g(localo1.aaXH, localo2.aaXH);; parambg = ac.a(localo1.aaXH, localo2.aaXH))
      {
        parambg = be.b(parambg, paramb);
        break;
      }
      if ((parambg instanceof aj))
      {
        parambg = (k)a((aj)parambg, paramb, paramInt, q.aaXL);
        AppMethodBeat.o(58134);
        return parambg;
      }
      parambg = new m();
      AppMethodBeat.o(58134);
      throw parambg;
    }
  }
  
  private static final o a(aj paramaj, kotlin.g.a.b<? super Integer, d> paramb, int paramInt, q paramq)
  {
    AppMethodBeat.i(58135);
    if ((!a(paramq)) && (paramaj.iOR().isEmpty()))
    {
      paramaj = new o(paramaj, 1, false);
      AppMethodBeat.o(58135);
      return paramaj;
    }
    Object localObject1 = paramaj.iOU().iEf();
    if (localObject1 == null)
    {
      paramaj = new o(paramaj, 1, false);
      AppMethodBeat.o(58135);
      return paramaj;
    }
    kotlin.g.b.p.j(localObject1, "constructor.declarationD…pleResult(this, 1, false)");
    d locald = (d)paramb.invoke(Integer.valueOf(paramInt));
    localObject1 = a((kotlin.l.b.a.b.b.h)localObject1, locald, paramq);
    kotlin.l.b.a.b.b.h localh = (kotlin.l.b.a.b.b.h)((c)localObject1).result;
    kotlin.l.b.a.b.b.a.g localg = ((c)localObject1).aaWC;
    at localat = localh.iDL();
    kotlin.g.b.p.j(localat, "enhancedClassifier.typeConstructor");
    if (localg != null) {}
    Collection localCollection;
    int j;
    int k;
    int m;
    for (int i = 1;; i = 0)
    {
      localObject1 = (Iterable)paramaj.iOR();
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      j = 0;
      k = paramInt + 1;
      m = i;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label432;
        }
        localObject1 = localIterator.next();
        if (j < 0) {
          j.iBO();
        }
        localObject1 = (av)localObject1;
        if (!((av)localObject1).iPZ()) {
          break;
        }
        i = k + 1;
        localObject1 = localh.iDL();
        kotlin.g.b.p.j(localObject1, "enhancedClassifier.typeConstructor");
        localObject1 = bc.d((as)((at)localObject1).iCb().get(j));
        localCollection.add(localObject1);
        j += 1;
        k = i;
      }
    }
    Object localObject2 = a(((av)localObject1).iFN().iPX(), paramb, k);
    if ((m != 0) || (((k)localObject2).aaXk)) {}
    for (i = 1;; i = 0)
    {
      k = ((k)localObject2).aaXj + k;
      localObject2 = ((k)localObject2).iFN();
      localObject1 = ((av)localObject1).iQa();
      kotlin.g.b.p.j(localObject1, "arg.projectionKind");
      localObject1 = a.a((ab)localObject2, (bh)localObject1, (as)localat.iCb().get(j));
      m = i;
      i = k;
      break;
    }
    label432:
    paramb = (List)localCollection;
    paramq = a((ab)paramaj, locald, paramq);
    boolean bool = ((Boolean)paramq.result).booleanValue();
    paramq = paramq.aaWC;
    if ((m != 0) || (paramq != null)) {}
    for (i = 1;; i = 0)
    {
      j = k - paramInt;
      if (i != 0) {
        break;
      }
      paramaj = new o(paramaj, j, false);
      AppMethodBeat.o(58135);
      return paramaj;
    }
    paramb = ac.c(lC(j.ah(new kotlin.l.b.a.b.b.a.g[] { paramaj.iDY(), localg, paramq })), localat, paramb, bool);
    if (locald.aaWF)
    {
      paramb = (aj)new f(paramb);
      if ((paramq == null) || (!locald.aaWG)) {
        break label626;
      }
      paramInt = 1;
      label584:
      if (paramInt == 0) {
        break label631;
      }
    }
    label626:
    label631:
    for (paramaj = be.b((bg)paramaj, (ab)paramb);; paramaj = (bg)paramb)
    {
      if (paramaj != null) {
        break label639;
      }
      paramaj = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(58135);
      throw paramaj;
      break;
      paramInt = 0;
      break label584;
    }
    label639:
    paramaj = new o((aj)paramaj, j, true);
    AppMethodBeat.o(58135);
    return paramaj;
  }
  
  public static final ab a(ab paramab, kotlin.g.a.b<? super Integer, d> paramb)
  {
    AppMethodBeat.i(58131);
    kotlin.g.b.p.k(paramab, "$this$enhance");
    kotlin.g.b.p.k(paramb, "qualifiers");
    paramab = a(paramab.iPX(), paramb, 0);
    paramb = paramab.iFN();
    if (paramab.aaXk)
    {
      AppMethodBeat.o(58131);
      return paramb;
    }
    AppMethodBeat.o(58131);
    return null;
  }
  
  private static boolean a(q paramq)
  {
    AppMethodBeat.i(58137);
    kotlin.g.b.p.k(paramq, "$this$shouldEnhance");
    if (paramq != q.aaXL)
    {
      AppMethodBeat.o(58137);
      return true;
    }
    AppMethodBeat.o(58137);
    return false;
  }
  
  public static final boolean a(bb parambb, kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(58133);
    kotlin.g.b.p.k(parambb, "$this$hasEnhancedNullability");
    kotlin.g.b.p.k(paramh, "type");
    kotlin.l.b.a.b.f.b localb = kotlin.l.b.a.b.d.a.p.aaSn;
    kotlin.g.b.p.j(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    boolean bool = parambb.a(paramh, localb);
    AppMethodBeat.o(58133);
    return bool;
  }
  
  private static final <T> c<T> fu(T paramT)
  {
    AppMethodBeat.i(58138);
    paramT = new c(paramT, null);
    AppMethodBeat.o(58138);
    return paramT;
  }
  
  private static final <T> c<T> fv(T paramT)
  {
    AppMethodBeat.i(58139);
    paramT = new c(paramT, (kotlin.l.b.a.b.b.a.g)aaXN);
    AppMethodBeat.o(58139);
    return paramT;
  }
  
  private static final <T> c<T> fw(T paramT)
  {
    AppMethodBeat.i(58140);
    paramT = new c(paramT, (kotlin.l.b.a.b.b.a.g)aaXO);
    AppMethodBeat.o(58140);
    return paramT;
  }
  
  private static final kotlin.l.b.a.b.b.a.g lC(List<? extends kotlin.l.b.a.b.b.a.g> paramList)
  {
    AppMethodBeat.i(58136);
    switch (paramList.size())
    {
    default: 
      paramList = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.b.a.k(j.p((Iterable)paramList));
      AppMethodBeat.o(58136);
      return paramList;
    case 0: 
      paramList = (Throwable)new IllegalStateException("At least one Annotations object expected".toString());
      AppMethodBeat.o(58136);
      throw paramList;
    }
    paramList = (kotlin.l.b.a.b.b.a.g)j.ls(paramList);
    AppMethodBeat.o(58136);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.s
 * JD-Core Version:    0.7.0.1
 */