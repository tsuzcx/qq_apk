package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.d;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.h;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.k.a;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.m.ab;

public final class c
  extends a<kotlin.l.b.a.b.b.a.c, g<?>>
{
  private final aa aaHL;
  private final y aaIj;
  private final kotlin.l.b.a.b.k.a.f aaYd;
  
  public c(y paramy, aa paramaa, kotlin.l.b.a.b.l.j paramj, n paramn)
  {
    super(paramj, paramn);
    AppMethodBeat.i(58180);
    this.aaIj = paramy;
    this.aaHL = paramaa;
    this.aaYd = new kotlin.l.b.a.b.k.a.f(this.aaIj, this.aaHL);
    AppMethodBeat.o(58180);
  }
  
  protected final p.a a(kotlin.l.b.a.b.f.a parama, final an paraman, final List<kotlin.l.b.a.b.b.a.c> paramList)
  {
    AppMethodBeat.i(58179);
    p.k(parama, "annotationClassId");
    p.k(paraman, "source");
    p.k(paramList, "result");
    parama = (p.a)new a(this, s.a(this.aaIj, parama, this.aaHL), paramList, paraman);
    AppMethodBeat.o(58179);
    return parama;
  }
  
  public static final class a
    implements p.a
  {
    final HashMap<kotlin.l.b.a.b.f.f, g<?>> aaYe;
    
    a(e parame, List paramList, an paraman)
    {
      AppMethodBeat.i(58176);
      this.aaYe = new HashMap();
      AppMethodBeat.o(58176);
    }
    
    static g<?> b(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58175);
      g localg = h.abkY.fF(paramObject);
      paramObject = localg;
      if (localg == null)
      {
        paramObject = k.abld;
        paramObject = (g)k.a.bHk("Unsupported annotation argument: ".concat(String.valueOf(paramf)));
      }
      AppMethodBeat.o(58175);
      return paramObject;
    }
    
    public final void XJ()
    {
      AppMethodBeat.i(58174);
      paramList.add(new d((ab)this.aaYg.iET(), (Map)this.aaYe, paraman));
      AppMethodBeat.o(58174);
    }
    
    public final p.a a(final kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.a parama)
    {
      AppMethodBeat.i(58173);
      p.k(paramf, "name");
      p.k(parama, "classId");
      final ArrayList localArrayList = new ArrayList();
      c localc = this.aaYf;
      an localan = an.aaKE;
      p.j(localan, "SourceElement.NO_SOURCE");
      paramf = (p.a)new a(this, localc.a(parama, localan, (List)localArrayList), paramf, localArrayList);
      AppMethodBeat.o(58173);
      return paramf;
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58169);
      if (paramf != null) {
        ((Map)this.aaYe).put(paramf, b(paramf, paramObject));
      }
      AppMethodBeat.o(58169);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.a parama, kotlin.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58171);
      p.k(paramf1, "name");
      p.k(parama, "enumClassId");
      p.k(paramf2, "enumEntryName");
      ((Map)this.aaYe).put(paramf1, new kotlin.l.b.a.b.j.b.j(parama, paramf2));
      AppMethodBeat.o(58171);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58170);
      p.k(paramf, "name");
      p.k(paramf1, "value");
      ((Map)this.aaYe).put(paramf, new r(paramf1));
      AppMethodBeat.o(58170);
    }
    
    public final p.b n(final kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58172);
      p.k(paramf, "name");
      paramf = (p.b)new b(this, paramf);
      AppMethodBeat.o(58172);
      return paramf;
    }
    
    public static final class a
      implements p.a
    {
      a(p.a parama, kotlin.l.b.a.b.f.f paramf, ArrayList paramArrayList)
      {
        this.aaYi = paramf;
      }
      
      public final void XJ()
      {
        AppMethodBeat.i(58158);
        this.aaYk.XJ();
        ((Map)this.aaYj.aaYe).put(paramf, new kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a.c)kotlin.a.j.ls((List)localArrayList)));
        AppMethodBeat.o(58158);
      }
      
      public final p.a a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.a parama)
      {
        AppMethodBeat.i(58160);
        p.k(paramf, "name");
        p.k(parama, "classId");
        paramf = this.aaYi.a(paramf, parama);
        AppMethodBeat.o(58160);
        return paramf;
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
      {
        AppMethodBeat.i(58159);
        this.aaYi.a(paramf, paramObject);
        AppMethodBeat.o(58159);
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.a parama, kotlin.l.b.a.b.f.f paramf2)
      {
        AppMethodBeat.i(58163);
        p.k(paramf1, "name");
        p.k(parama, "enumClassId");
        p.k(paramf2, "enumEntryName");
        this.aaYi.a(paramf1, parama, paramf2);
        AppMethodBeat.o(58163);
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
      {
        AppMethodBeat.i(58162);
        p.k(paramf, "name");
        p.k(paramf1, "value");
        this.aaYi.a(paramf, paramf1);
        AppMethodBeat.o(58162);
      }
      
      public final p.b n(kotlin.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58161);
        p.k(paramf, "name");
        paramf = this.aaYi.n(paramf);
        AppMethodBeat.o(58161);
        return paramf;
      }
    }
    
    public static final class b
      implements p.b
    {
      private final ArrayList<g<?>> aaYl;
      
      b(kotlin.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58168);
        this.aaYl = new ArrayList();
        AppMethodBeat.o(58168);
      }
      
      public final void XJ()
      {
        AppMethodBeat.i(58167);
        Object localObject1 = kotlin.l.b.a.b.d.a.a.a.b(paramf, this.aaYj.aaYg);
        if (localObject1 != null)
        {
          Map localMap = (Map)this.aaYj.aaYe;
          kotlin.l.b.a.b.f.f localf = paramf;
          Object localObject2 = h.abkY;
          localObject2 = kotlin.l.b.a.b.o.a.bN(this.aaYl);
          localObject1 = ((av)localObject1).iFN();
          p.j(localObject1, "parameter.type");
          localMap.put(localf, h.a((List)localObject2, (ab)localObject1));
        }
        AppMethodBeat.o(58167);
      }
      
      public final void a(kotlin.l.b.a.b.f.a parama, kotlin.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58165);
        p.k(parama, "enumClassId");
        p.k(paramf, "enumEntryName");
        this.aaYl.add(new kotlin.l.b.a.b.j.b.j(parama, paramf));
        AppMethodBeat.o(58165);
      }
      
      public final void a(kotlin.l.b.a.b.j.b.f paramf)
      {
        AppMethodBeat.i(58166);
        p.k(paramf, "value");
        this.aaYl.add(new r(paramf));
        AppMethodBeat.o(58166);
      }
      
      public final void fy(Object paramObject)
      {
        AppMethodBeat.i(58164);
        this.aaYl.add(c.a.b(paramf, paramObject));
        AppMethodBeat.o(58164);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */