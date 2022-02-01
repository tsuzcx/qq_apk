package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bh.e;
import kotlin.l.b.a.b.b.bh.h;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.b.d.a.a;
import kotlin.l.b.a.b.b.d.a.b;
import kotlin.l.b.a.b.b.d.a.c;
import kotlin.l.b.a.b.d.a.e.r;

public abstract interface t
  extends r
{
  public abstract int kqC();
  
  public static final class a
  {
    public static boolean a(t paramt)
    {
      AppMethodBeat.i(57492);
      s.u(paramt, "this");
      boolean bool = Modifier.isAbstract(paramt.kqC());
      AppMethodBeat.o(57492);
      return bool;
    }
    
    public static boolean b(t paramt)
    {
      AppMethodBeat.i(57493);
      s.u(paramt, "this");
      boolean bool = Modifier.isStatic(paramt.kqC());
      AppMethodBeat.o(57493);
      return bool;
    }
    
    public static boolean c(t paramt)
    {
      AppMethodBeat.i(57494);
      s.u(paramt, "this");
      boolean bool = Modifier.isFinal(paramt.kqC());
      AppMethodBeat.o(57494);
      return bool;
    }
    
    public static bi d(t paramt)
    {
      AppMethodBeat.i(57495);
      s.u(paramt, "this");
      int i = paramt.kqC();
      if (Modifier.isPublic(i))
      {
        paramt = (bi)bh.h.aiHJ;
        AppMethodBeat.o(57495);
        return paramt;
      }
      if (Modifier.isPrivate(i))
      {
        paramt = (bi)bh.e.aiHG;
        AppMethodBeat.o(57495);
        return paramt;
      }
      if (Modifier.isProtected(i))
      {
        if (Modifier.isStatic(i))
        {
          paramt = (bi)a.c.aiMt;
          AppMethodBeat.o(57495);
          return paramt;
        }
        paramt = (bi)a.b.aiMs;
        AppMethodBeat.o(57495);
        return paramt;
      }
      paramt = (bi)a.a.aiMr;
      AppMethodBeat.o(57495);
      return paramt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.t
 * JD-Core Version:    0.7.0.1
 */