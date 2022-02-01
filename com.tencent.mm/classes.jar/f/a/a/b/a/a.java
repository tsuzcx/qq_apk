package f.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int JMy;
  private int bIK;
  private int bIL;
  private int bIM;
  private int bIN;
  private int bIQ;
  private byte[] buffer;
  private int bufferSize;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2420);
    this.bIK = 0;
    this.bIM = 0;
    this.JMy = 0;
    this.bIN = 2147483647;
    this.bIQ = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.bIL = 0;
    this.input = null;
    AppMethodBeat.o(2420);
  }
  
  private int[] ago(int paramInt)
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
    for (;;)
    {
      if (paramInt >= 5)
      {
        b localb = b.fMx();
        AppMethodBeat.o(2415);
        throw localb;
      }
      if (this.buffer[j] >= 0)
      {
        AppMethodBeat.o(2415);
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private byte[] fU(int paramInt)
  {
    AppMethodBeat.i(2423);
    if (paramInt < 0)
    {
      localObject = b.fMw();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (this.JMy + this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.JMy - this.bIL);
      localObject = b.fMv();
      AppMethodBeat.o(2423);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.bIL)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bIL, localObject, 0, paramInt);
      this.bIL += paramInt;
      AppMethodBeat.o(2423);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bIL;
      System.arraycopy(this.buffer, this.bIL, localObject, 0, i);
      this.bIL = this.bufferSize;
      ys(true);
      for (;;)
      {
        if (paramInt - i <= this.bufferSize)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.bIL = (paramInt - i);
          AppMethodBeat.o(2423);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bIL = this.bufferSize;
        ys(true);
      }
    }
    int m = this.bIL;
    int n = this.bufferSize;
    this.JMy += this.bufferSize;
    this.bIL = 0;
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
        AppMethodBeat.o(2423);
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
          if (this.input == null) {}
          for (int k = -1; k == -1; k = this.input.read(arrayOfByte1, j, arrayOfByte1.length - j))
          {
            localObject = b.fMv();
            AppMethodBeat.o(2423);
            throw ((Throwable)localObject);
          }
          this.JMy += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  private void fV(int paramInt)
  {
    AppMethodBeat.i(2424);
    b localb;
    if (paramInt < 0)
    {
      localb = b.fMw();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (this.JMy + this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.JMy - this.bIL);
      localb = b.fMv();
      AppMethodBeat.o(2424);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.bIL)
    {
      this.bIL += paramInt;
      AppMethodBeat.o(2424);
      return;
    }
    int i = this.bufferSize - this.bIL;
    this.JMy += i;
    this.bIL = 0;
    this.bufferSize = 0;
    for (;;)
    {
      if (i >= paramInt)
      {
        AppMethodBeat.o(2424);
        return;
      }
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.fMv();
        AppMethodBeat.o(2424);
        throw localb;
      }
      i += j;
      this.JMy = (j + this.JMy);
    }
  }
  
  private void xU()
  {
    this.bufferSize += this.bIK;
    int i = this.JMy + this.bufferSize;
    if (i > this.bIN)
    {
      this.bIK = (i - this.bIN);
      this.bufferSize -= this.bIK;
      return;
    }
    this.bIK = 0;
  }
  
  private byte xW()
  {
    AppMethodBeat.i(2422);
    if (this.bIL == this.bufferSize) {
      ys(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bIL;
    this.bIL = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(2422);
    return b;
  }
  
  private boolean ys(boolean paramBoolean)
  {
    AppMethodBeat.i(2421);
    Object localObject;
    if (this.bIL < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    if (this.JMy + this.bufferSize == this.bIN)
    {
      if (paramBoolean)
      {
        localObject = b.fMv();
        AppMethodBeat.o(2421);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(2421);
      return false;
    }
    this.JMy += this.bufferSize;
    this.bIL = 0;
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
      localObject = b.fMv();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return false;
    label159:
    xU();
    i = this.JMy + this.bufferSize + this.bIK;
    if ((i > this.bIQ) || (i < 0))
    {
      localObject = b.fMz();
      AppMethodBeat.o(2421);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(2421);
    return true;
  }
  
  public final LinkedList<byte[]> agn(int paramInt)
  {
    AppMethodBeat.i(2412);
    LinkedList localLinkedList = new LinkedList();
    int i = xS();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bIL, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.bIL = (i + this.bIL);
      i = this.bIL;
      if (this.bIL == this.bufferSize)
      {
        AppMethodBeat.o(2412);
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = new OutOfMemoryError("alloc bytes:".concat(String.valueOf(i)));
      AppMethodBeat.o(2412);
      throw ((Throwable)localObject);
    }
    Object localObject = ago(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (f.a.a.b.a.gc(i) != paramInt) {}
      do
      {
        AppMethodBeat.o(2412);
        return localLinkedList;
        this.bIL = localObject[1];
        i = xS();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.bIL, localObject, 0, i);
        localLinkedList.add(localObject);
        this.bIL = (i + this.bIL);
      } while (this.bIL == this.bufferSize);
      localObject = ago(this.bIL);
    }
  }
  
  public final boolean fHu()
  {
    AppMethodBeat.i(2411);
    if (xS() != 0)
    {
      AppMethodBeat.o(2411);
      return true;
    }
    AppMethodBeat.o(2411);
    return false;
  }
  
  public final int fHx()
  {
    AppMethodBeat.i(2418);
    int i = xW();
    int j = xW();
    int k = xW();
    int m = xW();
    AppMethodBeat.o(2418);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long fHy()
  {
    AppMethodBeat.i(2419);
    int i = xW();
    int j = xW();
    int k = xW();
    int m = xW();
    int n = xW();
    int i1 = xW();
    int i2 = xW();
    int i3 = xW();
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
  
  public final LinkedList<Integer> fMs()
  {
    AppMethodBeat.i(2410);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (this.bIL >= this.bufferSize)
      {
        AppMethodBeat.o(2410);
        return localLinkedList;
      }
      localLinkedList.add(Integer.valueOf(xS()));
    }
  }
  
  public final LinkedList<Long> fMt()
  {
    AppMethodBeat.i(183559);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (this.bIL >= this.bufferSize)
      {
        AppMethodBeat.o(183559);
        return localLinkedList;
      }
      localLinkedList.add(Long.valueOf(xT()));
    }
  }
  
  public final com.tencent.mm.bx.b fMu()
  {
    AppMethodBeat.i(2414);
    int i = xS();
    if ((i < this.bufferSize - this.bIL) && (i > 0))
    {
      localb = com.tencent.mm.bx.b.F(this.buffer, this.bIL, i);
      this.bIL = (i + this.bIL);
      AppMethodBeat.o(2414);
      return localb;
    }
    com.tencent.mm.bx.b localb = com.tencent.mm.bx.b.cd(fU(i));
    AppMethodBeat.o(2414);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(2413);
    int i = xS();
    if ((i < this.bufferSize - this.bIL) && (i > 0))
    {
      str = new String(this.buffer, this.bIL, i, "UTF-8");
      this.bIL = (i + this.bIL);
      AppMethodBeat.o(2413);
      return str;
    }
    String str = new String(fU(i), "UTF-8");
    AppMethodBeat.o(2413);
    return str;
  }
  
  public final int xR()
  {
    AppMethodBeat.i(168737);
    if ((this.bIL == this.bufferSize) && (!ys(false)))
    {
      this.bIM = 0;
      AppMethodBeat.o(168737);
      return 0;
    }
    this.bIM = xS();
    if (this.bIM == 0)
    {
      b localb = b.fMy();
      AppMethodBeat.o(168737);
      throw localb;
    }
    int i = this.bIM;
    AppMethodBeat.o(168737);
    return i;
  }
  
  public final int xS()
  {
    AppMethodBeat.i(2416);
    int i = xW();
    if (i >= 0)
    {
      AppMethodBeat.o(2416);
      return i;
    }
    i &= 0x7F;
    int j = xW();
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
        j = xW();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = xW();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = xW();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    for (;;)
    {
      if (i >= 5)
      {
        b localb = b.fMx();
        AppMethodBeat.o(2416);
        throw localb;
      }
      if (xW() >= 0)
      {
        AppMethodBeat.o(2416);
        return j;
      }
      i += 1;
    }
  }
  
  public final long xT()
  {
    AppMethodBeat.i(2417);
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64)
      {
        b localb = b.fMx();
        AppMethodBeat.o(2417);
        throw localb;
      }
      int j = xW();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(2417);
        return l;
      }
      i += 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */