package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ay.a;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.a.r.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.k.a.ac;
import kotlin.l.b.a.b.k.a.j;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;

public final class n
  extends kotlin.l.b.a.b.b.c.b
{
  final kotlin.l.b.a.b.k.a.l ajmz;
  final a.r ajoo;
  private final b ajop;
  
  public n(kotlin.l.b.a.b.k.a.l paraml, a.r paramr, int paramInt)
  {
    super(localm, locall, (kotlin.l.b.a.b.b.a.g)localObject1, localf, z.b((a.r.b)localObject2), paramr.ajbe, paramInt, av.aiHu, (ay)ay.a.aiHw);
    AppMethodBeat.i(60492);
    this.ajmz = paraml;
    this.ajoo = paramr;
    this.ajop = new b(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new a(this));
    AppMethodBeat.o(60492);
  }
  
  public final List<ad> kpH()
  {
    AppMethodBeat.i(60490);
    Object localObject4 = this.ajoo;
    Object localObject3 = this.ajmz.aiyl;
    s.u(localObject4, "<this>");
    s.u(localObject3, "typeTable");
    Object localObject1 = ((a.r)localObject4).ajbg;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label157;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = ((a.r)localObject4).ajbh;
      s.s(localObject1, "upperBoundIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        s.s(localObject4, "it");
        ((Collection)localObject1).add(((kotlin.l.b.a.b.e.b.g)localObject3).aLZ(((Integer)localObject4).intValue()));
      }
      i = 0;
      break;
      label157:
      localObject1 = null;
    }
    Object localObject2 = (List)localObject1;
    label167:
    if (((List)localObject2).isEmpty())
    {
      localObject1 = p.listOf(kotlin.l.b.a.b.j.d.a.G((kotlin.l.b.a.b.b.l)this).kmQ());
      AppMethodBeat.o(60490);
      return localObject1;
    }
    localObject3 = (Iterable)localObject2;
    localObject1 = this.ajmz.ajmn;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((ac)localObject1).s((a.p)((Iterator)localObject3).next()));
    }
    localObject1 = (List)localObject2;
    AppMethodBeat.o(60490);
    return localObject1;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<List<? extends c>>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.n
 * JD-Core Version:    0.7.0.1
 */