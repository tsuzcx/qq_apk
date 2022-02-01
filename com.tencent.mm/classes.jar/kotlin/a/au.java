package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/SetsKt")
public class au
  extends at
{
  public static final <T> Set<T> a(Set<? extends T> paramSet, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191171);
    s.u(paramSet, "$this$minus");
    s.u(paramIterable, "elements");
    paramIterable = p.a(paramIterable, (Iterable)paramSet);
    if (paramIterable.isEmpty())
    {
      paramSet = p.r((Iterable)paramSet);
      AppMethodBeat.o(191171);
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
      AppMethodBeat.o(191171);
      return paramSet;
    }
    paramSet = new LinkedHashSet((Collection)paramSet);
    paramSet.removeAll(paramIterable);
    paramSet = (Set)paramSet;
    AppMethodBeat.o(191171);
    return paramSet;
  }
  
  public static final <T> Set<T> b(Set<? extends T> paramSet, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129005);
    s.u(paramSet, "$this$plus");
    s.u(paramIterable, "elements");
    Object localObject = p.d(paramIterable);
    if (localObject != null) {}
    for (int i = ((Number)localObject).intValue() + paramSet.size();; i = paramSet.size() * 2)
    {
      localObject = new LinkedHashSet(ak.aKi(i));
      ((LinkedHashSet)localObject).addAll((Collection)paramSet);
      p.a((Collection)localObject, paramIterable);
      paramSet = (Set)localObject;
      AppMethodBeat.o(129005);
      return paramSet;
    }
  }
  
  public static final <T> Set<T> c(Set<? extends T> paramSet, T paramT)
  {
    AppMethodBeat.i(129004);
    s.u(paramSet, "$this$plus");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(ak.aKi(paramSet.size() + 1));
    localLinkedHashSet.addAll((Collection)paramSet);
    localLinkedHashSet.add(paramT);
    paramSet = (Set)localLinkedHashSet;
    AppMethodBeat.o(129004);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.au
 * JD-Core Version:    0.7.0.1
 */