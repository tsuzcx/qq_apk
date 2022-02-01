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
  private final List<byte[]> Kkt;
  private int Kku;
  private int Kkv;
  private byte[] Kkw;
  private boolean Kkx;
  private int count;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(10290);
    this.Kkt = new ArrayList();
    this.Kkx = true;
    try
    {
      agr(1024);
      return;
    }
    finally
    {
      AppMethodBeat.o(10290);
    }
  }
  
  private void agr(int paramInt)
  {
    AppMethodBeat.i(10291);
    if (this.Kku < this.Kkt.size() - 1)
    {
      this.Kkv += this.Kkw.length;
      this.Kku += 1;
      this.Kkw = ((byte[])this.Kkt.get(this.Kku));
      AppMethodBeat.o(10291);
      return;
    }
    if (this.Kkw == null) {}
    for (this.Kkv = 0;; this.Kkv += this.Kkw.length)
    {
      this.Kku += 1;
      this.Kkw = new byte[paramInt];
      this.Kkt.add(this.Kkw);
      AppMethodBeat.o(10291);
      return;
      paramInt = Math.max(this.Kkw.length << 1, paramInt - this.Kkv);
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
        Iterator localIterator = this.Kkt.iterator();
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
      int j = this.count - this.Kkv;
      int i = j;
      if (j == this.Kkw.length)
      {
        agr(this.count + 1);
        i = 0;
      }
      this.Kkw[i] = ((byte)paramInt);
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
      int j = this.count - this.Kkv;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, this.Kkw.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, this.Kkw, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          agr(m);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.a.a.a
 * JD-Core Version:    0.7.0.1
 */