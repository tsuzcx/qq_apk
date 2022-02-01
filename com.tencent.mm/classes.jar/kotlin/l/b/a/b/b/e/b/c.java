package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.f;

public final class c
  extends n
  implements kotlin.l.b.a.b.d.a.e.a
{
  public final Annotation aiMw;
  
  public c(Annotation paramAnnotation)
  {
    AppMethodBeat.i(57414);
    this.aiMw = paramAnnotation;
    AppMethodBeat.o(57414);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57411);
    if (((paramObject instanceof c)) && (s.p(this.aiMw, ((c)paramObject).aiMw)))
    {
      AppMethodBeat.o(57411);
      return true;
    }
    AppMethodBeat.o(57411);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57412);
    int i = this.aiMw.hashCode();
    AppMethodBeat.o(57412);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.b kmb()
  {
    AppMethodBeat.i(57409);
    kotlin.l.b.a.b.f.b localb = b.cM(kotlin.g.a.b(kotlin.g.a.a(this.aiMw)));
    AppMethodBeat.o(57409);
    return localb;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.b> kqr()
  {
    AppMethodBeat.i(57408);
    Object localObject1 = kotlin.g.a.b(kotlin.g.a.a(this.aiMw)).getDeclaredMethods();
    s.s(localObject1, "annotation.annotationClass.java.declaredMethods");
    localObject1 = (Object[])localObject1;
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = (Method)localObject1[i];
      Object localObject2 = d.aiMU;
      localObject2 = localMethod.invoke(this.aiMw, new Object[0]);
      s.s(localObject2, "method.invoke(annotation)");
      localCollection.add(d.a.a(localObject2, f.bJe(localMethod.getName())));
      i += 1;
    }
    localObject1 = (Collection)localCollection;
    AppMethodBeat.o(57408);
    return localObject1;
  }
  
  public final boolean kqs()
  {
    AppMethodBeat.i(191852);
    s.u(this, "this");
    AppMethodBeat.o(191852);
    return false;
  }
  
  public final boolean kqt()
  {
    AppMethodBeat.i(191854);
    s.u(this, "this");
    AppMethodBeat.o(191854);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57413);
    String str = getClass().getName() + ": " + this.aiMw;
    AppMethodBeat.o(57413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.c
 * JD-Core Version:    0.7.0.1
 */