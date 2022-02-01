package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, hxG=1)
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
    AppMethodBeat.i(206261);
    p.h(paramIterable1, "$this$convertToSetForSetOperationWith");
    p.h(paramIterable2, "source");
    if ((paramIterable1 instanceof Set))
    {
      paramIterable1 = (Collection)paramIterable1;
      AppMethodBeat.o(206261);
      return paramIterable1;
    }
    if ((paramIterable1 instanceof Collection))
    {
      if (((paramIterable2 instanceof Collection)) && (((Collection)paramIterable2).size() < 2))
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(206261);
        return paramIterable1;
      }
      paramIterable2 = (Collection)paramIterable1;
      if ((paramIterable2.size() > 2) && ((paramIterable2 instanceof ArrayList))) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramIterable1 = (Collection)paramIterable1;
        AppMethodBeat.o(206261);
        return paramIterable1;
      }
    }
    paramIterable1 = (Collection)j.o(paramIterable1);
    AppMethodBeat.o(206261);
    return paramIterable1;
  }
  
  public static final <T> Integer d(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(206260);
    p.h(paramIterable, "$this$collectionSizeOrNull");
    if ((paramIterable instanceof Collection))
    {
      int i = ((Collection)paramIterable).size();
      AppMethodBeat.o(206260);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(206260);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.m
 * JD-Core Version:    0.7.0.1
 */