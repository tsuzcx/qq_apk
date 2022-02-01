package d;

import com.tencent.matrix.trace.core.AppMethodBeat;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"})
public final class w
  implements Comparable<w>
{
  public static final a Nhp;
  private final long data;
  
  static
  {
    AppMethodBeat.i(188701);
    Nhp = new a((byte)0);
    AppMethodBeat.o(188701);
  }
  
  public static String FT(long paramLong)
  {
    AppMethodBeat.i(224171);
    String str = ab.FV(paramLong);
    AppMethodBeat.o(224171);
    return str;
  }
  
  public static long FU(long paramLong)
  {
    return paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.data;
    return ((paramObject instanceof w)) && (l == ((w)paramObject).data);
  }
  
  public final int hashCode()
  {
    long l = this.data;
    return (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188699);
    String str = ab.FV(this.data);
    AppMethodBeat.o(188699);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.w
 * JD-Core Version:    0.7.0.1
 */