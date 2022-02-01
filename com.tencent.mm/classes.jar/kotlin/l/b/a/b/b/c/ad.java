package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.al;

public class ad
  extends aa
  implements ar
{
  private bd aiLU;
  private final ar aiLV;
  
  static
  {
    AppMethodBeat.i(57271);
    if (!ad.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57271);
      return;
    }
  }
  
  public ad(ap paramap, g paramg, ab paramab, t paramt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, ar paramar, av paramav)
  {
    super(paramab, paramt, paramap, paramg, f.bJg("<set-" + paramap.kok() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paramav);
    AppMethodBeat.i(191882);
    if (paramar != null) {}
    for (;;)
    {
      this.aiLV = paramar;
      AppMethodBeat.o(191882);
      return;
      paramar = this;
    }
  }
  
  public static ak a(ar paramar, kotlin.l.b.a.b.m.ad paramad, g paramg)
  {
    AppMethodBeat.i(57259);
    if (paramar == null) {
      aKu(7);
    }
    if (paramad == null) {
      aKu(8);
    }
    if (paramg == null) {
      aKu(9);
    }
    paramar = new ak(paramar, null, 0, paramg, f.bJg("<set-?>"), paramad, false, false, false, null, av.aiHu);
    AppMethodBeat.o(57259);
    return paramar;
  }
  
  private ar kqh()
  {
    AppMethodBeat.i(57264);
    ar localar = this.aiLV;
    if (localar == null) {
      aKu(13);
    }
    AppMethodBeat.o(57264);
    return localar;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57263);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57263);
    return paramn;
  }
  
  public final void a(bd parambd)
  {
    AppMethodBeat.i(57258);
    if (parambd == null) {
      aKu(6);
    }
    if ((!$assertionsDisabled) && (this.aiLU != null))
    {
      parambd = new AssertionError();
      AppMethodBeat.o(57258);
      throw parambd;
    }
    this.aiLU = parambd;
    AppMethodBeat.o(57258);
  }
  
  public final kotlin.l.b.a.b.m.ad kob()
  {
    AppMethodBeat.i(57262);
    al localal = a.G(this).kmW();
    if (localal == null) {
      aKu(12);
    }
    AppMethodBeat.o(57262);
    return localal;
  }
  
  public final List<bd> kod()
  {
    AppMethodBeat.i(57261);
    if (this.aiLU == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(57261);
      throw ((Throwable)localObject);
    }
    Object localObject = Collections.singletonList(this.aiLU);
    if (localObject == null) {
      aKu(11);
    }
    AppMethodBeat.o(57261);
    return localObject;
  }
  
  public final Collection<? extends ar> kof()
  {
    AppMethodBeat.i(57260);
    Collection localCollection = super.Pn(false);
    if (localCollection == null) {
      aKu(10);
    }
    AppMethodBeat.o(57260);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ad
 * JD-Core Version:    0.7.0.1
 */