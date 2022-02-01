package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.j.a.a.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.t;

public final class l
  implements b
{
  final av TIo;
  final as TOv;
  private final f TPk;
  kotlin.g.a.a<? extends List<? extends bg>> TPl;
  final l TPm;
  
  private l(av paramav, List<? extends bg> paramList)
  {
    this(paramav, (kotlin.g.a.a)new l.1(paramList), null, null, 8);
    AppMethodBeat.i(61082);
    AppMethodBeat.o(61082);
  }
  
  l(av paramav, kotlin.g.a.a<? extends List<? extends bg>> parama, l paraml, as paramas)
  {
    AppMethodBeat.i(186276);
    this.TIo = paramav;
    this.TPl = parama;
    this.TPm = paraml;
    this.TOv = paramas;
    this.TPk = kotlin.g.a(k.SWQ, (kotlin.g.a.a)new a(this));
    AppMethodBeat.o(186276);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61078);
    if ((l)this == paramObject)
    {
      AppMethodBeat.o(61078);
      return true;
    }
    Object localObject2 = getClass();
    if (paramObject != null) {}
    for (Object localObject1 = paramObject.getClass(); (p.j(localObject2, localObject1) ^ true); localObject1 = null)
    {
      AppMethodBeat.o(61078);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
      AppMethodBeat.o(61078);
      throw paramObject;
    }
    localObject1 = this.TPm;
    if (localObject1 == null) {
      localObject1 = this;
    }
    for (;;)
    {
      localObject2 = ((l)paramObject).TPm;
      if (localObject2 == null) {}
      for (paramObject = (l)paramObject;; paramObject = localObject2)
      {
        if (localObject1 == paramObject)
        {
          AppMethodBeat.o(61078);
          return true;
        }
        AppMethodBeat.o(61078);
        return false;
      }
    }
  }
  
  public final List<as> getParameters()
  {
    return (List)v.SXr;
  }
  
  public final kotlin.l.b.a.b.a.g hBh()
  {
    AppMethodBeat.i(61077);
    Object localObject = this.TIo.hBy();
    p.g(localObject, "projection.type");
    localObject = kotlin.l.b.a.b.m.d.a.aM((ab)localObject);
    AppMethodBeat.o(61077);
    return localObject;
  }
  
  public final av hKF()
  {
    return this.TIo;
  }
  
  public final List<bg> hLx()
  {
    AppMethodBeat.i(61075);
    List localList2 = (List)this.TPk.getValue();
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)v.SXr;
    }
    AppMethodBeat.o(61075);
    return localList1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61079);
    l locall;
    for (Object localObject = this;; localObject = locall)
    {
      locall = ((l)localObject).TPm;
      if (locall == null) {
        break;
      }
    }
    int i = localObject.hashCode();
    AppMethodBeat.o(61079);
    return i;
  }
  
  public final h hzS()
  {
    return null;
  }
  
  public final boolean hzU()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61080);
    String str = "CapturedType(" + this.TIo + ')';
    AppMethodBeat.o(61080);
    return str;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends bg>>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<List<? extends bg>>
  {
    c(l paraml, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.l
 * JD-Core Version:    0.7.0.1
 */