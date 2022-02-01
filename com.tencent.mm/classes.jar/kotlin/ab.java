package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.n.a;

@Metadata(d1={""}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ab
  implements Comparable<ab>
{
  public static final ab.a aiuS;
  public final long data;
  
  static
  {
    AppMethodBeat.i(190778);
    aiuS = new ab.a((byte)0);
    AppMethodBeat.o(190778);
  }
  
  public static int I(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.data;
    return ((paramObject instanceof ab)) && (l == ((ab)paramObject).data);
  }
  
  public final int hashCode()
  {
    long l = this.data;
    return (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190791);
    long l1 = this.data;
    if (l1 >= 0L)
    {
      localObject = Long.toString(l1, a.aMy(10));
      s.s(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      AppMethodBeat.o(190791);
      return localObject;
    }
    long l3 = (l1 >>> 1) / 10L << 1;
    long l4 = l1 - l3 * 10L;
    long l2 = l4;
    l1 = l3;
    if (l4 >= 10L)
    {
      l2 = l4 - 10L;
      l1 = l3 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(l1, a.aMy(10));
    s.s(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = ((StringBuilder)localObject).append(str);
    str = Long.toString(l2, a.aMy(10));
    s.s(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = str;
    AppMethodBeat.o(190791);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.ab
 * JD-Core Version:    0.7.0.1
 */