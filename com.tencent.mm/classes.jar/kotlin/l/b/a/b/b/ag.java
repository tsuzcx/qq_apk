package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ad;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.u;
import kotlin.k.k;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.j;

public final class ag
{
  final m aiBu;
  final ae aiEx;
  final kotlin.l.b.a.b.l.f<c, ah> aiHd;
  private final kotlin.l.b.a.b.l.f<ag.a, e> aiHe;
  
  public ag(m paramm, ae paramae)
  {
    AppMethodBeat.i(56877);
    this.aiBu = paramm;
    this.aiEx = paramae;
    this.aiHd = this.aiBu.bd((kotlin.g.a.b)new d(this));
    this.aiHe = this.aiBu.bd((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(56877);
  }
  
  public final e a(kotlin.l.b.a.b.f.b paramb, List<Integer> paramList)
  {
    AppMethodBeat.i(56876);
    kotlin.g.b.s.u(paramb, "classId");
    kotlin.g.b.s.u(paramList, "typeParametersCount");
    paramb = (e)this.aiHe.invoke(new ag.a(paramb, paramList));
    AppMethodBeat.o(56876);
    return paramb;
  }
  
  public static final class b
    extends kotlin.l.b.a.b.b.c.g
  {
    private final boolean aiHg;
    private final List<ba> aiHh;
    private final j aiHi;
    
    public b(m paramm, l paraml, kotlin.l.b.a.b.f.f paramf, boolean paramBoolean, int paramInt)
    {
      super(paraml, paramf, av.aiHu);
      AppMethodBeat.i(56873);
      this.aiHg = paramBoolean;
      paramf = (Iterable)k.qt(0, paramInt);
      paraml = (Collection)new ArrayList(p.a(paramf, 10));
      paramf = paramf.iterator();
      while (paramf.hasNext())
      {
        paramInt = ((kotlin.a.ah)paramf).Zo();
        l locall = (l)this;
        g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
        paraml.add(aj.a(locall, g.a.kpB(), bl.ajqM, kotlin.l.b.a.b.f.f.bJe(kotlin.g.b.s.X("T", Integer.valueOf(paramInt))), paramInt, paramm));
      }
      this.aiHh = ((List)paraml);
      this.aiHi = new j((e)this, bb.a((i)this), (Collection)ar.setOf(a.F((l)this).koV().kmO()), paramm);
      AppMethodBeat.o(56873);
    }
    
    public final boolean isValue()
    {
      return false;
    }
    
    public final Collection<d> klv()
    {
      return (Collection)ad.aivA;
    }
    
    public final f kna()
    {
      return f.aiGt;
    }
    
    public final ab knb()
    {
      return ab.aiGY;
    }
    
    public final t knc()
    {
      AppMethodBeat.i(191817);
      t localt = s.aiGG;
      kotlin.g.b.s.s(localt, "PUBLIC");
      AppMethodBeat.o(191817);
      return localt;
    }
    
    public final boolean knd()
    {
      return false;
    }
    
    public final boolean kne()
    {
      return this.aiHg;
    }
    
    public final boolean knf()
    {
      return false;
    }
    
    public final boolean kng()
    {
      return false;
    }
    
    public final boolean knh()
    {
      return false;
    }
    
    public final boolean kni()
    {
      return false;
    }
    
    public final boolean knj()
    {
      return false;
    }
    
    public final boolean knk()
    {
      return false;
    }
    
    public final kotlin.l.b.a.b.b.a.g knl()
    {
      AppMethodBeat.i(56870);
      Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
      localObject = g.a.kpB();
      AppMethodBeat.o(56870);
      return localObject;
    }
    
    public final y<al> knn()
    {
      return null;
    }
    
    public final List<ba> kno()
    {
      return this.aiHh;
    }
    
    public final e knr()
    {
      return null;
    }
    
    public final d kns()
    {
      return null;
    }
    
    public final Collection<e> knt()
    {
      return (Collection)kotlin.a.ab.aivy;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56872);
      String str = "class " + kok() + " (not found)";
      AppMethodBeat.o(56872);
      return str;
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<ag.a, e>
  {
    c(ag paramag)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.b<c, ah>
  {
    d(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.ag
 * JD-Core Version:    0.7.0.1
 */