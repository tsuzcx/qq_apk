package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.f;

public final class i
  extends w
  implements f
{
  private final Type aiMV;
  private final w aiMW;
  private final Collection<a> aiMX;
  private final boolean aiMY;
  
  public i(Type paramType)
  {
    AppMethodBeat.i(57424);
    this.aiMV = paramType;
    paramType = this.aiMV;
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      s.s(paramType, "genericComponentType");
    }
    for (paramType = w.a.l(paramType);; paramType = w.a.l((Type)paramType))
    {
      this.aiMW = paramType;
      this.aiMX = ((Collection)ab.aivy);
      AppMethodBeat.o(57424);
      return;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isArray())) {
        break;
      }
      paramType = ((Class)paramType).getComponentType();
      s.s(paramType, "getComponentType()");
    }
    paramType = new IllegalArgumentException("Not an array type (" + this.aiMV.getClass() + "): " + this.aiMV);
    AppMethodBeat.o(57424);
    throw paramType;
  }
  
  public final boolean kqA()
  {
    return this.aiMY;
  }
  
  protected final Type kqy()
  {
    return this.aiMV;
  }
  
  public final Collection<a> kqz()
  {
    return this.aiMX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.i
 * JD-Core Version:    0.7.0.1
 */