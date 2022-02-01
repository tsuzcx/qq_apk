package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.g.a.b;
import kotlin.g.b.ag;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "shuffle", "random", "Lkotlin/random/Random;", "shuffled", "", "kotlin-stdlib"}, iBN=1)
public class q
  extends p
{
  public static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(219256);
    kotlin.g.b.p.k(paramIterable, "$this$removeAll");
    kotlin.g.b.p.k(paramb, "predicate");
    boolean bool = a(paramIterable, paramb, true);
    AppMethodBeat.o(219256);
    return bool;
  }
  
  private static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(129121);
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    if (paramIterable.hasNext())
    {
      if (((Boolean)paramb.invoke(paramIterable.next())).booleanValue() != paramBoolean) {
        break label63;
      }
      paramIterable.remove();
      bool = true;
    }
    label63:
    for (;;)
    {
      break;
      AppMethodBeat.o(129121);
      return bool;
    }
  }
  
  public static final <T> boolean a(Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129119);
    kotlin.g.b.p.k(paramCollection, "$this$addAll");
    kotlin.g.b.p.k(paramIterable, "elements");
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
    kotlin.g.b.p.k(paramCollection, "$this$addAll");
    kotlin.g.b.p.k(paramArrayOfT, "elements");
    boolean bool = paramCollection.addAll((Collection)e.Q(paramArrayOfT));
    AppMethodBeat.o(168694);
    return bool;
  }
  
  public static final <T> boolean b(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129120);
    kotlin.g.b.p.k(paramIterable, "$this$retainAll");
    kotlin.g.b.p.k(paramb, "predicate");
    boolean bool = a(paramIterable, paramb, false);
    AppMethodBeat.o(129120);
    return bool;
  }
  
  public static final <T> boolean c(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129122);
    kotlin.g.b.p.k(paramList, "$this$removeAll");
    kotlin.g.b.p.k(paramb, "predicate");
    boolean bool = d(paramList, paramb);
    AppMethodBeat.o(129122);
    return bool;
  }
  
  private static final <T> boolean d(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129123);
    if (!(paramList instanceof RandomAccess))
    {
      if (paramList == null)
      {
        paramList = new t("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        AppMethodBeat.o(129123);
        throw paramList;
      }
      boolean bool = a(ag.fa(paramList), paramb, true);
      AppMethodBeat.o(129123);
      return bool;
    }
    int m = j.lk(paramList);
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
      i = j.lk(paramList);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.q
 * JD-Core Version:    0.7.0.1
 */