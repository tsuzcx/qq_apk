package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.a.b;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/HashSetSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "element", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class o<E>
  extends w<E, Set<? extends E>, HashSet<E>>
{
  private final e Wki;
  
  public o(b<E> paramb)
  {
    super(paramb, (byte)0);
    AppMethodBeat.i(188554);
    this.Wki = ((e)new n(paramb.iou()));
    AppMethodBeat.o(188554);
  }
  
  public final e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.o
 * JD-Core Version:    0.7.0.1
 */