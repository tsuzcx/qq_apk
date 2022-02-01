package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.o;

public final class at<T extends kotlin.l.b.a.b.j.g.h>
{
  public static final a aiHn;
  private final e aiHo;
  private final b<g, T> aiHp;
  private final g aiHq;
  private final kotlin.l.b.a.b.l.h aiHr;
  
  static
  {
    AppMethodBeat.i(56881);
    aYe = new o[] { (o)ai.a((af)new ag((kotlin.l.e)ai.cz(at.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")) };
    aiHn = new a((byte)0);
    AppMethodBeat.o(56881);
  }
  
  private at(e parame, m paramm, b<? super g, ? extends T> paramb, g paramg)
  {
    AppMethodBeat.i(56883);
    this.aiHo = parame;
    this.aiHp = paramb;
    this.aiHq = paramg;
    this.aiHr = paramm.cq((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(56883);
  }
  
  private final T kpj()
  {
    AppMethodBeat.i(191822);
    kotlin.l.b.a.b.j.g.h localh = (kotlin.l.b.a.b.j.g.h)kotlin.l.b.a.b.l.l.a(this.aiHr, aYe[0]);
    AppMethodBeat.o(191822);
    return localh;
  }
  
  public final T b(final g paramg)
  {
    AppMethodBeat.i(56882);
    s.u(paramg, "kotlinTypeRefiner");
    if (!paramg.g(kotlin.l.b.a.b.j.d.a.F((l)this.aiHo)))
    {
      paramg = kpj();
      AppMethodBeat.o(56882);
      return paramg;
    }
    ax localax = this.aiHo.kmZ();
    s.s(localax, "classDescriptor.typeConstructor");
    if (!paramg.e(localax))
    {
      paramg = kpj();
      AppMethodBeat.o(56882);
      return paramg;
    }
    paramg = paramg.a(this.aiHo, (kotlin.g.a.a)new b(this, paramg));
    AppMethodBeat.o(56882);
    return paramg;
  }
  
  public static final class a
  {
    public static <T extends kotlin.l.b.a.b.j.g.h> at<T> a(e parame, m paramm, g paramg, b<? super g, ? extends T> paramb)
    {
      AppMethodBeat.i(56879);
      s.u(parame, "classDescriptor");
      s.u(paramm, "storageManager");
      s.u(paramg, "kotlinTypeRefinerForOwnerModule");
      s.u(paramb, "scopeFactory");
      parame = new at(parame, paramm, paramb, paramg, (byte)0);
      AppMethodBeat.o(56879);
      return parame;
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<T>
  {
    b(at<T> paramat, g paramg)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<T>
  {
    c(at<T> paramat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.at
 * JD-Core Version:    0.7.0.1
 */