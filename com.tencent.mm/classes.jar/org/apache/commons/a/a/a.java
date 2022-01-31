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
  private final List<byte[]> COC;
  private int COD;
  private int COE;
  private byte[] COF;
  private boolean COG;
  private int count;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(136486);
    this.COC = new ArrayList();
    this.COG = true;
    try
    {
      Wt(1024);
      return;
    }
    finally
    {
      AppMethodBeat.o(136486);
    }
  }
  
  private void Wt(int paramInt)
  {
    AppMethodBeat.i(136487);
    if (this.COD < this.COC.size() - 1)
    {
      this.COE += this.COF.length;
      this.COD += 1;
      this.COF = ((byte[])this.COC.get(this.COD));
      AppMethodBeat.o(136487);
      return;
    }
    if (this.COF == null) {}
    for (this.COE = 0;; this.COE += this.COF.length)
    {
      this.COD += 1;
      this.COF = new byte[paramInt];
      this.COC.add(this.COF);
      AppMethodBeat.o(136487);
      return;
      paramInt = Math.max(this.COF.length << 1, paramInt - this.COE);
    }
  }
  
  public final void close() {}
  
  public final byte[] toByteArray()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(136490);
        int j = this.count;
        if (j == 0)
        {
          arrayOfByte1 = EMPTY_BYTE_ARRAY;
          AppMethodBeat.o(136490);
          return arrayOfByte1;
        }
        byte[] arrayOfByte1 = new byte[j];
        Iterator localIterator = this.COC.iterator();
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
          AppMethodBeat.o(136490);
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
    AppMethodBeat.i(136491);
    String str = new String(toByteArray(), Charset.defaultCharset());
    AppMethodBeat.o(136491);
    return str;
  }
  
  public final void write(int paramInt)
  {
    try
    {
      AppMethodBeat.i(136489);
      int j = this.count - this.COE;
      int i = j;
      if (j == this.COF.length)
      {
        Wt(this.count + 1);
        i = 0;
      }
      this.COF[i] = ((byte)paramInt);
      this.count += 1;
      AppMethodBeat.o(136489);
      return;
    }
    finally {}
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136488);
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0))
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(136488);
      throw paramArrayOfByte;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(136488);
      return;
    }
    try
    {
      int m = this.count + paramInt2;
      int j = this.count - this.COE;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, this.COF.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, this.COF, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          Wt(m);
          j = 0;
          i = k;
        }
      }
      this.count = m;
      return;
    }
    finally
    {
      AppMethodBeat.o(136488);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.apache.commons.a.a.a
 * JD-Core Version:    0.7.0.1
 */