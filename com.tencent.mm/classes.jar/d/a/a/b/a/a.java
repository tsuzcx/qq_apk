package d.a.a.b.a;

import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int aUA = 0;
  public int aUB;
  public int aUC = 0;
  private int aUD = 2147483647;
  private int aUG = 67108864;
  public byte[] buffer;
  public int bufferSize;
  private InputStream xpL;
  private int xpM = 0;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.aUB = 0;
    this.xpL = null;
  }
  
  private int[] KO(int paramInt)
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
        throw b.cUw();
      }
      if (this.buffer[j] >= 0) {
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private void dN(int paramInt)
  {
    if (paramInt < 0) {
      throw b.cUv();
    }
    if (this.xpM + this.aUB + paramInt > this.aUD)
    {
      dN(this.aUD - this.xpM - this.aUB);
      throw b.cUu();
    }
    if (paramInt < this.bufferSize - this.aUB) {
      this.aUB += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.bufferSize - this.aUB;
      this.xpM += i;
      this.aUB = 0;
      this.bufferSize = 0;
      while (i < paramInt)
      {
        if (this.xpL == null) {}
        for (int j = -1; j <= 0; j = (int)this.xpL.skip(paramInt - i)) {
          throw b.cUu();
        }
        i += j;
        this.xpM = (j + this.xpM);
      }
    }
  }
  
  private byte oH()
  {
    if (this.aUB == this.bufferSize) {
      oz(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.aUB;
    this.aUB = (i + 1);
    return arrayOfByte[i];
  }
  
  public final LinkedList<byte[]> KN(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = oD();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.aUB, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.aUB = (i + this.aUB);
      i = this.aUB;
      if (this.aUB == this.bufferSize) {
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new OutOfMemoryError("alloc bytes:" + i);
    }
    Object localObject = KO(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (d.a.a.b.a.dU(i) != paramInt) {}
      do
      {
        return localLinkedList;
        this.aUB = localObject[1];
        i = oD();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.aUB, localObject, 0, i);
        localLinkedList.add(localObject);
        this.aUB = (i + this.aUB);
      } while (this.aUB == this.bufferSize);
      localObject = KO(this.aUB);
    }
  }
  
  public final byte[] dM(int paramInt)
  {
    if (paramInt < 0) {
      throw b.cUv();
    }
    if (this.xpM + this.aUB + paramInt > this.aUD)
    {
      dN(this.aUD - this.xpM - this.aUB);
      throw b.cUu();
    }
    if (paramInt <= this.bufferSize - this.aUB)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.aUB, localObject, 0, paramInt);
      this.aUB += paramInt;
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.aUB;
      System.arraycopy(this.buffer, this.aUB, localObject, 0, i);
      this.aUB = this.bufferSize;
      oz(true);
      for (;;)
      {
        if (paramInt - i <= this.bufferSize)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.aUB = (paramInt - i);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.aUB = this.bufferSize;
        oz(true);
      }
    }
    int m = this.aUB;
    int n = this.bufferSize;
    this.xpM += this.bufferSize;
    this.aUB = 0;
    this.bufferSize = 0;
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
          if (this.xpL == null) {}
          for (int k = -1; k == -1; k = this.xpL.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
            throw b.cUu();
          }
          this.xpM += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  public final int oD()
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
        throw b.cUw();
      }
      i = k;
      if (oH() >= 0) {
        break;
      }
      j += 1;
    }
  }
  
  public final long oE()
  {
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64) {
        throw b.cUw();
      }
      int j = oH();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
  }
  
  public final boolean oz(boolean paramBoolean)
  {
    if (this.aUB < this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.xpM + this.bufferSize == this.aUD)
    {
      if (paramBoolean) {
        throw b.cUu();
      }
      return false;
    }
    this.xpM += this.bufferSize;
    this.aUB = 0;
    if (this.xpL == null) {}
    for (int i = -1;; i = this.xpL.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label117;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      throw b.cUu();
    }
    return false;
    label117:
    this.bufferSize += this.aUA;
    i = this.xpM + this.bufferSize;
    if (i > this.aUD)
    {
      this.aUA = (i - this.aUD);
      this.bufferSize -= this.aUA;
    }
    for (;;)
    {
      i = this.xpM + this.bufferSize + this.aUA;
      if ((i <= this.aUG) && (i >= 0)) {
        break;
      }
      throw b.cUy();
      this.aUA = 0;
    }
    return true;
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
    int i = oD();
    if ((i < this.bufferSize - this.aUB) && (i > 0))
    {
      String str = new String(this.buffer, this.aUB, i, "UTF-8");
      this.aUB = (i + this.aUB);
      return str;
    }
    return new String(dM(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */