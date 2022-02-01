package f.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int LzR;
  private int bGs;
  private int bGt;
  private int bGu;
  private int bGv;
  private int bGy;
  private byte[] buffer;
  private int bufferSize;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.bGs = 0;
    this.bGu = 0;
    this.LzR = 0;
    this.bGv = 2147483647;
    this.bGy = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.bGt = 0;
    this.input = null;
    AppMethodBeat.o(2420);
  }
  
  private int[] ajk(int paramInt)
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
    b localb = b.gfn();
    AppMethodBeat.o(2415);
    throw localb;
  }
  
  private byte[] fG(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.gfm();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.LzR + this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.LzR - this.bGt);
      localObject = b.gfl();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.bGt)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bGt, localObject, 0, paramInt);
      this.bGt += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bGt;
      System.arraycopy(this.buffer, this.bGt, localObject, 0, i);
      this.bGt = this.bufferSize;
      zK(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bGt = this.bufferSize;
        zK(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.bGt = (paramInt - i);
      AppMethodBeat.o(2423);
      return localObject;
    }
    int m = this.bGt;
    int n = this.bufferSize;
    this.LzR += this.bufferSize;
    this.bGt = 0;
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
          localObject = b.gfl();
          AppMethodBeat.o(2423);
          throw ((Throwable)localObject);
        }
        this.LzR += k;
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
  
  private void fH(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.gfm();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.LzR + this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.LzR - this.bGt);
      localb = b.gfl();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.bGt)
    {
      this.bGt += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.bGt;
    this.LzR += i;
    this.bGt = 0;
    this.bufferSize = 0;
    while (i < paramInt)
    {
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.gfl();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.LzR = (j + this.LzR);
    }
    AppMethodBeat.o(2424);
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
    AppMethodBeat.i(2422);
    if (this.bGt == this.bufferSize) {
      zK(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bGt;
    this.bGt = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
  }
  
  private boolean zK(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.bGt < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.LzR + this.bufferSize == this.bGv)
    {
      if (paramBoolean)
      {
        localObject = b.gfl();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.LzR += this.bufferSize;
    this.bGt = 0;
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
      localObject = b.gfl();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    xH();
    i = this.LzR + this.bufferSize + this.bGs;
    if ((i > this.bGy) || (i < 0))
    {
      localObject = b.gfp();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  public final LinkedList<byte[]> ajj(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = xF();
    Object localObject;
    OutOfMemoryError localOutOfMemoryError2;
    try
    {
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.bGt, localObject, 0, i);
      localLinkedList.add(localObject);
      this.bGt = (i + this.bGt);
      i = this.bGt;
      if (this.bGt == this.bufferSize)
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
      localObject = ajk(i);
      if (f.a.a.b.a.fO(localObject[0]) != paramInt) {
        break;
      }
      this.bGt = localObject[1];
      i = xF();
      localObject = new byte[i];
      System.arraycopy(this.buffer, this.bGt, localObject, 0, i);
      localOutOfMemoryError2.add(localObject);
      this.bGt = (i + this.bGt);
      if (this.bGt == this.bufferSize) {
        break;
      }
      i = this.bGt;
    }
    AppMethodBeat.o(2412);
    return localOutOfMemoryError2;
  }
  
  public final boolean fZX()
  {
    AppMethodBeat.i(2411);
    if (xF() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int gaa()
  {
    AppMethodBeat.i(2418);
    int i = xJ();
    int j = xJ();
    int k = xJ();
    int m = xJ();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long gab()
  {
    AppMethodBeat.i(2419);
    int i = xJ();
    int j = xJ();
    int k = xJ();
    int m = xJ();
    int n = xJ();
    int i1 = xJ();
    int i2 = xJ();
    int i3 = xJ();
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
  
  public final LinkedList<Integer> gfi()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    while (this.bGt < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(xF()));
    }
    AppMethodBeat.o(2410);
    return localLinkedList;
  }
  
  public final LinkedList<Long> gfj()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    while (this.bGt < this.bufferSize) {
      localLinkedList.add(Long.valueOf(xG()));
    }
    AppMethodBeat.o(183559);
    return localLinkedList;
  }
  
  public final com.tencent.mm.bw.b gfk()
  {
    AppMethodBeat.i(2414);
    int i = xF();
    if ((i < this.bufferSize - this.bGt) && (i > 0))
    {
      localb = com.tencent.mm.bw.b.E(this.buffer, this.bGt, i);
      this.bGt = (i + this.bGt);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.bw.b localb = com.tencent.mm.bw.b.cc(fG(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = xF();
    if ((i < this.bufferSize - this.bGt) && (i > 0))
    {
      str = new String(this.buffer, this.bGt, i, "UTF-8");
      this.bGt = (i + this.bGt);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(fG(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
  
  public final int xE()
  {
    AppMethodBeat.i(168737);
    if ((this.bGt == this.bufferSize) && (!zK(false)))
    {
      this.bGu = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.bGu = xF();
    if (this.bGu == 0)
    {
      b localb = b.gfo();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.bGu;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final int xF()
  {
    AppMethodBeat.i(2416);
    int i = xJ();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = xJ();
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
        j = xJ();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = xJ();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = xJ();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (xJ() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
    b localb = b.gfn();
    AppMethodBeat.o(2416);
    throw localb;
  }
  
  public final long xG()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = xJ();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
    b localb = b.gfn();
    AppMethodBeat.o(2417);
    throw localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */