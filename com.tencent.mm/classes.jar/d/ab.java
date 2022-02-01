package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.n.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"})
public final class ab
{
  public static final String Ft(long paramLong)
  {
    AppMethodBeat.i(199630);
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, a.aly(10));
      p.g(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      AppMethodBeat.o(199630);
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
    String str = Long.toString(paramLong, a.aly(10));
    p.g(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = ((StringBuilder)localObject).append(str);
    str = Long.toString(l1, a.aly(10));
    p.g(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = str;
    AppMethodBeat.o(199630);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.ab
 * JD-Core Version:    0.7.0.1
 */