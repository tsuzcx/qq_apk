package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bc;

public final class t
{
  public static final k U(ab paramab)
  {
    AppMethodBeat.i(58246);
    p.h(paramab, "$this$mapToJvmType");
    paramab = (k)aa.a(paramab, (l)m.TvN, y.Twf, (w)x.TvU);
    AppMethodBeat.o(58246);
    return paramab;
  }
  
  private static String a(kotlin.l.b.a.b.b.t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58241);
    p.h(paramt, "$this$computeJvmDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if (paramBoolean2)
    {
      if (!(paramt instanceof kotlin.l.b.a.b.b.k)) {
        break label119;
      }
      localObject1 = "<init>";
    }
    Object localObject2;
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localObject1 = paramt.hAw().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        p.g(localObject2, "parameter");
        localObject2 = ((av)localObject2).hBy();
        p.g(localObject2, "parameter.type");
        a(localStringBuilder, (ab)localObject2);
      }
      label119:
      localObject1 = paramt.hAH().sG();
      p.g(localObject1, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject1 = (kotlin.l.b.a.b.b.a)paramt;
      p.h(localObject1, "descriptor");
      if (!(localObject1 instanceof kotlin.l.b.a.b.b.k)) {
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
      localObject2 = ((kotlin.l.b.a.b.b.a)localObject1).hAu();
      if (localObject2 == null) {
        p.hyc();
      }
      if (g.C((ab)localObject2))
      {
        localObject2 = ((kotlin.l.b.a.b.b.a)localObject1).hAu();
        if (localObject2 == null) {
          p.hyc();
        }
        if ((!bc.aE((ab)localObject2)) && (!(localObject1 instanceof ai)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      label274:
      paramt = paramt.hAu();
      if (paramt == null) {
        p.hyc();
      }
      p.g(paramt, "returnType!!");
      a(localStringBuilder, paramt);
    }
  }
  
  private static final void a(StringBuilder paramStringBuilder, ab paramab)
  {
    AppMethodBeat.i(58245);
    paramStringBuilder.append(U(paramab));
    AppMethodBeat.o(58245);
  }
  
  public static final boolean b(kotlin.l.b.a.b.b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(58243);
    p.h(parama, "f");
    if (!(parama instanceof kotlin.l.b.a.b.b.t))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    if ((((kotlin.l.b.a.b.b.t)parama).hAw().size() != 1) || (kotlin.l.b.a.b.d.a.t.r((kotlin.l.b.a.b.b.b)parama)) || ((p.j(((kotlin.l.b.a.b.b.t)parama).hAH().sG(), "remove") ^ true)))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    Object localObject1 = ((kotlin.l.b.a.b.b.t)parama).hAT();
    p.g(localObject1, "f.original");
    localObject1 = ((kotlin.l.b.a.b.b.t)localObject1).hAw();
    p.g(localObject1, "f.original.valueParameters");
    localObject1 = j.kw((List)localObject1);
    p.g(localObject1, "f.original.valueParameters.single()");
    localObject1 = ((av)localObject1).hBy();
    p.g(localObject1, "f.original.valueParameters.single().type");
    Object localObject3 = U((ab)localObject1);
    localObject1 = localObject3;
    if (!(localObject3 instanceof k.c)) {
      localObject1 = null;
    }
    localObject3 = (k.c)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((k.c)localObject3).TvM;
    }
    if (localObject1 != kotlin.l.b.a.b.j.e.d.TJa)
    {
      AppMethodBeat.o(58243);
      return false;
    }
    parama = kotlin.l.b.a.b.d.a.d.e((kotlin.l.b.a.b.b.t)parama);
    if (parama == null)
    {
      AppMethodBeat.o(58243);
      return false;
    }
    localObject1 = parama.hAT();
    p.g(localObject1, "overridden.original");
    localObject1 = ((kotlin.l.b.a.b.b.t)localObject1).hAw();
    p.g(localObject1, "overridden.original.valueParameters");
    localObject1 = j.kw((List)localObject1);
    p.g(localObject1, "overridden.original.valueParameters.single()");
    localObject1 = ((av)localObject1).hBy();
    p.g(localObject1, "overridden.original.valueParameters.single().type");
    localObject1 = U((ab)localObject1);
    parama = parama.hzx();
    p.g(parama, "overridden.containingDeclaration");
    if ((p.j(kotlin.l.b.a.b.j.d.a.q(parama), g.TcO.TdN.hJe())) && ((localObject1 instanceof k.b)) && (p.j(((k.b)localObject1).TvL, "java/lang/Object")))
    {
      AppMethodBeat.o(58243);
      return true;
    }
    AppMethodBeat.o(58243);
    return false;
  }
  
  public static final String c(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(58244);
    p.h(parama, "$this$computeJvmSignature");
    Object localObject1 = v.TvS;
    if (c.m((kotlin.l.b.a.b.b.l)parama))
    {
      AppMethodBeat.o(58244);
      return null;
    }
    Object localObject2 = parama.hzx();
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
    localObject1 = ((e)localObject2).hAH();
    p.g(localObject1, "classDescriptor.name");
    if (((f)localObject1).TDa)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    localObject1 = parama.hAv();
    parama = (kotlin.l.b.a.b.b.a)localObject1;
    if (!(localObject1 instanceof am)) {
      parama = null;
    }
    parama = (am)parama;
    if (parama == null)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    parama = v.a((e)localObject2, a((kotlin.l.b.a.b.b.t)parama, false, false, 3));
    AppMethodBeat.o(58244);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.t
 * JD-Core Version:    0.7.0.1
 */