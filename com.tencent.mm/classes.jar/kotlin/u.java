package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"})
public final class u
  implements Comparable<u>
{
  public static final a aazL;
  
  static
  {
    AppMethodBeat.i(217137);
    aazL = new a((byte)0);
    AppMethodBeat.o(217137);
  }
  
  public static String Xs(long paramLong)
  {
    AppMethodBeat.i(292755);
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, a.aFL(10));
      p.j(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      AppMethodBeat.o(292755);
      return localObject;
    }
    long l2 = (paramLong >>> 1) / 10L << 1;
    long l3 = paramLong - l2 * 10L;
    long l1 = l3;
    paramLong = l2;
    if (l3 >= 10L)
    {
      l1 = l3 - 10L;
      paramLong = l2 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(paramLong, a.aFL(10));
    p.j(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = ((StringBuilder)localObject).append(str);
    str = Long.toString(l1, a.aFL(10));
    p.j(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = str;
    AppMethodBeat.o(292755);
    return localObject;
  }
  
  public static long Xt(long paramLong)
  {
    return paramLong;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.u
 * JD-Core Version:    0.7.0.1
 */