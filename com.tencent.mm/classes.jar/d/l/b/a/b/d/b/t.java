package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.c;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.bc;
import java.util.Iterator;
import java.util.List;

public final class t
{
  public static final k V(ab paramab)
  {
    AppMethodBeat.i(58246);
    p.h(paramab, "$this$mapToJvmType");
    paramab = (k)aa.a(paramab, (l)m.Njb, y.Njt, (w)x.Nji);
    AppMethodBeat.o(58246);
    return paramab;
  }
  
  private static String a(d.l.b.a.b.b.t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58241);
    p.h(paramt, "$this$computeJvmDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if (paramBoolean2)
    {
      if (!(paramt instanceof d.l.b.a.b.b.k)) {
        break label119;
      }
      localObject1 = "<init>";
    }
    Object localObject2;
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localObject1 = paramt.gis().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        p.g(localObject2, "parameter");
        localObject2 = ((av)localObject2).gju();
        p.g(localObject2, "parameter.type");
        a(localStringBuilder, (ab)localObject2);
      }
      label119:
      localObject1 = paramt.giD().sD();
      p.g(localObject1, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject1 = (d.l.b.a.b.b.a)paramt;
      p.h(localObject1, "descriptor");
      if (!(localObject1 instanceof d.l.b.a.b.b.k)) {
        break label206;
      }
      i = 1;
      if (i == 0) {
        break label274;
      }
      localStringBuilder.append("V");
    }
    for (;;)
    {
      paramt = localStringBuilder.toString();
      p.g(paramt, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(58241);
      return paramt;
      label206:
      localObject2 = ((d.l.b.a.b.b.a)localObject1).giq();
      if (localObject2 == null) {
        p.gfZ();
      }
      if (g.C((ab)localObject2))
      {
        localObject2 = ((d.l.b.a.b.b.a)localObject1).giq();
        if (localObject2 == null) {
          p.gfZ();
        }
        if ((!bc.aF((ab)localObject2)) && (!(localObject1 instanceof ai)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      label274:
      paramt = paramt.giq();
      if (paramt == null) {
        p.gfZ();
      }
      p.g(paramt, "returnType!!");
      a(localStringBuilder, paramt);
    }
  }
  
  private static final void a(StringBuilder paramStringBuilder, ab paramab)
  {
    AppMethodBeat.i(58245);
    paramStringBuilder.append(V(paramab));
    AppMethodBeat.o(58245);
  }
  
  public static final boolean b(d.l.b.a.b.b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(58243);
    p.h(parama, "f");
    if (!(parama instanceof d.l.b.a.b.b.t))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    if ((((d.l.b.a.b.b.t)parama).gis().size() != 1) || (d.l.b.a.b.d.a.t.r((d.l.b.a.b.b.b)parama)) || ((p.i(((d.l.b.a.b.b.t)parama).giD().sD(), "remove") ^ true)))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    Object localObject1 = ((d.l.b.a.b.b.t)parama).giP();
    p.g(localObject1, "f.original");
    localObject1 = ((d.l.b.a.b.b.t)localObject1).gis();
    p.g(localObject1, "f.original.valueParameters");
    localObject1 = j.jg((List)localObject1);
    p.g(localObject1, "f.original.valueParameters.single()");
    localObject1 = ((av)localObject1).gju();
    p.g(localObject1, "f.original.valueParameters.single().type");
    Object localObject3 = V((ab)localObject1);
    localObject1 = localObject3;
    if (!(localObject3 instanceof k.c)) {
      localObject1 = null;
    }
    localObject3 = (k.c)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((k.c)localObject3).Nja;
    }
    if (localObject1 != d.l.b.a.b.j.e.d.NwX)
    {
      AppMethodBeat.o(58243);
      return false;
    }
    parama = d.l.b.a.b.d.a.d.e((d.l.b.a.b.b.t)parama);
    if (parama == null)
    {
      AppMethodBeat.o(58243);
      return false;
    }
    localObject1 = parama.giP();
    p.g(localObject1, "overridden.original");
    localObject1 = ((d.l.b.a.b.b.t)localObject1).gis();
    p.g(localObject1, "overridden.original.valueParameters");
    localObject1 = j.jg((List)localObject1);
    p.g(localObject1, "overridden.original.valueParameters.single()");
    localObject1 = ((av)localObject1).gju();
    p.g(localObject1, "overridden.original.valueParameters.single().type");
    localObject1 = V((ab)localObject1);
    parama = parama.ghs();
    p.g(parama, "overridden.containingDeclaration");
    if ((p.i(d.l.b.a.b.j.d.a.q(parama), g.MQb.MRa.grf())) && ((localObject1 instanceof k.b)) && (p.i(((k.b)localObject1).NiZ, "java/lang/Object")))
    {
      AppMethodBeat.o(58243);
      return true;
    }
    AppMethodBeat.o(58243);
    return false;
  }
  
  public static final String c(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(58244);
    p.h(parama, "$this$computeJvmSignature");
    Object localObject1 = v.Njg;
    if (c.m((d.l.b.a.b.b.l)parama))
    {
      AppMethodBeat.o(58244);
      return null;
    }
    Object localObject2 = parama.ghs();
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    if (localObject2 == null)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    localObject1 = ((e)localObject2).giD();
    p.g(localObject1, "classDescriptor.name");
    if (((f)localObject1).Nqp)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    localObject1 = parama.gir();
    parama = (d.l.b.a.b.b.a)localObject1;
    if (!(localObject1 instanceof am)) {
      parama = null;
    }
    parama = (am)parama;
    if (parama == null)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    parama = v.a((e)localObject2, a((d.l.b.a.b.b.t)parama, false, false, 3));
    AppMethodBeat.o(58244);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.t
 * JD-Core Version:    0.7.0.1
 */