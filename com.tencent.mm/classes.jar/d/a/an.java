package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, fOb=1)
public class an
  extends am
{
  public static final <T> Set<T> a(Set<? extends T> paramSet, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129005);
    k.h(paramSet, "$this$plus");
    k.h(paramIterable, "elements");
    k.h(paramIterable, "$this$collectionSizeOrNull");
    Object localObject;
    if ((paramIterable instanceof Collection))
    {
      localObject = Integer.valueOf(((Collection)paramIterable).size());
      if (localObject == null) {
        break label109;
      }
    }
    label109:
    for (int i = ((Number)localObject).intValue() + paramSet.size();; i = paramSet.size() * 2)
    {
      localObject = new LinkedHashSet(ae.agH(i));
      ((LinkedHashSet)localObject).addAll((Collection)paramSet);
      j.a((Collection)localObject, paramIterable);
      paramSet = (Set)localObject;
      AppMethodBeat.o(129005);
      return paramSet;
      localObject = null;
      break;
    }
  }
  
  public static final <T> Set<T> c(Set<? extends T> paramSet, T paramT)
  {
    AppMethodBeat.i(129004);
    k.h(paramSet, "$this$plus");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(ae.agH(paramSet.size() + 1));
    localLinkedHashSet.addAll((Collection)paramSet);
    localLinkedHashSet.add(paramT);
    paramSet = (Set)localLinkedHashSet;
    AppMethodBeat.o(129004);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.an
 * JD-Core Version:    0.7.0.1
 */