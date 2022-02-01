package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.aa.b;
import d.l.b.a.b.b.af;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.j.b.r.b;
import d.l.b.a.b.j.b.r.b.a;
import d.l.b.a.b.j.b.r.b.b;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.am;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bf;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.bi;
import d.l.b.a.b.m.u;
import d.l.b.a.b.m.u.d;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  extends c
  implements i
{
  private final d.f NQA;
  final j NQB;
  private final d.f NQz;
  
  public e(j paramj)
  {
    AppMethodBeat.i(59769);
    this.NQB = paramj;
    boolean bool = this.NQB.aIe;
    if ((ac.Nhs) && (!bool))
    {
      paramj = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59769);
      throw paramj;
    }
    this.NQz = d.g.O((d.g.a.a)new c(this));
    this.NQA = d.g.O((d.g.a.a)new d(this));
    AppMethodBeat.o(59769);
  }
  
  private static boolean X(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59725);
    if (d.l.b.a.b.a.f.f(paramab))
    {
      paramab = (Iterable)paramab.gxy();
      if ((!(paramab instanceof Collection)) || (!((Collection)paramab).isEmpty()))
      {
        paramab = paramab.iterator();
        do
        {
          if (!paramab.hasNext()) {
            break;
          }
        } while (!((d.l.b.a.b.m.av)paramab.next()).gyE());
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
  
  private static boolean Y(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59736);
    if ((d.l.b.a.b.a.f.e(paramab)) || (!paramab.gmj().isEmpty()))
    {
      AppMethodBeat.o(59736);
      return true;
    }
    AppMethodBeat.o(59736);
    return false;
  }
  
  private static w a(d.l.b.a.b.b.v paramv)
  {
    AppMethodBeat.i(59744);
    if ((paramv instanceof d.l.b.a.b.b.e))
    {
      if (((d.l.b.a.b.b.e)paramv).glY() == d.l.b.a.b.b.f.Nrx)
      {
        paramv = w.NrJ;
        AppMethodBeat.o(59744);
        return paramv;
      }
      paramv = w.NrG;
      AppMethodBeat.o(59744);
      return paramv;
    }
    Object localObject2 = paramv.glU();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof d.l.b.a.b.b.e)) {
      localObject1 = null;
    }
    localObject1 = (d.l.b.a.b.b.e)localObject1;
    if (localObject1 == null)
    {
      paramv = w.NrG;
      AppMethodBeat.o(59744);
      return paramv;
    }
    if (!(paramv instanceof d.l.b.a.b.b.b))
    {
      paramv = w.NrG;
      AppMethodBeat.o(59744);
      return paramv;
    }
    localObject2 = ((d.l.b.a.b.b.b)paramv).gmW();
    d.g.b.p.g(localObject2, "this.overriddenDescriptors");
    if (!((Collection)localObject2).isEmpty()) {}
    for (int i = 1; (i != 0) && (((d.l.b.a.b.b.e)localObject1).glZ() != w.NrG); i = 0)
    {
      paramv = w.NrI;
      AppMethodBeat.o(59744);
      return paramv;
    }
    if ((((d.l.b.a.b.b.e)localObject1).glY() == d.l.b.a.b.b.f.Nrx) && ((d.g.b.p.i(((d.l.b.a.b.b.b)paramv).gmb(), az.Nsi) ^ true)))
    {
      if (((d.l.b.a.b.b.b)paramv).glZ() == w.NrJ)
      {
        paramv = w.NrJ;
        AppMethodBeat.o(59744);
        return paramv;
      }
      paramv = w.NrI;
      AppMethodBeat.o(59744);
      return paramv;
    }
    paramv = w.NrG;
    AppMethodBeat.o(59744);
    return paramv;
  }
  
  private String a(d.l.b.a.b.m.at paramat)
  {
    AppMethodBeat.i(59732);
    d.g.b.p.h(paramat, "typeConstructor");
    d.l.b.a.b.b.h localh = paramat.gmq();
    if (((localh instanceof as)) || ((localh instanceof d.l.b.a.b.b.e)) || ((localh instanceof ar)))
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
  
  private final void a(d.l.b.a.b.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59755);
    if (!((Boolean)this.NQB.NRC.a(j.cxA[29])).booleanValue())
    {
      AppMethodBeat.o(59755);
      return;
    }
    parama = parama.gmP();
    if (parama != null)
    {
      paramStringBuilder = paramStringBuilder.append(" on ");
      parama = parama.gnW();
      d.g.b.p.g(parama, "receiver.type");
      paramStringBuilder.append(b(parama));
    }
    AppMethodBeat.o(59755);
  }
  
  private final void a(as paramas, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59752);
    if (paramBoolean) {
      paramStringBuilder.append(wX("<"));
    }
    if (this.NQB.gxa()) {
      paramStringBuilder.append("/*").append(paramas.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, paramas.gni(), "reified");
    Object localObject = paramas.gnh().label;
    boolean bool;
    if (((CharSequence)localObject).length() > 0)
    {
      bool = true;
      a(paramStringBuilder, bool, (String)localObject);
      a(paramStringBuilder, (d.l.b.a.b.b.a.a)paramas, null);
      a((l)paramas, paramStringBuilder, paramBoolean);
      i = paramas.gkL().size();
      if (((i <= 1) || (paramBoolean)) && (i != 1)) {
        break label237;
      }
      paramas = (d.l.b.a.b.m.ab)paramas.gkL().iterator().next();
      if (!d.l.b.a.b.a.g.B(paramas))
      {
        localObject = paramStringBuilder.append(" : ");
        d.g.b.p.g(paramas, "upperBound");
        ((StringBuilder)localObject).append(b(paramas));
      }
    }
    label237:
    while (!paramBoolean)
    {
      if (paramBoolean) {
        paramStringBuilder.append(wX(">"));
      }
      AppMethodBeat.o(59752);
      return;
      bool = false;
      break;
    }
    paramas = paramas.gkL().iterator();
    int i = 1;
    label256:
    if (paramas.hasNext())
    {
      localObject = (d.l.b.a.b.m.ab)paramas.next();
      if (d.l.b.a.b.a.g.B((d.l.b.a.b.m.ab)localObject)) {
        break label333;
      }
      if (i == 0) {
        break label322;
      }
      paramStringBuilder.append(" : ");
      label297:
      d.g.b.p.g(localObject, "upperBound");
      paramStringBuilder.append(b((d.l.b.a.b.m.ab)localObject));
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
  
  private final void a(d.l.b.a.b.b.av paramav, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    AppMethodBeat.i(59759);
    if (paramBoolean2) {
      paramStringBuilder.append(bep("value-parameter")).append(" ");
    }
    if (this.NQB.gxa()) {
      paramStringBuilder.append("/*").append(paramav.getIndex()).append("*/ ");
    }
    a(paramStringBuilder, (d.l.b.a.b.b.a.a)paramav, null);
    a(paramStringBuilder, paramav.gob(), "crossinline");
    a(paramStringBuilder, paramav.goc(), "noinline");
    Object localObject2;
    Object localObject1;
    boolean bool;
    if (this.NQB.gxc())
    {
      localObject2 = paramav.gnX();
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if ((localObject1 != null) && (((d)localObject1).isPrimary() == true))
      {
        bool = true;
        if (bool) {
          a(paramStringBuilder, this.NQB.gxd(), "actual");
        }
        a((ax)paramav, paramBoolean1, paramStringBuilder, paramBoolean2, bool);
        if (this.NQB.gxh() == null) {
          break label306;
        }
        if (!this.NQB.gwT()) {
          break label298;
        }
        paramBoolean1 = paramav.gnY();
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
        localObject2 = this.NQB.gxh();
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        paramStringBuilder.append((String)((d.g.a.b)localObject2).invoke(paramav));
      }
      AppMethodBeat.o(59759);
      return;
      bool = false;
      break;
      paramBoolean1 = d.l.b.a.b.j.d.a.b(paramav);
      break label220;
    }
  }
  
  private final void a(ax paramax, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59762);
    if (this.NQB.gxf())
    {
      paramax = paramax.goe();
      if (paramax != null)
      {
        paramStringBuilder = paramStringBuilder.append(" = ");
        d.g.b.p.g(paramax, "constant");
        paramStringBuilder.append(wX(b(paramax)));
        AppMethodBeat.o(59762);
        return;
      }
    }
    AppMethodBeat.o(59762);
  }
  
  private final void a(ax paramax, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59760);
    if ((paramBoolean) || (!(paramax instanceof d.l.b.a.b.b.av))) {
      if (!paramax.god()) {
        break label53;
      }
    }
    label53:
    for (paramax = "var";; paramax = "val")
    {
      paramStringBuilder.append(bep(paramax)).append(" ");
      AppMethodBeat.o(59760);
      return;
    }
  }
  
  private final void a(ax paramax, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(59761);
    d.l.b.a.b.m.ab localab = paramax.gnW();
    d.g.b.p.g(localab, "variable.type");
    if (!(paramax instanceof d.l.b.a.b.b.av)) {}
    for (Object localObject1 = null;; localObject1 = paramax)
    {
      localObject1 = (d.l.b.a.b.b.av)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((d.l.b.a.b.b.av)localObject1).gnZ();
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
          if ((paramBoolean3) || ((paramBoolean2) && (!this.NQB.gwY()))) {
            a(paramax, paramStringBuilder, paramBoolean3);
          }
          if (paramBoolean1)
          {
            a((l)paramax, paramStringBuilder, paramBoolean2);
            paramStringBuilder.append(": ");
          }
          paramStringBuilder.append(b((d.l.b.a.b.m.ab)localObject2));
          a(paramax, paramStringBuilder);
          if ((this.NQB.gxa()) && (localObject1 != null)) {
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
  
  private final void a(d.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59745);
    if ((!d.l.b.a.b.j.c.r((l)paramb)) || (paramb.glZ() != w.NrG))
    {
      if ((this.NQB.gxj() == m.NSb) && (paramb.glZ() == w.NrI) && (s(paramb)))
      {
        AppMethodBeat.o(59745);
        return;
      }
      w localw = paramb.glZ();
      d.g.b.p.g(localw, "callable.modality");
      a(localw, paramStringBuilder, a((d.l.b.a.b.b.v)paramb));
    }
    AppMethodBeat.o(59745);
  }
  
  private final void a(d.l.b.a.b.b.i parami, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59763);
    List localList = parami.gmm();
    d.g.b.p.g(localList, "classifier.declaredTypeParameters");
    Object localObject = parami.glW();
    d.g.b.p.g(localObject, "classifier.typeConstructor");
    localObject = ((d.l.b.a.b.m.at)localObject).getParameters();
    d.g.b.p.g(localObject, "classifier.typeConstructor.parameters");
    if ((this.NQB.gxa()) && (parami.gmd()) && (((List)localObject).size() > localList.size()))
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
    paraml = paraml.gnf();
    d.g.b.p.g(paraml, "descriptor.name");
    paramStringBuilder.append(b(paraml, paramBoolean));
    AppMethodBeat.o(59717);
  }
  
  private final void a(d.l.b.a.b.b.t paramt, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59750);
    a(paramStringBuilder, paramt.gnx(), "suspend");
    AppMethodBeat.o(59750);
  }
  
  private final void a(d.l.b.a.b.b.v paramv, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59749);
    a(paramStringBuilder, paramv.gmi(), "external");
    if ((this.NQB.gwX().contains(h.NQQ)) && (paramv.gmg()))
    {
      bool1 = true;
      a(paramStringBuilder, bool1, "expect");
      if ((!this.NQB.gwX().contains(h.NQR)) || (!paramv.gmh())) {
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
    if ((!((Boolean)this.NQB.NRn.a(j.cxA[14])).booleanValue()) && (paramw1 == paramw2))
    {
      AppMethodBeat.o(59743);
      return;
    }
    boolean bool = this.NQB.gwX().contains(h.NQJ);
    paramw1 = paramw1.name();
    if (paramw1 == null)
    {
      paramw1 = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(59743);
      throw paramw1;
    }
    paramw1 = paramw1.toLowerCase();
    d.g.b.p.g(paramw1, "(this as java.lang.String).toLowerCase()");
    a(paramStringBuilder, bool, paramw1);
    AppMethodBeat.o(59743);
  }
  
  private final void a(d.l.b.a.b.f.b paramb, String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59764);
    paramStringBuilder.append(bep(paramString));
    paramb = paramb.gvH();
    d.g.b.p.g(paramb, "fqName.toUnsafe()");
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
  
  private final void a(StringBuilder paramStringBuilder, d.l.b.a.b.b.a.a parama, d.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59737);
    if (!this.NQB.gwX().contains(h.NQL))
    {
      AppMethodBeat.o(59737);
      return;
    }
    Set localSet;
    d.g.a.b localb;
    if ((parama instanceof d.l.b.a.b.m.ab))
    {
      localSet = this.NQB.gwV();
      localb = (d.g.a.b)this.NQB.NRJ.a(j.cxA[36]);
      parama = parama.gmj().iterator();
    }
    for (;;)
    {
      if (!parama.hasNext()) {
        break label227;
      }
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)parama.next();
      if ((!d.a.j.a((Iterable)localSet, localc.gnI())) && ((localb == null) || (((Boolean)localb.invoke(localc)).booleanValue())))
      {
        paramStringBuilder.append(a(localc, parame));
        if (((Boolean)this.NQB.NRG.a(j.cxA[33])).booleanValue())
        {
          d.n.n.i(paramStringBuilder);
          continue;
          localSet = (Set)this.NQB.NRH.a(j.cxA[34]);
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
    Object localObject = paramaf.NrV;
    if (localObject != null)
    {
      a(paramStringBuilder, (af)localObject);
      paramStringBuilder.append('.');
      localObject = paramaf.NrT.gnf();
      d.g.b.p.g(localObject, "possiblyInnerType.classifierDescriptor.name");
      if (paramStringBuilder.append(b((d.l.b.a.b.f.f)localObject, false)) != null) {}
    }
    else
    {
      localObject = paramaf.NrT.glW();
      d.g.b.p.g(localObject, "possiblyInnerType.classi…escriptor.typeConstructor");
      paramStringBuilder.append(a((d.l.b.a.b.m.at)localObject));
    }
    paramStringBuilder.append(jA(paramaf.NrU));
    AppMethodBeat.o(59731);
  }
  
  private final void a(StringBuilder paramStringBuilder, d.l.b.a.b.m.a parama)
  {
    AppMethodBeat.i(59722);
    if (this.NQB.gxl() == p.NSo) {
      paramStringBuilder.append("<font color=\"808080\"><i>");
    }
    paramStringBuilder.append(" /* = ");
    c(paramStringBuilder, (d.l.b.a.b.m.ab)parama.NEl);
    paramStringBuilder.append(" */");
    if (this.NQB.gxl() == p.NSo) {
      paramStringBuilder.append("</i></font>");
    }
    AppMethodBeat.o(59722);
  }
  
  private final void a(StringBuilder paramStringBuilder, d.l.b.a.b.m.ab paramab, d.l.b.a.b.m.at paramat)
  {
    AppMethodBeat.i(59729);
    d.g.b.p.h(paramab, "$this$buildPossiblyInnerType");
    d.l.b.a.b.b.h localh = paramab.gxB().gmq();
    Object localObject = localh;
    if (!(localh instanceof d.l.b.a.b.b.i)) {
      localObject = null;
    }
    localObject = d.l.b.a.b.b.at.a(paramab, (d.l.b.a.b.b.i)localObject, 0);
    if (localObject == null)
    {
      paramStringBuilder.append(a(paramat));
      paramStringBuilder.append(jA(paramab.gxy()));
      AppMethodBeat.o(59729);
      return;
    }
    a(paramStringBuilder, (af)localObject);
    AppMethodBeat.o(59729);
  }
  
  private final void a(StringBuilder paramStringBuilder, aj paramaj)
  {
    AppMethodBeat.i(59724);
    if ((d.g.b.p.i(paramaj, bc.NZT)) || (bc.aC((d.l.b.a.b.m.ab)paramaj)))
    {
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (u.al((d.l.b.a.b.m.ab)paramaj))
    {
      if (this.NQB.gxe())
      {
        paramaj = paramaj.gxB();
        if (paramaj == null)
        {
          paramStringBuilder = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
          AppMethodBeat.o(59724);
          throw paramStringBuilder;
        }
        paramaj = ((u.d)paramaj).gyy();
        d.g.b.p.g(paramaj, "(type.constructor as Uni…).typeParameterDescriptor");
        paramaj = paramaj.gnf().toString();
        d.g.b.p.g(paramaj, "(type.constructor as Uni…escriptor.name.toString()");
        paramStringBuilder.append(beq(paramaj));
        AppMethodBeat.o(59724);
        return;
      }
      paramStringBuilder.append("???");
      AppMethodBeat.o(59724);
      return;
    }
    if (d.l.b.a.b.m.ad.aq((d.l.b.a.b.m.ab)paramaj))
    {
      d(paramStringBuilder, (d.l.b.a.b.m.ab)paramaj);
      AppMethodBeat.o(59724);
      return;
    }
    if (X((d.l.b.a.b.m.ab)paramaj))
    {
      e(paramStringBuilder, (d.l.b.a.b.m.ab)paramaj);
      AppMethodBeat.o(59724);
      return;
    }
    d(paramStringBuilder, (d.l.b.a.b.m.ab)paramaj);
    AppMethodBeat.o(59724);
  }
  
  private final void a(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(59748);
    if (paramBoolean)
    {
      paramStringBuilder.append(bep(paramString));
      paramStringBuilder.append(" ");
    }
    AppMethodBeat.o(59748);
  }
  
  private final void a(Collection<? extends d.l.b.a.b.b.av> paramCollection, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59758);
    Object localObject = (n)this.NQB.NRB.a(j.cxA[28]);
    boolean bool1 = bool2;
    switch (g.NQE[localObject.ordinal()])
    {
    default: 
      paramCollection = new d.m();
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
      this.NQB.gxk().e(paramStringBuilder);
      paramCollection = ((Iterable)paramCollection).iterator();
      int i = 0;
      while (paramCollection.hasNext())
      {
        localObject = (d.l.b.a.b.b.av)paramCollection.next();
        this.NQB.gxk().a((d.l.b.a.b.b.av)localObject, paramStringBuilder);
        a((d.l.b.a.b.b.av)localObject, bool1, paramStringBuilder, false);
        this.NQB.gxk().a((d.l.b.a.b.b.av)localObject, i, j, paramStringBuilder);
        i += 1;
      }
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.NQB.gxk().f(paramStringBuilder);
    AppMethodBeat.o(59758);
  }
  
  private final void a(List<? extends as> paramList, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59757);
    if (this.NQB.gxg())
    {
      AppMethodBeat.o(59757);
      return;
    }
    ArrayList localArrayList = new ArrayList(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      as localas = (as)paramList.next();
      Object localObject1 = localas.gkL();
      d.g.b.p.g(localObject1, "typeParameter.upperBounds");
      localObject1 = ((Iterable)d.a.j.h((Iterable)localObject1)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        localObject2 = (d.l.b.a.b.m.ab)localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        d.l.b.a.b.f.f localf = localas.gnf();
        d.g.b.p.g(localf, "typeParameter.name");
        localStringBuilder = localStringBuilder.append(b(localf, false)).append(" : ");
        d.g.b.p.g(localObject2, "it");
        localCollection.add(b((d.l.b.a.b.m.ab)localObject2));
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(" ").append(bep("where")).append(" ");
        d.a.j.a((Iterable)localArrayList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, null, 124);
      }
      AppMethodBeat.o(59757);
      return;
    }
  }
  
  private final void a(List<? extends as> paramList, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(59753);
    if (this.NQB.gxg())
    {
      AppMethodBeat.o(59753);
      return;
    }
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramStringBuilder.append(wX("<"));
        c(paramStringBuilder, paramList);
        paramStringBuilder.append(wX(">"));
        if (paramBoolean) {
          paramStringBuilder.append(" ");
        }
      }
      AppMethodBeat.o(59753);
      return;
    }
  }
  
  private final boolean a(ba paramba, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59742);
    if (!this.NQB.gwX().contains(h.NQI))
    {
      AppMethodBeat.o(59742);
      return false;
    }
    ba localba = paramba;
    if (((Boolean)this.NQB.NRl.a(j.cxA[12])).booleanValue()) {
      localba = paramba.gol();
    }
    if ((!this.NQB.gxb()) && (d.g.b.p.i(localba, az.Nst)))
    {
      AppMethodBeat.o(59742);
      return false;
    }
    paramStringBuilder.append(bep(localba.gok())).append(" ");
    AppMethodBeat.o(59742);
    return true;
  }
  
  private String b(d.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(59719);
    d.g.b.p.h(paramh, "klass");
    if (u.L((l)paramh))
    {
      paramh = paramh.glW().toString();
      AppMethodBeat.o(59719);
      return paramh;
    }
    paramh = this.NQB.gwW().a(paramh, (c)this);
    AppMethodBeat.o(59719);
    return paramh;
  }
  
  private final String b(d.l.b.a.b.j.b.g<?> paramg)
  {
    int i = 0;
    AppMethodBeat.i(59741);
    if ((paramg instanceof d.l.b.a.b.j.b.b))
    {
      paramg = d.a.j.a((Iterable)((d.l.b.a.b.j.b.b)paramg).getValue(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (d.g.a.b)new e(this), 24);
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof d.l.b.a.b.j.b.a))
    {
      paramg = d.n.n.b(a((d.l.b.a.b.b.a.c)((d.l.b.a.b.j.b.a)paramg).getValue(), null), (CharSequence)"@");
      AppMethodBeat.o(59741);
      return paramg;
    }
    if ((paramg instanceof r))
    {
      r.b localb = (r.b)((r)paramg).getValue();
      if ((localb instanceof r.b.a))
      {
        paramg = ((r.b.a)localb).NlK + "::class";
        AppMethodBeat.o(59741);
        return paramg;
      }
      if ((localb instanceof r.b.b))
      {
        paramg = ((r.b.b)localb).NTO.NpB.gvG().sD();
        d.g.b.p.g(paramg, "classValue.classId.asSingleFqName().asString()");
        int j = ((r.b.b)localb).NTO.NTx;
        while (i < j)
        {
          paramg = "kotlin.Array<" + paramg + '>';
          i += 1;
        }
        paramg = paramg + "::class";
        AppMethodBeat.o(59741);
        return paramg;
      }
      paramg = new d.m();
      AppMethodBeat.o(59741);
      throw paramg;
    }
    paramg = paramg.toString();
    AppMethodBeat.o(59741);
    return paramg;
  }
  
  private final void b(d.l.b.a.b.b.a parama, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59756);
    parama = parama.gmP();
    if (parama != null)
    {
      a(paramStringBuilder, (d.l.b.a.b.b.a.a)parama, d.l.b.a.b.b.a.e.NsI);
      d.l.b.a.b.m.ab localab = parama.gnW();
      d.g.b.p.g(localab, "receiver.type");
      String str = b(localab);
      parama = str;
      if (X(localab))
      {
        parama = str;
        if (!bc.aF(localab)) {
          parama = "(" + str + ')';
        }
      }
      paramStringBuilder.append(parama).append(".");
    }
    AppMethodBeat.o(59756);
  }
  
  private final void b(d.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59746);
    if (!this.NQB.gwX().contains(h.NQK))
    {
      AppMethodBeat.o(59746);
      return;
    }
    if ((s(paramb)) && (this.NQB.gxj() != m.NSc))
    {
      a(paramStringBuilder, true, "override");
      if (this.NQB.gxa()) {
        paramStringBuilder.append("/*").append(paramb.gmW().size()).append("*/ ");
      }
    }
    AppMethodBeat.o(59746);
  }
  
  private final void b(StringBuilder paramStringBuilder, d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59721);
    bg localbg = paramab.gyC();
    Object localObject = localbg;
    if (!(localbg instanceof d.l.b.a.b.m.a)) {
      localObject = null;
    }
    localObject = (d.l.b.a.b.m.a)localObject;
    if (localObject != null)
    {
      if (this.NQB.gxp())
      {
        c(paramStringBuilder, (d.l.b.a.b.m.ab)((d.l.b.a.b.m.a)localObject).NEl);
        AppMethodBeat.o(59721);
        return;
      }
      c(paramStringBuilder, (d.l.b.a.b.m.ab)((d.l.b.a.b.m.a)localObject).NYo);
      if (this.NQB.gxo()) {
        a(paramStringBuilder, (d.l.b.a.b.m.a)localObject);
      }
      AppMethodBeat.o(59721);
      return;
    }
    c(paramStringBuilder, paramab);
    AppMethodBeat.o(59721);
  }
  
  private final void b(StringBuilder paramStringBuilder, List<? extends d.l.b.a.b.m.av> paramList)
  {
    AppMethodBeat.i(59734);
    d.a.j.a((Iterable)paramList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (d.g.a.b)new b(this), 60);
    AppMethodBeat.o(59734);
  }
  
  private final String bep(String paramString)
  {
    AppMethodBeat.i(59712);
    p localp = this.NQB.gxl();
    switch (g.cqt[localp.ordinal()])
    {
    default: 
      paramString = new d.m();
      AppMethodBeat.o(59712);
      throw paramString;
    case 1: 
      AppMethodBeat.o(59712);
      return paramString;
    }
    if (this.NQB.gxt())
    {
      AppMethodBeat.o(59712);
      return paramString;
    }
    paramString = "<b>" + paramString + "</b>";
    AppMethodBeat.o(59712);
    return paramString;
  }
  
  private final String beq(String paramString)
  {
    AppMethodBeat.i(59713);
    p localp = this.NQB.gxl();
    switch (g.gpL[localp.ordinal()])
    {
    default: 
      paramString = new d.m();
      AppMethodBeat.o(59713);
      throw paramString;
    case 1: 
      AppMethodBeat.o(59713);
      return paramString;
    }
    paramString = "<font color=red><b>" + paramString + "</b></font>";
    AppMethodBeat.o(59713);
    return paramString;
  }
  
  private final void c(d.l.b.a.b.b.b paramb, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(59747);
    if (!this.NQB.gwX().contains(h.NQN))
    {
      AppMethodBeat.o(59747);
      return;
    }
    if ((this.NQB.gxa()) && (paramb.gmY() != b.a.Nro))
    {
      paramStringBuilder = paramStringBuilder.append("/*");
      paramb = paramb.gmY().name();
      if (paramb == null)
      {
        paramb = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59747);
        throw paramb;
      }
      paramb = paramb.toLowerCase();
      d.g.b.p.g(paramb, "(this as java.lang.String).toLowerCase()");
      paramStringBuilder.append(paramb).append("*/ ");
    }
    AppMethodBeat.o(59747);
  }
  
  private final void c(StringBuilder paramStringBuilder, d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59723);
    if (((paramab instanceof bi)) && (this.NQB.gwT()) && (!((bi)paramab).gyq()))
    {
      paramStringBuilder.append("<Not computed yet>");
      AppMethodBeat.o(59723);
      return;
    }
    paramab = paramab.gyC();
    if ((paramab instanceof d.l.b.a.b.m.v))
    {
      paramStringBuilder.append(((d.l.b.a.b.m.v)paramab).a((c)this, (i)this));
      AppMethodBeat.o(59723);
      return;
    }
    if ((paramab instanceof aj)) {
      a(paramStringBuilder, (aj)paramab);
    }
    AppMethodBeat.o(59723);
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
  
  private final void d(StringBuilder paramStringBuilder, d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59728);
    a(paramStringBuilder, (d.l.b.a.b.b.a.a)paramab, null);
    if (d.l.b.a.b.m.ad.aq(paramab)) {
      if (((paramab instanceof bf)) && (this.NQB.gxs()))
      {
        paramStringBuilder.append(((bf)paramab).NYR);
        paramStringBuilder.append(jA(paramab.gxy()));
      }
    }
    for (;;)
    {
      if (paramab.gqy()) {
        paramStringBuilder.append("?");
      }
      if (am.as(paramab)) {
        paramStringBuilder.append("!!");
      }
      AppMethodBeat.o(59728);
      return;
      if (((paramab instanceof d.l.b.a.b.m.t)) && (!this.NQB.gxu()))
      {
        paramStringBuilder.append(((d.l.b.a.b.m.t)paramab).gyw());
        break;
      }
      paramStringBuilder.append(paramab.gxB().toString());
      break;
      a(this, paramStringBuilder, paramab);
    }
  }
  
  private final void e(StringBuilder paramStringBuilder, d.l.b.a.b.m.ab paramab)
  {
    int k = 1;
    AppMethodBeat.i(59735);
    int m = paramStringBuilder.length();
    gwP().a(paramStringBuilder, (d.l.b.a.b.b.a.a)paramab, null);
    int j;
    boolean bool2;
    int i;
    label75:
    label93:
    d.l.b.a.b.m.av localav;
    if (paramStringBuilder.length() != m)
    {
      j = 1;
      boolean bool1 = d.l.b.a.b.a.f.e(paramab);
      bool2 = paramab.gqy();
      localObject = d.l.b.a.b.a.f.h(paramab);
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
        if (X((d.l.b.a.b.m.ab)localObject))
        {
          j = k;
          if (!((d.l.b.a.b.m.ab)localObject).gqy()) {}
        }
        else
        {
          if (!Y((d.l.b.a.b.m.ab)localObject)) {
            break label436;
          }
          j = k;
        }
        label140:
        if (j != 0) {
          paramStringBuilder.append("(");
        }
        b(paramStringBuilder, (d.l.b.a.b.m.ab)localObject);
        if (j != 0) {
          paramStringBuilder.append(")");
        }
        paramStringBuilder.append(".");
      }
      paramStringBuilder.append("(");
      Iterator localIterator = ((Iterable)d.l.b.a.b.a.f.j(paramab)).iterator();
      j = 0;
      label206:
      if (!localIterator.hasNext()) {
        break label448;
      }
      localav = (d.l.b.a.b.m.av)localIterator.next();
      if (j > 0) {
        paramStringBuilder.append(", ");
      }
      if (!this.NQB.gxr()) {
        break label442;
      }
      localObject = localav.gnW();
      d.g.b.p.g(localObject, "typeProjection.type");
    }
    label436:
    label442:
    for (Object localObject = d.l.b.a.b.a.f.k((d.l.b.a.b.m.ab)localObject);; localObject = null)
    {
      if (localObject != null)
      {
        paramStringBuilder.append(b((d.l.b.a.b.f.f)localObject, false));
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(gwQ().a(localav));
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
        if (d.n.n.aK((CharSequence)paramStringBuilder) == ' ') {}
        for (j = 1; (ac.Nhs) && (j == 0); j = 0)
        {
          paramStringBuilder = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(59735);
          throw paramStringBuilder;
        }
        if (paramStringBuilder.charAt(d.n.n.aG((CharSequence)paramStringBuilder) - 1) != ')') {
          paramStringBuilder.insert(d.n.n.aG((CharSequence)paramStringBuilder), "()");
        }
      }
      paramStringBuilder.append("(");
      break label93;
      j = 0;
      break label140;
    }
    label448:
    paramStringBuilder.append(") ").append(gwR()).append(" ");
    b(paramStringBuilder, d.l.b.a.b.a.f.i(paramab));
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
  
  private final e gwP()
  {
    AppMethodBeat.i(59710);
    e locale = (e)this.NQz.getValue();
    AppMethodBeat.o(59710);
    return locale;
  }
  
  private final c gwQ()
  {
    AppMethodBeat.i(59711);
    c localc = (c)this.NQA.getValue();
    AppMethodBeat.o(59711);
    return localc;
  }
  
  private final String gwR()
  {
    AppMethodBeat.i(59715);
    Object localObject = this.NQB.gxl();
    switch (g.xBI[localObject.ordinal()])
    {
    default: 
      localObject = new d.m();
      AppMethodBeat.o(59715);
      throw ((Throwable)localObject);
    case 1: 
      localObject = wX("->");
      AppMethodBeat.o(59715);
      return localObject;
    }
    AppMethodBeat.o(59715);
    return "&rarr;";
  }
  
  private String jA(List<? extends d.l.b.a.b.m.av> paramList)
  {
    AppMethodBeat.i(59727);
    d.g.b.p.h(paramList, "typeArguments");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(59727);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(wX("<"));
    b(localStringBuilder, paramList);
    localStringBuilder.append(wX(">"));
    paramList = localStringBuilder.toString();
    d.g.b.p.g(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59727);
    return paramList;
  }
  
  private static String k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(59766);
    if ((d.n.n.nF(paramString1, paramString2)) && (d.n.n.nF(paramString3, paramString4)))
    {
      int i = paramString2.length();
      if (paramString1 == null)
      {
        paramString1 = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString1 = paramString1.substring(i);
      d.g.b.p.g(paramString1, "(this as java.lang.String).substring(startIndex)");
      i = paramString4.length();
      if (paramString3 == null)
      {
        paramString1 = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(59766);
        throw paramString1;
      }
      paramString2 = paramString3.substring(i);
      d.g.b.p.g(paramString2, "(this as java.lang.String).substring(startIndex)");
      paramString3 = paramString5 + paramString1;
      if (d.g.b.p.i(paramString1, paramString2))
      {
        AppMethodBeat.o(59766);
        return paramString3;
      }
      if (nD(paramString1, paramString2))
      {
        paramString1 = paramString3 + '!';
        AppMethodBeat.o(59766);
        return paramString1;
      }
    }
    AppMethodBeat.o(59766);
    return null;
  }
  
  private final List<String> k(d.l.b.a.b.b.a.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(59740);
    Object localObject3 = paramc.gom();
    if (((Boolean)this.NQB.NRF.a(j.cxA[32])).booleanValue()) {}
    for (Object localObject1 = d.l.b.a.b.j.d.a.l(paramc);; localObject1 = null)
    {
      paramc = (d.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = ((d.l.b.a.b.b.e)localObject1).gma();
      paramc = (d.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = ((d)localObject1).gmU();
      paramc = (d.l.b.a.b.b.a.c)localObject2;
      if (localObject1 == null) {
        break label236;
      }
      localObject1 = (Iterable)localObject1;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((d.l.b.a.b.b.av)localObject2).gnY()) {
          paramc.add(localObject2);
        }
      }
    }
    localObject1 = (Iterable)paramc;
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.l.b.a.b.b.av)((Iterator)localObject1).next();
      d.g.b.p.g(localObject2, "it");
      paramc.add(((d.l.b.a.b.b.av)localObject2).gnf());
    }
    paramc = (List)paramc;
    label236:
    localObject1 = paramc;
    if (paramc == null) {
      localObject1 = (List)d.a.v.NhH;
    }
    localObject2 = (Iterable)localObject1;
    paramc = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label330:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if (!((Map)localObject3).containsKey((d.l.b.a.b.f.f)localObject4)) {}
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
    paramc = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (d.l.b.a.b.f.f)((Iterator)localObject2).next();
      paramc.add(((d.l.b.a.b.f.f)localObject4).sD() + " = ...");
    }
    localObject2 = (List)paramc;
    paramc = (Iterable)((Map)localObject3).entrySet();
    localObject3 = (Collection)new ArrayList(d.a.j.a(paramc, 10));
    Object localObject4 = paramc.iterator();
    if (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
      paramc = (d.l.b.a.b.f.f)((Map.Entry)localObject5).getKey();
      d.l.b.a.b.j.b.g localg = (d.l.b.a.b.j.b.g)((Map.Entry)localObject5).getValue();
      localObject5 = new StringBuilder().append(paramc.sD()).append(" = ");
      if (!((List)localObject1).contains(paramc)) {}
      for (paramc = b(localg);; paramc = "...")
      {
        ((Collection)localObject3).add(paramc);
        break;
      }
    }
    paramc = (List)localObject3;
    paramc = d.a.j.j((Iterable)d.a.j.b((Collection)localObject2, (Iterable)paramc));
    AppMethodBeat.o(59740);
    return paramc;
  }
  
  private static boolean nD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59767);
    if ((d.g.b.p.i(paramString1, d.n.n.h(paramString2, "?", "", false))) || ((d.n.n.nG(paramString2, "?")) && (d.g.b.p.i(paramString1 + '?', paramString2))) || (d.g.b.p.i("(" + paramString1 + ")?", paramString2)))
    {
      AppMethodBeat.o(59767);
      return true;
    }
    AppMethodBeat.o(59767);
    return false;
  }
  
  private static boolean s(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(59768);
    if (!paramb.gmW().isEmpty())
    {
      AppMethodBeat.o(59768);
      return true;
    }
    AppMethodBeat.o(59768);
    return false;
  }
  
  private final String wX(String paramString)
  {
    AppMethodBeat.i(59714);
    paramString = this.NQB.gxl().wX(paramString);
    AppMethodBeat.o(59714);
    return paramString;
  }
  
  public final void AA(boolean paramBoolean)
  {
    AppMethodBeat.i(59787);
    this.NQB.AA(paramBoolean);
    AppMethodBeat.o(59787);
  }
  
  public final void Au(boolean paramBoolean)
  {
    AppMethodBeat.i(59780);
    this.NQB.Au(paramBoolean);
    AppMethodBeat.o(59780);
  }
  
  public final void Av(boolean paramBoolean)
  {
    AppMethodBeat.i(59781);
    this.NQB.Av(paramBoolean);
    AppMethodBeat.o(59781);
  }
  
  public final void Aw(boolean paramBoolean)
  {
    AppMethodBeat.i(59782);
    this.NQB.Aw(paramBoolean);
    AppMethodBeat.o(59782);
  }
  
  public final void Ax(boolean paramBoolean)
  {
    AppMethodBeat.i(59784);
    this.NQB.Ax(paramBoolean);
    AppMethodBeat.o(59784);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(59785);
    this.NQB.Ay(paramBoolean);
    AppMethodBeat.o(59785);
  }
  
  public final void Az(boolean paramBoolean)
  {
    AppMethodBeat.i(59786);
    this.NQB.Az(paramBoolean);
    AppMethodBeat.o(59786);
  }
  
  public final String a(d.l.b.a.b.b.a.c paramc, d.l.b.a.b.b.a.e parame)
  {
    AppMethodBeat.i(59739);
    d.g.b.p.h(paramc, "annotation");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('@');
    if (parame != null) {
      localStringBuilder.append(parame.NsN + ":");
    }
    parame = paramc.gnW();
    localStringBuilder.append(b(parame));
    if (i.a.a(this.NQB))
    {
      paramc = k(paramc);
      if (!i.a.b(this.NQB)) {
        if (((Collection)paramc).isEmpty()) {
          break label223;
        }
      }
    }
    label223:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        d.a.j.a((Iterable)paramc, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 112);
      }
      if ((this.NQB.gxa()) && ((d.l.b.a.b.m.ad.aq(parame)) || ((parame.gxB().gmq() instanceof aa.b)))) {
        localStringBuilder.append(" /* annotation class not found */");
      }
      paramc = localStringBuilder.toString();
      d.g.b.p.g(paramc, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(59739);
      return paramc;
    }
  }
  
  public final String a(d.l.b.a.b.m.av paramav)
  {
    AppMethodBeat.i(59733);
    d.g.b.p.h(paramav, "typeProjection");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, d.a.j.listOf(paramav));
    paramav = localStringBuilder.toString();
    d.g.b.p.g(paramav, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59733);
    return paramav;
  }
  
  public final String a(String paramString1, String paramString2, d.l.b.a.b.a.g paramg)
  {
    AppMethodBeat.i(59726);
    d.g.b.p.h(paramString1, "lowerRendered");
    d.g.b.p.h(paramString2, "upperRendered");
    d.g.b.p.h(paramg, "builtIns");
    if (nD(paramString1, paramString2))
    {
      if (d.n.n.nF(paramString2, "("))
      {
        paramString1 = "(" + paramString1 + ")!";
        AppMethodBeat.o(59726);
        return paramString1;
      }
      paramString1 = paramString1 + '!';
      AppMethodBeat.o(59726);
      return paramString1;
    }
    Object localObject1 = this.NQB.gwW();
    Object localObject2 = paramg.a(d.l.b.a.b.a.g.Nng.NnX);
    if (localObject2 == null) {
      d.l.b.a.b.a.g.ajW(33);
    }
    d.g.b.p.g(localObject2, "builtIns.collection");
    localObject1 = d.n.n.nH(((b)localObject1).a((d.l.b.a.b.b.h)localObject2, (c)this), "Collection");
    localObject2 = k(paramString1, (String)localObject1 + "Mutable", paramString2, (String)localObject1, (String)localObject1 + '(' + "Mutable" + ')');
    if (localObject2 != null)
    {
      AppMethodBeat.o(59726);
      return localObject2;
    }
    localObject1 = k(paramString1, (String)localObject1 + "MutableMap.MutableEntry", paramString2, (String)localObject1 + "Map.Entry", (String)localObject1 + "(Mutable)Map.(Mutable)Entry");
    if (localObject1 != null)
    {
      AppMethodBeat.o(59726);
      return localObject1;
    }
    localObject1 = this.NQB.gwW();
    paramg = paramg.bdJ("Array");
    d.g.b.p.g(paramg, "builtIns.array");
    paramg = d.n.n.nH(((b)localObject1).a((d.l.b.a.b.b.h)paramg, (c)this), "Array");
    paramg = k(paramString1, paramg + wX("Array<"), paramString2, paramg + wX("Array<out "), paramg + wX("Array<(out) "));
    if (paramg != null)
    {
      AppMethodBeat.o(59726);
      return paramg;
    }
    paramString1 = "(" + paramString1 + ".." + paramString2 + ')';
    AppMethodBeat.o(59726);
    return paramString1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59771);
    d.g.b.p.h(parama, "<set-?>");
    this.NQB.a(parama);
    AppMethodBeat.o(59771);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59772);
    d.g.b.p.h(paramb, "<set-?>");
    this.NQB.a(paramb);
    AppMethodBeat.o(59772);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59779);
    d.g.b.p.h(paramn, "<set-?>");
    this.NQB.a(paramn);
    AppMethodBeat.o(59779);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59783);
    d.g.b.p.h(paramp, "<set-?>");
    this.NQB.a(paramp);
    AppMethodBeat.o(59783);
  }
  
  public final String b(d.l.b.a.b.f.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(59716);
    d.g.b.p.h(paramf, "name");
    paramf = wX(q.x(paramf));
    if ((this.NQB.gxt()) && (this.NQB.gxl() == p.NSo) && (paramBoolean))
    {
      paramf = "<b>" + paramf + "</b>";
      AppMethodBeat.o(59716);
      return paramf;
    }
    AppMethodBeat.o(59716);
    return paramf;
  }
  
  public final String b(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59720);
    d.g.b.p.h(paramab, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, (d.l.b.a.b.m.ab)((d.g.a.b)this.NQB.NRv.a(j.cxA[22])).invoke(paramab));
    paramab = localStringBuilder.toString();
    d.g.b.p.g(paramab, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59720);
    return paramab;
  }
  
  public final String f(d.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(59718);
    d.g.b.p.h(paramc, "fqName");
    paramc = paramc.gvO();
    d.g.b.p.g(paramc, "fqName.pathSegments()");
    paramc = wX(q.jB(paramc));
    AppMethodBeat.o(59718);
    return paramc;
  }
  
  public final a gwS()
  {
    AppMethodBeat.i(59770);
    a locala = this.NQB.gwS();
    AppMethodBeat.o(59770);
    return locala;
  }
  
  public final boolean gwT()
  {
    AppMethodBeat.i(224207);
    boolean bool = this.NQB.gwT();
    AppMethodBeat.o(224207);
    return bool;
  }
  
  public final boolean gwU()
  {
    AppMethodBeat.i(59775);
    boolean bool = this.NQB.gwU();
    AppMethodBeat.o(59775);
    return bool;
  }
  
  public final Set<d.l.b.a.b.f.b> gwV()
  {
    AppMethodBeat.i(224208);
    Set localSet = this.NQB.gwV();
    AppMethodBeat.o(224208);
    return localSet;
  }
  
  public final String k(l paraml)
  {
    AppMethodBeat.i(59751);
    d.g.b.p.h(paraml, "declarationDescriptor");
    StringBuilder localStringBuilder1 = new StringBuilder();
    paraml.a((d.l.b.a.b.b.n)new a(), localStringBuilder1);
    if ((!((Boolean)this.NQB.NRa.a(j.cxA[1])).booleanValue()) || ((paraml instanceof d.l.b.a.b.b.ab)) || ((paraml instanceof d.l.b.a.b.b.ad))) {}
    l locall;
    do
    {
      for (;;)
      {
        paraml = localStringBuilder1.toString();
        d.g.b.p.g(paraml, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(59751);
        return paraml;
        if (!(paraml instanceof y)) {
          break;
        }
        localStringBuilder1.append(" is a module");
      }
      locall = paraml.glU();
    } while ((locall == null) || ((locall instanceof y)));
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ");
    Object localObject = "defined in";
    d.g.b.p.h("defined in", "message");
    p localp = this.NQB.gxl();
    switch (g.NQD[localp.ordinal()])
    {
    default: 
      paraml = new d.m();
      AppMethodBeat.o(59751);
      throw paraml;
    case 2: 
      localObject = "<i>" + "defined in" + "</i>";
    }
    localStringBuilder2.append((String)localObject).append(" ");
    localObject = d.l.b.a.b.j.c.n(locall);
    d.g.b.p.g(localObject, "DescriptorUtils.getFqName(containingDeclaration)");
    if (((d.l.b.a.b.f.c)localObject).NNr.isEmpty()) {}
    for (localObject = "root package";; localObject = f((d.l.b.a.b.f.c)localObject))
    {
      localStringBuilder1.append((String)localObject);
      if ((!((Boolean)this.NQB.NRb.a(j.cxA[2])).booleanValue()) || (!(locall instanceof d.l.b.a.b.b.ab)) || (!(paraml instanceof d.l.b.a.b.b.o))) {
        break;
      }
      paraml = ((d.l.b.a.b.b.o)paraml).gmk();
      d.g.b.p.g(paraml, "descriptor.source");
      d.g.b.p.g(paraml.gnS(), "descriptor.source.containingFile");
      break;
    }
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59774);
    this.NQB.setDebugMode(paramBoolean);
    AppMethodBeat.o(59774);
  }
  
  public final void u(Set<d.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59777);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NQB.u(paramSet);
    AppMethodBeat.o(59777);
  }
  
  public final void v(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59778);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NQB.v(paramSet);
    AppMethodBeat.o(59778);
  }
  
  final class a
    implements d.l.b.a.b.b.n<z, StringBuilder>
  {
    private final void a(ag paramag, StringBuilder paramStringBuilder, String paramString)
    {
      AppMethodBeat.i(59687);
      o localo = this.NQC.NQB.gxm();
      switch (f.cqt[localo.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(59687);
        return;
        e.a(this.NQC, paramag, paramStringBuilder);
        paramStringBuilder.append(paramString + " for ");
        paramString = this.NQC;
        paramag = paramag.gnK();
        d.g.b.p.g(paramag, "descriptor.correspondingProperty");
        e.a(paramString, paramag, paramStringBuilder);
        AppMethodBeat.o(59687);
        return;
        b((d.l.b.a.b.b.t)paramag, paramStringBuilder);
      }
    }
    
    private void b(d.l.b.a.b.b.t paramt, StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(59688);
      d.g.b.p.h(paramt, "descriptor");
      d.g.b.p.h(paramStringBuilder, "builder");
      e.a(this.NQC, paramt, paramStringBuilder);
      AppMethodBeat.o(59688);
    }
  }
  
  static final class b
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.m.av, CharSequence>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.q
    implements d.g.a.a<e>
  {
    c(e parame)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.q
    implements d.g.a.a<c>
  {
    d(e parame)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.j.b.g<?>, String>
  {
    e(e parame)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.m.ab, String>
  {
    g(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.i.e
 * JD-Core Version:    0.7.0.1
 */