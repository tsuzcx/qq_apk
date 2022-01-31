package a.a.a.b.a;

import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int amM;
  private int amN = 0;
  private int amO;
  private InputStream amP;
  private int amQ = 0;
  private int amR = 0;
  private int amS = 2147483647;
  private int amT = 67108864;
  private byte[] buffer;
  
  private a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.amM = (paramInt + 0);
    this.amO = 0;
    this.amP = null;
  }
  
  private boolean I(boolean paramBoolean)
  {
    if (this.amO < this.amM) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.amR + this.amM == this.amS)
    {
      if (paramBoolean) {
        throw b.oI();
      }
      return false;
    }
    this.amR += this.amM;
    this.amO = 0;
    if (this.amP == null) {}
    for (int i = -1;; i = this.amP.read(this.buffer))
    {
      this.amM = i;
      if (this.amM != -1) {
        break label117;
      }
      this.amM = 0;
      if (!paramBoolean) {
        break;
      }
      throw b.oI();
    }
    return false;
    label117:
    this.amM += this.amN;
    i = this.amR + this.amM;
    if (i > this.amS)
    {
      this.amN = (i - this.amS);
      this.amM -= this.amN;
    }
    for (;;)
    {
      i = this.amR + this.amM + this.amN;
      if ((i <= this.amT) && (i >= 0)) {
        break;
      }
      throw b.oM();
      this.amN = 0;
    }
    return true;
  }
  
  private int[] cl(int paramInt)
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
        throw b.oK();
      }
      if (this.buffer[j] >= 0) {
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private byte[] cm(int paramInt)
  {
    if (paramInt < 0) {
      throw b.oJ();
    }
    if (this.amR + this.amO + paramInt > this.amS)
    {
      cn(this.amS - this.amR - this.amO);
      throw b.oI();
    }
    if (paramInt <= this.amM - this.amO)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.amO, localObject, 0, paramInt);
      this.amO += paramInt;
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.amM - this.amO;
      System.arraycopy(this.buffer, this.amO, localObject, 0, i);
      this.amO = this.amM;
      I(true);
      for (;;)
      {
        if (paramInt - i <= this.amM)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.amO = (paramInt - i);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.amM);
        i += this.amM;
        this.amO = this.amM;
        I(true);
      }
    }
    int m = this.amO;
    int n = this.amM;
    this.amR += this.amM;
    this.amO = 0;
    this.amM = 0;
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
          if (this.amP == null) {}
          for (int k = -1; k == -1; k = this.amP.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
            throw b.oI();
          }
          this.amR += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  private void cn(int paramInt)
  {
    if (paramInt < 0) {
      throw b.oJ();
    }
    if (this.amR + this.amO + paramInt > this.amS)
    {
      cn(this.amS - this.amR - this.amO);
      throw b.oI();
    }
    if (paramInt < this.amM - this.amO) {
      this.amO += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.amM - this.amO;
      this.amR += i;
      this.amO = 0;
      this.amM = 0;
      while (i < paramInt)
      {
        if (this.amP == null) {}
        for (int j = -1; j <= 0; j = (int)this.amP.skip(paramInt - i)) {
          throw b.oI();
        }
        i += j;
        this.amR = (j + this.amR);
      }
    }
  }
  
  private int oF()
  {
    int i = oH();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = oH();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = oH();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = oH();
      if (k >= 0) {
        return i | k << 21;
      }
      j = oH();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        throw b.oK();
      }
      i = k;
      if (oH() >= 0) {
        break;
      }
      j += 1;
    }
  }
  
  private byte oH()
  {
    if (this.amO == this.amM) {
      I(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.amO;
    this.amO = (i + 1);
    return arrayOfByte[i];
  }
  
  public static a q(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final LinkedList<byte[]> ci(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = oF();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.amO, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.amO = (i + this.amO);
      i = this.amO;
      if (this.amO == this.amM) {
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new OutOfMemoryError("alloc bytes:" + i);
    }
    Object localObject = cl(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (a.a.a.b.a.ck(i) != paramInt) {}
      do
      {
        return localLinkedList;
        this.amO = localObject[1];
        i = oF();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.amO, localObject, 0, i);
        localLinkedList.add(localObject);
        this.amO = (i + this.amO);
      } while (this.amO == this.amM);
      localObject = cl(this.amO);
    }
  }
  
  public final int oB()
  {
    if ((this.amO == this.amM) && (!I(false)))
    {
      this.amQ = 0;
      return 0;
    }
    this.amQ = oF();
    if (this.amQ == 0) {
      throw b.oL();
    }
    return this.amQ;
  }
  
  public final int oC()
  {
    return oF();
  }
  
  public final boolean oD()
  {
    return oF() != 0;
  }
  
  public final com.tencent.mm.d.b oE()
  {
    int i = oF();
    if ((i < this.amM - this.amO) && (i > 0))
    {
      com.tencent.mm.d.b localb = new com.tencent.mm.d.b(this.buffer, this.amO, i);
      this.amO = (i + this.amO);
      return localb;
    }
    return new com.tencent.mm.d.b(cm(i));
  }
  
  public final long oG()
  {
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64) {
        throw b.oK();
      }
      int j = oH();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
  }
  
  public final double readDouble()
  {
    int i = oH();
    int j = oH();
    int k = oH();
    int m = oH();
    int n = oH();
    int i1 = oH();
    int i2 = oH();
    int i3 = oH();
    long l = i;
    return Double.longBitsToDouble((j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56);
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(oH() & 0xFF | (oH() & 0xFF) << 8 | (oH() & 0xFF) << 16 | (oH() & 0xFF) << 24);
  }
  
  public final String readString()
  {
    int i = oF();
    if ((i < this.amM - this.amO) && (i > 0))
    {
      String str = new String(this.buffer, this.amO, i, "UTF-8");
      this.amO = (i + this.amO);
      return str;
    }
    return new String(cm(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */