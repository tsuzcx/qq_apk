package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.d.a.e.q;

public final class s
  extends r
  implements q
{
  public final Method aiNl;
  
  public s(Method paramMethod)
  {
    AppMethodBeat.i(57490);
    this.aiNl = paramMethod;
    AppMethodBeat.o(57490);
  }
  
  public final List<x> koa()
  {
    AppMethodBeat.i(57489);
    Object localObject = this.aiNl.getTypeParameters();
    kotlin.g.b.s.s(localObject, "member.typeParameters");
    localObject = (Object[])localObject;
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x((TypeVariable)localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(57489);
    return localObject;
  }
  
  public final List<aa> kod()
  {
    AppMethodBeat.i(57486);
    Object localObject = this.aiNl.getGenericParameterTypes();
    kotlin.g.b.s.s(localObject, "member.genericParameterTypes");
    Annotation[][] arrayOfAnnotation = this.aiNl.getParameterAnnotations();
    kotlin.g.b.s.s(arrayOfAnnotation, "member.parameterAnnotations");
    localObject = a((Type[])localObject, (Annotation[][])arrayOfAnnotation, this.aiNl.isVarArgs());
    AppMethodBeat.o(57486);
    return localObject;
  }
  
  public final b krf()
  {
    Object localObject1 = null;
    AppMethodBeat.i(57488);
    Object localObject2 = this.aiNl.getDefaultValue();
    if (localObject2 == null) {}
    for (;;)
    {
      localObject1 = (b)localObject1;
      AppMethodBeat.o(57488);
      return localObject1;
      localObject1 = d.aiMU;
      localObject1 = d.a.a(localObject2, null);
    }
  }
  
  public final boolean krg()
  {
    AppMethodBeat.i(57491);
    kotlin.g.b.s.u(this, "this");
    if (krf() != null)
    {
      AppMethodBeat.o(57491);
      return true;
    }
    AppMethodBeat.o(57491);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.s
 * JD-Core Version:    0.7.0.1
 */