package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"})
public final class d
{
  public static final String N(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(129569);
    p.k(paramObject1, "from");
    p.k(paramObject2, "until");
    paramObject1 = "Random range is empty: [" + paramObject1 + ", " + paramObject2 + ").";
    AppMethodBeat.o(129569);
    return paramObject1;
  }
  
  public static final c Xv(long paramLong)
  {
    AppMethodBeat.i(129568);
    c localc = (c)new e((int)paramLong, (int)(paramLong >> 32));
    AppMethodBeat.o(129568);
    return localc;
  }
  
  public static final int ot(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.j.d
 * JD-Core Version:    0.7.0.1
 */