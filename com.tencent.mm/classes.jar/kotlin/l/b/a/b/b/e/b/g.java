package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a;
import kotlin.g.b.s;

public final class g
{
  public static final List<c> a(Annotation[] paramArrayOfAnnotation)
  {
    AppMethodBeat.i(57420);
    s.u(paramArrayOfAnnotation, "<this>");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfAnnotation.length);
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new c(paramArrayOfAnnotation[i]));
      i += 1;
    }
    paramArrayOfAnnotation = (List)localCollection;
    AppMethodBeat.o(57420);
    return paramArrayOfAnnotation;
  }
  
  public static final c a(Annotation[] paramArrayOfAnnotation, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57421);
    s.u(paramArrayOfAnnotation, "<this>");
    s.u(paramc, "fqName");
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    Annotation localAnnotation;
    if (i < j)
    {
      localAnnotation = paramArrayOfAnnotation[i];
      if (!s.p(b.cM(a.b(a.a(localAnnotation))).kxQ(), paramc)) {}
    }
    for (paramArrayOfAnnotation = localAnnotation;; paramArrayOfAnnotation = null)
    {
      if (paramArrayOfAnnotation != null) {
        break label79;
      }
      AppMethodBeat.o(57421);
      return null;
      i += 1;
      break;
    }
    label79:
    paramArrayOfAnnotation = new c(paramArrayOfAnnotation);
    AppMethodBeat.o(57421);
    return paramArrayOfAnnotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.g
 * JD-Core Version:    0.7.0.1
 */