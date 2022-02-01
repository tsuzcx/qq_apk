package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.a;
import kotlin.e.b;
import kotlin.g.b.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c
{
  private static final c aaBJ = a.iBV();
  public static final a aaBK = a.aaBM;
  public static final b aaBL = new b((byte)0);
  
  static
  {
    a locala = b.aaAQ;
  }
  
  public int Nz(int paramInt)
  {
    return os(0, paramInt);
  }
  
  public abstract int aDE(int paramInt);
  
  public int os(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.N(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = aDE(31 - Integer.numberOfLeadingZeros(i));
      }
      for (;;)
      {
        return paramInt2 + paramInt1;
        int j;
        do
        {
          j = zD() >>> 1;
          paramInt2 = j % i;
        } while (j - paramInt2 + (i - 1) < 0);
      }
    }
    do
    {
      i = zD();
    } while ((paramInt1 > i) || (paramInt2 <= i));
    return i;
  }
  
  public double v(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.N(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
    }
    double d = paramDouble2 - paramDouble1;
    if (Double.isInfinite(d)) {
      if ((!Double.isInfinite(paramDouble1)) && (!Double.isNaN(paramDouble1)))
      {
        i = 1;
        if (i == 0) {
          break label170;
        }
        if ((Double.isInfinite(paramDouble2)) || (Double.isNaN(paramDouble2))) {
          break label164;
        }
        i = j;
        label101:
        if (i == 0) {
          break label170;
        }
        d = zB() * (paramDouble2 / 2.0D - paramDouble1 / 2.0D);
      }
    }
    label164:
    label170:
    for (paramDouble1 = d + (paramDouble1 + d);; paramDouble1 = zB() * d + paramDouble1)
    {
      d = paramDouble1;
      if (paramDouble1 >= paramDouble2)
      {
        k localk = k.aaBn;
        d = Math.nextAfter(paramDouble2, k.iCi());
      }
      return d;
      i = 0;
      break;
      i = 0;
      break label101;
    }
  }
  
  public double zB()
  {
    int i = aDE(26);
    int j = aDE(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public long zC()
  {
    return (zD() << 32) + zD();
  }
  
  public int zD()
  {
    return aDE(32);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
  public static final class a
    extends c
  {
    public static final a aaBM;
    
    static
    {
      AppMethodBeat.i(129567);
      aaBM = new a();
      AppMethodBeat.o(129567);
    }
    
    public final int aDE(int paramInt)
    {
      AppMethodBeat.i(129566);
      paramInt = c.iCt().aDE(paramInt);
      AppMethodBeat.o(129566);
      return paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
  public static final class b
    extends c
  {
    public final int Nz(int paramInt)
    {
      AppMethodBeat.i(292757);
      paramInt = c.iCt().Nz(paramInt);
      AppMethodBeat.o(292757);
      return paramInt;
    }
    
    public final int aDE(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.iCt().aDE(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final int os(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.iCt().os(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
    
    public final double v(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.iCt().v(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
    
    public final double zB()
    {
      AppMethodBeat.i(129563);
      double d = c.iCt().zB();
      AppMethodBeat.o(129563);
      return d;
    }
    
    public final long zC()
    {
      AppMethodBeat.i(217565);
      long l = c.iCt().zC();
      AppMethodBeat.o(217565);
      return l;
    }
    
    public final int zD()
    {
      AppMethodBeat.i(292756);
      int i = c.iCt().zD();
      AppMethodBeat.o(292756);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.j.c
 * JD-Core Version:    0.7.0.1
 */