package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import d.l.b.a.b.j.a.a.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bg;
import java.util.List;

public final class l
  implements b
{
  final av NTs;
  final as NZC;
  private final f Oaq;
  d.g.a.a<? extends List<? extends bg>> Oar;
  final l Oas;
  
  l(av paramav, d.g.a.a<? extends List<? extends bg>> parama, l paraml, as paramas)
  {
    AppMethodBeat.i(193321);
    this.NTs = paramav;
    this.Oar = parama;
    this.Oas = paraml;
    this.NZC = paramas;
    this.Oaq = d.g.a(k.Nhe, (d.g.a.a)new a(this));
    AppMethodBeat.o(193321);
  }
  
  private l(av paramav, List<? extends bg> paramList)
  {
    this(paramav, (d.g.a.a)new q(paramList) {}, null, 8);
    AppMethodBeat.i(61082);
    AppMethodBeat.o(61082);
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
    for (Object localObject1 = paramObject.getClass(); (p.i(localObject2, localObject1) ^ true); localObject1 = null)
    {
      AppMethodBeat.o(61078);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
      AppMethodBeat.o(61078);
      throw paramObject;
    }
    localObject1 = this.Oas;
    if (localObject1 == null) {
      localObject1 = this;
    }
    for (;;)
    {
      localObject2 = ((l)paramObject).Oas;
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
    return (List)d.a.v.NhH;
  }
  
  public final h gmq()
  {
    return null;
  }
  
  public final boolean gms()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g gnF()
  {
    AppMethodBeat.i(61077);
    Object localObject = this.NTs.gnW();
    p.g(localObject, "projection.type");
    localObject = d.l.b.a.b.m.d.a.aN((ab)localObject);
    AppMethodBeat.o(61077);
    return localObject;
  }
  
  public final av gxC()
  {
    return this.NTs;
  }
  
  public final List<bg> gyu()
  {
    AppMethodBeat.i(61075);
    List localList2 = (List)this.Oaq.getValue();
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)d.a.v.NhH;
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
      locall = ((l)localObject).Oas;
      if (locall == null) {
        break;
      }
    }
    int i = localObject.hashCode();
    AppMethodBeat.o(61079);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61080);
    String str = "CapturedType(" + this.NTs + ')';
    AppMethodBeat.o(61080);
    return str;
  }
  
  static final class a
    extends q
    implements d.g.a.a<List<? extends bg>>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements d.g.a.a<List<? extends bg>>
  {
    b(List paramList)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements d.g.a.a<List<? extends bg>>
  {
    c(l paraml, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.l
 * JD-Core Version:    0.7.0.1
 */