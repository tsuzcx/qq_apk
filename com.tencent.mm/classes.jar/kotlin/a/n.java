package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEqualsNullable", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepHashCodeNullable", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringNullable", "contentEquals", "contentEqualsNullable", "contentHashCode", "contentHashCodeNullable", "contentToString", "contentToStringNullable", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "([Ljava/lang/Comparable;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/ArraysKt")
public class n
  extends m
{
  public static final List<Float> C(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(191137);
    s.u(paramArrayOfFloat, "$this$asList");
    paramArrayOfFloat = (List)new n.b(paramArrayOfFloat);
    AppMethodBeat.o(191137);
    return paramArrayOfFloat;
  }
  
  public static final <T> List<T> V(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129130);
    s.u(paramArrayOfT, "$this$asList");
    paramArrayOfT = Arrays.asList(paramArrayOfT);
    s.s(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    AppMethodBeat.o(129130);
    return paramArrayOfT;
  }
  
  public static final <T> void W(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129135);
    s.u(paramArrayOfT, "$this$sort");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT);
    }
    AppMethodBeat.o(129135);
  }
  
  public static final List<Integer> Y(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(129131);
    s.u(paramArrayOfInt, "$this$asList");
    paramArrayOfInt = (List)new n.a(paramArrayOfInt);
    AppMethodBeat.o(129131);
    return paramArrayOfInt;
  }
  
  public static final <T> void a(T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191204);
    s.u(paramArrayOfT, "$this$fill");
    Arrays.fill(paramArrayOfT, paramInt1, paramInt2, paramT);
    AppMethodBeat.o(191204);
  }
  
  public static final <T> void a(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129136);
    s.u(paramArrayOfT, "$this$sortWith");
    s.u(paramComparator, "comparator");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT, paramComparator);
    }
    AppMethodBeat.o(129136);
  }
  
  public static final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191152);
    s.u(paramArrayOfByte1, "$this$copyInto");
    s.u(paramArrayOfByte2, "destination");
    System.arraycopy(paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramInt1, paramInt3 - paramInt2);
    AppMethodBeat.o(191152);
    return paramArrayOfByte2;
  }
  
  public static final float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191196);
    s.u(paramArrayOfFloat, "$this$copyOfRangeImpl");
    k.qm(paramInt2, paramArrayOfFloat.length);
    paramArrayOfFloat = Arrays.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    s.s(paramArrayOfFloat, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    AppMethodBeat.o(191196);
    return paramArrayOfFloat;
  }
  
  public static final float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt)
  {
    AppMethodBeat.i(191170);
    s.u(paramArrayOfFloat1, "$this$copyInto");
    s.u(paramArrayOfFloat2, "destination");
    System.arraycopy(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramInt + 0);
    AppMethodBeat.o(191170);
    return paramArrayOfFloat2;
  }
  
  public static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191159);
    s.u(paramArrayOfInt1, "$this$copyInto");
    s.u(paramArrayOfInt2, "destination");
    System.arraycopy(paramArrayOfInt1, paramInt2, paramArrayOfInt2, paramInt1, paramInt3 - paramInt2);
    AppMethodBeat.o(191159);
    return paramArrayOfInt2;
  }
  
  public static final <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191142);
    s.u(paramArrayOfT1, "$this$copyInto");
    s.u(paramArrayOfT2, "destination");
    System.arraycopy(paramArrayOfT1, paramInt2, paramArrayOfT2, paramInt1, paramInt3 - paramInt2);
    AppMethodBeat.o(191142);
    return paramArrayOfT2;
  }
  
  public static final <T> T[] c(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(191235);
    s.u(paramArrayOfT, "$this$plus");
    int i = paramArrayOfT.length;
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, i + 1);
    paramArrayOfT[i] = paramT;
    s.s(paramArrayOfT, "result");
    AppMethodBeat.o(191235);
    return paramArrayOfT;
  }
  
  public static final byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191190);
    s.u(paramArrayOfByte, "$this$copyOfRangeImpl");
    k.qm(paramInt2, paramArrayOfByte.length);
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    s.s(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    AppMethodBeat.o(191190);
    return paramArrayOfByte;
  }
  
  public static final <T> T[] e(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129132);
    s.u(paramArrayOfT, "$this$copyOfRangeImpl");
    k.qm(paramInt2, paramArrayOfT.length);
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    s.s(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    AppMethodBeat.o(129132);
    return paramArrayOfT;
  }
  
  public static final void m(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191218);
    s.u(paramArrayOfInt, "$this$fill");
    Arrays.fill(paramArrayOfInt, 0, paramInt2, paramInt1);
    AppMethodBeat.o(191218);
  }
  
  public static final byte[] u(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(191251);
    s.u(paramArrayOfByte1, "$this$plus");
    s.u(paramArrayOfByte2, "elements");
    int i = paramArrayOfByte2.length;
    paramArrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, i + 12);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 12, i);
    s.s(paramArrayOfByte1, "result");
    AppMethodBeat.o(191251);
    return paramArrayOfByte1;
  }
  
  public static final int[] z(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(191242);
    s.u(paramArrayOfInt, "$this$plus");
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, i + 1);
    paramArrayOfInt[i] = paramInt;
    s.s(paramArrayOfInt, "result");
    AppMethodBeat.o(191242);
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.n
 * JD-Core Version:    0.7.0.1
 */