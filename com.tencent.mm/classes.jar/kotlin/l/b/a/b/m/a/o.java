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
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.e;
import kotlin.l.b.a.b.m.g;
import kotlin.m;

public final class o
  implements n
{
  private final i THR;
  private final kotlin.l.b.a.b.j.i TPt;
  
  public o(i parami)
  {
    AppMethodBeat.i(61089);
    this.THR = parami;
    parami = kotlin.l.b.a.b.j.i.f(this.THR);
    p.g(parami, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
    this.TPt = parami;
    AppMethodBeat.o(61089);
  }
  
  private static aj c(aj paramaj)
  {
    int i = 1;
    Object localObject3 = null;
    AppMethodBeat.i(61087);
    p.h(paramaj, "type");
    at localat = paramaj.hKE();
    Object localObject2;
    Object localObject1;
    if ((localat instanceof c))
    {
      localObject2 = ((c)localat).TIo;
      if (((av)localObject2).hLI() == bh.TOR) {
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
          localObject2 = ((av)localObject2).hBy();
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((ab)localObject2).hLF();
          }
        }
        if (((c)localat).TIn != null) {
          break label212;
        }
        localObject2 = (c)localat;
        localObject3 = ((c)localat).TIo;
        Object localObject4 = (Iterable)((c)localat).hBV();
        localCollection = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          localCollection.add(((ab)((Iterator)localObject4).next()).hLF());
        }
        i = 0;
        break;
        label188:
        localObject2 = null;
      }
      ((c)localObject2).TIn = new l((av)localObject3, (List)localCollection, (byte)0);
      label212:
      localObject2 = b.TPP;
      localObject3 = ((c)localat).TIn;
      if (localObject3 == null) {
        p.hyc();
      }
      paramaj = (aj)new k((b)localObject2, (l)localObject3, (bg)localObject1, paramaj.hzL(), paramaj.hEa());
      AppMethodBeat.o(61087);
      return paramaj;
    }
    if ((localat instanceof q))
    {
      localObject2 = (Iterable)((q)localat).TII;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(bc.b((ab)((Iterator)localObject2).next(), paramaj.hEa()));
      }
      localObject1 = new aa((Collection)localObject1);
      paramaj = ac.a(paramaj.hzL(), (at)localObject1, (List)kotlin.a.v.SXr, false, paramaj.hAp());
      AppMethodBeat.o(61087);
      return paramaj;
    }
    if (((localat instanceof aa)) && (paramaj.hEa()))
    {
      localObject1 = (Iterable)((aa)localat).TOe;
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
          break label535;
        }
        paramaj = (aa)localat;
      }
    }
    label535:
    for (;;)
    {
      paramaj = paramaj.hLE();
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
      if (!(parambg instanceof kotlin.l.b.a.b.m.v)) {
        break;
      }
      localObject = c(((kotlin.l.b.a.b.m.v)parambg).TNV);
      aj localaj = c(((kotlin.l.b.a.b.m.v)parambg).TNW);
      if ((localObject != ((kotlin.l.b.a.b.m.v)parambg).TNV) || (localaj != ((kotlin.l.b.a.b.m.v)parambg).TNW)) {
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
    a locala = new a(true, false, false, this.THR, 6);
    paramab1 = paramab1.hLF();
    paramab2 = paramab2.hLF();
    p.h(locala, "$this$isSubtypeOf");
    p.h(paramab1, "subType");
    p.h(paramab2, "superType");
    e locale = e.TNl;
    boolean bool = e.a((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61085);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61086);
    p.h(paramab1, "a");
    p.h(paramab2, "b");
    a locala = new a(false, false, false, this.THR, 6);
    paramab1 = paramab1.hLF();
    paramab2 = paramab2.hLF();
    p.h(locala, "$this$equalTypes");
    p.h(paramab1, "a");
    p.h(paramab2, "b");
    e locale = e.TNl;
    boolean bool = e.b((g)locala, (h)paramab1, (h)paramab2);
    AppMethodBeat.o(61086);
    return bool;
  }
  
  public final i hLM()
  {
    return this.THR;
  }
  
  public final kotlin.l.b.a.b.j.i hLN()
  {
    return this.TPt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.o
 * JD-Core Version:    0.7.0.1
 */