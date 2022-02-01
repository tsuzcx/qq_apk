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
  private final d.g.a.b<ab, Void> LiH;
  private final List<ab> LiI;
  private boolean initialized;
  
  private ai(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq)
  {
    super(d.l.b.a.b.l.b.LJP, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(57320);
    this.LiI = new ArrayList(1);
    this.initialized = false;
    this.LiH = null;
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
    this.LiI.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, d.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt)
  {
    AppMethodBeat.i(57317);
    if (paraml == null) {
      agL(0);
    }
    if (paramg == null) {
      agL(1);
    }
    if (parambh == null) {
      agL(2);
    }
    if (paramf == null) {
      agL(3);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.Lec);
    paramg.L(a.G(paraml).fPH());
    paramg.setInitialized();
    if (paramg == null) {
      agL(4);
    }
    AppMethodBeat.o(57317);
    return paramg;
  }
  
  public static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman)
  {
    AppMethodBeat.i(57318);
    if (paraml == null) {
      agL(5);
    }
    if (paramg == null) {
      agL(6);
    }
    if (parambh == null) {
      agL(7);
    }
    if (paramf == null) {
      agL(8);
    }
    if (paraman == null) {
      agL(9);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.Lee);
    AppMethodBeat.o(57318);
    return paraml;
  }
  
  private static ai a(l paraml, d.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq)
  {
    AppMethodBeat.i(57319);
    if (paraml == null) {
      agL(10);
    }
    if (paramg == null) {
      agL(11);
    }
    if (parambh == null) {
      agL(12);
    }
    if (paramf == null) {
      agL(13);
    }
    if (paraman == null) {
      agL(14);
    }
    if (paramaq == null) {
      agL(15);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq);
    AppMethodBeat.o(57319);
    return paraml;
  }
  
  private void fSU()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + fSV());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String fSV()
  {
    AppMethodBeat.i(57322);
    String str = fRf() + " declared in " + c.n(fPU());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void I(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      agL(23);
    }
    if (this.LiH == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.LiH.ay(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void L(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      agL(22);
    }
    fSU();
    M(paramab);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ab> fSu()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + fSV());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.LiI;
    if (localObject == null) {
      agL(24);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(57323);
    fSU();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */