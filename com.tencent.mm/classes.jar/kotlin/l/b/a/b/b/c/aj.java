package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ay.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.bl;

public final class aj
  extends e
{
  private final b<ad, Void> aiMd;
  private final List<ad> aiMe;
  private boolean initialized;
  
  private aj(l paraml, g paramg, boolean paramBoolean, bl parambl, f paramf, int paramInt, av paramav, ay paramay, m paramm)
  {
    super(paramm, paraml, paramg, paramf, parambl, paramBoolean, paramInt, paramav, paramay);
    AppMethodBeat.i(191889);
    this.aiMe = new ArrayList(1);
    this.initialized = false;
    this.aiMd = null;
    AppMethodBeat.o(191889);
  }
  
  private void E(ad paramad)
  {
    AppMethodBeat.i(57325);
    if (af.ai(paramad))
    {
      AppMethodBeat.o(57325);
      return;
    }
    this.aiMe.add(paramad);
    AppMethodBeat.o(57325);
  }
  
  public static ba a(l paraml, g paramg, bl parambl, f paramf, int paramInt, m paramm)
  {
    AppMethodBeat.i(191880);
    if (paraml == null) {
      aKu(0);
    }
    if (paramg == null) {
      aKu(1);
    }
    if (parambl == null) {
      aKu(2);
    }
    if (paramf == null) {
      aKu(3);
    }
    if (paramm == null) {
      aKu(4);
    }
    paramg = a(paraml, paramg, false, parambl, paramf, paramInt, av.aiHu, paramm);
    paramg.D(a.G(paraml).kmQ());
    paramg.kqm();
    if (paramg == null) {
      aKu(5);
    }
    AppMethodBeat.o(191880);
    return paramg;
  }
  
  private static aj a(l paraml, g paramg, boolean paramBoolean, bl parambl, f paramf, int paramInt, av paramav, ay paramay, m paramm)
  {
    AppMethodBeat.i(191887);
    if (paraml == null) {
      aKu(12);
    }
    if (paramg == null) {
      aKu(13);
    }
    if (parambl == null) {
      aKu(14);
    }
    if (paramf == null) {
      aKu(15);
    }
    if (paramav == null) {
      aKu(16);
    }
    if (paramay == null) {
      aKu(17);
    }
    if (paramm == null) {
      aKu(18);
    }
    paraml = new aj(paraml, paramg, paramBoolean, parambl, paramf, paramInt, paramav, paramay, paramm);
    AppMethodBeat.o(191887);
    return paraml;
  }
  
  public static aj a(l paraml, g paramg, boolean paramBoolean, bl parambl, f paramf, int paramInt, av paramav, m paramm)
  {
    AppMethodBeat.i(191883);
    if (paraml == null) {
      aKu(6);
    }
    if (paramg == null) {
      aKu(7);
    }
    if (parambl == null) {
      aKu(8);
    }
    if (paramf == null) {
      aKu(9);
    }
    if (paramav == null) {
      aKu(10);
    }
    if (paramm == null) {
      aKu(11);
    }
    paraml = a(paraml, paramg, paramBoolean, parambl, paramf, paramInt, paramav, ay.a.aiHw, paramm);
    AppMethodBeat.o(191883);
    return paraml;
  }
  
  private void kqk()
  {
    AppMethodBeat.i(57321);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + kql());
      AppMethodBeat.o(57321);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(57321);
  }
  
  private String kql()
  {
    AppMethodBeat.i(57322);
    String str = kok() + " declared in " + d.n(knp());
    AppMethodBeat.o(57322);
    return str;
  }
  
  protected final void A(ad paramad)
  {
    AppMethodBeat.i(57326);
    if (paramad == null) {
      aKu(27);
    }
    if (this.aiMd == null)
    {
      AppMethodBeat.o(57326);
      return;
    }
    this.aiMd.invoke(paramad);
    AppMethodBeat.o(57326);
  }
  
  public final void D(ad paramad)
  {
    AppMethodBeat.i(57324);
    if (paramad == null) {
      aKu(26);
    }
    kqk();
    E(paramad);
    AppMethodBeat.o(57324);
  }
  
  protected final List<ad> kpH()
  {
    AppMethodBeat.i(57327);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + kql());
      AppMethodBeat.o(57327);
      throw ((Throwable)localObject);
    }
    Object localObject = this.aiMe;
    if (localObject == null) {
      aKu(28);
    }
    AppMethodBeat.o(57327);
    return localObject;
  }
  
  public final void kqm()
  {
    AppMethodBeat.i(57323);
    kqk();
    this.initialized = true;
    AppMethodBeat.o(57323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.aj
 * JD-Core Version:    0.7.0.1
 */