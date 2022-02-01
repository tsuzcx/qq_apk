package f.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
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
  
  public static int aB(long paramLong)
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
    paramInt = fY(paramInt);
    int i = ga(paramb.wA.length);
    int j = paramb.wA.length;
    AppMethodBeat.o(2437);
    return paramInt + i + j;
  }
  
  public static int bA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2435);
    if (paramInt2 >= 0)
    {
      paramInt1 = fY(paramInt1);
      paramInt2 = ga(paramInt2);
      AppMethodBeat.o(2435);
      return paramInt1 + paramInt2;
    }
    paramInt1 = fY(paramInt1);
    AppMethodBeat.o(2435);
    return paramInt1 + 10;
  }
  
  private void c(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  private void cY(byte[] paramArrayOfByte)
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
  
  public static int e(int paramInt, String paramString)
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
      paramInt = fY(paramInt);
      int i = ga(paramString.length);
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
  
  public static int fY(int paramInt)
  {
    AppMethodBeat.i(2441);
    paramInt = ga(f.a.a.b.a.bD(paramInt, 0));
    AppMethodBeat.o(2441);
    return paramInt;
  }
  
  public static int ga(int paramInt)
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
  
  public static int q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2434);
    paramInt = fY(paramInt);
    int i = aB(paramLong);
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
    bC(paramInt, 2);
    paramb = paramb.toByteArray();
    fZ(paramb.length);
    cY(paramb);
    AppMethodBeat.o(2432);
  }
  
  public final void aA(long paramLong)
  {
    AppMethodBeat.i(2443);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        c((byte)(int)paramLong);
        AppMethodBeat.o(2443);
        return;
      }
      c((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2440);
    fZ(f.a.a.b.a.bD(paramInt1, paramInt2));
    AppMethodBeat.o(2440);
  }
  
  public final void bf(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(2430);
    bC(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    c((byte)paramInt);
    AppMethodBeat.o(2430);
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2429);
    bC(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      fZ(paramInt2);
      AppMethodBeat.o(2429);
      return;
    }
    aA(paramInt2);
    AppMethodBeat.o(2429);
  }
  
  public final void d(int paramInt, String paramString)
  {
    AppMethodBeat.i(2431);
    if (paramString == null)
    {
      AppMethodBeat.o(2431);
      return;
    }
    bC(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    fZ(paramString.length);
    cY(paramString);
    AppMethodBeat.o(2431);
  }
  
  public final void e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2426);
    bC(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    c((byte)((int)l & 0xFF));
    c((byte)((int)(l >> 8) & 0xFF));
    c((byte)((int)(l >> 16) & 0xFF));
    c((byte)((int)(l >> 24) & 0xFF));
    c((byte)((int)(l >> 32) & 0xFF));
    c((byte)((int)(l >> 40) & 0xFF));
    c((byte)((int)(l >> 48) & 0xFF));
    c((byte)((int)(l >> 56) & 0xFF));
    AppMethodBeat.o(2426);
  }
  
  public final void fZ(int paramInt)
  {
    AppMethodBeat.i(2442);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        c((byte)paramInt);
        AppMethodBeat.o(2442);
        return;
      }
      c((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void kX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2433);
    bC(paramInt1, 2);
    fZ(paramInt2);
    AppMethodBeat.o(2433);
  }
  
  public final void o(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2428);
    bC(paramInt, 0);
    aA(paramLong);
    AppMethodBeat.o(2428);
  }
  
  public final void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2427);
    bC(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    c((byte)(paramInt & 0xFF));
    c((byte)(paramInt >> 8 & 0xFF));
    c((byte)(paramInt >> 16 & 0xFF));
    c((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(2427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */