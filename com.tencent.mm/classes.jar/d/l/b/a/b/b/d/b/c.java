package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

public final class c
  extends n
  implements d.l.b.a.b.d.a.e.a
{
  public final Annotation LiW;
  
  public c(Annotation paramAnnotation)
  {
    AppMethodBeat.i(57414);
    this.LiW = paramAnnotation;
    AppMethodBeat.o(57414);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57411);
    if (((paramObject instanceof c)) && (k.g(this.LiW, ((c)paramObject).LiW)))
    {
      AppMethodBeat.o(57411);
      return true;
    }
    AppMethodBeat.o(57411);
    return false;
  }
  
  public final d.l.b.a.b.f.a fOT()
  {
    AppMethodBeat.i(57409);
    d.l.b.a.b.f.a locala = b.bz(d.g.a.a(d.g.a.a(this.LiW)));
    AppMethodBeat.o(57409);
    return locala;
  }
  
  public final Collection<d.l.b.a.b.d.a.e.b> fTa()
  {
    AppMethodBeat.i(57408);
    Object localObject1 = d.g.a.a(d.g.a.a(this.LiW)).getDeclaredMethods();
    k.g(localObject1, "annotation.annotationClass.java.declaredMethods");
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      Object localObject3 = d.Ljt;
      localObject3 = localObject2.invoke(this.LiW, new Object[0]);
      k.g(localObject3, "method.invoke(annotation)");
      k.g(localObject2, "method");
      localCollection.add(d.a.a(localObject3, f.aWB(localObject2.getName())));
      i += 1;
    }
    localObject1 = (Collection)localCollection;
    AppMethodBeat.o(57408);
    return localObject1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57412);
    int i = this.LiW.hashCode();
    AppMethodBeat.o(57412);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57413);
    String str = getClass().getName() + ": " + this.LiW;
    AppMethodBeat.o(57413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.c
 * JD-Core Version:    0.7.0.1
 */