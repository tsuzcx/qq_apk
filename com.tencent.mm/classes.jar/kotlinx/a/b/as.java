package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import d.l;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class as<T>
  implements h<T>
{
  private final n Ois;
  private final h<T> OjM;
  
  public as(h<T> paramh)
  {
    AppMethodBeat.i(199665);
    this.OjM = paramh;
    this.Ois = ((n)new bb(this.OjM.eOR()));
    AppMethodBeat.o(199665);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(199661);
    p.h(paramc, "decoder");
    if (paramc.gBf())
    {
      paramc = paramc.a((f)this.OjM);
      AppMethodBeat.o(199661);
      return paramc;
    }
    paramc = paramc.gBg();
    AppMethodBeat.o(199661);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(199662);
    p.h(paramc, "decoder");
    if (paramT == null)
    {
      paramc = a(paramc);
      AppMethodBeat.o(199662);
      return paramc;
    }
    if (paramc.gBf())
    {
      paramc = paramc.a((f)this.OjM, paramT);
      AppMethodBeat.o(199662);
      return paramc;
    }
    paramc.gBg();
    AppMethodBeat.o(199662);
    return paramT;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(199660);
    p.h(paramg, "encoder");
    if (paramT != null)
    {
      paramg.a((v)this.OjM, paramT);
      AppMethodBeat.o(199660);
      return;
    }
    paramg.gBq();
    AppMethodBeat.o(199660);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199663);
    if ((as)this == paramObject)
    {
      AppMethodBeat.o(199663);
      return true;
    }
    if ((paramObject == null) || ((p.i(z.bp(getClass()), z.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(199663);
      return false;
    }
    if ((p.i(this.OjM, ((as)paramObject).OjM) ^ true))
    {
      AppMethodBeat.o(199663);
      return false;
    }
    AppMethodBeat.o(199663);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199664);
    int i = this.OjM.hashCode();
    AppMethodBeat.o(199664);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.as
 * JD-Core Version:    0.7.0.1
 */