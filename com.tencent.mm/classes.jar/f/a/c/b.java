package f.a.c;

import java.io.InputStream;

public final class b
{
  public int tMt;
  public int xvL;
  public InputStream xvM;
  
  public static void c(short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = 1024;
      i += 1;
    }
  }
  
  public final int e(short[] paramArrayOfShort, int paramInt)
  {
    int i = paramArrayOfShort[paramInt];
    int j = (this.xvL >>> 11) * i;
    if ((this.tMt ^ 0x80000000) < (0x80000000 ^ j))
    {
      this.xvL = j;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.xvL & 0xFF000000) == 0)
      {
        this.tMt = (this.tMt << 8 | this.xvM.read());
        this.xvL <<= 8;
      }
      return 0;
    }
    this.xvL -= j;
    this.tMt -= j;
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.xvL & 0xFF000000) == 0)
    {
      this.tMt = (this.tMt << 8 | this.xvM.read());
      this.xvL <<= 8;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     f.a.c.b
 * JD-Core Version:    0.7.0.1
 */