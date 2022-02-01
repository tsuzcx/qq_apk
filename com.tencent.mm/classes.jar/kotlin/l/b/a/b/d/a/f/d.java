package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.c.b.f;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.x;

public final class d
{
  private final kotlin.l.b.a.b.d.a.c.d aiUI;
  
  public d(kotlin.l.b.a.b.d.a.c.d paramd)
  {
    AppMethodBeat.i(192081);
    this.aiUI = paramd;
    AppMethodBeat.o(192081);
  }
  
  private final a a(bk parambk, b<? super Integer, e> paramb, int paramInt, boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(192089);
    if (af.ai((ad)parambk))
    {
      parambk = new a((ad)parambk, 1, false);
      AppMethodBeat.o(192089);
      return parambk;
    }
    if ((parambk instanceof x))
    {
      boolean bool2 = parambk instanceof kotlin.l.b.a.b.m.ak;
      b localb1 = a(((x)parambk).ajpE, paramb, paramInt, o.aiVU, bool2, paramBoolean);
      b localb2 = a(((x)parambk).ajpF, paramb, paramInt, o.aiVV, bool2, paramBoolean);
      if (localb1.aiUJ == localb2.aiUJ) {}
      for (paramInt = 1; (kotlin.ak.aiuY) && (paramInt == 0); paramInt = 0)
      {
        parambk = (Throwable)new AssertionError("Different tree sizes of bounds: lower = (" + ((x)parambk).ajpE + ", " + localb1.aiUJ + "), upper = (" + ((x)parambk).ajpF + ", " + localb2.aiUJ + ')');
        AppMethodBeat.o(192089);
        throw parambk;
      }
      if (!localb1.aiUK)
      {
        paramBoolean = bool1;
        if (!localb2.aiUK) {}
      }
      else
      {
        paramBoolean = true;
      }
      paramb = a((ad)localb1.aiUL, (ad)localb2.aiUL);
      if (paramBoolean) {
        if ((parambk instanceof f))
        {
          parambk = (bk)new f(localb1.aiUL, localb2.aiUL);
          parambk = bi.b(parambk, paramb);
        }
      }
      for (;;)
      {
        parambk = new a((ad)parambk, localb1.aiUJ, paramBoolean);
        AppMethodBeat.o(192089);
        return parambk;
        parambk = ae.a(localb1.aiUL, localb2.aiUL);
        break;
      }
    }
    if ((parambk instanceof al))
    {
      parambk = (a)a(this, (al)parambk, paramb, paramInt, o.aiVW, paramBoolean);
      AppMethodBeat.o(192089);
      return parambk;
    }
    parambk = new kotlin.p();
    AppMethodBeat.o(192089);
    throw parambk;
  }
  
