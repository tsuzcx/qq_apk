package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;

public class f
  extends p
  implements d
{
  private static final kotlin.l.b.a.b.f.f aaNh;
  protected final boolean oJH;
  
  static
  {
    AppMethodBeat.i(57041);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aaNh = kotlin.l.b.a.b.f.f.bHd("<init>");
      AppMethodBeat.o(57041);
      return;
    }
  }
  
  protected f(e parame, k paramk, g paramg, boolean paramBoolean, b.a parama, an paraman)
  {
    super(parame, paramk, paramg, aaNh, parama, paraman);
    AppMethodBeat.i(57015);
    this.oJH = paramBoolean;
    AppMethodBeat.o(57015);
  }
  
  public static f a(e parame, g paramg, an paraman)
  {
    AppMethodBeat.i(57016);
    if (paramg == null) {
      aDG(5);
    }
    if (paraman == null) {
      aDG(6);
    }
    parame = new f(parame, null, paramg, true, b.a.aaJQ, paraman);
    AppMethodBeat.o(57016);
    return parame;
  }
  
  private d a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57027);
    paraml = (d)super.b(paraml, paramw, paramba, parama, paramBoolean);
    if (paraml == null) {
      aDG(25);
    }
    AppMethodBeat.o(57027);
    return paraml;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57023);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57023);
    return paramn;
  }
  
  public final f a(List<av> paramList, kotlin.l.b.a.b.b.ba paramba)
  {
    AppMethodBeat.i(57018);
    if (paramList == null) {
      aDG(13);
    }
    if (paramba == null) {
      aDG(14);
    }
    a(paramList, paramba, iGn().iEb());
    AppMethodBeat.o(57018);
    return this;
  }
  
  public final f a(List<av> paramList, kotlin.l.b.a.b.b.ba paramba, List<as> paramList1)
  {
    AppMethodBeat.i(57017);
    if (paramList == null) {
      aDG(10);
    }
    if (paramba == null) {
      aDG(11);
    }
    if (paramList1 == null) {
      aDG(12);
    }
    Object localObject = iGn();
    if (((e)localObject).iDS())
    {
      localObject = ((e)localObject).iDJ();
      if (!(localObject instanceof e)) {}
    }
    for (localObject = ((e)localObject).iFb();; localObject = null)
    {
      super.a(null, (ak)localObject, paramList1, paramList, null, w.aaKi, paramba);
      AppMethodBeat.o(57017);
      return this;
    }
  }
  
  public final d a(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57022);
    if (paramba == null) {
      aDG(18);
    }
    paramba = (d)super.c(paramba);
    AppMethodBeat.o(57022);
    return paramba;
  }
  
  protected f b(l paraml, t paramt, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57026);
    if (paraml == null) {
      aDG(21);
    }
    if (parama == null) {
      aDG(22);
    }
    if (paramg == null) {
      aDG(23);
    }
    if (paraman == null) {
      aDG(24);
    }
    if ((parama != b.a.aaJQ) && (parama != b.a.aaJT))
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
    paraml = new f((e)paraml, this, paramg, this.oJH, b.a.aaJQ, paraman);
    AppMethodBeat.o(57026);
    return paraml;
  }
  
  public final Collection<? extends t> iEL()
  {
    AppMethodBeat.i(57024);
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      aDG(19);
    }
    AppMethodBeat.o(57024);
    return localSet;
  }
  
  public final d iEY()
  {
    AppMethodBeat.i(57021);
    d locald = (d)super.iFh();
    if (locald == null) {
      aDG(17);
    }
    AppMethodBeat.o(57021);
    return locald;
  }
  
  public final e iFf()
  {
    AppMethodBeat.i(57020);
    e locale = iGn();
    if (locale == null) {
      aDG(16);
    }
    AppMethodBeat.o(57020);
    return locale;
  }
  
  public final boolean iFg()
  {
    return this.oJH;
  }
  
  public final e iGn()
  {
    AppMethodBeat.i(57019);
    e locale = (e)super.iDJ();
    if (locale == null) {
      aDG(15);
    }
    AppMethodBeat.o(57019);
    return locale;
  }
  
  public final void v(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(57025);
    if (paramCollection == null) {
      aDG(20);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.f
 * JD-Core Version:    0.7.0.1
 */