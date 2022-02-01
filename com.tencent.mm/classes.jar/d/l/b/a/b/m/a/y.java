package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.ac;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l.b.a.b.m.aa;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.am;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.l;
import d.l.b.a.b.m.l.a;
import d.l.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<+Ld.l.b.a.b.m.aj;>;
import java.util.Set;

public final class y
{
  public static final y OaL;
  
  static
  {
    AppMethodBeat.i(61187);
    OaL = new y();
    AppMethodBeat.o(61187);
  }
  
  private static Collection<aj> a(Collection<? extends aj> paramCollection, m<? super aj, ? super aj, Boolean> paramm)
  {
    AppMethodBeat.i(61186);
    paramCollection = new ArrayList(paramCollection);
    Iterator localIterator = paramCollection.iterator();
    p.g(localIterator, "filteredTypes.iterator()");
    label137:
    label159:
    label164:
    while (localIterator.hasNext())
    {
      aj localaj1 = (aj)localIterator.next();
      Object localObject = (Iterable)paramCollection;
      if (!((Collection)localObject).isEmpty())
      {
        localObject = ((Iterable)localObject).iterator();
        label73:
        if (((Iterator)localObject).hasNext())
        {
          aj localaj2 = (aj)((Iterator)localObject).next();
          if (localaj2 != localaj1)
          {
            p.g(localaj2, "lower");
            p.g(localaj1, "upper");
            if (((Boolean)paramm.p(localaj2, localaj1)).booleanValue())
            {
              i = 1;
              if (i == 0) {
                break label159;
              }
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label164;
        }
        localIterator.remove();
        break;
        i = 0;
        break label137;
        break label73;
      }
    }
    paramCollection = (Collection)paramCollection;
    AppMethodBeat.o(61186);
    return paramCollection;
  }
  
  public final aj jG(List<? extends aj> paramList)
  {
    int j = 1;
    AppMethodBeat.i(61185);
    p.h(paramList, "types");
    if (paramList.size() > 1) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Size should be at least 2, but it is " + paramList.size());
      AppMethodBeat.o(61185);
      throw paramList;
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (aj)((Iterator)localObject2).next();
      if ((((aj)localObject4).gxB() instanceof aa))
      {
        paramList = ((aj)localObject4).gxB().got();
        p.g(paramList, "type.constructor.supertypes");
        paramList = (Iterable)paramList;
        localObject5 = (Collection)new ArrayList(j.a(paramList, 10));
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (ab)localIterator.next();
          p.g(paramList, "it");
          localObject1 = d.l.b.a.b.m.y.ap(paramList);
          paramList = (List<? extends aj>)localObject1;
          if (((aj)localObject4).gqy()) {
            paramList = ((aj)localObject1).Ap(true);
          }
          ((Collection)localObject5).add(paramList);
        }
        ((ArrayList)localObject3).addAll((Collection)localObject5);
      }
      else
      {
        ((ArrayList)localObject3).add(localObject4);
      }
    }
    paramList = (Iterable)localObject3;
    localObject2 = a.OaM;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localObject2 = ((a)localObject2).e((bg)paramList.next());
    }
    paramList = (Iterable)localObject3;
    Object localObject4 = (Collection)new LinkedHashSet();
    Object localObject5 = paramList.iterator();
    if (((Iterator)localObject5).hasNext())
    {
      localObject3 = (aj)((Iterator)localObject5).next();
      if (localObject2 == a.OaP)
      {
        p.h(localObject3, "$this$makeSimpleTypeDefinitelyNotNullOrNotNull");
        paramList = l.NYM;
        paramList = l.a.a((bg)localObject3);
        if (paramList != null)
        {
          paramList = (aj)paramList;
          label399:
          localObject1 = paramList;
          if (paramList != null) {}
        }
      }
      for (localObject1 = ((aj)localObject3).Ap(false);; localObject1 = localObject3)
      {
        ((Collection)localObject4).add(localObject1);
        break;
        paramList = am.at((ab)localObject3);
        break label399;
      }
    }
    paramList = (Set)localObject4;
    if (paramList.size() == 1)
    {
      paramList = (aj)j.f((Iterable)paramList);
      AppMethodBeat.o(61185);
      return paramList;
    }
    Object localObject1 = (a)new y.b(paramList);
    localObject2 = a((Collection)paramList, (m)new c((y)this));
    if (!((Collection)localObject2).isEmpty()) {}
    for (i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError(((a)localObject1).invoke());
      AppMethodBeat.o(61185);
      throw paramList;
    }
    localObject3 = d.l.b.a.b.j.b.n.NTG;
    localObject3 = d.l.b.a.b.j.b.n.a.x((Collection)localObject2);
    if (localObject3 != null)
    {
      AppMethodBeat.o(61185);
      return localObject3;
    }
    localObject3 = n.Oaw;
    localObject2 = a((Collection)localObject2, (m)new d(n.a.gyL()));
    if (!((Collection)localObject2).isEmpty()) {}
    for (i = j; (ac.Nhs) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError(((a)localObject1).invoke());
      AppMethodBeat.o(61185);
      throw paramList;
    }
    if (((Collection)localObject2).size() < 2)
    {
      paramList = (aj)j.f((Iterable)localObject2);
      AppMethodBeat.o(61185);
      return paramList;
    }
    paramList = new aa((Collection)paramList).gyB();
    AppMethodBeat.o(61185);
    return paramList;
  }
  
  static abstract enum a
  {
    static
    {
      c localc = new c("START");
      OaM = localc;
      a locala = new a("ACCEPT_NULL");
      OaN = locala;
      d locald = new d("UNKNOWN");
      OaO = locald;
      b localb = new b("NOT_NULL");
      OaP = localb;
      OaQ = new a[] { localc, locala, locald, localb };
    }
    
    private a() {}
    
    protected static a f(bg parambg)
    {
      p.h(parambg, "$this$resultNullability");
      if (parambg.gqy()) {
        return OaN;
      }
      q localq = q.OaA;
      if (q.d(parambg)) {
        return OaP;
      }
      return OaO;
    }
    
    public abstract a e(bg parambg);
    
    static final class a
      extends y.a
    {
      a()
      {
        super(1, (byte)0);
      }
      
      public final y.a e(bg parambg)
      {
        AppMethodBeat.i(61176);
        p.h(parambg, "nextType");
        parambg = f(parambg);
        AppMethodBeat.o(61176);
        return parambg;
      }
    }
    
    static final class b
      extends y.a
    {
      b()
      {
        super(3, (byte)0);
      }
    }
    
    static final class c
      extends y.a
    {
      c()
      {
        super(0, (byte)0);
      }
      
      public final y.a e(bg parambg)
      {
        AppMethodBeat.i(61178);
        p.h(parambg, "nextType");
        parambg = f(parambg);
        AppMethodBeat.o(61178);
        return parambg;
      }
    }
    
    static final class d
      extends y.a
    {
      d()
      {
        super(2, (byte)0);
      }
      
      public final y.a e(bg parambg)
      {
        AppMethodBeat.i(61179);
        p.h(parambg, "nextType");
        parambg = f(parambg);
        if (parambg == y.a.OaN)
        {
          parambg = (y.a)this;
          AppMethodBeat.o(61179);
          return parambg;
        }
        AppMethodBeat.o(61179);
        return parambg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.y
 * JD-Core Version:    0.7.0.1
 */