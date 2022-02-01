package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.at;

final class e
  implements b
{
  public static final e TQo;
  private static final String description = "second parameter must be of type KProperty<*> or its supertype";
  
  static
  {
    AppMethodBeat.i(61295);
    TQo = new e();
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
    Object localObject1 = (av)paramt.hAw().get(1);
    paramt = i.TeS;
    p.g(localObject1, "secondParameter");
    paramt = kotlin.l.b.a.b.j.d.a.F((l)localObject1);
    p.h(paramt, "module");
    Object localObject2 = kotlin.l.b.a.b.a.g.TcO.Ted;
    p.g(localObject2, "KotlinBuiltIns.FQ_NAMES.kProperty");
    paramt = s.b(paramt, (kotlin.l.b.a.b.f.a)localObject2);
    if (paramt == null) {}
    Object localObject3;
    for (paramt = null; paramt != null; paramt = (ab)ac.a((kotlin.l.b.a.b.b.a.g)localObject2, paramt, j.listOf(new ao((as)localObject3))))
    {
      localObject1 = ((av)localObject1).hBy();
      p.g(localObject1, "secondParameter.type");
      boolean bool = kotlin.l.b.a.b.m.d.a.c(paramt, kotlin.l.b.a.b.m.d.a.aD((ab)localObject1));
      AppMethodBeat.o(61294);
      return bool;
      localObject2 = kotlin.l.b.a.b.b.a.g.TiC;
      localObject2 = kotlin.l.b.a.b.b.a.g.a.hBP();
      localObject3 = paramt.hzz();
      p.g(localObject3, "kPropertyClass.typeConstructor");
      localObject3 = ((at)localObject3).getParameters();
      p.g(localObject3, "kPropertyClass.typeConstructor.parameters");
      localObject3 = j.kw((List)localObject3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.n.e
 * JD-Core Version:    0.7.0.1
 */