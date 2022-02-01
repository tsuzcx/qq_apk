package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.v;
import d.l.b.a.b.d.a.e.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class m
  extends r
  implements d.l.b.a.b.d.a.e.k
{
  public final Constructor<?> Jwm;
  
  public m(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57478);
    this.Jwm = paramConstructor;
    AppMethodBeat.o(57478);
  }
  
  public final List<x> fyn()
  {
    AppMethodBeat.i(57477);
    Object localObject = this.Jwm.getTypeParameters();
    d.g.b.k.g(localObject, "member.typeParameters");
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x(localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(57477);
    return localObject;
  }
  
  public final List<y> fyq()
  {
    AppMethodBeat.i(57476);
    Object localObject1 = this.Jwm.getGenericParameterTypes();
    d.g.b.k.g(localObject1, "types");
    if (localObject1.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = (List)v.Jgl;
      AppMethodBeat.o(57476);
      return localObject1;
    }
    Object localObject2 = this.Jwm.getDeclaringClass();
    d.g.b.k.g(localObject2, "klass");
    if ((((Class)localObject2).getDeclaringClass() != null) && (!Modifier.isStatic(((Class)localObject2).getModifiers()))) {
      localObject1 = (Type[])e.copyOfRange((Object[])localObject1, 1, localObject1.length);
    }
    for (;;)
    {
      localObject2 = this.Jwm.getParameterAnnotations();
      if (((Object[])localObject2).length >= localObject1.length) {
        break;
      }
      localObject1 = (Throwable)new IllegalStateException("Illegal generic signature: " + this.Jwm);
      AppMethodBeat.o(57476);
      throw ((Throwable)localObject1);
    }
    if (((Object[])localObject2).length > localObject1.length)
    {
      d.g.b.k.g(localObject2, "annotations");
      localObject2 = (Annotation[][])e.copyOfRange((Object[])localObject2, ((Object[])localObject2).length - localObject1.length, ((Object[])localObject2).length);
    }
    for (;;)
    {
      d.g.b.k.g(localObject1, "realTypes");
      d.g.b.k.g(localObject2, "realAnnotations");
      localObject1 = a((Type[])localObject1, (Annotation[][])localObject2, this.Jwm.isVarArgs());
      AppMethodBeat.o(57476);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.m
 * JD-Core Version:    0.7.0.1
 */