package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.aa.b;
import kotlin.l.b.a.b.b.af;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.r.b;
import kotlin.l.b.a.b.j.b.r.b.a;
import kotlin.l.b.a.b.j.b.r.b.b;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.am;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bf;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.u;
import kotlin.x;
import kotlin.z;

public final class e
  extends c
  implements i
{
  private final kotlin.f abib;
  private final kotlin.f abic;
  final j abid;
  
  public e(j paramj)
  {
    AppMethodBeat.i(59769);
    this.abid = paramj;
    boolean bool = this.abid.APF;
    if ((z.aazO) && (!bool))
    {
      paramj = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59769);
      throw paramj;
    }
    this.abib = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.abic = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(59769);
  }
  
  private final String Mi(String paramString)
  {
    AppMethodBeat.i(59714);
    paramString = this.abid.iOE().Mi(paramString);
    AppMethodBeat.o(59714);
    return paramString;
  }
  
  private static boolean W(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59725);
    if (kotlin.l.b.a.b.a.f.f(paramab))
    {
      paramab = (Iterable)paramab.iOR();
      if ((!(paramab instanceof Collection)) || (!((Collection)paramab).isEmpty()))
      {
        paramab = paramab.iterator();
        do
        {
          if (!paramab.hasNext()) {
            break;
          }
        } while (!((kotlin.l.b.a.b.m.av)paramab.next()).iPZ());
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
  
  private static boolean X(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59736);
    if ((kotlin.l.b.a.b.a.f.e(paramab)) || (!paramab.iDY().isEmpty()))
    {
      AppMethodBeat.o(59736);
      return true;
    }
    AppMethodBeat.o(59736);
    return false;
  }
  
  private String a(kotlin.l.b.a.b.m.at paramat)
  {
    AppMethodBeat.i(59732);
    kotlin.g.b.p.k(paramat, "typeConstructor");
    kotlin.l.b.a.b.b.h localh = paramat.iEf();
    if (((localh instanceof as)) || ((localh instanceof kotlin.l.b.a.b.b.e)) || ((localh instanceof ar)))
    {
      paramat = b(localh);
      AppMethodBeat.o(59732);
      return paramat;
    }
    if (localh == null)
    {
      paramat = paramat.toString();
      AppMethodBeat.o(59732);
      return paramat;
    }
    paramat = (Throwable)new IllegalStateException(("Unexpected classifier: " + localh.getClass()).toString());
    AppMethodBeat.o(59732);
    throw paramat;
  }
  
  private static w a(kotlin.l.b.a.b.b.v paramv)
  {
    AppMethodBeat.i(59744);
    if ((paramv instanceof kotlin.l.b.a.b.b.e))
    {
      if (((kotlin.l.b.a.b.b.e)paramv).iDN() == kotlin.l.b.a.b.b.f.aaJZ)
      {
        paramv = w.aaKl;
        AppMethodBeat.o(59744);
        return paramv;
      }
      paramv = w.aaKi;
      AppMethodBeat.o(59744);
      return paramv;
    }
    Object localObject2 = paramv.iDJ();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof kotlin.l.b.a.b.b.e)) {
      localObject1 = null;
    }
    localObject1 = (kotlin.l.b.a.b.b.e)localObject1;
    if (localObject1 == null)
    {
      paramv = w.aaKi;
      AppMethodBeat.o(59744);
      return paramv;
    }
    if (!(paramv instanceof kotlin.l.b.a.b.b.b))
    {
      paramv = w.aaKi;
      AppMethodBeat.o(59744);
      return paramv;
    }
    localObject2 = ((kotlin.l.b.a.b.b.b)paramv).iEL();
    kotlin.g.b.p.j(localObject2, "this.overriddenDescriptors");
    if (!((Collection)localObject2).isEmpty()) {}
    for (int i = 1; (i != 0) && (((kotlin.l.b.a.b.b.e)localObject1).iDO() != w.aaKi); i = 0)
    {
      paramv = w.aaKk;
      AppMethodBeat.o(59744);
      return paramv;
    }
    if ((((kotlin.l.b.a.b.b.e)localObject1).iDN() == kotlin.l.b.a.b.b.f.aaJZ) && ((kotlin.g.b.p.h(((kotlin.l.b.a.b.b.b)paramv).iDQ(), az.aaKK) ^ true)))
    {
      if (((kotlin.l.b.a.b.b.b)paramv).iDO() == w.aaKl)
      {
        paramv = w.aaKl;
        AppMethodBeat.o(59744);
        return paramv;
      }
      paramv = w.aaKk;
      AppMethodBeat.o(59744);
      return paramv;
    }
    paramv = w.aaKi;
    AppMethodBeat.o(59744);
    return paramv;
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.b.a.a parama, kotlin.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59737);
    if (!this.abid.iOq().contains(h.abil))
    {
      AppMethodBeat.o(59737);
      return;
    }
    Set localSet;
    kotlin.g.a.b localb;
    if ((parama instanceof kotlin.l.b.a.b.m.ab))
    {
      localSet = this.abid.iOo();
      localb = (kotlin.g.a.b)this.abid.abjj.a(j.cMt[36]);
      parama = parama.iDY().iterator();
    }
    for (;;)
    {
      if (!parama.hasNext()) {
        break label227;
      }
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)parama.next();
      if ((!kotlin.a.j.a((Iterable)localSet, localc.iFy())) && ((localb == null) || (((Boolean)localb.invoke(localc)).booleanValue())))
      {
        paramStringBuilder.append(a(localc, parame));
        if (((Boolean)this.abid.abjg.a(j.cMt[33])).booleanValue())
        {
          kotlin.n.n.i(paramStringBuilder);
          continue;
          localSet = (Set)this.abid.abjh.a(j.cMt[34]);
          break;
        }
        paramStringBuilder.append(" ");
      }
    }
    label227:
    AppMethodBeat.o(59737);
  }
  
  private final void a(StringBuilder paramStringBuilder, af paramaf)
  {
    AppMethodBeat.i(59731);
    Object localObject = paramaf.aaKx;
    if (localObject != null)
    {
      a(paramStringBuilder, (af)localObject);
      paramStringBuilder.append('.');
      localObject = paramaf.aaKv.iEU();
      kotlin.g.b.p.j(localObject, "possiblyInnerType.classifierDescriptor.name");
      if (paramStringBuilder.append(b((kotlin.l.b.a.b.f.f)localObject, false)) != null) {}
    }
    else
    {
      localObject = paramaf.aaKv.iDL();
      kotlin.g.b.p.j(localObject, "possiblyInnerType.classi…escriptor.typeConstructor");
      paramStringBuilder.append(a((kotlin.l.b.a.b.m.at)localObject));
    }
    paramStringBuilder.append(lD(paramaf.aaKw));
    AppMethodBeat.o(59731);
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.a parama)
  {
    AppMethodBeat.i(59722);
    if (this.abid.iOE() == p.abjO) {
      paramStringBuilder.append("<font color=\"808080\"><i>");
    }
    paramStringBuilder.append(" /* = ");
    c(paramStringBuilder, (kotlin.l.b.a.b.m.ab)parama.aaWM);
    paramStringBuilder.append(" */");
    if (this.abid.iOE() == p.abjO) {
      paramStringBuilder.append("</i></font>");
    }
    AppMethodBeat.o(59722);
  }
  
  private final void a(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.m.at paramat)
  {
    AppMethodBeat.i(59729);
    kotlin.g.b.p.k(paramab, "$this$buildPossiblyInnerType");
    kotlin.l.b.a.b.b.h localh = paramab.iOU().iEf();
    Object localObject = localh;
    if (!(localh instanceof kotlin.l.b.a.b.b.i)) {
      localObject = null;
    }
    localObject = kotlin.l.b.a.b.b.at.a(paramab, (kotlin.l.b.a.b.b.i)localObject, 0);
    if (localObject == null)
    {
      paramStringBuilder.append(a(paramat));
      paramStringBuilder.append(lD(paramab.iOR()));
      AppMethodBeat.o(59729);
      return;
    }
    a(paramStringBuilder, (af)localObject);
    AppMethodBeat.o(59729);
  }
  
  private final void a(StringBuilder paramStringBuilder, aj paramaj)
  {
    AppMethodBeat.i(59724);
    if ((kotlin.g.b.p.h(paramaj, bc.abrm)) || (bc.aB((kotlin.l.b.a.b.m.ab)paramaj)))
    {
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (u.ak((kotlin.l.b.a.b.m.ab)paramaj))
    {
      if (this.abid.iOx())
      {
        if (paramaj.iOU() == null)
        {
          paramStringBuilder = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
          AppMethodBeat.o(59724);
          throw paramStringBuilder;
        }
        AppMethodBeat.o(59724);
        throw null;
      }
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (kotlin.l.b.a.b.m.ad.ap((kotlin.l.b.a.b.m.ab)paramaj))
    {
      d(paramStringBuilder, (kotlin.l.b.a.b.m.ab)paramaj);
      AppMethodBeat.o(59724);
      return;
    }
    if (W((kotlin.l.b.a.b.m.ab)paramaj))
    {
      e(paramStringBuilder, (kotlin.l.b.a.b.m.ab)paramaj);
      AppMethodBeat.o(59724);
      return;
    }
    d(paramStringBuilder, (kotlin.l.b.a.b.m.ab)paramaj);
    AppMethodBeat.o(59724);
  }
  
  private final void a(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(59748);
    if (paramBoolean)
    {
      paramStringBuilder.append(bHh(paramString));
      paramStringBuilder.append(" ");
    }
    AppMethodBeat.o(59748);
  }
  
  private final void a(Collection<? extends kotlin.l.b.a.b.b.av> paramCollection, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59758);
    Object localObject = (n)this.abid.abjb.a(j.cMt[28]);
    boolean bool1 = bool2;
    switch (g.yBl[localObject.ordinal()])
    {
    default: 
      paramCollection = new kotlin.m();
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
      this.abid.iOD().e(paramStringBuilder);
      paramCollection = ((Iterable)paramCollection).iterator();
      int i = 0;
      while (paramCollection.hasNext())
      {
        localObject = (kotlin.l.b.a.b.b.av)paramCollection.next();
        this.abid.iOD().a((kotlin.l.b.a.b.b.av)localObject, paramStringBuilder);
        a((kotlin.l.b.a.b.b.av)localObject, bool1, paramStringBuilder, false);
        this.abid.iOD().a((kotlin.l.b.a.b.b.av)localObject, i, j, paramStringBuilder);
        i += 1;
      }
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.abid.iOD().f(paramStringBuilder);
    AppMethodBeat.o(59758);
  }
  
  private final void a(List<? extends as> paramList, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59757);
    if (this.abid.iOz())
    {
      AppMethodBeat.o(59757);
      return;
    }
    ArrayList localArrayList = new ArrayList(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      as localas = (as)paramList.next();
      Object localObject1 = localas.iCz();
      kotlin.g.b.p.j(localObject1, "typeParameter.upperBounds");
      localObject1 = ((Iterable)kotlin.a.j.k((Iterable)localObject1)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        localObject2 = (kotlin.l.b.a.b.m.ab)localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        kotlin.l.b.a.b.f.f localf = localas.iEU();
        kotlin.g.b.p.j(localf, "typeParameter.name");
        localStringBuilder = localStringBuilder.append(b(localf, false)).append(" : ");
        kotlin.g.b.p.j(localObject2, "it");
        localCollection.add(b((kotlin.l.b.a.b.m.ab)localObject2));
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ").append(bHh("where")).append(" ");
        kotlin.a.j.a((Iterable)localArrayList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, null, 124);
      }
      AppMethodBeat.o(59757);
      return;
    }
  }
  
  private final void a(List<? extends as> paramList, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59753);
    if (this.abid.iOz())
    {
      AppMethodBeat.o(59753);
      return;
    }
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(Mi("<"));
        c(paramStringBuilder, paramList);
        paramStringBuilder.append(Mi(">"));
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
    if (!((Boolean)this.abid.abjc.a(j.cMt[29])).booleanValue())
    {
      AppMethodBeat.o(59755);
      return;
    }
    parama = parama.iEE();
    if (parama != null)
    {
      paramStringBuilder = paramStringBuilder.append(" on ");
      parama = parama.iFN();
      kotlin.g.b.p.j(parama, "receiver.type");
      paramStringBuilder.append(b(parama));
    }
    AppMethodBeat.o(59755);
  }
  
  private final void a(as paramas, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59752);
    if (paramBoolean) {
      paramStringBuilder.append(Mi("<"));
    }
    if (this.abid.iOt()) {
      paramStringBuilder.append("/*").append(paramas.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, paramas.iEX(), "reified");
    Object localObject = paramas.iEW().label;
    boolean bool;
    if (((CharSequence)localObject).length() > 0)
    {
      bool = true;
      a(paramStringBuilder, bool, (String)localObject);
      a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramas, null);
      a((l)paramas, paramStringBuilder, paramBoolean);
      i = paramas.iCz().size();
      if (((i <= 1) || (paramBoolean)) && (i != 1)) {
        break label237;
      }
      paramas = (kotlin.l.b.a.b.m.ab)paramas.iCz().iterator().next();
      if (!kotlin.l.b.a.b.a.g.B(paramas))
      {
        localObject = paramStringBuilder.append(" : ");
        kotlin.g.b.p.j(paramas, "upperBound");
        ((StringBuilder)localObject).append(b(paramas));
      }
    }
    label237:
    while (!paramBoolean)
    {
      if (paramBoolean) {
        paramStringBuilder.append(Mi(">"));
      }
      AppMethodBeat.o(59752);
      return;
      bool = false;
      break;
    }
    paramas = paramas.iCz().iterator();
    int i = 1;
    label256:
    if (paramas.hasNext())
    {
      localObject = (kotlin.l.b.a.b.m.ab)paramas.next();
      if (kotlin.l.b.a.b.a.g.B((kotlin.l.b.a.b.m.ab)localObject)) {
        break label333;
      }
      if (i == 0) {
        break label322;
      }
      paramStringBuilder.append(" : ");
      label297:
      kotlin.g.b.p.j(localObject, "upperBound");
      paramStringBuilder.append(b((kotlin.l.b.a.b.m.ab)localObject));
      i = 0;
    }
    label322:
    label333:
    for (;;)
    {
      break label256;
      break;
      paramStringBuilder.append(" & ");
      break label297;
    }
  }
  
  private final void a(kotlin.l.b.a.b.b.av paramav, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    AppMethodBeat.i(59759);
    if (paramBoolean2) {
      paramStringBuilder.append(bHh("value-parameter")).append(" ");
    }
    if (this.abid.iOt()) {
      paramStringBuilder.append("/*").append(paramav.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramav, null);
    a(paramStringBuilder, paramav.iFS(), "crossinline");
    a(paramStringBuilder, paramav.iFT(), "noinline");
    Object localObject2;
    Object localObject1;
    boolean bool;
    if (this.abid.iOv())
    {
      localObject2 = paramav.iFO();
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if ((localObject1 != null) && (((d)localObject1).iFg() == true))
      {
        bool = true;
        if (bool) {
          a(paramStringBuilder, this.abid.iOw(), "actual");
        }
        a((ax)paramav, paramBoolean1, paramStringBuilder, paramBoolean2, bool);
        if (this.abid.iOA() == null) {
          break label306;
        }
        if (!this.abid.iOm()) {
          break label298;
        }
        paramBoolean1 = paramav.iFP();
        label220:
        if (!paramBoolean1) {
          break label306;
        }
      }
    }
    label298:
    label306:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new StringBuilder(" = ");
        localObject2 = this.abid.iOA();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        paramStringBuilder.append((String)((kotlin.g.a.b)localObject2).invoke(paramav));
      }
      AppMethodBeat.o(59759);
      return;
      bool = false;
      break;
      paramBoolean1 = kotlin.l.b.a.b.j.d.a.b(paramav);
      break label220;
    }
  }
  
  private final void a(ax paramax, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59762);
    if (this.abid.iOy())
    {
      paramax = paramax.iFV();
      if (paramax != null)
      {
        paramStringBuilder = paramStringBuilder.append(" = ");
        kotlin.g.b.p.j(paramax, "constant");
        paramStringBuilder.append(Mi(b(paramax)));
        AppMethodBeat.o(59762);
        return;
      }
    }
    AppMethodBeat.o(59762);
  }
  
  private final void a(ax paramax, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59760);
    if ((paramBoolean) || (!(paramax instanceof kotlin.l.b.a.b.b.av))) {
      if (!paramax.iFU()) {
        break label53;
      }
    }
    label53:
    for (paramax = "var";; paramax = "val")
    {
      paramStringBuilder.append(bHh(paramax)).append(" ");
      AppMethodBeat.o(59760);
      return;
    }
  }
  
  private final void a(ax paramax, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(59761);
    kotlin.l.b.a.b.m.ab localab = paramax.iFN();
    kotlin.g.b.p.j(localab, "variable.type");
    if (!(paramax instanceof kotlin.l.b.a.b.b.av)) {}
    for (Object localObject1 = null;; localObject1 = paramax)
    {
      localObject1 = (kotlin.l.b.a.b.b.av)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((kotlin.l.b.a.b.b.av)localObject1).iFQ();
        if (localObject1 != null) {
          break label205;
        }
      }
      label205:
      for (Object localObject2 = localab;; localObject2 = localObject1)
      {
        if (localObject1 != null) {}
        for (boolean bool = true;; bool = false)
        {
          a(paramStringBuilder, bool, "vararg");
          if ((paramBoolean3) || ((paramBoolean2) && (!this.abid.iOr()))) {
            a(paramax, paramStringBuilder, paramBoolean3);
          }
          if (paramBoolean1)
          {
            a((l)paramax, paramStringBuilder, paramBoolean2);
            paramStringBuilder.append(": ");
          }
          paramStringBuilder.append(b((kotlin.l.b.a.b.m.ab)localObject2));
          a(paramax, paramStringBuilder);
          if ((this.abid.iOt()) && (localObject1 != null)) {
            paramStringBuilder.append(" /*").append(b(localab)).append("*/");
          }
          AppMethodBeat.o(59761);
          return;
          localObject1 = null;
          break;
        }
      }
    }
  }
  
  private final void a(kotlin.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59745);
    if ((!kotlin.l.b.a.b.j.c.r((l)paramb)) || (paramb.iDO() != w.aaKi))
    {
      if ((this.abid.iOC() == m.abjB) && (paramb.iDO() == w.aaKk) && (s(paramb)))
      {
        AppMethodBeat.o(59745);
        return;
      }
      w localw = paramb.iDO();
      kotlin.g.b.p.j(localw, "callable.modality");
      a(localw, paramStringBuilder, a((kotlin.l.b.a.b.b.v)paramb));
    }
    AppMethodBeat.o(59745);
  }
  
  private final void a(kotlin.l.b.a.b.b.i parami, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59763);
    List localList = parami.iEb();
    kotlin.g.b.p.j(localList, "classifier.declaredTypeParameters");
    Object localObject = parami.iDL();
    kotlin.g.b.p.j(localObject, "classifier.typeConstructor");
    localObject = ((kotlin.l.b.a.b.m.at)localObject).iCb();
    kotlin.g.b.p.j(localObject, "classifier.typeConstructor.parameters");
    if ((this.abid.iOt()) && (parami.iDS()) && (((List)localObject).size() > localList.size()))
    {
      paramStringBuilder.append(" /*captured type parameters: ");
      c(paramStringBuilder, ((List)localObject).subList(localList.size(), ((List)localObject).size()));
      paramStringBuilder.append("*/");
    }
    AppMethodBeat.o(59763);
  }
  
  private final void a(l paraml, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59717);
    paraml = paraml.iEU();
    kotlin.g.b.p.j(paraml, "descriptor.name");
    paramStringBuilder.append(b(paraml, paramBoolean));
    AppMethodBeat.o(59717);
  }
  
  private final void a(kotlin.l.b.a.b.b.t paramt, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59750);
    a(paramStringBuilder, paramt.iFn(), "suspend");
    AppMethodBeat.o(59750);
  }
  
  private final void a(kotlin.l.b.a.b.b.v paramv, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59749);
    a(paramStringBuilder, paramv.iDX(), "external");
    if ((this.abid.iOq().contains(h.abiq)) && (paramv.iDV()))
    {
      bool1 = true;
      a(paramStringBuilder, bool1, "expect");
      if ((!this.abid.iOq().contains(h.abir)) || (!paramv.iDW())) {
        break label112;
      }
    }
    label112:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(paramStringBuilder, bool1, "actual");
      AppMethodBeat.o(59749);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void a(w paramw1, StringBuilder paramStringBuilder, w paramw2)
  {
    AppMethodBeat.i(59743);
    if ((!((Boolean)this.abid.abiN.a(j.cMt[14])).booleanValue()) && (paramw1 == paramw2))
    {
      AppMethodBeat.o(59743);
      return;
    }
    boolean bool = this.abid.iOq().contains(h.abij);
    paramw1 = paramw1.name();
    if (paramw1 == null)
    {
      paramw1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(59743);
      throw paramw1;
    }
    paramw1 = paramw1.toLowerCase();
    kotlin.g.b.p.j(paramw1, "(this as java.lang.String).toLowerCase()");
    a(paramStringBuilder, bool, paramw1);
    AppMethodBeat.o(59743);
  }
  
  private final void a(kotlin.l.b.a.b.f.b paramb, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59764);
    paramStringBuilder.append(bHh(paramString));
    paramb = paramb.iNy();
    kotlin.g.b.p.j(paramb, "fqName.toUnsafe()");
    paramb = f(paramb);
    if (((CharSequence)paramb).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ");
        paramStringBuilder.append(paramb);
      }
      AppMethodBeat.o(59764);
      return;
    }
  }
  
  private final boolean a(ba paramba, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59742);
    if (!this.abid.iOq().contains(h.abii))
    {
      AppMethodBeat.o(59742);
      return false;
    }
    ba localba = paramba;
    if (((Boolean)this.abid.abiL.a(j.cMt[12])).booleanValue()) {
      localba = paramba.iGc();
    }
    if ((!this.abid.iOu()) && (kotlin.g.b.p.h(localba, az.aaKV)))
    {
      AppMethodBeat.o(59742);
      return false;
    }
    paramStringBuilder.append(bHh(localba.iGb())).append(" ");
    AppMethodBeat.o(59742);
    return true;
  }
  
  private String b(kotlin.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(59719);
    kotlin.g.b.p.k(paramh, "klass");
    if (u.L((l)paramh))
    {
      paramh = paramh.iDL().toString();
      AppMethodBeat.o(59719);
      return paramh;
    }
    paramh = this.abid.iOp().a(paramh, (c)this);
    AppMethodBeat.o(59719);
    return paramh;
  }
  
  private final String b(kotlin.l.b.a.b.j.b.g<?> paramg)
  {
    int i = 0;
    AppMethodBeat.i(59741);
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      paramg = kotlin.a.j.a((Iterable)((kotlin.l.b.a.b.j.b.b)paramg).getValue(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (kotlin.g.a.b)new e(this), 24);
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.a))
    {
      paramg = kotlin.n.n.b(a((kotlin.l.b.a.b.b.a.c)((kotlin.l.b.a.b.j.b.a)paramg).getValue(), null), (CharSequence)"@");
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof r))
    {
      r.b localb = (r.b)((r)paramg).getValue();
      if ((localb instanceof r.b.a))
      {
        paramg = ((r.b.a)localb).aaEm + "::class";
        AppMethodBeat.o(59741);
        return paramg;
      }
      if ((localb instanceof r.b.b))
      {
        paramg = ((r.b.b)localb).abln.aaId.iNx().qu();
        kotlin.g.b.p.j(paramg, "classValue.classId.asSingleFqName().asString()");
        int j = ((r.b.b)localb).abln.abkX;
        while (i < j)
        {
          paramg = "kotlin.Array<" + paramg + '>';
          i += 1;
        }
        paramg = paramg + "::class";
        AppMethodBeat.o(59741);
        return paramg;
      }
      paramg = new kotlin.m();
      AppMethodBeat.o(59741);
      throw paramg;
    }
    paramg = paramg.toString();
    AppMethodBeat.o(59741);
    return paramg;
  }
  
  private final void b(StringBuilder paramStringBuilder, List<? extends kotlin.l.b.a.b.m.av> paramList)
  {
    AppMethodBeat.i(59734);
    kotlin.a.j.a((Iterable)paramList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (kotlin.g.a.b)new b(this), 60);
    AppMethodBeat.o(59734);
  }
  
  private final void b(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59721);
    bg localbg = paramab.iPX();
    Object localObject = localbg;
    if (!(localbg instanceof kotlin.l.b.a.b.m.a)) {
      localObject = null;
    }
    localObject = (kotlin.l.b.a.b.m.a)localObject;
    if (localObject != null)
    {
      if (this.abid.iOI())
      {
        c(paramStringBuilder, (kotlin.l.b.a.b.m.ab)((kotlin.l.b.a.b.m.a)localObject).aaWM);
        AppMethodBeat.o(59721);
        return;
      }
      c(paramStringBuilder, (kotlin.l.b.a.b.m.ab)((kotlin.l.b.a.b.m.a)localObject).abpJ);
      if (this.abid.iOH()) {
        a(paramStringBuilder, (kotlin.l.b.a.b.m.a)localObject);
      }
      AppMethodBeat.o(59721);
      return;
    }
    c(paramStringBuilder, paramab);
    AppMethodBeat.o(59721);
  }
  
  private final void b(kotlin.l.b.a.b.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59756);
    parama = parama.iEE();
    if (parama != null)
    {
      a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)parama, kotlin.l.b.a.b.b.a.e.aaLk);
      kotlin.l.b.a.b.m.ab localab = parama.iFN();
      kotlin.g.b.p.j(localab, "receiver.type");
      String str = b(localab);
      parama = str;
      if (W(localab))
      {
        parama = str;
        if (!bc.aE(localab)) {
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
    if (!this.abid.iOq().contains(h.abik))
    {
      AppMethodBeat.o(59746);
      return;
    }
    if ((s(paramb)) && (this.abid.iOC() != m.abjC))
    {
      a(paramStringBuilder, true, "override");
      if (this.abid.iOt()) {
        paramStringBuilder.append("/*").append(paramb.iEL().size()).append("*/ ");
      }
    }
    AppMethodBeat.o(59746);
  }
  
  private final String bHh(String paramString)
  {
    AppMethodBeat.i(59712);
    p localp = this.abid.iOE();
    switch (g.$EnumSwitchMapping$0[localp.ordinal()])
    {
    default: 
      paramString = new kotlin.m();
      AppMethodBeat.o(59712);
      throw paramString;
    case 1: 
      AppMethodBeat.o(59712);
      return paramString;
    }
    if (this.abid.iOM())
    {
      AppMethodBeat.o(59712);
      return paramString;
    }
    paramString = "<b>" + paramString + "</b>";
    AppMethodBeat.o(59712);
    return paramString;
  }
  
  private final void c(StringBuilder paramStringBuilder, List<? extends as> paramList)
  {
    AppMethodBeat.i(59754);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a((as)paramList.next(), paramStringBuilder, false);
      if (paramList.hasNext()) {
        paramStringBuilder.append(", ");
      }
    }
    AppMethodBeat.o(59754);
  }
  
  private final void c(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59723);
    if (((paramab instanceof bi)) && (this.abid.iOm()) && (!((bi)paramab).iPL()))
    {
      paramStringBuilder.append("<Not computed yet>");
      AppMethodBeat.o(59723);
      return;
    }
    paramab = paramab.iPX();
    if ((paramab instanceof kotlin.l.b.a.b.m.v))
    {
      paramStringBuilder.append(((kotlin.l.b.a.b.m.v)paramab).a((c)this, (i)this));
      AppMethodBeat.o(59723);
      return;
    }
    if ((paramab instanceof aj)) {
      a(paramStringBuilder, (aj)paramab);
    }
    AppMethodBeat.o(59723);
  }
  
  private final void c(kotlin.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59747);
    if (!this.abid.iOq().contains(h.abin))
    {
      AppMethodBeat.o(59747);
      return;
    }
    if ((this.abid.iOt()) && (paramb.iEN() != b.a.aaJQ))
    {
      paramStringBuilder = paramStringBuilder.append("/*");
      paramb = paramb.iEN().name();
      if (paramb == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59747);
        throw paramb;
      }
      paramb = paramb.toLowerCase();
      kotlin.g.b.p.j(paramb, "(this as java.lang.String).toLowerCase()");
      paramStringBuilder.append(paramb).append("*/ ");
    }
    AppMethodBeat.o(59747);
  }
  
  private final void d(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59728);
    a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramab, null);
    if (kotlin.l.b.a.b.m.ad.ap(paramab)) {
      if (((paramab instanceof bf)) && (this.abid.iOL()))
      {
        paramStringBuilder.append(((bf)paramab).abqm);
        paramStringBuilder.append(lD(paramab.iOR()));
      }
    }
    for (;;)
    {
      if (paramab.iIu()) {
        paramStringBuilder.append("?");
      }
      if (am.ar(paramab)) {
        paramStringBuilder.append("!!");
      }
      AppMethodBeat.o(59728);
      return;
      if (((paramab instanceof kotlin.l.b.a.b.m.t)) && (!this.abid.iON()))
      {
        paramStringBuilder.append(((kotlin.l.b.a.b.m.t)paramab).iPS());
        break;
      }
      paramStringBuilder.append(paramab.iOU().toString());
      break;
      a(this, paramStringBuilder, paramab);
    }
  }
  
  private final void e(StringBuilder paramStringBuilder, kotlin.l.b.a.b.m.ab paramab)
  {
    int k = 1;
    AppMethodBeat.i(59735);
    int m = paramStringBuilder.length();
    iOi().a(paramStringBuilder, (kotlin.l.b.a.b.b.a.a)paramab, null);
    int j;
    boolean bool2;
    int i;
    label75:
    label93:
    kotlin.l.b.a.b.m.av localav;
    if (paramStringBuilder.length() != m)
    {
      j = 1;
      boolean bool1 = kotlin.l.b.a.b.a.f.e(paramab);
      bool2 = paramab.iIu();
      localObject = kotlin.l.b.a.b.a.f.h(paramab);
      if ((!bool2) && ((j == 0) || (localObject == null))) {
        break label329;
      }
      i = 1;
      if (i != 0)
      {
        if (!bool1) {
          break label334;
        }
        paramStringBuilder.insert(m, '(');
      }
      a(paramStringBuilder, bool1, "suspend");
      if (localObject != null)
      {
        if (W((kotlin.l.b.a.b.m.ab)localObject))
        {
          j = k;
          if (!((kotlin.l.b.a.b.m.ab)localObject).iIu()) {}
        }
        else
        {
          if (!X((kotlin.l.b.a.b.m.ab)localObject)) {
            break label436;
          }
          j = k;
        }
        label140:
        if (j != 0) {
          paramStringBuilder.append("(");
        }
        b(paramStringBuilder, (kotlin.l.b.a.b.m.ab)localObject);
        if (j != 0) {
          paramStringBuilder.append(")");
        }
        paramStringBuilder.append(".");
      }
      paramStringBuilder.append("(");
      Iterator localIterator = ((Iterable)kotlin.l.b.a.b.a.f.j(paramab)).iterator();
      j = 0;
      label206:
      if (!localIterator.hasNext()) {
        break label448;
      }
      localav = (kotlin.l.b.a.b.m.av)localIterator.next();
      if (j > 0) {
        paramStringBuilder.append(", ");
      }
      if (!this.abid.iOK()) {
        break label442;
      }
      localObject = localav.iFN();
      kotlin.g.b.p.j(localObject, "typeProjection.type");
    }
    label436:
    label442:
    for (Object localObject = kotlin.l.b.a.b.a.f.k((kotlin.l.b.a.b.m.ab)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        paramStringBuilder.append(b((kotlin.l.b.a.b.f.f)localObject, false));
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(iOj().a(localav));
      j += 1;
      break label206;
      j = 0;
      break;
      label329:
      i = 0;
      break label75;
      label334:
      if (j != 0)
      {
        if (kotlin.n.n.bi((CharSequence)paramStringBuilder) == ' ') {}
        for (j = 1; (z.aazO) && (j == 0); j = 0)
        {
          paramStringBuilder = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(59735);
          throw paramStringBuilder;
        }
        if (paramStringBuilder.charAt(kotlin.n.n.be((CharSequence)paramStringBuilder) - 1) != ')') {
          paramStringBuilder.insert(kotlin.n.n.be((CharSequence)paramStringBuilder), "()");
        }
      }
      paramStringBuilder.append("(");
      break label93;
      j = 0;
      break label140;
    }
    label448:
    paramStringBuilder.append(") ").append(iOk()).append(" ");
    b(paramStringBuilder, kotlin.l.b.a.b.a.f.i(paramab));
    if (i != 0) {
      paramStringBuilder.append(")");
    }
    if (bool2) {
      paramStringBuilder.append("?");
    }
    AppMethodBeat.o(59735);
  }
  
  private static void g(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59765);
    int i = paramStringBuilder.length();
    if ((i == 0) || (paramStringBuilder.charAt(i - 1) != ' ')) {
      paramStringBuilder.append(' ');
    }
    AppMethodBeat.o(59765);
  }
  
  private final e iOi()
  {
    AppMethodBeat.i(59710);
    e locale = (e)this.abib.getValue();
    AppMethodBeat.o(59710);
    return locale;
  }
  
  private final c iOj()
  {
    AppMethodBeat.i(59711);
    c localc = (c)this.abic.getValue();
    AppMethodBeat.o(59711);
    return localc;
  }
  
  private final String iOk()
  {
    AppMethodBeat.i(59715);
    Object localObject = this.abid.iOE();
    switch (g.tKM[localObject.ordinal()])
    {
    default: 
      localObject = new kotlin.m();
      AppMethodBeat.o(59715);
      throw ((Throwable)localObject);
    case 1: 
      localObject = Mi("->");
      AppMethodBeat.o(59715);
      return localObject;
    }
    AppMethodBeat.o(59715);
    return "&rarr;";
  }
  
  private final List<String> k(kotlin.l.b.a.b.b.a.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(59740);
    Object localObject3 = paramc.iGd();
    if (((Boolean)this.abid.abjf.a(j.cMt[32])).booleanValue()) {}
    for (Object localObject1 = kotlin.l.b.a.b.j.d.a.l(paramc);; localObject1 = null)
    {
      paramc = (kotlin.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = ((kotlin.l.b.a.b.b.e)localObject1).iDP();
      paramc = (kotlin.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = ((d)localObject1).iEJ();
      paramc = (kotlin.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = (Iterable)localObject1;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((kotlin.l.b.a.b.b.av)localObject2).iFP()) {
          paramc.add(localObject2);
        }
      }
    }
    localObject1 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (kotlin.l.b.a.b.b.av)((Iterator)localObject1).next();
      kotlin.g.b.p.j(localObject2, "it");
      paramc.add(((kotlin.l.b.a.b.b.av)localObject2).iEU());
    }
    paramc = (List)paramc;
    label236:
    localObject1 = paramc;
    if (paramc == null) {
      localObject1 = (List)kotlin.a.v.aaAd;
    }
    localObject2 = (Iterable)localObject1;
    paramc = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label330:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if (!((Map)localObject3).containsKey((kotlin.l.b.a.b.f.f)localObject4)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label330;
        }
        paramc.add(localObject4);
        break;
      }
    }
    localObject2 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (kotlin.l.b.a.b.f.f)((Iterator)localObject2).next();
      paramc.add(((kotlin.l.b.a.b.f.f)localObject4).qu() + " = ...");
    }
    localObject2 = (List)paramc;
    paramc = (Iterable)((Map)localObject3).entrySet();
    localObject3 = (Collection)new ArrayList(kotlin.a.j.a(paramc, 10));
    Object localObject4 = paramc.iterator();
    if (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
      paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject5).getKey();
      kotlin.l.b.a.b.j.b.g localg = (kotlin.l.b.a.b.j.b.g)((Map.Entry)localObject5).getValue();
      localObject5 = new StringBuilder().append(paramc.qu()).append(" = ");
      if (!((List)localObject1).contains(paramc)) {}
      for (paramc = b(localg);; paramc = "...")
      {
        ((Collection)localObject3).add(paramc);
        break;
      }
    }
    paramc = (List)localObject3;
    paramc = kotlin.a.j.n((Iterable)kotlin.a.j.b((Collection)localObject2, (Iterable)paramc));
    AppMethodBeat.o(59740);
    return paramc;
  }
  
  private String lD(List<? extends kotlin.l.b.a.b.m.av> paramList)
  {
    AppMethodBeat.i(59727);
    kotlin.g.b.p.k(paramList, "typeArguments");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(59727);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Mi("<"));
    b(localStringBuilder, paramList);
    localStringBuilder.append(Mi(">"));
    paramList = localStringBuilder.toString();
    kotlin.g.b.p.j(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59727);
    return paramList;
  }
  
  private static String m(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(59766);
    if ((kotlin.n.n.M(paramString1, paramString2, false)) && (kotlin.n.n.M(paramString3, paramString4, false)))
    {
      int i = paramString2.length();
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString1 = paramString1.substring(i);
      kotlin.g.b.p.j(paramString1, "(this as java.lang.String).substring(startIndex)");
      i = paramString4.length();
      if (paramString3 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString2 = paramString3.substring(i);
      kotlin.g.b.p.j(paramString2, "(this as java.lang.String).substring(startIndex)");
      paramString3 = paramString5 + paramString1;
      if (kotlin.g.b.p.h(paramString1, paramString2))
      {
        AppMethodBeat.o(59766);
        return paramString3;
      }
      if (ps(paramString1, paramString2))
      {
        paramString1 = paramString3 + '!';
        AppMethodBeat.o(59766);
        return paramString1;
      }
    }
    AppMethodBeat.o(59766);
    return null;
  }
  
  private static boolean ps(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59767);
    if ((kotlin.g.b.p.h(paramString1, kotlin.n.n.l(paramString2, "?", "", false))) || ((kotlin.n.n.pu(paramString2, "?")) && (kotlin.g.b.p.h(paramString1 + '?', paramString2))) || (kotlin.g.b.p.h("(" + paramString1 + ")?", paramString2)))
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
    if (!paramb.iEL().isEmpty())
    {
      AppMethodBeat.o(59768);
      return true;
    }
    AppMethodBeat.o(59768);
    return false;
  }
  
  public final void C(Set<kotlin.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59777);
    kotlin.g.b.p.k(paramSet, "<set-?>");
    this.abid.C(paramSet);
    AppMethodBeat.o(59777);
  }
  
  public final void D(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59778);
    kotlin.g.b.p.k(paramSet, "<set-?>");
    this.abid.D(paramSet);
    AppMethodBeat.o(59778);
  }
  
  public final void Jr(boolean paramBoolean)
  {
    AppMethodBeat.i(59780);
    this.abid.Jr(paramBoolean);
    AppMethodBeat.o(59780);
  }
  
  public final void Js(boolean paramBoolean)
  {
    AppMethodBeat.i(59781);
    this.abid.Js(paramBoolean);
    AppMethodBeat.o(59781);
  }
  
  public final void Jt(boolean paramBoolean)
  {
    AppMethodBeat.i(59782);
    this.abid.Jt(paramBoolean);
    AppMethodBeat.o(59782);
  }
  
  public final void Ju(boolean paramBoolean)
  {
    AppMethodBeat.i(59784);
    this.abid.Ju(paramBoolean);
    AppMethodBeat.o(59784);
  }
  
  public final void Jv(boolean paramBoolean)
  {
    AppMethodBeat.i(59785);
    this.abid.Jv(paramBoolean);
    AppMethodBeat.o(59785);
  }
  
  public final void Jw(boolean paramBoolean)
  {
    AppMethodBeat.i(59786);
    this.abid.Jw(paramBoolean);
    AppMethodBeat.o(59786);
  }
  
  public final void Jx(boolean paramBoolean)
  {
    AppMethodBeat.i(59787);
    this.abid.Jx(paramBoolean);
    AppMethodBeat.o(59787);
  }
  
  public final String a(String paramString1, String paramString2, kotlin.l.b.a.b.a.g paramg)
  {
    AppMethodBeat.i(59726);
    kotlin.g.b.p.k(paramString1, "lowerRendered");
    kotlin.g.b.p.k(paramString2, "upperRendered");
    kotlin.g.b.p.k(paramg, "builtIns");
    if (ps(paramString1, paramString2))
    {
      if (kotlin.n.n.M(paramString2, "(", false))
      {
        paramString1 = "(" + paramString1 + ")!";
        AppMethodBeat.o(59726);
        return paramString1;
      }
      paramString1 = paramString1 + '!';
      AppMethodBeat.o(59726);
      return paramString1;
    }
    Object localObject1 = this.abid.iOp();
    Object localObject2 = paramg.a(kotlin.l.b.a.b.a.g.aaFI.aaGz);
    if (localObject2 == null) {
      kotlin.l.b.a.b.a.g.aDG(33);
    }
    kotlin.g.b.p.j(localObject2, "builtIns.collection");
    localObject1 = kotlin.n.n.pv(((b)localObject1).a((kotlin.l.b.a.b.b.h)localObject2, (c)this), "Collection");
    localObject2 = m(paramString1, (String)localObject1 + "Mutable", paramString2, (String)localObject1, (String)localObject1 + '(' + "Mutable" + ')');
    if (localObject2 != null)
    {
      AppMethodBeat.o(59726);
      return localObject2;
    }
    localObject1 = m(paramString1, (String)localObject1 + "MutableMap.MutableEntry", paramString2, (String)localObject1 + "Map.Entry", (String)localObject1 + "(Mutable)Map.(Mutable)Entry");
    if (localObject1 != null)
    {
      AppMethodBeat.o(59726);
      return localObject1;
    }
    localObject1 = this.abid.iOp();
    paramg = paramg.bGC("Array");
    kotlin.g.b.p.j(paramg, "builtIns.array");
    paramg = kotlin.n.n.pv(((b)localObject1).a((kotlin.l.b.a.b.b.h)paramg, (c)this), "Array");
    paramg = m(paramString1, paramg + Mi("Array<"), paramString2, paramg + Mi("Array<out "), paramg + Mi("Array<(out) "));
    if (paramg != null)
    {
      AppMethodBeat.o(59726);
      return paramg;
    }
    paramString1 = "(" + paramString1 + ".." + paramString2 + ')';
    AppMethodBeat.o(59726);
    return paramString1;
  }
  
  public final String a(kotlin.l.b.a.b.b.a.c paramc, kotlin.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59739);
    kotlin.g.b.p.k(paramc, "annotation");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('@');
    if (parame != null) {
      localStringBuilder.append(parame.aaLp + ":");
    }
    parame = paramc.iFN();
    localStringBuilder.append(b(parame));
    if (i.a.a(this.abid))
    {
      paramc = k(paramc);
      if (!i.a.b(this.abid)) {
        if (((Collection)paramc).isEmpty()) {
          break label223;
        }
      }
    }
    label223:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        kotlin.a.j.a((Iterable)paramc, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 112);
      }
      if ((this.abid.iOt()) && ((kotlin.l.b.a.b.m.ad.ap(parame)) || ((parame.iOU().iEf() instanceof aa.b)))) {
        localStringBuilder.append(" /* annotation class not found */");
      }
      paramc = localStringBuilder.toString();
      kotlin.g.b.p.j(paramc, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(59739);
      return paramc;
    }
  }
  
  public final String a(kotlin.l.b.a.b.m.av paramav)
  {
    AppMethodBeat.i(59733);
    kotlin.g.b.p.k(paramav, "typeProjection");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, kotlin.a.j.listOf(paramav));
    paramav = localStringBuilder.toString();
    kotlin.g.b.p.j(paramav, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59733);
    return paramav;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59771);
    kotlin.g.b.p.k(parama, "<set-?>");
    this.abid.a(parama);
    AppMethodBeat.o(59771);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59772);
    kotlin.g.b.p.k(paramb, "<set-?>");
    this.abid.a(paramb);
    AppMethodBeat.o(59772);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59779);
    kotlin.g.b.p.k(paramn, "<set-?>");
    this.abid.a(paramn);
    AppMethodBeat.o(59779);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59783);
    kotlin.g.b.p.k(paramp, "<set-?>");
    this.abid.a(paramp);
    AppMethodBeat.o(59783);
  }
  
  public final String b(kotlin.l.b.a.b.f.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(59716);
    kotlin.g.b.p.k(paramf, "name");
    paramf = Mi(q.x(paramf));
    if ((this.abid.iOM()) && (this.abid.iOE() == p.abjO) && (paramBoolean))
    {
      paramf = "<b>" + paramf + "</b>";
      AppMethodBeat.o(59716);
      return paramf;
    }
    AppMethodBeat.o(59716);
    return paramf;
  }
  
  public final String b(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59720);
    kotlin.g.b.p.k(paramab, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, (kotlin.l.b.a.b.m.ab)((kotlin.g.a.b)this.abid.abiV.a(j.cMt[22])).invoke(paramab));
    paramab = localStringBuilder.toString();
    kotlin.g.b.p.j(paramab, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59720);
    return paramab;
  }
  
  public final String f(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(59718);
    kotlin.g.b.p.k(paramc, "fqName");
    paramc = paramc.iNF();
    kotlin.g.b.p.j(paramc, "fqName.pathSegments()");
    paramc = Mi(q.lE(paramc));
    AppMethodBeat.o(59718);
    return paramc;
  }
  
  public final a iOl()
  {
    AppMethodBeat.i(59770);
    a locala = this.abid.iOl();
    AppMethodBeat.o(59770);
    return locala;
  }
  
  public final boolean iOm()
  {
    AppMethodBeat.i(293045);
    boolean bool = this.abid.iOm();
    AppMethodBeat.o(293045);
    return bool;
  }
  
  public final boolean iOn()
  {
    AppMethodBeat.i(59775);
    boolean bool = this.abid.iOn();
    AppMethodBeat.o(59775);
    return bool;
  }
  
  public final Set<kotlin.l.b.a.b.f.b> iOo()
  {
    AppMethodBeat.i(293046);
    Set localSet = this.abid.iOo();
    AppMethodBeat.o(293046);
    return localSet;
  }
  
  public final String k(l paraml)
  {
    AppMethodBeat.i(59751);
    kotlin.g.b.p.k(paraml, "declarationDescriptor");
    StringBuilder localStringBuilder1 = new StringBuilder();
    paraml.a((kotlin.l.b.a.b.b.n)new a(), localStringBuilder1);
    if ((!((Boolean)this.abid.abiA.a(j.cMt[1])).booleanValue()) || ((paraml instanceof kotlin.l.b.a.b.b.ab)) || ((paraml instanceof kotlin.l.b.a.b.b.ad))) {}
    l locall;
    do
    {
      for (;;)
      {
        paraml = localStringBuilder1.toString();
        kotlin.g.b.p.j(paraml, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(59751);
        return paraml;
        if (!(paraml instanceof y)) {
          break;
        }
        localStringBuilder1.append(" is a module");
      }
      locall = paraml.iDJ();
    } while ((locall == null) || ((locall instanceof y)));
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ");
    Object localObject = "defined in";
    kotlin.g.b.p.k("defined in", "message");
    p localp = this.abid.iOE();
    switch (g.yBk[localp.ordinal()])
    {
    default: 
      paraml = new kotlin.m();
      AppMethodBeat.o(59751);
      throw paraml;
    case 2: 
      localObject = "<i>" + "defined in" + "</i>";
    }
    localStringBuilder2.append((String)localObject).append(" ");
    localObject = kotlin.l.b.a.b.j.c.n(locall);
    kotlin.g.b.p.j(localObject, "DescriptorUtils.getFqName(containingDeclaration)");
    if (((kotlin.l.b.a.b.f.c)localObject).abfJ.isEmpty()) {}
    for (localObject = "root package";; localObject = f((kotlin.l.b.a.b.f.c)localObject))
    {
      localStringBuilder1.append((String)localObject);
      if ((!((Boolean)this.abid.abiB.a(j.cMt[2])).booleanValue()) || (!(locall instanceof kotlin.l.b.a.b.b.ab)) || (!(paraml instanceof kotlin.l.b.a.b.b.o))) {
        break;
      }
      paraml = ((kotlin.l.b.a.b.b.o)paraml).iDZ();
      kotlin.g.b.p.j(paraml, "descriptor.source");
      kotlin.g.b.p.j(paraml.iFJ(), "descriptor.source.containingFile");
      break;
    }
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59774);
    this.abid.setDebugMode(paramBoolean);
    AppMethodBeat.o(59774);
  }
  
  final class a
    implements kotlin.l.b.a.b.b.n<x, StringBuilder>
  {
    private final void a(ag paramag, StringBuilder paramStringBuilder, String paramString)
    {
      AppMethodBeat.i(59687);
      o localo = this.abie.abid.iOF();
      switch (f.$EnumSwitchMapping$0[localo.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(59687);
        return;
        e.a(this.abie, paramag, paramStringBuilder);
        paramStringBuilder.append(paramString + " for ");
        paramString = this.abie;
        paramag = paramag.iFB();
        kotlin.g.b.p.j(paramag, "descriptor.correspondingProperty");
        e.a(paramString, paramag, paramStringBuilder);
        AppMethodBeat.o(59687);
        return;
        b((kotlin.l.b.a.b.b.t)paramag, paramStringBuilder);
      }
    }
    
    private void b(kotlin.l.b.a.b.b.t paramt, StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59688);
      kotlin.g.b.p.k(paramt, "descriptor");
      kotlin.g.b.p.k(paramStringBuilder, "builder");
      e.a(this.abie, paramt, paramStringBuilder);
      AppMethodBeat.o(59688);
    }
  }
  
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.av, CharSequence>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<e>
  {
    c(e parame)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c>
  {
    d(e parame)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.b.g<?>, String>
  {
    e(e parame)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.ab, String>
  {
    g(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.e
 * JD-Core Version:    0.7.0.1
 */