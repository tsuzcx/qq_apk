package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.e.a.u;
import d.l.b.a.b.e.a.v;
import java.util.List;

public final class i
{
  private static final i Lyc;
  public static final a Lyd;
  final List<a.u> hqS;
  
  static
  {
    AppMethodBeat.i(59086);
    Lyd = new a((byte)0);
    Lyc = new i((List)v.KTF);
    AppMethodBeat.o(59086);
  }
  
  private i(List<a.u> paramList)
  {
    this.hqS = paramList;
  }
  
  public static final class a
  {
    public static i g(a.v paramv)
    {
      AppMethodBeat.i(59085);
      k.h(paramv, "table");
      if (paramv.LwM.size() == 0)
      {
        paramv = i.fYN();
        AppMethodBeat.o(59085);
        return paramv;
      }
      paramv = paramv.LwM;
      k.g(paramv, "table.requirementList");
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