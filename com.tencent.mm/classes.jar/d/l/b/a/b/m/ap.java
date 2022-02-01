package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.i;
import d.l.b.a.b.b.l;
import d.l.b.a.b.j.d.a;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ap
{
  public static final ab c(as paramas)
  {
    AppMethodBeat.i(60816);
    k.h(paramas, "$this$starProjectionType");
    Object localObject1 = paramas.fxq();
    if (localObject1 == null)
    {
      paramas = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
      AppMethodBeat.o(60816);
      throw paramas;
    }
    localObject1 = ((i)localObject1).fxs();
    k.g(localObject1, "classDescriptor.typeConstructor");
    localObject1 = ((at)localObject1).getParameters();
    k.g(localObject1, "classDescriptor.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      k.g(localas, "it");
      ((Collection)localObject1).add(localas.fxs());
    }
    localObject1 = ba.d((ay)new a((List)localObject1));
    localObject2 = paramas.fwf();
    k.g(localObject2, "this.upperBounds");
    localObject2 = ((ba)localObject1).c((ab)j.iy((List)localObject2), bh.JYE);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramas = a.G((l)paramas).fxd();
      k.g(paramas, "builtIns.defaultBound");
      localObject1 = (ab)paramas;
    }
    AppMethodBeat.o(60816);
    return localObject1;
  }
  
  public static final class a
    extends au
  {
    a(List paramList) {}
    
    public final av d(at paramat)
    {
      AppMethodBeat.i(60815);
      k.h(paramat, "key");
      if (this.JYj.contains(paramat))
      {
        paramat = paramat.fxM();
        if (paramat == null)
        {
          paramat = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
          AppMethodBeat.o(60815);
          throw paramat;
        }
        paramat = bc.d((as)paramat);
        AppMethodBeat.o(60815);
        return paramat;
      }
      AppMethodBeat.o(60815);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ap
 * JD-Core Version:    0.7.0.1
 */