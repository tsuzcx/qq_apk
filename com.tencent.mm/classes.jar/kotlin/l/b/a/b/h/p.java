package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.NoSuchElementException;

class p
  extends d
{
  private int bNi = 0;
  protected final byte[] zy;
  
  p(byte[] paramArrayOfByte)
  {
    this.zy = paramArrayOfByte;
  }
  
  private static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  final boolean a(p paramp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59527);
    if (paramInt2 > paramp.size())
    {
      paramInt1 = size();
      paramp = new IllegalArgumentException(40 + "Length too large: " + paramInt2 + paramInt1);
      AppMethodBeat.o(59527);
      throw paramp;
    }
    if (paramInt1 + paramInt2 > paramp.size())
    {
      i = paramp.size();
      paramp = new IllegalArgumentException(59 + "Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + i);
      AppMethodBeat.o(59527);
      throw paramp;
    }
    byte[] arrayOfByte1 = this.zy;
    byte[] arrayOfByte2 = paramp.zy;
    int j = yR();
    int i = yR();
    paramInt1 = paramp.yR() + paramInt1;
    while (i < j + paramInt2)
    {
      if (arrayOfByte1[i] != arrayOfByte2[paramInt1])
      {
        AppMethodBeat.o(59527);
        return false;
      }
      i += 1;
      paramInt1 += 1;
    }
    AppMethodBeat.o(59527);
    return true;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59522);
    paramOutputStream.write(this.zy, yR() + paramInt1, paramInt2);
    AppMethodBeat.o(59522);
  }
  
  protected final int bi(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59525);
    paramInt2 = yR() + paramInt2;
    byte[] arrayOfByte = this.zy;
    int k = paramInt2 + paramInt3;
    int m;
    int i;
    int j;
    if (paramInt1 != 0)
    {
      if (paramInt2 >= k)
      {
        AppMethodBeat.o(59525);
        return paramInt1;
      }
      m = (byte)paramInt1;
      if (m < -32)
      {
        if (m >= -62)
        {
          paramInt1 = paramInt2 + 1;
          if (arrayOfByte[paramInt2] <= -65) {
            break label331;
          }
        }
        AppMethodBeat.o(59525);
        return -1;
      }
      if (m < -16)
      {
        i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt1 = i;
        paramInt3 = paramInt2;
        if (i == 0)
        {
          paramInt3 = paramInt2 + 1;
          paramInt1 = arrayOfByte[paramInt2];
          if (paramInt3 >= k)
          {
            paramInt1 = y.by(m, paramInt1);
            AppMethodBeat.o(59525);
            return paramInt1;
          }
        }
        if ((paramInt1 <= -65) && ((m != -32) || (paramInt1 >= -96)) && ((m != -19) || (paramInt1 < -96)))
        {
          paramInt1 = paramInt3 + 1;
          if (arrayOfByte[paramInt3] <= -65) {
            break label331;
          }
        }
        AppMethodBeat.o(59525);
        return -1;
      }
      paramInt3 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
      i = 0;
      if (paramInt3 == 0)
      {
        j = paramInt2 + 1;
        paramInt3 = arrayOfByte[paramInt2];
        if (j < k) {
          break label347;
        }
        paramInt1 = y.by(m, paramInt3);
        AppMethodBeat.o(59525);
        return paramInt1;
      }
      paramInt1 = (byte)(paramInt1 >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        i = paramInt2 + 1;
        j = arrayOfByte[paramInt2];
        paramInt1 = j;
        paramInt2 = i;
        if (i >= k)
        {
          paramInt1 = y.z(m, paramInt3, j);
          AppMethodBeat.o(59525);
          return paramInt1;
        }
      }
      if ((paramInt3 <= -65) && ((m << 28) + (paramInt3 + 112) >> 30 == 0) && (paramInt1 <= -65))
      {
        paramInt1 = paramInt2 + 1;
        if (arrayOfByte[paramInt2] <= -65) {}
      }
      else
      {
        AppMethodBeat.o(59525);
        return -1;
        paramInt1 = paramInt2;
      }
      label331:
      paramInt1 = y.X(arrayOfByte, paramInt1, k);
      AppMethodBeat.o(59525);
      return paramInt1;
      label347:
      paramInt1 = i;
      paramInt2 = j;
    }
  }
  
  protected final int bj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59529);
    paramInt1 = b(paramInt1, this.zy, yR() + paramInt2, paramInt3);
    AppMethodBeat.o(59529);
    return paramInt1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59526);
    if (paramObject == this)
    {
      AppMethodBeat.o(59526);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(59526);
      return false;
    }
    if (size() != ((d)paramObject).size())
    {
      AppMethodBeat.o(59526);
      return false;
    }
    if (size() == 0)
    {
      AppMethodBeat.o(59526);
      return true;
    }
    boolean bool;
    if ((paramObject instanceof p))
    {
      bool = a((p)paramObject, 0, size());
      AppMethodBeat.o(59526);
      return bool;
    }
    if ((paramObject instanceof u))
    {
      bool = paramObject.equals(this);
      AppMethodBeat.o(59526);
      return bool;
    }
    paramObject = String.valueOf(String.valueOf(paramObject.getClass()));
    paramObject = new IllegalArgumentException(paramObject.length() + 49 + "Has a new type of ByteString been created? Found " + paramObject);
    AppMethodBeat.o(59526);
    throw paramObject;
  }
  
  public byte fB(int paramInt)
  {
    return this.zy[paramInt];
  }
  
  public d.a hJm()
  {
    AppMethodBeat.i(59531);
    a locala = new a((byte)0);
    AppMethodBeat.o(59531);
    return locala;
  }
  
  public final e hJn()
  {
    AppMethodBeat.i(59530);
    e locale = e.a(this);
    AppMethodBeat.o(59530);
    return locale;
  }
  
  protected final int hJp()
  {
    return 0;
  }
  
  protected final boolean hJq()
  {
    return true;
  }
  
  protected final int hJr()
  {
    return this.bNi;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(59528);
    int j = this.bNi;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = bj(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.bNi = i;
    }
    AppMethodBeat.o(59528);
    return i;
  }
  
  protected void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59521);
    System.arraycopy(this.zy, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(59521);
  }
  
  public int size()
  {
    return this.zy.length;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(59523);
    paramString = new String(this.zy, yR(), size(), paramString);
    AppMethodBeat.o(59523);
    return paramString;
  }
  
  public final boolean yP()
  {
    AppMethodBeat.i(59524);
    int i = yR();
    boolean bool = y.s(this.zy, i, size() + i);
    AppMethodBeat.o(59524);
    return bool;
  }
  
  protected int yR()
  {
    return 0;
  }
  
  final class a
    implements d.a
  {
    private final int limit;
    private int position;
    
    private a()
    {
      AppMethodBeat.i(59517);
      this.position = 0;
      this.limit = p.this.size();
      AppMethodBeat.o(59517);
    }
    
    public final boolean hasNext()
    {
      return this.position < this.limit;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59518);
      try
      {
        byte[] arrayOfByte = p.this.zy;
        int i = this.position;
        this.position = (i + 1);
        byte b = arrayOfByte[i];
        AppMethodBeat.o(59518);
        return b;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        NoSuchElementException localNoSuchElementException = new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
        AppMethodBeat.o(59518);
        throw localNoSuchElementException;
      }
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59519);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(59519);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.p
 * JD-Core Version:    0.7.0.1
 */