package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean ajeY;
  private a ajeZ;
  final byte[] buffer;
  int bufferSize;
  int dIR;
  int dIS;
  private int dIT;
  private int dIX;
  private int dIZ;
  private boolean dJa;
  private int dJb;
  private final InputStream dJc;
  private int dJd;
  int dXt;
  
  e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.dJa = false;
    this.dJb = 2147483647;
    this.dIS = 64;
    this.dIT = 67108864;
    this.ajeZ = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.dXt = 0;
    this.dJd = 0;
    this.dJc = paramInputStream;
    this.ajeY = false;
    AppMethodBeat.o(59389);
  }
  
  private byte aaA()
  {
    AppMethodBeat.i(59396);
    if (this.dXt == this.bufferSize) {
      jS(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.dXt;
    this.dXt = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  private long aas()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = aaA();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    l locall = l.kyp();
    AppMethodBeat.o(59386);
    throw locall;
  }
  
  private boolean aau()
  {
    AppMethodBeat.i(59393);
    if ((this.dXt == this.bufferSize) && (!jT(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  private void aaz()
  {
    this.bufferSize += this.dIX;
    int i = this.dJd + this.bufferSize;
    if (i > this.dJb)
    {
      this.dIX = (i - this.dJb);
      this.bufferSize -= this.dIX;
      return;
    }
    this.dIX = 0;
  }
  
  public static long cO(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void jR(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.dXt) && (paramInt >= 0))
    {
      this.dXt += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    jX(paramInt);
    AppMethodBeat.o(59398);
  }
  
  private void jS(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!jT(paramInt))
    {
      l locall = l.kyn();
      AppMethodBeat.o(59394);
      throw locall;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean jT(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.dXt + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.dJd + this.dXt + paramInt > this.dJb)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.dJc == null) {
        break;
      }
      int i = this.dXt;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.dJd += i;
        this.bufferSize -= i;
        this.dXt = 0;
      }
      i = this.dJc.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
      if ((i == 0) || (i < -1) || (i > this.buffer.length))
      {
        localObject = new IllegalStateException(102 + "InputStream#read(byte[]) returned invalid result: " + i + "\nThe InputStream implementation is buggy.");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (i <= 0) {
        break;
      }
      this.bufferSize = (i + this.bufferSize);
      if (this.dJd + paramInt - this.dIT > 0)
      {
        localObject = l.kyu();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      aaz();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private void jX(int paramInt)
  {
    AppMethodBeat.i(59399);
    l locall;
    if (paramInt < 0)
    {
      locall = l.kyo();
      AppMethodBeat.o(59399);
      throw locall;
    }
    if (this.dJd + this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dJd - this.dXt);
      locall = l.kyn();
      AppMethodBeat.o(59399);
      throw locall;
    }
    int i = this.bufferSize - this.dXt;
    this.dXt = this.bufferSize;
    jS(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.dXt = this.bufferSize;
      jS(1);
    }
    this.dXt = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  public final <T extends r> T a(t<T> paramt, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = aar();
    if (this.dIR >= this.dIS)
    {
      paramt = l.kyt();
      AppMethodBeat.o(59382);
      throw paramt;
    }
    i = jO(i);
    this.dIR += 1;
    paramt = (r)paramt.a(this, paramg);
    jM(0);
    this.dIR -= 1;
    jP(i);
    AppMethodBeat.o(59382);
    return paramt;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (aa.lD(paramInt))
    {
    default: 
      paramf = l.kys();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = aaw();
      paramf.lI(paramInt);
      paramf.dg(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = aay();
      paramf.lI(paramInt);
      paramf.BJ(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = kyd();
      paramf.lI(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.lI(paramInt);
      do
      {
        i = aac();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = aa.cU(aa.lE(paramInt), 4);
      jM(paramInt);
      paramf.lI(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = aax();
    paramf.lI(paramInt);
    paramf.aMj(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] aMi(int paramInt)
  {
    AppMethodBeat.i(59397);
    if (paramInt <= 0)
    {
      if (paramInt == 0)
      {
        localObject1 = k.EMPTY_BYTE_ARRAY;
        AppMethodBeat.o(59397);
        return localObject1;
      }
      localObject1 = l.kyo();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.dJd + this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dJd - this.dXt);
      localObject1 = l.kyn();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.dXt;
      System.arraycopy(this.buffer, this.dXt, localObject1, 0, i);
      this.dXt = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.dXt < j) {
        jS(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.dXt = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.dXt;
    int n = this.bufferSize;
    this.dJd += this.bufferSize;
    this.dXt = 0;
    this.bufferSize = 0;
    Object localObject2 = new ArrayList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      localObject1 = new byte[Math.min(i, 4096)];
      j = 0;
      while (j < localObject1.length)
      {
        if (this.dJc == null) {}
        for (int k = -1; k == -1; k = this.dJc.read((byte[])localObject1, j, localObject1.length - j))
        {
          localObject1 = l.kyn();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.dJd += k;
        j += k;
      }
      j = localObject1.length;
      ((List)localObject2).add(localObject1);
      i -= j;
    }
    Object localObject1 = new byte[paramInt];
    paramInt = n - m;
    System.arraycopy(this.buffer, m, localObject1, 0, paramInt);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
      System.arraycopy(arrayOfByte, 0, localObject1, paramInt, arrayOfByte.length);
      paramInt = arrayOfByte.length + paramInt;
    }
    AppMethodBeat.o(59397);
    return localObject1;
  }
  
  public final int aac()
  {
    AppMethodBeat.i(59378);
    if (aau())
    {
      this.dIZ = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.dIZ = aar();
    if (aa.lE(this.dIZ) == 0)
    {
      l locall = l.kyq();
      AppMethodBeat.o(59378);
      throw locall;
    }
    int i = this.dIZ;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(59381);
    if (aaw() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final int aar()
  {
    AppMethodBeat.i(59384);
    int i = this.dXt;
    byte[] arrayOfByte;
    int j;
    int k;
    if (this.bufferSize != i)
    {
      arrayOfByte = this.buffer;
      j = i + 1;
      k = arrayOfByte[i];
      if (k >= 0)
      {
        this.dXt = j;
        AppMethodBeat.o(59384);
        return k;
      }
      if (this.bufferSize - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0L) {
          j = (int)(k ^ 0xFFFFFF80);
        }
      }
    }
    for (;;)
    {
      this.dXt = i;
      AppMethodBeat.o(59384);
      return j;
      j = i + 1;
      k ^= arrayOfByte[i] << 14;
      if (k >= 0L)
      {
        k = (int)(k ^ 0x3F80);
        i = j;
        j = k;
      }
      else
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 21;
        if (k < 0L)
        {
          j = (int)(k ^ 0xFFE03F80);
        }
        else
        {
          int m = i + 1;
          j = arrayOfByte[i];
          k = (int)(k ^ j << 28 ^ 0xFE03F80);
          i = m;
          if (j < 0)
          {
            int n = m + 1;
            j = k;
            i = n;
            if (arrayOfByte[m] >= 0) {
              continue;
            }
            m = n + 1;
            i = m;
            if (arrayOfByte[n] < 0)
            {
              n = m + 1;
              j = k;
              i = n;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                i = m + 1;
                j = k;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                i = (int)aas();
                AppMethodBeat.o(59384);
                return i;
              }
            }
          }
          j = k;
        }
      }
    }
  }
  
  public final int aat()
  {
    if (this.dJb == 2147483647) {
      return -1;
    }
    int i = this.dJd;
    int j = this.dXt;
    return this.dJb - (i + j);
  }
  
  public final long aaw()
  {
    AppMethodBeat.i(59385);
    int i = this.dXt;
    byte[] arrayOfByte;
    int j;
    long l;
    if (this.bufferSize != i)
    {
      arrayOfByte = this.buffer;
      j = i + 1;
      int k = arrayOfByte[i];
      if (k >= 0)
      {
        this.dXt = j;
        l = k;
        AppMethodBeat.o(59385);
        return l;
      }
      if (this.bufferSize - j >= 9)
      {
        i = j + 1;
        l = k ^ arrayOfByte[j] << 7;
        if (l < 0L) {
          l ^= 0xFFFFFF80;
        }
      }
    }
    for (;;)
    {
      this.dXt = i;
      AppMethodBeat.o(59385);
      return l;
      j = i + 1;
      l ^= arrayOfByte[i] << 14;
      if (l >= 0L)
      {
        l ^= 0x3F80;
        i = j;
      }
      else
      {
        i = j + 1;
        l ^= arrayOfByte[j] << 21;
        if (l < 0L)
        {
          l ^= 0xFFE03F80;
        }
        else
        {
          j = i + 1;
          l ^= arrayOfByte[i] << 28;
          if (l >= 0L)
          {
            l ^= 0xFE03F80;
            i = j;
          }
          else
          {
            i = j + 1;
            l ^= arrayOfByte[j] << 35;
            if (l < 0L)
            {
              l ^= 0xFE03F80;
            }
            else
            {
              j = i + 1;
              l ^= arrayOfByte[i] << 42;
              if (l >= 0L)
              {
                l ^= 0xFE03F80;
                i = j;
              }
              else
              {
                i = j + 1;
                l ^= arrayOfByte[j] << 49;
                if (l < 0L)
                {
                  l ^= 0xFE03F80;
                }
                else
                {
                  j = i + 1;
                  l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
                  if (l < 0L)
                  {
                    i = j + 1;
                    if (arrayOfByte[j] < 0L)
                    {
                      l = aas();
                      AppMethodBeat.o(59385);
                      return l;
                    }
                  }
                  else
                  {
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final int aax()
  {
    AppMethodBeat.i(59387);
    int j = this.dXt;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      jS(4);
      i = this.dXt;
    }
    byte[] arrayOfByte = this.buffer;
    this.dXt = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long aay()
  {
    AppMethodBeat.i(59388);
    int j = this.dXt;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      jS(8);
      i = this.dXt;
    }
    byte[] arrayOfByte = this.buffer;
    this.dXt = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    long l8 = arrayOfByte[(i + 7)];
    AppMethodBeat.o(59388);
    return (l8 & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  public final void jM(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.dIZ != paramInt)
    {
      l locall = l.kyr();
      AppMethodBeat.o(59379);
      throw locall;
    }
    AppMethodBeat.o(59379);
  }
  
  public final int jO(int paramInt)
  {
    AppMethodBeat.i(59391);
    l locall;
    if (paramInt < 0)
    {
      locall = l.kyo();
      AppMethodBeat.o(59391);
      throw locall;
    }
    paramInt = this.dJd + this.dXt + paramInt;
    int i = this.dJb;
    if (paramInt > i)
    {
      locall = l.kyn();
      AppMethodBeat.o(59391);
      throw locall;
    }
    this.dJb = paramInt;
    aaz();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void jP(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.dJb = paramInt;
    aaz();
    AppMethodBeat.o(59392);
  }
  
  public final d kyd()
  {
    AppMethodBeat.i(59383);
    int i = aar();
    if ((i <= this.bufferSize - this.dXt) && (i > 0))
    {
      if ((this.ajeY) && (this.dJa)) {}
      for (localObject = new c(this.buffer, this.dXt, i);; localObject = d.V(this.buffer, this.dXt, i))
      {
        this.dXt = (i + this.dXt);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.ajeU;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new q(aMi(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */