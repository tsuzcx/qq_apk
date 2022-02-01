package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "plus", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class m<E>
{
  public static final Object ag(Object paramObject, E paramE)
  {
    AppMethodBeat.i(189417);
    if (au.ASSERTIONS_ENABLED)
    {
      if (!(paramE instanceof List)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = new AssertionError();
        AppMethodBeat.o(189417);
        throw paramObject;
      }
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(189417);
      return paramE;
    }
    if ((paramObject instanceof ArrayList))
    {
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        AppMethodBeat.o(189417);
        throw paramObject;
      }
      ((ArrayList)paramObject).add(paramE);
      AppMethodBeat.o(189417);
      return paramObject;
    }
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(paramObject);
    localArrayList.add(paramE);
    AppMethodBeat.o(189417);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.m
 * JD-Core Version:    0.7.0.1
 */