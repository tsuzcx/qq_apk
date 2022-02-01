package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.a.v;
import d.a.x;
import d.g.b.p;
import d.g.b.q;
import d.k.h;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.c.m;
import d.l.b.a.b.l.c;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  final d.l.b.a.b.l.j MQa;
  final y MSC;
  final c<d.l.b.a.b.f.b, ab> MUH;
  private final c<aa.a, e> MUI;
  
  public aa(d.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56877);
    this.MQa = paramj;
    this.MSC = paramy;
    this.MUH = this.MQa.I((d.g.a.b)new d(this));
    this.MUI = this.MQa.I((d.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(d.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    p.h(parama, "classId");
    p.h(paramList, "typeParametersCount");
    parama = (e)this.MUI.invoke(new aa.a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  public static final class b
    extends d.l.b.a.b.b.c.g
  {
    private final List<as> MUK;
    private final d.l.b.a.b.m.j MUL;
    private final boolean MUM;
    
    public b(d.l.b.a.b.l.j paramj, l paraml, d.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.MUX);
      AppMethodBeat.i(56873);
      this.MUM = paramBoolean;
      paramf = (Iterable)h.lo(0, paramInt);
      paraml = (Collection)new ArrayList(d.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((d.a.ab)paramf).nextInt();
        l locall = (l)this;
        g.a locala = d.l.b.a.b.b.a.g.MVP;
        paraml.add(ai.a(locall, g.a.gjL(), bh.NCP, d.l.b.a.b.f.f.bcE("T".concat(String.valueOf(paramInt))), paramInt, paramj));
      }
      this.MUK = ((List)paraml);
      this.MUL = new d.l.b.a.b.m.j((e)this, this.MUK, (Collection)ak.setOf(d.l.b.a.b.j.d.a.F(this).gjd().ghd()), paramj);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> gfV()
    {
      return (Collection)x.MKG;
    }
    
    public final boolean ghA()
    {
      return false;
    }
    
    public final boolean ghB()
    {
      return this.MUM;
    }
    
    public final boolean ghC()
    {
      return false;
    }
    
    public final boolean ghD()
    {
      return false;
    }
    
    public final boolean ghE()
    {
      return false;
    }
    
    public final boolean ghF()
    {
      return false;
    }
    
    public final boolean ghG()
    {
      return false;
    }
    
    public final d.l.b.a.b.b.a.g ghH()
    {
      AppMethodBeat.i(56870);
      Object localObject = d.l.b.a.b.b.a.g.MVP;
      localObject = g.a.gjL();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> ghJ()
    {
      return (Collection)v.MKE;
    }
    
    public final List<as> ghK()
    {
      return this.MUK;
    }
    
    public final e ghv()
    {
      return null;
    }
    
    public final f ghw()
    {
      return f.MUr;
    }
    
    public final w ghx()
    {
      return w.MUB;
    }
    
    public final d ghy()
    {
      return null;
    }
    
    public final ba ghz()
    {
      AppMethodBeat.i(56869);
      ba localba = az.MVh;
      p.g(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + giD() + " (not found)";
      AppMethodBeat.o(56872);
      return str;
    }
  }
  
  static final class c
    extends q
    implements d.g.a.b<aa.a, aa.b>
  {
    c(aa paramaa)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<d.l.b.a.b.f.b, m>
  {
    d(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.aa
 * JD-Core Version:    0.7.0.1
 */