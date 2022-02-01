package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.u;
import kotlin.l.b.a.b.e.a.v;

public final class i
{
  private static final i TBJ;
  public static final a TBK;
  final List<a.u> iHg;
  
  static
  {
    AppMethodBeat.i(59086);
    TBK = new a((byte)0);
    TBJ = new i((List)v.SXr);
    AppMethodBeat.o(59086);
  }
  
  private i(List<a.u> paramList)
  {
    this.iHg = paramList;
  }
  
  public static final class a
  {
    public static i g(a.v paramv)
    {
      AppMethodBeat.i(59085);
      p.h(paramv, "table");
      if (paramv.TAr.size() == 0)
      {
        paramv = i.hIl();
        AppMethodBeat.o(59085);
        return paramv;
      }
      paramv = paramv.TAr;
      p.g(paramv, "table.requirementList");
      paramv = new i(paramv, (byte)0);
      AppMethodBeat.o(59085);
      return paramv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.i
 * JD-Core Version:    0.7.0.1
 */