package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.a.i;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.t;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.ao;
import d.l.b.a.b.m.at;
import java.util.List;

final class e
  implements b
{
  public static final e NEn;
  private static final String description = "second parameter must be of type KProperty<*> or its supertype";
  
  static
  {
    AppMethodBeat.i(61295);
    NEn = new e();
    description = "second parameter must be of type KProperty<*> or its supertype";
    AppMethodBeat.o(61295);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(t paramt)
  {
    AppMethodBeat.i(61294);
    p.h(paramt, "functionDescriptor");
    Object localObject1 = (av)paramt.gis().get(1);
    paramt = i.MSf;
    p.g(localObject1, "secondParameter");
    paramt = d.l.b.a.b.j.d.a.F((l)localObject1);
    p.h(paramt, "module");
    Object localObject2 = d.l.b.a.b.a.g.MQb.MRq;
    p.g(localObject2, "KotlinBuiltIns.FQ_NAMES.kProperty");
    paramt = s.b(paramt, (d.l.b.a.b.f.a)localObject2);
    if (paramt == null) {}
    Object localObject3;
    for (paramt = null; paramt != null; paramt = (ab)ac.a((d.l.b.a.b.b.a.g)localObject2, paramt, j.listOf(new ao((as)localObject3))))
    {
      localObject1 = ((av)localObject1).gju();
      p.g(localObject1, "secondParameter.type");
      boolean bool = d.l.b.a.b.m.d.a.c(paramt, d.l.b.a.b.m.d.a.aE((ab)localObject1));
      AppMethodBeat.o(61294);
      return bool;
      localObject2 = d.l.b.a.b.b.a.g.MVP;
      localObject2 = d.l.b.a.b.b.a.g.a.gjL();
      localObject3 = paramt.ghu();
      p.g(localObject3, "kPropertyClass.typeConstructor");
      localObject3 = ((at)localObject3).getParameters();
      p.g(localObject3, "kPropertyClass.typeConstructor.parameters");
      localObject3 = j.jg((List)localObject3);
      p.g(localObject3, "kPropertyClass.typeConstructor.parameters.single()");
    }
    AppMethodBeat.o(61294);
    return false;
  }
  
  public final String i(t paramt)
  {
    AppMethodBeat.i(61296);
    p.h(paramt, "functionDescriptor");
    paramt = b.a.a(this, paramt);
    AppMethodBeat.o(61296);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.n.e
 * JD-Core Version:    0.7.0.1
 */