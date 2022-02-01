package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.c.a;

public class g
  implements Comparator<l>
{
  public static final g ajiW;
  private static final c ajiX;
  
  static
  {
    AppMethodBeat.i(59953);
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajiW = new g();
      c.a locala = c.ajgs;
      ajiX = c.a.bc(new b() {});
      AppMethodBeat.o(59953);
      return;
    }
  }
  
  public static final class a
    implements Comparator<l>
  {
    public static final a ajiY;
    
    static
    {
      AppMethodBeat.i(59951);
      ajiY = new a();
      AppMethodBeat.o(59951);
    }
    
    private static int E(l paraml)
    {
      AppMethodBeat.i(59947);
      if (d.x(paraml))
      {
        AppMethodBeat.o(59947);
        return 8;
      }
      if ((paraml instanceof k))
      {
        AppMethodBeat.o(59947);
        return 7;
      }
      if ((paraml instanceof ap))
      {
        if (((ap)paraml).knY() == null)
        {
          AppMethodBeat.o(59947);
          return 6;
        }
        AppMethodBeat.o(59947);
        return 5;
      }
      if ((paraml instanceof x))
      {
        if (((x)paraml).knY() == null)
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
      if ((paraml instanceof az))
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
      if ((d.x(paraml1)) && (d.x(paraml2)))
      {
        AppMethodBeat.o(59948);
        return Integer.valueOf(0);
      }
      i = paraml1.kok().v(paraml2.kok());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g
 * JD-Core Version:    0.7.0.1
 */