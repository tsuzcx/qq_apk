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
  private av NwA;
  private final d.l.b.a.b.b.aj NwB;
  
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
    super(paramw, paramba, paramah, paramg, f.bek("<set-" + paramah.gnf() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57257);
    if (paramaj != null) {}
    for (;;)
    {
      this.NwB = paramaj;
      AppMethodBeat.o(57257);
      return;
      paramaj = this;
    }
  }
  
  public static aj a(d.l.b.a.b.b.aj paramaj, ab paramab, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57259);
    if (paramaj == null) {
      ajW(7);
    }
    if (paramab == null) {
      ajW(8);
    }
    if (paramg == null) {
      ajW(9);
    }
    paramaj = new aj(paramaj, null, 0, paramg, f.bek("<set-?>"), paramab, false, false, false, null, an.Nsc);
    AppMethodBeat.o(57259);
    return paramaj;
  }
  
  private d.l.b.a.b.b.aj goR()
  {
    AppMethodBeat.i(57264);
    d.l.b.a.b.b.aj localaj = this.NwB;
    if (localaj == null) {
      ajW(13);
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
      ajW(6);
    }
    if ((!$assertionsDisabled) && (this.NwA != null))
    {
      paramav = new AssertionError();
      AppMethodBeat.o(57258);
      throw paramav;
    }
    this.NwA = paramav;
    AppMethodBeat.o(57258);
  }
  
  public final ab gmS()
  {
    AppMethodBeat.i(57262);
    d.l.b.a.b.m.aj localaj = a.G(this).glN();
    if (localaj == null) {
      ajW(12);
    }
    AppMethodBeat.o(57262);
    return localaj;
  }
  
  public final List<av> gmU()
  {
    AppMethodBeat.i(57261);
    if (this.NwA == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(57261);
      throw ((Throwable)localObject);
    }
    Object localObject = Collections.singletonList(this.NwA);
    if (localObject == null) {
      ajW(11);
    }
    AppMethodBeat.o(57261);
    return localObject;
  }
  
  public final Collection<? extends d.l.b.a.b.b.aj> gmW()
  {
    AppMethodBeat.i(57260);
    Collection localCollection = super.An(false);
    AppMethodBeat.o(57260);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ac
 * JD-Core Version:    0.7.0.1
 */