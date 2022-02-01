package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ak;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.l.c;
import kotlin.l.b.a.b.m.bh;

public final class aa
{
  final kotlin.l.b.a.b.l.j TcN;
  final y Tfp;
  final c<kotlin.l.b.a.b.f.b, ab> Thu;
  private final c<aa.a, e> Thv;
  
  public aa(kotlin.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56877);
    this.TcN = paramj;
    this.Tfp = paramy;
    this.Thu = this.TcN.U((kotlin.g.a.b)new d(this));
    this.Thv = this.TcN.U((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(kotlin.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    p.h(parama, "classId");
    p.h(paramList, "typeParametersCount");
    parama = (e)this.Thv.invoke(new aa.a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  public static final class b
    extends kotlin.l.b.a.b.b.c.g
  {
    private final List<as> Thx;
    private final kotlin.l.b.a.b.m.j Thy;
    private final boolean Thz;
    
    public b(kotlin.l.b.a.b.l.j paramj, l paraml, kotlin.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.ThK);
      AppMethodBeat.i(56873);
      this.Thz = paramBoolean;
      paramf = (Iterable)kotlin.k.j.mY(0, paramInt);
      paraml = (Collection)new ArrayList(kotlin.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((kotlin.a.ab)paramf).nextInt();
        l locall = (l)this;
        g.a locala = kotlin.l.b.a.b.b.a.g.TiC;
        paraml.add(ai.a(locall, g.a.hBP(), bh.TOQ, kotlin.l.b.a.b.f.f.btY("T".concat(String.valueOf(paramInt))), paramInt, paramj));
      }
      this.Thx = ((List)paraml);
      this.Thy = new kotlin.l.b.a.b.m.j((e)this, this.Thx, (Collection)ak.setOf(kotlin.l.b.a.b.j.d.a.F(this).hBh().hzi()), paramj);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> hxW()
    {
      return (Collection)x.SXt;
    }
    
    public final e hzA()
    {
      return null;
    }
    
    public final f hzB()
    {
      return f.The;
    }
    
    public final w hzC()
    {
      return w.Tho;
    }
    
    public final d hzD()
    {
      return null;
    }
    
    public final ba hzE()
    {
      AppMethodBeat.i(56869);
      ba localba = az.ThU;
      p.g(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final boolean hzF()
    {
      return false;
    }
    
    public final boolean hzG()
    {
      return this.Thz;
    }
    
    public final boolean hzH()
    {
      return false;
    }
    
    public final boolean hzI()
    {
      return false;
    }
    
    public final boolean hzJ()
    {
      return false;
    }
    
    public final boolean hzK()
    {
      return false;
    }
    
    public final kotlin.l.b.a.b.b.a.g hzL()
    {
      AppMethodBeat.i(56870);
      Object localObject = kotlin.l.b.a.b.b.a.g.TiC;
      localObject = g.a.hBP();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> hzN()
    {
      return (Collection)v.SXr;
    }
    
    public final List<as> hzO()
    {
      return this.Thx;
    }
    
    public final boolean isExternal()
    {
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + hAH() + " (not found)";
      AppMethodBeat.o(56872);
      return str;
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<aa.a, aa.b>
  {
    c(aa paramaa)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, m>
  {
    d(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aa
 * JD-Core Version:    0.7.0.1
 */