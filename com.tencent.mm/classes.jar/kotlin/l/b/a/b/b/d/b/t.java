package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.e.r;
import kotlin.l.b.a.b.d.a.n;

public abstract interface t
  extends r
{
  public abstract int getModifiers();
  
  public static final class a
  {
    public static boolean a(t paramt)
    {
      AppMethodBeat.i(57492);
      boolean bool = Modifier.isAbstract(paramt.getModifiers());
      AppMethodBeat.o(57492);
      return bool;
    }
    
    public static boolean b(t paramt)
    {
      AppMethodBeat.i(57493);
      boolean bool = Modifier.isStatic(paramt.getModifiers());
      AppMethodBeat.o(57493);
      return bool;
    }
    
    public static boolean c(t paramt)
    {
      AppMethodBeat.i(57494);
      boolean bool = Modifier.isFinal(paramt.getModifiers());
      AppMethodBeat.o(57494);
      return bool;
    }
    
    public static ba d(t paramt)
    {
      AppMethodBeat.i(57495);
      int i = paramt.getModifiers();
      if (Modifier.isPublic(i))
      {
        paramt = az.ThU;
        p.g(paramt, "Visibilities.PUBLIC");
        AppMethodBeat.o(57495);
        return paramt;
      }
      if (Modifier.isPrivate(i))
      {
        paramt = az.ThQ;
        p.g(paramt, "Visibilities.PRIVATE");
        AppMethodBeat.o(57495);
        return paramt;
      }
      if (Modifier.isProtected(i))
      {
        if (Modifier.isStatic(i)) {}
        for (paramt = n.Tpf;; paramt = n.Tpg)
        {
          p.g(paramt, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
          AppMethodBeat.o(57495);
          return paramt;
        }
      }
      paramt = n.Tpe;
      p.g(paramt, "JavaVisibilities.PACKAGE_VISIBILITY");
      AppMethodBeat.o(57495);
      return paramt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.t
 * JD-Core Version:    0.7.0.1
 */