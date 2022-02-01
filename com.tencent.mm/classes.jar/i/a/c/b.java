package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class b
{
  public int NcY;
  public int Upw;
  public InputStream Upx;
  
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
    AppMethodBeat.i(155362);
    int i = paramArrayOfShort[paramInt];
    int j = (this.Upw >>> 11) * i;
    if ((this.NcY ^ 0x80000000) < (0x80000000 ^ j))
    {
      this.Upw = j;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.Upw & 0xFF000000) == 0)
      {
        this.NcY = (this.NcY << 8 | this.Upx.read());
        this.Upw <<= 8;
      }
      AppMethodBeat.o(155362);
      return 0;
    }
    this.Upw -= j;
    this.NcY -= j;
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.Upw & 0xFF000000) == 0)
    {
      this.NcY = (this.NcY << 8 | this.Upx.read());
      this.Upw <<= 8;
    }
    AppMethodBeat.o(155362);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     i.a.c.b
 * JD-Core Version:    0.7.0.1
 */