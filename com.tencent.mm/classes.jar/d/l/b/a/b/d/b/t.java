package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
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
    d.g.b.k.h(paramab, "$this$mapToJvmType");
    paramab = (k)aa.a(paramab, (l)m.JEL, y.JFd, (w)x.JES);
    AppMethodBeat.o(58246);
    return paramab;
  }
  
  private static String a(d.l.b.a.b.b.t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58241);
    d.g.b.k.h(paramt, "$this$computeJvmDescriptor");
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
      localObject1 = paramt.fyq().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        d.g.b.k.g(localObject2, "parameter");
        localObject2 = ((av)localObject2).fzr();
        d.g.b.k.g(localObject2, "parameter.type");
        a(localStringBuilder, (ab)localObject2);
      }
      label119:
      localObject1 = paramt.fyB().qV();
      d.g.b.k.g(localObject1, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject1 = (d.l.b.a.b.b.a)paramt;
      d.g.b.k.h(localObject1, "descriptor");
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
      d.g.b.k.g(paramt, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(58241);
      return paramt;
      label206:
      localObject2 = ((d.l.b.a.b.b.a)localObject1).fyo();
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      if (g.C((ab)localObject2))
      {
        localObject2 = ((d.l.b.a.b.b.a)localObject1).fyo();
        if (localObject2 == null) {
          d.g.b.k.fvU();
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
      paramt = paramt.fyo();
      if (paramt == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.g(paramt, "returnType!!");
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
    d.g.b.k.h(parama, "f");
    if (!(parama instanceof d.l.b.a.b.b.t))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    if ((((d.l.b.a.b.b.t)parama).fyq().size() != 1) || (d.l.b.a.b.d.a.t.r((d.l.b.a.b.b.b)parama)) || ((d.g.b.k.g(((d.l.b.a.b.b.t)parama).fyB().qV(), "remove") ^ true)))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    Object localObject1 = ((d.l.b.a.b.b.t)parama).fyM();
    d.g.b.k.g(localObject1, "f.original");
    localObject1 = ((d.l.b.a.b.b.t)localObject1).fyq();
    d.g.b.k.g(localObject1, "f.original.valueParameters");
    localObject1 = j.iC((List)localObject1);
    d.g.b.k.g(localObject1, "f.original.valueParameters.single()");
    localObject1 = ((av)localObject1).fzr();
    d.g.b.k.g(localObject1, "f.original.valueParameters.single().type");
    Object localObject3 = V((ab)localObject1);
    localObject1 = localObject3;
    if (!(localObject3 instanceof k.c)) {
      localObject1 = null;
    }
    localObject3 = (k.c)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((k.c)localObject3).JEK;
    }
    if (localObject1 != d.l.b.a.b.j.e.d.JSG)
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
    localObject1 = parama.fyM();
    d.g.b.k.g(localObject1, "overridden.original");
    localObject1 = ((d.l.b.a.b.b.t)localObject1).fyq();
    d.g.b.k.g(localObject1, "overridden.original.valueParameters");
    localObject1 = j.iC((List)localObject1);
    d.g.b.k.g(localObject1, "overridden.original.valueParameters.single()");
    localObject1 = ((av)localObject1).fzr();
    d.g.b.k.g(localObject1, "overridden.original.valueParameters.single().type");
    localObject1 = V((ab)localObject1);
    parama = parama.fxq();
    d.g.b.k.g(parama, "overridden.containingDeclaration");
    if ((d.g.b.k.g(d.l.b.a.b.j.d.a.q(parama), g.JlM.JmL.fHc())) && ((localObject1 instanceof k.b)) && (d.g.b.k.g(((k.b)localObject1).JEJ, "java/lang/Object")))
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
    d.g.b.k.h(parama, "$this$computeJvmSignature");
    Object localObject1 = v.JEQ;
    if (c.m((d.l.b.a.b.b.l)parama))
    {
      AppMethodBeat.o(58244);
      return null;
    }
    Object localObject2 = parama.fxq();
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
    localObject1 = ((e)localObject2).fyB();
    d.g.b.k.g(localObject1, "classDescriptor.name");
    if (((f)localObject1).JLZ)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    localObject1 = parama.fyp();
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