package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class b
{
  public int FMB;
  public int MhC;
  public InputStream MhD;
  
  public static void c(short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = 1024;
      i += 1;
    }
  }
  
  public final int f(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(155362);
    int i = paramArrayOfShort[paramInt];
    int j = (this.MhC >>> 11) * i;
    if ((this.FMB ^ 0x80000000) < (0x80000000 ^ j))
    {
      this.MhC = j;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.MhC & 0xFF000000) == 0)
      {
        this.FMB = (this.FMB << 8 | this.MhD.read());
        this.MhC <<= 8;
      }
      AppMethodBeat.o(155362);
      return 0;
    }
    this.MhC -= j;
    this.FMB -= j;
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.MhC & 0xFF000000) == 0)
    {
      this.FMB = (this.FMB << 8 | this.MhD.read());
      this.MhC <<= 8;
    }
    AppMethodBeat.o(155362);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     g.a.c.b
 * JD-Core Version:    0.7.0.1
 */