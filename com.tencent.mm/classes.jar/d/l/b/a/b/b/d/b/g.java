package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
{
  public static final c a(Annotation[] paramArrayOfAnnotation, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57421);
    k.h(paramArrayOfAnnotation, "$this$findAnnotation");
    k.h(paramb, "fqName");
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    Annotation localAnnotation;
    if (i < j)
    {
      localAnnotation = paramArrayOfAnnotation[i];
      if (!k.g(b.bz(d.g.a.a(d.g.a.a(localAnnotation))).fZF(), paramb)) {}
    }
    for (paramArrayOfAnnotation = localAnnotation;; paramArrayOfAnnotation = null)
    {
      if (paramArrayOfAnnotation == null) {
        break label88;
      }
      paramArrayOfAnnotation = new c(paramArrayOfAnnotation);
      AppMethodBeat.o(57421);
      return paramArrayOfAnnotation;
      i += 1;
      break;
    }
    label88:
    AppMethodBeat.o(57421);
    return null;
  }
  
  public static final List<c> a(Annotation[] paramArrayOfAnnotation)
  {
    AppMethodBeat.i(57420);
    k.h(paramArrayOfAnnotation, "$this$getAnnotations");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */