package d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"absoluteValue", "", "absoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "sign$annotations", "getSign", "(J)I", "ulp", "ulp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, gkc=1)
public class c
  extends b
{
  public static final long K(double paramDouble)
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
  
  public static final int cm(float paramFloat)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.h.c
 * JD-Core Version:    0.7.0.1
 */