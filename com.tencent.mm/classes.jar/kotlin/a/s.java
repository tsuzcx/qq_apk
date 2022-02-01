package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class s
  extends r
{
  public static final <T> int a(Iterable<? extends T> paramIterable, int paramInt)
  {
    AppMethodBeat.i(129232);
    kotlin.g.b.s.u(paramIterable, "$this$collectionSizeOrDefault");
    if ((paramIterable instanceof Collection))
    {
      paramInt = ((Collection)paramIterable).size();
      AppMethodBeat.o(129232);
      return paramInt;
    }
    AppMethodBeat.o(129232);
    return paramInt;
  }
  
  public static final <T> Collection<T> a(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    AppMethodBeat.i(191012);
    kotlin.g.b.s.u(paramIterable1, "$this$convertToSetForSetOperationWith");
    kotlin.g.b.s.u(paramIterable2, "source");
    if ((paramIterable1 instanceof Set))
    {
      paramIterable1 = (Collection)paramIterable1;
      AppMethodBeat.o(191012);
      return paramIterable1;
    }
    if ((paramIterable1 instanceof Collection))
    {
      if (((paramIterable2 instanceof Collection)) && (((Collection)paramIterable2).size() < 2))
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(191012);
        return paramIterable1;
      }
      paramIterable2 = (Collection)paramIterable1;
      if ((paramIterable2.size() > 2) && ((paramIterable2 instanceof ArrayList))) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(191012);
        return paramIterable1;
      }
    }
    paramIterable1 = (Collection)p.o(paramIterable1);
    AppMethodBeat.o(191012);
    return paramIterable1;
  }
  
  public static final <T> Integer d(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191007);
    kotlin.g.b.s.u(paramIterable, "$this$collectionSizeOrNull");
    if ((paramIterable instanceof Collection))
    {
      int i = ((Collection)paramIterable).size();
      AppMethodBeat.o(191007);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(191007);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.s
 * JD-Core Version:    0.7.0.1
 */