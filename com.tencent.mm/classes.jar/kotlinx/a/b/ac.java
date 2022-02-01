package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.h.a;
import kotlinx.a.t;
import kotlinx.a.v;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"})
public abstract class ac<K, V, R>
  implements h<R>
{
  private final h<K> TYu;
  private final h<V> TYv;
  
  private ac(h<K> paramh, h<V> paramh1)
  {
    this.TYu = paramh;
    this.TYv = paramh1;
  }
  
  public final R a(c paramc)
  {
    p.h(paramc, "decoder");
    a locala = paramc.a(fWv(), new h[] { this.TYu, this.TYv });
    paramc = bh.hOL();
    Object localObject = bh.hOL();
    int i;
    for (;;)
    {
      i = locala.b(fWv());
      if (i == -1) {
        break label137;
      }
      if (i == 0)
      {
        paramc = locala.a(fWv(), 0, (f)this.TYu);
      }
      else
      {
        if (i != 1) {
          break;
        }
        localObject = locala.a(fWv(), 1, (f)this.TYv);
      }
    }
    throw ((Throwable)new t("Invalid index: ".concat(String.valueOf(i)), (byte)0));
    label137:
    locala.a(fWv());
    if (paramc == bh.hOL()) {
      throw ((Throwable)new t("Element 'key' is missing", (byte)0));
    }
    if (localObject == bh.hOL()) {
      throw ((Throwable)new t("Element 'value' is missing", (byte)0));
    }
    return aa(paramc, localObject);
  }
  
  public final R a(c paramc, R paramR)
  {
    p.h(paramc, "decoder");
    return h.a.a(this, paramc);
  }
  
  public final void a(g paramg, R paramR)
  {
    p.h(paramg, "encoder");
    paramg = paramg.b(fWv(), new h[] { this.TYu, this.TYv });
    paramg.a(fWv(), 0, (v)this.TYu, go(paramR));
    paramg.a(fWv(), 1, (v)this.TYv, getValue(paramR));
    paramg.a(fWv());
  }
  
  public abstract R aa(K paramK, V paramV);
  
  public abstract V getValue(R paramR);
  
  public abstract K go(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.ac
 * JD-Core Version:    0.7.0.1
 */