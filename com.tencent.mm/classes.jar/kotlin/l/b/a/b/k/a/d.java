package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a.a;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.c;
import kotlin.l.b.a.b.e.a.f;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.k.a;

public final class d
  implements c<kotlin.l.b.a.b.b.a.c, g<?>>
{
  private final f abnb;
  private final a abnc;
  
  public d(y paramy, aa paramaa, a parama)
  {
    AppMethodBeat.i(60278);
    this.abnc = parama;
    this.abnb = new f(paramy, paramaa);
    AppMethodBeat.o(60278);
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60275);
    p.k(paramp, "proto");
    p.k(paramc, "nameResolver");
    Object localObject = (List)paramp.d(this.abnc.abdD);
    paramp = (a.p)localObject;
    if (localObject == null) {
      paramp = (List)v.aaAd;
    }
    localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramp.add(this.abnb.b(locala, paramc));
    }
    paramp = (List)paramp;
    AppMethodBeat.o(60275);
    return paramp;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(a.r paramr, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60276);
    p.k(paramr, "proto");
    p.k(paramc, "nameResolver");
    Object localObject = (List)paramr.d(this.abnc.abdE);
    paramr = (a.r)localObject;
    if (localObject == null) {
      paramr = (List)v.aaAd;
    }
    localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramr.add(this.abnb.b(locala, paramc));
    }
    paramr = (List)paramr;
    AppMethodBeat.o(60276);
    return paramr;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(z paramz, a.f paramf)
  {
    AppMethodBeat.i(60272);
    p.k(paramz, "container");
    p.k(paramf, "proto");
    Object localObject = (List)paramf.d(this.abnc.abdB);
    paramf = (a.f)localObject;
    if (localObject == null) {
      paramf = (List)v.aaAd;
    }
    localObject = (Iterable)paramf;
    paramf = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramf.add(this.abnb.b(locala, paramz.aaCB));
    }
    paramz = (List)paramf;
    AppMethodBeat.o(60272);
    return paramz;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60270);
    p.k(paramz, "container");
    p.k(paramm, "proto");
    paramz = (List)v.aaAd;
    AppMethodBeat.o(60270);
    return paramz;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(z paramz, r paramr, b paramb)
  {
    AppMethodBeat.i(60269);
    p.k(paramz, "container");
    p.k(paramr, "proto");
    p.k(paramb, "kind");
    if ((paramr instanceof a.c)) {
      paramr = (List)((a.c)paramr).d(this.abnc.abdv);
    }
    for (;;)
    {
      paramb = paramr;
      if (paramr == null) {
        paramb = (List)v.aaAd;
      }
      paramb = (Iterable)paramb;
      paramr = (Collection)new ArrayList(j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        a.a locala = (a.a)paramb.next();
        paramr.add(this.abnb.b(locala, paramz.aaCB));
      }
      if ((paramr instanceof a.h))
      {
        paramr = (List)((a.h)paramr).d(this.abnc.abdw);
      }
      else
      {
        if (!(paramr instanceof a.m)) {
          break;
        }
        switch (e.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        default: 
          paramz = (Throwable)new IllegalStateException("Unsupported callable kind with property proto".toString());
          AppMethodBeat.o(60269);
          throw paramz;
        case 1: 
          paramr = (List)((a.m)paramr).d(this.abnc.abdx);
          break;
        case 2: 
          paramr = (List)((a.m)paramr).d(this.abnc.abdy);
          break;
        case 3: 
          paramr = (List)((a.m)paramr).d(this.abnc.abdz);
        }
      }
    }
    paramz = (Throwable)new IllegalStateException("Unknown message: ".concat(String.valueOf(paramr)).toString());
    AppMethodBeat.o(60269);
    throw paramz;
    paramz = (List)paramr;
    AppMethodBeat.o(60269);
    return paramz;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(z paramz, r paramr, b paramb, int paramInt, a.t paramt)
  {
    AppMethodBeat.i(60273);
    p.k(paramz, "container");
    p.k(paramr, "callableProto");
    p.k(paramb, "kind");
    p.k(paramt, "proto");
    paramb = (List)paramt.d(this.abnc.abdC);
    paramr = paramb;
    if (paramb == null) {
      paramr = (List)v.aaAd;
    }
    paramb = (Iterable)paramr;
    paramr = (Collection)new ArrayList(j.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      paramt = (a.a)paramb.next();
      paramr.add(this.abnb.b(paramt, paramz.aaCB));
    }
    paramz = (List)paramr;
    AppMethodBeat.o(60273);
    return paramz;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(z.a parama)
  {
    AppMethodBeat.i(60268);
    p.k(parama, "container");
    Object localObject2 = (List)parama.abnd.d(this.abnc.abdu);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.aaAd;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.abnb.b(locala, parama.aaCB));
    }
    parama = (List)localObject1;
    AppMethodBeat.o(60268);
    return parama;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60271);
    p.k(paramz, "container");
    p.k(paramm, "proto");
    paramz = (List)v.aaAd;
    AppMethodBeat.o(60271);
    return paramz;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(z paramz, r paramr, b paramb)
  {
    AppMethodBeat.i(60274);
    p.k(paramz, "container");
    p.k(paramr, "proto");
    p.k(paramb, "kind");
    paramz = (List)v.aaAd;
    AppMethodBeat.o(60274);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.d
 * JD-Core Version:    0.7.0.1
 */