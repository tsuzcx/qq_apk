package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.a.a.c;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.e;
import kotlin.l.b.a.b.m.g;
import kotlin.l.b.a.b.m.v;
import kotlin.m;

public final class o
  implements n
{
  private final i abkv;
  private final kotlin.l.b.a.b.j.i abrS;
  
  public o(i parami)
  {
    AppMethodBeat.i(61089);
    this.abkv = parami;
    parami = kotlin.l.b.a.b.j.i.f(this.abkv);
    p.j(parami, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
    this.abrS = parami;
    AppMethodBeat.o(61089);
  }
  
  private static aj c(aj paramaj)
  {
    int i = 1;
    Object localObject3 = null;
    AppMethodBeat.i(61087);
    p.k(paramaj, "type");
    at localat = paramaj.iOU();
    Object localObject1;
    if ((localat instanceof c))
    {
      Object localObject2 = ((c)localat).abkS;
      if (((av)localObject2).iQa() == bh.abrq) {
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
          localObject2 = ((av)localObject2).iFN();
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((ab)localObject2).iPX();
          }
        }
        if (((c)localat).abkR != null) {
          break label212;
        }
        localObject2 = (c)localat;
        localObject3 = ((c)localat).abkS;
        Object localObject4 = (Iterable)((c)localat).iGk();
        localCollection = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          localCollection.add(((ab)((Iterator)localObject4).next()).iPX());
        }
        i = 0;
        break;
        label188:
        localObject2 = null;
      }
      ((c)localObject2).abkR = new l((av)localObject3, (List)localCollection, (byte)0);
      label212:
      localObject2 = b.abso;
      localObject3 = ((c)localat).abkR;
      if (localObject3 == null) {
        p.iCn();
      }
      paramaj = (aj)new k((b)localObject2, (l)localObject3, (bg)localObject1, paramaj.iDY(), paramaj.iIu());
      AppMethodBeat.o(61087);
      return paramaj;
    }
    if ((localat instanceof q))
    {
      AppMethodBeat.o(61087);
      throw null;
    }
    if (((localat instanceof aa)) && (paramaj.iIu()))
    {
      localObject1 = (Iterable)((aa)localat).abqE;
      paramaj = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      for (i = 0; ((Iterator)localObject1).hasNext(); i = 1) {
        paramaj.add(kotlin.l.b.a.b.m.d.a.aC((ab)((Iterator)localObject1).next()));
      }
      paramaj = (List)paramaj;
      if (i == 0)
      {
        paramaj = null;
        if (paramaj != null) {
          break label423;
        }
        paramaj = (aa)localat;
      }
    }
    label423:
    for (;;)
    {
      paramaj = paramaj.iPW();
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
    p.k(parambg, "type");
    Object localObject;
    if ((parambg instanceof aj)) {
      localObject = (bg)c((aj)parambg);
    }
    for (;;)
    {
      parambg = be.a((bg)localObject, (ab)parambg);
      AppMethodBeat.o(61088);
      return parambg;
      if (!(parambg instanceof v)) {
        break;
      }
      localObject = c(((v)parambg).abqv);
      aj localaj = c(((v)parambg).abqw);
      if ((localObject != ((v)parambg).abqv) || (localaj != ((v)parambg).abqw)) {
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
    p.k(paramab1, "subtype");
    p.k(paramab2, "supertype");
    a locala = new a(true, false, false, this.abkv, 6);
    paramab1 = paramab1.iPX();
    paramab2 = paramab2.iPX();
    p.k(locala, "$this$isSubtypeOf");
    p.k(paramab1, "subType");
    p.k(paramab2, "superType");
    e locale = e.abpN;
    boolean bool = e.a((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61085);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61086);
    p.k(paramab1, "a");
    p.k(paramab2, "b");
    a locala = new a(false, false, false, this.abkv, 6);
    paramab1 = paramab1.iPX();
    paramab2 = paramab2.iPX();
    p.k(locala, "$this$equalTypes");
    p.k(paramab1, "a");
    p.k(paramab2, "b");
    e locale = e.abpN;
    boolean bool = e.b((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61086);
    return bool;
  }
  
  public final i iQe()
  {
    return this.abkv;
  }
  
  public final kotlin.l.b.a.b.j.i iQf()
  {
    return this.abrS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.o
 * JD-Core Version:    0.7.0.1
 */