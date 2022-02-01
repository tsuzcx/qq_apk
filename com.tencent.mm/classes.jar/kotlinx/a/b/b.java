package kotlinx.a.b;

import d.g.b.p;
import d.g.b.z;
import d.l;
import kotlinx.a.a;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.h.a;
import kotlinx.a.n;
import kotlinx.a.t;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/CompositeDecoder;", "(Lkotlinx/serialization/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializer", "klassName", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serialize", "", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public abstract class b<T>
  implements h<T>
{
  public final T a(kotlinx.a.c paramc)
  {
    p.h(paramc, "decoder");
    Object localObject2 = eLj();
    a locala = paramc.a((n)localObject2, new h[0]);
    Object localObject1 = null;
    paramc = null;
    int i;
    for (;;)
    {
      i = locala.b(eLj());
      if (i == -1) {
        break label170;
      }
      if (i == 0)
      {
        paramc = locala.i(eLj(), i);
      }
      else
      {
        if (i != 1) {
          break;
        }
        if (paramc == null) {
          throw ((Throwable)new IllegalArgumentException("Cannot read polymorphic value before its type token".toString()));
        }
        localObject1 = a(locala, paramc);
        localObject1 = locala.a(eLj(), i, (f)localObject1);
      }
    }
    localObject2 = new StringBuilder("Invalid index in polymorphic deserialization of ");
    localObject1 = paramc;
    if (paramc == null) {
      localObject1 = "unknown class";
    }
    throw ((Throwable)new t(localObject1 + "\n Expected 0, 1 or READ_DONE(-1), but found " + i, (byte)0));
    label170:
    if (localObject1 == null) {
      throw ((Throwable)new IllegalArgumentException("Polymorphic value has not been read for class ".concat(String.valueOf(paramc)).toString()));
    }
    locala.a((n)localObject2);
    return localObject1;
  }
  
  public final T a(kotlinx.a.c paramc, T paramT)
  {
    p.h(paramc, "decoder");
    p.h(paramT, "old");
    return h.a.a(this, paramc);
  }
  
  public h<? extends T> a(a parama, String paramString)
  {
    p.h(parama, "decoder");
    p.h(paramString, "klassName");
    parama = parama.gwB().a(gwP(), paramString);
    if (parama == null)
    {
      c.a(paramString, gwP());
      throw null;
    }
    return parama;
  }
  
  public final void a(g paramg, T paramT)
  {
    p.h(paramg, "encoder");
    p.h(paramT, "value");
    h localh = b(paramg, paramT);
    n localn1 = eLj();
    paramg = paramg.b(localn1, new h[0]);
    paramg.a(eLj(), localh.eLj().gwQ());
    n localn2 = eLj();
    if (localh == null) {
      throw new d.v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
    }
    paramg.a(localn2, 1, (kotlinx.a.v)localh, paramT);
    paramg.a(localn1);
  }
  
  public h<? extends T> b(g paramg, T paramT)
  {
    p.h(paramg, "encoder");
    p.h(paramT, "value");
    paramg = paramg.gwB().a(gwP(), paramT);
    if (paramg == null)
    {
      paramg = z.bp(paramT.getClass());
      paramT = gwP();
      p.h(paramg, "subClass");
      p.h(paramT, "baseClass");
      c.a(paramg.toString(), paramT);
      throw null;
    }
    return paramg;
  }
  
  public abstract d.l.b<T> gwP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.b
 * JD-Core Version:    0.7.0.1
 */