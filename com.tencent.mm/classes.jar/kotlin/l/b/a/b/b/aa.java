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
import kotlin.k.i;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.l.c;
import kotlin.l.b.a.b.m.bh;

public final class aa
{
  final kotlin.l.b.a.b.l.j aaFH;
  final y aaIj;
  final c<kotlin.l.b.a.b.f.b, ab> aaKo;
  private final c<aa.a, e> aaKp;
  
  public aa(kotlin.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56877);
    this.aaFH = paramj;
    this.aaIj = paramy;
    this.aaKo = this.aaFH.ak((kotlin.g.a.b)new d(this));
    this.aaKp = this.aaFH.ak((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(kotlin.l.b.a.b.f.a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    p.k(parama, "classId");
    p.k(paramList, "typeParametersCount");
    parama = (e)this.aaKp.invoke(new aa.a(parama, paramList));
    AppMethodBeat.o(56876);
    return parama;
  }
  
  public static final class b
    extends kotlin.l.b.a.b.b.c.g
  {
    private final List<as> aaKr;
    private final kotlin.l.b.a.b.m.j aaKs;
    private final boolean aaKt;
    
    public b(kotlin.l.b.a.b.l.j paramj, l paraml, kotlin.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, an.aaKE);
      AppMethodBeat.i(56873);
      this.aaKt = paramBoolean;
      paramf = (Iterable)i.ou(0, paramInt);
      paraml = (Collection)new ArrayList(kotlin.a.j.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((kotlin.a.ab)paramf).zD();
        l locall = (l)this;
        g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
        paraml.add(ai.a(locall, g.a.iGe(), bh.abrp, kotlin.l.b.a.b.f.f.bHb("T".concat(String.valueOf(paramInt))), paramInt, paramj));
      }
      this.aaKr = ((List)paraml);
      this.aaKs = new kotlin.l.b.a.b.m.j((e)this, this.aaKr, (Collection)ak.setOf(kotlin.l.b.a.b.j.d.a.F(this).iFv().iDu()), paramj);
      AppMethodBeat.o(56873);
    }
    
    public final Collection<d> iCg()
    {
      return (Collection)x.aaAf;
    }
    
    public final e iDM()
    {
      return null;
    }
    
    public final f iDN()
    {
      return f.aaJY;
    }
    
    public final w iDO()
    {
      return w.aaKi;
    }
    
    public final d iDP()
    {
      return null;
    }
    
    public final ba iDQ()
    {
      AppMethodBeat.i(56869);
      ba localba = az.aaKO;
      p.j(localba, "Visibilities.PUBLIC");
      AppMethodBeat.o(56869);
      return localba;
    }
    
    public final boolean iDR()
    {
      return false;
    }
    
    public final boolean iDS()
    {
      return this.aaKt;
    }
    
    public final boolean iDT()
    {
      return false;
    }
    
    public final boolean iDU()
    {
      return false;
    }
    
    public final boolean iDV()
    {
      return false;
    }
    
    public final boolean iDW()
    {
      return false;
    }
    
    public final boolean iDX()
    {
      return false;
    }
    
    public final kotlin.l.b.a.b.b.a.g iDY()
    {
      AppMethodBeat.i(56870);
      Object localObject = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject = g.a.iGe();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final Collection<e> iEa()
    {
      return (Collection)v.aaAd;
    }
    
    public final List<as> iEb()
    {
      return this.aaKr;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + iEU() + " (not found)";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aa
 * JD-Core Version:    0.7.0.1
 */