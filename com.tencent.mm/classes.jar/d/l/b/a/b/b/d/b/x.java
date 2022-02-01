package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.e.w;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;

public final class x
  extends n
  implements f, w
{
  private final TypeVariable<?> LjL;
  
  public x(TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(57510);
    this.LjL = paramTypeVariable;
    AppMethodBeat.o(57510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57507);
    if (((paramObject instanceof x)) && (k.g(this.LjL, ((x)paramObject).LjL)))
    {
      AppMethodBeat.o(57507);
      return true;
    }
    AppMethodBeat.o(57507);
    return false;
  }
  
  public final d.l.b.a.b.f.f fRf()
  {
    AppMethodBeat.i(57506);
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aWB(this.LjL.getName());
    k.g(localf, "Name.identifier(typeVariable.name)");
    AppMethodBeat.o(57506);
    return localf;
  }
  
  public final AnnotatedElement fTd()
  {
    TypeVariable localTypeVariable2 = this.LjL;
    TypeVariable localTypeVariable1 = localTypeVariable2;
    if (!(localTypeVariable2 instanceof AnnotatedElement)) {
      localTypeVariable1 = null;
    }
    return (AnnotatedElement)localTypeVariable1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57508);
    int i = this.LjL.hashCode();
    AppMethodBeat.o(57508);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57509);
    String str = getClass().getName() + ": " + this.LjL;
    AppMethodBeat.o(57509);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.x
 * JD-Core Version:    0.7.0.1
 */