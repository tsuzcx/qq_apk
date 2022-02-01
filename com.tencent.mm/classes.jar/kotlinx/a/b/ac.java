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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"})
public abstract class ac<K, V, R>
  implements h<R>
{
  private final h<K> NMt;
  private final h<V> NMu;
  
  private ac(h<K> paramh, h<V> paramh1)
  {
    this.NMt = paramh;
    this.NMu = paramh1;
  }
  
  public abstract R Y(K paramK, V paramV);
  
  public final R a(c paramc)
  {
    p.h(paramc, "decoder");
    a locala = paramc.a(eLj(), new h[] { this.NMt, this.NMu });
    paramc = bh.gxc();
    Object localObject = bh.gxc();
    int i;
    for (;;)
    {
      i = locala.b(eLj());
      if (i == -1) {
        break label137;
      }
      if (i == 0)
      {
        paramc = locala.a(eLj(), 0, (f)this.NMt);
      }
      else
      {
        if (i != 1) {
          break;
        }
        localObject = locala.a(eLj(), 1, (f)this.NMu);
      }
    }
    throw ((Throwable)new t("Invalid index: ".concat(String.valueOf(i)), (byte)0));
    label137:
    locala.a(eLj());
    if (paramc == bh.gxc()) {
      throw ((Throwable)new t("Element 'key' is missing", (byte)0));
    }
    if (localObject == bh.gxc()) {
      throw ((Throwable)new t("Element 'value' is missing", (byte)0));
    }
    return Y(paramc, localObject);
  }
  
  public final R a(c paramc, R paramR)
  {
    p.h(paramc, "decoder");
    return h.a.a(this, paramc);
  }
  
  public final void a(g paramg, R paramR)
  {
    p.h(paramg, "encoder");
    paramg = paramg.b(eLj(), new h[] { this.NMt, this.NMu });
    paramg.a(eLj(), 0, (v)this.NMt, gg(paramR));
    paramg.a(eLj(), 1, (v)this.NMu, getValue(paramR));
    paramg.a(eLj());
  }
  
  public abstract V getValue(R paramR);
  
  public abstract K gg(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ac
 * JD-Core Version:    0.7.0.1
 */