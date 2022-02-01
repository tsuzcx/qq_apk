package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()D", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"})
public final class k
{
  private static final double MAX_VALUE = 1.7976931348623157E+308D;
  private static final double MIN_VALUE = 4.9E-324D;
  private static final double NEGATIVE_INFINITY = (-1.0D / 0.0D);
  private static final double NaN = (0.0D / 0.0D);
  private static final double POSITIVE_INFINITY = (1.0D / 0.0D);
  public static final k SYw;
  
  static
  {
    AppMethodBeat.i(129343);
    SYw = new k();
    MIN_VALUE = 4.9E-324D;
    MAX_VALUE = 1.7976931348623157E+308D;
    POSITIVE_INFINITY = (1.0D / 0.0D);
    NEGATIVE_INFINITY = (-1.0D / 0.0D);
    NaN = (0.0D / 0.0D);
    AppMethodBeat.o(129343);
  }
  
  public static double hxX()
  {
    return NEGATIVE_INFINITY;
  }
  
  public static double hxY()
  {
    return NaN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.k
 * JD-Core Version:    0.7.0.1
 */