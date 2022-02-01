package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class b
{
  public int Upv;
  public int abSL;
  public InputStream abSM;
  
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
    int j = (this.abSL >>> 11) * i;
    if ((this.Upv ^ 0x80000000) < (0x80000000 ^ j))
    {
      this.abSL = j;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.abSL & 0xFF000000) == 0)
      {
        this.Upv = (this.Upv << 8 | this.abSM.read());
        this.abSL <<= 8;
      }
      AppMethodBeat.o(155362);
      return 0;
    }
    this.abSL -= j;
    this.Upv -= j;
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.abSL & 0xFF000000) == 0)
    {
      this.Upv = (this.Upv << 8 | this.abSM.read());
      this.abSL <<= 8;
    }
    AppMethodBeat.o(155362);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     i.a.c.b
 * JD-Core Version:    0.7.0.1
 */