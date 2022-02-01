package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean JMw;
  private boolean JMx;
  private int JMy;
  private a JMz;
  private int bIK;
  int bIL;
  private int bIM;
  private int bIN;
  int bIO;
  int bIP;
  private int bIQ;
  final byte[] buffer;
  int bufferSize;
  private final InputStream input;
  
  private e(p paramp)
  {
    AppMethodBeat.i(59390);
    this.JMx = false;
    this.bIN = 2147483647;
    this.bIP = 64;
    this.bIQ = 67108864;
    this.JMz = null;
    this.buffer = paramp.wA;
    this.bIL = paramp.fHl();
    this.bufferSize = (this.bIL + paramp.size());
    this.JMy = (-this.bIL);
    this.input = null;
    this.JMw = true;
    AppMethodBeat.o(59390);
  }
  
  private e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.JMx = false;
    this.bIN = 2147483647;
    this.bIP = 64;
    this.bIQ = 67108864;
    this.JMz = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bIL = 0;
    this.JMy = 0;
    this.input = paramInputStream;
    this.JMw = false;
    AppMethodBeat.o(59389);
  }
  
  public static e W(InputStream paramInputStream)
  {
    AppMethodBeat.i(59376);
    paramInputStream = new e(paramInputStream);
    AppMethodBeat.o(59376);
    return paramInputStream;
  }
  
  static e a(p paramp)
  {
    AppMethodBeat.i(59377);
    e locale = new e(paramp);
    try
    {
      locale.fR(paramp.size());
      AppMethodBeat.o(59377);
      return locale;
    }
    catch (k paramp)
    {
      paramp = new IllegalArgumentException(paramp);
      AppMethodBeat.o(59377);
      throw paramp;
    }
  }
  
  private void afB(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!afC(paramInt))
    {
      k localk = k.fHN();
      AppMethodBeat.o(59394);
      throw localk;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean afC(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.bIL + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.JMy + this.bIL + paramInt > this.bIN)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.bIL;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.JMy += i;
        this.bufferSize -= i;
        this.bIL = 0;
      }
      i = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
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
      if (this.JMy + paramInt - this.bIQ > 0)
      {
        localObject = k.fHU();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      xU();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private void afE(int paramInt)
  {
    AppMethodBeat.i(59399);
    k localk;
    if (paramInt < 0)
    {
      localk = k.fHO();
      AppMethodBeat.o(59399);
      throw localk;
    }
    if (this.JMy + this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.JMy - this.bIL);
      localk = k.fHN();
      AppMethodBeat.o(59399);
      throw localk;
    }
    int i = this.bufferSize - this.bIL;
    this.bIL = this.bufferSize;
    afB(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bIL = this.bufferSize;
      afB(1);
    }
    this.bIL = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  private long fHw()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = xW();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    k localk = k.fHP();
    AppMethodBeat.o(59386);
    throw localk;
  }
  
  private boolean fHz()
  {
    AppMethodBeat.i(59393);
    if ((this.bIL == this.bufferSize) && (!afC(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  private void fV(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.bIL) && (paramInt >= 0))
    {
      this.bIL += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    afE(paramInt);
    AppMethodBeat.o(59398);
  }
  
  public static long xF(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void xU()
  {
    this.bufferSize += this.bIK;
    int i = this.JMy + this.bufferSize;
    if (i > this.bIN)
    {
      this.bIK = (i - this.bIN);
      this.bufferSize -= this.bIK;
      return;
    }
    this.bIK = 0;
  }
  
  private byte xW()
  {
    AppMethodBeat.i(59396);
    if (this.bIL == this.bufferSize) {
      afB(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bIL;
    this.bIL = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  public final <T extends q> T a(s<T> params, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = xS();
    if (this.bIO >= this.bIP)
    {
      params = k.fHT();
      AppMethodBeat.o(59382);
      throw params;
    }
    i = fR(i);
    this.bIO += 1;
    params = (q)params.a(this, paramg);
    fP(0);
    this.bIO -= 1;
    fS(i);
    AppMethodBeat.o(59382);
    return params;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (z.gb(paramInt))
    {
    default: 
      paramf = k.fHS();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = xT();
      paramf.fZ(paramInt);
      paramf.aA(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = fHy();
      paramf.fZ(paramInt);
      paramf.xI(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = fHv();
      paramf.fZ(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.fZ(paramInt);
      do
      {
        i = xR();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = z.bD(z.gc(paramInt), 4);
      fP(paramInt);
      paramf.fZ(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = fHx();
    paramf.fZ(paramInt);
    paramf.afH(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] afD(int paramInt)
  {
    AppMethodBeat.i(59397);
    if (paramInt <= 0)
    {
      if (paramInt == 0)
      {
        localObject1 = j.EMPTY_BYTE_ARRAY;
        AppMethodBeat.o(59397);
        return localObject1;
      }
      localObject1 = k.fHO();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.JMy + this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.JMy - this.bIL);
      localObject1 = k.fHN();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.bIL;
      System.arraycopy(this.buffer, this.bIL, localObject1, 0, i);
      this.bIL = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.bIL < j) {
        afB(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.bIL = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.bIL;
    int n = this.bufferSize;
    this.JMy += this.bufferSize;
    this.bIL = 0;
    this.bufferSize = 0;
    Object localObject2 = new ArrayList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      localObject1 = new byte[Math.min(i, 4096)];
      j = 0;
      while (j < localObject1.length)
      {
        if (this.input == null) {}
        for (int k = -1; k == -1; k = this.input.read((byte[])localObject1, j, localObject1.length - j))
        {
          localObject1 = k.fHN();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.JMy += k;
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
  
  public final boolean fHu()
  {
    AppMethodBeat.i(59381);
    if (xT() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final d fHv()
  {
    AppMethodBeat.i(59383);
    int i = xS();
    if ((i <= this.bufferSize - this.bIL) && (i > 0))
    {
      if ((this.JMw) && (this.JMx)) {}
      for (localObject = new c(this.buffer, this.bIL, i);; localObject = d.J(this.buffer, this.bIL, i))
      {
        this.bIL = (i + this.bIL);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.JMs;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new p(afD(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  public final int fHx()
  {
    AppMethodBeat.i(59387);
    int j = this.bIL;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      afB(4);
      i = this.bIL;
    }
    byte[] arrayOfByte = this.buffer;
    this.bIL = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long fHy()
  {
    AppMethodBeat.i(59388);
    int j = this.bIL;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      afB(8);
      i = this.bIL;
    }
    byte[] arrayOfByte = this.buffer;
    this.bIL = (i + 8);
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
  
  public final void fP(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.bIM != paramInt)
    {
      k localk = k.fHR();
      AppMethodBeat.o(59379);
      throw localk;
    }
    AppMethodBeat.o(59379);
  }
  
  public final int fR(int paramInt)
  {
    AppMethodBeat.i(59391);
    k localk;
    if (paramInt < 0)
    {
      localk = k.fHO();
      AppMethodBeat.o(59391);
      throw localk;
    }
    paramInt = this.JMy + this.bIL + paramInt;
    int i = this.bIN;
    if (paramInt > i)
    {
      localk = k.fHN();
      AppMethodBeat.o(59391);
      throw localk;
    }
    this.bIN = paramInt;
    xU();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void fS(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.bIN = paramInt;
    xU();
    AppMethodBeat.o(59392);
  }
  
  public final int xR()
  {
    AppMethodBeat.i(59378);
    if (fHz())
    {
      this.bIM = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.bIM = xS();
    if (z.gc(this.bIM) == 0)
    {
      k localk = k.fHQ();
      AppMethodBeat.o(59378);
      throw localk;
    }
    int i = this.bIM;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final int xS()
  {
    AppMethodBeat.i(59384);
    int i = this.bIL;
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
        this.bIL = j;
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
      this.bIL = i;
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
                i = (int)fHw();
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
  
  public final long xT()
  {
    AppMethodBeat.i(59385);
    int i = this.bIL;
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
        this.bIL = j;
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
      this.bIL = i;
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
                      l = fHw();
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
  
  public final int xV()
  {
    if (this.bIN == 2147483647) {
      return -1;
    }
    int i = this.JMy;
    int j = this.bIL;
    return this.bIN - (i + j);
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */