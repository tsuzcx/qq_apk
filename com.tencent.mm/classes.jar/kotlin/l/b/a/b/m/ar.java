package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.j.d.a;

public final class ar
{
  private static final ad a(List<? extends ax> paramList, List<? extends ad> paramList1, h paramh)
  {
    AppMethodBeat.i(191565);
    paramList1 = be.d((bc)new a(paramList)).c((ad)p.oK(paramList1), bl.ajqO);
    paramList = paramList1;
    if (paramList1 == null) {
      paramList = (ad)paramh.kmQ();
    }
    s.s(paramList, "typeParameters: List<Typ… ?: builtIns.defaultBound");
    AppMethodBeat.o(191565);
    return paramList;
  }
  
  public static final ad b(ba paramba)
  {
    AppMethodBeat.i(60816);
    s.u(paramba, "<this>");
    Object localObject1 = paramba.knp();
    s.s(localObject1, "this.containingDeclaration");
    Object localObject2;
    ax localax;
    if ((localObject1 instanceof i))
    {
      localObject1 = ((i)localObject1).kmZ().klq();
      s.s(localObject1, "descriptor.typeConstructor.parameters");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localax = ((ba)((Iterator)localObject2).next()).kmZ();
        s.s(localax, "it.typeConstructor");
        ((Collection)localObject1).add(localax);
      }
      localObject1 = (List)localObject1;
      localObject2 = paramba.klF();
      s.s(localObject2, "upperBounds");
      paramba = a((List)localObject1, (List)localObject2, a.G((l)paramba));
      AppMethodBeat.o(60816);
      return paramba;
    }
    if ((localObject1 instanceof x))
    {
      localObject1 = ((x)localObject1).koa();
      s.s(localObject1, "descriptor.typeParameters");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localax = ((ba)((Iterator)localObject2).next()).kmZ();
        s.s(localax, "it.typeConstructor");
        ((Collection)localObject1).add(localax);
      }
      localObject1 = (List)localObject1;
      localObject2 = paramba.klF();
      s.s(localObject2, "upperBounds");
      paramba = a((List)localObject1, (List)localObject2, a.G((l)paramba));
      AppMethodBeat.o(60816);
      return paramba;
    }
    paramba = new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    AppMethodBeat.o(60816);
    throw paramba;
  }
  
  public static final class a
    extends ay
  {
    a(List<? extends ax> paramList) {}
    
    public final az c(ax paramax)
    {
      AppMethodBeat.i(191650);
      s.u(paramax, "key");
      if (this.ajqi.contains(paramax))
      {
        paramax = paramax.knA();
        if (paramax == null)
        {
          paramax = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
          AppMethodBeat.o(191650);
          throw paramax;
        }
        paramax = bg.c((ba)paramax);
        AppMethodBeat.o(191650);
        return paramax;
      }
      AppMethodBeat.o(191650);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ar
 * JD-Core Version:    0.7.0.1
 */