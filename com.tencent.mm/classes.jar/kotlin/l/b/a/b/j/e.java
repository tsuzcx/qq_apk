package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.t;

public final class e
{
  private static av A(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(59940);
    p.h(parame, "$this$underlyingRepresentation");
    if (!parame.hzI())
    {
      AppMethodBeat.o(59940);
      return null;
    }
    parame = parame.hzD();
    if (parame != null)
    {
      parame = parame.hAw();
      if (parame != null)
      {
        parame = (av)j.kx(parame);
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
    p.h(paraml, "$this$isInlineClass");
    if (((paraml instanceof kotlin.l.b.a.b.b.e)) && (((kotlin.l.b.a.b.b.e)paraml).hzI()))
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
    p.h(paramax, "$this$isUnderlyingPropertyOfInlineClass");
    Object localObject = paramax.hzx();
    p.g(localObject, "this.containingDeclaration");
    if (!D((l)localObject))
    {
      AppMethodBeat.o(59945);
      return false;
    }
    if (localObject == null)
    {
      paramax = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(59945);
      throw paramax;
    }
    localObject = A((kotlin.l.b.a.b.b.e)localObject);
    if (localObject != null) {}
    for (localObject = ((av)localObject).hAH();; localObject = null)
    {
      boolean bool = p.j(localObject, paramax.hAH());
      AppMethodBeat.o(59945);
      return bool;
    }
  }
  
  public static final boolean aa(ab paramab)
  {
    AppMethodBeat.i(59942);
    p.h(paramab, "$this$isInlineClassType");
    paramab = paramab.hKE().hzS();
    if (paramab != null)
    {
      boolean bool = D((l)paramab);
      AppMethodBeat.o(59942);
      return bool;
    }
    AppMethodBeat.o(59942);
    return false;
  }
  
  public static final ab ab(ab paramab)
  {
    AppMethodBeat.i(59943);
    p.h(paramab, "$this$substitutedUnderlyingType");
    p.h(paramab, "$this$unsubstitutedUnderlyingParameter");
    kotlin.l.b.a.b.b.h localh = paramab.hKE().hzS();
    Object localObject = localh;
    if (!(localh instanceof kotlin.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (kotlin.l.b.a.b.b.e)localObject;
    if (localObject != null) {}
    for (localObject = A((kotlin.l.b.a.b.b.e)localObject); localObject == null; localObject = null)
    {
      AppMethodBeat.o(59943);
      return null;
    }
    paramab = paramab.hAp();
    localObject = ((av)localObject).hAH();
    p.g(localObject, "parameter.name");
    paramab = (ah)j.j((Iterable)paramab.a((f)localObject, (kotlin.l.b.a.b.c.a.a)c.TnN));
    if (paramab != null)
    {
      paramab = paramab.hBy();
      AppMethodBeat.o(59943);
      return paramab;
    }
    AppMethodBeat.o(59943);
    return null;
  }
  
  public static final boolean f(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59944);
    p.h(parama, "$this$isGetterOfUnderlyingPropertyOfInlineClass");
    if ((parama instanceof ai))
    {
      parama = ((ai)parama).hBm();
      p.g(parama, "correspondingProperty");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e
 * JD-Core Version:    0.7.0.1
 */