package g.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int abgg;
  private int bPp;
  private int bPs;
  private int bPu;
  private int bPw;
  private byte[] buffer;
  private int bufferSize;
  private int ccP;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.bPs = 0;
    this.bPu = 0;
    this.abgg = 0;
    this.bPw = 2147483647;
    this.bPp = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.ccP = 0;
    this.input = null;
    AppMethodBeat.o(2420);
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
    AppMethodBeat.i(2422);
    if (this.ccP == this.bufferSize) {
      JM(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.ccP;
    this.ccP = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
  }
  
  private boolean JM(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.ccP < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.abgg + this.bufferSize == this.bPw)
    {
      if (paramBoolean)
      {
        localObject = b.iUx();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.abgg += this.bufferSize;
    this.ccP = 0;
    if (this.input == null) {}
    for (int i = -1;; i = this.input.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label159;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      localObject = b.iUx();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    AQ();
    i = this.abgg + this.bufferSize + this.bPs;
    if ((i > this.bPp) || (i < 0))
    {
      localObject = b.iUB();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  private int[] aGd(int paramInt)
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
    b localb = b.iUz();
    AppMethodBeat.o(2415);
    throw localb;
  }
  
  private void gC(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.iUy();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.abgg + this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.abgg - this.ccP);
      localb = b.iUx();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.ccP)
    {
      this.ccP += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.ccP;
    this.abgg += i;
    this.ccP = 0;
    this.bufferSize = 0;
    while (i < paramInt)
    {
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.iUx();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.abgg = (j + this.abgg);
    }
    AppMethodBeat.o(2424);
  }
  
  private byte[] hR(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.iUy();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.abgg + this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.abgg - this.ccP);
      localObject = b.iUx();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.ccP)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.ccP, localObject, 0, paramInt);
      this.ccP += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.ccP;
      System.arraycopy(this.buffer, this.ccP, localObject, 0, i);
      this.ccP = this.bufferSize;
      JM(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.ccP = this.bufferSize;
        JM(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.ccP = (paramInt - i);
      AppMethodBeat.o(2423);
      return localObject;
    }
    int m = this.ccP;
    int n = this.bufferSize;
    this.abgg += this.bufferSize;
    this.ccP = 0;
    this.bufferSize = 0;
    Object localObject = new LinkedList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      arrayOfByte1 = new byte[Math.min(i, 2048)];
      int j = 0;
      while (j < arrayOfByte1.length)
      {
        if (this.input == null) {}
        for (int k = -1; k == -1; k = this.input.read(arrayOfByte1, j, arrayOfByte1.length - j))
        {
          localObject = b.iUx();
          AppMethodBeat.o(2423);
          throw ((Throwable)localObject);
        }
        this.abgg += k;
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
  
  public final boolean AB()
  {
    AppMethodBeat.i(2411);
    if (AK() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int AK()
  {
    AppMethodBeat.i(2416);
    int i = AS();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = AS();
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
        j = AS();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = AS();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = AS();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (AS() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
    b localb = b.iUz();
    AppMethodBeat.o(2416);
    throw localb;
  }
  
  public final long AN()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = AS();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
    b localb = b.iUz();
    AppMethodBeat.o(2417);
    throw localb;
  }
  
  public final int AO()
  {
    AppMethodBeat.i(2418);
    int i = AS();
    int j = AS();
    int k = AS();
    int m = AS();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long AP()
  {
    AppMethodBeat.i(2419);
    int i = AS();
    int j = AS();
    int k = AS();
    int m = AS();
    int n = AS();
    int i1 = AS();
    int i2 = AS();
    int i3 = AS();
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
  
  public final int Av()
  {
    AppMethodBeat.i(168737);
    if ((this.ccP == this.bufferSize) && (!JM(false)))
    {
      this.bPu = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.bPu = AK();
    if (this.bPu == 0)
    {
      b localb = b.iUA();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.bPu;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final LinkedList<byte[]> aGc(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = AK();
    Object localObject;
    OutOfMemoryError localOutOfMemoryError2;
    try
    {
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.ccP, localObject, 0, i);
      localLinkedList.add(localObject);
      this.ccP = (i + this.ccP);
      i = this.ccP;
      if (this.ccP == this.bufferSize)
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
      localObject = aGd(i);
      if (g.a.a.b.a.hP(localObject[0]) != paramInt) {
        break;
      }
      this.ccP = localObject[1];
      i = AK();
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.ccP, localObject, 0, i);
      localOutOfMemoryError2.add(localObject);
      this.ccP = (i + this.ccP);
      if (this.ccP == this.bufferSize) {
        break;
      }
      i = this.ccP;
    }
    AppMethodBeat.o(2412);
    return localOutOfMemoryError2;
  }
  
  public final LinkedList<Integer> iUu()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    while (this.ccP < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(AK()));
    }
    AppMethodBeat.o(2410);
    return localLinkedList;
  }
  
  public final LinkedList<Long> iUv()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    while (this.ccP < this.bufferSize) {
      localLinkedList.add(Long.valueOf(AN()));
    }
    AppMethodBeat.o(183559);
    return localLinkedList;
  }
  
  public final com.tencent.mm.cd.b iUw()
  {
    AppMethodBeat.i(2414);
    int i = AK();
    if ((i < this.bufferSize - this.ccP) && (i > 0))
    {
      localb = com.tencent.mm.cd.b.S(this.buffer, this.ccP, i);
      this.ccP = (i + this.ccP);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.cd.b localb = com.tencent.mm.cd.b.cU(hR(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = AK();
    if ((i < this.bufferSize - this.ccP) && (i > 0))
    {
      str = new String(this.buffer, this.ccP, i, "UTF-8");
      this.ccP = (i + this.ccP);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(hR(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     g.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */