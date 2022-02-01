package i.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] buffer;
  public final int limit;
  public int position;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(2425);
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt + 0);
    AppMethodBeat.o(2425);
  }
  
  public static int c(int paramInt, b paramb)
  {
    AppMethodBeat.i(2437);
    if (paramb == null)
    {
      AppMethodBeat.o(2437);
      return 0;
    }
    paramInt = ko(paramInt);
    int i = kv(paramb.Op.length);
    int j = paramb.Op.length;
    AppMethodBeat.o(2437);
    return paramInt + i + j;
  }
  
  public static int cJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2435);
    if (paramInt2 >= 0)
    {
      paramInt1 = ko(paramInt1);
      paramInt2 = kv(paramInt2);
      AppMethodBeat.o(2435);
      return paramInt1 + paramInt2;
    }
    paramInt1 = ko(paramInt1);
    AppMethodBeat.o(2435);
    return paramInt1 + 10;
  }
  
  private void dM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2438);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(2438);
      return;
    }
    r(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(2438);
  }
  
  public static int dh(long paramLong)
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
  
  public static int h(int paramInt, String paramString)
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
      paramInt = ko(paramInt);
      int i = kv(paramString.length);
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
  
  public static int ko(int paramInt)
  {
    AppMethodBeat.i(2441);
    paramInt = kv(i.a.a.b.a.cU(paramInt, 0));
    AppMethodBeat.o(2441);
    return paramInt;
  }
  
  public static int kv(int paramInt)
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
  
  private void p(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public static int q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2434);
    paramInt = ko(paramInt);
    int i = dh(paramLong);
    AppMethodBeat.o(2434);
    return paramInt + i;
  }
  
  private void r(byte[] paramArrayOfByte, int paramInt)
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
  
  public final void I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2430);
    cE(paramInt, 0);
    if (paramBoolean)
    {
      p((byte)1);
      AppMethodBeat.o(2430);
      return;
    }
    p((byte)0);
    AppMethodBeat.o(2430);
  }
  
  public final void b(int paramInt, b paramb)
  {
    AppMethodBeat.i(2432);
    if (paramb == null)
    {
      AppMethodBeat.o(2432);
      return;
    }
    cE(paramInt, 2);
    paramb = paramb.toByteArray();
    lI(paramb.length);
    dM(paramb);
    AppMethodBeat.o(2432);
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2440);
    lI(i.a.a.b.a.cU(paramInt1, paramInt2));
    AppMethodBeat.o(2440);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2429);
    cE(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      lI(paramInt2);
      AppMethodBeat.o(2429);
      return;
    }
    dg(paramInt2);
    AppMethodBeat.o(2429);
  }
  
  public final void d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2426);
    cE(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    p((byte)((int)l & 0xFF));
    p((byte)((int)(l >> 8) & 0xFF));
    p((byte)((int)(l >> 16) & 0xFF));
    p((byte)((int)(l >> 24) & 0xFF));
    p((byte)((int)(l >> 32) & 0xFF));
    p((byte)((int)(l >> 40) & 0xFF));
    p((byte)((int)(l >> 48) & 0xFF));
    p((byte)((int)(l >> 56) & 0xFF));
    AppMethodBeat.o(2426);
  }
  
  public final void dg(long paramLong)
  {
    AppMethodBeat.i(2443);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        p((byte)(int)paramLong);
        AppMethodBeat.o(2443);
        return;
      }
      p((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void g(int paramInt, String paramString)
  {
    AppMethodBeat.i(2431);
    if (paramString == null)
    {
      AppMethodBeat.o(2431);
      return;
    }
    cE(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    lI(paramString.length);
    dM(paramString);
    AppMethodBeat.o(2431);
  }
  
  public final void l(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2427);
    cE(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    p((byte)(paramInt & 0xFF));
    p((byte)(paramInt >> 8 & 0xFF));
    p((byte)(paramInt >> 16 & 0xFF));
    p((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(2427);
  }
  
  public final void lI(int paramInt)
  {
    AppMethodBeat.i(2442);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        p((byte)paramInt);
        AppMethodBeat.o(2442);
        return;
      }
      p((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void qD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2433);
    cE(paramInt1, 2);
    lI(paramInt2);
    AppMethodBeat.o(2433);
  }
  
  public final void t(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2428);
    cE(paramInt, 0);
    dg(paramLong);
    AppMethodBeat.o(2428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     i.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */