package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, iBN=1)
public class u
  extends t
{
  public static final Float bHA(String paramString)
  {
    AppMethodBeat.i(129457);
    p.k(paramString, "$this$toFloatOrNull");
    for (;;)
    {
      try
      {
        if (!m.abvM.aY((CharSequence)paramString)) {
          continue;
        }
        float f = Float.parseFloat(paramString);
        paramString = Float.valueOf(f);
      }
      catch (NumberFormatException paramString)
      {
        paramString = null;
        continue;
      }
      AppMethodBeat.o(129457);
      return paramString;
      paramString = null;
    }
  }
  
  public static final Double bHB(String paramString)
  {
    AppMethodBeat.i(129458);
    p.k(paramString, "$this$toDoubleOrNull");
    for (;;)
    {
      try
      {
        if (!m.abvM.aY((CharSequence)paramString)) {
          continue;
        }
        double d = Double.parseDouble(paramString);
        paramString = Double.valueOf(d);
      }
      catch (NumberFormatException paramString)
      {
        paramString = null;
        continue;
      }
      AppMethodBeat.o(129458);
      return paramString;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.u
 * JD-Core Version:    0.7.0.1
 */