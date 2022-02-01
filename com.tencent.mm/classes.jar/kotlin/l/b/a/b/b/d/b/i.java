package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.f;

public final class i
  extends w
  implements f
{
  private final w Tne;
  private final Type Tnf;
  
  public i(Type paramType)
  {
    AppMethodBeat.i(57424);
    this.Tnf = paramType;
    paramType = this.Tnf;
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      p.g(paramType, "genericComponentType");
    }
    for (paramType = w.a.b(paramType);; paramType = w.a.b((Type)paramType))
    {
      this.Tne = paramType;
      AppMethodBeat.o(57424);
      return;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isArray())) {
        break;
      }
      paramType = ((Class)paramType).getComponentType();
      p.g(paramType, "getComponentType()");
    }
    paramType = (Throwable)new IllegalArgumentException("Not an array type (" + this.Tnf.getClass() + "): " + this.Tnf);
    AppMethodBeat.o(57424);
    throw paramType;
  }
  
  protected final Type hCJ()
  {
    return this.Tnf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */