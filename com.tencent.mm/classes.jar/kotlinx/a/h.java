package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "patch", "decoder", "Lkotlinx/serialization/Decoder;", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract interface h<T>
  extends f<T>, v<T>
{
  public abstract n fWv();
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static <T> T a(h<T> paramh, c paramc)
    {
      AppMethodBeat.i(225381);
      p.h(paramc, "decoder");
      paramh = (Throwable)new aa(paramh.fWv().hOz());
      AppMethodBeat.o(225381);
      throw paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.h
 * JD-Core Version:    0.7.0.1
 */