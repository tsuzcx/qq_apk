package a.a.a.b.a;

import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int aqo;
  private int aqp = 0;
  private int aqq;
  private InputStream aqr;
  private int aqs = 0;
  private int aqt = 0;
  private int aqu = 2147483647;
  private int aqv = 67108864;
  private byte[] buffer;
  
  private a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.aqo = (paramInt + 0);
    this.aqq = 0;
    this.aqr = null;
  }
  
  private boolean L(boolean paramBoolean)
  {
    if (this.aqq < this.aqo) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.aqt + this.aqo == this.aqu)
    {
      if (paramBoolean) {
        throw b.pw();
      }
      return false;
    }
    this.aqt += this.aqo;
    this.aqq = 0;
    if (this.aqr == null) {}
    for (int i = -1;; i = this.aqr.read(this.buffer))
    {
      this.aqo = i;
      if (this.aqo != -1) {
        break label117;
      }
      this.aqo = 0;
      if (!paramBoolean) {
        break;
      }
      throw b.pw();
    }
    return false;
    label117:
    pu();
    i = this.aqt + this.aqo + this.aqp;
    if ((i > this.aqv) || (i < 0)) {
      throw b.pA();
    }
    return true;
  }
  
  private int[] cH(int paramInt)
  {
    int j = this.buffer[paramInt];
    int i = paramInt + 1;
    if (j >= 0) {
      return new int[] { j, i };
    }
    paramInt = j & 0x7F;
    j = this.buffer[i];
    if (j >= 0)
    {
      i += 1;
      paramInt |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        return new int[] { paramInt, i };
        paramInt |= (j & 0x7F) << 7;
        j = this.buffer[i];
        if (j >= 0)
        {
          i += 1;
          paramInt |= j << 14;
        }
        else
        {
          paramInt |= (j & 0x7F) << 14;
          j = this.buffer[i];
          if (j < 0) {
            break;
          }
          i += 1;
          paramInt |= j << 21;
        }
      }
      k = this.buffer[i];
      paramInt = paramInt | (j & 0x7F) << 21 | k << 28;
      j = i + 1;
      i = j;
    } while (k >= 0);
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= 5) {
        throw b.py();
      }
      if (this.buffer[j] >= 0) {
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private byte[] cI(int paramInt)
  {
    if (paramInt < 0) {
      throw b.px();
    }
    if (this.aqt + this.aqq + paramInt > this.aqu)
    {
      cJ(this.aqu - this.aqt - this.aqq);
      throw b.pw();
    }
    if (paramInt <= this.aqo - this.aqq)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.aqq, localObject, 0, paramInt);
      this.aqq += paramInt;
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.aqo - this.aqq;
      System.arraycopy(this.buffer, this.aqq, localObject, 0, i);
      this.aqq = this.aqo;
      L(true);
      for (;;)
      {
        if (paramInt - i <= this.aqo)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.aqq = (paramInt - i);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.aqo);
        i += this.aqo;
        this.aqq = this.aqo;
        L(true);
      }
    }
    int m = this.aqq;
    int n = this.aqo;
    this.aqt += this.aqo;
    this.aqq = 0;
    this.aqo = 0;
    Object localObject = new LinkedList();
    int i = paramInt - (n - m);
    byte[] arrayOfByte1;
    if (i <= 0)
    {
      arrayOfByte1 = new byte[paramInt];
      i = n - m;
      System.arraycopy(this.buffer, m, arrayOfByte1, 0, i);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= ((LinkedList)localObject).size())
      {
        return arrayOfByte1;
        arrayOfByte1 = new byte[Math.min(i, 2048)];
        int j = 0;
        for (;;)
        {
          if (j >= arrayOfByte1.length)
          {
            j = arrayOfByte1.length;
            ((LinkedList)localObject).add(arrayOfByte1);
            i -= j;
            break;
          }
          if (this.aqr == null) {}
          for (int k = -1; k == -1; k = this.aqr.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
            throw b.pw();
          }
          this.aqt += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  private void cJ(int paramInt)
  {
    if (paramInt < 0) {
      throw b.px();
    }
    if (this.aqt + this.aqq + paramInt > this.aqu)
    {
      cJ(this.aqu - this.aqt - this.aqq);
      throw b.pw();
    }
    if (paramInt < this.aqo - this.aqq) {
      this.aqq += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.aqo - this.aqq;
      this.aqt += i;
      this.aqq = 0;
      this.aqo = 0;
      while (i < paramInt)
      {
        if (this.aqr == null) {}
        for (int j = -1; j <= 0; j = (int)this.aqr.skip(paramInt - i)) {
          throw b.pw();
        }
        i += j;
        this.aqt = (j + this.aqt);
      }
    }
  }
  
  private int ps()
  {
    int i = pv();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = pv();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = pv();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = pv();
      if (k >= 0) {
        return i | k << 21;
      }
      j = pv();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        throw b.py();
      }
      i = k;
      if (pv() >= 0) {
        break;
      }
      j += 1;
    }
  }
  
  private void pu()
  {
    this.aqo += this.aqp;
    int i = this.aqt + this.aqo;
    if (i > this.aqu)
    {
      this.aqp = (i - this.aqu);
      this.aqo -= this.aqp;
      return;
    }
    this.aqp = 0;
  }
  
  private byte pv()
  {
    if (this.aqq == this.aqo) {
      L(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.aqq;
    this.aqq = (i + 1);
    return arrayOfByte[i];
  }
  
  public static a q(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final LinkedList<byte[]> cE(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = ps();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.aqq, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.aqq = (i + this.aqq);
      i = this.aqq;
      if (this.aqq == this.aqo) {
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new OutOfMemoryError("alloc bytes:".concat(String.valueOf(i)));
    }
    Object localObject = cH(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (a.a.a.b.a.cG(i) != paramInt) {}
      do
      {
        return localLinkedList;
        this.aqq = localObject[1];
        i = ps();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.aqq, localObject, 0, i);
        localLinkedList.add(localObject);
        this.aqq = (i + this.aqq);
      } while (this.aqq == this.aqo);
      localObject = cH(this.aqq);
    }
  }
  
  public final int po()
  {
    if ((this.aqq == this.aqo) && (!L(false)))
    {
      this.aqs = 0;
      return 0;
    }
    this.aqs = ps();
    if (this.aqs == 0) {
      throw b.pz();
    }
    return this.aqs;
  }
  
  public final int pp()
  {
    return ps();
  }
  
  public final boolean pq()
  {
    return ps() != 0;
  }
  
  public final com.tencent.mm.d.b pr()
  {
    int i = ps();
    if ((i < this.aqo - this.aqq) && (i > 0))
    {
      com.tencent.mm.d.b localb = new com.tencent.mm.d.b(this.buffer, this.aqq, i);
      this.aqq = (i + this.aqq);
      return localb;
    }
    return new com.tencent.mm.d.b(cI(i));
  }
  
  public final long pt()
  {
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64) {
        throw b.py();
      }
      int j = pv();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
  }
  
  public final double readDouble()
  {
    int i = pv();
    int j = pv();
    int k = pv();
    int m = pv();
    int n = pv();
    int i1 = pv();
    int i2 = pv();
    int i3 = pv();
    long l = i;
    return Double.longBitsToDouble((j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56);
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(pv() & 0xFF | (pv() & 0xFF) << 8 | (pv() & 0xFF) << 16 | (pv() & 0xFF) << 24);
  }
  
  public final String readString()
  {
    int i = ps();
    if ((i < this.aqo - this.aqq) && (i > 0))
    {
      String str = new String(this.buffer, this.aqq, i, "UTF-8");
      this.aqq = (i + this.aqq);
      return str;
    }
    return new String(cI(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */