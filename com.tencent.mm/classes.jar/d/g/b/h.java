package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()D", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"})
public final class h
{
  public static final h Jhq;
  private static final double MAX_VALUE = 1.7976931348623157E+308D;
  private static final double MIN_VALUE = 4.9E-324D;
  private static final double NEGATIVE_INFINITY = (-1.0D / 0.0D);
  private static final double NaN = (0.0D / 0.0D);
  private static final double POSITIVE_INFINITY = (1.0D / 0.0D);
  
  static
  {
    AppMethodBeat.i(129343);
    Jhq = new h();
    MIN_VALUE = 4.9E-324D;
    MAX_VALUE = 1.7976931348623157E+308D;
    POSITIVE_INFINITY = (1.0D / 0.0D);
    NEGATIVE_INFINITY = (-1.0D / 0.0D);
    NaN = (0.0D / 0.0D);
    AppMethodBeat.o(129343);
  }
  
  public static double fvS()
  {
    return NEGATIVE_INFINITY;
  }
  
  public static double fvT()
  {
    return NaN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.h
 * JD-Core Version:    0.7.0.1
 */