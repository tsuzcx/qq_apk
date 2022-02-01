package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.f;

public final class c
  extends n
  implements kotlin.l.b.a.b.d.a.e.a
{
  public final Annotation aaPA;
  
  public c(Annotation paramAnnotation)
  {
    AppMethodBeat.i(57414);
    this.aaPA = paramAnnotation;
    AppMethodBeat.o(57414);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57411);
    if (((paramObject instanceof c)) && (p.h(this.aaPA, ((c)paramObject).aaPA)))
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
    int i = this.aaPA.hashCode();
    AppMethodBeat.o(57412);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.a iCJ()
  {
    AppMethodBeat.i(57409);
    kotlin.l.b.a.b.f.a locala = b.ca(kotlin.g.a.a(kotlin.g.a.a(this.aaPA)));
    AppMethodBeat.o(57409);
    return locala;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.b> iGU()
  {
    AppMethodBeat.i(57408);
    Object localObject1 = kotlin.g.a.a(kotlin.g.a.a(this.aaPA)).getDeclaredMethods();
    p.j(localObject1, "annotation.annotationClass.java.declaredMethods");
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      Object localObject3 = d.aaPX;
      localObject3 = localObject2.invoke(this.aaPA, new Object[0]);
      p.j(localObject3, "method.invoke(annotation)");
      p.j(localObject2, "method");
      localCollection.add(d.a.a(localObject3, f.bHb(localObject2.getName())));
      i += 1;
    }
    localObject1 = (Collection)localCollection;
    AppMethodBeat.o(57408);
    return localObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57413);
    String str = getClass().getName() + ": " + this.aaPA;
    AppMethodBeat.o(57413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */