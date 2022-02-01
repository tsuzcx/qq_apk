package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.j.g.k;
import kotlin.l.b.a.b.j.g.k.a;

public final class a
  extends o
{
  public static final a ajiE;
  
  static
  {
    AppMethodBeat.i(192177);
    ajiE = new a();
    AppMethodBeat.o(192177);
  }
  
  private static final void a(e parame, LinkedHashSet<e> paramLinkedHashSet, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(192174);
    Iterator localIterator = k.a.a((k)paramh, kotlin.l.b.a.b.j.g.d.ajkV, null, 2).iterator();
    label204:
    while (localIterator.hasNext())
    {
      Object localObject2 = (l)localIterator.next();
      if ((localObject2 instanceof e))
      {
        Object localObject1 = localObject2;
        if (((e)localObject2).kni())
        {
          localObject1 = ((e)localObject2).kok();
          s.s(localObject1, "descriptor.name");
          localObject2 = paramh.c((f)localObject1, (b)kotlin.l.b.a.b.c.a.d.aiNH);
          localObject1 = localObject2;
          if (!(localObject2 instanceof e)) {
            if ((localObject2 instanceof az)) {
              localObject1 = ((az)localObject2).kpn();
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label204;
          }
          if (d.b((e)localObject1, parame)) {
            paramLinkedHashSet.add(localObject1);
          }
          if (!paramBoolean) {
            break;
          }
          localObject1 = ((e)localObject1).kou();
          s.s(localObject1, "refinedDescriptor.unsubstitutedInnerClassesScope");
          a(parame, paramLinkedHashSet, (h)localObject1, paramBoolean);
          break;
          localObject1 = null;
          continue;
          localObject1 = (e)localObject1;
        }
      }
    }
    AppMethodBeat.o(192174);
  }
  
  public static Collection<e> x(e parame)
  {
    AppMethodBeat.i(192173);
    s.u(parame, "sealedClass");
    if (parame.knb() != kotlin.l.b.a.b.b.ab.aiGZ)
    {
      parame = (Collection)kotlin.a.ab.aivy;
      AppMethodBeat.o(192173);
      return parame;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject = parame.knp();
    if ((localObject instanceof ah)) {
      a(parame, localLinkedHashSet, ((ah)localObject).knP(), false);
    }
    localObject = parame.kou();
    s.s(localObject, "sealedClass.unsubstitutedInnerClassesScope");
    a(parame, localLinkedHashSet, (h)localObject, true);
    parame = (Collection)localLinkedHashSet;
    AppMethodBeat.o(192173);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a
 * JD-Core Version:    0.7.0.1
 */