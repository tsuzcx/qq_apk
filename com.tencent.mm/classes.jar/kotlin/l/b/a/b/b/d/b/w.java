package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.g.b.p;

public abstract class w
  implements kotlin.l.b.a.b.d.a.e.v
{
  public static final a aaQo = new a((byte)0);
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof w)) && (p.h(iHa(), ((w)paramObject).iHa()));
  }
  
  public int hashCode()
  {
    return iHa().hashCode();
  }
  
  protected abstract Type iHa();
  
  public String toString()
  {
    return getClass().getName() + ": " + iHa();
  }
  
  public static final class a
  {
    public static w j(Type paramType)
    {
      AppMethodBeat.i(57504);
      p.k(paramType, "type");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.w
 * JD-Core Version:    0.7.0.1
 */