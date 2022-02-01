package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  private final byte[] buffer;
  private int dJp;
  private final int limit;
  private final OutputStream osU;
  private int position;
  
  private f(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59400);
    this.dJp = 0;
    this.osU = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(59400);
  }
  
  public static int BI(long paramLong)
  {
    AppMethodBeat.i(59422);
    int i = ko(2);
    int j = dh(cV(paramLong));
    AppMethodBeat.o(59422);
    return i + j;
  }
  
  public static int D(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59428);
    int i = kv(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    AppMethodBeat.o(59428);
    return i + j;
  }
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(59434);
    if (this.limit - this.position >= paramInt)
    {
      paramd.b(this.buffer, 0, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.dJp += paramInt;
      AppMethodBeat.o(59434);
      return;
      int i = this.limit - this.position;
      paramd.b(this.buffer, 0, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.dJp = (i + this.dJp);
      kye();
      if (paramInt <= this.limit)
      {
        paramd.b(this.buffer, j, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        paramd.a(this.osU, j, paramInt);
      }
    }
  }
  
  public static int c(int paramInt, r paramr)
  {
    AppMethodBeat.i(59419);
    paramInt = ko(paramInt);
    int i = c(paramr);
    AppMethodBeat.o(59419);
    return paramInt + i;
  }
  
  public static int c(d paramd)
  {
    AppMethodBeat.i(59420);
    int i = ko(6);
    int j = d(paramd);
    AppMethodBeat.o(59420);
    return i + j;
  }
  
  public static int c(r paramr)
  {
    AppMethodBeat.i(59425);
    int i = paramr.getSerializedSize();
    int j = kv(i);
    AppMethodBeat.o(59425);
    return i + j;
  }
  
  public static int cJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59418);
    paramInt1 = ko(paramInt1);
    paramInt2 = kp(paramInt2);
    AppMethodBeat.o(59418);
    return paramInt1 + paramInt2;
  }
  
  public static int cM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59421);
    paramInt1 = ko(paramInt1);
    paramInt2 = kp(paramInt2);
    AppMethodBeat.o(59421);
    return paramInt1 + paramInt2;
  }
  
  public static long cV(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int d(d paramd)
  {
    AppMethodBeat.i(59427);
    int i = kv(paramd.size());
    int j = paramd.size();
    AppMethodBeat.o(59427);
    return i + j;
  }
  
  public static int dU(String paramString)
  {
    AppMethodBeat.i(59424);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = kv(paramString.length);
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
  
  public static f i(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(59401);
    paramOutputStream = new f(paramOutputStream, new byte[paramInt]);
    AppMethodBeat.o(59401);
    return paramOutputStream;
  }
  
  public static int ko(int paramInt)
  {
    AppMethodBeat.i(59436);
    paramInt = kv(aa.cU(paramInt, 0));
    AppMethodBeat.o(59436);
    return paramInt;
  }
  
  public static int kp(int paramInt)
  {
    AppMethodBeat.i(59423);
    if (paramInt >= 0)
    {
      paramInt = kv(paramInt);
      AppMethodBeat.o(59423);
      return paramInt;
    }
    AppMethodBeat.o(59423);
    return 10;
  }
  
  public static int ku(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
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
  
  private void kye()
  {
    AppMethodBeat.i(59429);
    if (this.osU == null)
    {
      a locala = new a();
      AppMethodBeat.o(59429);
      throw locala;
    }
    this.osU.write(this.buffer, 0, this.position);
    this.position = 0;
    AppMethodBeat.o(59429);
  }
  
  private void p(byte paramByte)
  {
    AppMethodBeat.i(59431);
    if (this.position == this.limit) {
      kye();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.dJp += 1;
    AppMethodBeat.o(59431);
  }
  
  private void r(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(59433);
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.dJp += paramInt;
      AppMethodBeat.o(59433);
      return;
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.dJp = (i + this.dJp);
      kye();
      if (paramInt <= this.limit)
      {
        System.arraycopy(paramArrayOfByte, j, this.buffer, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        this.osU.write(paramArrayOfByte, j, paramInt);
      }
    }
  }
  
  public final void BJ(long paramLong)
  {
    AppMethodBeat.i(59440);
    p((byte)((int)paramLong & 0xFF));
    p((byte)((int)(paramLong >> 8) & 0xFF));
    p((byte)((int)(paramLong >> 16) & 0xFF));
    p((byte)((int)(paramLong >> 24) & 0xFF));
    p((byte)((int)(paramLong >> 32) & 0xFF));
    p((byte)((int)(paramLong >> 40) & 0xFF));
    p((byte)((int)(paramLong >> 48) & 0xFF));
    p((byte)((int)(paramLong >> 56) & 0xFF));
    AppMethodBeat.o(59440);
  }
  
  public final void Pt(boolean paramBoolean)
  {
    AppMethodBeat.i(59403);
    cE(3, 0);
    bZ(paramBoolean);
    AppMethodBeat.o(59403);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(59405);
    cE(paramInt, 2);
    b(paramd);
    AppMethodBeat.o(59405);
  }
  
  public final void a(int paramInt, r paramr)
  {
    AppMethodBeat.i(59404);
    cE(paramInt, 2);
    b(paramr);
    AppMethodBeat.o(59404);
  }
  
  public final void aMj(int paramInt)
  {
    AppMethodBeat.i(59439);
    p((byte)(paramInt & 0xFF));
    p((byte)(paramInt >> 8 & 0xFF));
    p((byte)(paramInt >> 16 & 0xFF));
    p((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(59439);
  }
  
  public final void b(int paramInt, r paramr)
  {
    AppMethodBeat.i(59407);
    cE(1, 3);
    cE(2, 0);
    lI(paramInt);
    a(3, paramr);
    cE(1, 4);
    AppMethodBeat.o(59407);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(59414);
    lI(paramd.size());
    e(paramd);
    AppMethodBeat.o(59414);
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(59413);
    lI(paramr.getSerializedSize());
    paramr.a(this);
    AppMethodBeat.o(59413);
  }
  
  public final void bZ(boolean paramBoolean)
  {
    AppMethodBeat.i(59411);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      p((byte)i);
      AppMethodBeat.o(59411);
      return;
    }
  }
  
  public final void bd(float paramFloat)
  {
    AppMethodBeat.i(59409);
    aMj(Float.floatToRawIntBits(paramFloat));
    AppMethodBeat.o(59409);
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59435);
    lI(aa.cU(paramInt1, paramInt2));
    AppMethodBeat.o(59435);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59402);
    cE(paramInt1, 0);
    kd(paramInt2);
    AppMethodBeat.o(59402);
  }
  
  public final void cP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59406);
    cE(paramInt1, 0);
    kd(paramInt2);
    AppMethodBeat.o(59406);
  }
  
  public final void cQ(long paramLong)
  {
    AppMethodBeat.i(59417);
    dg(cV(paramLong));
    AppMethodBeat.o(59417);
  }
  
  public final void dK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59415);
    lI(paramArrayOfByte.length);
    r(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(59415);
  }
  
  public final void dT(String paramString)
  {
    AppMethodBeat.i(59412);
    paramString = paramString.getBytes("UTF-8");
    lI(paramString.length);
    r(paramString, paramString.length);
    AppMethodBeat.o(59412);
  }
  
  public final void dg(long paramLong)
  {
    AppMethodBeat.i(59438);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        p((byte)(int)paramLong);
        AppMethodBeat.o(59438);
        return;
      }
      p((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(59432);
    a(paramd, paramd.size());
    AppMethodBeat.o(59432);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(59430);
    if (this.osU != null) {
      kye();
    }
    AppMethodBeat.o(59430);
  }
  
  public final void kd(int paramInt)
  {
    AppMethodBeat.i(59410);
    if (paramInt >= 0)
    {
      lI(paramInt);
      AppMethodBeat.o(59410);
      return;
    }
    dg(paramInt);
    AppMethodBeat.o(59410);
  }
  
  public final void kf(int paramInt)
  {
    AppMethodBeat.i(59416);
    lI(ku(paramInt));
    AppMethodBeat.o(59416);
  }
  
  public final void lI(int paramInt)
  {
    AppMethodBeat.i(59437);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        p((byte)paramInt);
        AppMethodBeat.o(59437);
        return;
      }
      p((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(59408);
    BJ(Double.doubleToRawLongBits(paramDouble));
    AppMethodBeat.o(59408);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.f
 * JD-Core Version:    0.7.0.1
 */