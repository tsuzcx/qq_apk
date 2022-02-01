package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.o.f;
import kotlin.l.b.a.b.o.f.b;

public final class l
{
  public static final <H> Collection<H> b(Collection<? extends H> paramCollection, b<? super H, ? extends a> paramb)
  {
    AppMethodBeat.i(60009);
    s.u(paramCollection, "<this>");
    s.u(paramb, "descriptorByHandle");
    if (paramCollection.size() <= 1)
    {
      AppMethodBeat.o(60009);
      return paramCollection;
    }
    paramCollection = new LinkedList(paramCollection);
    Object localObject1 = f.ajtJ;
    localObject1 = f.b.kBe();
    int i;
    if (!((Collection)paramCollection).isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Object localObject3 = p.oK((List)paramCollection);
        Object localObject2 = f.ajtJ;
        localObject2 = f.b.kBe();
        Object localObject4 = j.a(localObject3, (Collection)paramCollection, paramb, (b)new a((f)localObject2));
        s.s(localObject4, "val conflictedHandles = …nflictedHandles.add(it) }");
        if ((((Collection)localObject4).size() == 1) && (((f)localObject2).isEmpty()))
        {
          localObject2 = p.i((Iterable)localObject4);
          s.s(localObject2, "overridableGroup.single()");
          ((f)localObject1).add(localObject2);
          break;
          i = 0;
          continue;
        }
        localObject3 = j.a((Collection)localObject4, paramb);
        s.s(localObject3, "selectMostSpecificMember…roup, descriptorByHandle)");
        a locala = (a)paramb.invoke(localObject3);
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          s.s(localObject5, "it");
          if (!j.e(locala, (a)paramb.invoke(localObject5))) {
            ((Collection)localObject2).add(localObject5);
          }
        }
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((f)localObject1).addAll((Collection)localObject2);
          }
          ((f)localObject1).add(localObject3);
          break;
        }
      }
    }
    paramCollection = (Collection)localObject1;
    AppMethodBeat.o(60009);
    return paramCollection;
  }
  
  static final class a
    extends u
    implements b<H, ah>
  {
    a(f<H> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.j.l
 * JD-Core Version:    0.7.0.1
 */