package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class z
  implements ParameterizedType, aa
{
  private final Type dFd;
  private final Type[] dFf;
  private final Class<?> dIb;
  
  public z(Class<?> paramClass, Type paramType, List<? extends Type> paramList)
  {
    AppMethodBeat.i(191295);
    this.dIb = paramClass;
    this.dFd = paramType;
    paramClass = ((Collection)paramList).toArray(new Type[0]);
    if (paramClass == null)
    {
      paramClass = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191295);
      throw paramClass;
    }
    this.dFf = ((Type[])paramClass);
    AppMethodBeat.o(191295);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191326);
    if (((paramObject instanceof ParameterizedType)) && (s.p(this.dIb, ((ParameterizedType)paramObject).getRawType())) && (s.p(this.dFd, ((ParameterizedType)paramObject).getOwnerType())) && (Arrays.equals(getActualTypeArguments(), ((ParameterizedType)paramObject).getActualTypeArguments())))
    {
      AppMethodBeat.o(191326);
      return true;
    }
    AppMethodBeat.o(191326);
    return false;
  }
  
  public final Type[] getActualTypeArguments()
  {
    return this.dFf;
  }
  
  public final Type getOwnerType()
  {
    return this.dFd;
  }
  
  public final Type getRawType()
  {
    return (Type)this.dIb;
  }
  
  public final String getTypeName()
  {
    AppMethodBeat.i(191320);
    Object localObject = new StringBuilder();
    if (this.dFd != null)
    {
      ((StringBuilder)localObject).append(ac.i(this.dFd));
      ((StringBuilder)localObject).append("$");
      ((StringBuilder)localObject).append(this.dIb.getSimpleName());
      if (this.dFf.length != 0) {
        break label135;
      }
      i = 1;
      label61:
      if (i != 0) {
        break label140;
      }
    }
    label135:
    label140:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        k.a(this.dFf, (Appendable)localObject, (CharSequence)"<", (CharSequence)">", (b)a.aixR);
      }
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(191320);
      return localObject;
      ((StringBuilder)localObject).append(ac.i((Type)this.dIb));
      break;
      i = 0;
      break label61;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191331);
    int j = this.dIb.hashCode();
    Type localType = this.dFd;
    if (localType != null) {}
    for (int i = localType.hashCode();; i = 0)
    {
      int k = Arrays.hashCode(getActualTypeArguments());
      AppMethodBeat.o(191331);
      return i ^ j ^ k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191334);
    String str = getTypeName();
    AppMethodBeat.o(191334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.z
 * JD-Core Version:    0.7.0.1
 */