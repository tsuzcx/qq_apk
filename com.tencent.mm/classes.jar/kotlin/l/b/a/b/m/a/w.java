package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<+Lkotlin.l.b.a.b.m.al;>;
import java.util.Set;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.b.n;
import kotlin.l.b.a.b.j.b.n.a;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.as;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bk;

public final class w
{
  public static final w ajrt;
  
  static
  {
    AppMethodBeat.i(61187);
    ajrt = new w();
    AppMethodBeat.o(61187);
  }
  
  private static Collection<al> a(Collection<? extends al> paramCollection, kotlin.g.a.m<? super al, ? super al, Boolean> paramm)
  {
    AppMethodBeat.i(61186);
    paramCollection = new ArrayList(paramCollection);
    Iterator localIterator = paramCollection.iterator();
    s.s(localIterator, "filteredTypes.iterator()");
    label137:
    label159:
    label164:
    while (localIterator.hasNext())
    {
      al localal1 = (al)localIterator.next();
      Object localObject = (Iterable)paramCollection;
      if (!((Collection)localObject).isEmpty())
      {
        localObject = ((Iterable)localObject).iterator();
        label73:
        if (((Iterator)localObject).hasNext())
        {
          al localal2 = (al)((Iterator)localObject).next();
          if (localal2 != localal1)
          {
            s.s(localal2, "lower");
            s.s(localal1, "upper");
            if (((Boolean)paramm.invoke(localal2, localal1)).booleanValue())
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
  
  public final al ph(List<? extends al> paramList)
  {
    int j = 1;
    AppMethodBeat.i(61185);
    s.u(paramList, "types");
    if (paramList.size() > 1) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError(s.X("Size should be at least 2, but it is ", Integer.valueOf(paramList.size())));
      AppMethodBeat.o(61185);
      throw paramList;
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (al)((Iterator)localObject3).next();
      if ((((al)localObject4).kzm() instanceof ac))
      {
        paramList = ((al)localObject4).kzm().kpG();
        s.s(paramList, "type.constructor.supertypes");
        paramList = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(p.a(paramList, 10));
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (ad)localIterator.next();
          s.s(paramList, "it");
          localObject1 = aa.af(paramList);
          paramList = (List<? extends al>)localObject1;
          if (((al)localObject4).ksB()) {
            paramList = ((al)localObject1).Pq(true);
          }
          localCollection.add(paramList);
        }
        ((ArrayList)localObject2).addAll((Collection)localCollection);
      }
      else
      {
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    Object localObject1 = (Iterable)localObject2;
    paramList = a.ajru;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList = paramList.d((bk)((Iterator)localObject1).next());
    }
    localObject1 = (Iterable)localObject2;
    localObject3 = (Collection)new LinkedHashSet();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (al)((Iterator)localObject4).next();
      localObject2 = localObject1;
      if (paramList == a.ajrx)
      {
        localObject2 = localObject1;
        if ((localObject1 instanceof i))
        {
          localObject1 = (i)localObject1;
          s.u(localObject1, "<this>");
          localObject2 = (al)new i(((i)localObject1).ajrc, ((i)localObject1).ajrd, ((i)localObject1).ajre, ((i)localObject1).knl(), ((i)localObject1).ksB(), true);
        }
        localObject2 = ao.a((al)localObject2, false);
      }
      ((Collection)localObject3).add(localObject2);
    }
    paramList = (Set)localObject3;
    if (paramList.size() == 1)
    {
      paramList = (al)p.i((Iterable)paramList);
      AppMethodBeat.o(61185);
      return paramList;
    }
    localObject1 = (a)new w.b(paramList);
    localObject2 = a((Collection)paramList, (kotlin.g.a.m)new w.c(this));
    if (!((Collection)localObject2).isEmpty()) {}
    for (i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError(((a)localObject1).invoke());
      AppMethodBeat.o(61185);
      throw paramList;
    }
    localObject3 = n.ajjK;
    localObject3 = n.a.P((Collection)localObject2);
    if (localObject3 != null)
    {
      AppMethodBeat.o(61185);
      return localObject3;
    }
    localObject3 = l.ajrl;
    localObject2 = a((Collection)localObject2, (kotlin.g.a.m)new w.d(l.a.kAV()));
    if (!((Collection)localObject2).isEmpty()) {}
    for (i = j; (ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError(((a)localObject1).invoke());
      AppMethodBeat.o(61185);
      throw paramList;
    }
    if (((Collection)localObject2).size() < 2)
    {
      paramList = (al)p.i((Iterable)localObject2);
      AppMethodBeat.o(61185);
      return paramList;
    }
    paramList = new ac((Collection)paramList).kAJ();
    AppMethodBeat.o(61185);
    return paramList;
  }
  
  static abstract enum a
  {
    private a() {}
    
    protected static a e(bk parambk)
    {
      s.u(parambk, "<this>");
      if (parambk.ksB()) {
        return ajrv;
      }
      if (((parambk instanceof kotlin.l.b.a.b.m.m)) && ((((kotlin.l.b.a.b.m.m)parambk).ajpp instanceof as))) {
        return ajrx;
      }
      if (!(parambk instanceof as))
      {
        o localo = o.ajrp;
        if (o.c(parambk)) {
          return ajrx;
        }
      }
      return ajrw;
    }
    
    public abstract a d(bk parambk);
    
    static final class a
      extends w.a
    {
      a()
      {
        super(1, (byte)0);
      }
      
      public final w.a d(bk parambk)
      {
        AppMethodBeat.i(61176);
        s.u(parambk, "nextType");
        parambk = e(parambk);
        AppMethodBeat.o(61176);
        return parambk;
      }
    }
    
    static final class b
      extends w.a
    {
      b()
      {
        super(3, (byte)0);
      }
    }
    
    static final class c
      extends w.a
    {
      c()
      {
        super(0, (byte)0);
      }
      
      public final w.a d(bk parambk)
      {
        AppMethodBeat.i(61178);
        s.u(parambk, "nextType");
        parambk = e(parambk);
        AppMethodBeat.o(61178);
        return parambk;
      }
    }
    
    static final class d
      extends w.a
    {
      d()
      {
        super(2, (byte)0);
      }
      
      public final w.a d(bk parambk)
      {
        AppMethodBeat.i(61179);
        s.u(parambk, "nextType");
        parambk = e(parambk);
        if (parambk == w.a.ajrv)
        {
          parambk = (w.a)this;
          AppMethodBeat.o(61179);
          return parambk;
        }
        AppMethodBeat.o(61179);
        return parambk;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.w
 * JD-Core Version:    0.7.0.1
 */