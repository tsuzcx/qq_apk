package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.a.g.a;
import d.l.b.a.b.m.at;
import java.util.Map;

final class i$3
  implements g.a
{
  i$3(i parami, Map paramMap) {}
  
  public final boolean a(at paramat1, at paramat2)
  {
    AppMethodBeat.i(59957);
    if (paramat1 == null) {
      ajm(0);
    }
    if (paramat2 == null) {
      ajm(1);
    }
    if (i.a(this.NvS).a(paramat1, paramat2))
    {
      AppMethodBeat.o(59957);
      return true;
    }
    at localat1 = (at)this.NvR.get(paramat1);
    at localat2 = (at)this.NvR.get(paramat2);
    if (((localat1 != null) && (localat1.equals(paramat2))) || ((localat2 != null) && (localat2.equals(paramat1))))
    {
      AppMethodBeat.o(59957);
      return true;
    }
    AppMethodBeat.o(59957);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.i.3
 * JD-Core Version:    0.7.0.1
 */