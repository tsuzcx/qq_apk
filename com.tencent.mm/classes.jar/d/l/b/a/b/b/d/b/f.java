package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.d.a.e.d;
import d.l.b.a.b.f.b;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

public abstract interface f
  extends d
{
  public abstract AnnotatedElement fAz();
  
  public static final class a
  {
    public static c a(f paramf, b paramb)
    {
      AppMethodBeat.i(57419);
      k.h(paramb, "fqName");
      paramf = paramf.fAz();
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
    
    public static List<c> a(f paramf)
    {
      AppMethodBeat.i(57418);
      paramf = paramf.fAz();
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
      paramf = (List)v.Jgl;
      AppMethodBeat.o(57418);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.f
 * JD-Core Version:    0.7.0.1
 */