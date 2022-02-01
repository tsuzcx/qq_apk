package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.j.a.a.b;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bk;
import kotlin.o;

public final class j
  implements b
{
  private final ba aiUy;
  public final az ajjx;
  kotlin.g.a.a<? extends List<? extends bk>> ajrg;
  private final j ajrh;
  private final kotlin.j ajri;
  
  private j(az paramaz, List<? extends bk> paramList)
  {
    this(paramaz, (kotlin.g.a.a)new u(paramList) {}, null, null, 8);
    AppMethodBeat.i(61082);
    AppMethodBeat.o(61082);
  }
  
  private j(az paramaz, kotlin.g.a.a<? extends List<? extends bk>> parama, j paramj, ba paramba)
  {
    AppMethodBeat.i(191688);
    this.ajjx = paramaz;
    this.ajrg = parama;
    this.ajrh = paramj;
    this.aiUy = paramba;
    this.ajri = k.a(o.aiuG, (kotlin.g.a.a)new a(this));
    AppMethodBeat.o(191688);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61078);
    if (this == paramObject)
    {
      AppMethodBeat.o(61078);
      return true;
    }
    Object localObject2 = getClass();
    if (paramObject == null) {}
    for (Object localObject1 = null; !s.p(localObject2, localObject1); localObject1 = paramObject.getClass())
    {
      AppMethodBeat.o(61078);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
      AppMethodBeat.o(61078);
      throw paramObject;
    }
    localObject1 = this.ajrh;
    if (localObject1 == null)
    {
      localObject1 = this;
      localObject2 = ((j)paramObject).ajrh;
      if (localObject2 != null) {
        break label115;
      }
    }
    label115:
    for (paramObject = (j)paramObject;; paramObject = localObject2)
    {
      if (localObject1 != paramObject) {
        break label120;
      }
      AppMethodBeat.o(61078);
      return true;
      break;
    }
    label120:
    AppMethodBeat.o(61078);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61079);
    j localj;
    for (Object localObject = this;; localObject = localj)
    {
      localj = ((j)localObject).ajrh;
      if (localj == null)
      {
        int i = localObject.hashCode();
        AppMethodBeat.o(61079);
        return i;
      }
    }
  }
  
  public final List<bk> kAC()
  {
    AppMethodBeat.i(61075);
    List localList = (List)this.ajri.getValue();
    if (localList == null)
    {
      localList = (List)ab.aivy;
      AppMethodBeat.o(61075);
      return localList;
    }
    AppMethodBeat.o(61075);
    return localList;
  }
  
  public final List<ba> klq()
  {
    return (List)ab.aivy;
  }
  
  public final kotlin.l.b.a.b.b.h knA()
  {
    return null;
  }
  
  public final boolean knx()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.a.h koV()
  {
    AppMethodBeat.i(61077);
    Object localObject = this.ajjx.koG();
    s.s(localObject, "projection.type");
    localObject = kotlin.l.b.a.b.m.d.a.aE((ad)localObject);
    AppMethodBeat.o(61077);
    return localObject;
  }
  
  public final az kzn()
  {
    return this.ajjx;
  }
  
  public final void pg(List<? extends bk> paramList)
  {
    AppMethodBeat.i(191716);
    s.u(paramList, "supertypes");
    if (this.ajrg == null) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Already initialized! oldValue = " + this.ajrg + ", newValue = " + paramList);
      AppMethodBeat.o(191716);
      throw paramList;
    }
    this.ajrg = ((kotlin.g.a.a)new b(paramList));
    AppMethodBeat.o(191716);
  }
  
  public final j r(final g paramg)
  {
    AppMethodBeat.i(191729);
    s.u(paramg, "kotlinTypeRefiner");
    az localaz = this.ajjx.o(paramg);
    s.s(localaz, "projection.refine(kotlinTypeRefiner)");
    if (this.ajrg == null) {}
    for (paramg = null;; paramg = (kotlin.g.a.a)new c(this, paramg))
    {
      j localj2 = this.ajrh;
      j localj1 = localj2;
      if (localj2 == null) {
        localj1 = this;
      }
      paramg = new j(localaz, paramg, localj1, this.aiUy);
      AppMethodBeat.o(191729);
      return paramg;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61080);
    String str = "CapturedType(" + this.ajjx + ')';
    AppMethodBeat.o(61080);
    return str;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<List<? extends bk>>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<List<? extends bk>>
  {
    b(List<? extends bk> paramList)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<List<? extends bk>>
  {
    c(j paramj, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.j
 * JD-Core Version:    0.7.0.1
 */