package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "patch", "decoder", "Lkotlinx/serialization/Decoder;", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract interface h<T>
  extends f<T>, v<T>
{
  public abstract n gPe();
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static <T> T a(h<T> paramh, c paramc)
    {
      AppMethodBeat.i(254204);
      p.k(paramc, "decoder");
      paramh = (Throwable)new aa(paramh.gPe().iTF());
      AppMethodBeat.o(254204);
      throw paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.h
 * JD-Core Version:    0.7.0.1
 */