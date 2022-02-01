package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ag;
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
  private final a ajlK;
  private final e ajlL;
  
  public d(ae paramae, ag paramag, a parama)
  {
    AppMethodBeat.i(60278);
    this.ajlK = parama;
    this.ajlL = new e(paramae, paramag);
    AppMethodBeat.o(60278);
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60275);
    s.u(paramp, "proto");
    s.u(paramc, "nameResolver");
    Object localObject = (List)paramp.e(this.ajlK.ajce);
    paramp = (a.p)localObject;
    if (localObject == null) {
      paramp = (List)ab.aivy;
    }
    localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramp.add(this.ajlL.b(locala, paramc));
    }
    paramp = (List)paramp;
    AppMethodBeat.o(60275);
    return paramp;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(a.r paramr, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(60276);
    s.u(paramr, "proto");
    s.u(paramc, "nameResolver");
    Object localObject = (List)paramr.e(this.ajlK.ajcf);
    paramr = (a.r)localObject;
    if (localObject == null) {
      paramr = (List)ab.aivy;
    }
    localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramr.add(this.ajlL.b(locala, paramc));
    }
    paramr = (List)paramr;
    AppMethodBeat.o(60276);
    return paramr;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(y paramy, a.f paramf)
  {
    AppMethodBeat.i(60272);
    s.u(paramy, "container");
    s.u(paramf, "proto");
    Object localObject = (List)paramf.e(this.ajlK.ajcc);
    paramf = (a.f)localObject;
    if (localObject == null) {
      paramf = (List)ab.aivy;
    }
    localObject = (Iterable)paramf;
    paramf = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      paramf.add(this.ajlL.b(locala, paramy.aiyk));
    }
    paramy = (List)paramf;
    AppMethodBeat.o(60272);
    return paramy;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(y paramy, a.m paramm)
  {
    AppMethodBeat.i(60270);
    s.u(paramy, "container");
    s.u(paramm, "proto");
    paramy = (List)ab.aivy;
    AppMethodBeat.o(60270);
    return paramy;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(y paramy, r paramr, b paramb)
  {
    AppMethodBeat.i(60269);
    s.u(paramy, "container");
    s.u(paramr, "proto");
    s.u(paramb, "kind");
    if ((paramr instanceof a.c)) {
      paramr = (List)((a.c)paramr).e(this.ajlK.ajbW);
    }
    for (;;)
    {
      paramb = paramr;
      if (paramr == null) {
        paramb = (List)ab.aivy;
      }
      paramb = (Iterable)paramb;
      paramr = (Collection)new ArrayList(p.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        a.a locala = (a.a)paramb.next();
        paramr.add(this.ajlL.b(locala, paramy.aiyk));
      }
      if ((paramr instanceof a.h))
      {
        paramr = (List)((a.h)paramr).e(this.ajlK.ajbX);
      }
      else
      {
        if (!(paramr instanceof a.m)) {
          break;
        }
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        default: 
          paramy = (Throwable)new IllegalStateException("Unsupported callable kind with property proto".toString());
          AppMethodBeat.o(60269);
          throw paramy;
        case 1: 
          paramr = (List)((a.m)paramr).e(this.ajlK.ajbY);
          break;
        case 2: 
          paramr = (List)((a.m)paramr).e(this.ajlK.ajbZ);
          break;
        case 3: 
          paramr = (List)((a.m)paramr).e(this.ajlK.ajca);
        }
      }
    }
    paramy = (Throwable)new IllegalStateException(s.X("Unknown message: ", paramr).toString());
    AppMethodBeat.o(60269);
    throw paramy;
    paramy = (List)paramr;
    AppMethodBeat.o(60269);
    return paramy;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> a(y paramy, r paramr, b paramb, int paramInt, a.t paramt)
  {
    AppMethodBeat.i(60273);
    s.u(paramy, "container");
    s.u(paramr, "callableProto");
    s.u(paramb, "kind");
    s.u(paramt, "proto");
    paramb = (List)paramt.e(this.ajlK.ajcd);
    paramr = paramb;
    if (paramb == null) {
      paramr = (List)ab.aivy;
    }
    paramb = (Iterable)paramr;
    paramr = (Collection)new ArrayList(p.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      paramt = (a.a)paramb.next();
      paramr.add(this.ajlL.b(paramt, paramy.aiyk));
    }
    paramy = (List)paramr;
    AppMethodBeat.o(60273);
    return paramy;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(y.a parama)
  {
    AppMethodBeat.i(60268);
    s.u(parama, "container");
    Object localObject2 = (List)parama.ajlM.e(this.ajlK.ajbV);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)ab.aivy;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.ajlL.b(locala, parama.aiyk));
    }
    parama = (List)localObject1;
    AppMethodBeat.o(60268);
    return parama;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(y paramy, a.m paramm)
  {
    AppMethodBeat.i(60271);
    s.u(paramy, "container");
    s.u(paramm, "proto");
    paramy = (List)ab.aivy;
    AppMethodBeat.o(60271);
    return paramy;
  }
  
  public final List<kotlin.l.b.a.b.b.a.c> b(y paramy, r paramr, b paramb)
  {
    AppMethodBeat.i(60274);
    s.u(paramy, "container");
    s.u(paramr, "proto");
    s.u(paramb, "kind");
    paramy = (List)ab.aivy;
    AppMethodBeat.o(60274);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.d
 * JD-Core Version:    0.7.0.1
 */