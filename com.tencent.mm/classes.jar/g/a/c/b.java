package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class b
{
  public int CSV;
  public InputStream CSW;
  public int xRf;
  
  public static void c(short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = 1024;
      i += 1;
    }
  }
  
  public final int g(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(86247);
    int i = paramArrayOfShort[paramInt];
    int j = (this.CSV >>> 11) * i;
    if ((this.xRf ^ 0x80000000) < (0x80000000 ^ j))
    {
      this.CSV = j;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.CSV & 0xFF000000) == 0)
      {
        this.xRf = (this.xRf << 8 | this.CSW.read());
        this.CSV <<= 8;
      }
      AppMethodBeat.o(86247);
      return 0;
    }
    this.CSV -= j;
    this.xRf -= j;
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.CSV & 0xFF000000) == 0)
    {
      this.xRf = (this.xRf << 8 | this.CSW.read());
      this.CSV <<= 8;
    }
    AppMethodBeat.o(86247);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     g.a.c.b
 * JD-Core Version:    0.7.0.1
 */