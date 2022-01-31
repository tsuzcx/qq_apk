package e.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int Crk;
  private int bgQ;
  public int bgR;
  public int bgS;
  private int bgT;
  private int bgW;
  private byte[] buffer;
  public int bufferSize;
  private InputStream input;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(51886);
    this.bgQ = 0;
    this.bgS = 0;
    this.Crk = 0;
    this.bgT = 2147483647;
    this.bgW = 67108864;
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.bgR = 0;
    this.input = null;
    AppMethodBeat.o(51886);
  }
  
  private int[] Wq(int paramInt)
  {
    AppMethodBeat.i(51881);
    int j = this.buffer[paramInt];
    int i = paramInt + 1;
    if (j >= 0)
    {
      AppMethodBeat.o(51881);
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
        AppMethodBeat.o(51881);
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
        b localb = b.eqV();
        AppMethodBeat.o(51881);
        throw localb;
      }
      if (this.buffer[j] >= 0)
      {
        AppMethodBeat.o(51881);
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private byte[] eS(int paramInt)
  {
    AppMethodBeat.i(51889);
    if (paramInt < 0)
    {
      localObject = b.eqU();
      AppMethodBeat.o(51889);
      throw ((Throwable)localObject);
    }
    if (this.Crk + this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.Crk - this.bgR);
      localObject = b.eqT();
      AppMethodBeat.o(51889);
      throw ((Throwable)localObject);
    }
    if (paramInt <= this.bufferSize - this.bgR)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bgR, localObject, 0, paramInt);
      this.bgR += paramInt;
      AppMethodBeat.o(51889);
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bgR;
      System.arraycopy(this.buffer, this.bgR, localObject, 0, i);
      this.bgR = this.bufferSize;
      sK(true);
      for (;;)
      {
        if (paramInt - i <= this.bufferSize)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.bgR = (paramInt - i);
          AppMethodBeat.o(51889);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bgR = this.bufferSize;
        sK(true);
      }
    }
    int m = this.bgR;
    int n = this.bufferSize;
    this.Crk += this.bufferSize;
    this.bgR = 0;
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
        AppMethodBeat.o(51889);
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
            localObject = b.eqT();
            AppMethodBeat.o(51889);
            throw ((Throwable)localObject);
          }
          this.Crk += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  private void eT(int paramInt)
  {
    AppMethodBeat.i(51890);
    b localb;
    if (paramInt < 0)
    {
      localb = b.eqU();
      AppMethodBeat.o(51890);
      throw localb;
    }
    if (this.Crk + this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.Crk - this.bgR);
      localb = b.eqT();
      AppMethodBeat.o(51890);
      throw localb;
    }
    if (paramInt < this.bufferSize - this.bgR)
    {
      this.bgR += paramInt;
      AppMethodBeat.o(51890);
      return;
    }
    int i = this.bufferSize - this.bgR;
    this.Crk += i;
    this.bgR = 0;
    this.bufferSize = 0;
    for (;;)
    {
      if (i >= paramInt)
      {
        AppMethodBeat.o(51890);
        return;
      }
      if (this.input == null) {}
      for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i))
      {
        localb = b.eqT();
        AppMethodBeat.o(51890);
        throw localb;
      }
      i += j;
      this.Crk = (j + this.Crk);
    }
  }
  
  private void sn()
  {
    this.bufferSize += this.bgQ;
    int i = this.Crk + this.bufferSize;
    if (i > this.bgT)
    {
      this.bgQ = (i - this.bgT);
      this.bufferSize -= this.bgQ;
      return;
    }
    this.bgQ = 0;
  }
  
  private byte sp()
  {
    AppMethodBeat.i(51888);
    if (this.bgR == this.bufferSize) {
      sK(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bgR;
    this.bgR = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(51888);
    return b;
  }
  
  public final LinkedList<byte[]> Wp(int paramInt)
  {
    AppMethodBeat.i(51878);
    LinkedList localLinkedList = new LinkedList();
    int i = sl();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bgR, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.bgR = (i + this.bgR);
      i = this.bgR;
      if (this.bgR == this.bufferSize)
      {
        AppMethodBeat.o(51878);
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = new OutOfMemoryError("alloc bytes:".concat(String.valueOf(i)));
      AppMethodBeat.o(51878);
      throw ((Throwable)localObject);
    }
    Object localObject = Wq(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (e.a.a.b.a.fa(i) != paramInt) {}
      do
      {
        AppMethodBeat.o(51878);
        return localLinkedList;
        this.bgR = localObject[1];
        i = sl();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.bgR, localObject, 0, i);
        localLinkedList.add(localObject);
        this.bgR = (i + this.bgR);
      } while (this.bgR == this.bufferSize);
      localObject = Wq(this.bgR);
    }
  }
  
  public final boolean emu()
  {
    AppMethodBeat.i(51877);
    if (sl() != 0)
    {
      AppMethodBeat.o(51877);
      return true;
    }
    AppMethodBeat.o(51877);
    return false;
  }
  
  public final int emx()
  {
    AppMethodBeat.i(51884);
    int i = sp();
    int j = sp();
    int k = sp();
    int m = sp();
    AppMethodBeat.o(51884);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long emy()
  {
    AppMethodBeat.i(51885);
    int i = sp();
    int j = sp();
    int k = sp();
    int m = sp();
    int n = sp();
    int i1 = sp();
    int i2 = sp();
    int i3 = sp();
    long l1 = i;
    long l2 = j;
    long l3 = k;
    long l4 = m;
    long l5 = n;
    long l6 = i1;
    long l7 = i2;
    long l8 = i3;
    AppMethodBeat.o(51885);
    return (l2 & 0xFF) << 8 | l1 & 0xFF | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (l8 & 0xFF) << 56;
  }
  
  public final LinkedList<Integer> eqR()
  {
    AppMethodBeat.i(51876);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (this.bgR >= this.bufferSize)
      {
        AppMethodBeat.o(51876);
        return localLinkedList;
      }
      localLinkedList.add(Integer.valueOf(sl()));
    }
  }
  
  public final com.tencent.mm.bv.b eqS()
  {
    AppMethodBeat.i(51880);
    int i = sl();
    if ((i < this.bufferSize - this.bgR) && (i > 0))
    {
      localb = com.tencent.mm.bv.b.z(this.buffer, this.bgR, i);
      this.bgR = (i + this.bgR);
      AppMethodBeat.o(51880);
      return localb;
    }
    com.tencent.mm.bv.b localb = com.tencent.mm.bv.b.bL(eS(i));
    AppMethodBeat.o(51880);
    return localb;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(51879);
    int i = sl();
    if ((i < this.bufferSize - this.bgR) && (i > 0))
    {
      str = new String(this.buffer, this.bgR, i, "UTF-8");
      this.bgR = (i + this.bgR);
      AppMethodBeat.o(51879);
      return str;
    }
    String str = new String(eS(i), "UTF-8");
    AppMethodBeat.o(51879);
    return str;
  }
  
  public final boolean sK(boolean paramBoolean)
  {
    AppMethodBeat.i(51887);
    Object localObject;
    if (this.bgR < this.bufferSize)
    {
      localObject = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
      AppMethodBeat.o(51887);
      throw ((Throwable)localObject);
    }
    if (this.Crk + this.bufferSize == this.bgT)
    {
      if (paramBoolean)
      {
        localObject = b.eqT();
        AppMethodBeat.o(51887);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(51887);
      return false;
    }
    this.Crk += this.bufferSize;
    this.bgR = 0;
    if (this.input == null) {}
    for (int i = -1;; i = this.input.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label153;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      localObject = b.eqT();
      AppMethodBeat.o(51887);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(51887);
    return false;
    label153:
    sn();
    i = this.Crk + this.bufferSize + this.bgQ;
    if ((i > this.bgW) || (i < 0))
    {
      localObject = b.eqX();
      AppMethodBeat.o(51887);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(51887);
    return true;
  }
  
  public final int sl()
  {
    AppMethodBeat.i(51882);
    int i = sp();
    if (i >= 0)
    {
      AppMethodBeat.o(51882);
      return i;
    }
    i &= 0x7F;
    int j = sp();
    if (j >= 0) {
      i |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        AppMethodBeat.o(51882);
        return i;
        i |= (j & 0x7F) << 7;
        j = sp();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = sp();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = sp();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    for (;;)
    {
      if (i >= 5)
      {
        b localb = b.eqV();
        AppMethodBeat.o(51882);
        throw localb;
      }
      if (sp() >= 0)
      {
        AppMethodBeat.o(51882);
        return j;
      }
      i += 1;
    }
  }
  
  public final long sm()
  {
    AppMethodBeat.i(51883);
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64)
      {
        b localb = b.eqV();
        AppMethodBeat.o(51883);
        throw localb;
      }
      int j = sp();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(51883);
        return l;
      }
      i += 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */