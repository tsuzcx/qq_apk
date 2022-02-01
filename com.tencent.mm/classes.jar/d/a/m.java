package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, gkc=1)
public class m
  extends l
{
  public static final <T> int a(Iterable<? extends T> paramIterable, int paramInt)
  {
    AppMethodBeat.i(129232);
    p.h(paramIterable, "$this$collectionSizeOrDefault");
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
    AppMethodBeat.i(188707);
    p.h(paramIterable1, "$this$convertToSetForSetOperationWith");
    p.h(paramIterable2, "source");
    if ((paramIterable1 instanceof Set))
    {
      paramIterable1 = (Collection)paramIterable1;
      AppMethodBeat.o(188707);
      return paramIterable1;
    }
    if ((paramIterable1 instanceof Collection))
    {
      if (((paramIterable2 instanceof Collection)) && (((Collection)paramIterable2).size() < 2))
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(188707);
        return paramIterable1;
      }
      paramIterable2 = (Collection)paramIterable1;
      if ((paramIterable2.size() > 2) && ((paramIterable2 instanceof ArrayList))) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(188707);
        return paramIterable1;
      }
    }
    paramIterable1 = (Collection)j.k(paramIterable1);
    AppMethodBeat.o(188707);
    return paramIterable1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.m
 * JD-Core Version:    0.7.0.1
 */