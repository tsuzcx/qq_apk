package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean TDt;
  private int TDu;
  private a TDv;
  int bNo;
  int bNp;
  private int bNq;
  private int bNt;
  private int bNv;
  private boolean bNw;
  private int bNx;
  final byte[] buffer;
  int bufferSize;
  int cbm;
  private final InputStream input;
  
  private e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.bNw = false;
    this.bNx = 2147483647;
    this.bNp = 64;
    this.bNq = 67108864;
    this.TDv = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.cbm = 0;
    this.TDu = 0;
    this.input = paramInputStream;
    this.TDt = false;
    AppMethodBeat.o(59389);
  }
  
  private e(p paramp)
  {
    AppMethodBeat.i(59390);
    this.bNw = false;
    this.bNx = 2147483647;
    this.bNp = 64;
    this.bNq = 67108864;
    this.TDv = null;
    this.buffer = paramp.zy;
    this.cbm = paramp.yR();
    this.bufferSize = (this.cbm + paramp.size());
    this.TDu = (-this.cbm);
    this.input = null;
    this.TDt = true;
    AppMethodBeat.o(59390);
  }
  
  public static long Ph(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static e V(InputStream paramInputStream)
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
      locale.fH(paramp.size());
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
  
  private void avA(int paramInt)
  {
    AppMethodBeat.i(59399);
    k localk;
    if (paramInt < 0)
    {
      localk = k.hJE();
      AppMethodBeat.o(59399);
      throw localk;
    }
    if (this.TDu + this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.TDu - this.cbm);
      localk = k.hJD();
      AppMethodBeat.o(59399);
      throw localk;
    }
    int i = this.bufferSize - this.cbm;
    this.cbm = this.bufferSize;
    avx(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.cbm = this.bufferSize;
      avx(1);
    }
    this.cbm = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  private void avx(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!avy(paramInt))
    {
      k localk = k.hJD();
      AppMethodBeat.o(59394);
      throw localk;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean avy(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.cbm + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.TDu + this.cbm + paramInt > this.bNx)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.cbm;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.TDu += i;
        this.bufferSize -= i;
        this.cbm = 0;
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
      if (this.TDu + paramInt - this.bNq > 0)
      {
        localObject = k.hJK();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      zo();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private boolean eww()
  {
    AppMethodBeat.i(59393);
    if ((this.cbm == this.bufferSize) && (!avy(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  private void fJ(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.cbm) && (paramInt >= 0))
    {
      this.cbm += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    avA(paramInt);
    AppMethodBeat.o(59398);
  }
  
  private long zj()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = zq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    k localk = k.hJF();
    AppMethodBeat.o(59386);
    throw localk;
  }
  
  private void zo()
  {
    this.bufferSize += this.bNt;
    int i = this.TDu + this.bufferSize;
    if (i > this.bNx)
    {
      this.bNt = (i - this.bNx);
      this.bufferSize -= this.bNt;
      return;
    }
    this.bNt = 0;
  }
  
  private byte zq()
  {
    AppMethodBeat.i(59396);
    if (this.cbm == this.bufferSize) {
      avx(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.cbm;
    this.cbm = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  public final <T extends q> T a(s<T> params, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = zi();
    if (this.bNo >= this.bNp)
    {
      params = k.hJJ();
      AppMethodBeat.o(59382);
      throw params;
    }
    i = fH(i);
    this.bNo += 1;
    params = (q)params.a(this, paramg);
    fF(0);
    this.bNo -= 1;
    fI(i);
    AppMethodBeat.o(59382);
    return params;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (z.gX(paramInt))
    {
    default: 
      paramf = k.hJI();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = zl();
      paramf.hc(paramInt);
      paramf.aJ(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = zn();
      paramf.hc(paramInt);
      paramf.Pj(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = hJt();
      paramf.hc(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.hc(paramInt);
      do
      {
        i = yT();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = z.bA(z.gY(paramInt), 4);
      fF(paramInt);
      paramf.hc(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = zm();
    paramf.hc(paramInt);
    paramf.avB(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] avz(int paramInt)
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
      localObject1 = k.hJE();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.TDu + this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.TDu - this.cbm);
      localObject1 = k.hJD();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.cbm;
      System.arraycopy(this.buffer, this.cbm, localObject1, 0, i);
      this.cbm = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.cbm < j) {
        avx(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.cbm = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.cbm;
    int n = this.bufferSize;
    this.TDu += this.bufferSize;
    this.cbm = 0;
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
          localObject1 = k.hJD();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.TDu += k;
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
  
  public final void fF(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.bNv != paramInt)
    {
      k localk = k.hJH();
      AppMethodBeat.o(59379);
      throw localk;
    }
    AppMethodBeat.o(59379);
  }
  
  public final int fH(int paramInt)
  {
    AppMethodBeat.i(59391);
    k localk;
    if (paramInt < 0)
    {
      localk = k.hJE();
      AppMethodBeat.o(59391);
      throw localk;
    }
    paramInt = this.TDu + this.cbm + paramInt;
    int i = this.bNx;
    if (paramInt > i)
    {
      localk = k.hJD();
      AppMethodBeat.o(59391);
      throw localk;
    }
    this.bNx = paramInt;
    zo();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void fI(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.bNx = paramInt;
    zo();
    AppMethodBeat.o(59392);
  }
  
  public final d hJt()
  {
    AppMethodBeat.i(59383);
    int i = zi();
    if ((i <= this.bufferSize - this.cbm) && (i > 0))
    {
      if ((this.TDt) && (this.bNw)) {}
      for (localObject = new c(this.buffer, this.cbm, i);; localObject = d.V(this.buffer, this.cbm, i))
      {
        this.cbm = (i + this.cbm);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.TDp;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new p(avz(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  public final int yT()
  {
    AppMethodBeat.i(59378);
    if (eww())
    {
      this.bNv = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.bNv = zi();
    if (z.gY(this.bNv) == 0)
    {
      k localk = k.hJG();
      AppMethodBeat.o(59378);
      throw localk;
    }
    int i = this.bNv;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final boolean yZ()
  {
    AppMethodBeat.i(59381);
    if (zl() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final int zi()
  {
    AppMethodBeat.i(59384);
    int i = this.cbm;
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
        this.cbm = j;
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
      this.cbm = i;
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
                i = (int)zj();
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
  
  public final int zk()
  {
    if (this.bNx == 2147483647) {
      return -1;
    }
    int i = this.TDu;
    int j = this.cbm;
    return this.bNx - (i + j);
  }
  
  public final long zl()
  {
    AppMethodBeat.i(59385);
    int i = this.cbm;
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
        this.cbm = j;
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
      this.cbm = i;
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
                      l = zj();
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
  
  public final int zm()
  {
    AppMethodBeat.i(59387);
    int j = this.cbm;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      avx(4);
      i = this.cbm;
    }
    byte[] arrayOfByte = this.buffer;
    this.cbm = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long zn()
  {
    AppMethodBeat.i(59388);
    int j = this.cbm;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      avx(8);
      i = this.cbm;
    }
    byte[] arrayOfByte = this.buffer;
    this.cbm = (i + 8);
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
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */