package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "element", "(Ljava/util/LinkedHashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class ag<E>
  extends ai<E, Set<? extends E>, LinkedHashSet<E>>
{
  private final n Ois;
  
  public ag(h<E> paramh)
  {
    super(paramh, (byte)0);
    AppMethodBeat.i(199815);
    this.Ois = ((n)new af(paramh.eOR()));
    AppMethodBeat.o(199815);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ag
 * JD-Core Version:    0.7.0.1
 */