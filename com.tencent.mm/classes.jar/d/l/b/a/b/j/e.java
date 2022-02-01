package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.l;
import d.l.b.a.b.c.a.c;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.v;

public final class e
{
  private static av A(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(59940);
    k.h(parame, "$this$underlyingRepresentation");
    if (!parame.fQf())
    {
      AppMethodBeat.o(59940);
      return null;
    }
    parame = parame.fQa();
    if (parame != null)
    {
      parame = parame.fQU();
      if (parame != null)
      {
        parame = (av)j.iT(parame);
        AppMethodBeat.o(59940);
        return parame;
      }
    }
    AppMethodBeat.o(59940);
    return null;
  }
  
  public static final boolean D(l paraml)
  {
    AppMethodBeat.i(59941);
    k.h(paraml, "$this$isInlineClass");
    if (((paraml instanceof d.l.b.a.b.b.e)) && (((d.l.b.a.b.b.e)paraml).fQf()))
    {
      AppMethodBeat.o(59941);
      return true;
    }
    AppMethodBeat.o(59941);
    return false;
  }
  
  public static final boolean a(ax paramax)
  {
    AppMethodBeat.i(59945);
    k.h(paramax, "$this$isUnderlyingPropertyOfInlineClass");
    Object localObject = paramax.fPU();
    k.g(localObject, "this.containingDeclaration");
    if (!D((l)localObject))
    {
      AppMethodBeat.o(59945);
      return false;
    }
    if (localObject == null)
    {
      paramax = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(59945);
      throw paramax;
    }
    localObject = A((d.l.b.a.b.b.e)localObject);
    if (localObject != null) {}
    for (localObject = ((av)localObject).fRf();; localObject = null)
    {
      boolean bool = k.g(localObject, paramax.fRf());
      AppMethodBeat.o(59945);
      return bool;
    }
  }
  
  public static final boolean ab(ab paramab)
  {
    AppMethodBeat.i(59942);
    k.h(paramab, "$this$isInlineClassType");
    paramab = paramab.gbz().fQq();
    if (paramab != null)
    {
      boolean bool = D((l)paramab);
      AppMethodBeat.o(59942);
      return bool;
    }
    AppMethodBeat.o(59942);
    return false;
  }
  
  public static final ab ac(ab paramab)
  {
    AppMethodBeat.i(59943);
    k.h(paramab, "$this$substitutedUnderlyingType");
    k.h(paramab, "$this$unsubstitutedUnderlyingParameter");
    d.l.b.a.b.b.h localh = paramab.gbz().fQq();
    Object localObject = localh;
    if (!(localh instanceof d.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (d.l.b.a.b.b.e)localObject;
    if (localObject != null) {}
    for (localObject = A((d.l.b.a.b.b.e)localObject); localObject == null; localObject = null)
    {
      AppMethodBeat.o(59943);
      return null;
    }
    paramab = paramab.fQN();
    localObject = ((av)localObject).fRf();
    k.g(localObject, "parameter.name");
    paramab = (ah)j.g((Iterable)paramab.a((f)localObject, (d.l.b.a.b.c.a.a)c.Lkd));
    if (paramab != null)
    {
      paramab = paramab.fRV();
      AppMethodBeat.o(59943);
      return paramab;
    }
    AppMethodBeat.o(59943);
    return null;
  }
  
  public static final boolean f(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59944);
    k.h(parama, "$this$isGetterOfUnderlyingPropertyOfInlineClass");
    if ((parama instanceof ai))
    {
      parama = ((ai)parama).fRJ();
      k.g(parama, "correspondingProperty");
      if (a((ax)parama))
      {
        AppMethodBeat.o(59944);
        return true;
      }
    }
    AppMethodBeat.o(59944);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.e
 * JD-Core Version:    0.7.0.1
 */