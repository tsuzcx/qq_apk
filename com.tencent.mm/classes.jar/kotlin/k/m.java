package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.c;

@Metadata(d1={""}, d2={"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/ranges/RangesKt")
public class m
  extends l
{
  public static final long B(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(190917);
    if (paramLong2 > paramLong3)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + paramLong3 + " is less than minimum " + paramLong2 + '.');
      AppMethodBeat.o(190917);
      throw localThrowable;
    }
    if (paramLong1 < paramLong2)
    {
      AppMethodBeat.o(190917);
      return paramLong2;
    }
    if (paramLong1 > paramLong3)
    {
      AppMethodBeat.o(190917);
      return paramLong3;
    }
    AppMethodBeat.o(190917);
    return paramLong1;
  }
  
  public static final float C(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(190918);
    if (paramFloat2 > paramFloat3)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + paramFloat3 + " is less than minimum " + paramFloat2 + '.');
      AppMethodBeat.o(190918);
      throw localThrowable;
    }
    if (paramFloat1 < paramFloat2)
    {
      AppMethodBeat.o(190918);
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3)
    {
      AppMethodBeat.o(190918);
      return paramFloat3;
    }
    AppMethodBeat.o(190918);
    return paramFloat1;
  }
  
  public static final int a(g paramg, c paramc)
  {
    AppMethodBeat.i(190867);
    s.u(paramg, "$this$random");
    s.u(paramc, "random");
    try
    {
      s.u(paramc, "$this$nextInt");
      s.u(paramg, "range");
      if (paramg.isEmpty())
      {
        paramg = (Throwable)new IllegalArgumentException("Cannot get random in empty range: ".concat(String.valueOf(paramg)));
        AppMethodBeat.o(190867);
        throw paramg;
      }
    }
    catch (IllegalArgumentException paramg)
    {
      paramg = (Throwable)new NoSuchElementException(paramg.getMessage());
      AppMethodBeat.o(190867);
      throw paramg;
    }
    if (paramg.aixs < 2147483647)
    {
      i = paramc.qq(paramg.fIj, paramg.aixs + 1);
      AppMethodBeat.o(190867);
      return i;
    }
    if (paramg.fIj > -2147483648)
    {
      i = paramc.qq(paramg.fIj - 1, paramg.aixs);
      AppMethodBeat.o(190867);
      return i + 1;
    }
    int i = paramc.Zo();
    AppMethodBeat.o(190867);
    return i;
  }
  
  public static final e a(e parame, int paramInt)
  {
    AppMethodBeat.i(129307);
    s.u(parame, "$this$step");
    boolean bool;
    int i;
    int j;
    if (paramInt > 0)
    {
      bool = true;
      k.a(bool, (Number)Integer.valueOf(paramInt));
      e.a locala = e.aixt;
      i = parame.fIj;
      j = parame.aixs;
      if (parame.rBp <= 0) {
        break label72;
      }
    }
    for (;;)
    {
      parame = e.a.bP(i, j, paramInt);
      AppMethodBeat.o(129307);
      return parame;
      bool = false;
      break;
      label72:
      paramInt = -paramInt;
    }
  }
  
  public static final double aj(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 1.0D) {
      d = 1.0D;
    }
    return d;
  }
  
  public static final int bQ(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static final long bR(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final long bS(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static final float bt(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final float bu(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static final double c(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(190923);
    if (paramDouble2 > paramDouble3)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + paramDouble3 + " is less than minimum " + paramDouble2 + '.');
      AppMethodBeat.o(190923);
      throw localThrowable;
    }
    if (paramDouble1 < paramDouble2)
    {
      AppMethodBeat.o(190923);
      return paramDouble2;
    }
    if (paramDouble1 > paramDouble3)
    {
      AppMethodBeat.o(190923);
      return paramDouble3;
    }
    AppMethodBeat.o(190923);
    return paramDouble1;
  }
  
  public static final <T extends Comparable<? super T>> T d(T paramT1, T paramT2)
  {
    AppMethodBeat.i(190889);
    s.u(paramT1, "$this$coerceAtLeast");
    s.u(paramT2, "minimumValue");
    if (paramT1.compareTo(paramT2) < 0)
    {
      AppMethodBeat.o(190889);
      return paramT2;
    }
    AppMethodBeat.o(190889);
    return paramT1;
  }
  
  public static final e qs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190874);
    Object localObject = e.aixt;
    localObject = e.a.bP(paramInt1, paramInt2, -1);
    AppMethodBeat.o(190874);
    return localObject;
  }
  
  public static final g qt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129310);
    if (paramInt2 <= -2147483648)
    {
      localObject = g.aixx;
      localObject = g.klL();
      AppMethodBeat.o(129310);
      return localObject;
    }
    Object localObject = new g(paramInt1, paramInt2 - 1);
    AppMethodBeat.o(129310);
    return localObject;
  }
  
  public static final int qu(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static final int qv(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.k.m
 * JD-Core Version:    0.7.0.1
 */