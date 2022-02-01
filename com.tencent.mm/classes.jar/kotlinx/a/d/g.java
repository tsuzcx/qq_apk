package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.l.b;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "forClass", "(Lkotlin/reflect/KClass;)V", "msg", "", "(Ljava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class g
  extends IllegalArgumentException
{
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(257270);
    AppMethodBeat.o(257270);
  }
  
  public g(b<?> paramb1, b<?> paramb2)
  {
    this("Serializer for " + paramb2 + " already registered in the scope of " + paramb1);
    AppMethodBeat.i(257271);
    AppMethodBeat.o(257271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.d.g
 * JD-Core Version:    0.7.0.1
 */