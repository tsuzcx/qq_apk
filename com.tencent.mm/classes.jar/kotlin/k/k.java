package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, iBN=1)
public class k
  extends j
{
  public static final int a(e parame, kotlin.j.c paramc)
  {
    AppMethodBeat.i(217148);
    p.k(parame, "$this$random");
    p.k(paramc, "random");
    try
    {
      p.k(paramc, "$this$nextInt");
      p.k(parame, "range");
      if (parame.isEmpty())
      {
        parame = (Throwable)new IllegalArgumentException("Cannot get random in empty range: ".concat(String.valueOf(parame)));
        AppMethodBeat.o(217148);
        throw parame;
      }
    }
    catch (IllegalArgumentException parame)
    {
      parame = (Throwable)new NoSuchElementException(parame.getMessage());
      AppMethodBeat.o(217148);
      throw parame;
    }
    if (parame.aaBQ < 2147483647)
    {
      i = paramc.os(parame.dHa, parame.aaBQ + 1);
      AppMethodBeat.o(217148);
      return i;
    }
    if (parame.dHa > -2147483648)
    {
      i = paramc.os(parame.dHa - 1, parame.aaBQ);
      AppMethodBeat.o(217148);
      return i + 1;
    }
    int i = paramc.zD();
    AppMethodBeat.o(217148);
    return i;
  }
  
  public static final c a(c paramc, int paramInt)
  {
    AppMethodBeat.i(129307);
    p.k(paramc, "$this$step");
    boolean bool;
    int i;
    int j;
    if (paramInt > 0)
    {
      bool = true;
      i.a(bool, (Number)Integer.valueOf(paramInt));
      c.a locala = c.aaBR;
      i = paramc.dHa;
      j = paramc.aaBQ;
      if (paramc.oxQ <= 0) {
        break label72;
      }
    }
    for (;;)
    {
      paramc = c.a.bl(i, j, paramInt);
      AppMethodBeat.o(129307);
      return paramc;
      bool = false;
      break;
      label72:
      paramInt = -paramInt;
    }
  }
  
  public static final f a(f paramf, long paramLong)
  {
    AppMethodBeat.i(129308);
    p.k(paramf, "$this$step");
    boolean bool;
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      bool = true;
      i.a(bool, (Number)Long.valueOf(paramLong));
      f.a locala = f.aaBX;
      l1 = paramf.first;
      l2 = paramf.aaBW;
      if (paramf.HIt <= 0L) {
        break label78;
      }
    }
    for (;;)
    {
      paramf = f.a.w(l1, l2, paramLong);
      AppMethodBeat.o(129308);
      return paramf;
      bool = false;
      break;
      label78:
      paramLong = -paramLong;
    }
  }
  
  public static final float aP(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final float aQ(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final long be(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final long bf(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final int bm(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static final e ou(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129310);
    if (paramInt2 <= -2147483648)
    {
      localObject = e.aaBV;
      localObject = e.iCu();
      AppMethodBeat.o(129310);
      return localObject;
    }
    Object localObject = new e(paramInt1, paramInt2 - 1);
    AppMethodBeat.o(129310);
    return localObject;
  }
  
  public static final int ov(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static final int ow(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.k.k
 * JD-Core Version:    0.7.0.1
 */