package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.aa;

public final class m
  extends r
  implements kotlin.l.b.a.b.d.a.e.k
{
  public final Constructor<?> aiNi;
  
  public m(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57478);
    this.aiNi = paramConstructor;
    AppMethodBeat.o(57478);
  }
  
  public final List<x> koa()
  {
    AppMethodBeat.i(57477);
    Object localObject = this.aiNi.getTypeParameters();
    s.s(localObject, "member.typeParameters");
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
    AppMethodBeat.o(57477);
    return localObject;
  }
  
  public final List<aa> kod()
  {
    AppMethodBeat.i(57476);
    Object localObject1 = this.aiNi.getGenericParameterTypes();
    s.s(localObject1, "types");
    if (localObject1.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = (List)ab.aivy;
      AppMethodBeat.o(57476);
      return localObject1;
    }
    Object localObject2 = this.aiNi.getDeclaringClass();
    if ((((Class)localObject2).getDeclaringClass() != null) && (!Modifier.isStatic(((Class)localObject2).getModifiers()))) {
      localObject1 = (Type[])kotlin.a.k.e((Object[])localObject1, 1, localObject1.length);
    }
    for (;;)
    {
      localObject2 = this.aiNi.getParameterAnnotations();
      if (((Object[])localObject2).length >= localObject1.length) {
        break;
      }
      localObject1 = new IllegalStateException(s.X("Illegal generic signature: ", this.aiNi));
      AppMethodBeat.o(57476);
      throw ((Throwable)localObject1);
    }
    if (((Object[])localObject2).length > localObject1.length)
    {
      s.s(localObject2, "annotations");
      localObject2 = (Annotation[][])kotlin.a.k.e((Object[])localObject2, ((Object[])localObject2).length - localObject1.length, ((Object[])localObject2).length);
    }
    for (;;)
    {
      s.s(localObject1, "realTypes");
      s.s(localObject2, "realAnnotations");
      localObject1 = a((Type[])localObject1, (Annotation[][])localObject2, this.aiNi.isVarArgs());
      AppMethodBeat.o(57476);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.m
 * JD-Core Version:    0.7.0.1
 */