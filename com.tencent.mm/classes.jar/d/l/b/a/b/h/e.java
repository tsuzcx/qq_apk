package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean NqM;
  private boolean NqN;
  private int NqO;
  private a NqP;
  private int bQG;
  int bQH;
  private int bQI;
  private int bQJ;
  int bQK;
  int bQL;
  private int bQM;
  final byte[] buffer;
  int bufferSize;
  private final InputStream input;
  
  private e(p paramp)
  {
    AppMethodBeat.i(59390);
    this.NqN = false;
    this.bQJ = 2147483647;
    this.bQL = 64;
    this.bQM = 67108864;
    this.NqP = null;
    this.buffer = paramp.zr;
    this.bQH = paramp.grn();
    this.bufferSize = (this.bQH + paramp.size());
    this.NqO = (-this.bQH);
    this.input = null;
    this.NqM = true;
    AppMethodBeat.o(59390);
  }
  
  private e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.NqN = false;
    this.bQJ = 2147483647;
    this.bQL = 64;
    this.bQM = 67108864;
    this.NqP = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bQH = 0;
    this.NqO = 0;
    this.input = paramInputStream;
    this.NqM = false;
    AppMethodBeat.o(59389);
  }
  
  public static long Fx(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static e Y(InputStream paramInputStream)
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
      locale.fG(paramp.size());
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
  
  private void akY(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!akZ(paramInt))
    {
      k localk = k.grP();
      AppMethodBeat.o(59394);
      throw localk;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean akZ(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.bQH + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.NqO + this.bQH + paramInt > this.bQJ)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.bQH;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.NqO += i;
        this.bufferSize -= i;
        this.bQH = 0;
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
      if (this.NqO + paramInt - this.bQM > 0)
      {
        localObject = k.grW();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      ze();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private void alb(int paramInt)
  {
    AppMethodBeat.i(59399);
    k localk;
    if (paramInt < 0)
    {
      localk = k.grQ();
      AppMethodBeat.o(59399);
      throw localk;
    }
    if (this.NqO + this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.NqO - this.bQH);
      localk = k.grP();
      AppMethodBeat.o(59399);
      throw localk;
    }
    int i = this.bufferSize - this.bQH;
    this.bQH = this.bufferSize;
    akY(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bQH = this.bufferSize;
      akY(1);
    }
    this.bQH = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  private void fK(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.bQH) && (paramInt >= 0))
    {
      this.bQH += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    alb(paramInt);
    AppMethodBeat.o(59398);
  }
  
  private boolean grB()
  {
    AppMethodBeat.i(59393);
    if ((this.bQH == this.bufferSize) && (!akZ(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  private long gry()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = zg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    k localk = k.grR();
    AppMethodBeat.o(59386);
    throw localk;
  }
  
  private void ze()
  {
    this.bufferSize += this.bQG;
    int i = this.NqO + this.bufferSize;
    if (i > this.bQJ)
    {
      this.bQG = (i - this.bQJ);
      this.bufferSize -= this.bQG;
      return;
    }
    this.bQG = 0;
  }
  
  private byte zg()
  {
    AppMethodBeat.i(59396);
    if (this.bQH == this.bufferSize) {
      akY(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bQH;
    this.bQH = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  public final <T extends q> T a(s<T> params, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = zc();
    if (this.bQK >= this.bQL)
    {
      params = k.grV();
      AppMethodBeat.o(59382);
      throw params;
    }
    i = fG(i);
    this.bQK += 1;
    params = (q)params.a(this, paramg);
    fE(0);
    this.bQK -= 1;
    fH(i);
    AppMethodBeat.o(59382);
    return params;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (z.fQ(paramInt))
    {
    default: 
      paramf = k.grU();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = zd();
      paramf.fO(paramInt);
      paramf.aw(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = grA();
      paramf.fO(paramInt);
      paramf.FA(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = grx();
      paramf.fO(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.fO(paramInt);
      do
      {
        i = zb();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = z.bC(z.fR(paramInt), 4);
      fE(paramInt);
      paramf.fO(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = grz();
    paramf.fO(paramInt);
    paramf.ale(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] ala(int paramInt)
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
      localObject1 = k.grQ();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.NqO + this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.NqO - this.bQH);
      localObject1 = k.grP();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.bQH;
      System.arraycopy(this.buffer, this.bQH, localObject1, 0, i);
      this.bQH = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.bQH < j) {
        akY(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.bQH = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.bQH;
    int n = this.bufferSize;
    this.NqO += this.bufferSize;
    this.bQH = 0;
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
          localObject1 = k.grP();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.NqO += k;
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
  
  public final void fE(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.bQI != paramInt)
    {
      k localk = k.grT();
      AppMethodBeat.o(59379);
      throw localk;
    }
    AppMethodBeat.o(59379);
  }
  
  public final int fG(int paramInt)
  {
    AppMethodBeat.i(59391);
    k localk;
    if (paramInt < 0)
    {
      localk = k.grQ();
      AppMethodBeat.o(59391);
      throw localk;
    }
    paramInt = this.NqO + this.bQH + paramInt;
    int i = this.bQJ;
    if (paramInt > i)
    {
      localk = k.grP();
      AppMethodBeat.o(59391);
      throw localk;
    }
    this.bQJ = paramInt;
    ze();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void fH(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.bQJ = paramInt;
    ze();
    AppMethodBeat.o(59392);
  }
  
  public final long grA()
  {
    AppMethodBeat.i(59388);
    int j = this.bQH;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      akY(8);
      i = this.bQH;
    }
    byte[] arrayOfByte = this.buffer;
    this.bQH = (i + 8);
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
  
  public final boolean grw()
  {
    AppMethodBeat.i(59381);
    if (zd() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final d grx()
  {
    AppMethodBeat.i(59383);
    int i = zc();
    if ((i <= this.bufferSize - this.bQH) && (i > 0))
    {
      if ((this.NqM) && (this.NqN)) {}
      for (localObject = new c(this.buffer, this.bQH, i);; localObject = d.J(this.buffer, this.bQH, i))
      {
        this.bQH = (i + this.bQH);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.NqI;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new p(ala(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  public final int grz()
  {
    AppMethodBeat.i(59387);
    int j = this.bQH;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      akY(4);
      i = this.bQH;
    }
    byte[] arrayOfByte = this.buffer;
    this.bQH = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final int zb()
  {
    AppMethodBeat.i(59378);
    if (grB())
    {
      this.bQI = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.bQI = zc();
    if (z.fR(this.bQI) == 0)
    {
      k localk = k.grS();
      AppMethodBeat.o(59378);
      throw localk;
    }
    int i = this.bQI;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final int zc()
  {
    AppMethodBeat.i(59384);
    int i = this.bQH;
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
        this.bQH = j;
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
      this.bQH = i;
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
                i = (int)gry();
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
  
  public final long zd()
  {
    AppMethodBeat.i(59385);
    int i = this.bQH;
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
        this.bQH = j;
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
      this.bQH = i;
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
                      l = gry();
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
  
  public final int zf()
  {
    if (this.bQJ == 2147483647) {
      return -1;
    }
    int i = this.NqO;
    int j = this.bQH;
    return this.bQJ - (i + j);
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */