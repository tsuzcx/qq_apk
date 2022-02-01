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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class as<T>
  implements h<T>
{
  private final n NLm;
  private final h<T> NMG;
  
  public as(h<T> paramh)
  {
    AppMethodBeat.i(191077);
    this.NMG = paramh;
    this.NLm = ((n)new bb(this.NMG.eLj()));
    AppMethodBeat.o(191077);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(191073);
    p.h(paramc, "decoder");
    if (paramc.gwD())
    {
      paramc = paramc.a((f)this.NMG);
      AppMethodBeat.o(191073);
      return paramc;
    }
    paramc = paramc.gwE();
    AppMethodBeat.o(191073);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(191074);
    p.h(paramc, "decoder");
    if (paramT == null)
    {
      paramc = a(paramc);
      AppMethodBeat.o(191074);
      return paramc;
    }
    if (paramc.gwD())
    {
      paramc = paramc.a((f)this.NMG, paramT);
      AppMethodBeat.o(191074);
      return paramc;
    }
    paramc.gwE();
    AppMethodBeat.o(191074);
    return paramT;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(191072);
    p.h(paramg, "encoder");
    if (paramT != null)
    {
      paramg.a((v)this.NMG, paramT);
      AppMethodBeat.o(191072);
      return;
    }
    paramg.gwO();
    AppMethodBeat.o(191072);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191075);
    if ((as)this == paramObject)
    {
      AppMethodBeat.o(191075);
      return true;
    }
    if ((paramObject == null) || ((p.i(z.bp(getClass()), z.bp(paramObject.getClass())) ^ true)))
    {
      AppMethodBeat.o(191075);
      return false;
    }
    if ((p.i(this.NMG, ((as)paramObject).NMG) ^ true))
    {
      AppMethodBeat.o(191075);
      return false;
    }
    AppMethodBeat.o(191075);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191076);
    int i = this.NMG.hashCode();
    AppMethodBeat.o(191076);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.as
 * JD-Core Version:    0.7.0.1
 */