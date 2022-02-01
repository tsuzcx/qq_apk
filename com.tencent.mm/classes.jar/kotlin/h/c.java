package kotlin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"absoluteValue", "", "absoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "sign$annotations", "getSign", "(J)I", "ulp", "ulp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, iBN=1)
public class c
  extends b
{
  public static final int M(double paramDouble)
  {
    AppMethodBeat.i(219316);
    if (Double.isNaN(paramDouble))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(219316);
      throw localThrowable;
    }
    if (paramDouble > 2147483647.0D)
    {
      AppMethodBeat.o(219316);
      return 2147483647;
    }
    if (paramDouble < -2147483648.0D)
    {
      AppMethodBeat.o(219316);
      return -2147483648;
    }
    int i = (int)Math.round(paramDouble);
    AppMethodBeat.o(219316);
    return i;
  }
  
  public static final long N(double paramDouble)
  {
    AppMethodBeat.i(129570);
    if (Double.isNaN(paramDouble))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(129570);
      throw localThrowable;
    }
    long l = Math.round(paramDouble);
    AppMethodBeat.o(129570);
    return l;
  }
  
  public static final int dm(float paramFloat)
  {
    AppMethodBeat.i(129571);
    if (Float.isNaN(paramFloat))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(129571);
      throw localThrowable;
    }
    int i = Math.round(paramFloat);
    AppMethodBeat.o(129571);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.h.c
 * JD-Core Version:    0.7.0.1
 */