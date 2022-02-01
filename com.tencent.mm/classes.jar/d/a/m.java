package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.Collection;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, fOb=1)
public class m
  extends l
{
  public static final <T> int a(Iterable<? extends T> paramIterable, int paramInt)
  {
    AppMethodBeat.i(129232);
    k.h(paramIterable, "$this$collectionSizeOrDefault");
    if ((paramIterable instanceof Collection))
    {
      paramInt = ((Collection)paramIterable).size();
      AppMethodBeat.o(129232);
      return paramInt;
    }
    AppMethodBeat.o(129232);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.m
 * JD-Core Version:    0.7.0.1
 */