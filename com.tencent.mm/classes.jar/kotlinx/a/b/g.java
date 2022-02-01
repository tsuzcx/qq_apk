package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementNames", "", "getElementNames", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class g
{
  public static final Iterable<e> a(e parame)
  {
    AppMethodBeat.i(188427);
    s.u(parame, "$this$elementDescriptors");
    parame = (Iterable)new a(parame);
    AppMethodBeat.o(188427);
    return parame;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 4, 0})
  public static final class a
    implements Iterable<e>, a
  {
    public a(e parame) {}
    
    public final Iterator<e> iterator()
    {
      AppMethodBeat.i(188464);
      Iterator localIterator = (Iterator)new a(this);
      AppMethodBeat.o(188464);
      return localIterator;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/serialization/descriptors/SerialDescriptorKt$elementDescriptors$1$1", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
    public static final class a
      implements Iterator<e>, a
    {
      private int ajDe;
      
      a(g.a parama)
      {
        AppMethodBeat.i(188458);
        this.ajDe = this.ajDf.ajDd.kFb();
        AppMethodBeat.o(188458);
      }
      
      public final boolean hasNext()
      {
        return this.ajDe > 0;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(188484);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(188484);
        throw localUnsupportedOperationException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.b.g
 * JD-Core Version:    0.7.0.1
 */