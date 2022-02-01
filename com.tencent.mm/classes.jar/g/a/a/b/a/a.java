package g.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int TDu;
  private int bNq;
  private int bNt;
  private int bNv;
  private int bNx;
  private byte[] buffer;
  private int bufferSize;
  private int cbm;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.bNt = 0;
    this.bNv = 0;
    this.TDu = 0;
    this.bNx = 2147483647;
    this.bNq = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.cbm = 0;
    this.input = null;
    AppMethodBeat.o(2420);
  }
  
  private boolean Fd(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.cbm < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.TDu + this.bufferSize == this.bNx)
    {
      if (paramBoolean)
      {
        localObject = b.hPp();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.TDu += this.bufferSize;
    this.cbm = 0;
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
      localObject = b.hPp();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    zo();
    i = this.TDu + this.bufferSize + this.bNt;
    if ((i > this.bNq) || (i < 0))
    {
      localObject = b.hPt();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  private int[] awi(int paramInt)
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
    b localb = b.hPr();
    AppMethodBeat.o(2415);
    throw localb;
  }
  
  private void fJ(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.hPq();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.TDu + this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.TDu - this.cbm);
      localb = b.hPp();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.cbm)
    {
      this.cbm += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.cbm;
    this.TDu += i;
    this.cbm = 0;
    this.bufferSize = 0;
    while (i < paramInt)
    {
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.hPp();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.TDu = (j + this.TDu);
    }
    AppMethodBeat.o(2424);
  }
  
  private byte[] ha(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.hPq();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.TDu + this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.TDu - this.cbm);
      localObject = b.hPp();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.cbm)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.cbm, localObject, 0, paramInt);
      this.cbm += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.cbm;
      System.arraycopy(this.buffer, this.cbm, localObject, 0, i);
      this.cbm = this.bufferSize;
      Fd(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.cbm = this.bufferSize;
        Fd(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.cbm = (paramInt - i);
      AppMethodBeat.o(2423);
      return localObject;
    }
    int m = this.cbm;
    int n = this.bufferSize;
    this.TDu += this.bufferSize;
    this.cbm = 0;
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
          localObject = b.hPp();
          AppMethodBeat.o(2423);
          throw ((Throwable)localObject);
        }
        this.TDu += k;
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
    AppMethodBeat.i(2422);
    if (this.cbm == this.bufferSize) {
      Fd(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.cbm;
    this.cbm = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
  }
  
  public final LinkedList<byte[]> awh(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = zi();
    Object localObject;
    OutOfMemoryError localOutOfMemoryError2;
    try
    {
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.cbm, localObject, 0, i);
      localLinkedList.add(localObject);
      this.cbm = (i + this.cbm);
      i = this.cbm;
      if (this.cbm == this.bufferSize)
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
      localObject = awi(i);
      if (g.a.a.b.a.gY(localObject[0]) != paramInt) {
        break;
      }
      this.cbm = localObject[1];
      i = zi();
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.cbm, localObject, 0, i);
      localOutOfMemoryError2.add(localObject);
      this.cbm = (i + this.cbm);
      if (this.cbm == this.bufferSize) {
        break;
      }
      i = this.cbm;
    }
    AppMethodBeat.o(2412);
    return localOutOfMemoryError2;
  }
  
  public final LinkedList<Integer> hPm()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    while (this.cbm < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(zi()));
    }
    AppMethodBeat.o(2410);
    return localLinkedList;
  }
  
  public final LinkedList<Long> hPn()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    while (this.cbm < this.bufferSize) {
      localLinkedList.add(Long.valueOf(zl()));
    }
    AppMethodBeat.o(183559);
    return localLinkedList;
  }
  
  public final com.tencent.mm.bw.b hPo()
  {
    AppMethodBeat.i(2414);
    int i = zi();
    if ((i < this.bufferSize - this.cbm) && (i > 0))
    {
      localb = com.tencent.mm.bw.b.Q(this.buffer, this.cbm, i);
      this.cbm = (i + this.cbm);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.bw.b localb = com.tencent.mm.bw.b.cD(ha(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = zi();
    if ((i < this.bufferSize - this.cbm) && (i > 0))
    {
      str = new String(this.buffer, this.cbm, i, "UTF-8");
      this.cbm = (i + this.cbm);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(ha(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
  
  public final int yT()
  {
    AppMethodBeat.i(168737);
    if ((this.cbm == this.bufferSize) && (!Fd(false)))
    {
      this.bNv = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.bNv = zi();
    if (this.bNv == 0)
    {
      b localb = b.hPs();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.bNv;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final boolean yZ()
  {
    AppMethodBeat.i(2411);
    if (zi() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int zi()
  {
    AppMethodBeat.i(2416);
    int i = zq();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = zq();
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
        j = zq();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = zq();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = zq();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (zq() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
    b localb = b.hPr();
    AppMethodBeat.o(2416);
    throw localb;
  }
  
  public final long zl()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
    b localb = b.hPr();
    AppMethodBeat.o(2417);
    throw localb;
  }
  
  public final int zm()
  {
    AppMethodBeat.i(2418);
    int i = zq();
    int j = zq();
    int k = zq();
    int m = zq();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long zn()
  {
    AppMethodBeat.i(2419);
    int i = zq();
    int j = zq();
    int k = zq();
    int m = zq();
    int n = zq();
    int i1 = zq();
    int i2 = zq();
    int i3 = zq();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     g.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */