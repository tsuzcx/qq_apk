package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.u;
import kotlin.l.b.a.b.e.a.v;

public final class i
{
  public static final a ajdj;
  private static final i ajdk;
  final List<a.u> ooG;
  
  static
  {
    AppMethodBeat.i(59086);
    ajdj = new a((byte)0);
    ajdk = new i((List)ab.aivy);
    AppMethodBeat.o(59086);
  }
  
  private i(List<a.u> paramList)
  {
    this.ooG = paramList;
  }
  
  public static final class a
  {
    public static i g(a.v paramv)
    {
      AppMethodBeat.i(59085);
      s.u(paramv, "table");
      if (paramv.ajbJ.size() == 0)
      {
        paramv = i.kwY();
        AppMethodBeat.o(59085);
        return paramv;
      }
      paramv = paramv.ajbJ;
      s.s(paramv, "table.requirementList");
      paramv = new i(paramv, (byte)0);
      AppMethodBeat.o(59085);
      return paramv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.i
 * JD-Core Version:    0.7.0.1
 */