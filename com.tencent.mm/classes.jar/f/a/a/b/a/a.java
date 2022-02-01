package f.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int NNU;
  private int bQG;
  private int bQH;
  private int bQI;
  private int bQJ;
  private int bQM;
  private byte[] buffer;
  private int bufferSize;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.bQG = 0;
    this.bQI = 0;
    this.NNU = 0;
    this.bQJ = 2147483647;
    this.bQM = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.bQH = 0;
    this.input = null;
    AppMethodBeat.o(2420);
  }
  
  private boolean AN(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.bQH < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.NNU + this.bufferSize == this.bQJ)
    {
      if (paramBoolean)
      {
        localObject = b.gCl();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.NNU += this.bufferSize;
    this.bQH = 0;
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
      localObject = b.gCl();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    ze();
    i = this.NNU + this.bufferSize + this.bQG;
    if ((i > this.bQM) || (i < 0))
    {
      localObject = b.gCp();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  private int[] amB(int paramInt)
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
    b localb = b.gCn();
    AppMethodBeat.o(2415);
    throw localb;
  }
  
  private byte[] fJ(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.gCm();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.NNU + this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.NNU - this.bQH);
      localObject = b.gCl();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.bQH)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bQH, localObject, 0, paramInt);
      this.bQH += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bQH;
      System.arraycopy(this.buffer, this.bQH, localObject, 0, i);
      this.bQH = this.bufferSize;
      AN(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bQH = this.bufferSize;
        AN(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.bQH = (paramInt - i);
      AppMethodBeat.o(2423);
      return localObject;
    }
    int m = this.bQH;
    int n = this.bufferSize;
    this.NNU += this.bufferSize;
    this.bQH = 0;
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
          localObject = b.gCl();
          AppMethodBeat.o(2423);
          throw ((Throwable)localObject);
        }
        this.NNU += k;
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
  
  private void fK(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.gCm();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.NNU + this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.NNU - this.bQH);
      localb = b.gCl();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.bQH)
    {
      this.bQH += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.bQH;
    this.NNU += i;
    this.bQH = 0;
    this.bufferSize = 0;
    while (i < paramInt)
    {
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.gCl();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.NNU = (j + this.NNU);
    }
    AppMethodBeat.o(2424);
  }
  
  private void ze()
  {
    this.bufferSize += this.bQG;
    int i = this.NNU + this.bufferSize;
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
    AppMethodBeat.i(2422);
    if (this.bQH == this.bufferSize) {
      AN(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bQH;
    this.bQH = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
  }
  
  public final LinkedList<byte[]> amA(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = zc();
    Object localObject;
    OutOfMemoryError localOutOfMemoryError2;
    try
    {
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.bQH, localObject, 0, i);
      localLinkedList.add(localObject);
      this.bQH = (i + this.bQH);
      i = this.bQH;
      if (this.bQH == this.bufferSize)
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
      localObject = amB(i);
      if (f.a.a.b.a.fR(localObject[0]) != paramInt) {
        break;
      }
      this.bQH = localObject[1];
      i = zc();
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.bQH, localObject, 0, i);
      localOutOfMemoryError2.add(localObject);
      this.bQH = (i + this.bQH);
      if (this.bQH == this.bufferSize) {
        break;
      }
      i = this.bQH;
    }
    AppMethodBeat.o(2412);
    return localOutOfMemoryError2;
  }
  
  public final LinkedList<Integer> gCi()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    while (this.bQH < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(zc()));
    }
    AppMethodBeat.o(2410);
    return localLinkedList;
  }
  
  public final LinkedList<Long> gCj()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    while (this.bQH < this.bufferSize) {
      localLinkedList.add(Long.valueOf(zd()));
    }
    AppMethodBeat.o(183559);
    return localLinkedList;
  }
  
  public final com.tencent.mm.bw.b gCk()
  {
    AppMethodBeat.i(2414);
    int i = zc();
    if ((i < this.bufferSize - this.bQH) && (i > 0))
    {
      localb = com.tencent.mm.bw.b.G(this.buffer, this.bQH, i);
      this.bQH = (i + this.bQH);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.bw.b localb = com.tencent.mm.bw.b.cm(fJ(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final boolean gvY()
  {
    AppMethodBeat.i(2411);
    if (zc() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int gwb()
  {
    AppMethodBeat.i(2418);
    int i = zg();
    int j = zg();
    int k = zg();
    int m = zg();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long gwc()
  {
    AppMethodBeat.i(2419);
    int i = zg();
    int j = zg();
    int k = zg();
    int m = zg();
    int n = zg();
    int i1 = zg();
    int i2 = zg();
    int i3 = zg();
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
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = zc();
    if ((i < this.bufferSize - this.bQH) && (i > 0))
    {
      str = new String(this.buffer, this.bQH, i, "UTF-8");
      this.bQH = (i + this.bQH);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(fJ(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
  
  public final int zb()
  {
    AppMethodBeat.i(168737);
    if ((this.bQH == this.bufferSize) && (!AN(false)))
    {
      this.bQI = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.bQI = zc();
    if (this.bQI == 0)
    {
      b localb = b.gCo();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.bQI;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final int zc()
  {
    AppMethodBeat.i(2416);
    int i = zg();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = zg();
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
        j = zg();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = zg();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = zg();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (zg() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
    b localb = b.gCn();
    AppMethodBeat.o(2416);
    throw localb;
  }
  
  public final long zd()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
    b localb = b.gCn();
    AppMethodBeat.o(2417);
    throw localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */