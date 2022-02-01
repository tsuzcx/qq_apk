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
    p.k(paramab, "$this$mapToJvmType");
    paramab = (k)aa.a(paramab, (l)m.aaYD, y.aaYV, (w)x.aaYK);
    AppMethodBeat.o(58246);
    return paramab;
  }
  
  private static String a(kotlin.l.b.a.b.b.t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58241);
    p.k(paramt, "$this$computeJvmDescriptor");
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
      localObject1 = paramt.iEJ().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        p.j(localObject2, "parameter");
        localObject2 = ((av)localObject2).iFN();
        p.j(localObject2, "parameter.type");
        a(localStringBuilder, (ab)localObject2);
      }
      label119:
      localObject1 = paramt.iEU().qu();
      p.j(localObject1, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject1 = (kotlin.l.b.a.b.b.a)paramt;
      p.k(localObject1, "descriptor");
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
      p.j(paramt, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(58241);
      return paramt;
      label206:
      localObject2 = ((kotlin.l.b.a.b.b.a)localObject1).iEH();
      if (localObject2 == null) {
        p.iCn();
      }
      if (g.C((ab)localObject2))
      {
        localObject2 = ((kotlin.l.b.a.b.b.a)localObject1).iEH();
        if (localObject2 == null) {
          p.iCn();
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
      paramt = paramt.iEH();
      if (paramt == null) {
        p.iCn();
      }
      p.j(paramt, "returnType!!");
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
    p.k(parama, "f");
    if (!(parama instanceof kotlin.l.b.a.b.b.t))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    if ((((kotlin.l.b.a.b.b.t)parama).iEJ().size() != 1) || (kotlin.l.b.a.b.d.a.t.r((kotlin.l.b.a.b.b.b)parama)) || ((p.h(((kotlin.l.b.a.b.b.t)parama).iEU().qu(), "remove") ^ true)))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    Object localObject1 = ((kotlin.l.b.a.b.b.t)parama).iFh();
    p.j(localObject1, "f.original");
    localObject1 = ((kotlin.l.b.a.b.b.t)localObject1).iEJ();
    p.j(localObject1, "f.original.valueParameters");
    localObject1 = j.ls((List)localObject1);
    p.j(localObject1, "f.original.valueParameters.single()");
    localObject1 = ((av)localObject1).iFN();
    p.j(localObject1, "f.original.valueParameters.single().type");
    Object localObject3 = U((ab)localObject1);
    localObject1 = localObject3;
    if (!(localObject3 instanceof k.c)) {
      localObject1 = null;
    }
    localObject3 = (k.c)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((k.c)localObject3).aaYC;
    }
    if (localObject1 != kotlin.l.b.a.b.j.e.d.ablC)
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
    localObject1 = parama.iFh();
    p.j(localObject1, "overridden.original");
    localObject1 = ((kotlin.l.b.a.b.b.t)localObject1).iEJ();
    p.j(localObject1, "overridden.original.valueParameters");
    localObject1 = j.ls((List)localObject1);
    p.j(localObject1, "overridden.original.valueParameters.single()");
    localObject1 = ((av)localObject1).iFN();
    p.j(localObject1, "overridden.original.valueParameters.single().type");
    localObject1 = U((ab)localObject1);
    parama = parama.iDJ();
    p.j(parama, "overridden.containingDeclaration");
    if ((p.h(kotlin.l.b.a.b.j.d.a.q(parama), g.aaFI.aaGH.iNy())) && ((localObject1 instanceof k.b)) && (p.h(((k.b)localObject1).aaYB, "java/lang/Object")))
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
    p.k(parama, "$this$computeJvmSignature");
    Object localObject1 = v.aaYI;
    if (c.m((kotlin.l.b.a.b.b.l)parama))
    {
      AppMethodBeat.o(58244);
      return null;
    }
    Object localObject2 = parama.iDJ();
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
    localObject1 = ((e)localObject2).iEU();
    p.j(localObject1, "classDescriptor.name");
    if (((f)localObject1).abfN)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    localObject1 = parama.iEI();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.t
 * JD-Core Version:    0.7.0.1
 */