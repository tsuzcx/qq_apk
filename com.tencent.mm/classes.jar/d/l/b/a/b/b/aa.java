package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.a.v;
import d.a.x;
import d.g.b.k;
import d.k.h;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.c.m;
import d.l.b.a.b.l.c;
import d.l.b.a.b.l.i;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  final i JlL;
  final y Jon;
  final c<d.l.b.a.b.f.b, ab> Jqt;
  private final c<aa.a, e> Jqu;
  
  public aa(i parami, y paramy)
  {
    AppMethodBeat.i(56877);
    this.JlL = parami;
    this.Jon = paramy;
    this.Jqt = this.JlL.A((d.g.a.b)new d(this));
    this.Jqu = this.JlL.A((d.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(d.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    k.h(parama, "classId");
    k.h(paramList, "typeParametersCount");
    parama = (e)this.Jqu.aA(new aa.a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  public static final class b
    extends d.l.b.a.b.b.c.g
  {
    private final List<as> Jqw;
    private final d.l.b.a.b.m.j Jqx;
    private final boolean Jqy;
    
    public b(i parami, l paraml, d.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.JqJ);
      AppMethodBeat.i(56873);
      this.Jqy = paramBoolean;
      paramf = (Iterable)h.kJ(0, paramInt);
      paraml = (Collection)new ArrayList(d.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((d.a.ab)paramf).nextInt();
        l locall = (l)this;
        g.a locala = d.l.b.a.b.b.a.g.JrB;
        paraml.add(ai.a(locall, g.a.fzI(), bh.JYC, d.l.b.a.b.f.f.aQC("T".concat(String.valueOf(paramInt))), paramInt));
      }
      this.Jqw = ((List)paraml);
      this.Jqx = new d.l.b.a.b.m.j((e)this, this.Jqw, (Collection)ak.setOf(d.l.b.a.b.j.d.a.F(this).fza().fxb()), parami);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> fvR()
    {
      return (Collection)x.Jgn;
    }
    
    public final boolean fxA()
    {
      return false;
    }
    
    public final boolean fxB()
    {
      return false;
    }
    
    public final boolean fxC()
    {
      return false;
    }
    
    public final boolean fxD()
    {
      return false;
    }
    
    public final boolean fxE()
    {
      return false;
    }
    
    public final d.l.b.a.b.b.a.g fxF()
    {
      AppMethodBeat.i(56870);
      Object localObject = d.l.b.a.b.b.a.g.JrB;
      localObject = g.a.fzI();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> fxH()
    {
      return (Collection)v.Jgl;
    }
    
    public final List<as> fxI()
    {
      return this.Jqw;
    }
    
    public final e fxt()
    {
      return null;
    }
    
    public final f fxu()
    {
      return f.Jqd;
    }
    
    public final w fxv()
    {
      return w.Jqn;
    }
    
    public final d fxw()
    {
      return null;
    }
    
    public final ba fxx()
    {
      AppMethodBeat.i(56869);
      ba localba = az.JqT;
      k.g(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final boolean fxy()
    {
      return false;
    }
    
    public final boolean fxz()
    {
      return this.Jqy;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + fyB() + " (not found)";
      AppMethodBeat.o(56872);
      return str;
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.b<aa.a, aa.b>
  {
    c(aa paramaa)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
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