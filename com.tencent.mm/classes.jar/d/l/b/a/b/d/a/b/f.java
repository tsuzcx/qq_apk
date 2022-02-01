package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
  extends ae
  implements b
{
  public static final a.a<av> LmP;
  private a LmQ;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LmP = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private f(l paraml, am paramam, g paramg, d.l.b.a.b.f.f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57713);
    this.LmQ = null;
    AppMethodBeat.o(57713);
  }
  
  public static f a(l paraml, g paramg, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(57714);
    if (paraml == null) {
      agL(5);
    }
    if (paramg == null) {
      agL(6);
    }
    if (paramf == null) {
      agL(7);
    }
    if (paraman == null) {
      agL(8);
    }
    paraml = new f(paraml, null, paramg, paramf, b.a.Ldo, paraman);
    AppMethodBeat.o(57714);
    return paraml;
  }
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57715);
    if (paramList == null) {
      agL(9);
    }
    if (paramList1 == null) {
      agL(10);
    }
    if (paramba == null) {
      agL(11);
    }
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    paramak1 = i.LNy;
    d.g.b.k.h(paramak2, "functionDescriptor");
    paramList = paramak1.gcK().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      d.g.b.k.h(paramak2, "functionDescriptor");
      if ((paramak1.Lgj != null) && ((d.g.b.k.g(paramak2.fRf(), paramak1.Lgj) ^ true)))
      {
        i = 0;
        label125:
        if (i == 0) {
          break label294;
        }
        d.g.b.k.h(paramak2, "functionDescriptor");
        paramList = paramak1.LNo;
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
      this.Lhc = paramak1.deB;
      if (paramak2 == null) {
        agL(12);
      }
      AppMethodBeat.o(57715);
      return paramak2;
      if (paramak1.LNl != null)
      {
        paramList1 = paramak2.fRf().rf();
        d.g.b.k.g(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.LNl.aB(paramList1))
        {
          i = 0;
          break label125;
        }
      }
      if ((paramak1.LNm != null) && (!paramak1.LNm.contains(paramak2.fRf())))
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
      paramak1 = (String)paramak1.LNn.ay(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.LNk;
        continue;
        paramak1 = (c)c.a.LNj;
      }
    }
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.LmQ = a.aY(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean fQV()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.LmQ == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.LmQ.LmW;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean fSA()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.LmQ == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.LmQ.LmV;
    AppMethodBeat.o(57716);
    return bool;
  }
  
  static enum a
  {
    public final boolean LmV;
    public final boolean LmW;
    
    static
    {
      AppMethodBeat.i(57712);
      LmR = new a("NON_STABLE_DECLARED", 0, false, false);
      LmS = new a("STABLE_DECLARED", 1, true, false);
      LmT = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
      LmU = new a("STABLE_SYNTHESIZED", 3, true, true);
      LmX = new a[] { LmR, LmS, LmT, LmU };
      AppMethodBeat.o(57712);
    }
    
    private a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.LmV = paramBoolean1;
      this.LmW = paramBoolean2;
    }
    
    public static a aY(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(57711);
      Object localObject;
      if (paramBoolean1) {
        if (paramBoolean2) {
          localObject = LmU;
        }
      }
      while (localObject == null)
      {
        localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
        AppMethodBeat.o(57711);
        throw ((Throwable)localObject);
        localObject = LmS;
        continue;
        if (paramBoolean2) {
          localObject = LmT;
        } else {
          localObject = LmR;
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