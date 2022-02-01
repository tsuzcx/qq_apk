package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class aq<T>
  extends b<T>
{
  private final List<T> aivC;
  
  public aq(List<? extends T> paramList)
  {
    AppMethodBeat.i(191180);
    this.aivC = paramList;
    AppMethodBeat.o(191180);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(191189);
    Object localObject = this.aivC.get(x.ad(this, paramInt));
    AppMethodBeat.o(191189);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(191184);
    int i = this.aivC.size();
    AppMethodBeat.o(191184);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.aq
 * JD-Core Version:    0.7.0.1
 */