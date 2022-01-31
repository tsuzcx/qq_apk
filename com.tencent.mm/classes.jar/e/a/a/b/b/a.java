package e.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] buffer;
  private final int limit;
  private int position;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(51891);
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = (paramInt + 0);
    AppMethodBeat.o(51891);
  }
  
  public static int ap(long paramLong)
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
    AppMethodBeat.i(51903);
    if (paramb == null)
    {
      AppMethodBeat.o(51903);
      return 0;
    }
    paramInt = eW(paramInt);
    int i = eY(paramb.pW.length);
    int j = paramb.pW.length;
    AppMethodBeat.o(51903);
    return paramInt + i + j;
  }
  
  public static int bl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51901);
    if (paramInt2 >= 0)
    {
      paramInt1 = eW(paramInt1);
      paramInt2 = eY(paramInt2);
      AppMethodBeat.o(51901);
      return paramInt1 + paramInt2;
    }
    paramInt1 = eW(paramInt1);
    AppMethodBeat.o(51901);
    return paramInt1 + 10;
  }
  
  private void cG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51904);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(51904);
      return;
    }
    n(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(51904);
  }
  
  private void d(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public static int eW(int paramInt)
  {
    AppMethodBeat.i(51907);
    paramInt = eY(e.a.a.b.a.bo(paramInt, 0));
    AppMethodBeat.o(51907);
    return paramInt;
  }
  
  public static int eY(int paramInt)
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
  
  public static int f(int paramInt, String paramString)
  {
    AppMethodBeat.i(51902);
    if (paramString == null)
    {
      AppMethodBeat.o(51902);
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = eW(paramInt);
      int i = eY(paramString.length);
      int j = paramString.length;
      AppMethodBeat.o(51902);
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new IllegalStateException("UTF-8 not supported.");
      AppMethodBeat.o(51902);
      throw paramString;
    }
  }
  
  private void n(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(51905);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(51905);
      return;
    }
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
      AppMethodBeat.o(51905);
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
    AppMethodBeat.o(51905);
  }
  
  public static int p(int paramInt, long paramLong)
  {
    AppMethodBeat.i(51900);
    paramInt = eW(paramInt);
    int i = ap(paramLong);
    AppMethodBeat.o(51900);
    return paramInt + i;
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(51898);
    if (paramb == null)
    {
      AppMethodBeat.o(51898);
      return;
    }
    bn(paramInt, 2);
    paramb = paramb.toByteArray();
    eX(paramb.length);
    cG(paramb);
    AppMethodBeat.o(51898);
  }
  
  public final void aR(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(51896);
    bn(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    d((byte)paramInt);
    AppMethodBeat.o(51896);
  }
  
  public final void ao(long paramLong)
  {
    AppMethodBeat.i(51909);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        d((byte)(int)paramLong);
        AppMethodBeat.o(51909);
        return;
      }
      d((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void bj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51895);
    bn(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      eX(paramInt2);
      AppMethodBeat.o(51895);
      return;
    }
    ao(paramInt2);
    AppMethodBeat.o(51895);
  }
  
  public final void bn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51906);
    eX(e.a.a.b.a.bo(paramInt1, paramInt2));
    AppMethodBeat.o(51906);
  }
  
  public final void e(int paramInt, String paramString)
  {
    AppMethodBeat.i(51897);
    if (paramString == null)
    {
      AppMethodBeat.o(51897);
      return;
    }
    bn(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    eX(paramString.length);
    cG(paramString);
    AppMethodBeat.o(51897);
  }
  
  public final void eX(int paramInt)
  {
    AppMethodBeat.i(51908);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        d((byte)paramInt);
        AppMethodBeat.o(51908);
        return;
      }
      d((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void f(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(51892);
    bn(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    d((byte)((int)l & 0xFF));
    d((byte)((int)(l >> 8) & 0xFF));
    d((byte)((int)(l >> 16) & 0xFF));
    d((byte)((int)(l >> 24) & 0xFF));
    d((byte)((int)(l >> 32) & 0xFF));
    d((byte)((int)(l >> 40) & 0xFF));
    d((byte)((int)(l >> 48) & 0xFF));
    d((byte)((int)(l >> 56) & 0xFF));
    AppMethodBeat.o(51892);
  }
  
  public final void iQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51899);
    bn(paramInt1, 2);
    eX(paramInt2);
    AppMethodBeat.o(51899);
  }
  
  public final void n(int paramInt, long paramLong)
  {
    AppMethodBeat.i(51894);
    bn(paramInt, 0);
    ao(paramLong);
    AppMethodBeat.o(51894);
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(51893);
    bn(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    d((byte)(paramInt & 0xFF));
    d((byte)(paramInt >> 8 & 0xFF));
    d((byte)(paramInt >> 16 & 0xFF));
    d((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(51893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */