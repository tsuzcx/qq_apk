package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.a;
import kotlin.e.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class c
{
  private static final c aixk = b.aiwB.klk();
  public static final a aixl = new a((byte)0);
  
  public float OB()
  {
    return aKr(24) / 16777216.0F;
  }
  
  public int Pa(int paramInt)
  {
    return qq(0, paramInt);
  }
  
  public byte[] U(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    s.u(paramArrayOfByte, "array");
    int i = paramArrayOfByte.length;
    if (paramInt1 < 0) {}
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label108;
      }
      throw ((Throwable)new IllegalArgumentException(("fromIndex (" + paramInt1 + ") or toIndex (" + paramInt2 + ") are out of range: 0.." + paramArrayOfByte.length + '.').toString()));
      if (i < paramInt1) {
        break;
      }
      i = paramArrayOfByte.length;
      if ((paramInt2 < 0) || (i < paramInt2)) {
        break;
      }
    }
    label108:
    if (paramInt1 <= paramInt2) {}
    for (i = k; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("fromIndex (" + paramInt1 + ") must be not greater than toIndex (" + paramInt2 + ").").toString()));
    }
    k = (paramInt2 - paramInt1) / 4;
    i = 0;
    while (i < k)
    {
      int m = Zo();
      paramArrayOfByte[paramInt1] = ((byte)m);
      paramArrayOfByte[(paramInt1 + 1)] = ((byte)(m >>> 8));
      paramArrayOfByte[(paramInt1 + 2)] = ((byte)(m >>> 16));
      paramArrayOfByte[(paramInt1 + 3)] = ((byte)(m >>> 24));
      paramInt1 += 4;
      i += 1;
    }
    i = paramInt2 - paramInt1;
    k = aKr(i * 8);
    paramInt2 = j;
    while (paramInt2 < i)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k >>> paramInt2 * 8));
      paramInt2 += 1;
    }
    return paramArrayOfByte;
  }
  
  public double Zm()
  {
    int i = aKr(26);
    int j = aKr(27);
    long l = i;
    return (j + (l << 27)) / 9007199254740992.0D;
  }
  
  public long Zn()
  {
    return (Zo() << 32) + Zo();
  }
  
  public int Zo()
  {
    return aKr(32);
  }
  
  public abstract int aKr(int paramInt);
  
  public byte[] dG(byte[] paramArrayOfByte)
  {
    s.u(paramArrayOfByte, "array");
    return U(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int qq(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.Z(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
    i = paramInt2 - paramInt1;
    if ((i > 0) || (i == -2147483648))
    {
      if ((-i & i) == i) {
        paramInt2 = aKr(31 - Integer.numberOfLeadingZeros(i));
      }
      for (;;)
      {
        return paramInt2 + paramInt1;
        int j;
        do
        {
          j = Zo() >>> 1;
          paramInt2 = j % i;
        } while (j - paramInt2 + (i - 1) < 0);
      }
    }
    do
    {
      i = Zo();
    } while ((paramInt1 > i) || (paramInt2 <= i));
    return i;
  }
  
  public double y(double paramDouble1, double paramDouble2)
  {
    int j = 1;
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(d.Z(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
    }
    double d = paramDouble2 - paramDouble1;
    if (Double.isInfinite(d)) {
      if ((!Double.isInfinite(paramDouble1)) && (!Double.isNaN(paramDouble1)))
      {
        i = 1;
        if (i == 0) {
          break label165;
        }
        if ((Double.isInfinite(paramDouble2)) || (Double.isNaN(paramDouble2))) {
          break label159;
        }
        i = j;
        label101:
        if (i == 0) {
          break label165;
        }
        d = Zm() * (paramDouble2 / 2.0D - paramDouble1 / 2.0D);
      }
    }
    label159:
    label165:
    for (paramDouble1 = d + (paramDouble1 + d);; paramDouble1 = Zm() * d + paramDouble1)
    {
      d = paramDouble1;
      if (paramDouble1 >= paramDouble2) {
        d = Math.nextAfter(paramDouble2, (-1.0D / 0.0D));
      }
      return d;
      i = 0;
      break;
      i = 0;
      break label101;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    extends c
    implements Serializable
  {
    public final float OB()
    {
      AppMethodBeat.i(190919);
      float f = c.klI().OB();
      AppMethodBeat.o(190919);
      return f;
    }
    
    public final int Pa(int paramInt)
    {
      AppMethodBeat.i(369486);
      paramInt = c.klI().Pa(paramInt);
      AppMethodBeat.o(369486);
      return paramInt;
    }
    
    public final byte[] U(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190929);
      s.u(paramArrayOfByte, "array");
      paramArrayOfByte = c.klI().U(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(190929);
      return paramArrayOfByte;
    }
    
    public final double Zm()
    {
      AppMethodBeat.i(129563);
      double d = c.klI().Zm();
      AppMethodBeat.o(129563);
      return d;
    }
    
    public final long Zn()
    {
      AppMethodBeat.i(190909);
      long l = c.klI().Zn();
      AppMethodBeat.o(190909);
      return l;
    }
    
    public final int Zo()
    {
      AppMethodBeat.i(369485);
      int i = c.klI().Zo();
      AppMethodBeat.o(369485);
      return i;
    }
    
    public final int aKr(int paramInt)
    {
      AppMethodBeat.i(129560);
      paramInt = c.klI().aKr(paramInt);
      AppMethodBeat.o(129560);
      return paramInt;
    }
    
    public final byte[] dG(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(190924);
      s.u(paramArrayOfByte, "array");
      paramArrayOfByte = c.klI().dG(paramArrayOfByte);
      AppMethodBeat.o(190924);
      return paramArrayOfByte;
    }
    
    public final int qq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129562);
      paramInt1 = c.klI().qq(paramInt1, paramInt2);
      AppMethodBeat.o(129562);
      return paramInt1;
    }
    
    public final double y(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(129564);
      paramDouble1 = c.klI().y(paramDouble1, paramDouble2);
      AppMethodBeat.o(129564);
      return paramDouble1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.j.c
 * JD-Core Version:    0.7.0.1
 */