package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.a;
import d.e.b;
import d.g.b.k;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c
{
  public static final c Njf = a.gko();
  public static final a Njg = a.Nji;
  public static final b Njh = new b((byte)0);
  
  static
  {
    a locala = b.Niy;
  }
  
  public abstract int ajU(int paramInt);
  
  public double nextDouble()
  {
    int i = ajU(26);
    int j = ajU(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.S(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
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
        k localk = k.NiO;
        d = Math.nextAfter(paramDouble2, k.gky());
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
    return ajU(32);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.S(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = ajU(31 - Integer.numberOfLeadingZeros(i));
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
  public static final class a
    extends c
  {
    public static final a Nji;
    
    static
    {
      AppMethodBeat.i(129567);
      Nji = new a();
      AppMethodBeat.o(129567);
    }
    
    public final int ajU(int paramInt)
    {
      AppMethodBeat.i(129566);
      paramInt = c.Njf.ajU(paramInt);
      AppMethodBeat.o(129566);
      return paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
  public static final class b
    extends c
  {
    public final int ajU(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.Njf.ajU(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final double nextDouble()
    {
      AppMethodBeat.i(129563);
      double d = c.Njf.nextDouble();
      AppMethodBeat.o(129563);
      return d;
    }
    
    public final double nextDouble(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.Njf.nextDouble(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
    
    public final int nextInt()
    {
      AppMethodBeat.i(129561);
      int i = c.Njf.nextInt();
      AppMethodBeat.o(129561);
      return i;
    }
    
    public final int nextInt(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.Njf.nextInt(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.c
 * JD-Core Version:    0.7.0.1
 */