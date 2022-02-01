package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.ap;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.t;

public final class d
{
  private static final b aaWl;
  
  static
  {
    AppMethodBeat.i(57981);
    aaWl = new b("java.lang.Class");
    AppMethodBeat.o(57981);
  }
  
  public static final ab a(as paramas1, as paramas2, kotlin.g.a.a<? extends ab> parama)
  {
    AppMethodBeat.i(57979);
    p.k(paramas1, "$this$getErasedUpperBound");
    p.k(parama, "defaultValue");
    if (paramas1 == paramas2)
    {
      paramas1 = (ab)parama.invoke();
      AppMethodBeat.o(57979);
      return paramas1;
    }
    Object localObject = paramas1.iCz();
    p.j(localObject, "upperBounds");
    localObject = (ab)j.lo((List)localObject);
    if ((((ab)localObject).iOU().iEf() instanceof e))
    {
      p.j(localObject, "firstUpperBound");
      paramas1 = kotlin.l.b.a.b.m.d.a.aO((ab)localObject);
      AppMethodBeat.o(57979);
      return paramas1;
    }
    if (paramas2 == null) {}
    for (;;)
    {
      paramas2 = ((ab)localObject).iOU().iEf();
      if (paramas2 == null)
      {
        paramas1 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        AppMethodBeat.o(57979);
        throw paramas1;
      }
      for (paramas2 = (as)paramas2; (p.h(paramas2, paramas1) ^ true); paramas2 = (as)paramas2)
      {
        paramas2 = paramas2.iCz();
        p.j(paramas2, "current.upperBounds");
        paramas2 = (ab)j.lo(paramas2);
        if ((paramas2.iOU().iEf() instanceof e))
        {
          p.j(paramas2, "nextUpperBound");
          paramas1 = kotlin.l.b.a.b.m.d.a.aO(paramas2);
          AppMethodBeat.o(57979);
          return paramas1;
        }
        paramas2 = paramas2.iOU().iEf();
        if (paramas2 == null)
        {
          paramas1 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
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
    p.k(paramas, "typeParameter");
    p.k(parama, "attr");
    if (parama.aaVV == l.aaTo)
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
    implements kotlin.g.a.a<aj>
  {
    a(as paramas)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */