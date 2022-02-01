package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.k;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.w;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class f
  extends p
  implements d
{
  private static final d.l.b.a.b.f.f LgD;
  protected final boolean kkz;
  
  static
  {
    AppMethodBeat.i(57041);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LgD = d.l.b.a.b.f.f.aWD("<init>");
      AppMethodBeat.o(57041);
      return;
    }
  }
  
  protected f(e parame, k paramk, g paramg, boolean paramBoolean, b.a parama, an paraman)
  {
    super(parame, paramk, paramg, LgD, parama, paraman);
    AppMethodBeat.i(57015);
    this.kkz = paramBoolean;
    AppMethodBeat.o(57015);
  }
  
  public static f a(e parame, g paramg, an paraman)
  {
    AppMethodBeat.i(57016);
    if (paramg == null) {
      agL(5);
    }
    if (paraman == null) {
      agL(6);
    }
    parame = new f(parame, null, paramg, true, b.a.Ldo, paraman);
    AppMethodBeat.o(57016);
    return parame;
  }
  
  private d a(l paraml, w paramw, d.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57027);
    paraml = (d)super.b(paraml, paramw, paramba, parama, paramBoolean);
    if (paraml == null) {
      agL(25);
    }
    AppMethodBeat.o(57027);
    return paraml;
  }
  
  public final f a(List<av> paramList, d.l.b.a.b.b.ba paramba)
  {
    AppMethodBeat.i(57018);
    if (paramList == null) {
      agL(13);
    }
    if (paramba == null) {
      agL(14);
    }
    a(paramList, paramba, fSw().fQm());
    AppMethodBeat.o(57018);
    return this;
  }
  
  public final f a(List<av> paramList, d.l.b.a.b.b.ba paramba, List<as> paramList1)
  {
    AppMethodBeat.i(57017);
    if (paramList == null) {
      agL(10);
    }
    if (paramba == null) {
      agL(11);
    }
    if (paramList1 == null) {
      agL(12);
    }
    Object localObject = fSw();
    if (((e)localObject).fQd())
    {
      localObject = ((e)localObject).fPU();
      if (!(localObject instanceof e)) {}
    }
    for (localObject = ((e)localObject).fRl();; localObject = null)
    {
      super.a(null, (ak)localObject, paramList1, paramList, null, w.LdG, paramba);
      AppMethodBeat.o(57017);
      return this;
    }
  }
  
  public final d a(d.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57022);
    if (paramba == null) {
      agL(18);
    }
    paramba = (d)super.c(paramba);
    AppMethodBeat.o(57022);
    return paramba;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57023);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57023);
    return paramn;
  }
  
  protected f b(l paraml, t paramt, b.a parama, d.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57026);
    if (paraml == null) {
      agL(21);
    }
    if (parama == null) {
      agL(22);
    }
    if (paramg == null) {
      agL(23);
    }
    if (paraman == null) {
      agL(24);
    }
    if ((parama != b.a.Ldo) && (parama != b.a.Ldr))
    {
      paraml = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + paraml + "\nkind: " + parama);
      AppMethodBeat.o(57026);
      throw paraml;
    }
    if ((!$assertionsDisabled) && (paramf != null))
    {
      paraml = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57026);
      throw paraml;
    }
    paraml = new f((e)paraml, this, paramg, this.kkz, b.a.Ldo, paraman);
    AppMethodBeat.o(57026);
    return paraml;
  }
  
  public final Collection<? extends t> fQW()
  {
    AppMethodBeat.i(57024);
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      agL(19);
    }
    AppMethodBeat.o(57024);
    return localSet;
  }
  
  public final d fRi()
  {
    AppMethodBeat.i(57021);
    d locald = (d)super.fRq();
    if (locald == null) {
      agL(17);
    }
    AppMethodBeat.o(57021);
    return locald;
  }
  
  public final e fRp()
  {
    AppMethodBeat.i(57020);
    e locale = fSw();
    if (locale == null) {
      agL(16);
    }
    AppMethodBeat.o(57020);
    return locale;
  }
  
  public final e fSw()
  {
    AppMethodBeat.i(57019);
    e locale = (e)super.fPU();
    if (locale == null) {
      agL(15);
    }
    AppMethodBeat.o(57019);
    return locale;
  }
  
  public final boolean isPrimary()
  {
    return this.kkz;
  }
  
  public final void t(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(57025);
    if (paramCollection == null) {
      agL(20);
    }
    if ((!$assertionsDisabled) && (!paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Constructors cannot override anything");
      AppMethodBeat.o(57025);
      throw paramCollection;
    }
    AppMethodBeat.o(57025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.f
 * JD-Core Version:    0.7.0.1
 */