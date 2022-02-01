package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, hxG=1)
public class h
  extends g
{
  public static final List<Integer> W(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(129131);
    p.h(paramArrayOfInt, "$this$asList");
    paramArrayOfInt = (List)new a(paramArrayOfInt);
    AppMethodBeat.o(129131);
    return paramArrayOfInt;
  }
  
  public static final <T> void a(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129136);
    p.h(paramArrayOfT, "$this$sortWith");
    p.h(paramComparator, "comparator");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT, paramComparator);
    }
    AppMethodBeat.o(129136);
  }
  
  public static final float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt)
  {
    AppMethodBeat.i(206275);
    p.h(paramArrayOfFloat1, "$this$copyInto");
    p.h(paramArrayOfFloat2, "destination");
    System.arraycopy(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramInt + 0);
    AppMethodBeat.o(206275);
    return paramArrayOfFloat2;
  }
  
  public static final <T> List<T> asList(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129130);
    p.h(paramArrayOfT, "$this$asList");
    paramArrayOfT = Arrays.asList(paramArrayOfT);
    p.g(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    AppMethodBeat.o(129130);
    return paramArrayOfT;
  }
  
  public static final <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129132);
    p.h(paramArrayOfT, "$this$copyOfRangeImpl");
    int i = paramArrayOfT.length;
    if (paramInt2 > i)
    {
      paramArrayOfT = (Throwable)new IndexOutOfBoundsException("toIndex (" + paramInt2 + ") is greater than size (" + i + ").");
      AppMethodBeat.o(129132);
      throw paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    p.g(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    AppMethodBeat.o(129132);
    return paramArrayOfT;
  }
  
  public static final <T> void e(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(129133);
    p.h(paramArrayOfT, "$this$fill");
    Arrays.fill(paramArrayOfT, 0, paramInt, null);
    AppMethodBeat.o(129133);
  }
  
  public static final <T> void sort(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129135);
    p.h(paramArrayOfT, "$this$sort");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT);
    }
    AppMethodBeat.o(129135);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
  public static final class a
    extends b<Integer>
    implements RandomAccess
  {
    a(int[] paramArrayOfInt) {}
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(129237);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(129237);
        return false;
      }
      int i = ((Number)paramObject).intValue();
      boolean bool = e.contains(this.SXk, i);
      AppMethodBeat.o(129237);
      return bool;
    }
    
    public final int getSize()
    {
      return this.SXk.length;
    }
    
    public final int indexOf(Object paramObject)
    {
      AppMethodBeat.i(129239);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(129239);
        return -1;
      }
      int i = ((Number)paramObject).intValue();
      i = e.n(this.SXk, i);
      AppMethodBeat.o(129239);
      return i;
    }
    
    public final boolean isEmpty()
    {
      return this.SXk.length == 0;
    }
    
    public final int lastIndexOf(Object paramObject)
    {
      AppMethodBeat.i(129240);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(129240);
        return -1;
      }
      int j = ((Number)paramObject).intValue();
      paramObject = this.SXk;
      p.h(paramObject, "$this$lastIndexOf");
      int i = paramObject.length - 1;
      while (i >= 0)
      {
        if (j == paramObject[i])
        {
          AppMethodBeat.o(129240);
          return i;
        }
        i -= 1;
      }
      AppMethodBeat.o(129240);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.h
 * JD-Core Version:    0.7.0.1
 */