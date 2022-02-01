package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class x
  extends w
{
  public static final <T> List<T> oI(List<? extends T> paramList)
  {
    AppMethodBeat.i(191018);
    s.u(paramList, "$this$asReversed");
    paramList = (List)new aq(paramList);
    AppMethodBeat.o(191018);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.x
 * JD-Core Version:    0.7.0.1
 */