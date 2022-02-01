package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.e.a;
import d.e.b;
import d.g.b.k;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c
{
  public static final c MMc = a.gfM();
  public static final a MMd = a.MMf;
  public static final b MMe = new b((byte)0);
  
  static
  {
    a locala = b.MLv;
  }
  
  public abstract int ajk(int paramInt);
  
  public double nextDouble()
  {
    int i = ajk(26);
    int j = ajk(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.T(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
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
        k localk = k.MLL;
        d = Math.nextAfter(paramDouble2, k.gfW());
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
    return ajk(32);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.T(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = ajk(31 - Integer.numberOfLeadingZeros(i));
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
  public static final class a
    extends c
  {
    public static final a MMf;
    
    static
    {
      AppMethodBeat.i(129567);
      MMf = new a();
      AppMethodBeat.o(129567);
    }
    
    public final int ajk(int paramInt)
    {
      AppMethodBeat.i(129566);
      paramInt = c.MMc.ajk(paramInt);
      AppMethodBeat.o(129566);
      return paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
  public static final class b
    extends c
  {
    public final int ajk(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.MMc.ajk(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final double nextDouble()
    {
      AppMethodBeat.i(129563);
      double d = c.MMc.nextDouble();
      AppMethodBeat.o(129563);
      return d;
    }
    
    public final double nextDouble(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.MMc.nextDouble(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
    
    public final int nextInt()
    {
      AppMethodBeat.i(129561);
      int i = c.MMc.nextInt();
      AppMethodBeat.o(129561);
      return i;
    }
    
    public final int nextInt(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.MMc.nextInt(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.c
 * JD-Core Version:    0.7.0.1
 */