package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"})
public final class d
{
  public static final String Q(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(129569);
    k.h(paramObject1, "from");
    k.h(paramObject2, "until");
    paramObject1 = "Random range is empty: [" + paramObject1 + ", " + paramObject2 + ").";
    AppMethodBeat.o(129569);
    return paramObject1;
  }
  
  public static final int kI(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
  
  public static final c xD(long paramLong)
  {
    AppMethodBeat.i(129568);
    c localc = (c)new e((int)paramLong, (int)(paramLong >> 32));
    AppMethodBeat.o(129568);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.j.d
 * JD-Core Version:    0.7.0.1
 */