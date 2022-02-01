package kotlinx.a.b;

import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlinx.a.b;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "Lkotlinx/serialization/internal/HashMapSerializer;", "kotlinx-serialization-runtime"})
public abstract class ao<Key, Value, Collection, Builder extends Map<Key, Value>>
  extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder>
{
  public final h<Key> NMt;
  public final h<Value> NMu;
  private final h<? extends Object>[] NMw;
  
  private ao(h<Key> paramh, h<Value> paramh1)
  {
    super((byte)0);
    this.NMt = paramh;
    this.NMu = paramh1;
    this.NMw = new h[] { this.NMt, this.NMu };
  }
  
  public final void a(g paramg, Collection paramCollection)
  {
    p.h(paramg, "encoder");
    gb(paramCollection);
    Object localObject1 = eLj();
    Object localObject2 = this.NMw;
    paramg = paramg.c((n)localObject1, (h[])Arrays.copyOf((Object[])localObject2, localObject2.length));
    paramCollection = gc(paramCollection);
    int i = 0;
    while (paramCollection.hasNext())
    {
      localObject2 = (Map.Entry)paramCollection.next();
      localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      n localn = eLj();
      int j = i + 1;
      paramg.a(localn, i, (v)this.NMt, localObject1);
      localObject1 = eLj();
      i = j + 1;
      paramg.a((n)localObject1, j, (v)this.NMu, localObject2);
    }
    paramg.a(eLj());
  }
  
  public abstract n eLj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ao
 * JD-Core Version:    0.7.0.1
 */