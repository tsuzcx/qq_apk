package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.f.b;

public abstract interface f
  extends d
{
  public abstract AnnotatedElement hCG();
  
  public static final class a
  {
    public static List<c> a(f paramf)
    {
      AppMethodBeat.i(57418);
      paramf = paramf.hCG();
      if (paramf != null)
      {
        paramf = paramf.getDeclaredAnnotations();
        if (paramf != null)
        {
          paramf = g.a(paramf);
          AppMethodBeat.o(57418);
          return paramf;
        }
      }
      paramf = (List)v.SXr;
      AppMethodBeat.o(57418);
      return paramf;
    }
    
    public static c a(f paramf, b paramb)
    {
      AppMethodBeat.i(57419);
      p.h(paramb, "fqName");
      paramf = paramf.hCG();
      if (paramf != null)
      {
        paramf = paramf.getDeclaredAnnotations();
        if (paramf != null)
        {
          paramf = g.a(paramf, paramb);
          AppMethodBeat.o(57419);
          return paramf;
        }
      }
      AppMethodBeat.o(57419);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.f
 * JD-Core Version:    0.7.0.1
 */