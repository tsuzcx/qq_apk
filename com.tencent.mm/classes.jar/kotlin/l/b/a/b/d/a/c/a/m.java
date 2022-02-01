package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.d.a.c.e;
import kotlin.l.b.a.b.d.a.e.j;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.f.l.a;
import kotlin.l.b.a.b.d.a.f.l.b;
import kotlin.l.b.a.b.d.a.f.l.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bl;

public final class m
  extends kotlin.l.b.a.b.b.c.b
{
  private final kotlin.l.b.a.b.d.a.c.h aiSh;
  private final x aiTW;
  
  public m(kotlin.l.b.a.b.d.a.c.h paramh, x paramx, int paramInt, kotlin.l.b.a.b.b.l paraml)
  {
    super(paramh.aiSp.aiBu, paraml, (g)new e(paramh, (kotlin.l.b.a.b.d.a.e.d)paramx), paramx.kok(), bl.ajqM, false, paramInt, av.aiHu, paramh.aiSp.aiJR);
    AppMethodBeat.i(57947);
    this.aiSh = paramh;
    this.aiTW = paramx;
    AppMethodBeat.o(57947);
  }
  
  public final void A(ad paramad)
  {
    AppMethodBeat.i(57946);
    s.u(paramad, "type");
    AppMethodBeat.o(57946);
  }
  
  public final List<ad> kpH()
  {
    AppMethodBeat.i(57945);
    Object localObject1 = this.aiTW.krk();
    if (((Collection)localObject1).isEmpty())
    {
      localObject1 = this.aiSh.aiSp.aiEx.koV().kmO();
      s.s(localObject1, "c.module.builtIns.anyType");
      localObject2 = this.aiSh.aiSp.aiEx.koV().kmP();
      s.s(localObject2, "c.module.builtIns.nullableAnyType");
      localObject1 = p.listOf(kotlin.l.b.a.b.m.ae.a((al)localObject1, (al)localObject2));
      AppMethodBeat.o(57945);
      return localObject1;
    }
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      j localj = (j)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.aiSh.aiSt.a((w)localj, kotlin.l.b.a.b.d.a.c.b.d.a(k.aiRp, false, (ba)this, 1)));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57945);
    return localObject1;
  }
  
  public final List<ad> oU(List<? extends ad> paramList)
  {
    AppMethodBeat.i(192159);
    s.u(paramList, "bounds");
    kotlin.l.b.a.b.d.a.f.l locall = this.aiSh.aiSp.aiRY;
    ba localba = (ba)this;
    kotlin.l.b.a.b.d.a.c.h localh = this.aiSh;
    s.u(localba, "typeParameter");
    s.u(paramList, "bounds");
    s.u(localh, "context");
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ad)localIterator.next();
      if (kotlin.l.b.a.b.m.d.a.a(paramList, (kotlin.g.a.b)l.f.aiVM)) {}
      for (;;)
      {
        localCollection.add(paramList);
        break;
        paramList = l.b.a(new l.b(locall, (kotlin.l.b.a.b.b.a.a)localba, paramList, (Collection)ab.aivy, false, localh, kotlin.l.b.a.b.d.a.a.aiOd, true, false, 128)).aiAd;
      }
    }
    paramList = (List)localCollection;
    AppMethodBeat.o(192159);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.m
 * JD-Core Version:    0.7.0.1
 */