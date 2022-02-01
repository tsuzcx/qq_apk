package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/ArrayListSerializer;", "E", "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", "index", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class e<E>
  extends ai<E, List<? extends E>, ArrayList<E>>
{
  private final n TXo;
  
  public e(h<E> paramh)
  {
    super(paramh, (byte)0);
    AppMethodBeat.i(225597);
    this.TXo = ((n)new d(paramh.fWv()));
    AppMethodBeat.o(225597);
  }
  
  public final n fWv()
  {
    return this.TXo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.e
 * JD-Core Version:    0.7.0.1
 */