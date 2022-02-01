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
  private static final kotlin.l.b.a.b.f.f Tkn;
  protected final boolean lNt;
  
  static
  {
    AppMethodBeat.i(57041);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Tkn = kotlin.l.b.a.b.f.f.bua("<init>");
      AppMethodBeat.o(57041);
      return;
    }
  }
  
  protected f(e parame, k paramk, g paramg, boolean paramBoolean, b.a parama, an paraman)
  {
    super(parame, paramk, paramg, Tkn, parama, paraman);
    AppMethodBeat.i(57015);
    this.lNt = paramBoolean;
    AppMethodBeat.o(57015);
  }
  
  public static f a(e parame, g paramg, an paraman)
  {
    AppMethodBeat.i(57016);
    if (paramg == null) {
      atM(5);
    }
    if (paraman == null) {
      atM(6);
    }
    parame = new f(parame, null, paramg, true, b.a.TgW, paraman);
    AppMethodBeat.o(57016);
    return parame;
  }
  
  private d a(l paraml, w paramw, kotlin.l.b.a.b.b.ba paramba, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(57027);
    paraml = (d)super.b(paraml, paramw, paramba, parama, paramBoolean);
    if (paraml == null) {
      atM(25);
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
      atM(13);
    }
    if (paramba == null) {
      atM(14);
    }
    a(paramList, paramba, hBY().hzO());
    AppMethodBeat.o(57018);
    return this;
  }
  
  public final f a(List<av> paramList, kotlin.l.b.a.b.b.ba paramba, List<as> paramList1)
  {
    AppMethodBeat.i(57017);
    if (paramList == null) {
      atM(10);
    }
    if (paramba == null) {
      atM(11);
    }
    if (paramList1 == null) {
      atM(12);
    }
    Object localObject = hBY();
    if (((e)localObject).hzG())
    {
      localObject = ((e)localObject).hzx();
      if (!(localObject instanceof e)) {}
    }
    for (localObject = ((e)localObject).hAO();; localObject = null)
    {
      super.a(null, (ak)localObject, paramList1, paramList, null, w.Tho, paramba);
      AppMethodBeat.o(57017);
      return this;
    }
  }
  
  public final d a(kotlin.l.b.a.b.m.ba paramba)
  {
    AppMethodBeat.i(57022);
    if (paramba == null) {
      atM(18);
    }
    paramba = (d)super.c(paramba);
    AppMethodBeat.o(57022);
    return paramba;
  }
  
  protected f b(l paraml, t paramt, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57026);
    if (paraml == null) {
      atM(21);
    }
    if (parama == null) {
      atM(22);
    }
    if (paramg == null) {
      atM(23);
    }
    if (paraman == null) {
      atM(24);
    }
    if ((parama != b.a.TgW) && (parama != b.a.TgZ))
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
    paraml = new f((e)paraml, this, paramg, this.lNt, b.a.TgW, paraman);
    AppMethodBeat.o(57026);
    return paraml;
  }
  
  public final d hAL()
  {
    AppMethodBeat.i(57021);
    d locald = (d)super.hAT();
    if (locald == null) {
      atM(17);
    }
    AppMethodBeat.o(57021);
    return locald;
  }
  
  public final e hAS()
  {
    AppMethodBeat.i(57020);
    e locale = hBY();
    if (locale == null) {
      atM(16);
    }
    AppMethodBeat.o(57020);
    return locale;
  }
  
  public final Collection<? extends t> hAy()
  {
    AppMethodBeat.i(57024);
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      atM(19);
    }
    AppMethodBeat.o(57024);
    return localSet;
  }
  
  public final e hBY()
  {
    AppMethodBeat.i(57019);
    e locale = (e)super.hzx();
    if (locale == null) {
      atM(15);
    }
    AppMethodBeat.o(57019);
    return locale;
  }
  
  public final boolean isPrimary()
  {
    return this.lNt;
  }
  
  public final void x(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(57025);
    if (paramCollection == null) {
      atM(20);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.f
 * JD-Core Version:    0.7.0.1
 */