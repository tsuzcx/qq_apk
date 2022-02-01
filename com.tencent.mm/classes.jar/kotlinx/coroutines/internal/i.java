package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.ap;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "plus", "element", "plus-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlinx-coroutines-core"})
public final class i<E>
{
  public static final Object S(Object paramObject, E paramE)
  {
    AppMethodBeat.i(205068);
    if (ap.iRg())
    {
      if (!(paramE instanceof List)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(205068);
        throw paramObject;
      }
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(205068);
      return paramE;
    }
    if ((paramObject instanceof ArrayList))
    {
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
        AppMethodBeat.o(205068);
        throw paramObject;
      }
      ((ArrayList)paramObject).add(paramE);
      AppMethodBeat.o(205068);
      return paramObject;
    }
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(paramObject);
    localArrayList.add(paramE);
    AppMethodBeat.o(205068);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.i
 * JD-Core Version:    0.7.0.1
 */