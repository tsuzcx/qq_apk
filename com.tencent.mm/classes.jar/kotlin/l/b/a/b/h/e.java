package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean abgf;
  private int abgg;
  private a abgh;
  int bPn;
  int bPo;
  private int bPp;
  private int bPs;
  private int bPu;
  private boolean bPv;
  private int bPw;
  final byte[] buffer;
  int bufferSize;
  int ccP;
  private final InputStream input;
  
  e(InputStream paramInputStream)
  {
    AppMethodBeat.i(59389);
    this.bPv = false;
    this.bPw = 2147483647;
    this.bPo = 64;
    this.bPp = 67108864;
    this.abgh = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.ccP = 0;
    this.abgg = 0;
    this.input = paramInputStream;
    this.abgf = false;
    AppMethodBeat.o(59389);
  }
  
  private long AL()
  {
    AppMethodBeat.i(59386);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = AS();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(59386);
        return l;
      }
      i += 7;
    }
    l locall = l.iNX();
    AppMethodBeat.o(59386);
    throw locall;
  }
  
  private void AQ()
  {
    this.bufferSize += this.bPs;
    int i = this.abgg + this.bufferSize;
    if (i > this.bPw)
    {
      this.bPs = (i - this.bPw);
      this.bufferSize -= this.bPs;
      return;
    }
    this.bPs = 0;
  }
  
  private byte AS()
  {
    AppMethodBeat.i(59396);
    if (this.ccP == this.bufferSize) {
      aFr(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.ccP;
    this.ccP = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(59396);
    return b;
  }
  
  public static long Xx(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void aFr(int paramInt)
  {
    AppMethodBeat.i(59394);
    if (!aFs(paramInt))
    {
      l locall = l.iNV();
      AppMethodBeat.o(59394);
      throw locall;
    }
    AppMethodBeat.o(59394);
  }
  
  private boolean aFs(int paramInt)
  {
    AppMethodBeat.i(59395);
    do
    {
      Object localObject;
      if (this.ccP + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      if (this.abgg + this.ccP + paramInt > this.bPw)
      {
        AppMethodBeat.o(59395);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.ccP;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.abgg += i;
        this.bufferSize -= i;
        this.ccP = 0;
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
      if (this.abgg + paramInt - this.bPp > 0)
      {
        localObject = l.iOc();
        AppMethodBeat.o(59395);
        throw ((Throwable)localObject);
      }
      AQ();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(59395);
    return true;
    AppMethodBeat.o(59395);
    return false;
  }
  
  private void aFu(int paramInt)
  {
    AppMethodBeat.i(59399);
    l locall;
    if (paramInt < 0)
    {
      locall = l.iNW();
      AppMethodBeat.o(59399);
      throw locall;
    }
    if (this.abgg + this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.abgg - this.ccP);
      locall = l.iNV();
      AppMethodBeat.o(59399);
      throw locall;
    }
    int i = this.bufferSize - this.ccP;
    this.ccP = this.bufferSize;
    aFr(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.ccP = this.bufferSize;
      aFr(1);
    }
    this.ccP = (paramInt - i);
    AppMethodBeat.o(59399);
  }
  
  private void gC(int paramInt)
  {
    AppMethodBeat.i(59398);
    if ((paramInt <= this.bufferSize - this.ccP) && (paramInt >= 0))
    {
      this.ccP += paramInt;
      AppMethodBeat.o(59398);
      return;
    }
    aFu(paramInt);
    AppMethodBeat.o(59398);
  }
  
  private boolean hWy()
  {
    AppMethodBeat.i(59393);
    if ((this.ccP == this.bufferSize) && (!aFs(1)))
    {
      AppMethodBeat.o(59393);
      return true;
    }
    AppMethodBeat.o(59393);
    return false;
  }
  
  public final boolean AB()
  {
    AppMethodBeat.i(59381);
    if (AN() != 0L)
    {
      AppMethodBeat.o(59381);
      return true;
    }
    AppMethodBeat.o(59381);
    return false;
  }
  
  public final int AK()
  {
    AppMethodBeat.i(59384);
    int i = this.ccP;
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
        this.ccP = j;
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
      this.ccP = i;
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
                i = (int)AL();
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
  
  public final int AM()
  {
    if (this.bPw == 2147483647) {
      return -1;
    }
    int i = this.abgg;
    int j = this.ccP;
    return this.bPw - (i + j);
  }
  
  public final long AN()
  {
    AppMethodBeat.i(59385);
    int i = this.ccP;
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
        this.ccP = j;
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
      this.ccP = i;
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
                      l = AL();
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
  
  public final int AO()
  {
    AppMethodBeat.i(59387);
    int j = this.ccP;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      aFr(4);
      i = this.ccP;
    }
    byte[] arrayOfByte = this.buffer;
    this.ccP = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(59387);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long AP()
  {
    AppMethodBeat.i(59388);
    int j = this.ccP;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      aFr(8);
      i = this.ccP;
    }
    byte[] arrayOfByte = this.buffer;
    this.ccP = (i + 8);
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
  
  public final int Av()
  {
    AppMethodBeat.i(59378);
    if (hWy())
    {
      this.bPu = 0;
      AppMethodBeat.o(59378);
      return 0;
    }
    this.bPu = AK();
    if (aa.hP(this.bPu) == 0)
    {
      l locall = l.iNY();
      AppMethodBeat.o(59378);
      throw locall;
    }
    int i = this.bPu;
    AppMethodBeat.o(59378);
    return i;
  }
  
  public final <T extends r> T a(t<T> paramt, g paramg)
  {
    AppMethodBeat.i(59382);
    int i = AK();
    if (this.bPn >= this.bPo)
    {
      paramt = l.iOb();
      AppMethodBeat.o(59382);
      throw paramt;
    }
    i = gA(i);
    this.bPn += 1;
    paramt = (r)paramt.a(this, paramg);
    gy(0);
    this.bPn -= 1;
    gB(i);
    AppMethodBeat.o(59382);
    return paramt;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(59380);
    long l;
    switch (aa.hO(paramInt))
    {
    default: 
      paramf = l.iOa();
      AppMethodBeat.o(59380);
      throw paramf;
    case 0: 
      l = AN();
      paramf.hT(paramInt);
      paramf.aN(l);
      AppMethodBeat.o(59380);
      return true;
    case 1: 
      l = AP();
      paramf.hT(paramInt);
      paramf.Xz(l);
      AppMethodBeat.o(59380);
      return true;
    case 2: 
      d locald = iNL();
      paramf.hT(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(59380);
      return true;
    case 3: 
      paramf.hT(paramInt);
      do
      {
        i = Av();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = aa.bT(aa.hP(paramInt), 4);
      gy(paramInt);
      paramf.hT(paramInt);
      AppMethodBeat.o(59380);
      return true;
    case 4: 
      AppMethodBeat.o(59380);
      return false;
    }
    int i = AO();
    paramf.hT(paramInt);
    paramf.aFv(i);
    AppMethodBeat.o(59380);
    return true;
  }
  
  final byte[] aFt(int paramInt)
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
      localObject1 = l.iNW();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    if (this.abgg + this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.abgg - this.ccP);
      localObject1 = l.iNV();
      AppMethodBeat.o(59397);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.ccP;
      System.arraycopy(this.buffer, this.ccP, localObject1, 0, i);
      this.ccP = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.ccP < j) {
        aFr(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.ccP = (paramInt - i);
      AppMethodBeat.o(59397);
      return localObject1;
    }
    int m = this.ccP;
    int n = this.bufferSize;
    this.abgg += this.bufferSize;
    this.ccP = 0;
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
          localObject1 = l.iNV();
          AppMethodBeat.o(59397);
          throw ((Throwable)localObject1);
        }
        this.abgg += k;
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
  
  public final int gA(int paramInt)
  {
    AppMethodBeat.i(59391);
    l locall;
    if (paramInt < 0)
    {
      locall = l.iNW();
      AppMethodBeat.o(59391);
      throw locall;
    }
    paramInt = this.abgg + this.ccP + paramInt;
    int i = this.bPw;
    if (paramInt > i)
    {
      locall = l.iNV();
      AppMethodBeat.o(59391);
      throw locall;
    }
    this.bPw = paramInt;
    AQ();
    AppMethodBeat.o(59391);
    return i;
  }
  
  public final void gB(int paramInt)
  {
    AppMethodBeat.i(59392);
    this.bPw = paramInt;
    AQ();
    AppMethodBeat.o(59392);
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(59379);
    if (this.bPu != paramInt)
    {
      l locall = l.iNZ();
      AppMethodBeat.o(59379);
      throw locall;
    }
    AppMethodBeat.o(59379);
  }
  
  public final d iNL()
  {
    AppMethodBeat.i(59383);
    int i = AK();
    if ((i <= this.bufferSize - this.ccP) && (i > 0))
    {
      if ((this.abgf) && (this.bPv)) {}
      for (localObject = new c(this.buffer, this.ccP, i);; localObject = d.X(this.buffer, this.ccP, i))
      {
        this.ccP = (i + this.ccP);
        AppMethodBeat.o(59383);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.abgb;
      AppMethodBeat.o(59383);
      return localObject;
    }
    Object localObject = new q(aFt(i));
    AppMethodBeat.o(59383);
    return localObject;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.e
 * JD-Core Version:    0.7.0.1
 */