  private final b a(al paramal, b<? super Integer, e> paramb, int paramInt, o paramo, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192094);
    if ((!p.a(paramo)) && (paramal.klR().isEmpty()))
    {
      paramal = new b(paramal, 1, false);
      AppMethodBeat.o(192094);
      return paramal;
    }
    Object localObject1 = paramal.kzm().knA();
    if (localObject1 == null)
    {
      paramal = new b(paramal, 1, false);
      AppMethodBeat.o(192094);
      return paramal;
    }
    e locale = (e)paramb.invoke(Integer.valueOf(paramInt));
    localObject1 = s.a((kotlin.l.b.a.b.b.h)localObject1, locale, paramo);
    kotlin.l.b.a.b.b.h localh = (kotlin.l.b.a.b.b.h)((c)localObject1).result;
    kotlin.l.b.a.b.b.a.g localg = ((c)localObject1).aiUH;
    ax localax = localh.kmZ();
    kotlin.g.b.s.s(localax, "enhancedClassifier.typeConstructor");
    int j = paramInt + 1;
    Collection localCollection;
    int k;
    if (localg != null)
    {
      i = 1;
      if ((paramBoolean2) && (paramBoolean1)) {
        break label597;
      }
      localObject1 = (Iterable)paramal.klR();
      localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      k = 0;
      label199:
      if (!localIterator.hasNext()) {
        break label515;
      }
      localObject1 = localIterator.next();
      if (k < 0) {
        kotlin.a.p.kkW();
      }
      localObject1 = (az)localObject1;
      if (!((az)localObject1).kAM()) {
        break label405;
      }
      localObject2 = (e)paramb.invoke(Integer.valueOf(j));
      j += 1;
      if ((((e)localObject2).aiUN != h.aiUX) || (paramBoolean1)) {
        break label367;
      }
      localObject2 = a.au((ad)((az)localObject1).koG().kAK());
      localObject1 = ((az)localObject1).kAN();
      kotlin.g.b.s.s(localObject1, "arg.projectionKind");
      localObject1 = a.a((ad)localObject2, (bl)localObject1, (ba)localax.klq().get(k));
    }
    for (;;)
    {
      localCollection.add(localObject1);
      k += 1;
      break label199;
      i = 0;
      break;
      label367:
      localObject1 = bg.c((ba)localh.kmZ().klq().get(k));
      kotlin.g.b.s.s(localObject1, "{\n                      …x])\n                    }");
    }
    label405:
    Object localObject2 = a(((az)localObject1).koG().kAK(), paramb, j, paramBoolean2);
    if ((i != 0) || (((a)localObject2).aiUK)) {}
    for (int i = 1;; i = 0)
    {
      int m = ((a)localObject2).aiUJ;
      localObject2 = ((a)localObject2).koG();
      localObject1 = ((az)localObject1).kAN();
      kotlin.g.b.s.s(localObject1, "arg.projectionKind");
      localObject1 = a.a((ad)localObject2, (bl)localObject1, (ba)localax.klq().get(k));
      j = m + j;
      break;
    }
    label515:
    paramb = (List)localCollection;
    paramo = s.a((ad)paramal, locale, paramo);
    paramBoolean1 = ((Boolean)paramo.result).booleanValue();
    localObject1 = paramo.aiUH;
    if ((i != 0) || (localObject1 != null)) {}
    for (i = 1;; i = 0)
    {
      j -= paramInt;
      if (i != 0) {
        break label625;
      }
      paramal = new b(paramal, j, false);
      AppMethodBeat.o(192094);
      return paramal;
      label597:
      j += paramal.klR().size();
      paramb = paramal.klR();
      break;
    }
    label625:
    paramo = ae.c(s.pa(kotlin.a.p.am(new kotlin.l.b.a.b.b.a.g[] { paramal.knl(), localg, localObject1 })), localax, paramb, paramBoolean1);
    paramb = paramo;
    if (locale.aiUP) {
      paramb = a(paramo);
    }
    if ((localObject1 != null) && (locale.aiUQ))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label738;
      }
    }
    label738:
    for (paramal = bi.b((bk)paramal, (ad)paramb);; paramal = (bk)paramb)
    {
      paramal = new b((al)paramal, j, true);
      AppMethodBeat.o(192094);
      return paramal;
      paramInt = 0;
      break;
    }
  }
  
  private static ad a(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(192084);
    paramad2 = bi.aC(paramad2);
    ad localad = bi.aC(paramad1);
    paramad1 = localad;
    if (localad == null)
    {
      if (paramad2 == null)
      {
        AppMethodBeat.o(192084);
        return null;
      }
      paramad1 = paramad2;
    }
    if (paramad2 == null)
    {
      AppMethodBeat.o(192084);
      return paramad1;
    }
    paramad1 = (ad)ae.a(aa.ae(paramad1), aa.af(paramad2));
    AppMethodBeat.o(192084);
    return paramad1;
  }
  
  private final al a(al paramal)
  {
    AppMethodBeat.i(192101);
    if (this.aiUI.ksh())
    {
      paramal = ao.a(paramal, true);
      AppMethodBeat.o(192101);
      return paramal;
    }
    paramal = (al)new g(paramal);
    AppMethodBeat.o(192101);
    return paramal;
  }
  
  public final ad a(ad paramad, b<? super Integer, e> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(192106);
    kotlin.g.b.s.u(paramad, "<this>");
    kotlin.g.b.s.u(paramb, "qualifiers");
    paramad = a(paramad.kAK(), paramb, 0, paramBoolean);
    paramb = paramad.koG();
    if (paramad.aiUK)
    {
      AppMethodBeat.o(192106);
      return paramb;
    }
    AppMethodBeat.o(192106);
    return null;
  }
  
  static class a
  {
    private final ad aiAd;
    final int aiUJ;
    final boolean aiUK;
    
    public a(ad paramad, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(192091);
      this.aiAd = paramad;
      this.aiUJ = paramInt;
      this.aiUK = paramBoolean;
      AppMethodBeat.o(192091);
    }
    
    public ad koG()
    {
      return this.aiAd;
    }
  }
  
  static final class b
    extends d.a
  {
    final al aiUL;
    
    public b(al paramal, int paramInt, boolean paramBoolean)
    {
      super(paramInt, paramBoolean);
      AppMethodBeat.i(192093);
      this.aiUL = paramal;
      AppMethodBeat.o(192093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.d
 * JD-Core Version:    0.7.0.1
 */