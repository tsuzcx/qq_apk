package kotlinx.a.b;

import d.g.b.p;
import d.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.h.a;
import kotlinx.a.t;
import kotlinx.a.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"})
public abstract class ac<K, V, R>
  implements h<R>
{
  private final h<V> OjA;
  private final h<K> Ojz;
  
  private ac(h<K> paramh, h<V> paramh1)
  {
    this.Ojz = paramh;
    this.OjA = paramh1;
  }
  
  public abstract R X(K paramK, V paramV);
  
  public final R a(c paramc)
  {
    p.h(paramc, "decoder");
    a locala = paramc.a(eOR(), new h[] { this.Ojz, this.OjA });
    paramc = bh.gBE();
    Object localObject = bh.gBE();
    int i;
    for (;;)
    {
      i = locala.b(eOR());
      if (i == -1) {
        break label137;
      }
      if (i == 0)
      {
        paramc = locala.a(eOR(), 0, (f)this.Ojz);
      }
      else
      {
        if (i != 1) {
          break;
        }
        localObject = locala.a(eOR(), 1, (f)this.OjA);
      }
    }
    throw ((Throwable)new t("Invalid index: ".concat(String.valueOf(i)), (byte)0));
    label137:
    locala.a(eOR());
    if (paramc == bh.gBE()) {
      throw ((Throwable)new t("Element 'key' is missing", (byte)0));
    }
    if (localObject == bh.gBE()) {
      throw ((Throwable)new t("Element 'value' is missing", (byte)0));
    }
    return X(paramc, localObject);
  }
  
  public final R a(c paramc, R paramR)
  {
    p.h(paramc, "decoder");
    return h.a.a(this, paramc);
  }
  
  public final void a(g paramg, R paramR)
  {
    p.h(paramg, "encoder");
    paramg = paramg.b(eOR(), new h[] { this.Ojz, this.OjA });
    paramg.a(eOR(), 0, (v)this.Ojz, gj(paramR));
    paramg.a(eOR(), 1, (v)this.OjA, getValue(paramR));
    paramg.a(eOR());
  }
  
  public abstract V getValue(R paramR);
  
  public abstract K gj(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ac
 * JD-Core Version:    0.7.0.1
 */