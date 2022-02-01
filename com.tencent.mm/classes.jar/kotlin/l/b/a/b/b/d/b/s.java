package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.d.a.e.y;

public final class s
  extends r
  implements q
{
  public final Method Tns;
  
  public s(Method paramMethod)
  {
    AppMethodBeat.i(57490);
    this.Tns = paramMethod;
    AppMethodBeat.o(57490);
  }
  
  public final List<x> hAt()
  {
    AppMethodBeat.i(57489);
    Object localObject = this.Tns.getTypeParameters();
    p.g(localObject, "member.typeParameters");
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x(localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(57489);
    return localObject;
  }
  
  public final List<y> hAw()
  {
    AppMethodBeat.i(57486);
    Object localObject = this.Tns.getGenericParameterTypes();
    p.g(localObject, "member.genericParameterTypes");
    Annotation[][] arrayOfAnnotation = this.Tns.getParameterAnnotations();
    p.g(arrayOfAnnotation, "member.parameterAnnotations");
    localObject = a((Type[])localObject, arrayOfAnnotation, this.Tns.isVarArgs());
    AppMethodBeat.o(57486);
    return localObject;
  }
  
  public final b hDe()
  {
    Object localObject1 = null;
    AppMethodBeat.i(57488);
    Object localObject2 = this.Tns.getDefaultValue();
    if (localObject2 != null)
    {
      localObject1 = d.Tnd;
      localObject1 = d.a.a(localObject2, null);
    }
    localObject1 = (b)localObject1;
    AppMethodBeat.o(57488);
    return localObject1;
  }
  
  public final boolean hDf()
  {
    AppMethodBeat.i(57491);
    if (hDe() != null)
    {
      AppMethodBeat.o(57491);
      return true;
    }
    AppMethodBeat.o(57491);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.s
 * JD-Core Version:    0.7.0.1
 */