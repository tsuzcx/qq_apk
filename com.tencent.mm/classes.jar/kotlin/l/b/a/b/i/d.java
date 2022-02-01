package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.ak;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ag.b;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.aw;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bb;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.j.b.q.b;
import kotlin.l.b.a.b.j.b.q.b.a;
import kotlin.l.b.a.b.j.b.q.b.b;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bj;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.bm;
import kotlin.l.b.a.b.m.v;

public final class d
  extends c
  implements f
{
  final g ajgO;
  private final kotlin.j ajgP;
  
  public d(g paramg)
  {
    AppMethodBeat.i(59769);
    this.ajgO = paramg;
    boolean bool = this.ajgO.GrX;
    if ((ak.aiuY) && (!bool))
    {
      paramg = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59769);
      throw paramg;
    }
    this.ajgP = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(59769);
  }
  
  private final String EQ(String paramString)
  {
    AppMethodBeat.i(59714);
    paramString = kyZ().EQ(paramString);
    AppMethodBeat.o(59714);
    return paramString;
  }
  
  private static boolean N(ad paramad)
  {
    AppMethodBeat.i(59725);
    if (kotlin.l.b.a.b.a.g.f(paramad))
    {
      paramad = (Iterable)paramad.klR();
      if ((!(paramad instanceof Collection)) || (!((Collection)paramad).isEmpty()))
      {
        paramad = paramad.iterator();
        do
        {
          if (!paramad.hasNext()) {
            break;
          }
        } while (!((kotlin.l.b.a.b.m.az)paramad.next()).kAM());
      }
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(59725);
        return true;
      }
    }
    AppMethodBeat.o(59725);
    return false;
  }
  
  private static boolean O(ad paramad)
  {
    AppMethodBeat.i(59736);
    if ((kotlin.l.b.a.b.a.g.e(paramad)) || (!paramad.knl().isEmpty()))
    {
      AppMethodBeat.o(59736);
      return true;
    }
    AppMethodBeat.o(59736);
    return false;
  }
  
  private final String a(kotlin.l.b.a.b.j.b.g<?> paramg)
  {
    int i = 0;
    AppMethodBeat.i(59741);
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      paramg = kotlin.a.p.a((Iterable)((kotlin.l.b.a.b.j.b.b)paramg).getValue(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (kotlin.g.a.b)new e(this), 24);
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.a))
    {
      paramg = kotlin.n.n.c(((c)this).a((kotlin.l.b.a.b.b.a.c)((kotlin.l.b.a.b.j.b.a)paramg).getValue(), null), (CharSequence)"@");
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof q))
    {
      q.b localb = (q.b)((q)paramg).getValue();
      if ((localb instanceof q.b.a))
      {
        paramg = ((q.b.a)localb).aiAd + "::class";
        AppMethodBeat.o(59741);
        return paramg;
      }
      if ((localb instanceof q.b.b))
      {
        paramg = ((q.b.b)localb).ajjT.aiEe.kxQ().PF();
        kotlin.g.b.s.s(paramg, "classValue.classId.asSingleFqName().asString()");
        int j = ((q.b.b)localb).ajjT.ajjD;
        while (i < j)
        {
          paramg = "kotlin.Array<" + paramg + '>';
          i += 1;
        }
        paramg = kotlin.g.b.s.X(paramg, "::class");
        AppMethodBeat.o(59741);
        return paramg;
      }
      paramg = new kotlin.p();
      AppMethodBeat.o(59741);
      throw paramg;
    }
    paramg = paramg.toString();
    AppMethodBeat.o(59741);
    return paramg;
  }
  
  private String a(ax paramax)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59732);
    kotlin.g.b.s.u(paramax, "typeConstructor");
    kotlin.l.b.a.b.b.h localh = paramax.knA();
    if ((localh instanceof ba))
    {
      bool1 = true;
      if (!bool1) {
        break label67;
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = localh instanceof kotlin.l.b.a.b.b.az)
    {
      if (!bool1) {
        break label76;
      }
      paramax = c(localh);
      AppMethodBeat.o(59732);
      return paramax;
      bool1 = localh instanceof kotlin.l.b.a.b.b.e;
      break;
    }
    label76:
    if (localh == null)
    {
      if ((paramax instanceof ac))
      {
        paramax = ((ac)paramax).bf((kotlin.g.a.b)h.ajgT);
        AppMethodBeat.o(59732);
        return paramax;
      }
      paramax = paramax.toString();
      AppMethodBeat.o(59732);
      return paramax;
    }
    paramax = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Unexpected classifier: ", localh.getClass()).toString());
    AppMethodBeat.o(59732);
    throw paramax;
  }
  
  private static kotlin.l.b.a.b.b.ab a(aa paramaa)
  {
    AppMethodBeat.i(59744);
    if ((paramaa instanceof kotlin.l.b.a.b.b.e))
    {
      if (((kotlin.l.b.a.b.b.e)paramaa).kna() == kotlin.l.b.a.b.b.f.aiGu)
      {
        paramaa = kotlin.l.b.a.b.b.ab.aiHb;
        AppMethodBeat.o(59744);
        return paramaa;
      }
      paramaa = kotlin.l.b.a.b.b.ab.aiGY;
      AppMethodBeat.o(59744);
      return paramaa;
    }
    Object localObject = paramaa.knp();
    if ((localObject instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject = (kotlin.l.b.a.b.b.e)localObject; localObject == null; localObject = null)
    {
      paramaa = kotlin.l.b.a.b.b.ab.aiGY;
      AppMethodBeat.o(59744);
      return paramaa;
    }
    if (!(paramaa instanceof kotlin.l.b.a.b.b.b))
    {
      paramaa = kotlin.l.b.a.b.b.ab.aiGY;
      AppMethodBeat.o(59744);
      return paramaa;
    }
    Collection localCollection = ((kotlin.l.b.a.b.b.b)paramaa).kof();
    kotlin.g.b.s.s(localCollection, "this.overriddenDescriptors");
    if (!localCollection.isEmpty()) {}
    for (int i = 1; (i != 0) && (((kotlin.l.b.a.b.b.e)localObject).knb() != kotlin.l.b.a.b.b.ab.aiGY); i = 0)
    {
      paramaa = kotlin.l.b.a.b.b.ab.aiHa;
      AppMethodBeat.o(59744);
      return paramaa;
    }
    if ((((kotlin.l.b.a.b.b.e)localObject).kna() == kotlin.l.b.a.b.b.f.aiGu) && (!kotlin.g.b.s.p(((kotlin.l.b.a.b.b.b)paramaa).knc(), kotlin.l.b.a.b.b.s.aiGC)))
    {
      if (((kotlin.l.b.a.b.b.b)paramaa).knb() == kotlin.l.b.a.b.b.ab.aiHb)
      {
        paramaa = kotlin.l.b.a.b.b.ab.aiHb;
        AppMethodBeat.o(59744);
        return paramaa;
      }
      paramaa = kotlin.l.b.a.b.b.ab.aiHa;
      AppMethodBeat.o(59744);
      return paramaa;
    }
    paramaa = kotlin.l.b.a.b.b.ab.aiGY;
    AppMethodBeat.o(59744);
    return paramaa;
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.b.a.a parama, kotlin.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59737);
    if (!kyO().contains(e.ajhb))
    {
      AppMethodBeat.o(59737);
      return;
    }
    Set localSet;
    kotlin.g.a.b localb;
    if ((parama instanceof ad))
    {
      localSet = this.ajgO.kyK();
      localb = (kotlin.g.a.b)this.ajgO.ajhX.a(g.aYe[36]);
      parama = parama.knl().iterator();
    }
    for (;;)
    {
      if (!parama.hasNext()) {
        break label247;
      }
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)parama.next();
      if ((!kotlin.a.p.a((Iterable)localSet, localc.koY())) && (!kotlin.g.b.s.p(localc.koY(), k.a.aiDa)) && ((localb == null) || (((Boolean)localb.invoke(localc)).booleanValue())))
      {
        paramStringBuilder.append(a(localc, parame));
        if (((Boolean)this.ajgO.ajhU.a(g.aYe[33])).booleanValue())
        {
          kotlin.g.b.s.s(paramStringBuilder.append('\n'), "append('\\n')");
          continue;
          localSet = (Set)this.ajgO.ajhV.a(g.aYe[34]);
          break;
        }
        paramStringBuilder.append(" ");
      }
    }
    label247:
    AppMethodBeat.o(59737);
  }
  
  private final void a(StringBuilder paramStringBuilder, an paraman)
  {
    AppMethodBeat.i(59731);
    Object localObject = paraman.aiHm;
    if (localObject == null) {}
    for (localObject = null;; localObject = paramStringBuilder.append(b((kotlin.l.b.a.b.f.f)localObject, false)))
    {
      if (localObject == null)
      {
        localObject = paraman.aiHk.kmZ();
        kotlin.g.b.s.s(localObject, "possiblyInnerType.classi…escriptor.typeConstructor");
        paramStringBuilder.append(a((ax)localObject));
      }
      paramStringBuilder.append(pb(paraman.aiHl));
      AppMethodBeat.o(59731);
      return;
      a(paramStringBuilder, (an)localObject);
      paramStringBuilder.append('.');
      localObject = paraman.aiHk.kok();
      kotlin.g.b.s.s(localObject, "possiblyInnerType.classifierDescriptor.name");
    }
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(191531);
    if (((paraml instanceof kotlin.l.b.a.b.b.ah)) || ((paraml instanceof kotlin.l.b.a.b.b.al)))
    {
      AppMethodBeat.o(191531);
      return;
    }
    kotlin.l.b.a.b.b.l locall = paraml.knp();
    if ((locall != null) && (!(locall instanceof ae)))
    {
      paramStringBuilder.append(" ").append(bJl("defined in")).append(" ");
      localObject = kotlin.l.b.a.b.j.d.n(locall);
      kotlin.g.b.s.s(localObject, "getFqName(containingDeclaration)");
      if (!((kotlin.l.b.a.b.f.d)localObject).ajeC.isEmpty()) {
        break label205;
      }
    }
    label205:
    for (Object localObject = "root package";; localObject = j((kotlin.l.b.a.b.f.d)localObject))
    {
      paramStringBuilder.append((String)localObject);
      if ((((Boolean)this.ajgO.ajhp.a(g.aYe[2])).booleanValue()) && ((locall instanceof kotlin.l.b.a.b.b.ah)) && ((paraml instanceof o)))
      {
        paraml = ((o)paraml).knm().kpk().getName();
        if (paraml != null) {
          paramStringBuilder.append(" ").append(bJl("in file")).append(" ").append(paraml);
        }
      }
      AppMethodBeat.o(191531);
      return;
    }
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.a parama)
  {
    AppMethodBeat.i(59722);
    if (kyZ() == m.ajiC) {
      paramStringBuilder.append("<font color=\"808080\"><i>");
    }
    paramStringBuilder.append(" /* = ");
    c(paramStringBuilder, (ad)parama.aiUV);
    paramStringBuilder.append(" */");
    if (kyZ() == m.ajiC) {
      paramStringBuilder.append("</i></font>");
    }
    AppMethodBeat.o(59722);
  }
  
  private final void a(StringBuilder paramStringBuilder, ad paramad, ax paramax)
  {
    AppMethodBeat.i(59729);
    kotlin.g.b.s.u(paramad, "<this>");
    Object localObject = paramad.kzm().knA();
    if ((localObject instanceof i)) {}
    for (localObject = (i)localObject;; localObject = null)
    {
      localObject = bb.a(paramad, (i)localObject, 0);
      if (localObject != null) {
        break;
      }
      paramStringBuilder.append(a(paramax));
      paramStringBuilder.append(pb(paramad.klR()));
      AppMethodBeat.o(59729);
      return;
    }
    a(paramStringBuilder, (an)localObject);
    AppMethodBeat.o(59729);
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.al paramal)
  {
    AppMethodBeat.i(59724);
    if ((kotlin.g.b.s.p(paramal, bg.ajqG)) || (bg.as((ad)paramal)))
    {
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (v.ab((ad)paramal))
    {
      if (kza())
      {
        paramal.kzm();
        AppMethodBeat.o(59724);
        throw null;
      }
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (af.ai((ad)paramal))
    {
      d(paramStringBuilder, (ad)paramal);
      AppMethodBeat.o(59724);
      return;
    }
    if (N((ad)paramal))
    {
      e(paramStringBuilder, (ad)paramal);
      AppMethodBeat.o(59724);
      return;
    }
    d(paramStringBuilder, (ad)paramal);
    AppMethodBeat.o(59724);
  }
  
  private final void a(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(59748);
    if (paramBoolean)
    {
      paramStringBuilder.append(bJk(paramString));
      paramStringBuilder.append(" ");
    }
    AppMethodBeat.o(59748);
  }
  
  private final void a(Collection<? extends bd> paramCollection, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59758);
    Object localObject = (k)this.ajgO.ajhP.a(g.aYe[28]);
    boolean bool1 = bool2;
    switch (b.avl[localObject.ordinal()])
    {
    default: 
      paramCollection = new kotlin.p();
      AppMethodBeat.o(59758);
      throw paramCollection;
    case 2: 
      if (!paramBoolean) {
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      int j = paramCollection.size();
      kzb().f(paramStringBuilder);
      paramCollection = paramCollection.iterator();
      int i = 0;
      while (paramCollection.hasNext())
      {
        localObject = (bd)paramCollection.next();
        kzb().a((bd)localObject, paramStringBuilder);
        a((bd)localObject, bool1, paramStringBuilder, false);
        kzb().a((bd)localObject, i, j, paramStringBuilder);
        i += 1;
      }
      bool1 = false;
      continue;
      bool1 = false;
    }
    kzb().g(paramStringBuilder);
    AppMethodBeat.o(59758);
  }
  
  private final void a(List<? extends ba> paramList, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59757);
    if (kzd())
    {
      AppMethodBeat.o(59757);
      return;
    }
    ArrayList localArrayList = new ArrayList(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ba localba = (ba)paramList.next();
      Object localObject1 = localba.klF();
      kotlin.g.b.s.s(localObject1, "typeParameter.upperBounds");
      localObject1 = ((Iterable)kotlin.a.p.k((Iterable)localObject1)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        localObject2 = (ad)localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        kotlin.l.b.a.b.f.f localf = localba.kok();
        kotlin.g.b.s.s(localf, "typeParameter.name");
        localStringBuilder = localStringBuilder.append(b(localf, false)).append(" : ");
        kotlin.g.b.s.s(localObject2, "it");
        localCollection.add(b((ad)localObject2));
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ").append(bJk("where")).append(" ");
        kotlin.a.p.a((Iterable)localArrayList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, null, 124);
      }
      AppMethodBeat.o(59757);
      return;
    }
  }
  
  private final void a(List<? extends ba> paramList, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59753);
    if (kzd())
    {
      AppMethodBeat.o(59753);
      return;
    }
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(EQ("<"));
        c(paramStringBuilder, paramList);
        paramStringBuilder.append(EQ(">"));
        if (paramBoolean) {
          paramStringBuilder.append(" ");
        }
      }
      AppMethodBeat.o(59753);
      return;
    }
  }
  
  private final void a(kotlin.l.b.a.b.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59755);
    if (!((Boolean)this.ajgO.ajhQ.a(g.aYe[29])).booleanValue())
    {
      AppMethodBeat.o(59755);
      return;
    }
    parama = parama.knY();
    if (parama != null)
    {
      paramStringBuilder = paramStringBuilder.append(" on ");
      parama = parama.koG();
      kotlin.g.b.s.s(parama, "receiver.type");
      paramStringBuilder.append(b(parama));
    }
    AppMethodBeat.o(59755);
  }
  
  private final void a(aa paramaa, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59749);
    a(paramStringBuilder, paramaa.knk(), "external");
    if ((kyO().contains(e.ajhg)) && (paramaa.kni()))
    {
      bool1 = true;
      a(paramStringBuilder, bool1, "expect");
      if ((!kyO().contains(e.ajhh)) || (!paramaa.knj())) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(paramStringBuilder, bool1, "actual");
      AppMethodBeat.o(59749);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void a(kotlin.l.b.a.b.b.ab paramab1, StringBuilder paramStringBuilder, kotlin.l.b.a.b.b.ab paramab2)
  {
    AppMethodBeat.i(59743);
    if ((!((Boolean)this.ajgO.ajhB.a(g.aYe[14])).booleanValue()) && (paramab1 == paramab2))
    {
      AppMethodBeat.o(59743);
      return;
    }
    a(paramStringBuilder, kyO().contains(e.ajgZ), kotlin.l.b.a.b.n.a.a.bJz(paramab1.name()));
    AppMethodBeat.o(59743);
  }
  
  private final void a(kotlin.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59745);
    if ((!kotlin.l.b.a.b.j.d.r((kotlin.l.b.a.b.b.l)paramb)) || (paramb.knb() != kotlin.l.b.a.b.b.ab.aiGY))
    {
      if ((kyP() == j.ajip) && (paramb.knb() == kotlin.l.b.a.b.b.ab.aiHa) && (s(paramb)))
      {
        AppMethodBeat.o(59745);
        return;
      }
      kotlin.l.b.a.b.b.ab localab = paramb.knb();
      kotlin.g.b.s.s(localab, "callable.modality");
      a(localab, paramStringBuilder, a((aa)paramb));
    }
    AppMethodBeat.o(59745);
  }
  
  private final void a(ba paramba, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(59752);
    if (paramBoolean) {
      paramStringBuilder.append(EQ("<"));
    }
    if (kzc()) {
      paramStringBuilder.append("/*").append(paramba.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, paramba.kon(), "reified");
    Object localObject = paramba.kom().label;
    boolean bool;
    if (((CharSequence)localObject).length() > 0)
    {
      bool = true;
      a(paramStringBuilder, bool, (String)localObject);
      a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramba, null);
      a((kotlin.l.b.a.b.b.l)paramba, paramStringBuilder, paramBoolean);
      int j = paramba.klF().size();
      if (((j <= 1) || (paramBoolean)) && (j != 1)) {
        break label237;
      }
      paramba = (ad)paramba.klF().iterator().next();
      if (!kotlin.l.b.a.b.a.h.u(paramba))
      {
        localObject = paramStringBuilder.append(" : ");
        kotlin.g.b.s.s(paramba, "upperBound");
        ((StringBuilder)localObject).append(b(paramba));
      }
    }
    label237:
    while (!paramBoolean)
    {
      if (paramBoolean) {
        paramStringBuilder.append(EQ(">"));
      }
      AppMethodBeat.o(59752);
      return;
      bool = false;
      break;
    }
    paramba = paramba.klF().iterator();
    label253:
    while (paramba.hasNext())
    {
      localObject = (ad)paramba.next();
      if (!kotlin.l.b.a.b.a.h.u((ad)localObject))
      {
        if (i == 0) {
          break label319;
        }
        paramStringBuilder.append(" : ");
      }
    }
    for (;;)
    {
      kotlin.g.b.s.s(localObject, "upperBound");
      paramStringBuilder.append(b((ad)localObject));
      i = 0;
      break label253;
      break;
      label319:
      paramStringBuilder.append(" & ");
    }
  }
  
  private final void a(bd parambd, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    AppMethodBeat.i(59759);
    if (paramBoolean2) {
      paramStringBuilder.append(bJk("value-parameter")).append(" ");
    }
    if (kzc()) {
      paramStringBuilder.append("/*").append(parambd.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)parambd, null);
    a(paramStringBuilder, parambd.kps(), "crossinline");
    a(paramStringBuilder, parambd.kpt(), "noinline");
    Object localObject;
    label146:
    boolean bool;
    if (kyT())
    {
      localObject = parambd.kpo();
      if ((localObject instanceof kotlin.l.b.a.b.b.d))
      {
        localObject = (kotlin.l.b.a.b.b.d)localObject;
        if ((localObject == null) || (((kotlin.l.b.a.b.b.d)localObject).koA() != true)) {
          break label264;
        }
        i = 1;
        if (i == 0) {
          break label270;
        }
        bool = true;
        label154:
        if (bool) {
          a(paramStringBuilder, kyC(), "actual");
        }
        a((bf)parambd, paramBoolean1, paramStringBuilder, paramBoolean2, bool);
        if (kyI() == null) {
          break label284;
        }
        if (!this.ajgO.kyH()) {
          break label276;
        }
        paramBoolean1 = parambd.kpp();
        label209:
        if (!paramBoolean1) {
          break label284;
        }
      }
    }
    label264:
    label270:
    label276:
    label284:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = kyI();
        kotlin.g.b.s.checkNotNull(localObject);
        paramStringBuilder.append(kotlin.g.b.s.X(" = ", ((kotlin.g.a.b)localObject).invoke(parambd)));
      }
      AppMethodBeat.o(59759);
      return;
      localObject = null;
      break;
      i = 0;
      break label146;
      bool = false;
      break label154;
      paramBoolean1 = kotlin.l.b.a.b.j.d.a.b(parambd);
      break label209;
    }
  }
  
  private final void a(bf parambf, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59762);
    if (kyM())
    {
      parambf = parambf.kpv();
      if (parambf != null) {
        paramStringBuilder.append(" = ").append(EQ(a(parambf)));
      }
    }
    AppMethodBeat.o(59762);
  }
  
  private final void a(bf parambf, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59760);
    if ((paramBoolean) || (!(parambf instanceof bd))) {
      if (!parambf.kpu()) {
        break label53;
      }
    }
    label53:
    for (parambf = "var";; parambf = "val")
    {
      paramStringBuilder.append(bJk(parambf)).append(" ");
      AppMethodBeat.o(59760);
      return;
    }
  }
  
  private final void a(bf parambf, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(59761);
    ad localad = parambf.koG();
    kotlin.g.b.s.s(localad, "variable.type");
    Object localObject1;
    if ((parambf instanceof bd))
    {
      localObject1 = (bd)parambf;
      if (localObject1 != null) {
        break label187;
      }
      localObject1 = localObject2;
      label47:
      if (localObject1 != null) {
        break label199;
      }
      localObject2 = localad;
      label56:
      if (localObject1 == null) {
        break label206;
      }
    }
    label187:
    label199:
    label206:
    for (boolean bool = true;; bool = false)
    {
      a(paramStringBuilder, bool, "vararg");
      if ((paramBoolean3) || ((paramBoolean2) && (!kyY()))) {
        a(parambf, paramStringBuilder, paramBoolean3);
      }
      if (paramBoolean1)
      {
        a((kotlin.l.b.a.b.b.l)parambf, paramStringBuilder, paramBoolean2);
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(b(localObject2));
      a(parambf, paramStringBuilder);
      if ((kzc()) && (localObject1 != null)) {
        paramStringBuilder.append(" /*").append(b(localad)).append("*/");
      }
      AppMethodBeat.o(59761);
      return;
      localObject1 = null;
      break;
      localObject1 = ((bd)localObject1).kpq();
      break label47;
      localObject2 = localObject1;
      break label56;
    }
  }
  
  private final void a(i parami, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59763);
    List localList1 = parami.kno();
    kotlin.g.b.s.s(localList1, "classifier.declaredTypeParameters");
    List localList2 = parami.kmZ().klq();
    kotlin.g.b.s.s(localList2, "classifier.typeConstructor.parameters");
    if ((kzc()) && (parami.kne()) && (localList2.size() > localList1.size()))
    {
      paramStringBuilder.append(" /*captured type parameters: ");
      c(paramStringBuilder, localList2.subList(localList1.size(), localList2.size()));
      paramStringBuilder.append("*/");
    }
    AppMethodBeat.o(59763);
  }
  
  private final void a(kotlin.l.b.a.b.b.l paraml, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59717);
    paraml = paraml.kok();
    kotlin.g.b.s.s(paraml, "descriptor.name");
    paramStringBuilder.append(b(paraml, paramBoolean));
    AppMethodBeat.o(59717);
  }
  
  private final void a(kotlin.l.b.a.b.b.x paramx, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59750);
    a(paramStringBuilder, paramx.koN(), "suspend");
    AppMethodBeat.o(59750);
  }
  
  private final void a(kotlin.l.b.a.b.f.c paramc, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59764);
    paramStringBuilder.append(bJk(paramString));
    paramc = paramc.kxR();
    kotlin.g.b.s.s(paramc, "fqName.toUnsafe()");
    paramc = j(paramc);
    if (((CharSequence)paramc).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ");
        paramStringBuilder.append(paramc);
      }
      AppMethodBeat.o(59764);
      return;
    }
  }
  
  private final boolean a(t paramt, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(191533);
    if (!kyO().contains(e.ajgY))
    {
      AppMethodBeat.o(191533);
      return false;
    }
    t localt = paramt;
    if (((Boolean)this.ajgO.ajhz.a(g.aYe[12])).booleanValue()) {
      localt = paramt.koD();
    }
    if ((!this.ajgO.kzg()) && (kotlin.g.b.s.p(localt, kotlin.l.b.a.b.b.s.aiGN)))
    {
      AppMethodBeat.o(191533);
      return false;
    }
    paramStringBuilder.append(bJk(localt.koC())).append(" ");
    AppMethodBeat.o(191533);
    return true;
  }
  
  private final void b(StringBuilder paramStringBuilder, List<? extends kotlin.l.b.a.b.m.az> paramList)
  {
    AppMethodBeat.i(59734);
    kotlin.a.p.a((Iterable)paramList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (kotlin.g.a.b)new c(this), 60);
    AppMethodBeat.o(59734);
  }
  
  private final void b(StringBuilder paramStringBuilder, ad paramad)
  {
    AppMethodBeat.i(59721);
    Object localObject = paramad.kAK();
    if ((localObject instanceof kotlin.l.b.a.b.m.a)) {
      localObject = (kotlin.l.b.a.b.m.a)localObject;
    }
    while (localObject != null) {
      if (kyU())
      {
        c(paramStringBuilder, (ad)((kotlin.l.b.a.b.m.a)localObject).aiUV);
        AppMethodBeat.o(59721);
        return;
        localObject = null;
      }
      else
      {
        c(paramStringBuilder, (ad)((kotlin.l.b.a.b.m.a)localObject).ajoN);
        if (kyV()) {
          a(paramStringBuilder, (kotlin.l.b.a.b.m.a)localObject);
        }
        AppMethodBeat.o(59721);
        return;
      }
    }
    c(paramStringBuilder, paramad);
    AppMethodBeat.o(59721);
  }
  
  private final void b(kotlin.l.b.a.b.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59756);
    parama = parama.knY();
    if (parama != null)
    {
      a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)parama, kotlin.l.b.a.b.b.a.e.aiHW);
      ad localad = parama.koG();
      kotlin.g.b.s.s(localad, "receiver.type");
      String str = b(localad);
      parama = str;
      if (N(localad))
      {
        parama = str;
        if (!bg.aw(localad)) {
          parama = "(" + str + ')';
        }
      }
      paramStringBuilder.append(parama).append(".");
    }
    AppMethodBeat.o(59756);
  }
  
  private final void b(kotlin.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59746);
    if (!kyO().contains(e.ajha))
    {
      AppMethodBeat.o(59746);
      return;
    }
    if ((s(paramb)) && (kyP() != j.ajiq))
    {
      a(paramStringBuilder, true, "override");
      if (kzc()) {
        paramStringBuilder.append("/*").append(paramb.kof().size()).append("*/ ");
      }
    }
    AppMethodBeat.o(59746);
  }
  
  private final String bJk(String paramString)
  {
    AppMethodBeat.i(59712);
    m localm = kyZ();
    switch (b.$EnumSwitchMapping$0[localm.ordinal()])
    {
    default: 
      paramString = new kotlin.p();
      AppMethodBeat.o(59712);
      throw paramString;
    case 1: 
      AppMethodBeat.o(59712);
      return paramString;
    }
    if (kyF())
    {
      AppMethodBeat.o(59712);
      return paramString;
    }
    paramString = "<b>" + paramString + "</b>";
    AppMethodBeat.o(59712);
    return paramString;
  }
  
  private String bJl(String paramString)
  {
    AppMethodBeat.i(191493);
    kotlin.g.b.s.u(paramString, "message");
    m localm = kyZ();
    switch (b.$EnumSwitchMapping$0[localm.ordinal()])
    {
    default: 
      paramString = new kotlin.p();
      AppMethodBeat.o(191493);
      throw paramString;
    case 1: 
      AppMethodBeat.o(191493);
      return paramString;
    }
    paramString = "<i>" + paramString + "</i>";
    AppMethodBeat.o(191493);
    return paramString;
  }
  
  private String c(kotlin.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(59719);
    kotlin.g.b.s.u(paramh, "klass");
    if (v.L((kotlin.l.b.a.b.b.l)paramh))
    {
      paramh = paramh.kmZ().toString();
      AppMethodBeat.o(59719);
      return paramh;
    }
    paramh = kyG().a(paramh, (c)this);
    AppMethodBeat.o(59719);
    return paramh;
  }
  
  private final void c(StringBuilder paramStringBuilder, List<? extends ba> paramList)
  {
    AppMethodBeat.i(59754);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a((ba)paramList.next(), paramStringBuilder, false);
      if (paramList.hasNext()) {
        paramStringBuilder.append(", ");
      }
    }
    AppMethodBeat.o(59754);
  }
  
  private final void c(StringBuilder paramStringBuilder, ad paramad)
  {
    AppMethodBeat.i(59723);
    if (((paramad instanceof bm)) && (this.ajgO.kyH()) && (!((bm)paramad).kAv()))
    {
      paramStringBuilder.append("<Not computed yet>");
      AppMethodBeat.o(59723);
      return;
    }
    paramad = paramad.kAK();
    if ((paramad instanceof kotlin.l.b.a.b.m.x))
    {
      paramStringBuilder.append(((kotlin.l.b.a.b.m.x)paramad).a((c)this, (f)this));
      AppMethodBeat.o(59723);
      return;
    }
    if ((paramad instanceof kotlin.l.b.a.b.m.al)) {
      a(paramStringBuilder, (kotlin.l.b.a.b.m.al)paramad);
    }
    AppMethodBeat.o(59723);
  }
  
  private final void c(kotlin.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59747);
    if (!kyO().contains(e.ajhd))
    {
      AppMethodBeat.o(59747);
      return;
    }
    if ((kzc()) && (paramb.koh() != b.a.aiGl)) {
      paramStringBuilder.append("/*").append(kotlin.l.b.a.b.n.a.a.bJz(paramb.koh().name())).append("*/ ");
    }
    AppMethodBeat.o(59747);
  }
  
  private final void d(StringBuilder paramStringBuilder, ad paramad)
  {
    AppMethodBeat.i(59728);
    a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramad, null);
    Object localObject;
    if ((paramad instanceof kotlin.l.b.a.b.m.m))
    {
      localObject = (kotlin.l.b.a.b.m.m)paramad;
      if (localObject != null) {
        break label122;
      }
      localObject = null;
      label34:
      if (!af.ai(paramad)) {
        break label174;
      }
      if ((!(paramad instanceof bj)) || (!kyR())) {
        break label130;
      }
      paramStringBuilder.append(((bj)paramad).ajpv);
      label67:
      paramStringBuilder.append(pb(paramad.klR()));
    }
    for (;;)
    {
      if (paramad.ksB()) {
        paramStringBuilder.append("?");
      }
      if (kotlin.l.b.a.b.m.ao.ak(paramad)) {
        paramStringBuilder.append("!!");
      }
      AppMethodBeat.o(59728);
      return;
      localObject = null;
      break;
      label122:
      localObject = ((kotlin.l.b.a.b.m.m)localObject).ajpp;
      break label34;
      label130:
      if (((paramad instanceof kotlin.l.b.a.b.m.u)) && (!kyN()))
      {
        paramStringBuilder.append(((kotlin.l.b.a.b.m.u)paramad).kAE());
        break label67;
      }
      paramStringBuilder.append(paramad.kzm().toString());
      break label67;
      label174:
      if ((paramad instanceof kotlin.l.b.a.b.m.as)) {
        paramStringBuilder.append(((kotlin.l.b.a.b.m.as)paramad).ajoR.toString());
      } else if ((localObject instanceof kotlin.l.b.a.b.m.as)) {
        paramStringBuilder.append(((kotlin.l.b.a.b.m.as)localObject).ajoR.toString());
      } else {
        a(this, paramStringBuilder, paramad);
      }
    }
  }
  
  private final void e(StringBuilder paramStringBuilder, ad paramad)
  {
    int k = 1;
    AppMethodBeat.i(59735);
    int m = paramStringBuilder.length();
    kze().a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramad, null);
    int j;
    boolean bool2;
    int i;
    label75:
    label93:
    kotlin.l.b.a.b.m.az localaz;
    if (paramStringBuilder.length() != m)
    {
      j = 1;
      boolean bool1 = kotlin.l.b.a.b.a.g.e(paramad);
      bool2 = paramad.ksB();
      localObject = kotlin.l.b.a.b.a.g.h(paramad);
      if ((!bool2) && ((j == 0) || (localObject == null))) {
        break label319;
      }
      i = 1;
      if (i != 0)
      {
        if (!bool1) {
          break label324;
        }
        paramStringBuilder.insert(m, '(');
      }
      a(paramStringBuilder, bool1, "suspend");
      if (localObject != null)
      {
        if (N((ad)localObject))
        {
          j = k;
          if (!((ad)localObject).ksB()) {}
        }
        else
        {
          if (!O((ad)localObject)) {
            break label417;
          }
          j = k;
        }
        label140:
        if (j != 0) {
          paramStringBuilder.append("(");
        }
        b(paramStringBuilder, (ad)localObject);
        if (j != 0) {
          paramStringBuilder.append(")");
        }
        paramStringBuilder.append(".");
      }
      paramStringBuilder.append("(");
      Iterator localIterator = kotlin.l.b.a.b.a.g.j(paramad).iterator();
      j = 0;
      label203:
      if (!localIterator.hasNext()) {
        break label429;
      }
      localaz = (kotlin.l.b.a.b.m.az)localIterator.next();
      if (j > 0) {
        paramStringBuilder.append(", ");
      }
      if (!kyQ()) {
        break label423;
      }
      localObject = localaz.koG();
      kotlin.g.b.s.s(localObject, "typeProjection.type");
    }
    label417:
    label423:
    for (Object localObject = kotlin.l.b.a.b.a.g.k((ad)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        paramStringBuilder.append(b((kotlin.l.b.a.b.f.f)localObject, false));
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(a(localaz));
      j += 1;
      break label203;
      j = 0;
      break;
      label319:
      i = 0;
      break label75;
      label324:
      if (j != 0)
      {
        boolean bool3 = kotlin.n.a.I(kotlin.n.n.bz((CharSequence)paramStringBuilder));
        if ((ak.aiuY) && (!bool3))
        {
          paramStringBuilder = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(59735);
          throw paramStringBuilder;
        }
        if (paramStringBuilder.charAt(kotlin.n.n.bt((CharSequence)paramStringBuilder) - 1) != ')') {
          paramStringBuilder.insert(kotlin.n.n.bt((CharSequence)paramStringBuilder), "()");
        }
      }
      paramStringBuilder.append("(");
      break label93;
      j = 0;
      break label140;
    }
    label429:
    paramStringBuilder.append(") ").append(kzf()).append(" ");
    b(paramStringBuilder, kotlin.l.b.a.b.a.g.i(paramad));
    if (i != 0) {
      paramStringBuilder.append(")");
    }
    if (bool2) {
      paramStringBuilder.append("?");
    }
    AppMethodBeat.o(59735);
  }
  
  private static void h(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59765);
    int i = paramStringBuilder.length();
    if ((i == 0) || (paramStringBuilder.charAt(i - 1) != ' ')) {
      paramStringBuilder.append(' ');
    }
    AppMethodBeat.o(59765);
  }
  
  private final List<String> i(kotlin.l.b.a.b.b.a.c paramc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(59740);
    Object localObject2 = paramc.kpA();
    if (((Boolean)this.ajgO.ajhT.a(g.aYe[32])).booleanValue())
    {
      paramc = kotlin.l.b.a.b.j.d.a.j(paramc);
      if (paramc != null) {
        break label162;
      }
      paramc = (kotlin.l.b.a.b.b.a.c)localObject1;
      label54:
      localObject1 = paramc;
      if (paramc == null) {
        localObject1 = (List)kotlin.a.ab.aivy;
      }
      localObject3 = (Iterable)localObject1;
      paramc = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
    }
    label93:
    Object localObject5;
    label162:
    label335:
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label337;
      }
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (kotlin.l.b.a.b.f.f)localObject4;
      kotlin.g.b.s.s(localObject5, "it");
      if (!((Map)localObject2).containsKey(localObject5)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label335;
        }
        paramc.add(localObject4);
        break label93;
        paramc = null;
        break;
        localObject3 = paramc.kns();
        paramc = (kotlin.l.b.a.b.b.a.c)localObject1;
        if (localObject3 == null) {
          break label54;
        }
        localObject3 = ((kotlin.l.b.a.b.b.d)localObject3).kod();
        paramc = (kotlin.l.b.a.b.b.a.c)localObject1;
        if (localObject3 == null) {
          break label54;
        }
        localObject1 = (Iterable)localObject3;
        paramc = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((Iterator)localObject1).next();
          if (((bd)localObject3).kpp()) {
            paramc.add(localObject3);
          }
        }
        localObject1 = (Iterable)paramc;
        paramc = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramc.add(((bd)((Iterator)localObject1).next()).kok());
        }
        paramc = (List)paramc;
        break label54;
      }
    }
    label337:
    Object localObject3 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      paramc.add(kotlin.g.b.s.X(((kotlin.l.b.a.b.f.f)((Iterator)localObject3).next()).PF(), " = ..."));
    }
    localObject3 = (List)paramc;
    paramc = (Iterable)((Map)localObject2).entrySet();
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a(paramc, 10));
    Object localObject4 = paramc.iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Map.Entry)((Iterator)localObject4).next();
      paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject5).getKey();
      kotlin.l.b.a.b.j.b.g localg = (kotlin.l.b.a.b.j.b.g)((Map.Entry)localObject5).getValue();
      localObject5 = new StringBuilder().append(paramc.PF()).append(" = ");
      if (!((List)localObject1).contains(paramc)) {}
      for (paramc = a(localg);; paramc = "...")
      {
        ((Collection)localObject2).add(paramc);
        break;
      }
    }
    paramc = (List)localObject2;
    paramc = kotlin.a.p.n((Iterable)kotlin.a.p.b((Collection)localObject3, (Iterable)paramc));
    AppMethodBeat.o(59740);
    return paramc;
  }
  
  private boolean kyA()
  {
    AppMethodBeat.i(191394);
    g localg = this.ajgO;
    kotlin.g.b.s.u(localg, "this");
    boolean bool = localg.kyE().ajgj;
    AppMethodBeat.o(191394);
    return bool;
  }
  
  private boolean kyB()
  {
    AppMethodBeat.i(191395);
    g localg = this.ajgO;
    kotlin.g.b.s.u(localg, "this");
    boolean bool = localg.kyE().ajgk;
    AppMethodBeat.o(191395);
    return bool;
  }
  
  private boolean kyC()
  {
    AppMethodBeat.i(191398);
    boolean bool = ((Boolean)this.ajgO.ajhE.a(g.aYe[17])).booleanValue();
    AppMethodBeat.o(191398);
    return bool;
  }
  
  private boolean kyD()
  {
    AppMethodBeat.i(191400);
    boolean bool = ((Boolean)this.ajgO.ajhZ.a(g.aYe[38])).booleanValue();
    AppMethodBeat.o(191400);
    return bool;
  }
  
  private boolean kyF()
  {
    AppMethodBeat.i(191401);
    boolean bool = ((Boolean)this.ajgO.ajih.a(g.aYe[46])).booleanValue();
    AppMethodBeat.o(191401);
    return bool;
  }
  
  private b kyG()
  {
    AppMethodBeat.i(191404);
    b localb = (b)this.ajgO.ajhn.a(g.aYe[0]);
    AppMethodBeat.o(191404);
    return localb;
  }
  
  private kotlin.g.a.b<bd, String> kyI()
  {
    AppMethodBeat.i(191406);
    kotlin.g.a.b localb = (kotlin.g.a.b)this.ajgO.ajhK.a(g.aYe[23]);
    AppMethodBeat.o(191406);
    return localb;
  }
  
  private boolean kyL()
  {
    AppMethodBeat.i(191409);
    boolean bool = ((Boolean)this.ajgO.ajid.a(g.aYe[42])).booleanValue();
    AppMethodBeat.o(191409);
    return bool;
  }
  
  private boolean kyM()
  {
    AppMethodBeat.i(191412);
    boolean bool = ((Boolean)this.ajgO.ajhG.a(g.aYe[19])).booleanValue();
    AppMethodBeat.o(191412);
    return bool;
  }
  
  private boolean kyN()
  {
    AppMethodBeat.i(191417);
    boolean bool = ((Boolean)this.ajgO.ajii.a(g.aYe[47])).booleanValue();
    AppMethodBeat.o(191417);
    return bool;
  }
  
  private Set<e> kyO()
  {
    AppMethodBeat.i(185566);
    Set localSet = (Set)this.ajgO.ajhq.a(g.aYe[3]);
    AppMethodBeat.o(185566);
    return localSet;
  }
  
  private j kyP()
  {
    AppMethodBeat.i(191422);
    j localj = (j)this.ajgO.ajhM.a(g.aYe[25]);
    AppMethodBeat.o(191422);
    return localj;
  }
  
  private boolean kyQ()
  {
    AppMethodBeat.i(191426);
    boolean bool = ((Boolean)this.ajgO.ajie.a(g.aYe[43])).booleanValue();
    AppMethodBeat.o(191426);
    return bool;
  }
  
  private boolean kyR()
  {
    AppMethodBeat.i(191431);
    boolean bool = ((Boolean)this.ajgO.ajig.a(g.aYe[45])).booleanValue();
    AppMethodBeat.o(191431);
    return bool;
  }
  
  private boolean kyT()
  {
    AppMethodBeat.i(191436);
    boolean bool = ((Boolean)this.ajgO.ajhD.a(g.aYe[16])).booleanValue();
    AppMethodBeat.o(191436);
    return bool;
  }
  
  private boolean kyU()
  {
    AppMethodBeat.i(191440);
    boolean bool = ((Boolean)this.ajgO.ajic.a(g.aYe[41])).booleanValue();
    AppMethodBeat.o(191440);
    return bool;
  }
  
  private boolean kyV()
  {
    AppMethodBeat.i(191444);
    boolean bool = ((Boolean)this.ajgO.ajib.a(g.aYe[40])).booleanValue();
    AppMethodBeat.o(191444);
    return bool;
  }
  
  private boolean kyW()
  {
    AppMethodBeat.i(191449);
    boolean bool = ((Boolean)this.ajgO.ajhL.a(g.aYe[24])).booleanValue();
    AppMethodBeat.o(191449);
    return bool;
  }
  
  private boolean kyX()
  {
    AppMethodBeat.i(191453);
    boolean bool = ((Boolean)this.ajgO.ajhs.a(g.aYe[5])).booleanValue();
    AppMethodBeat.o(191453);
    return bool;
  }
  
  private boolean kyY()
  {
    AppMethodBeat.i(191455);
    boolean bool = ((Boolean)this.ajgO.ajhr.a(g.aYe[4])).booleanValue();
    AppMethodBeat.o(191455);
    return bool;
  }
  
  private m kyZ()
  {
    AppMethodBeat.i(191459);
    m localm = (m)this.ajgO.ajhO.a(g.aYe[27]);
    AppMethodBeat.o(191459);
    return localm;
  }
  
  private boolean kza()
  {
    AppMethodBeat.i(191463);
    boolean bool = ((Boolean)this.ajgO.ajhF.a(g.aYe[18])).booleanValue();
    AppMethodBeat.o(191463);
    return bool;
  }
  
  private c.l kzb()
  {
    AppMethodBeat.i(191467);
    c.l locall = (c.l)this.ajgO.ajhN.a(g.aYe[26]);
    AppMethodBeat.o(191467);
    return locall;
  }
  
  private boolean kzc()
  {
    AppMethodBeat.i(191470);
    boolean bool = ((Boolean)this.ajgO.ajhv.a(g.aYe[8])).booleanValue();
    AppMethodBeat.o(191470);
    return bool;
  }
  
  private boolean kzd()
  {
    AppMethodBeat.i(191474);
    boolean bool = ((Boolean)this.ajgO.ajhH.a(g.aYe[20])).booleanValue();
    AppMethodBeat.o(191474);
    return bool;
  }
  
  private final d kze()
  {
    AppMethodBeat.i(59710);
    d locald = (d)this.ajgP.getValue();
    AppMethodBeat.o(59710);
    return locald;
  }
  
  private final String kzf()
  {
    AppMethodBeat.i(59715);
    Object localObject = kyZ();
    switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new kotlin.p();
      AppMethodBeat.o(59715);
      throw ((Throwable)localObject);
    case 1: 
      localObject = EQ("->");
      AppMethodBeat.o(59715);
      return localObject;
    }
    AppMethodBeat.o(59715);
    return "&rarr;";
  }
  
  private static String m(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(59766);
    if ((kotlin.n.n.U(paramString1, paramString2, false)) && (kotlin.n.n.U(paramString3, paramString4, false)))
    {
      int i = paramString2.length();
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString1 = paramString1.substring(i);
      kotlin.g.b.s.s(paramString1, "(this as java.lang.String).substring(startIndex)");
      i = paramString4.length();
      if (paramString3 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString2 = paramString3.substring(i);
      kotlin.g.b.s.s(paramString2, "(this as java.lang.String).substring(startIndex)");
      paramString3 = kotlin.g.b.s.X(paramString5, paramString1);
      if (kotlin.g.b.s.p(paramString1, paramString2))
      {
        AppMethodBeat.o(59766);
        return paramString3;
      }
      if (rp(paramString1, paramString2))
      {
        paramString1 = kotlin.g.b.s.X(paramString3, "!");
        AppMethodBeat.o(59766);
        return paramString1;
      }
    }
    AppMethodBeat.o(59766);
    return null;
  }
  
  private String pb(List<? extends kotlin.l.b.a.b.m.az> paramList)
  {
    AppMethodBeat.i(59727);
    kotlin.g.b.s.u(paramList, "typeArguments");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(59727);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EQ("<"));
    b(localStringBuilder, paramList);
    localStringBuilder.append(EQ(">"));
    paramList = localStringBuilder.toString();
    kotlin.g.b.s.s(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59727);
    return paramList;
  }
  
  private static boolean rp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59767);
    if ((kotlin.g.b.s.p(paramString1, kotlin.n.n.m(paramString2, "?", "", false))) || ((kotlin.n.n.rs(paramString2, "?")) && (kotlin.g.b.s.p(kotlin.g.b.s.X(paramString1, "?"), paramString2))) || (kotlin.g.b.s.p("(" + paramString1 + ")?", paramString2)))
    {
      AppMethodBeat.o(59767);
      return true;
    }
    AppMethodBeat.o(59767);
    return false;
  }
  
  private static boolean s(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59768);
    if (!paramb.kof().isEmpty())
    {
      AppMethodBeat.o(59768);
      return true;
    }
    AppMethodBeat.o(59768);
    return false;
  }
  
  public final void O(Set<kotlin.l.b.a.b.f.c> paramSet)
  {
    AppMethodBeat.i(59777);
    kotlin.g.b.s.u(paramSet, "<set-?>");
    this.ajgO.O(paramSet);
    AppMethodBeat.o(59777);
  }
  
  public final void P(Set<? extends e> paramSet)
  {
    AppMethodBeat.i(59778);
    kotlin.g.b.s.u(paramSet, "<set-?>");
    this.ajgO.P(paramSet);
    AppMethodBeat.o(59778);
  }
  
  public final void PA(boolean paramBoolean)
  {
    AppMethodBeat.i(59787);
    this.ajgO.PA(paramBoolean);
    AppMethodBeat.o(59787);
  }
  
  public final void Pu(boolean paramBoolean)
  {
    AppMethodBeat.i(59780);
    this.ajgO.Pu(paramBoolean);
    AppMethodBeat.o(59780);
  }
  
  public final void Pv(boolean paramBoolean)
  {
    AppMethodBeat.i(59781);
    this.ajgO.Pv(paramBoolean);
    AppMethodBeat.o(59781);
  }
  
  public final void Pw(boolean paramBoolean)
  {
    AppMethodBeat.i(59782);
    this.ajgO.Pw(paramBoolean);
    AppMethodBeat.o(59782);
  }
  
  public final void Px(boolean paramBoolean)
  {
    AppMethodBeat.i(59784);
    this.ajgO.Px(paramBoolean);
    AppMethodBeat.o(59784);
  }
  
  public final void Py(boolean paramBoolean)
  {
    AppMethodBeat.i(59785);
    this.ajgO.Py(paramBoolean);
    AppMethodBeat.o(59785);
  }
  
  public final void Pz(boolean paramBoolean)
  {
    AppMethodBeat.i(59786);
    this.ajgO.Pz(paramBoolean);
    AppMethodBeat.o(59786);
  }
  
  public final String a(String paramString1, String paramString2, kotlin.l.b.a.b.a.h paramh)
  {
    AppMethodBeat.i(59726);
    kotlin.g.b.s.u(paramString1, "lowerRendered");
    kotlin.g.b.s.u(paramString2, "upperRendered");
    kotlin.g.b.s.u(paramh, "builtIns");
    if (rp(paramString1, paramString2))
    {
      if (kotlin.n.n.U(paramString2, "(", false))
      {
        paramString1 = "(" + paramString1 + ")!";
        AppMethodBeat.o(59726);
        return paramString1;
      }
      paramString1 = kotlin.g.b.s.X(paramString1, "!");
      AppMethodBeat.o(59726);
      return paramString1;
    }
    Object localObject1 = kyG();
    Object localObject2 = paramh.a(k.a.aiDm);
    if (localObject2 == null) {
      kotlin.l.b.a.b.a.h.aKu(34);
    }
    kotlin.g.b.s.s(localObject2, "builtIns.collection");
    localObject1 = kotlin.n.n.rt(((b)localObject1).a((kotlin.l.b.a.b.b.h)localObject2, (c)this), "Collection");
    localObject2 = m(paramString1, kotlin.g.b.s.X((String)localObject1, "Mutable"), paramString2, (String)localObject1, (String)localObject1 + '(' + "Mutable" + ')');
    if (localObject2 != null)
    {
      AppMethodBeat.o(59726);
      return localObject2;
    }
    localObject1 = m(paramString1, kotlin.g.b.s.X((String)localObject1, "MutableMap.MutableEntry"), paramString2, kotlin.g.b.s.X((String)localObject1, "Map.Entry"), kotlin.g.b.s.X((String)localObject1, "(Mutable)Map.(Mutable)Entry"));
    if (localObject1 != null)
    {
      AppMethodBeat.o(59726);
      return localObject1;
    }
    localObject1 = kyG();
    paramh = paramh.bIC("Array");
    kotlin.g.b.s.s(paramh, "builtIns.array");
    paramh = kotlin.n.n.rt(((b)localObject1).a((kotlin.l.b.a.b.b.h)paramh, (c)this), "Array");
    paramh = m(paramString1, kotlin.g.b.s.X(paramh, EQ("Array<")), paramString2, kotlin.g.b.s.X(paramh, EQ("Array<out ")), kotlin.g.b.s.X(paramh, EQ("Array<(out) ")));
    if (paramh != null)
    {
      AppMethodBeat.o(59726);
      return paramh;
    }
    paramString1 = "(" + paramString1 + ".." + paramString2 + ')';
    AppMethodBeat.o(59726);
    return paramString1;
  }
  
  public final String a(kotlin.l.b.a.b.b.a.c paramc, kotlin.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59739);
    kotlin.g.b.s.u(paramc, "annotation");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('@');
    if (parame != null) {
      localStringBuilder.append(kotlin.g.b.s.X(parame.aiHQ, ":"));
    }
    parame = paramc.koG();
    localStringBuilder.append(b(parame));
    if (kyA())
    {
      paramc = i(paramc);
      if (!kyB()) {
        if (((Collection)paramc).isEmpty()) {
          break label200;
        }
      }
    }
    label200:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        kotlin.a.p.a((Iterable)paramc, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 112);
      }
      if ((kzc()) && ((af.ai(parame)) || ((parame.kzm().knA() instanceof ag.b)))) {
        localStringBuilder.append(" /* annotation class not found */");
      }
      paramc = localStringBuilder.toString();
      kotlin.g.b.s.s(paramc, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(59739);
      return paramc;
    }
  }
  
  public final String a(kotlin.l.b.a.b.m.az paramaz)
  {
    AppMethodBeat.i(59733);
    kotlin.g.b.s.u(paramaz, "typeProjection");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, kotlin.a.p.listOf(paramaz));
    paramaz = localStringBuilder.toString();
    kotlin.g.b.s.s(paramaz, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59733);
    return paramaz;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59771);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.ajgO.a(parama);
    AppMethodBeat.o(59771);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59772);
    kotlin.g.b.s.u(paramb, "<set-?>");
    this.ajgO.a(paramb);
    AppMethodBeat.o(59772);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(59779);
    kotlin.g.b.s.u(paramk, "<set-?>");
    this.ajgO.a(paramk);
    AppMethodBeat.o(59779);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(59783);
    kotlin.g.b.s.u(paramm, "<set-?>");
    this.ajgO.a(paramm);
    AppMethodBeat.o(59783);
  }
  
  public final String b(kotlin.l.b.a.b.f.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(59716);
    kotlin.g.b.s.u(paramf, "name");
    paramf = EQ(n.y(paramf));
    if ((kyF()) && (kyZ() == m.ajiC) && (paramBoolean))
    {
      paramf = "<b>" + paramf + "</b>";
      AppMethodBeat.o(59716);
      return paramf;
    }
    AppMethodBeat.o(59716);
    return paramf;
  }
  
  public final String b(ad paramad)
  {
    AppMethodBeat.i(59720);
    kotlin.g.b.s.u(paramad, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, (ad)((kotlin.g.a.b)this.ajgO.ajhJ.a(g.aYe[22])).invoke(paramad));
    paramad = localStringBuilder.toString();
    kotlin.g.b.s.s(paramad, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59720);
    return paramad;
  }
  
  public final String j(kotlin.l.b.a.b.f.d paramd)
  {
    AppMethodBeat.i(59718);
    kotlin.g.b.s.u(paramd, "fqName");
    paramd = paramd.kxV();
    kotlin.g.b.s.s(paramd, "fqName.pathSegments()");
    paramd = EQ(n.pc(paramd));
    AppMethodBeat.o(59718);
    return paramd;
  }
  
  public final String k(kotlin.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(59751);
    kotlin.g.b.s.u(paraml, "declarationDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    paraml.a((kotlin.l.b.a.b.b.n)new a(), localStringBuilder);
    if (((Boolean)this.ajgO.ajho.a(g.aYe[1])).booleanValue()) {
      a(localStringBuilder, paraml);
    }
    paraml = localStringBuilder.toString();
    kotlin.g.b.s.s(paraml, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59751);
    return paraml;
  }
  
  public final a kyE()
  {
    AppMethodBeat.i(59770);
    a locala = this.ajgO.kyE();
    AppMethodBeat.o(59770);
    return locala;
  }
  
  public final boolean kyH()
  {
    AppMethodBeat.i(185986);
    boolean bool = this.ajgO.kyH();
    AppMethodBeat.o(185986);
    return bool;
  }
  
  public final boolean kyJ()
  {
    AppMethodBeat.i(59775);
    boolean bool = this.ajgO.kyJ();
    AppMethodBeat.o(59775);
    return bool;
  }
  
  public final Set<kotlin.l.b.a.b.f.c> kyK()
  {
    AppMethodBeat.i(185987);
    Set localSet = this.ajgO.kyK();
    AppMethodBeat.o(185987);
    return localSet;
  }
  
  public final l kyS()
  {
    AppMethodBeat.i(191547);
    l locall = (l)this.ajgO.ajhS.a(g.aYe[31]);
    AppMethodBeat.o(191547);
    return locall;
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59774);
    this.ajgO.setDebugMode(paramBoolean);
    AppMethodBeat.o(59774);
  }
  
  final class a
    implements kotlin.l.b.a.b.b.n<kotlin.ah, StringBuilder>
  {
    public a()
    {
      AppMethodBeat.i(191393);
      AppMethodBeat.o(191393);
    }
    
    private final void a(kotlin.l.b.a.b.b.ao paramao, StringBuilder paramStringBuilder, String paramString)
    {
      AppMethodBeat.i(59687);
      l locall = this.ajgQ.kyS();
      switch (a.$EnumSwitchMapping$0[locall.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(59687);
        return;
        d.a(this.ajgQ, paramao, paramStringBuilder);
        paramStringBuilder.append(kotlin.g.b.s.X(paramString, " for "));
        paramString = this.ajgQ;
        paramao = paramao.kpb();
        kotlin.g.b.s.s(paramao, "descriptor.correspondingProperty");
        d.a(paramString, paramao, paramStringBuilder);
        AppMethodBeat.o(59687);
        return;
        b((kotlin.l.b.a.b.b.x)paramao, paramStringBuilder);
      }
    }
    
    private void b(kotlin.l.b.a.b.b.x paramx, StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59688);
      kotlin.g.b.s.u(paramx, "descriptor");
      kotlin.g.b.s.u(paramStringBuilder, "builder");
      d.a(this.ajgQ, paramx, paramStringBuilder);
      AppMethodBeat.o(59688);
    }
  }
  
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.az, CharSequence>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<d>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.b.g<?>, CharSequence>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, CharSequence>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, Object>
  {
    public static final h ajgT;
    
    static
    {
      AppMethodBeat.i(191397);
      ajgT = new h();
      AppMethodBeat.o(191397);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.i.d
 * JD-Core Version:    0.7.0.1
 */