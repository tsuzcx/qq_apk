package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"})
public final class i
{
  private static final Object[] gKK = new Object[0];
  
  public static final Object[] a(Collection<?> paramCollection, Object[] paramArrayOfObject)
  {
    int i = 0;
    AppMethodBeat.i(129342);
    p.h(paramCollection, "collection");
    if (paramArrayOfObject == null)
    {
      paramCollection = (Throwable)new NullPointerException();
      AppMethodBeat.o(129342);
      throw paramCollection;
    }
    int j = paramCollection.size();
    if (j == 0)
    {
      if (paramArrayOfObject.length > 0) {
        paramArrayOfObject[0] = null;
      }
      AppMethodBeat.o(129342);
      return paramArrayOfObject;
    }
    Iterator localIterator = paramCollection.iterator();
    if (!localIterator.hasNext())
    {
      if (paramArrayOfObject.length > 0) {
        paramArrayOfObject[0] = null;
      }
      AppMethodBeat.o(129342);
      return paramArrayOfObject;
    }
    if (j <= paramArrayOfObject.length) {
      paramCollection = paramArrayOfObject;
    }
    for (;;)
    {
      j = i + 1;
      paramCollection[i] = localIterator.next();
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext())
        {
          AppMethodBeat.o(129342);
          return paramCollection;
          paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
          if (paramCollection == null)
          {
            paramCollection = new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            AppMethodBeat.o(129342);
            throw paramCollection;
          }
          paramCollection = (Object[])paramCollection;
        }
        else
        {
          int k = j * 3 + 1 >>> 1;
          i = k;
          if (k <= j)
          {
            if (j >= 2147483645)
            {
              paramCollection = (Throwable)new OutOfMemoryError();
              AppMethodBeat.o(129342);
              throw paramCollection;
            }
            i = 2147483645;
          }
          paramCollection = Arrays.copyOf(paramCollection, i);
          p.g(paramCollection, "Arrays.copyOf(result, newSize)");
          i = j;
        }
      }
      else
      {
        if (!localIterator.hasNext())
        {
          if (paramCollection == paramArrayOfObject)
          {
            paramArrayOfObject[j] = null;
            AppMethodBeat.o(129342);
            return paramArrayOfObject;
          }
          paramCollection = Arrays.copyOf(paramCollection, j);
          p.g(paramCollection, "Arrays.copyOf(result, size)");
          AppMethodBeat.o(129342);
          return paramCollection;
        }
        i = j;
      }
    }
  }
  
  public static final Object[] w(Collection<?> paramCollection)
  {
    AppMethodBeat.i(129341);
    p.h(paramCollection, "collection");
    int i = paramCollection.size();
    if (i == 0)
    {
      paramCollection = gKK;
      AppMethodBeat.o(129341);
      return paramCollection;
    }
    Iterator localIterator = paramCollection.iterator();
    if (!localIterator.hasNext())
    {
      paramCollection = gKK;
      AppMethodBeat.o(129341);
      return paramCollection;
    }
    paramCollection = new Object[i];
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext())
        {
          AppMethodBeat.o(129341);
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j)
        {
          if (j >= 2147483645)
          {
            paramCollection = (Throwable)new OutOfMemoryError();
            AppMethodBeat.o(129341);
            throw paramCollection;
          }
          i = 2147483645;
        }
        paramCollection = Arrays.copyOf(paramCollection, i);
        p.g(paramCollection, "Arrays.copyOf(result, newSize)");
        i = j;
      }
      else
      {
        if (!localIterator.hasNext())
        {
          paramCollection = Arrays.copyOf(paramCollection, j);
          p.g(paramCollection, "Arrays.copyOf(result, size)");
          AppMethodBeat.o(129341);
          return paramCollection;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.i
 * JD-Core Version:    0.7.0.1
 */