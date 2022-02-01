package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.l.u;
import kotlin.l.v;
import kotlin.l.y;

@Metadata(d1={""}, d2={"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ao
  implements v
{
  public static final a aixh;
  
  static
  {
    AppMethodBeat.i(190989);
    aixh = new a((byte)0);
    AppMethodBeat.o(190989);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ao)) {
      throw null;
    }
    return false;
  }
  
  public final String getName()
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final List<u> klF()
  {
    throw null;
  }
  
  public final y klG()
  {
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190998);
    String str = a.a((v)this);
    AppMethodBeat.o(190998);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
  {
    public static String a(v paramv)
    {
      AppMethodBeat.i(190971);
      s.u(paramv, "typeParameter");
      StringBuilder localStringBuilder = new StringBuilder();
      y localy = paramv.klG();
      switch (ap.$EnumSwitchMapping$0[localy.ordinal()])
      {
      }
      for (;;)
      {
        localStringBuilder.append(paramv.getName());
        paramv = localStringBuilder.toString();
        s.s(paramv, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(190971);
        return paramv;
        localStringBuilder.append("in ");
        continue;
        localStringBuilder.append("out ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.ao
 * JD-Core Version:    0.7.0.1
 */