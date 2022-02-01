package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.p;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.d.a.c.b.d;
import kotlin.l.b.a.b.d.a.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.j.b.q.a;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.v;

public final class e
  implements kotlin.l.b.a.b.d.a.b.g
{
  private final kotlin.l.b.a.b.l.h aiQP;
  private final boolean aiQR;
  private final kotlin.l.b.a.b.l.h aiRe;
  private final kotlin.l.b.a.b.d.a.e.a aiSL;
  private final i aiSM;
  private final kotlin.l.b.a.b.d.a.d.a aiSN;
  public final boolean aiSO;
  private final kotlin.l.b.a.b.d.a.c.h aiSh;
  
  static
  {
    AppMethodBeat.i(57796);
    aYe = new kotlin.l.o[] { (kotlin.l.o)ai.a((kotlin.g.b.af)new ag((kotlin.l.e)ai.cz(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (kotlin.l.o)ai.a((kotlin.g.b.af)new ag((kotlin.l.e)ai.cz(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (kotlin.l.o)ai.a((kotlin.g.b.af)new ag((kotlin.l.e)ai.cz(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(192157);
    this.aiSh = paramh;
    this.aiSL = parama;
    this.aiSM = this.aiSh.aiSp.aiBu.cr((kotlin.g.a.a)new b(this));
    this.aiQP = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new c(this));
    this.aiSN = this.aiSh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)this.aiSL);
    this.aiRe = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new a(this));
    this.aiQR = this.aiSL.kqt();
    if ((this.aiSL.kqs()) || (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aiSO = paramBoolean;
      AppMethodBeat.o(192157);
      return;
    }
  }
  
  private final kotlin.l.b.a.b.j.b.g<?> b(kotlin.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof kotlin.l.b.a.b.d.a.e.o))
    {
      paramb = kotlin.l.b.a.b.j.b.h.ajjE.jdMethod_if(((kotlin.l.b.a.b.d.a.e.o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof kotlin.l.b.a.b.d.a.e.m))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.e.m)paramb).kqZ();
      paramb = ((kotlin.l.b.a.b.d.a.e.m)paramb).kra();
      if ((localObject1 == null) || (paramb == null))
      {
        AppMethodBeat.o(57801);
        return null;
      }
      paramb = (kotlin.l.b.a.b.j.b.g)new j((kotlin.l.b.a.b.f.b)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
    }
    if ((paramb instanceof kotlin.l.b.a.b.d.a.e.e))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.e.e)paramb).kok();
      if (localObject1 == null)
      {
        localObject1 = w.aiPv;
        kotlin.g.b.s.s(localObject1, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        localObject2 = ((kotlin.l.b.a.b.d.a.e.e)paramb).kqx();
        paramb = kso();
        kotlin.g.b.s.s(paramb, "type");
        if (kotlin.l.b.a.b.m.af.ai((ad)paramb)) {
          break label457;
        }
        paramb = kotlin.l.b.a.b.j.d.a.j((kotlin.l.b.a.b.b.a.c)this);
        kotlin.g.b.s.checkNotNull(paramb);
        paramb = kotlin.l.b.a.b.d.a.a.a.b((f)localObject1, paramb);
        if (paramb != null) {
          break label316;
        }
        paramb = null;
        label183:
        if (paramb != null) {
          break label326;
        }
        paramb = (ad)this.aiSh.aiSp.aiEx.koV().a(bl.ajqM, (ad)v.bJt("Unknown array element type"));
      }
      Collection localCollection;
      label316:
      label326:
      for (;;)
      {
        kotlin.g.b.s.s(paramb, "DescriptorResolverUtils.… type\")\n                )");
        localObject1 = (Iterable)localObject2;
        localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = b((kotlin.l.b.a.b.d.a.e.b)localIterator.next());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.s();
          }
          localCollection.add(localObject1);
        }
        break;
        paramb = paramb.koG();
        break label183;
      }
      localObject1 = (List)localCollection;
      Object localObject2 = kotlin.l.b.a.b.j.b.h.ajjE;
      paramb = (kotlin.l.b.a.b.j.b.g)kotlin.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
    }
    else
    {
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.c))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.c)paramb).kqv();
        paramb = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a.c)new e(this.aiSh, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.h))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.h)paramb).kqT();
        localObject1 = q.ajjS;
        paramb = q.a.U(this.aiSh.aiSt.a(paramb, d.a(k.aiRp, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
    }
    label457:
    AppMethodBeat.o(57801);
    return null;
  }
  
  private al kso()
  {
    AppMethodBeat.i(57798);
    al localal = (al)kotlin.l.b.a.b.l.l.a(this.aiQP, aYe[1]);
    AppMethodBeat.o(57798);
    return localal;
  }
  
  public final kotlin.l.b.a.b.f.c koY()
  {
    AppMethodBeat.i(57797);
    kotlin.l.b.a.b.f.c localc = (kotlin.l.b.a.b.f.c)kotlin.l.b.a.b.l.l.a(this.aiSM, aYe[0]);
    AppMethodBeat.o(57797);
    return localc;
  }
  
  public final Map<f, kotlin.l.b.a.b.j.b.g<?>> kpA()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)kotlin.l.b.a.b.l.l.a(this.aiRe, aYe[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final boolean kqt()
  {
    return this.aiQR;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = kotlin.l.b.a.b.i.c.a(kotlin.l.b.a.b.i.c.ajgy, (kotlin.l.b.a.b.b.a.c)this);
    AppMethodBeat.o(57802);
    return str;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<Map<f, ? extends kotlin.l.b.a.b.j.b.g<?>>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.f.c>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<al>
  {
    c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */