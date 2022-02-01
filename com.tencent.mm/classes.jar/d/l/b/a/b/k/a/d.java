package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.g.b.k;
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
  private final f LHx;
  private final a LHy;
  
  public d(y paramy, aa paramaa, a parama)
  {
    AppMethodBeat.i(60278);
    this.LHy = parama;
    this.LHx = new f(paramy, paramaa);
    AppMethodBeat.o(60278);
  }
  
  public final List<d.l.b.a.b.b.a.c> a(a.p paramp, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60275);
    k.h(paramp, "proto");
    k.h(paramc, "nameResolver");
    Object localObject = (List)paramp.e(this.LHy.Lxh);
    paramp = (a.p)localObject;
    if (localObject == null) {
      paramp = (List)v.KTF;
    }
    localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramp.add(this.LHx.b(locala, paramc));
    }
    paramp = (List)paramp;
    AppMethodBeat.o(60275);
    return paramp;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(a.r paramr, d.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60276);
    k.h(paramr, "proto");
    k.h(paramc, "nameResolver");
    Object localObject = (List)paramr.e(this.LHy.Lxi);
    paramr = (a.r)localObject;
    if (localObject == null) {
      paramr = (List)v.KTF;
    }
    localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramr.add(this.LHx.b(locala, paramc));
    }
    paramr = (List)paramr;
    AppMethodBeat.o(60276);
    return paramr;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, a.f paramf)
  {
    AppMethodBeat.i(60272);
    k.h(paramz, "container");
    k.h(paramf, "proto");
    Object localObject = (List)paramf.e(this.LHy.Lxf);
    paramf = (a.f)localObject;
    if (localObject == null) {
      paramf = (List)v.KTF;
    }
    localObject = (Iterable)paramf;
    paramf = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramf.add(this.LHx.b(locala, paramz.KVO));
    }
    paramz = (List)paramf;
    AppMethodBeat.o(60272);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60270);
    k.h(paramz, "container");
    k.h(paramm, "proto");
    paramz = (List)v.KTF;
    AppMethodBeat.o(60270);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> a(z paramz, q paramq, b paramb)
  {
    AppMethodBeat.i(60269);
    k.h(paramz, "container");
    k.h(paramq, "proto");
    k.h(paramb, "kind");
    if ((paramq instanceof a.c)) {
      paramq = (List)((a.c)paramq).e(this.LHy.LwZ);
    }
    for (;;)
    {
      paramb = paramq;
      if (paramq == null) {
        paramb = (List)v.KTF;
      }
      paramb = (Iterable)paramb;
      paramq = (Collection)new ArrayList(j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        a.a locala = (a.a)paramb.next();
        paramq.add(this.LHx.b(locala, paramz.KVO));
      }
      if ((paramq instanceof a.h))
      {
        paramq = (List)((a.h)paramq).e(this.LHy.Lxa);
      }
      else
      {
        if (!(paramq instanceof a.m)) {
          break;
        }
        switch (e.cfA[paramb.ordinal()])
        {
        default: 
          paramz = (Throwable)new IllegalStateException("Unsupported callable kind with property proto".toString());
          AppMethodBeat.o(60269);
          throw paramz;
        case 1: 
          paramq = (List)((a.m)paramq).e(this.LHy.Lxb);
          break;
        case 2: 
          paramq = (List)((a.m)paramq).e(this.LHy.Lxc);
          break;
        case 3: 
          paramq = (List)((a.m)paramq).e(this.LHy.Lxd);
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
    k.h(paramz, "container");
    k.h(paramq, "callableProto");
    k.h(paramb, "kind");
    k.h(paramt, "proto");
    paramb = (List)paramt.e(this.LHy.Lxg);
    paramq = paramb;
    if (paramb == null) {
      paramq = (List)v.KTF;
    }
    paramb = (Iterable)paramq;
    paramq = (Collection)new ArrayList(j.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      paramt = (a.a)paramb.next();
      paramq.add(this.LHx.b(paramt, paramz.KVO));
    }
    paramz = (List)paramq;
    AppMethodBeat.o(60273);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z.a parama)
  {
    AppMethodBeat.i(60268);
    k.h(parama, "container");
    Object localObject2 = (List)parama.LHz.e(this.LHy.LwY);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.KTF;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.LHx.b(locala, parama.KVO));
    }
    parama = (List)localObject1;
    AppMethodBeat.o(60268);
    return parama;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z paramz, a.m paramm)
  {
    AppMethodBeat.i(60271);
    k.h(paramz, "container");
    k.h(paramm, "proto");
    paramz = (List)v.KTF;
    AppMethodBeat.o(60271);
    return paramz;
  }
  
  public final List<d.l.b.a.b.b.a.c> b(z paramz, q paramq, b paramb)
  {
    AppMethodBeat.i(60274);
    k.h(paramz, "container");
    k.h(paramq, "proto");
    k.h(paramb, "kind");
    paramz = (List)v.KTF;
    AppMethodBeat.o(60274);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.d
 * JD-Core Version:    0.7.0.1
 */