package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ArrayListSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class e<E>
  extends ai<E, List<? extends E>, ArrayList<E>>
{
  private final n abAF;
  
  public e(h<E> paramh)
  {
    super(paramh, (byte)0);
    AppMethodBeat.i(254845);
    this.abAF = ((n)new d(paramh.gPe()));
    AppMethodBeat.o(254845);
  }
  
  public final n gPe()
  {
    return this.abAF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.e
 * JD-Core Version:    0.7.0.1
 */