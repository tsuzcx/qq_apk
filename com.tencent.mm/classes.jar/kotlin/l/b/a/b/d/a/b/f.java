package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.n.a;
import kotlin.l.b.a.b.n.c;
import kotlin.l.b.a.b.n.c.a;
import kotlin.l.b.a.b.n.c.b;
import kotlin.l.b.a.b.n.c.c;
import kotlin.l.b.a.b.n.d;
import kotlin.l.b.a.b.n.i;
import kotlin.n.k;

public class f
  extends ae
  implements b
{
  public static final a.a<av> aaTt;
  private f.a aaTu;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aaTt = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private f(l paraml, am paramam, g paramg, kotlin.l.b.a.b.f.f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57713);
    this.aaTu = null;
    AppMethodBeat.o(57713);
  }
  
  public static f a(l paraml, g paramg, kotlin.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(57714);
    if (paraml == null) {
      aDG(5);
    }
    if (paramg == null) {
      aDG(6);
    }
    if (paramf == null) {
      aDG(7);
    }
    if (paraman == null) {
      aDG(8);
    }
    paraml = new f(paraml, null, paramg, paramf, b.a.aaJQ, paraman);
    AppMethodBeat.o(57714);
    return paraml;
  }
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57715);
    if (paramList == null) {
      aDG(9);
    }
    if (paramList1 == null) {
      aDG(10);
    }
    if (paramba == null) {
      aDG(11);
    }
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    paramak1 = i.absT;
    p.k(paramak2, "functionDescriptor");
    paramList = paramak1.iQi().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      p.k(paramak2, "functionDescriptor");
      if ((paramak1.aaMN != null) && ((p.h(paramak2.iEU(), paramak1.aaMN) ^ true)))
      {
        i = 0;
        label125:
        if (i == 0) {
          break label294;
        }
        p.k(paramak2, "functionDescriptor");
        paramList = paramak1.absJ;
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
      this.aaNG = paramak1.isSuccess;
      if (paramak2 == null) {
        aDG(12);
      }
      AppMethodBeat.o(57715);
      return paramak2;
      if (paramak1.absG != null)
      {
        paramList1 = paramak2.iEU().qu();
        p.j(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.absG.aY(paramList1))
        {
          i = 0;
          break label125;
        }
      }
      if ((paramak1.absH != null) && (!paramak1.absH.contains(paramak2.iEU())))
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
      paramak1 = (String)paramak1.absI.invoke(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.absF;
        continue;
        paramak1 = (c)c.a.absE;
      }
    }
  }
  
  public final void by(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.aaTu = f.a.bz(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean iEK()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.aaTu == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.aaTu.aaTA;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean iGr()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.aaTu == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.aaTu.aaTz;
    AppMethodBeat.o(57716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */