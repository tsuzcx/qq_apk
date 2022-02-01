package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends OutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final List<byte[]> NSB;
  private int NSC;
  private int NSD;
  private byte[] NSE;
  private boolean NSF;
  private int count;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(10290);
    this.NSB = new ArrayList();
    this.NSF = true;
    try
    {
      alY(1024);
      return;
    }
    finally
    {
      AppMethodBeat.o(10290);
    }
  }
  
  private void alY(int paramInt)
  {
    AppMethodBeat.i(10291);
    if (this.NSC < this.NSB.size() - 1)
    {
      this.NSD += this.NSE.length;
      this.NSC += 1;
      this.NSE = ((byte[])this.NSB.get(this.NSC));
      AppMethodBeat.o(10291);
      return;
    }
    if (this.NSE == null) {}
    for (this.NSD = 0;; this.NSD += this.NSE.length)
    {
      this.NSC += 1;
      this.NSE = new byte[paramInt];
      this.NSB.add(this.NSE);
      AppMethodBeat.o(10291);
      return;
      paramInt = Math.max(this.NSE.length << 1, paramInt - this.NSD);
    }
  }
  
  public final void close() {}
  
  public final byte[] toByteArray()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(10294);
        int j = this.count;
        if (j == 0)
        {
          arrayOfByte1 = EMPTY_BYTE_ARRAY;
          AppMethodBeat.o(10294);
          return arrayOfByte1;
        }
        byte[] arrayOfByte1 = new byte[j];
        Iterator localIterator = this.NSB.iterator();
        int i = 0;
        int k;
        if (localIterator.hasNext())
        {
          byte[] arrayOfByte2 = (byte[])localIterator.next();
          k = Math.min(arrayOfByte2.length, j);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
          j -= k;
          if (j != 0) {}
        }
        else
        {
          AppMethodBeat.o(10294);
          continue;
        }
        i += k;
      }
      finally {}
    }
  }
  
  @Deprecated
  public final String toString()
  {
    AppMethodBeat.i(10295);
    String str = new String(toByteArray(), Charset.defaultCharset());
    AppMethodBeat.o(10295);
    return str;
  }
  
  public final void write(int paramInt)
  {
    try
    {
      AppMethodBeat.i(10293);
      int j = this.count - this.NSD;
      int i = j;
      if (j == this.NSE.length)
      {
        alY(this.count + 1);
        i = 0;
      }
      this.NSE[i] = ((byte)paramInt);
      this.count += 1;
      AppMethodBeat.o(10293);
      return;
    }
    finally {}
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10292);
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0))
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(10292);
      throw paramArrayOfByte;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(10292);
      return;
    }
    try
    {
      int m = this.count + paramInt2;
      int j = this.count - this.NSD;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, this.NSE.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, this.NSE, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          alY(m);
          j = 0;
          i = k;
        }
      }
      this.count = m;
      return;
    }
    finally
    {
      AppMethodBeat.o(10292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.a.a.a
 * JD-Core Version:    0.7.0.1
 */