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
  private final b<ab, Void> NwJ;
  private final List<ab> NwK;
  private boolean initialized;
  
  private ai(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    super(paramj, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(193298);
    this.NwK = new ArrayList(1);
    this.initialized = false;
    this.NwJ = null;
    AppMethodBeat.o(193298);
  }
  
  private void M(ab paramab)
  {
    AppMethodBeat.i(57325);
    if (ad.aq(paramab))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.NwK.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, d.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt, j paramj)
  {
    AppMethodBeat.i(193295);
    if (paraml == null) {
      ajW(0);
    }
    if (paramg == null) {
      ajW(1);
    }
    if (parambh == null) {
      ajW(2);
    }
    if (paramf == null) {
      ajW(3);
    }
    if (paramj == null) {
      ajW(4);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.Nsc, paramj);
    paramg.L(a.G(paraml).glH());
    paramg.setInitialized();
    if (paramg == null) {
      ajW(5);
    }
    AppMethodBeat.o(193295);
    return paramg;
  }
  
  private static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    AppMethodBeat.i(193297);
    if (paraml == null) {
      ajW(12);
    }
    if (paramg == null) {
      ajW(13);
    }
    if (parambh == null) {
      ajW(14);
    }
    if (paramf == null) {
      ajW(15);
    }
    if (paraman == null) {
      ajW(16);
    }
    if (paramaq == null) {
      ajW(17);
    }
    if (paramj == null) {
      ajW(18);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq, paramj);
    AppMethodBeat.o(193297);
    return paraml;
  }
  
  public static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, j paramj)
  {
    AppMethodBeat.i(193296);
    if (paraml == null) {
      ajW(6);
    }
    if (paramg == null) {
      ajW(7);
    }
    if (parambh == null) {
      ajW(8);
    }
    if (paramf == null) {
      ajW(9);
    }
    if (paraman == null) {
      ajW(10);
    }
    if (paramj == null) {
      ajW(11);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.Nse, paramj);
    AppMethodBeat.o(193296);
    return paraml;
  }
  
  private void goV()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + goW());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String goW()
  {
    AppMethodBeat.i(57322);
    String str = gnf() + " declared in " + c.n(glU());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void I(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      ajW(27);
    }
    if (this.NwJ == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.NwJ.invoke(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void L(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      ajW(26);
    }
    goV();
    M(paramab);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ab> gou()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + goW());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.NwK;
    if (localObject == null) {
      ajW(28);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(57323);
    goV();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */