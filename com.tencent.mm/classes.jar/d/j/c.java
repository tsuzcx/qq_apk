package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.a;
import d.e.b;
import d.g.b.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c
{
  public static final c JhC = a.fvI();
  public static final a JhD = a.JhF;
  public static final b JhE = new b((byte)0);
  
  static
  {
    a locala = b.Jhd;
  }
  
  public abstract int adN(int paramInt);
  
  public double nextDouble()
  {
    int i = adN(26);
    int j = adN(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.Q(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
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
        h localh = h.Jhq;
        d = Math.nextAfter(paramDouble2, h.fvS());
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
    return adN(32);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.Q(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = adN(31 - Integer.numberOfLeadingZeros(i));
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
  public static final class a
    extends c
  {
    public static final a JhF;
    
    static
    {
      AppMethodBeat.i(129567);
      JhF = new a();
      AppMethodBeat.o(129567);
    }
    
    public final int adN(int paramInt)
    {
      AppMethodBeat.i(129566);
      paramInt = c.JhC.adN(paramInt);
      AppMethodBeat.o(129566);
      return paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
  public static final class b
    extends c
  {
    public final int adN(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.JhC.adN(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final double nextDouble()
    {
      AppMethodBeat.i(129563);
      double d = c.JhC.nextDouble();
      AppMethodBeat.o(129563);
      return d;
    }
    
    public final double nextDouble(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.JhC.nextDouble(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
    
    public final int nextInt()
    {
      AppMethodBeat.i(129561);
      int i = c.JhC.nextInt();
      AppMethodBeat.o(129561);
      return i;
    }
    
    public final int nextInt(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.JhC.nextInt(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.j.c
 * JD-Core Version:    0.7.0.1
 */