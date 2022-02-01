package kotlinx.a.d;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlinx.a.b;
import kotlinx.a.b.e;
import kotlinx.a.c.c;
import kotlinx.a.c.c.b;
import kotlinx.a.c.f;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "Lkotlinx/serialization/internal/HashMapSerializer;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class aa<Key, Value, Collection, Builder extends Map<Key, Value>>
  extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder>
{
  private final b<Key> ajDw;
  private final b<Value> ajDx;
  
  private aa(b<Key> paramb, b<Value> paramb1)
  {
    super((byte)0);
    this.ajDw = paramb;
    this.ajDx = paramb1;
  }
  
  private void a(c paramc, int paramInt, Builder paramBuilder, boolean paramBoolean)
  {
    s.u(paramc, "decoder");
    s.u(paramBuilder, "builder");
    Object localObject = c.b.a(paramc, iou(), paramInt, (kotlinx.a.a)this.ajDw);
    if (paramBoolean)
    {
      int j = paramc.g(iou());
      if (j == paramInt + 1) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException(("Value must follow key in a map, index for key: " + paramInt + ", returned index for value: " + j).toString()));
      }
      paramInt = j;
      if ((!paramBuilder.containsKey(localObject)) || ((this.ajDx.iou().kFd() instanceof kotlinx.a.b.d))) {
        break label186;
      }
    }
    label186:
    for (paramc = paramc.a(iou(), paramInt, (kotlinx.a.a)this.ajDx, ak.e(paramBuilder, localObject));; paramc = c.b.a(paramc, iou(), paramInt, (kotlinx.a.a)this.ajDx))
    {
      paramBuilder.put(localObject, paramc);
      return;
      paramInt += 1;
      break;
    }
  }
  
  public final void a(f paramf, Collection paramCollection)
  {
    s.u(paramf, "encoder");
    int i = jr(paramCollection);
    paramf = paramf.d(iou(), i);
    paramCollection = js(paramCollection);
    i = 0;
    while (paramCollection.hasNext())
    {
      Object localObject2 = (Map.Entry)paramCollection.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      e locale = iou();
      int j = i + 1;
      paramf.a(locale, i, (g)this.ajDw, localObject1);
      localObject1 = iou();
      i = j + 1;
      paramf.a((e)localObject1, j, (g)this.ajDx, localObject2);
    }
    paramf.b(iou());
  }
  
  public abstract e iou();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.aa
 * JD-Core Version:    0.7.0.1
 */