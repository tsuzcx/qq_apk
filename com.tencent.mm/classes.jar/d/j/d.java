package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"})
public final class d
{
  public static final c Fv(long paramLong)
  {
    AppMethodBeat.i(129568);
    c localc = (c)new e((int)paramLong, (int)(paramLong >> 32));
    AppMethodBeat.o(129568);
    return localc;
  }
  
  public static final String T(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(129569);
    p.h(paramObject1, "from");
    p.h(paramObject2, "until");
    paramObject1 = "Random range is empty: [" + paramObject1 + ", " + paramObject2 + ").";
    AppMethodBeat.o(129569);
    return paramObject1;
  }
  
  public static final int ln(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.d
 * JD-Core Version:    0.7.0.1
 */