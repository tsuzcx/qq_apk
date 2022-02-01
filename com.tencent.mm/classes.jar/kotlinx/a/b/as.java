package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class as<T>
  implements h<T>
{
  private final n abAF;
  private final h<T> abBW;
  
  public as(h<T> paramh)
  {
    AppMethodBeat.i(254338);
    this.abBW = paramh;
    this.abAF = ((n)new bb(this.abBW.gPe()));
    AppMethodBeat.o(254338);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(254333);
    p.k(paramc, "decoder");
    if (paramc.iTs())
    {
      paramc = paramc.a((f)this.abBW);
      AppMethodBeat.o(254333);
      return paramc;
    }
    paramc = paramc.iTt();
    AppMethodBeat.o(254333);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(254334);
    p.k(paramc, "decoder");
    if (paramT == null)
    {
      paramc = a(paramc);
      AppMethodBeat.o(254334);
      return paramc;
    }
    if (paramc.iTs())
    {
      paramc = paramc.a((f)this.abBW, paramT);
      AppMethodBeat.o(254334);
      return paramc;
    }
    paramc.iTt();
    AppMethodBeat.o(254334);
    return paramT;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(254332);
    p.k(paramg, "encoder");
    if (paramT != null)
    {
      paramg.a((v)this.abBW, paramT);
      AppMethodBeat.o(254332);
      return;
    }
    paramg.iTD();
    AppMethodBeat.o(254332);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254336);
    if ((as)this == paramObject)
    {
      AppMethodBeat.o(254336);
      return true;
    }
    if ((paramObject == null) || ((p.h(ab.bO(getClass()), ab.bO(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(254336);
      return false;
    }
    if ((p.h(this.abBW, ((as)paramObject).abBW) ^ true))
    {
      AppMethodBeat.o(254336);
      return false;
    }
    AppMethodBeat.o(254336);
    return true;
  }
  
  public final n gPe()
  {
    return this.abAF;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(254337);
    int i = this.abBW.hashCode();
    AppMethodBeat.o(254337);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.as
 * JD-Core Version:    0.7.0.1
 */