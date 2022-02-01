package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.a.v;
import d.a.x;
import d.g.b.p;
import d.g.b.q;
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
  final d.l.b.a.b.l.j Nnf;
  final y NpH;
  final c<d.l.b.a.b.f.b, ab> NrM;
  private final c<a, e> NrN;
  
  public aa(d.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56877);
    this.Nnf = paramj;
    this.NpH = paramy;
    this.NrM = this.Nnf.L((d.g.a.b)new d(this));
    this.NrN = this.Nnf.L((d.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(d.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    p.h(parama, "classId");
    p.h(paramList, "typeParametersCount");
    parama = (e)this.NrN.invoke(new a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  static final class a
  {
    final d.l.b.a.b.f.a NpB;
    final List<Integer> NrO;
    
    public a(d.l.b.a.b.f.a parama, List<Integer> paramList)
    {
      AppMethodBeat.i(56865);
      this.NpB = parama;
      this.NrO = paramList;
      AppMethodBeat.o(56865);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(56868);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.i(this.NpB, paramObject.NpB)) || (!p.i(this.NrO, paramObject.NrO))) {}
        }
      }
      else
      {
        AppMethodBeat.o(56868);
        return true;
      }
      AppMethodBeat.o(56868);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(56867);
      Object localObject = this.NpB;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.NrO;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(56867);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56866);
      String str = "ClassRequest(classId=" + this.NpB + ", typeParametersCount=" + this.NrO + ")";
      AppMethodBeat.o(56866);
      return str;
    }
  }
  
  public static final class b
    extends d.l.b.a.b.b.c.g
  {
    private final List<as> NrP;
    private final d.l.b.a.b.m.j NrQ;
    private final boolean NrR;
    
    public b(d.l.b.a.b.l.j paramj, l paraml, d.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.Nsc);
      AppMethodBeat.i(56873);
      this.NrR = paramBoolean;
      paramf = (Iterable)d.k.j.lv(0, paramInt);
      paraml = (Collection)new ArrayList(d.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((d.a.ab)paramf).nextInt();
        l locall = (l)this;
        g.a locala = d.l.b.a.b.b.a.g.NsU;
        paraml.add(ai.a(locall, g.a.gon(), bh.NZW, d.l.b.a.b.f.f.bei("T".concat(String.valueOf(paramInt))), paramInt, paramj));
      }
      this.NrP = ((List)paraml);
      this.NrQ = new d.l.b.a.b.m.j((e)this, this.NrP, (Collection)ak.setOf(d.l.b.a.b.j.d.a.F(this).gnF().glF()), paramj);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> gkx()
    {
      return (Collection)x.NhJ;
    }
    
    public final e glX()
    {
      return null;
    }
    
    public final f glY()
    {
      return f.Nrw;
    }
    
    public final w glZ()
    {
      return w.NrG;
    }
    
    public final d gma()
    {
      return null;
    }
    
    public final ba gmb()
    {
      AppMethodBeat.i(56869);
      ba localba = az.Nsm;
      p.g(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final boolean gmc()
    {
      return false;
    }
    
    public final boolean gmd()
    {
      return this.NrR;
    }
    
    public final boolean gme()
    {
      return false;
    }
    
    public final boolean gmf()
    {
      return false;
    }
    
    public final boolean gmg()
    {
      return false;
    }
    
    public final boolean gmh()
    {
      return false;
    }
    
    public final boolean gmi()
    {
      return false;
    }
    
    public final d.l.b.a.b.b.a.g gmj()
    {
      AppMethodBeat.i(56870);
      Object localObject = d.l.b.a.b.b.a.g.NsU;
      localObject = g.a.gon();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> gml()
    {
      return (Collection)v.NhH;
    }
    
    public final List<as> gmm()
    {
      return this.NrP;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + gnf() + " (not found)";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.aa
 * JD-Core Version:    0.7.0.1
 */