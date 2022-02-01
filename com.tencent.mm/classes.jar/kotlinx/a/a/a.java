package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlinx.a.b;
import kotlinx.a.b.e;
import kotlinx.a.d.ac;
import kotlinx.a.d.al;
import kotlinx.a.d.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"nullable", "Lkotlinx/serialization/KSerializer;", "T", "", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "ArraySerializer", "", "E", "kClass", "Lkotlin/reflect/KClass;", "elementSerializer", "BooleanArraySerializer", "", "ByteArraySerializer", "", "CharArraySerializer", "", "DoubleArraySerializer", "", "FloatArraySerializer", "", "IntArraySerializer", "", "ListSerializer", "", "LongArraySerializer", "", "MapEntrySerializer", "", "K", "V", "keySerializer", "valueSerializer", "MapSerializer", "", "PairSerializer", "Lkotlin/Pair;", "SetSerializer", "", "ShortArraySerializer", "", "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "serializer", "", "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/Byte$Companion;", "", "Lkotlin/Char$Companion;", "", "Lkotlin/Double$Companion;", "", "Lkotlin/Float$Companion;", "", "Lkotlin/Int$Companion;", "", "Lkotlin/Long$Companion;", "", "Lkotlin/Short$Companion;", "", "Lkotlin/String$Companion;", "", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class a
{
  public static final b<String> a(am paramam)
  {
    AppMethodBeat.i(188424);
    s.u(paramam, "$this$serializer");
    paramam = (b)al.ajDU;
    AppMethodBeat.o(188424);
    return paramam;
  }
  
  public static final <T> b<T> a(b<T> paramb)
  {
    AppMethodBeat.i(188421);
    s.u(paramb, "$this$nullable");
    if (paramb.iou().kFc())
    {
      AppMethodBeat.o(188421);
      return paramb;
    }
    paramb = (b)new ac(paramb);
    AppMethodBeat.o(188421);
    return paramb;
  }
  
  public static final <T> b<Set<T>> b(b<T> paramb)
  {
    AppMethodBeat.i(188428);
    s.u(paramb, "elementSerializer");
    paramb = (b)new u(paramb);
    AppMethodBeat.o(188428);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.a.a
 * JD-Core Version:    0.7.0.1
 */