package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.i.c.a;
import kotlin.l.b.a.b.i.i;
import kotlin.x;

public class f
  implements Comparator<l>
{
  public static final f THL;
  private static final kotlin.l.b.a.b.i.c THM;
  
  static
  {
    AppMethodBeat.i(59953);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      THL = new f();
      c.a locala = kotlin.l.b.a.b.i.c.TFl;
      THM = c.a.T(new b() {});
      AppMethodBeat.o(59953);
      return;
    }
  }
  
  public static final class a
    implements Comparator<l>
  {
    public static final a THN;
    
    static
    {
      AppMethodBeat.i(59951);
      THN = new a();
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
        if (((ah)paraml).hAr() == null)
        {
          AppMethodBeat.o(59947);
          return 6;
        }
        AppMethodBeat.o(59947);
        return 5;
      }
      if ((paraml instanceof t))
      {
        if (((t)paraml).hAr() == null)
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
      i = paraml1.hAH().u(paraml2.hAH());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f
 * JD-Core Version:    0.7.0.1
 */