package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.w;

public final class x
  extends n
  implements f, w
{
  private final TypeVariable<?> Tnv;
  
  public x(TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(57510);
    this.Tnv = paramTypeVariable;
    AppMethodBeat.o(57510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57507);
    if (((paramObject instanceof x)) && (p.j(this.Tnv, ((x)paramObject).Tnv)))
    {
      AppMethodBeat.o(57507);
      return true;
    }
    AppMethodBeat.o(57507);
    return false;
  }
  
  public final kotlin.l.b.a.b.f.f hAH()
  {
    AppMethodBeat.i(57506);
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.btY(this.Tnv.getName());
    p.g(localf, "Name.identifier(typeVariable.name)");
    AppMethodBeat.o(57506);
    return localf;
  }
  
  public final AnnotatedElement hCG()
  {
    TypeVariable localTypeVariable2 = this.Tnv;
    TypeVariable localTypeVariable1 = localTypeVariable2;
    if (!(localTypeVariable2 instanceof AnnotatedElement)) {
      localTypeVariable1 = null;
    }
    return (AnnotatedElement)localTypeVariable1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57508);
    int i = this.Tnv.hashCode();
    AppMethodBeat.o(57508);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57509);
    String str = getClass().getName() + ": " + this.Tnv;
    AppMethodBeat.o(57509);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */