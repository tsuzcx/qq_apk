package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"})
public final class z
{
  public static final String Pd(long paramLong)
  {
    AppMethodBeat.i(206287);
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, a.avR(10));
      p.g(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      AppMethodBeat.o(206287);
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
    String str = Long.toString(paramLong, a.avR(10));
    p.g(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = ((StringBuilder)localObject).append(str);
    str = Long.toString(l1, a.avR(10));
    p.g(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = str;
    AppMethodBeat.o(206287);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.z
 * JD-Core Version:    0.7.0.1
 */