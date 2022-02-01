package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Map.Entry;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.o;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-runtime"})
public final class am<K, V>
  extends ac<K, V, Map.Entry<? extends K, ? extends V>>
{
  private final n Ois;
  
  public am(h<K> paramh, final h<V> paramh1)
  {
    super(paramh, paramh1, (byte)0);
    AppMethodBeat.i(199623);
    this.Ois = kotlinx.a.p.a("kotlin.collections.Map.Entry", (s)w.c.OiY, (b)new b(paramh, paramh1));
    AppMethodBeat.o(199623);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-runtime"})
  static final class a<K, V>
    implements a, Map.Entry<K, V>
  {
    private final K aIw;
    private final V value;
    
    public a(K paramK, V paramV)
    {
      this.aIw = paramK;
      this.value = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199806);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!d.g.b.p.i(getKey(), paramObject.getKey())) || (!d.g.b.p.i(getValue(), paramObject.getValue()))) {}
        }
      }
      else
      {
        AppMethodBeat.o(199806);
        return true;
      }
      AppMethodBeat.o(199806);
      return false;
    }
    
    public final K getKey()
    {
      return this.aIw;
    }
    
    public final V getValue()
    {
      return this.value;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(199805);
      Object localObject = getKey();
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = getValue();
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(199805);
        return i * 31 + j;
      }
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(199807);
      paramV = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(199807);
      throw paramV;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199804);
      String str = "MapEntry(key=" + getKey() + ", value=" + getValue() + ")";
      AppMethodBeat.o(199804);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "K", "V", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class b
    extends q
    implements b<o, z>
  {
    b(h paramh1, h paramh2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.am
 * JD-Core Version:    0.7.0.1
 */