package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.ad;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;

public abstract class w
  implements kotlin.l.b.a.b.d.a.e.w
{
  public static final a aiNn = new a((byte)0);
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof w)) && (s.p(kqy(), ((w)paramObject).kqy()));
  }
  
  public int hashCode()
  {
    return kqy().hashCode();
  }
  
  protected abstract Type kqy();
  
  public a m(c paramc)
  {
    Object localObject1 = (kotlin.l.b.a.b.d.a.e.w)this;
    s.u(localObject1, "this");
    s.u(paramc, "fqName");
    localObject1 = (ad)localObject1;
    s.u(localObject1, "this");
    s.u(paramc, "fqName");
    Iterator localIterator = ((Iterable)((ad)localObject1).kqz()).iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      localObject1 = ((a)localObject2).kmb();
      if (localObject1 == null)
      {
        localObject1 = null;
        label84:
        if (!s.p(localObject1, paramc)) {
          break label105;
        }
      }
    }
    for (paramc = localObject2;; paramc = null)
    {
      return (a)paramc;
      localObject1 = ((b)localObject1).kxQ();
      break label84;
      label105:
      break;
    }
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + kqy();
  }
  
  public static final class a
  {
    public static w l(Type paramType)
    {
      AppMethodBeat.i(57504);
      s.u(paramType, "type");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.w
 * JD-Core Version:    0.7.0.1
 */