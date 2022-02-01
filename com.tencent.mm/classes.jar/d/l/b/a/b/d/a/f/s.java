package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.d.a;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class s
{
  private static final b NFn;
  private static final b NFo;
  
  static
  {
    AppMethodBeat.i(58143);
    d.l.b.a.b.f.b localb = d.l.b.a.b.d.a.p.NzL;
    d.g.b.p.g(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    NFn = new b(localb);
    localb = d.l.b.a.b.d.a.p.NzM;
    d.g.b.p.g(localb, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
    NFo = new b(localb);
    AppMethodBeat.o(58143);
  }
  
  public static final boolean U(ab paramab)
  {
    AppMethodBeat.i(58132);
    d.g.b.p.h(paramab, "$this$hasEnhancedNullability");
    boolean bool = a((bb)d.l.b.a.b.m.a.s.OaB, (d.l.b.a.b.m.c.h)paramab);
    AppMethodBeat.o(58132);
    return bool;
  }
  
  private static final c<d.l.b.a.b.b.h> a(d.l.b.a.b.b.h paramh, d paramd, q paramq)
  {
    AppMethodBeat.i(58141);
    if (!a(paramq))
    {
      paramh = fi(paramh);
      AppMethodBeat.o(58141);
      return paramh;
    }
    if (!(paramh instanceof e))
    {
      paramh = fi(paramh);
      AppMethodBeat.o(58141);
      return paramh;
    }
    d.l.b.a.b.a.b.c localc = d.l.b.a.b.a.b.c.Nqr;
    paramd = paramd.NEd;
    if (paramd == null) {}
    do
    {
      do
      {
        for (;;)
        {
          paramh = fi(paramh);
          AppMethodBeat.o(58141);
          return paramh;
          switch (t.cqt[paramd.ordinal()])
          {
          }
        }
      } while ((paramq != q.NFj) || (!d.l.b.a.b.a.b.c.h((e)paramh)));
      paramh = fk(d.l.b.a.b.a.b.c.j((e)paramh));
      AppMethodBeat.o(58141);
      return paramh;
    } while ((paramq != q.NFk) || (!d.l.b.a.b.a.b.c.i((e)paramh)));
    paramh = fk(d.l.b.a.b.a.b.c.k((e)paramh));
    AppMethodBeat.o(58141);
    return paramh;
  }
  
  private static final c<Boolean> a(ab paramab, d paramd, q paramq)
  {
    AppMethodBeat.i(58142);
    if (!a(paramq))
    {
      paramab = fi(Boolean.valueOf(paramab.gqy()));
      AppMethodBeat.o(58142);
      return paramab;
    }
    paramd = paramd.NEc;
    if (paramd == null) {}
    for (;;)
    {
      paramab = fi(Boolean.valueOf(paramab.gqy()));
      AppMethodBeat.o(58142);
      return paramab;
      switch (t.gpL[paramd.ordinal()])
      {
      }
    }
    paramab = fj(Boolean.TRUE);
    AppMethodBeat.o(58142);
    return paramab;
    paramab = fj(Boolean.FALSE);
    AppMethodBeat.o(58142);
    return paramab;
  }
  
  private static final k a(bg parambg, d.g.a.b<? super Integer, d> paramb, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(58134);
    if (ad.aq((ab)parambg))
    {
      parambg = new k((ab)parambg, 1, false);
      AppMethodBeat.o(58134);
      return parambg;
    }
    o localo1;
    o localo2;
    if ((parambg instanceof d.l.b.a.b.m.v))
    {
      localo1 = a(((d.l.b.a.b.m.v)parambg).NZc, paramb, paramInt, q.NFj);
      localo2 = a(((d.l.b.a.b.m.v)parambg).NZd, paramb, paramInt, q.NFk);
      if (localo1.NEI == localo2.NEI) {}
      for (paramInt = 1; (d.ac.Nhs) && (paramInt == 0); paramInt = 0)
      {
        parambg = (Throwable)new AssertionError("Different tree sizes of bounds: lower = (" + ((d.l.b.a.b.m.v)parambg).NZc + ", " + localo1.NEI + "), upper = (" + ((d.l.b.a.b.m.v)parambg).NZd + ", " + localo2.NEI + ')');
        AppMethodBeat.o(58134);
        throw parambg;
      }
      if ((localo1.NEJ) || (localo2.NEJ)) {
        bool = true;
      }
      paramb = be.aK((ab)localo1.NFh);
      if (paramb != null) {
        break label369;
      }
      paramb = be.aK((ab)localo2.NFh);
    }
    label369:
    for (;;)
    {
      if (!bool)
      {
        parambg = new k((ab)parambg, localo1.NEI, bool);
        AppMethodBeat.o(58134);
        return parambg;
      }
      if ((parambg instanceof d.l.b.a.b.d.a.c.b.g)) {}
      for (parambg = (bg)new d.l.b.a.b.d.a.c.b.g(localo1.NFh, localo2.NFh);; parambg = d.l.b.a.b.m.ac.a(localo1.NFh, localo2.NFh))
      {
        parambg = be.b(parambg, paramb);
        break;
      }
      if ((parambg instanceof aj))
      {
        parambg = (k)a((aj)parambg, paramb, paramInt, q.NFl);
        AppMethodBeat.o(58134);
        return parambg;
      }
      parambg = new m();
      AppMethodBeat.o(58134);
      throw parambg;
    }
  }
  
  private static final o a(aj paramaj, d.g.a.b<? super Integer, d> paramb, int paramInt, q paramq)
  {
    AppMethodBeat.i(58135);
    if ((!a(paramq)) && (paramaj.gxy().isEmpty()))
    {
      paramaj = new o(paramaj, 1, false);
      AppMethodBeat.o(58135);
      return paramaj;
    }
    Object localObject1 = paramaj.gxB().gmq();
    if (localObject1 == null)
    {
      paramaj = new o(paramaj, 1, false);
      AppMethodBeat.o(58135);
      return paramaj;
    }
    d.g.b.p.g(localObject1, "constructor.declarationD…pleResult(this, 1, false)");
    d locald = (d)paramb.invoke(Integer.valueOf(paramInt));
    localObject1 = a((d.l.b.a.b.b.h)localObject1, locald, paramq);
    d.l.b.a.b.b.h localh = (d.l.b.a.b.b.h)((c)localObject1).result;
    d.l.b.a.b.b.a.g localg = ((c)localObject1).NEb;
    at localat = localh.glW();
    d.g.b.p.g(localat, "enhancedClassifier.typeConstructor");
    if (localg != null) {}
    Collection localCollection;
    int j;
    int k;
    int m;
    for (int i = 1;; i = 0)
    {
      localObject1 = (Iterable)paramaj.gxy();
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
          j.gkd();
        }
        localObject1 = (av)localObject1;
        if (!((av)localObject1).gyE()) {
          break;
        }
        i = k + 1;
        localObject1 = localh.glW();
        d.g.b.p.g(localObject1, "enhancedClassifier.typeConstructor");
        localObject1 = bc.d((as)((at)localObject1).getParameters().get(j));
        localCollection.add(localObject1);
        j += 1;
        k = i;
      }
    }
    Object localObject2 = a(((av)localObject1).gnW().gyC(), paramb, k);
    if ((m != 0) || (((k)localObject2).NEJ)) {}
    for (i = 1;; i = 0)
    {
      k = ((k)localObject2).NEI + k;
      localObject2 = ((k)localObject2).gnW();
      localObject1 = ((av)localObject1).gyF();
      d.g.b.p.g(localObject1, "arg.projectionKind");
      localObject1 = a.a((ab)localObject2, (bh)localObject1, (as)localat.getParameters().get(j));
      m = i;
      i = k;
      break;
    }
    label432:
    paramb = (List)localCollection;
    paramq = a((ab)paramaj, locald, paramq);
    boolean bool = ((Boolean)paramq.result).booleanValue();
    paramq = paramq.NEb;
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
    paramb = d.l.b.a.b.m.ac.c(jz(j.ac(new d.l.b.a.b.b.a.g[] { paramaj.gmj(), localg, paramq })), localat, paramb, bool);
    if (locald.NEe)
    {
      paramb = (aj)new f(paramb);
      if ((paramq == null) || (!locald.NEf)) {
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
      paramaj = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
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
  
  public static final ab a(ab paramab, d.g.a.b<? super Integer, d> paramb)
  {
    AppMethodBeat.i(58131);
    d.g.b.p.h(paramab, "$this$enhance");
    d.g.b.p.h(paramb, "qualifiers");
    paramab = a(paramab.gyC(), paramb, 0);
    paramb = paramab.gnW();
    if (paramab.NEJ)
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
    d.g.b.p.h(paramq, "$this$shouldEnhance");
    if (paramq != q.NFl)
    {
      AppMethodBeat.o(58137);
      return true;
    }
    AppMethodBeat.o(58137);
    return false;
  }
  
  public static final boolean a(bb parambb, d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(58133);
    d.g.b.p.h(parambb, "$this$hasEnhancedNullability");
    d.g.b.p.h(paramh, "type");
    d.l.b.a.b.f.b localb = d.l.b.a.b.d.a.p.NzL;
    d.g.b.p.g(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    boolean bool = parambb.a(paramh, localb);
    AppMethodBeat.o(58133);
    return bool;
  }
  
  private static final <T> c<T> fi(T paramT)
  {
    AppMethodBeat.i(58138);
    paramT = new c(paramT, null);
    AppMethodBeat.o(58138);
    return paramT;
  }
  
  private static final <T> c<T> fj(T paramT)
  {
    AppMethodBeat.i(58139);
    paramT = new c(paramT, (d.l.b.a.b.b.a.g)NFn);
    AppMethodBeat.o(58139);
    return paramT;
  }
  
  private static final <T> c<T> fk(T paramT)
  {
    AppMethodBeat.i(58140);
    paramT = new c(paramT, (d.l.b.a.b.b.a.g)NFo);
    AppMethodBeat.o(58140);
    return paramT;
  }
  
  private static final d.l.b.a.b.b.a.g jz(List<? extends d.l.b.a.b.b.a.g> paramList)
  {
    AppMethodBeat.i(58136);
    switch (paramList.size())
    {
    default: 
      paramList = (d.l.b.a.b.b.a.g)new d.l.b.a.b.b.a.k(j.l((Iterable)paramList));
      AppMethodBeat.o(58136);
      return paramList;
    case 0: 
      paramList = (Throwable)new IllegalStateException("At least one Annotations object expected".toString());
      AppMethodBeat.o(58136);
      throw paramList;
    }
    paramList = (d.l.b.a.b.b.a.g)j.jp(paramList);
    AppMethodBeat.o(58136);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.s
 * JD-Core Version:    0.7.0.1
 */