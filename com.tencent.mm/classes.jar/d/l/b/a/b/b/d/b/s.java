package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.e.b;
import d.l.b.a.b.d.a.e.q;
import d.l.b.a.b.d.a.e.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class s
  extends r
  implements q
{
  public final Method NaE;
  
  public s(Method paramMethod)
  {
    AppMethodBeat.i(57490);
    this.NaE = paramMethod;
    AppMethodBeat.o(57490);
  }
  
  public final List<x> gip()
  {
    AppMethodBeat.i(57489);
    Object localObject = this.NaE.getTypeParameters();
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
  
  public final List<y> gis()
  {
    AppMethodBeat.i(57486);
    Object localObject = this.NaE.getGenericParameterTypes();
    p.g(localObject, "member.genericParameterTypes");
    Annotation[][] arrayOfAnnotation = this.NaE.getParameterAnnotations();
    p.g(arrayOfAnnotation, "member.parameterAnnotations");
    localObject = a((Type[])localObject, arrayOfAnnotation, this.NaE.isVarArgs());
    AppMethodBeat.o(57486);
    return localObject;
  }
  
  public final b gla()
  {
    Object localObject1 = null;
    AppMethodBeat.i(57488);
    Object localObject2 = this.NaE.getDefaultValue();
    if (localObject2 != null)
    {
      localObject1 = d.Nap;
      localObject1 = d.a.a(localObject2, null);
    }
    localObject1 = (b)localObject1;
    AppMethodBeat.o(57488);
    return localObject1;
  }
  
  public final boolean glb()
  {
    AppMethodBeat.i(57491);
    if (gla() != null)
    {
      AppMethodBeat.o(57491);
      return true;
    }
    AppMethodBeat.o(57491);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.s
 * JD-Core Version:    0.7.0.1
 */