package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.k;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.i.c.a;
import d.l.b.a.b.i.i;
import d.z;
import java.util.Comparator;

public class f
  implements Comparator<l>
{
  public static final f NvJ;
  private static final d.l.b.a.b.i.c NvK;
  
  static
  {
    AppMethodBeat.i(59953);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NvJ = new f();
      c.a locala = d.l.b.a.b.i.c.Nth;
      NvK = c.a.H(new b() {});
      AppMethodBeat.o(59953);
      return;
    }
  }
  
  public static final class a
    implements Comparator<l>
  {
    public static final a NvL;
    
    static
    {
      AppMethodBeat.i(59951);
      NvL = new a();
      AppMethodBeat.o(59951);
    }
    
    private static int E(l paraml)
    {
      AppMethodBeat.i(59947);
      if (c.x(paraml))
      {
        AppMethodBeat.o(59947);
        return 8;
      }
      if ((paraml instanceof k))
      {
        AppMethodBeat.o(59947);
        return 7;
      }
      if ((paraml instanceof ah))
      {
        if (((ah)paraml).gin() == null)
        {
          AppMethodBeat.o(59947);
          return 6;
        }
        AppMethodBeat.o(59947);
        return 5;
      }
      if ((paraml instanceof t))
      {
        if (((t)paraml).gin() == null)
        {
          AppMethodBeat.o(59947);
          return 4;
        }
        AppMethodBeat.o(59947);
        return 3;
      }
      if ((paraml instanceof e))
      {
        AppMethodBeat.o(59947);
        return 2;
      }
      if ((paraml instanceof ar))
      {
        AppMethodBeat.o(59947);
        return 1;
      }
      AppMethodBeat.o(59947);
      return 0;
    }
    
    private static Integer e(l paraml1, l paraml2)
    {
      AppMethodBeat.i(59948);
      int i = E(paraml2) - E(paraml1);
      if (i != 0)
      {
        AppMethodBeat.o(59948);
        return Integer.valueOf(i);
      }
      if ((c.x(paraml1)) && (c.x(paraml2)))
      {
        AppMethodBeat.o(59948);
        return Integer.valueOf(0);
      }
      i = paraml1.giD().u(paraml2.giD());
      if (i != 0)
      {
        AppMethodBeat.o(59948);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(59948);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f
 * JD-Core Version:    0.7.0.1
 */