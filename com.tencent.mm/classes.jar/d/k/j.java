package d.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, fvw=1)
public class j
  extends i
{
  public static final b a(b paramb, int paramInt)
  {
    AppMethodBeat.i(129307);
    k.h(paramb, "$this$step");
    boolean bool;
    int i;
    int j;
    if (paramInt > 0)
    {
      bool = true;
      h.a(bool, (Number)Integer.valueOf(paramInt));
      b.a locala = b.JhJ;
      i = paramb.JhH;
      j = paramb.JhI;
      if (paramb.jzV <= 0) {
        break label72;
      }
    }
    for (;;)
    {
      paramb = b.a.aW(i, j, paramInt);
      AppMethodBeat.o(129307);
      return paramb;
      bool = false;
      break;
      label72:
      paramInt = -paramInt;
    }
  }
  
  public static final e a(e parame, long paramLong)
  {
    AppMethodBeat.i(129308);
    k.h(parame, "$this$step");
    boolean bool;
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      bool = true;
      h.a(bool, (Number)Long.valueOf(paramLong));
      e.a locala = e.JhQ;
      l1 = parame.first;
      l2 = parame.JhP;
      if (parame.vfC <= 0L) {
        break label78;
      }
    }
    for (;;)
    {
      parame = e.a.t(l1, l2, paramLong);
      AppMethodBeat.o(129308);
      return parame;
      bool = false;
      break;
      label78:
      paramLong = -paramLong;
    }
  }
  
  public static final boolean a(a<Integer> parama, float paramFloat)
  {
    AppMethodBeat.i(129306);
    k.h(parama, "$this$contains");
    Integer localInteger = h.bV(paramFloat);
    if (localInteger != null)
    {
      boolean bool = parama.contains((Comparable)localInteger);
      AppMethodBeat.o(129306);
      return bool;
    }
    AppMethodBeat.o(129306);
    return false;
  }
  
  public static final long aC(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final long aH(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final int aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129311);
    if (paramInt2 > paramInt3)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + paramInt3 + " is less than minimum " + paramInt2 + '.');
      AppMethodBeat.o(129311);
      throw localThrowable;
    }
    if (paramInt1 < paramInt2)
    {
      AppMethodBeat.o(129311);
      return paramInt2;
    }
    if (paramInt1 > paramInt3)
    {
      AppMethodBeat.o(129311);
      return paramInt3;
    }
    AppMethodBeat.o(129311);
    return paramInt1;
  }
  
  public static final float ar(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final Integer bV(float paramFloat)
  {
    AppMethodBeat.i(129309);
    if ((paramFloat >= -2.147484E+009F) && (paramFloat <= 2.147484E+009F))
    {
      int i = (int)paramFloat;
      AppMethodBeat.o(129309);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(129309);
    return null;
  }
  
  public static final d kJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129310);
    if (paramInt2 <= -2147483648)
    {
      localObject = d.JhO;
      localObject = d.fwa();
      AppMethodBeat.o(129310);
      return localObject;
    }
    Object localObject = new d(paramInt1, paramInt2 - 1);
    AppMethodBeat.o(129310);
    return localObject;
  }
  
  public static final int kK(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static final int kL(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.k.j
 * JD-Core Version:    0.7.0.1
 */