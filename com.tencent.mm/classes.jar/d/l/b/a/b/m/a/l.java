package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g.b.u;
import d.g.b.w;
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
  final av LFo;
  private final f LMo;
  d.g.a.a<? extends List<? extends bg>> LMp;
  final l LMq;
  
  static
  {
    AppMethodBeat.i(61074);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(l.class), "_supertypes", "get_supertypes()Ljava/util/List;")) };
    AppMethodBeat.o(61074);
  }
  
  l(av paramav, d.g.a.a<? extends List<? extends bg>> parama, l paraml)
  {
    AppMethodBeat.i(61081);
    this.LFo = paramav;
    this.LMp = parama;
    this.LMq = paraml;
    this.LMo = d.g.a(d.k.KTd, (d.g.a.a)new a(this));
    AppMethodBeat.o(61081);
  }
  
  private l(av paramav, List<? extends bg> paramList)
  {
    this(paramav, (d.g.a.a)new d.g.b.l(paramList) {}, null);
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
    for (Object localObject1 = paramObject.getClass(); (d.g.b.k.g(localObject2, localObject1) ^ true); localObject1 = null)
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
    localObject1 = this.LMq;
    if (localObject1 == null) {
      localObject1 = this;
    }
    for (;;)
    {
      localObject2 = ((l)paramObject).LMq;
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
  
  public final h fQq()
  {
    return null;
  }
  
  public final boolean fQs()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g fRE()
  {
    AppMethodBeat.i(61077);
    Object localObject = this.LFo.fRV();
    d.g.b.k.g(localObject, "projection.type");
    localObject = d.l.b.a.b.m.d.a.aN((ab)localObject);
    AppMethodBeat.o(61077);
    return localObject;
  }
  
  public final av gbA()
  {
    return this.LFo;
  }
  
  public final List<bg> gcs()
  {
    AppMethodBeat.i(61075);
    List localList2 = (List)this.LMo.getValue();
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)d.a.v.KTF;
    }
    AppMethodBeat.o(61075);
    return localList1;
  }
  
  public final List<as> getParameters()
  {
    return (List)d.a.v.KTF;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61079);
    l locall;
    for (Object localObject = this;; localObject = locall)
    {
      locall = ((l)localObject).LMq;
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
    String str = "CapturedType(" + this.LFo + ')';
    AppMethodBeat.o(61080);
    return str;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends bg>>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<? extends bg>>
  {
    b(List paramList)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
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