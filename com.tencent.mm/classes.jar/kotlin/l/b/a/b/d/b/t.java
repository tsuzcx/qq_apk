package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.d.a.ac;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.bg;

public final class t
{
  public static final j L(ad paramad)
  {
    AppMethodBeat.i(58246);
    kotlin.g.b.s.u(paramad, "<this>");
    paramad = (j)c.a(paramad, (k)l.aiWY, y.aiXu, (w)x.aiXg);
    AppMethodBeat.o(58246);
    return paramad;
  }
  
  private static String a(kotlin.l.b.a.b.b.x paramx, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58241);
    kotlin.g.b.s.u(paramx, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramBoolean2)
    {
      if (!(paramx instanceof kotlin.l.b.a.b.b.k)) {
        break label144;
      }
      localObject = "<init>";
    }
    ad localad;
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("(");
      localObject = paramx.knY();
      if (localObject != null)
      {
        localObject = ((as)localObject).koG();
        kotlin.g.b.s.s(localObject, "it.type");
        a(localStringBuilder, (ad)localObject);
      }
      localObject = paramx.kod().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localad = ((bd)((Iterator)localObject).next()).koG();
        kotlin.g.b.s.s(localad, "parameter.type");
        a(localStringBuilder, localad);
      }
      label144:
      localObject = paramx.kok().PF();
      kotlin.g.b.s.s(localObject, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject = (kotlin.l.b.a.b.b.a)paramx;
      kotlin.g.b.s.u(localObject, "descriptor");
      if (!(localObject instanceof kotlin.l.b.a.b.b.k)) {
        break label231;
      }
      i = 1;
      if (i == 0) {
        break label293;
      }
      localStringBuilder.append("V");
    }
    for (;;)
    {
      paramx = localStringBuilder.toString();
      kotlin.g.b.s.s(paramx, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(58241);
      return paramx;
      label231:
      localad = ((kotlin.l.b.a.b.b.a)localObject).kob();
      kotlin.g.b.s.checkNotNull(localad);
      if (h.v(localad))
      {
        localad = ((kotlin.l.b.a.b.b.a)localObject).kob();
        kotlin.g.b.s.checkNotNull(localad);
        if ((!bg.aw(localad)) && (!(localObject instanceof aq)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      label293:
      paramx = paramx.kob();
      kotlin.g.b.s.checkNotNull(paramx);
      kotlin.g.b.s.s(paramx, "returnType!!");
      a(localStringBuilder, paramx);
    }
  }
  
  private static final void a(StringBuilder paramStringBuilder, ad paramad)
  {
    AppMethodBeat.i(58245);
    paramStringBuilder.append(L(paramad));
    AppMethodBeat.o(58245);
  }
  
  public static final boolean b(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(58243);
    kotlin.g.b.s.u(parama, "f");
    if (!(parama instanceof kotlin.l.b.a.b.b.x))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    if ((!kotlin.g.b.s.p(((kotlin.l.b.a.b.b.x)parama).kok().PF(), "remove")) || (((kotlin.l.b.a.b.b.x)parama).kod().size() != 1) || (ac.r((kotlin.l.b.a.b.b.b)parama)))
    {
      AppMethodBeat.o(58243);
      return false;
    }
    Object localObject = ((kotlin.l.b.a.b.b.x)parama).koH().kod();
    kotlin.g.b.s.s(localObject, "f.original.valueParameters");
    localObject = ((bd)p.oO((List)localObject)).koG();
    kotlin.g.b.s.s(localObject, "f.original.valueParameters.single().type");
    localObject = L((ad)localObject);
    if ((localObject instanceof j.d))
    {
      localObject = (j.d)localObject;
      if (localObject != null) {
        break label162;
      }
    }
    label162:
    for (localObject = null;; localObject = ((j.d)localObject).aiWX)
    {
      if (localObject == kotlin.l.b.a.b.j.e.e.ajkh) {
        break label170;
      }
      AppMethodBeat.o(58243);
      return false;
      localObject = null;
      break;
    }
    label170:
    parama = kotlin.l.b.a.b.d.a.e.e((kotlin.l.b.a.b.b.x)parama);
    if (parama == null)
    {
      AppMethodBeat.o(58243);
      return false;
    }
    localObject = parama.koH().kod();
    kotlin.g.b.s.s(localObject, "overridden.original.valueParameters");
    localObject = ((bd)p.oO((List)localObject)).koG();
    kotlin.g.b.s.s(localObject, "overridden.original.valueParameters.single().type");
    localObject = L((ad)localObject);
    parama = parama.knp();
    kotlin.g.b.s.s(parama, "overridden.containingDeclaration");
    if ((kotlin.g.b.s.p(kotlin.l.b.a.b.j.d.a.q(parama), k.a.aiDu.kxR())) && ((localObject instanceof j.c)) && (kotlin.g.b.s.p(((j.c)localObject).aiWW, "java/lang/Object")))
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
    kotlin.g.b.s.u(parama, "<this>");
    v localv = v.aiXe;
    if (kotlin.l.b.a.b.j.d.m((kotlin.l.b.a.b.b.l)parama))
    {
      AppMethodBeat.o(58244);
      return null;
    }
    Object localObject = parama.knp();
    if ((localObject instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject = (kotlin.l.b.a.b.b.e)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    if (((kotlin.l.b.a.b.b.e)localObject).kok().ajeG)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    parama = parama.koc();
    if ((parama instanceof au)) {}
    for (parama = (au)parama; parama == null; parama = null)
    {
      AppMethodBeat.o(58244);
      return null;
    }
    parama = s.a(localv, (kotlin.l.b.a.b.b.e)localObject, a((kotlin.l.b.a.b.b.x)parama, false, false, 3));
    AppMethodBeat.o(58244);
    return parama;
  }
  
  public static final String t(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(191930);
    kotlin.g.b.s.u(parame, "<this>");
    Object localObject = kotlin.l.b.a.b.a.b.c.aiEX;
    localObject = kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)parame).kxR();
    kotlin.g.b.s.s(localObject, "fqNameSafe.toUnsafe()");
    localObject = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.d)localObject);
    if (localObject != null)
    {
      parame = kotlin.l.b.a.b.j.e.d.g((kotlin.l.b.a.b.f.b)localObject).kzr();
      kotlin.g.b.s.s(parame, "byClassId(it).internalName");
      AppMethodBeat.o(191930);
      return parame;
    }
    parame = c.s(parame);
    AppMethodBeat.o(191930);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.t
 * JD-Core Version:    0.7.0.1
 */