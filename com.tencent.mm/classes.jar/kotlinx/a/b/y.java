package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashSet;
import java.util.Set;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/HashSetSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "element", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class y<E>
  extends ai<E, Set<? extends E>, HashSet<E>>
{
  private final n NLm;
  
  public y(h<E> paramh)
  {
    super(paramh, (byte)0);
    AppMethodBeat.i(191058);
    this.NLm = ((n)new x(paramh.eLj()));
    AppMethodBeat.o(191058);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.y
 * JD-Core Version:    0.7.0.1
 */