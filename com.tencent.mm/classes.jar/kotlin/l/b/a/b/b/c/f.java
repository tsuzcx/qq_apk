package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.be;

public class f
  extends p
  implements d
{
  private static final kotlin.l.b.a.b.f.f aiJS;
  protected final boolean rNy;
  
  static
  {
    AppMethodBeat.i(57041);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aiJS = kotlin.l.b.a.b.f.f.bJg("<init>");
      AppMethodBeat.o(57041);
      return;
    }
  }
  
  protected f(e parame, k paramk, g paramg, boolean paramBoolean, b.a parama, av paramav)
  {
    super(parame, paramk, paramg, aiJS, parama, paramav);
    AppMethodBeat.i(57015);
    this.rNy = paramBoolean;
    AppMethodBeat.o(57015);
  }
  
  public static f a(e parame, g paramg, av paramav)
  {
    AppMethodBeat.i(57016);
    if (paramg == null) {
      aKu(5);
    }
    if (paramav == null) {
      aKu(6);
    }
    parame = new f(parame, null, paramg, true, b.a.aiGl, paramav);
    AppMethodBeat.o(57016);
    return parame;
  }
  
  private d a(l paraml, ab paramab, t paramt, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(191893);
    paraml = (d)super.b(paraml, paramab, paramt, parama, paramBoolean);
    if (paraml == null) {
      aKu(25);
    }
    AppMethodBeat.o(191893);
    return paraml;
  }
  
  public final void M(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(57025);
    if (paramCollection == null) {
      aKu(20);
    }
    if ((!$assertionsDisabled) && (!paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Constructors cannot override anything");
      AppMethodBeat.o(57025);
      throw paramCollection;
    }
    AppMethodBeat.o(57025);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57023);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57023);
    return paramn;
  }
  
  public final f a(List<bd> paramList, t paramt)
  {
    AppMethodBeat.i(191899);
    if (paramList == null) {
      aKu(13);
    }
    if (paramt == null) {
      aKu(14);
    }
    a(paramList, paramt, kpJ().kno());
    AppMethodBeat.o(191899);
    return this;
  }
  
  public final f a(List<bd> paramList, t paramt, List<ba> paramList1)
  {
    AppMethodBeat.i(191896);
    if (paramList == null) {
      aKu(10);
    }
    if (paramt == null) {
      aKu(11);
    }
    if (paramList1 == null) {
      aKu(12);
    }
    Object localObject = kpJ();
    if (((e)localObject).kne())
    {
      localObject = ((e)localObject).knp();
      if (!(localObject instanceof e)) {}
    }
    for (localObject = ((e)localObject).kov();; localObject = null)
    {
      super.a(null, (as)localObject, paramList1, paramList, null, ab.aiGY, paramt);
      AppMethodBeat.o(191896);
      return this;
    }
  }
  
  public final d a(be parambe)
  {
    AppMethodBeat.i(57022);
    if (parambe == null) {
      aKu(18);
    }
    parambe = (d)super.c(parambe);
    AppMethodBeat.o(57022);
    return parambe;
  }
  
  protected f b(l paraml, x paramx, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, av paramav)
  {
    AppMethodBeat.i(57026);
    if (paraml == null) {
      aKu(21);
    }
    if (parama == null) {
      aKu(22);
    }
    if (paramg == null) {
      aKu(23);
    }
    if (paramav == null) {
      aKu(24);
    }
    if ((parama != b.a.aiGl) && (parama != b.a.aiGo))
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
    paraml = new f((e)paraml, this, paramg, this.rNy, b.a.aiGl, paramav);
    AppMethodBeat.o(57026);
    return paraml;
  }
  
  public final boolean koA()
  {
    return this.rNy;
  }
  
  public final Collection<? extends x> kof()
  {
    AppMethodBeat.i(57024);
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      aKu(19);
    }
    AppMethodBeat.o(57024);
    return localSet;
  }
  
  public final d kos()
  {
    AppMethodBeat.i(57021);
    d locald = (d)super.koH();
    if (locald == null) {
      aKu(17);
    }
    AppMethodBeat.o(57021);
    return locald;
  }
  
  public final e koz()
  {
    AppMethodBeat.i(57020);
    e locale = kpJ();
    if (locale == null) {
      aKu(16);
    }
    AppMethodBeat.o(57020);
    return locale;
  }
  
  public final e kpJ()
  {
    AppMethodBeat.i(57019);
    e locale = (e)super.knp();
    if (locale == null) {
      aKu(15);
    }
    AppMethodBeat.o(57019);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.f
 * JD-Core Version:    0.7.0.1
 */