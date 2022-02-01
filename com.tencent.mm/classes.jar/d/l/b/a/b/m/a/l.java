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
  final as NCv;
  private final f NDj;
  d.g.a.a<? extends List<? extends bg>> NDk;
  final l NDl;
  final av Nwm;
  
  l(av paramav, d.g.a.a<? extends List<? extends bg>> parama, l paraml, as paramas)
  {
    AppMethodBeat.i(187797);
    this.Nwm = paramav;
    this.NDk = parama;
    this.NDl = paraml;
    this.NCv = paramas;
    this.NDj = d.g.a(k.MKb, (d.g.a.a)new a(this));
    AppMethodBeat.o(187797);
  }
  
  private l(av paramav, List<? extends bg> paramList)
  {
    this(paramav, (d.g.a.a)new l.1(paramList), null, 8);
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
    localObject1 = this.NDl;
    if (localObject1 == null) {
      localObject1 = this;
    }
    for (;;)
    {
      localObject2 = ((l)paramObject).NDl;
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
    return (List)d.a.v.MKE;
  }
  
  public final h ghO()
  {
    return null;
  }
  
  public final boolean ghQ()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g gjd()
  {
    AppMethodBeat.i(61077);
    Object localObject = this.Nwm.gju();
    p.g(localObject, "projection.type");
    localObject = d.l.b.a.b.m.d.a.aN((ab)localObject);
    AppMethodBeat.o(61077);
    return localObject;
  }
  
  public final List<bg> gtS()
  {
    AppMethodBeat.i(61075);
    List localList2 = (List)this.NDj.getValue();
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)d.a.v.MKE;
    }
    AppMethodBeat.o(61075);
    return localList1;
  }
  
  public final av gta()
  {
    return this.Nwm;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61079);
    l locall;
    for (Object localObject = this;; localObject = locall)
    {
      locall = ((l)localObject).NDl;
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
    String str = "CapturedType(" + this.Nwm + ')';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.l
 * JD-Core Version:    0.7.0.1
 */