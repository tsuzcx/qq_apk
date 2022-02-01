package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ay.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.a;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bl;

public final class b
  extends a
{
  private static final kotlin.l.b.a.b.f.b aiEE;
  private static final kotlin.l.b.a.b.f.b aiEF;
  public static final b.a aiEy;
  private final m aiBu;
  final c aiEA;
  private final b aiEB;
  private final d aiEC;
  final List<ba> aiED;
  private final kotlin.l.b.a.b.b.ah aiEz;
  final int arity;
  
  static
  {
    AppMethodBeat.i(56733);
    aiEy = new b.a((byte)0);
    aiEE = new kotlin.l.b.a.b.f.b(k.aiCr, kotlin.l.b.a.b.f.f.bJe("Function"));
    aiEF = new kotlin.l.b.a.b.f.b(k.aiCo, kotlin.l.b.a.b.f.f.bJe("KFunction"));
    AppMethodBeat.o(56733);
  }
  
  public b(m paramm, kotlin.l.b.a.b.b.ah paramah, c paramc, int paramInt)
  {
    super(paramm, paramc.aKz(paramInt));
    AppMethodBeat.i(191433);
    this.aiBu = paramm;
    this.aiEz = paramah;
    this.aiEA = paramc;
    this.arity = paramInt;
    this.aiEB = new b();
    this.aiEC = new d(this.aiBu, this);
    paramm = new ArrayList();
    paramc = (Iterable)new kotlin.k.g(1, this.arity);
    paramah = (Collection)new ArrayList(kotlin.a.p.a(paramc, 10));
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      paramInt = ((kotlin.a.ah)paramc).Zo();
      a(paramm, this, bl.ajqN, kotlin.g.b.s.X("P", Integer.valueOf(paramInt)));
      paramah.add(kotlin.ah.aiuX);
    }
    a(paramm, this, bl.ajqO, "R");
    this.aiED = kotlin.a.p.p((Iterable)paramm);
    AppMethodBeat.o(191433);
  }
  
  private static final void a(ArrayList<ba> paramArrayList, b paramb, bl parambl, String paramString)
  {
    AppMethodBeat.i(191438);
    l locall = (l)paramb;
    g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
    paramArrayList.add(aj.a(locall, g.a.kpB(), parambl, kotlin.l.b.a.b.f.f.bJe(paramString), paramArrayList.size(), paramb.aiBu));
    AppMethodBeat.o(191438);
  }
  
  public final boolean isValue()
  {
    return false;
  }
  
  public final ax kmZ()
  {
    return (ax)this.aiEB;
  }
  
  public final kotlin.l.b.a.b.b.f kna()
  {
    return kotlin.l.b.a.b.b.f.aiGu;
  }
  
  public final ab knb()
  {
    return ab.aiHb;
  }
  
  public final t knc()
  {
    AppMethodBeat.i(191482);
    t localt = kotlin.l.b.a.b.b.s.aiGG;
    kotlin.g.b.s.s(localt, "PUBLIC");
    AppMethodBeat.o(191482);
    return localt;
  }
  
  public final boolean knd()
  {
    return false;
  }
  
  public final boolean kne()
  {
    return false;
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
    AppMethodBeat.i(56729);
    Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject = g.a.kpB();
    AppMethodBeat.o(56729);
    return localObject;
  }
  
  public final av knm()
  {
    AppMethodBeat.i(56730);
    av localav = av.aiHu;
    kotlin.g.b.s.s(localav, "NO_SOURCE");
    AppMethodBeat.o(56730);
    return localav;
  }
  
  public final y<al> knn()
  {
    return null;
  }
  
  public final List<ba> kno()
  {
    return this.aiED;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56731);
    String str = kok().PF();
    kotlin.g.b.s.s(str, "name.asString()");
    AppMethodBeat.o(56731);
    return str;
  }
  
  final class b
    extends kotlin.l.b.a.b.m.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(56722);
      AppMethodBeat.o(56722);
    }
    
    public final List<ba> klq()
    {
      AppMethodBeat.i(369489);
      List localList = b.c(this.aiEG);
      AppMethodBeat.o(369489);
      return localList;
    }
    
    public final Collection<ad> knw()
    {
      AppMethodBeat.i(56719);
      Object localObject1 = this.aiEG.aiEA;
      kotlin.l.b.a.b.b.ae localae;
      Object localObject2;
      switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new kotlin.p();
        AppMethodBeat.o(56719);
        throw ((Throwable)localObject1);
      case 1: 
        localObject1 = kotlin.a.p.listOf(b.knu());
        localae = b.b(this.aiEG).koX();
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label426;
        }
        Object localObject3 = (kotlin.l.b.a.b.f.b)((Iterator)localObject2).next();
        e locale = w.b(localae, (kotlin.l.b.a.b.f.b)localObject3);
        if (locale == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("Built-in class " + localObject3 + " not found").toString());
          AppMethodBeat.o(56719);
          throw ((Throwable)localObject1);
          localObject1 = kotlin.a.p.listOf(new kotlin.l.b.a.b.f.b[] { b.knv(), new kotlin.l.b.a.b.f.b(k.aiCr, c.aiEM.aKz(this.aiEG.arity)) });
          break;
          localObject1 = kotlin.a.p.listOf(b.knu());
          break;
          localObject1 = kotlin.a.p.listOf(new kotlin.l.b.a.b.f.b[] { b.knv(), new kotlin.l.b.a.b.f.b(k.aiCi, c.aiEN.aKz(this.aiEG.arity)) });
          break;
        }
        Object localObject4 = (Iterable)kotlin.a.p.ag(b.c(this.aiEG), locale.kmZ().klq().size());
        localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new bb((ad)((ba)((Iterator)localObject4).next()).koj()));
        }
        localObject3 = (List)localObject3;
        localObject4 = kotlin.l.b.a.b.b.a.g.aiIh;
        ((Collection)localObject1).add(kotlin.l.b.a.b.m.ae.a(g.a.kpB(), locale, (List)localObject3));
      }
      label426:
      localObject1 = (Collection)kotlin.a.p.p((Iterable)localObject1);
      AppMethodBeat.o(56719);
      return localObject1;
    }
    
    public final boolean knx()
    {
      return true;
    }
    
    public final ay kny()
    {
      return (ay)ay.a.aiHw;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56721);
      String str = this.aiEG.toString();
      AppMethodBeat.o(56721);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */