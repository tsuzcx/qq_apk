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
  private final w aaPY;
  private final Type aaPZ;
  
  public i(Type paramType)
  {
    AppMethodBeat.i(57424);
    this.aaPZ = paramType;
    paramType = this.aaPZ;
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      p.j(paramType, "genericComponentType");
    }
    for (paramType = w.a.j(paramType);; paramType = w.a.j((Type)paramType))
    {
      this.aaPY = paramType;
      AppMethodBeat.o(57424);
      return;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isArray())) {
        break;
      }
      paramType = ((Class)paramType).getComponentType();
      p.j(paramType, "getComponentType()");
    }
    paramType = (Throwable)new IllegalArgumentException("Not an array type (" + this.aaPZ.getClass() + "): " + this.aaPZ);
    AppMethodBeat.o(57424);
    throw paramType;
  }
  
  protected final Type iHa()
  {
    return this.aaPZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */