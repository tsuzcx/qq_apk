package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.c.af;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.n.c;
import kotlin.l.b.a.b.n.c.a;
import kotlin.l.b.a.b.n.c.b;
import kotlin.l.b.a.b.n.c.c;
import kotlin.l.b.a.b.n.d;
import kotlin.l.b.a.b.n.i;
import kotlin.n.k;

public class e
  extends af
  implements a
{
  public static final a.a<bd> aiRt;
  private e.a aiRu;
  private final boolean aiRv;
  
  static
  {
    AppMethodBeat.i(57721);
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aiRt = new a.a() {};
      AppMethodBeat.o(57721);
      return;
    }
  }
  
  private e(l paraml, au paramau, g paramg, f paramf, b.a parama, av paramav, boolean paramBoolean)
  {
    super(paraml, paramau, paramg, paramf, parama, paramav);
    AppMethodBeat.i(191992);
    this.aiRu = null;
    this.aiRv = paramBoolean;
    AppMethodBeat.o(191992);
  }
  
  public static e a(l paraml, g paramg, f paramf, av paramav, boolean paramBoolean)
  {
    AppMethodBeat.i(191995);
    if (paraml == null) {
      aKu(5);
    }
    if (paramg == null) {
      aKu(6);
    }
    if (paramf == null) {
      aKu(7);
    }
    if (paramav == null) {
      aKu(8);
    }
    paraml = new e(paraml, null, paramg, paramf, b.a.aiGl, paramav, paramBoolean);
    AppMethodBeat.o(191995);
    return paraml;
  }
  
  public final af a(as paramas1, as paramas2, List<? extends ba> paramList, List<bd> paramList1, ad paramad, ab paramab, t paramt, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(192015);
    if (paramList == null) {
      aKu(9);
    }
    if (paramList1 == null) {
      aKu(10);
    }
    if (paramt == null) {
      aKu(11);
    }
    paramas2 = super.a(paramas1, paramas2, paramList, paramList1, paramad, paramab, paramt, paramMap);
    paramas1 = i.ajsi;
    s.u(paramas2, "functionDescriptor");
    paramList = paramas1.kAY().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramas1 = (d)paramList.next();
      s.u(paramas2, "functionDescriptor");
      if ((paramas1.aiJy != null) && (!s.p(paramas2.kok(), paramas1.aiJy)))
      {
        i = 0;
        label123:
        if (i == 0) {
          break label302;
        }
        s.u(paramas2, "functionDescriptor");
        paramList = paramas1.ajrZ;
        int j = paramList.length;
        i = 0;
        while (i < j)
        {
          paramList1 = paramList[i];
          i += 1;
          paramList1 = paramList1.i(paramas2);
          if (paramList1 != null) {
            paramas1 = (c)new c.b(paramList1);
          }
        }
      }
    }
    for (;;)
    {
      this.aiKr = paramas1.isSuccess;
      if (paramas2 == null) {
        aKu(12);
      }
      AppMethodBeat.o(192015);
      return paramas2;
      if (paramas1.ajrW != null)
      {
        paramList1 = paramas2.kok().PF();
        s.s(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramas1.ajrW.bm(paramList1))
        {
          i = 0;
          break label123;
        }
      }
      if ((paramas1.ajrX != null) && (!paramas1.ajrX.contains(paramas2.kok())))
      {
        i = 0;
        break label123;
      }
      i = 1;
      break label123;
      label302:
      break;
      paramas1 = (String)paramas1.ajrY.invoke(paramas2);
      if (paramas1 != null)
      {
        paramas1 = (c)new c.b(paramas1);
      }
      else
      {
        paramas1 = (c)c.c.ajrV;
        continue;
        paramas1 = (c)c.a.ajrU;
      }
    }
  }
  
  public final void bZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57718);
    this.aiRu = e.a.ca(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(57718);
  }
  
  public final boolean koe()
  {
    AppMethodBeat.i(57717);
    if ((!$assertionsDisabled) && (this.aiRu == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57717);
      throw localAssertionError;
    }
    boolean bool = this.aiRu.aiRB;
    AppMethodBeat.o(57717);
    return bool;
  }
  
  public final boolean kpO()
  {
    AppMethodBeat.i(57716);
    if ((!$assertionsDisabled) && (this.aiRu == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57716);
      throw localAssertionError;
    }
    boolean bool = this.aiRu.aiRA;
    AppMethodBeat.o(57716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */