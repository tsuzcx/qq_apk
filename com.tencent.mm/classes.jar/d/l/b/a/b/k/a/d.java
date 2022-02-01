package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.y;
import d.l.b.a.b.e.a.a;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.a.c;
import d.l.b.a.b.e.a.f;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.a.t;
import d.l.b.a.b.h.q;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
  implements c<d.l.b.a.b.b.a.c, g<?>>
{
  private final f Nyv;
  private final a Nyw;
  
  public d(y paramy, aa paramaa, a parama)
  {
    AppMethodBeat.i(60278);
    this.Nyw = parama;
    this.Nyv = new f(paramy, paramaa);
    AppMethodBeat.o(60278);
  }
  
  public final List<d.l.b.a.b.b.a.c> a(a.p paramp, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60275);
    p.h(paramp, "proto");
    p.h(paramc, "nameResolver");
    Object localObject = (List)paramp.e(this.Nyw.Noe);
    paramp = (a.p)localObject;
    if (localObject == null) {
      paramp = (List)v.MKE;
    }
    localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramp.add(this.Nyv.b(locala, paramc));
    }
    paramp = (List)paramp;
    AppMethodBeat.o(60275);
    return paramp;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(a.r paramr, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60276);
    p.h(paramr, "proto");
    p.h(paramc, "nameResolver");
    Object localObject = (List)paramr.e(this.Nyw.Nof);
    paramr = (a.r)localObject;
    if (localObject == null) {
      paramr = (List)v.MKE;
    }
    localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramr.add(this.Nyv.b(locala, paramc));
    }
    paramr = (List)paramr;
    AppMethodBeat.o(60276);
    return paramr;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, a.f paramf)
  {
    AppMethodBeat.i(60272);
    p.h(paramz, "container");
    p.h(paramf, "proto");
    Object localObject = (List)paramf.e(this.Nyw.Noc);
    paramf = (a.f)localObject;
    if (localObject == null) {
      paramf = (List)v.MKE;
    }
    localObject = (Iterable)paramf;
    paramf = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramf.add(this.Nyv.b(locala, paramz.MMU));
    }
    paramz = (List)paramf;
    AppMethodBeat.o(60272);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60270);
    p.h(paramz, "container");
    p.h(paramm, "proto");
    paramz = (List)v.MKE;
    AppMethodBeat.o(60270);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, q paramq, b paramb)
  {
    AppMethodBeat.i(60269);
    p.h(paramz, "container");
    p.h(paramq, "proto");
    p.h(paramb, "kind");
    if ((paramq instanceof a.c)) {
      paramq = (List)((a.c)paramq).e(this.Nyw.NnW);
    }
    for (;;)
    {
      paramb = paramq;
      if (paramq == null) {
        paramb = (List)v.MKE;
      }
      paramb = (Iterable)paramb;
      paramq = (Collection)new ArrayList(j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        a.a locala = (a.a)paramb.next();
        paramq.add(this.Nyv.b(locala, paramz.MMU));
      }
      if ((paramq instanceof a.h))
      {
        paramq = (List)((a.h)paramq).e(this.Nyw.NnX);
      }
      else
      {
        if (!(paramq instanceof a.m)) {
          break;
        }
        switch (e.cpQ[paramb.ordinal()])
        {
        default: 
          paramz = (Throwable)new IllegalStateException("Unsupported callable kind with property proto".toString());
          AppMethodBeat.o(60269);
          throw paramz;
        case 1: 
          paramq = (List)((a.m)paramq).e(this.Nyw.NnY);
          break;
        case 2: 
          paramq = (List)((a.m)paramq).e(this.Nyw.NnZ);
          break;
        case 3: 
          paramq = (List)((a.m)paramq).e(this.Nyw.Noa);
        }
      }
    }
    paramz = (Throwable)new IllegalStateException("Unknown message: ".concat(String.valueOf(paramq)).toString());
    AppMethodBeat.o(60269);
    throw paramz;
    paramz = (List)paramq;
    AppMethodBeat.o(60269);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, q paramq, b paramb, int paramInt, a.t paramt)
  {
    AppMethodBeat.i(60273);
    p.h(paramz, "container");
    p.h(paramq, "callableProto");
    p.h(paramb, "kind");
    p.h(paramt, "proto");
    paramb = (List)paramt.e(this.Nyw.Nod);
    paramq = paramb;
    if (paramb == null) {
      paramq = (List)v.MKE;
    }
    paramb = (Iterable)paramq;
    paramq = (Collection)new ArrayList(j.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      paramt = (a.a)paramb.next();
      paramq.add(this.Nyv.b(paramt, paramz.MMU));
    }
    paramz = (List)paramq;
    AppMethodBeat.o(60273);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z.a parama)
  {
    AppMethodBeat.i(60268);
    p.h(parama, "container");
    Object localObject2 = (List)parama.Nyx.e(this.Nyw.NnV);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.MKE;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.Nyv.b(locala, parama.MMU));
    }
    parama = (List)localObject1;
    AppMethodBeat.o(60268);
    return parama;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60271);
    p.h(paramz, "container");
    p.h(paramm, "proto");
    paramz = (List)v.MKE;
    AppMethodBeat.o(60271);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z paramz, q paramq, b paramb)
  {
    AppMethodBeat.i(60274);
    p.h(paramz, "container");
    p.h(paramq, "proto");
    p.h(paramb, "kind");
    paramz = (List)v.MKE;
    AppMethodBeat.o(60274);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.d
 * JD-Core Version:    0.7.0.1
 */