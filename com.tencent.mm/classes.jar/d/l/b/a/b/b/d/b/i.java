package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.e.f;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class i
  extends w
  implements f
{
  private final w Nxw;
  private final Type Nxx;
  
  public i(Type paramType)
  {
    AppMethodBeat.i(57424);
    this.Nxx = paramType;
    paramType = this.Nxx;
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      p.g(paramType, "genericComponentType");
    }
    for (paramType = w.a.j(paramType);; paramType = w.a.j((Type)paramType))
    {
      this.Nxw = paramType;
      AppMethodBeat.o(57424);
      return;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isArray())) {
        break;
      }
      paramType = ((Class)paramType).getComponentType();
      p.g(paramType, "getComponentType()");
    }
    paramType = (Throwable)new IllegalArgumentException("Not an array type (" + this.Nxx.getClass() + "): " + this.Nxx);
    AppMethodBeat.o(57424);
    throw paramType;
  }
  
  protected final Type gph()
  {
    return this.Nxx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */