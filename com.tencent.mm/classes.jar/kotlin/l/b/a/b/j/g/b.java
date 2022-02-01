package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.ad;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.n.b.a;
import kotlin.l.b.a.b.o.e;

public final class b
  implements h
{
  public static final a ajkx;
  private final h[] ajky;
  private final String roK;
  
  static
  {
    AppMethodBeat.i(60193);
    ajkx = new a((byte)0);
    AppMethodBeat.o(60193);
  }
  
  private b(String paramString, h[] paramArrayOfh)
  {
    this.roK = paramString;
    this.ajky = paramArrayOfh;
  }
  
  public final Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(60187);
    s.u(paramf, "name");
    s.u(paramb, "location");
    h[] arrayOfh = this.ajky;
    Collection localCollection;
    int j;
    switch (arrayOfh.length)
    {
    default: 
      localCollection = null;
      j = arrayOfh.length;
    }
    while (i < j)
    {
      h localh = arrayOfh[i];
      i += 1;
      localCollection = a.a(localCollection, localh.a(paramf, paramb));
      continue;
      paramf = (Collection)ab.aivy;
      AppMethodBeat.o(60187);
      return paramf;
      paramf = arrayOfh[0].a(paramf, paramb);
      AppMethodBeat.o(60187);
      return paramf;
    }
    if (localCollection == null)
    {
      paramf = (Collection)ad.aivA;
      AppMethodBeat.o(60187);
      return paramf;
    }
    AppMethodBeat.o(60187);
    return localCollection;
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    int i = 0;
    AppMethodBeat.i(60189);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    h[] arrayOfh = this.ajky;
    Collection localCollection;
    int j;
    switch (arrayOfh.length)
    {
    default: 
      localCollection = null;
      j = arrayOfh.length;
    }
    while (i < j)
    {
      h localh = arrayOfh[i];
      i += 1;
      localCollection = a.a(localCollection, localh.a(paramd, paramb));
      continue;
      paramd = (Collection)ab.aivy;
      AppMethodBeat.o(60189);
      return paramd;
      paramd = arrayOfh[0].a(paramd, paramb);
      AppMethodBeat.o(60189);
      return paramd;
    }
    if (localCollection == null)
    {
      paramd = (Collection)ad.aivA;
      AppMethodBeat.o(60189);
      return paramd;
    }
    AppMethodBeat.o(60189);
    return localCollection;
  }
  
  public final Collection<au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(60188);
    s.u(paramf, "name");
    s.u(paramb, "location");
    h[] arrayOfh = this.ajky;
    Collection localCollection;
    int j;
    switch (arrayOfh.length)
    {
    default: 
      localCollection = null;
      j = arrayOfh.length;
    }
    while (i < j)
    {
      h localh = arrayOfh[i];
      i += 1;
      localCollection = a.a(localCollection, localh.b(paramf, paramb));
      continue;
      paramf = (Collection)ab.aivy;
      AppMethodBeat.o(60188);
      return paramf;
      paramf = arrayOfh[0].b(paramf, paramb);
      AppMethodBeat.o(60188);
      return paramf;
    }
    if (localCollection == null)
    {
      paramf = (Collection)ad.aivA;
      AppMethodBeat.o(60188);
      return paramf;
    }
    AppMethodBeat.o(60188);
    return localCollection;
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60186);
    s.u(paramf, "name");
    s.u(paramb, "location");
    h[] arrayOfh = this.ajky;
    Object localObject1 = null;
    int i = 0;
    int j = arrayOfh.length;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = arrayOfh[i];
        i += 1;
        localObject2 = ((h)localObject2).c(paramf, paramb);
        if (localObject2 != null) {
          if (((localObject2 instanceof i)) && (((i)localObject2).kni()))
          {
            if (localObject1 == null) {
              localObject1 = localObject2;
            }
          }
          else
          {
            AppMethodBeat.o(60186);
            return localObject2;
          }
        }
      }
      else
      {
        AppMethodBeat.o(60186);
        return localObject1;
      }
    }
  }
  
  public final void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(192242);
    s.u(paramf, "name");
    s.u(paramb, "location");
    h[] arrayOfh = this.ajky;
    int j = arrayOfh.length;
    int i = 0;
    while (i < j)
    {
      arrayOfh[i].d(paramf, paramb);
      i += 1;
    }
    AppMethodBeat.o(192242);
  }
  
  public final Set<f> kpL()
  {
    AppMethodBeat.i(60190);
    Object localObject = this.ajky;
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      p.a(localCollection, (Iterable)localObject[i].kpL());
      i += 1;
    }
    localObject = (Set)localCollection;
    AppMethodBeat.o(60190);
    return localObject;
  }
  
  public final Set<f> kpM()
  {
    AppMethodBeat.i(192238);
    Set localSet = j.H(k.ai(this.ajky));
    AppMethodBeat.o(192238);
    return localSet;
  }
  
  public final Set<f> kpN()
  {
    AppMethodBeat.i(60191);
    Object localObject = this.ajky;
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      p.a(localCollection, (Iterable)localObject[i].kpN());
      i += 1;
    }
    localObject = (Set)localCollection;
    AppMethodBeat.o(60191);
    return localObject;
  }
  
  public final String toString()
  {
    return this.roK;
  }
  
  public static final class a
  {
    public static h Z(String paramString, List<? extends h> paramList)
    {
      AppMethodBeat.i(192236);
      s.u(paramString, "debugName");
      s.u(paramList, "scopes");
      switch (paramList.size())
      {
      default: 
        paramList = ((Collection)paramList).toArray(new h[0]);
        if (paramList == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(192236);
          throw paramString;
        }
        break;
      case 0: 
        paramString = (h)h.c.ajlm;
        AppMethodBeat.o(192236);
        return paramString;
      case 1: 
        paramString = (h)paramList.get(0);
        AppMethodBeat.o(192236);
        return paramString;
      }
      paramString = (h)new b(paramString, (h[])paramList, (byte)0);
      AppMethodBeat.o(192236);
      return paramString;
    }
    
    public static h a(String paramString, Iterable<? extends h> paramIterable)
    {
      AppMethodBeat.i(192234);
      s.u(paramString, "debugName");
      s.u(paramIterable, "scopes");
      e locale = new e();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        h localh = (h)paramIterable.next();
        if (localh != h.c.ajlm) {
          if ((localh instanceof b)) {
            p.a((Collection)locale, b.a((b)localh));
          } else {
            locale.add(localh);
          }
        }
      }
      paramString = Z(paramString, (List)locale);
      AppMethodBeat.o(192234);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.b
 * JD-Core Version:    0.7.0.1
 */