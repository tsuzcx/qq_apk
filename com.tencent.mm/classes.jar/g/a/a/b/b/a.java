package g.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] buffer;
  private final int limit;
  private int position;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2425);
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt + 0);
    AppMethodBeat.o(2425);
  }
  
  public static int aO(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int b(int paramInt, b paramb)
  {
    AppMethodBeat.i(2437);
    if (paramb == null)
    {
      AppMethodBeat.o(2437);
      return 0;
    }
    paramInt = gL(paramInt);
    int i = gR(paramb.UH.length);
    int j = paramb.UH.length;
    AppMethodBeat.o(2437);
    return paramInt + i + j;
  }
  
  public static int bM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2435);
    if (paramInt2 >= 0)
    {
      paramInt1 = gL(paramInt1);
      paramInt2 = gR(paramInt2);
      AppMethodBeat.o(2435);
      return paramInt1 + paramInt2;
    }
    paramInt1 = gL(paramInt1);
    AppMethodBeat.o(2435);
    return paramInt1 + 10;
  }
  
  private void dJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2438);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(2438);
      return;
    }
    s(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(2438);
  }
  
  public static int g(int paramInt, String paramString)
  {
    AppMethodBeat.i(2436);
    if (paramString == null)
    {
      AppMethodBeat.o(2436);
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = gL(paramInt);
      int i = gR(paramString.length);
      int j = paramString.length;
      AppMethodBeat.o(2436);
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new IllegalStateException("UTF-8 not supported.");
      AppMethodBeat.o(2436);
      throw paramString;
    }
  }
  
  public static int gL(int paramInt)
  {
    AppMethodBeat.i(2441);
    paramInt = gR(g.a.a.b.a.bT(paramInt, 0));
    AppMethodBeat.o(2441);
    return paramInt;
  }
  
  public static int gR(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  private void l(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public static int p(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2434);
    paramInt = gL(paramInt);
    int i = aO(paramLong);
    AppMethodBeat.o(2434);
    return paramInt + i;
  }
  
  private void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2439);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(2439);
      return;
    }
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
      AppMethodBeat.o(2439);
      return;
    }
    int i = this.limit - this.position;
    System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
    paramInt -= i;
    this.position = this.limit;
    if (paramInt <= this.limit)
    {
      System.arraycopy(paramArrayOfByte, i + 0, this.buffer, 0, paramInt);
      this.position = paramInt;
    }
    AppMethodBeat.o(2439);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(2432);
    if (paramb == null)
    {
      AppMethodBeat.o(2432);
      return;
    }
    bI(paramInt, 2);
    paramb = paramb.toByteArray();
    hT(paramb.length);
    dJ(paramb);
    AppMethodBeat.o(2432);
  }
  
  public final void aN(long paramLong)
  {
    AppMethodBeat.i(2443);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        l((byte)(int)paramLong);
        AppMethodBeat.o(2443);
        return;
      }
      l((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void bI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2440);
    hT(g.a.a.b.a.bT(paramInt1, paramInt2));
    AppMethodBeat.o(2440);
  }
  
  public final void bJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2429);
    bI(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      hT(paramInt2);
      AppMethodBeat.o(2429);
      return;
    }
    aN(paramInt2);
    AppMethodBeat.o(2429);
  }
  
  public final void e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2426);
    bI(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    l((byte)((int)l & 0xFF));
    l((byte)((int)(l >> 8) & 0xFF));
    l((byte)((int)(l >> 16) & 0xFF));
    l((byte)((int)(l >> 24) & 0xFF));
    l((byte)((int)(l >> 32) & 0xFF));
    l((byte)((int)(l >> 40) & 0xFF));
    l((byte)((int)(l >> 48) & 0xFF));
    l((byte)((int)(l >> 56) & 0xFF));
    AppMethodBeat.o(2426);
  }
  
  public final void f(int paramInt, String paramString)
  {
    AppMethodBeat.i(2431);
    if (paramString == null)
    {
      AppMethodBeat.o(2431);
      return;
    }
    bI(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    hT(paramString.length);
    dJ(paramString);
    AppMethodBeat.o(2431);
  }
  
  public final void hT(int paramInt)
  {
    AppMethodBeat.i(2442);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        l((byte)paramInt);
        AppMethodBeat.o(2442);
        return;
      }
      l((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2427);
    bI(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    l((byte)(paramInt & 0xFF));
    l((byte)(paramInt >> 8 & 0xFF));
    l((byte)(paramInt >> 16 & 0xFF));
    l((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(2427);
  }
  
  public final void oE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2433);
    bI(paramInt1, 2);
    hT(paramInt2);
    AppMethodBeat.o(2433);
  }
  
  public final void r(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2428);
    bI(paramInt, 0);
    aN(paramLong);
    AppMethodBeat.o(2428);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2430);
    bI(paramInt, 0);
    if (paramBoolean)
    {
      l((byte)1);
      AppMethodBeat.o(2430);
      return;
    }
    l((byte)0);
    AppMethodBeat.o(2430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     g.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */