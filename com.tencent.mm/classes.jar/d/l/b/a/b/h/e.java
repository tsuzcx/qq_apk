package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean LzP;
  private boolean LzQ;
  private int LzR;
  private a LzS;
  private int bGs;
  int bGt;
  private int bGu;
  private int bGv;
  int bGw;
  int bGx;
  private int bGy;
  final byte[] buffer;
  int bufferSize;
  private final InputStream input;
  
  private e(p paramp)
  {
    AppMethodBeat.i(59390);
    this.LzQ = false;
    this.bGv = 2147483647;
    this.bGx = 64;
    this.bGy = 67108864;
    this.LzS = null;
    this.buffer = paramp.xy;
    this.bGt = paramp.fZO();
    this.bufferSize = (this.bGt + paramp.size());
    this.LzR = (-this.bGt);
    this.input = null;
    this.LzP = true;
    AppMethodBeat.o(59390);
  }
  
  private e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.LzQ = false;
    this.bGv = 2147483647;
    this.bGx = 64;
    this.bGy = 67108864;
    this.LzS = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bGt = 0;
    this.LzR = 0;
    this.input = paramInputStream;
    this.LzP = false;
    AppMethodBeat.o(59389);
  }
  
  public static long Cs(long paramLong)
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
      locale.fD(paramp.size());
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
  
  private void aiA(int paramInt)
  {
    AppMethodBeat.i(59399);
    k localk;
    if (paramInt < 0)
    {
      localk = k.gar();
      AppMethodBeat.o(59399);
      throw localk;
    }
    if (this.LzR + this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.LzR - this.bGt);
      localk = k.gaq();
      AppMethodBeat.o(59399);
      throw localk;
    }
    int i = this.bufferSize - this.bGt;
    this.bGt = this.bufferSize;
    aix(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bGt = this.bufferSize;
      aix(1);
    }
    this.bGt = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  private void aix(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!aiy(paramInt))
    {
      k localk = k.gaq();
      AppMethodBeat.o(59394);
      throw localk;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean aiy(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.bGt + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.LzR + this.bGt + paramInt > this.bGv)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.bGt;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.LzR += i;
        this.bufferSize -= i;
        this.bGt = 0;
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
      if (this.LzR + paramInt - this.bGy > 0)
      {
        localObject = k.gax();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      xH();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private void fH(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.bGt) && (paramInt >= 0))
    {
      this.bGt += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    aiA(paramInt);
    AppMethodBeat.o(59398);
  }
  
  private long fZZ()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = xJ();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    k localk = k.gas();
    AppMethodBeat.o(59386);
    throw localk;
  }
  
  private boolean gac()
  {
    AppMethodBeat.i(59393);
    if ((this.bGt == this.bufferSize) && (!aiy(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  private void xH()
  {
    this.bufferSize += this.bGs;
    int i = this.LzR + this.bufferSize;
    if (i > this.bGv)
    {
      this.bGs = (i - this.bGv);
      this.bufferSize -= this.bGs;
      return;
    }
    this.bGs = 0;
  }
  
  private byte xJ()
  {
    AppMethodBeat.i(59396);
    if (this.bGt == this.bufferSize) {
      aix(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bGt;
    this.bGt = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  public final <T extends q> T a(s<T> params, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = xF();
    if (this.bGw >= this.bGx)
    {
      params = k.gaw();
      AppMethodBeat.o(59382);
      throw params;
    }
    i = fD(i);
    this.bGw += 1;
    params = (q)params.a(this, paramg);
    fB(0);
    this.bGw -= 1;
    fE(i);
    AppMethodBeat.o(59382);
    return params;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (z.fN(paramInt))
    {
    default: 
      paramf = k.gav();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = xG();
      paramf.fL(paramInt);
      paramf.aw(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = gab();
      paramf.fL(paramInt);
      paramf.Cv(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = fZY();
      paramf.fL(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.fL(paramInt);
      do
      {
        i = xE();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = z.bA(z.fO(paramInt), 4);
      fB(paramInt);
      paramf.fL(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = gaa();
    paramf.fL(paramInt);
    paramf.aiD(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] aiz(int paramInt)
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
      localObject1 = k.gar();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.LzR + this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.LzR - this.bGt);
      localObject1 = k.gaq();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.bGt;
      System.arraycopy(this.buffer, this.bGt, localObject1, 0, i);
      this.bGt = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.bGt < j) {
        aix(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.bGt = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.bGt;
    int n = this.bufferSize;
    this.LzR += this.bufferSize;
    this.bGt = 0;
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
          localObject1 = k.gaq();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.LzR += k;
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
  
  public final void fB(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.bGu != paramInt)
    {
      k localk = k.gau();
      AppMethodBeat.o(59379);
      throw localk;
    }
    AppMethodBeat.o(59379);
  }
  
  public final int fD(int paramInt)
  {
    AppMethodBeat.i(59391);
    k localk;
    if (paramInt < 0)
    {
      localk = k.gar();
      AppMethodBeat.o(59391);
      throw localk;
    }
    paramInt = this.LzR + this.bGt + paramInt;
    int i = this.bGv;
    if (paramInt > i)
    {
      localk = k.gaq();
      AppMethodBeat.o(59391);
      throw localk;
    }
    this.bGv = paramInt;
    xH();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void fE(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.bGv = paramInt;
    xH();
    AppMethodBeat.o(59392);
  }
  
  public final boolean fZX()
  {
    AppMethodBeat.i(59381);
    if (xG() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final d fZY()
  {
    AppMethodBeat.i(59383);
    int i = xF();
    if ((i <= this.bufferSize - this.bGt) && (i > 0))
    {
      if ((this.LzP) && (this.LzQ)) {}
      for (localObject = new c(this.buffer, this.bGt, i);; localObject = d.I(this.buffer, this.bGt, i))
      {
        this.bGt = (i + this.bGt);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.LzL;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new p(aiz(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  public final int gaa()
  {
    AppMethodBeat.i(59387);
    int j = this.bGt;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      aix(4);
      i = this.bGt;
    }
    byte[] arrayOfByte = this.buffer;
    this.bGt = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long gab()
  {
    AppMethodBeat.i(59388);
    int j = this.bGt;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      aix(8);
      i = this.bGt;
    }
    byte[] arrayOfByte = this.buffer;
    this.bGt = (i + 8);
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
  
  public final int xE()
  {
    AppMethodBeat.i(59378);
    if (gac())
    {
      this.bGu = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.bGu = xF();
    if (z.fO(this.bGu) == 0)
    {
      k localk = k.gat();
      AppMethodBeat.o(59378);
      throw localk;
    }
    int i = this.bGu;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final int xF()
  {
    AppMethodBeat.i(59384);
    int i = this.bGt;
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
        this.bGt = j;
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
      this.bGt = i;
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
                i = (int)fZZ();
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
  
  public final long xG()
  {
    AppMethodBeat.i(59385);
    int i = this.bGt;
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
        this.bGt = j;
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
      this.bGt = i;
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
                      l = fZZ();
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
  
  public final int xI()
  {
    if (this.bGv == 2147483647) {
      return -1;
    }
    int i = this.LzR;
    int j = this.bGt;
    return this.bGv - (i + j);
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */