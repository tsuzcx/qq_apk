package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.d.a;
import kotlin.t;

public final class ap
{
  public static final ab c(as paramas)
  {
    AppMethodBeat.i(60816);
    p.h(paramas, "$this$starProjectionType");
    Object localObject1 = paramas.hzx();
    if (localObject1 == null)
    {
      paramas = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
      AppMethodBeat.o(60816);
      throw paramas;
    }
    localObject1 = ((i)localObject1).hzz();
    p.g(localObject1, "classDescriptor.typeConstructor");
    localObject1 = ((at)localObject1).getParameters();
    p.g(localObject1, "classDescriptor.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      p.g(localas, "it");
      ((Collection)localObject1).add(localas.hzz());
    }
    localObject1 = ba.d((ay)new a((List)localObject1));
    localObject2 = paramas.hyo();
    p.g(localObject2, "this.upperBounds");
    localObject2 = ((ba)localObject1).c((ab)j.ks((List)localObject2), bh.TOS);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramas = a.G((l)paramas).hzk();
      p.g(paramas, "builtIns.defaultBound");
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
      p.h(paramat, "key");
      if (this.TOx.contains(paramat))
      {
        paramat = paramat.hzS();
        if (paramat == null)
        {
          paramat = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ap
 * JD-Core Version:    0.7.0.1
 */