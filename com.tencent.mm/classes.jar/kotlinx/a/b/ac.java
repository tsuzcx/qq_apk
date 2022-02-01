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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"})
public abstract class ac<K, V, R>
  implements h<R>
{
  private final h<K> abBJ;
  private final h<V> abBK;
  
  private ac(h<K> paramh, h<V> paramh1)
  {
    this.abBJ = paramh;
    this.abBK = paramh1;
  }
  
  public abstract R T(K paramK, V paramV);
  
  public final R a(c paramc)
  {
    p.k(paramc, "decoder");
    a locala = paramc.a(gPe(), new h[] { this.abBJ, this.abBK });
    paramc = bh.iTS();
    Object localObject = bh.iTS();
    int i;
    for (;;)
    {
      i = locala.b(gPe());
      if (i == -1) {
        break label137;
      }
      if (i == 0)
      {
        paramc = locala.a(gPe(), 0, (f)this.abBJ);
      }
      else
      {
        if (i != 1) {
          break;
        }
        localObject = locala.a(gPe(), 1, (f)this.abBK);
      }
    }
    throw ((Throwable)new t("Invalid index: ".concat(String.valueOf(i)), (byte)0));
    label137:
    locala.a(gPe());
    if (paramc == bh.iTS()) {
      throw ((Throwable)new t("Element 'key' is missing", (byte)0));
    }
    if (localObject == bh.iTS()) {
      throw ((Throwable)new t("Element 'value' is missing", (byte)0));
    }
    return T(paramc, localObject);
  }
  
  public final R a(c paramc, R paramR)
  {
    p.k(paramc, "decoder");
    return h.a.a(this, paramc);
  }
  
  public final void a(g paramg, R paramR)
  {
    p.k(paramg, "encoder");
    paramg = paramg.b(gPe(), new h[] { this.abBJ, this.abBK });
    paramg.a(gPe(), 0, (v)this.abBJ, gG(paramR));
    paramg.a(gPe(), 1, (v)this.abBK, getValue(paramR));
    paramg.a(gPe());
  }
  
  public abstract K gG(R paramR);
  
  public abstract V getValue(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.ac
 * JD-Core Version:    0.7.0.1
 */