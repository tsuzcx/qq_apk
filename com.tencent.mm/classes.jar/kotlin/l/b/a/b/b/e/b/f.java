package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.d;

public abstract interface f
  extends d
{
  public abstract AnnotatedElement kqw();
  
  public static final class a
  {
    public static List<c> a(f paramf)
    {
      AppMethodBeat.i(57418);
      s.u(paramf, "this");
      paramf = paramf.kqw();
      if (paramf == null) {}
      for (paramf = null; paramf == null; paramf = paramf.getDeclaredAnnotations())
      {
        paramf = (List)ab.aivy;
        AppMethodBeat.o(57418);
        return paramf;
      }
      paramf = g.a(paramf);
      AppMethodBeat.o(57418);
      return paramf;
    }
    
    public static c a(f paramf, kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(57419);
      s.u(paramf, "this");
      s.u(paramc, "fqName");
      paramf = paramf.kqw();
      if (paramf == null)
      {
        AppMethodBeat.o(57419);
        return null;
      }
      paramf = paramf.getDeclaredAnnotations();
      if (paramf == null)
      {
        AppMethodBeat.o(57419);
        return null;
      }
      paramf = g.a(paramf, paramc);
      AppMethodBeat.o(57419);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.f
 * JD-Core Version:    0.7.0.1
 */