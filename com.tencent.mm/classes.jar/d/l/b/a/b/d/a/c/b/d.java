package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.a.l;
import d.l.b.a.b.f.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ao;
import d.l.b.a.b.m.ap;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.v;
import java.util.List;

public final class d
{
  private static final b NgF;
  
  static
  {
    AppMethodBeat.i(57981);
    NgF = new b("java.lang.Class");
    AppMethodBeat.o(57981);
  }
  
  public static final ab a(as paramas1, as paramas2, d.g.a.a<? extends ab> parama)
  {
    AppMethodBeat.i(57979);
    p.h(paramas1, "$this$getErasedUpperBound");
    p.h(parama, "defaultValue");
    if (paramas1 == paramas2)
    {
      paramas1 = (ab)parama.invoke();
      AppMethodBeat.o(57979);
      return paramas1;
    }
    Object localObject = paramas1.ggj();
    p.g(localObject, "upperBounds");
    localObject = (ab)j.jc((List)localObject);
    if ((((ab)localObject).gsZ().ghO() instanceof e))
    {
      p.g(localObject, "firstUpperBound");
      paramas1 = d.l.b.a.b.m.d.a.aP((ab)localObject);
      AppMethodBeat.o(57979);
      return paramas1;
    }
    if (paramas2 == null) {}
    for (;;)
    {
      paramas2 = ((ab)localObject).gsZ().ghO();
      if (paramas2 == null)
      {
        paramas1 = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        AppMethodBeat.o(57979);
        throw paramas1;
      }
      for (paramas2 = (as)paramas2; (p.i(paramas2, paramas1) ^ true); paramas2 = (as)paramas2)
      {
        paramas2 = paramas2.ggj();
        p.g(paramas2, "current.upperBounds");
        paramas2 = (ab)j.jc(paramas2);
        if ((paramas2.gsZ().ghO() instanceof e))
        {
          p.g(paramas2, "nextUpperBound");
          paramas1 = d.l.b.a.b.m.d.a.aP(paramas2);
          AppMethodBeat.o(57979);
          return paramas1;
        }
        paramas2 = paramas2.gsZ().ghO();
        if (paramas2 == null)
        {
          paramas1 = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
          AppMethodBeat.o(57979);
          throw paramas1;
        }
      }
      paramas1 = (ab)parama.invoke();
      AppMethodBeat.o(57979);
      return paramas1;
      paramas1 = paramas2;
    }
  }
  
  public static final av a(as paramas, a parama)
  {
    AppMethodBeat.i(57977);
    p.h(paramas, "typeParameter");
    p.h(parama, "attr");
    if (parama.Ngp == l.NdH)
    {
      paramas = (av)new ax(ap.c(paramas));
      AppMethodBeat.o(57977);
      return paramas;
    }
    paramas = (av)new ao(paramas);
    AppMethodBeat.o(57977);
    return paramas;
  }
  
  static final class a
    extends q
    implements d.g.a.a<aj>
  {
    a(as paramas)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */