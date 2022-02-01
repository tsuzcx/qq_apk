package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import kotlin.g.b.s;

public final class x
  extends n
  implements f, kotlin.l.b.a.b.d.a.e.x
{
  private final TypeVariable<?> aiNo;
  
  public x(TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(57510);
    this.aiNo = paramTypeVariable;
    AppMethodBeat.o(57510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57507);
    if (((paramObject instanceof x)) && (s.p(this.aiNo, ((x)paramObject).aiNo)))
    {
      AppMethodBeat.o(57507);
      return true;
    }
    AppMethodBeat.o(57507);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57508);
    int i = this.aiNo.hashCode();
    AppMethodBeat.o(57508);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.f kok()
  {
    AppMethodBeat.i(57506);
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bJe(this.aiNo.getName());
    s.s(localf, "identifier(typeVariable.name)");
    AppMethodBeat.o(57506);
    return localf;
  }
  
  public final boolean kqA()
  {
    AppMethodBeat.i(191847);
    s.u((f)this, "this");
    AppMethodBeat.o(191847);
    return false;
  }
  
  public final AnnotatedElement kqw()
  {
    TypeVariable localTypeVariable = this.aiNo;
    if ((localTypeVariable instanceof AnnotatedElement)) {
      return (AnnotatedElement)localTypeVariable;
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57509);
    String str = getClass().getName() + ": " + this.aiNo;
    AppMethodBeat.o(57509);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.x
 * JD-Core Version:    0.7.0.1
 */