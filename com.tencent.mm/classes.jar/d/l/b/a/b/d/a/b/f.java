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
  public static final a.a<av> NdM;
  private f.a NdN;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NdM = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private f(l paraml, am paramam, g paramg, d.l.b.a.b.f.f paramf, b.a parama, an paraman)
  {
    super(paraml, paramam, paramg, paramf, parama, paraman);
    AppMethodBeat.i(57713);
    this.NdN = null;
    AppMethodBeat.o(57713);
  }
  
  public static f a(l paraml, g paramg, d.l.b.a.b.f.f paramf, an paraman)
  {
    AppMethodBeat.i(57714);
    if (paraml == null) {
      ajm(5);
    }
    if (paramg == null) {
      ajm(6);
    }
    if (paramf == null) {
      ajm(7);
    }
    if (paraman == null) {
      ajm(8);
    }
    paraml = new f(paraml, null, paramg, paramf, b.a.MUj, paraman);
    AppMethodBeat.o(57714);
    return paraml;
  }
  
  public final ae a(ak paramak1, ak paramak2, List<? extends as> paramList, List<av> paramList1, ab paramab, w paramw, ba paramba, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(57715);
    if (paramList == null) {
      ajm(9);
    }
    if (paramList1 == null) {
      ajm(10);
    }
    if (paramba == null) {
      ajm(11);
    }
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap);
    paramak1 = i.NEt;
    p.h(paramak2, "functionDescriptor");
    paramList = paramak1.gul().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      p.h(paramak2, "functionDescriptor");
      if ((paramak1.MXf != null) && ((p.i(paramak2.giD(), paramak1.MXf) ^ true)))
      {
        i = 0;
        label125:
        if (i == 0) {
          break label294;
        }
        p.h(paramak2, "functionDescriptor");
        paramList = paramak1.NEj;
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
      this.MXY = paramak1.dpX;
      if (paramak2 == null) {
        ajm(12);
      }
      AppMethodBeat.o(57715);
      return paramak2;
      if (paramak1.NEg != null)
      {
        paramList1 = paramak2.giD().sD();
        p.g(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.NEg.aC(paramList1))
        {
          i = 0;
          break label125;
        }
      }
      if ((paramak1.NEh != null) && (!paramak1.NEh.contains(paramak2.giD())))
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
      paramak1 = (String)paramak1.NEi.invoke(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.NEf;
        continue;
        paramak1 = (c)c.a.NEe;
      }
    }
  }
  
  public final void bf(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.NdN = f.a.bg(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean git()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.NdN == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.NdN.NdT;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean gjY()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.NdN == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.NdN.NdS;
    AppMethodBeat.o(57716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */