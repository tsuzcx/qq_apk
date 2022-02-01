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
  private final b<ab, Void> Tmr;
  private final List<ab> Tms;
  private boolean initialized;
  
  private ai(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    super(paramj, paraml, paramg, paramf, parambh, paramBoolean, paramInt, paraman, paramaq);
    AppMethodBeat.i(186249);
    this.Tms = new ArrayList(1);
    this.initialized = false;
    this.Tmr = null;
    AppMethodBeat.o(186249);
  }
  
  private void L(ab paramab)
  {
    AppMethodBeat.i(57325);
    if (ad.ap(paramab))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.Tms.add(paramab);
    AppMethodBeat.o(57325);
  }
  
  public static as a(l paraml, kotlin.l.b.a.b.b.a.g paramg, bh parambh, f paramf, int paramInt, j paramj)
  {
    AppMethodBeat.i(186246);
    if (paraml == null) {
      atM(0);
    }
    if (paramg == null) {
      atM(1);
    }
    if (parambh == null) {
      atM(2);
    }
    if (paramf == null) {
      atM(3);
    }
    if (paramj == null) {
      atM(4);
    }
    paramg = a(paraml, paramg, false, parambh, paramf, paramInt, an.ThK, paramj);
    paramg.K(a.G(paraml).hzk());
    paramg.setInitialized();
    if (paramg == null) {
      atM(5);
    }
    AppMethodBeat.o(186246);
    return paramg;
  }
  
  private static ai a(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, aq paramaq, j paramj)
  {
    AppMethodBeat.i(186248);
    if (paraml == null) {
      atM(12);
    }
    if (paramg == null) {
      atM(13);
    }
    if (parambh == null) {
      atM(14);
    }
    if (paramf == null) {
      atM(15);
    }
    if (paraman == null) {
      atM(16);
    }
    if (paramaq == null) {
      atM(17);
    }
    if (paramj == null) {
      atM(18);
    }
    paraml = new ai(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, paramaq, paramj);
    AppMethodBeat.o(186248);
    return paraml;
  }
  
  public static ai a(l paraml, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, bh parambh, f paramf, int paramInt, an paraman, j paramj)
  {
    AppMethodBeat.i(186247);
    if (paraml == null) {
      atM(6);
    }
    if (paramg == null) {
      atM(7);
    }
    if (parambh == null) {
      atM(8);
    }
    if (paramf == null) {
      atM(9);
    }
    if (paraman == null) {
      atM(10);
    }
    if (paramj == null) {
      atM(11);
    }
    paraml = a(paraml, paramg, paramBoolean, parambh, paramf, paramInt, paraman, aq.a.ThM, paramj);
    AppMethodBeat.o(186247);
    return paraml;
  }
  
  private void hCx()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + hCy());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String hCy()
  {
    AppMethodBeat.i(57322);
    String str = hAH() + " declared in " + c.n(hzx());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void H(ab paramab)
  {
    AppMethodBeat.i(57326);
    if (paramab == null) {
      atM(27);
    }
    if (this.Tmr == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.Tmr.invoke(paramab);
    AppMethodBeat.o(57326);
  }
  
  public final void K(ab paramab)
  {
    AppMethodBeat.i(57324);
    if (paramab == null) {
      atM(26);
    }
    hCx();
    L(paramab);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ab> hBW()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + hCy());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Tms;
    if (localObject == null) {
      atM(28);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(57323);
    hCx();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ai
 * JD-Core Version:    0.7.0.1
 */