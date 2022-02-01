package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  private int NqQ;
  private final byte[] buffer;
  private final int limit;
  private final OutputStream output;
  private int position;
  
  private f(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59400);
    this.NqQ = 0;
    this.output = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(59400);
  }
  
  public static long FB(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int Fz(long paramLong)
  {
    AppMethodBeat.i(59422);
    int i = fN(2);
    int j = ax(FB(paramLong));
    AppMethodBeat.o(59422);
    return i + j;
  }
  
  public static int a(m paramm)
  {
    AppMethodBeat.i(59426);
    int i = paramm.zp();
    int j = fP(i);
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
      this.NqQ += paramInt;
      AppMethodBeat.o(59434);
      return;
      int i = this.limit - this.position;
      paramd.i(this.buffer, 0, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.NqQ = (i + this.NqQ);
      grC();
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
  
  public static int alf(int paramInt)
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
  
  public static int bz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59418);
    paramInt1 = fN(paramInt1);
    paramInt2 = fL(paramInt2);
    AppMethodBeat.o(59418);
    return paramInt1 + paramInt2;
  }
  
  public static int c(int paramInt, q paramq)
  {
    AppMethodBeat.i(59419);
    paramInt = fN(paramInt);
    int i = c(paramq);
    AppMethodBeat.o(59419);
    return paramInt + i;
  }
  
  public static int c(d paramd)
  {
    AppMethodBeat.i(59420);
    int i = fN(6);
    int j = d(paramd);
    AppMethodBeat.o(59420);
    return i + j;
  }
  
  public static int c(q paramq)
  {
    AppMethodBeat.i(59425);
    int i = paramq.zp();
    int j = fP(i);
    AppMethodBeat.o(59425);
    return i + j;
  }
  
  public static int cc(String paramString)
  {
    AppMethodBeat.i(59424);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = fP(paramString.length);
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
  
  public static int d(d paramd)
  {
    AppMethodBeat.i(59427);
    int i = fP(paramd.size());
    int j = paramd.size();
    AppMethodBeat.o(59427);
    return i + j;
  }
  
  private void d(byte paramByte)
  {
    AppMethodBeat.i(59431);
    if (this.position == this.limit) {
      grC();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.NqQ += 1;
    AppMethodBeat.o(59431);
  }
  
  public static int db(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59428);
    int i = fP(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    AppMethodBeat.o(59428);
    return i + j;
  }
  
  public static f f(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(59401);
    paramOutputStream = new f(paramOutputStream, new byte[paramInt]);
    AppMethodBeat.o(59401);
    return paramOutputStream;
  }
  
  public static int fL(int paramInt)
  {
    AppMethodBeat.i(59423);
    if (paramInt >= 0)
    {
      paramInt = fP(paramInt);
      AppMethodBeat.o(59423);
      return paramInt;
    }
    AppMethodBeat.o(59423);
    return 10;
  }
  
  public static int fN(int paramInt)
  {
    AppMethodBeat.i(59436);
    paramInt = fP(z.bC(paramInt, 0));
    AppMethodBeat.o(59436);
    return paramInt;
  }
  
  public static int fP(int paramInt)
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
  
  private void grC()
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
  
  public static int ls(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59421);
    paramInt1 = fN(paramInt1);
    paramInt2 = fL(paramInt2);
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
      this.NqQ += paramInt;
      AppMethodBeat.o(59433);
      return;
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.NqQ = (i + this.NqQ);
      grC();
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
  
  public final void Af(boolean paramBoolean)
  {
    AppMethodBeat.i(59403);
    bB(3, 0);
    Ag(paramBoolean);
    AppMethodBeat.o(59403);
  }
  
  public final void Ag(boolean paramBoolean)
  {
    AppMethodBeat.i(59411);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d((byte)i);
      AppMethodBeat.o(59411);
      return;
    }
  }
  
  public final void FA(long paramLong)
  {
    AppMethodBeat.i(59440);
    d((byte)((int)paramLong & 0xFF));
    d((byte)((int)(paramLong >> 8) & 0xFF));
    d((byte)((int)(paramLong >> 16) & 0xFF));
    d((byte)((int)(paramLong >> 24) & 0xFF));
    d((byte)((int)(paramLong >> 32) & 0xFF));
    d((byte)((int)(paramLong >> 40) & 0xFF));
    d((byte)((int)(paramLong >> 48) & 0xFF));
    d((byte)((int)(paramLong >> 56) & 0xFF));
    AppMethodBeat.o(59440);
  }
  
  public final void Fy(long paramLong)
  {
    AppMethodBeat.i(59417);
    aw(FB(paramLong));
    AppMethodBeat.o(59417);
  }
  
  public final void M(double paramDouble)
  {
    AppMethodBeat.i(59408);
    FA(Double.doubleToRawLongBits(paramDouble));
    AppMethodBeat.o(59408);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(59405);
    bB(paramInt, 2);
    b(paramd);
    AppMethodBeat.o(59405);
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(59404);
    bB(paramInt, 2);
    b(paramq);
    AppMethodBeat.o(59404);
  }
  
  public final void alc(int paramInt)
  {
    AppMethodBeat.i(59410);
    if (paramInt >= 0)
    {
      fO(paramInt);
      AppMethodBeat.o(59410);
      return;
    }
    aw(paramInt);
    AppMethodBeat.o(59410);
  }
  
  public final void ald(int paramInt)
  {
    AppMethodBeat.i(59416);
    fO(alf(paramInt));
    AppMethodBeat.o(59416);
  }
  
  public final void ale(int paramInt)
  {
    AppMethodBeat.i(59439);
    d((byte)(paramInt & 0xFF));
    d((byte)(paramInt >> 8 & 0xFF));
    d((byte)(paramInt >> 16 & 0xFF));
    d((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(59439);
  }
  
  public final void aw(long paramLong)
  {
    AppMethodBeat.i(59438);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        d((byte)(int)paramLong);
        AppMethodBeat.o(59438);
        return;
      }
      d((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void b(int paramInt, q paramq)
  {
    AppMethodBeat.i(59407);
    bB(1, 3);
    bB(2, 0);
    fO(paramInt);
    a(3, paramq);
    bB(1, 4);
    AppMethodBeat.o(59407);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(59414);
    fO(paramd.size());
    e(paramd);
    AppMethodBeat.o(59414);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(59413);
    fO(paramq.zp());
    paramq.a(this);
    AppMethodBeat.o(59413);
  }
  
  public final void bB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59435);
    fO(z.bC(paramInt1, paramInt2));
    AppMethodBeat.o(59435);
  }
  
  public final void bcK(String paramString)
  {
    AppMethodBeat.i(59412);
    paramString = paramString.getBytes("UTF-8");
    fO(paramString.length);
    q(paramString, paramString.length);
    AppMethodBeat.o(59412);
  }
  
  public final void bx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59402);
    bB(paramInt1, 0);
    alc(paramInt2);
    AppMethodBeat.o(59402);
  }
  
  public final void cr(float paramFloat)
  {
    AppMethodBeat.i(59409);
    ale(Float.floatToRawIntBits(paramFloat));
    AppMethodBeat.o(59409);
  }
  
  public final void da(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59415);
    fO(paramArrayOfByte.length);
    q(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(59415);
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(59432);
    a(paramd, paramd.size());
    AppMethodBeat.o(59432);
  }
  
  public final void fO(int paramInt)
  {
    AppMethodBeat.i(59437);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        d((byte)paramInt);
        AppMethodBeat.o(59437);
        return;
      }
      d((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(59430);
    if (this.output != null) {
      grC();
    }
    AppMethodBeat.o(59430);
  }
  
  public final void lr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59406);
    bB(paramInt1, 0);
    alc(paramInt2);
    AppMethodBeat.o(59406);
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