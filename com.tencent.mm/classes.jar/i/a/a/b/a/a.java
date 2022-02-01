package i.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private byte[] buffer;
  private int bufferSize;
  private int dIT;
  private int dIX;
  private int dIZ;
  private int dJb;
  private InputStream dJc;
  private int dJd;
  private int dXt;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.dIX = 0;
    this.dIZ = 0;
    this.dJd = 0;
    this.dJb = 2147483647;
    this.dIT = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.dXt = 0;
    this.dJc = null;
    AppMethodBeat.o(2420);
  }
  
  private boolean PR(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.dXt < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.dJd + this.bufferSize == this.dJb)
    {
      if (paramBoolean)
      {
        localObject = b.kFY();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.dJd += this.bufferSize;
    this.dXt = 0;
    if (this.dJc == null) {}
    for (int i = -1;; i = this.dJc.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label159;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      localObject = b.kFY();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    aaz();
    i = this.dJd + this.bufferSize + this.dIX;
    if ((i > this.dIT) || (i < 0))
    {
      localObject = b.kGc();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  private int[] aMQ(int paramInt)
  {
    AppMethodBeat.i(2415);
    int j = this.buffer[paramInt];
    int i = paramInt + 1;
    if (j >= 0)
    {
      AppMethodBeat.o(2415);
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
        AppMethodBeat.o(2415);
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
    while (paramInt < 5)
    {
      if (this.buffer[j] >= 0)
      {
        AppMethodBeat.o(2415);
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
    b localb = b.kGa();
    AppMethodBeat.o(2415);
    throw localb;
  }
  
  private byte aaA()
  {
    AppMethodBeat.i(2422);
    if (this.dXt == this.bufferSize) {
      PR(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.dXt;
    this.dXt = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
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
  
  private void jR(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.kFZ();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.dJd + this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dJd - this.dXt);
      localb = b.kFY();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.dXt)
    {
      this.dXt += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.dXt;
    this.dJd += i;
    this.dXt = 0;
    this.bufferSize = 0;
    while (i < paramInt)
    {
      if (this.dJc == null) {}
      for (int j = -1; j <= 0; j = (int)this.dJc.skip(paramInt - i))
      {
        localb = b.kFY();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.dJd = (j + this.dJd);
    }
    AppMethodBeat.o(2424);
  }
  
  private byte[] lG(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.kFZ();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.dJd + this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dJd - this.dXt);
      localObject = b.kFY();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.dXt)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.dXt, localObject, 0, paramInt);
      this.dXt += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.dXt;
      System.arraycopy(this.buffer, this.dXt, localObject, 0, i);
      this.dXt = this.bufferSize;
      PR(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.dXt = this.bufferSize;
        PR(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.dXt = (paramInt - i);
      AppMethodBeat.o(2423);
      return localObject;
    }
    int m = this.dXt;
    int n = this.bufferSize;
    this.dJd += this.bufferSize;
    this.dXt = 0;
    this.bufferSize = 0;
    Object localObject = new LinkedList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      arrayOfByte1 = new byte[Math.min(i, 2048)];
      int j = 0;
      while (j < arrayOfByte1.length)
      {
        if (this.dJc == null) {}
        for (int k = -1; k == -1; k = this.dJc.read(arrayOfByte1, j, arrayOfByte1.length - j))
        {
          localObject = b.kFY();
          AppMethodBeat.o(2423);
          throw ((Throwable)localObject);
        }
        this.dJd += k;
        j += k;
      }
      j = arrayOfByte1.length;
      ((LinkedList)localObject).add(arrayOfByte1);
      i -= j;
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    i = n - m;
    System.arraycopy(this.buffer, m, arrayOfByte1, 0, i);
    paramInt = 0;
    while (paramInt < ((LinkedList)localObject).size())
    {
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
    AppMethodBeat.o(2423);
    return arrayOfByte1;
  }
  
  public final LinkedList<byte[]> aMP(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = aar();
    Object localObject;
    OutOfMemoryError localOutOfMemoryError2;
    try
    {
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.dXt, localObject, 0, i);
      localLinkedList.add(localObject);
      this.dXt = (i + this.dXt);
      i = this.dXt;
      if (this.dXt == this.bufferSize)
      {
        AppMethodBeat.o(2412);
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOutOfMemoryError2 = new OutOfMemoryError("alloc bytes:".concat(String.valueOf(i)));
      AppMethodBeat.o(2412);
      throw localOutOfMemoryError2;
    }
    for (;;)
    {
      localObject = aMQ(i);
      if (i.a.a.b.a.lE(localObject[0]) != paramInt) {
        break;
      }
      this.dXt = localObject[1];
      i = aar();
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.dXt, localObject, 0, i);
      localOutOfMemoryError2.add(localObject);
      this.dXt = (i + this.dXt);
      if (this.dXt == this.bufferSize) {
        break;
      }
      i = this.dXt;
    }
    AppMethodBeat.o(2412);
    return localOutOfMemoryError2;
  }
  
  public final int aac()
  {
    AppMethodBeat.i(168737);
    if ((this.dXt == this.bufferSize) && (!PR(false)))
    {
      this.dIZ = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.dIZ = aar();
    if (this.dIZ == 0)
    {
      b localb = b.kGb();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.dIZ;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(2411);
    if (aar() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int aar()
  {
    AppMethodBeat.i(2416);
    int i = aaA();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = aaA();
    if (j >= 0) {
      i |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        AppMethodBeat.o(2416);
        return i;
        i |= (j & 0x7F) << 7;
        j = aaA();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = aaA();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = aaA();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (aaA() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
    b localb = b.kGa();
    AppMethodBeat.o(2416);
    throw localb;
  }
  
  public final long aaw()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = aaA();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
    b localb = b.kGa();
    AppMethodBeat.o(2417);
    throw localb;
  }
  
  public final int aax()
  {
    AppMethodBeat.i(2418);
    int i = aaA();
    int j = aaA();
    int k = aaA();
    int m = aaA();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long aay()
  {
    AppMethodBeat.i(2419);
    int i = aaA();
    int j = aaA();
    int k = aaA();
    int m = aaA();
    int n = aaA();
    int i1 = aaA();
    int i2 = aaA();
    int i3 = aaA();
    long l1 = i;
    long l2 = j;
    long l3 = k;
    long l4 = m;
    long l5 = n;
    long l6 = i1;
    long l7 = i2;
    long l8 = i3;
    AppMethodBeat.o(2419);
    return (l2 & 0xFF) << 8 | l1 & 0xFF | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (l8 & 0xFF) << 56;
  }
  
  public final LinkedList<Integer> kFV()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    while (this.dXt < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(aar()));
    }
    AppMethodBeat.o(2410);
    return localLinkedList;
  }
  
  public final LinkedList<Long> kFW()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    while (this.dXt < this.bufferSize) {
      localLinkedList.add(Long.valueOf(aaw()));
    }
    AppMethodBeat.o(183559);
    return localLinkedList;
  }
  
  public final com.tencent.mm.bx.b kFX()
  {
    AppMethodBeat.i(2414);
    int i = aar();
    if ((i < this.bufferSize - this.dXt) && (i > 0))
    {
      localb = com.tencent.mm.bx.b.P(this.buffer, this.dXt, i);
      this.dXt = (i + this.dXt);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.bx.b localb = com.tencent.mm.bx.b.cX(lG(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = aar();
    if ((i < this.bufferSize - this.dXt) && (i > 0))
    {
      str = new String(this.buffer, this.dXt, i, "UTF-8");
      this.dXt = (i + this.dXt);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(lG(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     i.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */