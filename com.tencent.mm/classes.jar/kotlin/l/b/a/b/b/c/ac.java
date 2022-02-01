package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;

public class ac
  extends z
  implements kotlin.l.b.a.b.b.aj
{
  private av aaPc;
  private final kotlin.l.b.a.b.b.aj aaPd;
  
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
  
  public ac(ah paramah, kotlin.l.b.a.b.b.a.g paramg, w paramw, ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, kotlin.l.b.a.b.b.aj paramaj, an paraman)
  {
    super(paramw, paramba, paramah, paramg, f.bHd("<set-" + paramah.iEU() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57257);
    if (paramaj != null) {}
    for (;;)
    {
      this.aaPd = paramaj;
      AppMethodBeat.o(57257);
      return;
      paramaj = this;
    }
  }
  
  public static aj a(kotlin.l.b.a.b.b.aj paramaj, ab paramab, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57259);
    if (paramaj == null) {
      aDG(7);
    }
    if (paramab == null) {
      aDG(8);
    }
    if (paramg == null) {
      aDG(9);
    }
    paramaj = new aj(paramaj, null, 0, paramg, f.bHd("<set-?>"), paramab, false, false, false, null, an.aaKE);
    AppMethodBeat.o(57259);
    return paramaj;
  }
  
  private kotlin.l.b.a.b.b.aj iGJ()
  {
    AppMethodBeat.i(57264);
    kotlin.l.b.a.b.b.aj localaj = this.aaPd;
    if (localaj == null) {
      aDG(13);
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
      aDG(6);
    }
    if ((!$assertionsDisabled) && (this.aaPc != null))
    {
      paramav = new AssertionError();
      AppMethodBeat.o(57258);
      throw paramav;
    }
    this.aaPc = paramav;
    AppMethodBeat.o(57258);
  }
  
  public final ab iEH()
  {
    AppMethodBeat.i(57262);
    kotlin.l.b.a.b.m.aj localaj = a.G(this).iDC();
    if (localaj == null) {
      aDG(12);
    }
    AppMethodBeat.o(57262);
    return localaj;
  }
  
  public final List<av> iEJ()
  {
    AppMethodBeat.i(57261);
    if (this.aaPc == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(57261);
      throw ((Throwable)localObject);
    }
    Object localObject = Collections.singletonList(this.aaPc);
    if (localObject == null) {
      aDG(11);
    }
    AppMethodBeat.o(57261);
    return localObject;
  }
  
  public final Collection<? extends kotlin.l.b.a.b.b.aj> iEL()
  {
    AppMethodBeat.i(57260);
    Collection localCollection = super.Jk(false);
    AppMethodBeat.o(57260);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ac
 * JD-Core Version:    0.7.0.1
 */