package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c.f;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class ac<T>
  implements b<T>
{
  private final kotlinx.a.b.e Wki;
  private final b<T> ajDG;
  
  public ac(b<T> paramb)
  {
    AppMethodBeat.i(188701);
    this.ajDG = paramb;
    this.Wki = ((kotlinx.a.b.e)new aj(this.ajDG.iou()));
    AppMethodBeat.o(188701);
  }
  
  public final T a(kotlinx.a.c.e parame)
  {
    AppMethodBeat.i(188732);
    s.u(parame, "decoder");
    if (parame.kFg())
    {
      parame = parame.b((a)this.ajDG);
      AppMethodBeat.o(188732);
      return parame;
    }
    parame = parame.kFh();
    AppMethodBeat.o(188732);
    return parame;
  }
  
  public final void a(f paramf, T paramT)
  {
    AppMethodBeat.i(188722);
    s.u(paramf, "encoder");
    if (paramT != null)
    {
      paramf.a((g)this.ajDG, paramT);
      AppMethodBeat.o(188722);
      return;
    }
    paramf.kFs();
    AppMethodBeat.o(188722);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188743);
    if ((ac)this == paramObject)
    {
      AppMethodBeat.o(188743);
      return true;
    }
    if ((paramObject == null) || ((s.p(ai.cz(getClass()), ai.cz(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(188743);
      return false;
    }
    if ((s.p(this.ajDG, ((ac)paramObject).ajDG) ^ true))
    {
      AppMethodBeat.o(188743);
      return false;
    }
    AppMethodBeat.o(188743);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188755);
    int i = this.ajDG.hashCode();
    AppMethodBeat.o(188755);
    return i;
  }
  
  public final kotlinx.a.b.e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ac
 * JD-Core Version:    0.7.0.1
 */