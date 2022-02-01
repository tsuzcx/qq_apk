package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.m.ab;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ac
  extends z
  implements d.l.b.a.b.b.aj
{
  private av Liy;
  private final d.l.b.a.b.b.aj Liz;
  
  static
  {
    AppMethodBeat.i(57271);
    if (!ac.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57271);
      return;
    }
  }
  
  public ac(ah paramah, d.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, d.l.b.a.b.b.aj paramaj, an paraman)
  {
    super(paramw, paramba, paramah, paramg, f.aWD("<set-" + paramah.fRf() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57257);
    if (paramaj != null) {}
    for (;;)
    {
      this.Liz = paramaj;
      AppMethodBeat.o(57257);
      return;
      paramaj = this;
    }
  }
  
  public static aj a(d.l.b.a.b.b.aj paramaj, ab paramab, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57259);
    if (paramaj == null) {
      agL(7);
    }
    if (paramab == null) {
      agL(8);
    }
    if (paramg == null) {
      agL(9);
    }
    paramaj = new aj(paramaj, null, 0, paramg, f.aWD("<set-?>"), paramab, false, false, false, null, an.Lec);
    AppMethodBeat.o(57259);
    return paramaj;
  }
  
  private d.l.b.a.b.b.aj fSQ()
  {
    AppMethodBeat.i(57264);
    d.l.b.a.b.b.aj localaj = this.Liz;
    if (localaj == null) {
      agL(13);
    }
    AppMethodBeat.o(57264);
    return localaj;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57263);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57263);
    return paramn;
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(57258);
    if (paramav == null) {
      agL(6);
    }
    if ((!$assertionsDisabled) && (this.Liy != null))
    {
      paramav = new AssertionError();
      AppMethodBeat.o(57258);
      throw paramav;
    }
    this.Liy = paramav;
    AppMethodBeat.o(57258);
  }
  
  public final ab fQS()
  {
    AppMethodBeat.i(57262);
    d.l.b.a.b.m.aj localaj = a.G(this).fPN();
    if (localaj == null) {
      agL(12);
    }
    AppMethodBeat.o(57262);
    return localaj;
  }
  
  public final List<av> fQU()
  {
    AppMethodBeat.i(57261);
    if (this.Liy == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(57261);
      throw ((Throwable)localObject);
    }
    Object localObject = Collections.singletonList(this.Liy);
    if (localObject == null) {
      agL(11);
    }
    AppMethodBeat.o(57261);
    return localObject;
  }
  
  public final Collection<? extends d.l.b.a.b.b.aj> fQW()
  {
    AppMethodBeat.i(57260);
    Collection localCollection = super.zm(false);
    AppMethodBeat.o(57260);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ac
 * JD-Core Version:    0.7.0.1
 */