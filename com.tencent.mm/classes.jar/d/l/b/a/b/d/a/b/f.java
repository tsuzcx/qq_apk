package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.ae;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.n.a;
import d.l.b.a.b.n.c;
import d.l.b.a.b.n.c.a;
import d.l.b.a.b.n.c.b;
import d.l.b.a.b.n.c.c;
import d.l.b.a.b.n.d;
import d.l.b.a.b.n.i;
import d.n.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
  extends ae
  implements b
{
  public static final a.a<av> NAR;
  private a NAS;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NAR = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private f(l paraml, am paramam, g paramg, d.l.b.a.b.f.f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57713);
    this.NAS = null;
    AppMethodBeat.o(57713);
  }
  
  public static f a(l paraml, g paramg, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(57714);
    if (paraml == null) {
      ajW(5);
    }
    if (paramg == null) {
      ajW(6);
    }
    if (paramf == null) {
      ajW(7);
    }
    if (paraman == null) {
      ajW(8);
    }
    paraml = new f(paraml, null, paramg, paramf, b.a.Nro, paraman);
    AppMethodBeat.o(57714);
    return paraml;
  }
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57715);
    if (paramList == null) {
      ajW(9);
    }
    if (paramList1 == null) {
      ajW(10);
    }
    if (paramba == null) {
      ajW(11);
    }
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    paramak1 = i.ObA;
    p.h(paramak2, "functionDescriptor");
    paramList = paramak1.gyN().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      p.h(paramak2, "functionDescriptor");
      if ((paramak1.Nul != null) && ((p.i(paramak2.gnf(), paramak1.Nul) ^ true)))
      {
        i = 0;
        label125:
        if (i == 0) {
          break label294;
        }
        p.h(paramak2, "functionDescriptor");
        paramList = paramak1.Obq;
        int j = paramList.length;
        i = 0;
        label148:
        if (i >= j) {
          break label305;
        }
        paramList1 = paramList[i].i(paramak2);
        if (paramList1 == null) {
          break label296;
        }
        paramak1 = (c)new c.b(paramList1);
      }
    }
    for (;;)
    {
      this.Nve = paramak1.drc;
      if (paramak2 == null) {
        ajW(12);
      }
      AppMethodBeat.o(57715);
      return paramak2;
      if (paramak1.Obn != null)
      {
        paramList1 = paramak2.gnf().sD();
        p.g(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.Obn.aB(paramList1))
        {
          i = 0;
          break label125;
        }
      }
      if ((paramak1.Obo != null) && (!paramak1.Obo.contains(paramak2.gnf())))
      {
        i = 0;
        break label125;
      }
      i = 1;
      break label125;
      label294:
      break;
      label296:
      i += 1;
      break label148;
      label305:
      paramak1 = (String)paramak1.Obp.invoke(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.Obm;
        continue;
        paramak1 = (c)c.a.Obl;
      }
    }
  }
  
  public final void be(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.NAS = a.bf(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean gmV()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.NAS == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.NAS.NAY;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean goA()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.NAS == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.NAS.NAX;
    AppMethodBeat.o(57716);
    return bool;
  }
  
  static enum a
  {
    public final boolean NAX;
    public final boolean NAY;
    
    static
    {
      AppMethodBeat.i(57712);
      NAT = new a("NON_STABLE_DECLARED", 0, false, false);
      NAU = new a("STABLE_DECLARED", 1, true, false);
      NAV = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
      NAW = new a("STABLE_SYNTHESIZED", 3, true, true);
      NAZ = new a[] { NAT, NAU, NAV, NAW };
      AppMethodBeat.o(57712);
    }
    
    private a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.NAX = paramBoolean1;
      this.NAY = paramBoolean2;
    }
    
    public static a bf(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(57711);
      Object localObject;
      if (paramBoolean1) {
        if (paramBoolean2) {
          localObject = NAW;
        }
      }
      while (localObject == null)
      {
        localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
        AppMethodBeat.o(57711);
        throw ((Throwable)localObject);
        localObject = NAU;
        continue;
        if (paramBoolean2) {
          localObject = NAV;
        } else {
          localObject = NAT;
        }
      }
      AppMethodBeat.o(57711);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */