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
  public static final a.a<av> Jzw;
  private f.a Jzx;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Jzw = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private f(l paraml, am paramam, g paramg, d.l.b.a.b.f.f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57713);
    this.Jzx = null;
    AppMethodBeat.o(57713);
  }
  
  public static f a(l paraml, g paramg, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(57714);
    if (paraml == null) {
      adP(5);
    }
    if (paramg == null) {
      adP(6);
    }
    if (paramf == null) {
      adP(7);
    }
    if (paraman == null) {
      adP(8);
    }
    paraml = new f(paraml, null, paramg, paramf, b.a.JpV, paraman);
    AppMethodBeat.o(57714);
    return paraml;
  }
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57715);
    if (paramList == null) {
      adP(9);
    }
    if (paramList1 == null) {
      adP(10);
    }
    if (paramba == null) {
      adP(11);
    }
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    paramak1 = i.Kaf;
    d.g.b.k.h(paramak2, "functionDescriptor");
    paramList = paramak1.fKh().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      d.g.b.k.h(paramak2, "functionDescriptor");
      if ((paramak1.JsQ != null) && ((d.g.b.k.g(paramak2.fyB(), paramak1.JsQ) ^ true)))
      {
        i = 0;
        label125:
        if (i == 0) {
          break label294;
        }
        d.g.b.k.h(paramak2, "functionDescriptor");
        paramList = paramak1.JZV;
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
      this.JtJ = paramak1.dhg;
      if (paramak2 == null) {
        adP(12);
      }
      AppMethodBeat.o(57715);
      return paramak2;
      if (paramak1.JZS != null)
      {
        paramList1 = paramak2.fyB().qV();
        d.g.b.k.g(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.JZS.aA(paramList1))
        {
          i = 0;
          break label125;
        }
      }
      if ((paramak1.JZT != null) && (!paramak1.JZT.contains(paramak2.fyB())))
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
      paramak1 = (String)paramak1.JZU.aA(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.JZR;
        continue;
        paramak1 = (c)c.a.JZQ;
      }
    }
  }
  
  public final void aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.Jzx = f.a.aU(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean fyr()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.Jzx == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.Jzx.JzD;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean fzW()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.Jzx == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.Jzx.JzC;
    AppMethodBeat.o(57716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */