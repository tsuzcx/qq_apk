package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.d;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.j.b.h;
import d.l.b.a.b.j.b.k;
import d.l.b.a.b.j.b.k.a;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.m.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends a<d.l.b.a.b.b.a.c, g<?>>
{
  private final y MSC;
  private final aa MSe;
  private final d.l.b.a.b.k.a.f Niy;
  
  public c(y paramy, aa paramaa, d.l.b.a.b.l.j paramj, n paramn)
  {
    super(paramj, paramn);
    AppMethodBeat.i(58180);
    this.MSC = paramy;
    this.MSe = paramaa;
    this.Niy = new d.l.b.a.b.k.a.f(this.MSC, this.MSe);
    AppMethodBeat.o(58180);
  }
  
  protected final p.a a(d.l.b.a.b.f.a parama, final an paraman, final List<d.l.b.a.b.b.a.c> paramList)
  {
    AppMethodBeat.i(58179);
    p.h(parama, "annotationClassId");
    p.h(paraman, "source");
    p.h(paramList, "result");
    parama = (p.a)new a(this, s.a(this.MSC, parama, this.MSe), paramList, paraman);
    AppMethodBeat.o(58179);
    return parama;
  }
  
  public static final class a
    implements p.a
  {
    final HashMap<d.l.b.a.b.f.f, g<?>> Niz;
    
    a(e parame, List paramList, an paraman)
    {
      AppMethodBeat.i(58176);
      this.Niz = new HashMap();
      AppMethodBeat.o(58176);
    }
    
    static g<?> b(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58175);
      g localg = h.Nws.fs(paramObject);
      paramObject = localg;
      if (localg == null)
      {
        paramObject = k.Nwx;
        paramObject = (g)k.a.bcP("Unsupported annotation argument: ".concat(String.valueOf(paramf)));
      }
      AppMethodBeat.o(58175);
      return paramObject;
    }
    
    public final void IH()
    {
      AppMethodBeat.i(58174);
      paramList.add(new d((ab)this.NiB.giC(), (Map)this.Niz, paraman));
      AppMethodBeat.o(58174);
    }
    
    public final p.a a(final d.l.b.a.b.f.f paramf, d.l.b.a.b.f.a parama)
    {
      AppMethodBeat.i(58173);
      p.h(paramf, "name");
      p.h(parama, "classId");
      final ArrayList localArrayList = new ArrayList();
      c localc = this.NiA;
      an localan = an.MUX;
      p.g(localan, "SourceElement.NO_SOURCE");
      paramf = (p.a)new a(this, localc.a(parama, localan, (List)localArrayList), paramf, localArrayList);
      AppMethodBeat.o(58173);
      return paramf;
    }
    
    public final void a(d.l.b.a.b.f.f paramf1, d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58171);
      p.h(paramf1, "name");
      p.h(parama, "enumClassId");
      p.h(paramf2, "enumEntryName");
      ((Map)this.Niz).put(paramf1, new d.l.b.a.b.j.b.j(parama, paramf2));
      AppMethodBeat.o(58171);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58170);
      p.h(paramf, "name");
      p.h(paramf1, "value");
      ((Map)this.Niz).put(paramf, new r(paramf1));
      AppMethodBeat.o(58170);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58169);
      if (paramf != null) {
        ((Map)this.Niz).put(paramf, b(paramf, paramObject));
      }
      AppMethodBeat.o(58169);
    }
    
    public final p.b n(final d.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58172);
      p.h(paramf, "name");
      paramf = (p.b)new b(this, paramf);
      AppMethodBeat.o(58172);
      return paramf;
    }
    
    public static final class a
      implements p.a
    {
      a(p.a parama, d.l.b.a.b.f.f paramf, ArrayList paramArrayList)
      {
        this.NiD = paramf;
      }
      
      public final void IH()
      {
        AppMethodBeat.i(58158);
        this.NiF.IH();
        ((Map)this.NiE.Niz).put(paramf, new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)d.a.j.jg((List)localArrayList)));
        AppMethodBeat.o(58158);
      }
      
      public final p.a a(d.l.b.a.b.f.f paramf, d.l.b.a.b.f.a parama)
      {
        AppMethodBeat.i(58160);
        p.h(paramf, "name");
        p.h(parama, "classId");
        paramf = this.NiD.a(paramf, parama);
        AppMethodBeat.o(58160);
        return paramf;
      }
      
      public final void a(d.l.b.a.b.f.f paramf1, d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf2)
      {
        AppMethodBeat.i(58163);
        p.h(paramf1, "name");
        p.h(parama, "enumClassId");
        p.h(paramf2, "enumEntryName");
        this.NiD.a(paramf1, parama, paramf2);
        AppMethodBeat.o(58163);
      }
      
      public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
      {
        AppMethodBeat.i(58162);
        p.h(paramf, "name");
        p.h(paramf1, "value");
        this.NiD.a(paramf, paramf1);
        AppMethodBeat.o(58162);
      }
      
      public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
      {
        AppMethodBeat.i(58159);
        this.NiD.a(paramf, paramObject);
        AppMethodBeat.o(58159);
      }
      
      public final p.b n(d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58161);
        p.h(paramf, "name");
        paramf = this.NiD.n(paramf);
        AppMethodBeat.o(58161);
        return paramf;
      }
    }
    
    public static final class b
      implements p.b
    {
      private final ArrayList<g<?>> NiG;
      
      b(d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58168);
        this.NiG = new ArrayList();
        AppMethodBeat.o(58168);
      }
      
      public final void IH()
      {
        AppMethodBeat.i(58167);
        Object localObject1 = d.l.b.a.b.d.a.a.a.b(paramf, this.NiE.NiB);
        if (localObject1 != null)
        {
          Map localMap = (Map)this.NiE.Niz;
          d.l.b.a.b.f.f localf = paramf;
          Object localObject2 = h.Nws;
          localObject2 = d.l.b.a.b.o.a.bc(this.NiG);
          localObject1 = ((av)localObject1).gju();
          p.g(localObject1, "parameter.type");
          localMap.put(localf, h.a((List)localObject2, (ab)localObject1));
        }
        AppMethodBeat.o(58167);
      }
      
      public final void a(d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58165);
        p.h(parama, "enumClassId");
        p.h(paramf, "enumEntryName");
        this.NiG.add(new d.l.b.a.b.j.b.j(parama, paramf));
        AppMethodBeat.o(58165);
      }
      
      public final void a(d.l.b.a.b.j.b.f paramf)
      {
        AppMethodBeat.i(58166);
        p.h(paramf, "value");
        this.NiG.add(new r(paramf));
        AppMethodBeat.o(58166);
      }
      
      public final void fj(Object paramObject)
      {
        AppMethodBeat.i(58164);
        this.NiG.add(c.a.b(paramf, paramObject));
        AppMethodBeat.o(58164);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */