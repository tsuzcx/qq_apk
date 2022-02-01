package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.j.a.a.c;
import d.l.b.a.b.j.b.q;
import d.l.b.a.b.m.aa;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.b;
import d.l.b.a.b.m.c.h;
import d.l.b.a.b.m.e;
import d.l.b.a.b.m.g;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class o
  implements n
{
  private final i NSV;
  private final d.l.b.a.b.j.i Oaz;
  
  public o(i parami)
  {
    AppMethodBeat.i(61089);
    this.NSV = parami;
    parami = d.l.b.a.b.j.i.f(this.NSV);
    p.g(parami, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
    this.Oaz = parami;
    AppMethodBeat.o(61089);
  }
  
  private static aj c(aj paramaj)
  {
    int i = 1;
    Object localObject3 = null;
    AppMethodBeat.i(61087);
    p.h(paramaj, "type");
    at localat = paramaj.gxB();
    Object localObject2;
    Object localObject1;
    if ((localat instanceof c))
    {
      localObject2 = ((c)localat).NTs;
      if (((av)localObject2).gyF() == bh.NZX) {
        if (i == 0) {
          break label188;
        }
      }
      Collection localCollection;
      for (;;)
      {
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject2 = ((av)localObject2).gnW();
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((ab)localObject2).gyC();
          }
        }
        if (((c)localat).NTr != null) {
          break label212;
        }
        localObject2 = (c)localat;
        localObject3 = ((c)localat).NTs;
        Object localObject4 = (Iterable)((c)localat).got();
        localCollection = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          localCollection.add(((ab)((Iterator)localObject4).next()).gyC());
        }
        i = 0;
        break;
        label188:
        localObject2 = null;
      }
      ((c)localObject2).NTr = new l((av)localObject3, (List)localCollection, (byte)0);
      label212:
      localObject2 = b.OaV;
      localObject3 = ((c)localat).NTr;
      if (localObject3 == null) {
        p.gkB();
      }
      paramaj = (aj)new k((b)localObject2, (l)localObject3, (bg)localObject1, paramaj.gmj(), paramaj.gqy());
      AppMethodBeat.o(61087);
      return paramaj;
    }
    if ((localat instanceof q))
    {
      localObject2 = (Iterable)((q)localat).NTM;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(bc.a((ab)((Iterator)localObject2).next(), paramaj.gqy()));
      }
      localObject1 = new aa((Collection)localObject1);
      paramaj = ac.a(paramaj.gmj(), (at)localObject1, (List)d.a.v.NhH, paramaj.gmN());
      AppMethodBeat.o(61087);
      return paramaj;
    }
    if (((localat instanceof aa)) && (paramaj.gqy()))
    {
      localObject1 = (Iterable)((aa)localat).NZl;
      paramaj = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      for (i = 0; ((Iterator)localObject1).hasNext(); i = 1) {
        paramaj.add(d.l.b.a.b.m.d.a.aD((ab)((Iterator)localObject1).next()));
      }
      paramaj = (List)paramaj;
      if (i == 0)
      {
        paramaj = null;
        if (paramaj != null) {
          break label534;
        }
        paramaj = (aa)localat;
      }
    }
    label534:
    for (;;)
    {
      paramaj = paramaj.gyB();
      AppMethodBeat.o(61087);
      return paramaj;
      paramaj = new aa((Collection)paramaj);
      break;
      AppMethodBeat.o(61087);
      return paramaj;
    }
  }
  
  public static bg c(bg parambg)
  {
    AppMethodBeat.i(61088);
    p.h(parambg, "type");
    Object localObject;
    if ((parambg instanceof aj)) {
      localObject = (bg)c((aj)parambg);
    }
    for (;;)
    {
      parambg = be.a((bg)localObject, (ab)parambg);
      AppMethodBeat.o(61088);
      return parambg;
      if (!(parambg instanceof d.l.b.a.b.m.v)) {
        break;
      }
      localObject = c(((d.l.b.a.b.m.v)parambg).NZc);
      aj localaj = c(((d.l.b.a.b.m.v)parambg).NZd);
      if ((localObject != ((d.l.b.a.b.m.v)parambg).NZc) || (localaj != ((d.l.b.a.b.m.v)parambg).NZd)) {
        localObject = ac.a((aj)localObject, localaj);
      } else {
        localObject = parambg;
      }
    }
    parambg = new m();
    AppMethodBeat.o(61088);
    throw parambg;
  }
  
  public final boolean c(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61085);
    p.h(paramab1, "subtype");
    p.h(paramab2, "supertype");
    a locala = new a(true, false, false, this.NSV, 6);
    paramab1 = paramab1.gyC();
    paramab2 = paramab2.gyC();
    p.h(locala, "$this$isSubtypeOf");
    p.h(paramab1, "subType");
    p.h(paramab2, "superType");
    e locale = e.NYs;
    boolean bool = e.a((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61085);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61086);
    p.h(paramab1, "a");
    p.h(paramab2, "b");
    a locala = new a(false, false, false, this.NSV, 6);
    paramab1 = paramab1.gyC();
    paramab2 = paramab2.gyC();
    p.h(locala, "$this$equalTypes");
    p.h(paramab1, "a");
    p.h(paramab2, "b");
    e locale = e.NYs;
    boolean bool = e.b((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61086);
    return bool;
  }
  
  public final i gyJ()
  {
    return this.NSV;
  }
  
  public final d.l.b.a.b.j.i gyK()
  {
    return this.Oaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.o
 * JD-Core Version:    0.7.0.1
 */