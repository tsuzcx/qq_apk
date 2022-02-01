package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class w
  extends v
{
  public static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(191010);
    s.u(paramIterable, "$this$removeAll");
    s.u(paramb, "predicate");
    boolean bool = b(paramIterable, paramb);
    AppMethodBeat.o(191010);
    return bool;
  }
  
  public static final <T> boolean a(Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129119);
    s.u(paramCollection, "$this$addAll");
    s.u(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      bool = paramCollection.addAll((Collection)paramIterable);
      AppMethodBeat.o(129119);
      return bool;
    }
    boolean bool = false;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (paramCollection.add(paramIterable.next())) {
        bool = true;
      }
    }
    AppMethodBeat.o(129119);
    return bool;
  }
  
  public static final <T> boolean a(Collection<? super T> paramCollection, T[] paramArrayOfT)
  {
    AppMethodBeat.i(168694);
    s.u(paramCollection, "$this$addAll");
    s.u(paramArrayOfT, "elements");
    boolean bool = paramCollection.addAll((Collection)k.V(paramArrayOfT));
    AppMethodBeat.o(168694);
    return bool;
  }
  
  private static final <T> boolean b(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(191013);
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    if (paramIterable.hasNext())
    {
      if (((Boolean)paramb.invoke(paramIterable.next())).booleanValue() != true) {
        break label63;
      }
      paramIterable.remove();
      bool = true;
    }
    label63:
    for (;;)
    {
      break;
      AppMethodBeat.o(191013);
      return bool;
    }
  }
  
  public static final <T> boolean e(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129122);
    s.u(paramList, "$this$removeAll");
    s.u(paramb, "predicate");
    boolean bool = f(paramList, paramb);
    AppMethodBeat.o(129122);
    return bool;
  }
  
  private static final <T> boolean f(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129123);
    if (!(paramList instanceof RandomAccess))
    {
      if (paramList == null)
      {
        paramList = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        AppMethodBeat.o(129123);
        throw paramList;
      }
      boolean bool = b(an.hy(paramList), paramb);
      AppMethodBeat.o(129123);
      return bool;
    }
    int m = p.oE(paramList);
    int i;
    if (m >= 0)
    {
      int k = 0;
      for (j = 0;; j = i)
      {
        Object localObject = paramList.get(k);
        i = j;
        if (((Boolean)paramb.invoke(localObject)).booleanValue() != true)
        {
          if (j != k) {
            paramList.set(j, localObject);
          }
          i = j + 1;
        }
        j = i;
        if (k == m) {
          break;
        }
        k += 1;
      }
    }
    int j = 0;
    if (j < paramList.size())
    {
      i = p.oE(paramList);
      if (i >= j) {
        for (;;)
        {
          paramList.remove(i);
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(129123);
      return true;
    }
    AppMethodBeat.o(129123);
    return false;
  }
  
  public static final <T> T oG(List<T> paramList)
  {
    AppMethodBeat.i(191021);
    s.u(paramList, "$this$removeFirstOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(191021);
      return null;
    }
    paramList = paramList.remove(0);
    AppMethodBeat.o(191021);
    return paramList;
  }
  
  public static final <T> T oH(List<T> paramList)
  {
    AppMethodBeat.i(191029);
    s.u(paramList, "$this$removeLastOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(191029);
      return null;
    }
    paramList = paramList.remove(p.oE(paramList));
    AppMethodBeat.o(191029);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.w
 * JD-Core Version:    0.7.0.1
 */