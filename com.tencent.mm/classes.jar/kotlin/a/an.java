package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, hxG=1)
public class an
  extends am
{
  public static final <T> Set<T> a(Set<? extends T> paramSet, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(206273);
    p.h(paramSet, "$this$minus");
    p.h(paramIterable, "elements");
    paramIterable = j.a(paramIterable, (Iterable)paramSet);
    if (paramIterable.isEmpty())
    {
      paramSet = j.r((Iterable)paramSet);
      AppMethodBeat.o(206273);
      return paramSet;
    }
    if ((paramIterable instanceof Set))
    {
      Object localObject1 = (Iterable)paramSet;
      paramSet = (Collection)new LinkedHashSet();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (!paramIterable.contains(localObject2)) {
          paramSet.add(localObject2);
        }
      }
      paramSet = (Set)paramSet;
      AppMethodBeat.o(206273);
      return paramSet;
    }
    paramSet = new LinkedHashSet((Collection)paramSet);
    paramSet.removeAll(paramIterable);
    paramSet = (Set)paramSet;
    AppMethodBeat.o(206273);
    return paramSet;
  }
  
  public static final <T> Set<T> b(Set<? extends T> paramSet, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129005);
    p.h(paramSet, "$this$plus");
    p.h(paramIterable, "elements");
    Object localObject = j.d(paramIterable);
    if (localObject != null) {}
    for (int i = ((Number)localObject).intValue() + paramSet.size();; i = paramSet.size() * 2)
    {
      localObject = new LinkedHashSet(ae.atJ(i));
      ((LinkedHashSet)localObject).addAll((Collection)paramSet);
      j.a((Collection)localObject, paramIterable);
      paramSet = (Set)localObject;
      AppMethodBeat.o(129005);
      return paramSet;
    }
  }
  
  public static final <T> Set<T> c(Set<? extends T> paramSet, T paramT)
  {
    AppMethodBeat.i(129004);
    p.h(paramSet, "$this$plus");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(ae.atJ(paramSet.size() + 1));
    localLinkedHashSet.addAll((Collection)paramSet);
    localLinkedHashSet.add(paramT);
    paramSet = (Set)localLinkedHashSet;
    AppMethodBeat.o(129004);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.an
 * JD-Core Version:    0.7.0.1
 */