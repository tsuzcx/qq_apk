package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public abstract class w
  implements d.l.b.a.b.d.a.e.v
{
  public static final a LjK = new a((byte)0);
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof w)) && (k.g(fTg(), ((w)paramObject).fTg()));
  }
  
  protected abstract Type fTg();
  
  public int hashCode()
  {
    return fTg().hashCode();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + fTg();
  }
  
  public static final class a
  {
    public static w j(Type paramType)
    {
      AppMethodBeat.i(57504);
      k.h(paramType, "type");
      if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
      {
        paramType = (w)new v((Class)paramType);
        AppMethodBeat.o(57504);
        return paramType;
      }
      if (((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray())))
      {
        paramType = (w)new i(paramType);
        AppMethodBeat.o(57504);
        return paramType;
      }
      if ((paramType instanceof WildcardType))
      {
        paramType = (w)new z((WildcardType)paramType);
        AppMethodBeat.o(57504);
        return paramType;
      }
      paramType = (w)new l(paramType);
      AppMethodBeat.o(57504);
      return paramType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.w
 * JD-Core Version:    0.7.0.1
 */