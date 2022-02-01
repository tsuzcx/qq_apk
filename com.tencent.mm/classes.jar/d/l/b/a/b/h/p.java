package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.NoSuchElementException;

class p
  extends d
{
  private int vUo = 0;
  protected final byte[] xy;
  
  p(byte[] paramArrayOfByte)
  {
    this.xy = paramArrayOfByte;
  }
  
  private static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
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
    byte[] arrayOfByte1 = this.xy;
    byte[] arrayOfByte2 = paramp.xy;
    int j = fZO();
    int i = fZO();
    paramInt1 = paramp.fZO() + paramInt1;
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
  
  public byte aiv(int paramInt)
  {
    return this.xy[paramInt];
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59522);
    paramOutputStream.write(this.xy, fZO() + paramInt1, paramInt2);
    AppMethodBeat.o(59522);
  }
  
  protected final int ba(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59525);
    paramInt2 = fZO() + paramInt2;
    byte[] arrayOfByte = this.xy;
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
            paramInt1 = y.le(m, paramInt1);
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
        paramInt1 = y.le(m, paramInt3);
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
          paramInt1 = y.bc(m, paramInt3, j);
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
      paramInt1 = y.L(arrayOfByte, paramInt1, k);
      AppMethodBeat.o(59525);
      return paramInt1;
      label347:
      paramInt1 = i;
      paramInt2 = j;
    }
  }
  
  protected final int bb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59529);
    paramInt1 = a(paramInt1, this.xy, fZO() + paramInt2, paramInt3);
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
  
  protected int fZO()
  {
    return 0;
  }
  
  public d.a fZP()
  {
    AppMethodBeat.i(59531);
    a locala = new a((byte)0);
    AppMethodBeat.o(59531);
    return locala;
  }
  
  public final boolean fZQ()
  {
    AppMethodBeat.i(59524);
    int i = fZO();
    boolean bool = y.K(this.xy, i, size() + i);
    AppMethodBeat.o(59524);
    return bool;
  }
  
  public final e fZR()
  {
    AppMethodBeat.i(59530);
    e locale = e.a(this);
    AppMethodBeat.o(59530);
    return locale;
  }
  
  protected final int fZT()
  {
    return 0;
  }
  
  protected final boolean fZU()
  {
    return true;
  }
  
  protected final int fZV()
  {
    return this.vUo;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(59528);
    int j = this.vUo;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = bb(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.vUo = i;
    }
    AppMethodBeat.o(59528);
    return i;
  }
  
  protected void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59521);
    System.arraycopy(this.xy, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(59521);
  }
  
  public int size()
  {
    return this.xy.length;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(59523);
    paramString = new String(this.xy, fZO(), size(), paramString);
    AppMethodBeat.o(59523);
    return paramString;
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
        byte[] arrayOfByte = p.this.xy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.l.b.a.b.h.p
 * JD-Core Version:    0.7.0.1
 */