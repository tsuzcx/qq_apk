package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.List<+Lkotlinx.a.b.e;>;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"EMPTY_DESCRIPTOR_ARRAY", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getEMPTY_DESCRIPTOR_ARRAY$annotations", "()V", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "defer", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/DeserializationStrategy;", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/SerializationStrategy;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "getElementIndexOrThrow", "name", "kclass", "Lkotlin/reflect/KClass;", "", "Lkotlin/reflect/KType;", "serializerNotRegistered", "", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class af
{
  private static final e[] ajDI = new e[0];
  
  public static final Set<String> h(e parame)
  {
    AppMethodBeat.i(188696);
    s.u(parame, "$this$cachedSerialNames");
    if ((parame instanceof ag))
    {
      parame = ((ag)parame).kFu().keySet();
      AppMethodBeat.o(188696);
      return parame;
    }
    HashSet localHashSet = new HashSet(parame.kFb());
    int j = parame.kFb();
    int i = 0;
    while (i < j)
    {
      ((Collection)localHashSet).add(parame.aMK(i));
      i += 1;
    }
    parame = (Set)localHashSet;
    AppMethodBeat.o(188696);
    return parame;
  }
  
  public static final e[] pi(List<? extends e> paramList)
  {
    AppMethodBeat.i(188709);
    Object localObject = (Collection)paramList;
    int i;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        paramList = ((Collection)paramList).toArray(new e[0]);
        if (paramList == null)
        {
          paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(188709);
          throw paramList;
          i = 0;
          break;
          label73:
          paramList = null;
          continue;
        }
        localObject = (e[])paramList;
        paramList = (List<? extends e>)localObject;
        if (localObject != null) {
          break label93;
        }
      }
    }
    paramList = ajDI;
    label93:
    AppMethodBeat.o(188709);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.af
 * JD-Core Version:    0.7.0.1
 */