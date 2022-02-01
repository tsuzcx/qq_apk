package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.u;
import kotlin.l.b.a.b.e.a.v;

public final class i
{
  private static final i abex;
  public static final a abey;
  final List<a.u> lxi;
  
  static
  {
    AppMethodBeat.i(59086);
    abey = new a((byte)0);
    abex = new i((List)v.aaAd);
    AppMethodBeat.o(59086);
  }
  
  private i(List<a.u> paramList)
  {
    this.lxi = paramList;
  }
  
  public static final class a
  {
    public static i g(a.v paramv)
    {
      AppMethodBeat.i(59085);
      p.k(paramv, "table");
      if (paramv.abdi.size() == 0)
      {
        paramv = i.iMF();
        AppMethodBeat.o(59085);
        return paramv;
      }
      paramv = paramv.abdi;
      p.j(paramv, "table.requirementList");
      paramv = new i(paramv, (byte)0);
      AppMethodBeat.o(59085);
      return paramv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.i
 * JD-Core Version:    0.7.0.1
 */