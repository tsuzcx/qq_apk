package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.aq.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.bh;

public final class ai
  extends e
{
  private final b<ab, Void> aaPl;
  private final List<ab> aaPm;
  private boolean initialized;
  
  private ai(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    super(paramj, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(259654);
    this.aaPm = new ArrayList(1);
    this.initialized = false;
    this.aaPl = null;
    AppMethodBeat.o(259654);
  }
  
  private void L(ab paramab)
  {
    AppMethodBeat.i(57325);
    if (ad.ap(paramab))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.aaPm.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, kotlin.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt, j paramj)
  {
    AppMethodBeat.i(259648);
    if (paraml == null) {
      aDG(0);
    }
    if (paramg == null) {
      aDG(1);
    }
    if (parambh == null) {
      aDG(2);
    }
    if (paramf == null) {
      aDG(3);
    }
    if (paramj == null) {
      aDG(4);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.aaKE, paramj);
    paramg.K(a.G(paraml).iDw());
    paramg.iGP();
    if (paramg == null) {
      aDG(5);
    }
    AppMethodBeat.o(259648);
    return paramg;
  }
  
  private static ai a(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    AppMethodBeat.i(259653);
    if (paraml == null) {
      aDG(12);
    }
    if (paramg == null) {
      aDG(13);
    }
    if (parambh == null) {
      aDG(14);
    }
    if (paramf == null) {
      aDG(15);
    }
    if (paraman == null) {
      aDG(16);
    }
    if (paramaq == null) {
      aDG(17);
    }
    if (paramj == null) {
      aDG(18);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq, paramj);
    AppMethodBeat.o(259653);
    return paraml;
  }
  
  public static ai a(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, j paramj)
  {
    AppMethodBeat.i(259651);
    if (paraml == null) {
      aDG(6);
    }
    if (paramg == null) {
      aDG(7);
    }
    if (parambh == null) {
      aDG(8);
    }
    if (paramf == null) {
      aDG(9);
    }
    if (paraman == null) {
      aDG(10);
    }
    if (paramj == null) {
      aDG(11);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.aaKG, paramj);
    AppMethodBeat.o(259651);
    return paraml;
  }
  
  private void iGN()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + iGO());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String iGO()
  {
    AppMethodBeat.i(57322);
    String str = iEU() + " declared in " + c.n(iDJ());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void H(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      aDG(27);
    }
    if (this.aaPl == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.aaPl.invoke(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void K(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      aDG(26);
    }
    iGN();
    L(paramab);
    AppMethodBeat.o(57324);
  }
  
  public final void iGP()
  {
    AppMethodBeat.i(57323);
    iGN();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
  
  protected final List<ab> iGl()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + iGO());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.aaPm;
    if (localObject == null) {
      aDG(28);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */