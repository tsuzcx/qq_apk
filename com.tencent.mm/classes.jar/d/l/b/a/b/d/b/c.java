package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.d;
import d.l.b.a.b.b.aa;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.j.b.h;
import d.l.b.a.b.j.b.k.a;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.l.i;
import d.l.b.a.b.m.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends a<d.l.b.a.b.b.a.c, g<?>>
{
  private final d.l.b.a.b.k.a.f JEi;
  private final aa JnP;
  private final y Jon;
  
  public c(y paramy, aa paramaa, i parami, n paramn)
  {
    super(parami, paramn);
    AppMethodBeat.i(58180);
    this.Jon = paramy;
    this.JnP = paramaa;
    this.JEi = new d.l.b.a.b.k.a.f(this.Jon, this.JnP);
    AppMethodBeat.o(58180);
  }
  
  protected final p.a a(d.l.b.a.b.f.a parama, final an paraman, final List<d.l.b.a.b.b.a.c> paramList)
  {
    AppMethodBeat.i(58179);
    d.g.b.k.h(parama, "annotationClassId");
    d.g.b.k.h(paraman, "source");
    d.g.b.k.h(paramList, "result");
    parama = (p.a)new a(this, s.a(this.Jon, parama, this.JnP), paramList, paraman);
    AppMethodBeat.o(58179);
    return parama;
  }
  
  public static final class a
    implements p.a
  {
    final HashMap<d.l.b.a.b.f.f, g<?>> JEj;
    
    a(e parame, List paramList, an paraman)
    {
      AppMethodBeat.i(58176);
      this.JEj = new HashMap();
      AppMethodBeat.o(58176);
    }
    
    static g<?> b(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58175);
      g localg = h.JSb.fn(paramObject);
      paramObject = localg;
      if (localg == null)
      {
        paramObject = d.l.b.a.b.j.b.k.JSg;
        paramObject = (g)k.a.aQN("Unsupported annotation argument: ".concat(String.valueOf(paramf)));
      }
      AppMethodBeat.o(58175);
      return paramObject;
    }
    
    public final void HB()
    {
      AppMethodBeat.i(58174);
      paramList.add(new d((ab)this.JEl.fyA(), (Map)this.JEj, paraman));
      AppMethodBeat.o(58174);
    }
    
    public final p.a a(final d.l.b.a.b.f.f paramf, d.l.b.a.b.f.a parama)
    {
      AppMethodBeat.i(58173);
      d.g.b.k.h(paramf, "name");
      d.g.b.k.h(parama, "classId");
      final ArrayList localArrayList = new ArrayList();
      c localc = this.JEk;
      an localan = an.JqJ;
      d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
      paramf = (p.a)new a(this, localc.a(parama, localan, (List)localArrayList), paramf, localArrayList);
      AppMethodBeat.o(58173);
      return paramf;
    }
    
    public final void a(d.l.b.a.b.f.f paramf1, d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58171);
      d.g.b.k.h(paramf1, "name");
      d.g.b.k.h(parama, "enumClassId");
      d.g.b.k.h(paramf2, "enumEntryName");
      ((Map)this.JEj).put(paramf1, new d.l.b.a.b.j.b.j(parama, paramf2));
      AppMethodBeat.o(58171);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58170);
      d.g.b.k.h(paramf, "name");
      d.g.b.k.h(paramf1, "value");
      ((Map)this.JEj).put(paramf, new r(paramf1));
      AppMethodBeat.o(58170);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58169);
      if (paramf != null) {
        ((Map)this.JEj).put(paramf, b(paramf, paramObject));
      }
      AppMethodBeat.o(58169);
    }
    
    public final p.b n(final d.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58172);
      d.g.b.k.h(paramf, "name");
      paramf = (p.b)new b(this, paramf);
      AppMethodBeat.o(58172);
      return paramf;
    }
    
    public static final class a
      implements p.a
    {
      a(p.a parama, d.l.b.a.b.f.f paramf, ArrayList paramArrayList)
      {
        this.JEn = paramf;
      }
      
      public final void HB()
      {
        AppMethodBeat.i(58158);
        this.JEp.HB();
        ((Map)this.JEo.JEj).put(paramf, new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)d.a.j.iC((List)localArrayList)));
        AppMethodBeat.o(58158);
      }
      
      public final p.a a(d.l.b.a.b.f.f paramf, d.l.b.a.b.f.a parama)
      {
        AppMethodBeat.i(58160);
        d.g.b.k.h(paramf, "name");
        d.g.b.k.h(parama, "classId");
        paramf = this.JEn.a(paramf, parama);
        AppMethodBeat.o(58160);
        return paramf;
      }
      
      public final void a(d.l.b.a.b.f.f paramf1, d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf2)
      {
        AppMethodBeat.i(58163);
        d.g.b.k.h(paramf1, "name");
        d.g.b.k.h(parama, "enumClassId");
        d.g.b.k.h(paramf2, "enumEntryName");
        this.JEn.a(paramf1, parama, paramf2);
        AppMethodBeat.o(58163);
      }
      
      public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
      {
        AppMethodBeat.i(58162);
        d.g.b.k.h(paramf, "name");
        d.g.b.k.h(paramf1, "value");
        this.JEn.a(paramf, paramf1);
        AppMethodBeat.o(58162);
      }
      
      public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
      {
        AppMethodBeat.i(58159);
        this.JEn.a(paramf, paramObject);
        AppMethodBeat.o(58159);
      }
      
      public final p.b n(d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58161);
        d.g.b.k.h(paramf, "name");
        paramf = this.JEn.n(paramf);
        AppMethodBeat.o(58161);
        return paramf;
      }
    }
    
    public static final class b
      implements p.b
    {
      private final ArrayList<g<?>> JEq;
      
      b(d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58168);
        this.JEq = new ArrayList();
        AppMethodBeat.o(58168);
      }
      
      public final void HB()
      {
        AppMethodBeat.i(58167);
        Object localObject1 = d.l.b.a.b.d.a.a.a.b(paramf, this.JEo.JEl);
        if (localObject1 != null)
        {
          Map localMap = (Map)this.JEo.JEj;
          d.l.b.a.b.f.f localf = paramf;
          Object localObject2 = h.JSb;
          localObject2 = d.l.b.a.b.o.a.aT(this.JEq);
          localObject1 = ((av)localObject1).fzr();
          d.g.b.k.g(localObject1, "parameter.type");
          localMap.put(localf, h.a((List)localObject2, (ab)localObject1));
        }
        AppMethodBeat.o(58167);
      }
      
      public final void a(d.l.b.a.b.f.a parama, d.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58165);
        d.g.b.k.h(parama, "enumClassId");
        d.g.b.k.h(paramf, "enumEntryName");
        this.JEq.add(new d.l.b.a.b.j.b.j(parama, paramf));
        AppMethodBeat.o(58165);
      }
      
      public final void a(d.l.b.a.b.j.b.f paramf)
      {
        AppMethodBeat.i(58166);
        d.g.b.k.h(paramf, "value");
        this.JEq.add(new r(paramf));
        AppMethodBeat.o(58166);
      }
      
      public final void fe(Object paramObject)
      {
        AppMethodBeat.i(58164);
        this.JEq.add(c.a.b(paramf, paramObject));
        AppMethodBeat.o(58164);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */