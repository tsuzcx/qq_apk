package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l.b.a.b.e.a.u;
import d.l.b.a.b.e.a.v;
import java.util.List;

public final class i
{
  private static final i NMf;
  public static final a NMg;
  final List<a.u> hMd;
  
  static
  {
    AppMethodBeat.i(59086);
    NMg = new a((byte)0);
    NMf = new i((List)v.NhH);
    AppMethodBeat.o(59086);
  }
  
  private i(List<a.u> paramList)
  {
    this.hMd = paramList;
  }
  
  public static final class a
  {
    public static i g(a.v paramv)
    {
      AppMethodBeat.i(59085);
      p.h(paramv, "table");
      if (paramv.NKP.size() == 0)
      {
        paramv = i.guO();
        AppMethodBeat.o(59085);
        return paramv;
      }
      paramv = paramv.NKP;
      p.g(paramv, "table.requirementList");
      paramv = new i(paramv, (byte)0);
      AppMethodBeat.o(59085);
      return paramv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.b.i
 * JD-Core Version:    0.7.0.1
 */