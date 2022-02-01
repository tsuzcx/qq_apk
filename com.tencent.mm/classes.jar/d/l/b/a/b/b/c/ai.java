package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.List;

public final class ai
  extends e
{
  private final b<ab, Void> MZD;
  private final List<ab> MZE;
  private boolean initialized;
  
  private ai(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    super(paramj, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(187774);
    this.MZE = new ArrayList(1);
    this.initialized = false;
    this.MZD = null;
    AppMethodBeat.o(187774);
  }
  
  private void M(ab paramab)
  {
    AppMethodBeat.i(57325);
    if (ad.aq(paramab))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.MZE.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, d.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt, j paramj)
  {
    AppMethodBeat.i(187771);
    if (paraml == null) {
      ajm(0);
    }
    if (paramg == null) {
      ajm(1);
    }
    if (parambh == null) {
      ajm(2);
    }
    if (paramf == null) {
      ajm(3);
    }
    if (paramj == null) {
      ajm(4);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.MUX, paramj);
    paramg.L(a.G(paraml).ghf());
    paramg.setInitialized();
    if (paramg == null) {
      ajm(5);
    }
    AppMethodBeat.o(187771);
    return paramg;
  }
  
  private static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    AppMethodBeat.i(187773);
    if (paraml == null) {
      ajm(12);
    }
    if (paramg == null) {
      ajm(13);
    }
    if (parambh == null) {
      ajm(14);
    }
    if (paramf == null) {
      ajm(15);
    }
    if (paraman == null) {
      ajm(16);
    }
    if (paramaq == null) {
      ajm(17);
    }
    if (paramj == null) {
      ajm(18);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq, paramj);
    AppMethodBeat.o(187773);
    return paraml;
  }
  
  public static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, j paramj)
  {
    AppMethodBeat.i(187772);
    if (paraml == null) {
      ajm(6);
    }
    if (paramg == null) {
      ajm(7);
    }
    if (parambh == null) {
      ajm(8);
    }
    if (paramf == null) {
      ajm(9);
    }
    if (paraman == null) {
      ajm(10);
    }
    if (paramj == null) {
      ajm(11);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.MUZ, paramj);
    AppMethodBeat.o(187772);
    return paraml;
  }
  
  private void gkt()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + gku());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String gku()
  {
    AppMethodBeat.i(57322);
    String str = giD() + " declared in " + c.n(ghs());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void I(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      ajm(27);
    }
    if (this.MZD == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.MZD.invoke(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void L(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      ajm(26);
    }
    gkt();
    M(paramab);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ab> gjS()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + gku());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.MZE;
    if (localObject == null) {
      ajm(28);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(57323);
    gkt();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */