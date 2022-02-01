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
  final i KZf;
  final y LbH;
  final c<d.l.b.a.b.f.b, ab> LdM;
  private final c<a, e> LdN;
  
  public aa(i parami, y paramy)
  {
    AppMethodBeat.i(56877);
    this.KZf = parami;
    this.LbH = paramy;
    this.LdM = this.KZf.I((d.g.a.b)new d(this));
    this.LdN = this.KZf.I((d.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(d.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    k.h(parama, "classId");
    k.h(paramList, "typeParametersCount");
    parama = (e)this.LdN.ay(new a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  static final class a
  {
    final d.l.b.a.b.f.a LbB;
    final List<Integer> LdO;
    
    public a(d.l.b.a.b.f.a parama, List<Integer> paramList)
    {
      AppMethodBeat.i(56865);
      this.LbB = parama;
      this.LdO = paramList;
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
          if ((!k.g(this.LbB, paramObject.LbB)) || (!k.g(this.LdO, paramObject.LdO))) {}
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
      Object localObject = this.LbB;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.LdO;
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
      String str = "ClassRequest(classId=" + this.LbB + ", typeParametersCount=" + this.LdO + ")";
      AppMethodBeat.o(56866);
      return str;
    }
  }
  
  public static final class b
    extends d.l.b.a.b.b.c.g
  {
    private final List<as> LdP;
    private final d.l.b.a.b.m.j LdQ;
    private final boolean LdR;
    
    public b(i parami, l paraml, d.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.Lec);
      AppMethodBeat.i(56873);
      this.LdR = paramBoolean;
      paramf = (Iterable)h.kZ(0, paramInt);
      paraml = (Collection)new ArrayList(d.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((d.a.ab)paramf).nextInt();
        l locall = (l)this;
        g.a locala = d.l.b.a.b.b.a.g.LeU;
        paraml.add(ai.a(locall, g.a.fSm(), bh.LLV, d.l.b.a.b.f.f.aWB("T".concat(String.valueOf(paramInt))), paramInt));
      }
      this.LdP = ((List)paraml);
      this.LdQ = new d.l.b.a.b.m.j((e)this, this.LdP, (Collection)ak.setOf(d.l.b.a.b.j.d.a.F(this).fRE().fPF()), parami);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> fOv()
    {
      return (Collection)x.KTH;
    }
    
    public final e fPX()
    {
      return null;
    }
    
    public final f fPY()
    {
      return f.Ldw;
    }
    
    public final w fPZ()
    {
      return w.LdG;
    }
    
    public final d fQa()
    {
      return null;
    }
    
    public final ba fQb()
    {
      AppMethodBeat.i(56869);
      ba localba = az.Lem;
      k.g(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final boolean fQc()
    {
      return false;
    }
    
    public final boolean fQd()
    {
      return this.LdR;
    }
    
    public final boolean fQe()
    {
      return false;
    }
    
    public final boolean fQf()
    {
      return false;
    }
    
    public final boolean fQg()
    {
      return false;
    }
    
    public final boolean fQh()
    {
      return false;
    }
    
    public final boolean fQi()
    {
      return false;
    }
    
    public final d.l.b.a.b.b.a.g fQj()
    {
      AppMethodBeat.i(56870);
      Object localObject = d.l.b.a.b.b.a.g.LeU;
      localObject = g.a.fSm();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> fQl()
    {
      return (Collection)v.KTF;
    }
    
    public final List<as> fQm()
    {
      return this.LdP;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + fRf() + " (not found)";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.aa
 * JD-Core Version:    0.7.0.1
 */