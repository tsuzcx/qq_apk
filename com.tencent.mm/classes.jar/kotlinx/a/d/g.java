package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.l.b;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "forClass", "(Lkotlin/reflect/KClass;)V", "msg", "", "(Ljava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class g
  extends IllegalArgumentException
{
  public g(b<?> paramb1, b<?> paramb2)
  {
    this("Serializer for " + paramb2 + " already registered in the scope of " + paramb1);
    AppMethodBeat.i(191510);
    AppMethodBeat.o(191510);
  }
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(191509);
    AppMethodBeat.o(191509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.g
 * JD-Core Version:    0.7.0.1
 */