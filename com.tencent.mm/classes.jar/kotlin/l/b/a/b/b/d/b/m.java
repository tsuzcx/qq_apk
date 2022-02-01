package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.k;
import kotlin.l.b.a.b.d.a.e.y;

public final class m
  extends r
  implements k
{
  public final Constructor<?> aaQj;
  
  public m(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(57478);
    this.aaQj = paramConstructor;
    AppMethodBeat.o(57478);
  }
  
  public final List<x> iEG()
  {
    AppMethodBeat.i(57477);
    Object localObject = this.aaQj.getTypeParameters();
    p.j(localObject, "member.typeParameters");
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
  
  public final List<y> iEJ()
  {
    AppMethodBeat.i(57476);
    Object localObject1 = this.aaQj.getGenericParameterTypes();
    p.j(localObject1, "types");
    if (localObject1.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = (List)v.aaAd;
      AppMethodBeat.o(57476);
      return localObject1;
    }
    Object localObject2 = this.aaQj.getDeclaringClass();
    p.j(localObject2, "klass");
    if ((((Class)localObject2).getDeclaringClass() != null) && (!Modifier.isStatic(((Class)localObject2).getModifiers()))) {
      localObject1 = (Type[])e.a((Object[])localObject1, 1, localObject1.length);
    }
    for (;;)
    {
      localObject2 = this.aaQj.getParameterAnnotations();
      if (((Object[])localObject2).length >= localObject1.length) {
        break;
      }
      localObject1 = (Throwable)new IllegalStateException("Illegal generic signature: " + this.aaQj);
      AppMethodBeat.o(57476);
      throw ((Throwable)localObject1);
    }
    if (((Object[])localObject2).length > localObject1.length)
    {
      p.j(localObject2, "annotations");
      localObject2 = (Annotation[][])e.a((Object[])localObject2, ((Object[])localObject2).length - localObject1.length, ((Object[])localObject2).length);
    }
    for (;;)
    {
      p.j(localObject1, "realTypes");
      p.j(localObject2, "realAnnotations");
      localObject1 = a((Type[])localObject1, (Annotation[][])localObject2, this.aaQj.isVarArgs());
      AppMethodBeat.o(57476);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.m
 * JD-Core Version:    0.7.0.1
 */