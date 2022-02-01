package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.e.a;
import kotlin.e.b;
import kotlin.g.b.k;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c
{
  public static final c SYN = a.hxN();
  public static final a SYO = a.SYQ;
  public static final b SYP = new b((byte)0);
  
  static
  {
    a locala = b.SYe;
  }
  
  public abstract int atK(int paramInt);
  
  public double nextDouble()
  {
    int i = atK(26);
    int j = atK(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.V(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
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
        d = nextDouble() * (paramDouble2 / 2.0D - paramDouble1 / 2.0D);
      }
    }
    label164:
    label170:
    for (paramDouble1 = d + (paramDouble1 + d);; paramDouble1 = nextDouble() * d + paramDouble1)
    {
      d = paramDouble1;
      if (paramDouble1 >= paramDouble2)
      {
        k localk = k.SYw;
        d = Math.nextAfter(paramDouble2, k.hxX());
      }
      return d;
      i = 0;
      break;
      i = 0;
      break label101;
    }
  }
  
  public int nextInt()
  {
    return atK(32);
  }
  
  public int nextInt(int paramInt)
  {
    return nextInt(0, paramInt);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.V(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = atK(31 - Integer.numberOfLeadingZeros(i));
      }
      for (;;)
      {
        return paramInt2 + paramInt1;
        int j;
        do
        {
          j = nextInt() >>> 1;
          paramInt2 = j % i;
        } while (j - paramInt2 + (i - 1) < 0);
      }
    }
    do
    {
      i = nextInt();
    } while ((paramInt1 > i) || (paramInt2 <= i));
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
  public static final class a
    extends c
  {
    public static final a SYQ;
    
    static
    {
      AppMethodBeat.i(129567);
      SYQ = new a();
      AppMethodBeat.o(129567);
    }
    
    public final int atK(int paramInt)
    {
      AppMethodBeat.i(129566);
      paramInt = c.SYN.atK(paramInt);
      AppMethodBeat.o(129566);
      return paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
  public static final class b
    extends c
  {
    public final int atK(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.SYN.atK(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final double nextDouble()
    {
      AppMethodBeat.i(258673);
      double d = c.SYN.nextDouble();
      AppMethodBeat.o(258673);
      return d;
    }
    
    public final double nextDouble(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.SYN.nextDouble(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
    
    public final int nextInt()
    {
      AppMethodBeat.i(258672);
      int i = c.SYN.nextInt();
      AppMethodBeat.o(258672);
      return i;
    }
    
    public final int nextInt(int paramInt)
    {
      AppMethodBeat.i(206232);
      paramInt = c.SYN.nextInt(paramInt);
      AppMethodBeat.o(206232);
      return paramInt;
    }
    
    public final int nextInt(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.SYN.nextInt(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.j.c
 * JD-Core Version:    0.7.0.1
 */