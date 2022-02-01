package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;

public final class ac
  extends aa
  implements aq
{
  private ad aiLR;
  private final aq aiLT;
  
  public ac(ap paramap, g paramg, ab paramab, t paramt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, aq paramaq, av paramav)
  {
    super(paramab, paramt, paramap, paramg, f.bJg("<get-" + paramap.kok() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paramav);
    AppMethodBeat.i(191881);
    if (paramaq != null) {}
    for (;;)
    {
      this.aiLT = paramaq;
      AppMethodBeat.o(191881);
      return;
      paramaq = this;
    }
  }
  
  private aq kqg()
  {
    AppMethodBeat.i(57249);
    aq localaq = this.aiLT;
    if (localaq == null) {
      aKu(8);
    }
    AppMethodBeat.o(57249);
    return localaq;
  }
  
  public final void C(ad paramad)
  {
    AppMethodBeat.i(57245);
    ad localad = paramad;
    if (paramad == null) {
      localad = kpb().koG();
    }
    this.aiLR = localad;
    AppMethodBeat.o(57245);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57248);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57248);
    return paramn;
  }
  
  public final ad kob()
  {
    return this.aiLR;
  }
  
  public final List<bd> kod()
  {
    AppMethodBeat.i(57247);
    List localList = Collections.emptyList();
    if (localList == null) {
      aKu(7);
    }
    AppMethodBeat.o(57247);
    return localList;
  }
  
  public final Collection<? extends aq> kof()
  {
    AppMethodBeat.i(57246);
    Collection localCollection = super.Pn(true);
    if (localCollection == null) {
      aKu(6);
    }
    AppMethodBeat.o(57246);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ac
 * JD-Core Version:    0.7.0.1
 */