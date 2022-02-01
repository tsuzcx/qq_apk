package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  private int LzT;
  private final byte[] buffer;
  private final int limit;
  private final OutputStream output;
  private int position;
  
  private f(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59400);
    this.LzT = 0;
    this.output = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(59400);
  }
  
  public static int Cu(long paramLong)
  {
    AppMethodBeat.i(59422);
    int i = fK(2);
    int j = ax(Cw(paramLong));
    AppMethodBeat.o(59422);
    return i + j;
  }
  
  public static long Cw(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int a(m paramm)
  {
    AppMethodBeat.i(59426);
    int i = paramm.xS();
    int j = fM(i);
    AppMethodBeat.o(59426);
    return i + j;
  }
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(59434);
    if (this.limit - this.position >= paramInt)
    {
      paramd.i(this.buffer, 0, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.LzT += paramInt;
      AppMethodBeat.o(59434);
      return;
      int i = this.limit - this.position;
      paramd.i(this.buffer, 0, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.LzT = (i + this.LzT);
      gad();
      if (paramInt <= this.limit)
      {
        paramd.i(this.buffer, j, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        paramd.a(this.output, j, paramInt);
      }
    }
  }
  
  public static int aiE(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int ax(long paramLong)
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
  
  public static int bj(String paramString)
  {
    AppMethodBeat.i(59424);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fM(paramString.length);
      int j = paramString.length;
      AppMethodBeat.o(59424);
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported.", paramString);
      AppMethodBeat.o(59424);
      throw paramString;
    }
  }
  
  public static int bx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59418);
    paramInt1 = fK(paramInt1);
    paramInt2 = fI(paramInt2);
    AppMethodBeat.o(59418);
    return paramInt1 + paramInt2;
  }
  
  public static int c(int paramInt, q paramq)
  {
    AppMethodBeat.i(59419);
    paramInt = fK(paramInt);
    int i = c(paramq);
    AppMethodBeat.o(59419);
    return paramInt + i;
  }
  
  public static int c(d paramd)
  {
    AppMethodBeat.i(59420);
    int i = fK(6);
    int j = d(paramd);
    AppMethodBeat.o(59420);
    return i + j;
  }
  
  public static int c(q paramq)
  {
    AppMethodBeat.i(59425);
    int i = paramq.xS();
    int j = fM(i);
    AppMethodBeat.o(59425);
    return i + j;
  }
  
  private void c(byte paramByte)
  {
    AppMethodBeat.i(59431);
    if (this.position == this.limit) {
      gad();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.LzT += 1;
    AppMethodBeat.o(59431);
  }
  
  public static int cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59428);
    int i = fM(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    AppMethodBeat.o(59428);
    return i + j;
  }
  
  public static int d(d paramd)
  {
    AppMethodBeat.i(59427);
    int i = fM(paramd.size());
    int j = paramd.size();
    AppMethodBeat.o(59427);
    return i + j;
  }
  
  public static f f(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(59401);
    paramOutputStream = new f(paramOutputStream, new byte[paramInt]);
    AppMethodBeat.o(59401);
    return paramOutputStream;
  }
  
  public static int fI(int paramInt)
  {
    AppMethodBeat.i(59423);
    if (paramInt >= 0)
    {
      paramInt = fM(paramInt);
      AppMethodBeat.o(59423);
      return paramInt;
    }
    AppMethodBeat.o(59423);
    return 10;
  }
  
  public static int fK(int paramInt)
  {
    AppMethodBeat.i(59436);
    paramInt = fM(z.bA(paramInt, 0));
    AppMethodBeat.o(59436);
    return paramInt;
  }
  
  public static int fM(int paramInt)
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
  
  private void gad()
  {
    AppMethodBeat.i(59429);
    if (this.output == null)
    {
      a locala = new a();
      AppMethodBeat.o(59429);
      throw locala;
    }
    this.output.write(this.buffer, 0, this.position);
    this.position = 0;
    AppMethodBeat.o(59429);
  }
  
  public static int ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59421);
    paramInt1 = fK(paramInt1);
    paramInt2 = fI(paramInt2);
    AppMethodBeat.o(59421);
    return paramInt1 + paramInt2;
  }
  
  private void q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(59433);
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.LzT += paramInt;
      AppMethodBeat.o(59433);
      return;
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.LzT = (i + this.LzT);
      gad();
      if (paramInt <= this.limit)
      {
        System.arraycopy(paramArrayOfByte, j, this.buffer, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        this.output.write(paramArrayOfByte, j, paramInt);
      }
    }
  }
  
  public final void Ct(long paramLong)
  {
    AppMethodBeat.i(59417);
    aw(Cw(paramLong));
    AppMethodBeat.o(59417);
  }
  
  public final void Cv(long paramLong)
  {
    AppMethodBeat.i(59440);
    c((byte)((int)paramLong & 0xFF));
    c((byte)((int)(paramLong >> 8) & 0xFF));
    c((byte)((int)(paramLong >> 16) & 0xFF));
    c((byte)((int)(paramLong >> 24) & 0xFF));
    c((byte)((int)(paramLong >> 32) & 0xFF));
    c((byte)((int)(paramLong >> 40) & 0xFF));
    c((byte)((int)(paramLong >> 48) & 0xFF));
    c((byte)((int)(paramLong >> 56) & 0xFF));
    AppMethodBeat.o(59440);
  }
  
  public final void L(double paramDouble)
  {
    AppMethodBeat.i(59408);
    Cv(Double.doubleToRawLongBits(paramDouble));
    AppMethodBeat.o(59408);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(59405);
    bz(paramInt, 2);
    b(paramd);
    AppMethodBeat.o(59405);
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(59404);
    bz(paramInt, 2);
    b(paramq);
    AppMethodBeat.o(59404);
  }
  
  public final void aWH(String paramString)
  {
    AppMethodBeat.i(59412);
    paramString = paramString.getBytes("UTF-8");
    fL(paramString.length);
    q(paramString, paramString.length);
    AppMethodBeat.o(59412);
  }
  
  public final void aiB(int paramInt)
  {
    AppMethodBeat.i(59410);
    if (paramInt >= 0)
    {
      fL(paramInt);
      AppMethodBeat.o(59410);
      return;
    }
    aw(paramInt);
    AppMethodBeat.o(59410);
  }
  
  public final void aiC(int paramInt)
  {
    AppMethodBeat.i(59416);
    fL(aiE(paramInt));
    AppMethodBeat.o(59416);
  }
  
  public final void aiD(int paramInt)
  {
    AppMethodBeat.i(59439);
    c((byte)(paramInt & 0xFF));
    c((byte)(paramInt >> 8 & 0xFF));
    c((byte)(paramInt >> 16 & 0xFF));
    c((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(59439);
  }
  
  public final void aw(long paramLong)
  {
    AppMethodBeat.i(59438);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        c((byte)(int)paramLong);
        AppMethodBeat.o(59438);
        return;
      }
      c((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void b(int paramInt, q paramq)
  {
    AppMethodBeat.i(59407);
    bz(1, 3);
    bz(2, 0);
    fL(paramInt);
    a(3, paramq);
    bz(1, 4);
    AppMethodBeat.o(59407);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(59414);
    fL(paramd.size());
    e(paramd);
    AppMethodBeat.o(59414);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(59413);
    fL(paramq.xS());
    paramq.a(this);
    AppMethodBeat.o(59413);
  }
  
  public final void bv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59402);
    bz(paramInt1, 0);
    aiB(paramInt2);
    AppMethodBeat.o(59402);
  }
  
  public final void bz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59435);
    fL(z.bA(paramInt1, paramInt2));
    AppMethodBeat.o(59435);
  }
  
  public final void cU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59415);
    fL(paramArrayOfByte.length);
    q(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(59415);
  }
  
  public final void cm(float paramFloat)
  {
    AppMethodBeat.i(59409);
    aiD(Float.floatToRawIntBits(paramFloat));
    AppMethodBeat.o(59409);
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(59432);
    a(paramd, paramd.size());
    AppMethodBeat.o(59432);
  }
  
  public final void fL(int paramInt)
  {
    AppMethodBeat.i(59437);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        c((byte)paramInt);
        AppMethodBeat.o(59437);
        return;
      }
      c((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(59430);
    if (this.output != null) {
      gad();
    }
    AppMethodBeat.o(59430);
  }
  
  public final void lc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59406);
    bz(paramInt1, 0);
    aiB(paramInt2);
    AppMethodBeat.o(59406);
  }
  
  public final void zr(boolean paramBoolean)
  {
    AppMethodBeat.i(59403);
    bz(3, 0);
    zs(paramBoolean);
    AppMethodBeat.o(59403);
  }
  
  public final void zs(boolean paramBoolean)
  {
    AppMethodBeat.i(59411);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      c((byte)i);
      AppMethodBeat.o(59411);
      return;
    }
  }
  
  public static final class a
    extends IOException
  {
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.f
 * JD-Core Version:    0.7.0.1
 */