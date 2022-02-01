package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class as<T>
  implements h<T>
{
  private final n TXo;
  private final h<T> TYH;
  
  public as(h<T> paramh)
  {
    AppMethodBeat.i(225437);
    this.TYH = paramh;
    this.TXo = ((n)new bb(this.TYH.fWv()));
    AppMethodBeat.o(225437);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(225433);
    p.h(paramc, "decoder");
    if (paramc.hOm())
    {
      paramc = paramc.a((f)this.TYH);
      AppMethodBeat.o(225433);
      return paramc;
    }
    paramc = paramc.hOn();
    AppMethodBeat.o(225433);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(225434);
    p.h(paramc, "decoder");
    if (paramT == null)
    {
      paramc = a(paramc);
      AppMethodBeat.o(225434);
      return paramc;
    }
    if (paramc.hOm())
    {
      paramc = paramc.a((f)this.TYH, paramT);
      AppMethodBeat.o(225434);
      return paramc;
    }
    paramc.hOn();
    AppMethodBeat.o(225434);
    return paramT;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(225432);
    p.h(paramg, "encoder");
    if (paramT != null)
    {
      paramg.a((v)this.TYH, paramT);
      AppMethodBeat.o(225432);
      return;
    }
    paramg.hOx();
    AppMethodBeat.o(225432);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225435);
    if ((as)this == paramObject)
    {
      AppMethodBeat.o(225435);
      return true;
    }
    if ((paramObject == null) || ((p.j(aa.bp(getClass()), aa.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(225435);
      return false;
    }
    if ((p.j(this.TYH, ((as)paramObject).TYH) ^ true))
    {
      AppMethodBeat.o(225435);
      return false;
    }
    AppMethodBeat.o(225435);
    return true;
  }
  
  public final n fWv()
  {
    return this.TXo;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225436);
    int i = this.TYH.hashCode();
    AppMethodBeat.o(225436);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.as
 * JD-Core Version:    0.7.0.1
 */