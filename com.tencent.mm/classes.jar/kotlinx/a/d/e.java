package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.a.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/ArrayListSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class e<E>
  extends w<E, List<? extends E>, ArrayList<E>>
{
  private final kotlinx.a.b.e Wki;
  
  public e(b<E> paramb)
  {
    super(paramb, (byte)0);
    AppMethodBeat.i(188580);
    this.Wki = ((kotlinx.a.b.e)new d(paramb.iou()));
    AppMethodBeat.o(188580);
  }
  
  public final kotlinx.a.b.e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.e
 * JD-Core Version:    0.7.0.1
 */