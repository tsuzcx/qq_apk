package kotlinx.a.d;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c.c;
import kotlinx.a.c.c.b;
import kotlinx.a.c.d;
import kotlinx.a.c.e;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class q<K, V, R>
  implements b<R>
{
  private final b<K> ajDw;
  private final b<V> ajDx;
  
  private q(b<K> paramb, b<V> paramb1)
  {
    this.ajDw = paramb;
    this.ajDx = paramb1;
  }
  
  public final R a(e parame)
  {
    s.u(parame, "decoder");
    c localc = parame.c(iou());
    if (localc.kFr()) {
      return ah(c.b.a(localc, iou(), 0, (a)this.ajDw), c.b.a(localc, iou(), 1, (a)this.ajDx));
    }
    parame = an.HI();
    Object localObject = an.HI();
    for (;;)
    {
      int i = localc.g(iou());
      switch (i)
      {
      default: 
        throw ((Throwable)new kotlinx.a.f("Invalid index: ".concat(String.valueOf(i))));
      case 0: 
        parame = c.b.a(localc, iou(), 0, (a)this.ajDw);
        break;
      case 1: 
        localObject = c.b.a(localc, iou(), 1, (a)this.ajDx);
      }
    }
    localc.b(iou());
    if (parame == an.HI()) {
      throw ((Throwable)new kotlinx.a.f("Element 'key' is missing"));
    }
    if (localObject == an.HI()) {
      throw ((Throwable)new kotlinx.a.f("Element 'value' is missing"));
    }
    return ah(parame, localObject);
  }
  
  public final void a(kotlinx.a.c.f paramf, R paramR)
  {
    s.u(paramf, "encoder");
    paramf = paramf.e(iou());
    paramf.a(iou(), 0, (g)this.ajDw, jv(paramR));
    paramf.a(iou(), 1, (g)this.ajDx, getValue(paramR));
    paramf.b(iou());
  }
  
  protected abstract R ah(K paramK, V paramV);
  
  protected abstract V getValue(R paramR);
  
  protected abstract K jv(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.q
 * JD-Core Version:    0.7.0.1
 */