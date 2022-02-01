package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.e;
import kotlin.l.b.a.b.l.g;

public final class z<T>
  implements y<T>
{
  final Map<c, T> aiQc;
  private final e aiQd;
  private final g<c, T> aiQe;
  
  public z(Map<c, ? extends T> paramMap)
  {
    AppMethodBeat.i(192000);
    this.aiQc = paramMap;
    this.aiQd = new e("Java nullability annotation states");
    paramMap = this.aiQd.be((b)new a(this));
    s.s(paramMap, "storageManager.createMem…cificFqname(states)\n    }");
    this.aiQe = paramMap;
    AppMethodBeat.o(192000);
  }
  
  public final T p(c paramc)
  {
    AppMethodBeat.i(192005);
    s.u(paramc, "fqName");
    paramc = this.aiQe.invoke(paramc);
    AppMethodBeat.o(192005);
    return paramc;
  }
  
  static final class a
    extends u
    implements b<c, T>
  {
    a(z<T> paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.z
 * JD-Core Version:    0.7.0.1
 */