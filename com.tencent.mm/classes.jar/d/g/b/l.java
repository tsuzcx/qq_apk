package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/jvm/internal/FloatCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()F", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"})
public final class l
{
  private static final float MAX_VALUE = 3.4028235E+38F;
  private static final float MIN_VALUE = 1.4E-45F;
  private static final float NEGATIVE_INFINITY = (1.0F / -1.0F);
  private static final float NaN = (0.0F / 0.0F);
  public static final l NiP;
  private static final float POSITIVE_INFINITY = (1.0F / 1.0F);
  
  static
  {
    AppMethodBeat.i(188719);
    NiP = new l();
    MIN_VALUE = 1.4E-45F;
    MAX_VALUE = 3.4028235E+38F;
    POSITIVE_INFINITY = (1.0F / 1.0F);
    NEGATIVE_INFINITY = (1.0F / -1.0F);
    NaN = (0.0F / 0.0F);
    AppMethodBeat.o(188719);
  }
  
  public static float gkA()
  {
    return NEGATIVE_INFINITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.g.b.l
 * JD-Core Version:    0.7.0.1
 */