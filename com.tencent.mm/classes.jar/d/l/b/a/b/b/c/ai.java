package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.List;

public final class ai
  extends e
{
  private final d.g.a.b<ab, Void> Jvo;
  private final List<ab> Jvp;
  private boolean initialized;
  
  private ai(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq)
  {
    super(d.l.b.a.b.l.b.JWw, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(57320);
    this.Jvp = new ArrayList(1);
    this.initialized = false;
    this.Jvo = null;
    AppMethodBeat.o(57320);
  }
  
  private void M(ab paramab)
  {
    AppMethodBeat.i(57325);
    if (ad.aq(paramab))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.Jvp.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, d.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt)
  {
    AppMethodBeat.i(57317);
    if (paraml == null) {
      adP(0);
    }
    if (paramg == null) {
      adP(1);
    }
    if (parambh == null) {
      adP(2);
    }
    if (paramf == null) {
      adP(3);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.JqJ);
    paramg.L(a.G(paraml).fxd());
    paramg.setInitialized();
    if (paramg == null) {
      adP(4);
    }
    AppMethodBeat.o(57317);
    return paramg;
  }
  
  public static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman)
  {
    AppMethodBeat.i(57318);
    if (paraml == null) {
      adP(5);
    }
    if (paramg == null) {
      adP(6);
    }
    if (parambh == null) {
      adP(7);
    }
    if (paramf == null) {
      adP(8);
    }
    if (paraman == null) {
      adP(9);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.JqL);
    AppMethodBeat.o(57318);
    return paraml;
  }
  
  private static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq)
  {
    AppMethodBeat.i(57319);
    if (paraml == null) {
      adP(10);
    }
    if (paramg == null) {
      adP(11);
    }
    if (parambh == null) {
      adP(12);
    }
    if (paramf == null) {
      adP(13);
    }
    if (paraman == null) {
      adP(14);
    }
    if (paramaq == null) {
      adP(15);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq);
    AppMethodBeat.o(57319);
    return paraml;
  }
  
  private void fAq()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + fAr());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String fAr()
  {
    AppMethodBeat.i(57322);
    String str = fyB() + " declared in " + c.n(fxq());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void I(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      adP(23);
    }
    if (this.Jvo == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.Jvo.aA(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void L(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      adP(22);
    }
    fAq();
    M(paramab);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ab> fzQ()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + fAr());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Jvp;
    if (localObject == null) {
      adP(24);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(57323);
    fAq();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */