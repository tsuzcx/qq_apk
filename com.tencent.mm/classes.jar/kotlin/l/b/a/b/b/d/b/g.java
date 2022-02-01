package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;

public final class g
{
  public static final List<c> a(Annotation[] paramArrayOfAnnotation)
  {
    AppMethodBeat.i(57420);
    p.h(paramArrayOfAnnotation, "$this$getAnnotations");
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
  
  public static final c a(Annotation[] paramArrayOfAnnotation, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57421);
    p.h(paramArrayOfAnnotation, "$this$findAnnotation");
    p.h(paramb, "fqName");
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    Annotation localAnnotation;
    if (i < j)
    {
      localAnnotation = paramArrayOfAnnotation[i];
      if (!p.j(b.bB(kotlin.g.a.a(kotlin.g.a.a(localAnnotation))).hJd(), paramb)) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */