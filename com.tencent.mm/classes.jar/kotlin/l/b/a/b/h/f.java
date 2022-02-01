package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  private int abgi;
  private final byte[] buffer;
  private final int limit;
  private final OutputStream output;
  private int position;
  
  private f(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59400);
    this.abgi = 0;
    this.output = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(59400);
  }
  
  public static int B(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59428);
    int i = gR(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    AppMethodBeat.o(59428);
    return i + j;
  }
  
  public static int Xy(long paramLong)
  {
    AppMethodBeat.i(59422);
    int i = gL(2);
    int j = aO(aG(paramLong));
    AppMethodBeat.o(59422);
    return i + j;
  }
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(59434);
    if (this.limit - this.position >= paramInt)
    {
      paramd.k(this.buffer, 0, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.abgi += paramInt;
      AppMethodBeat.o(59434);
      return;
      int i = this.limit - this.position;
      paramd.k(this.buffer, 0, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.abgi = (i + this.abgi);
      iNM();
      if (paramInt <= this.limit)
      {
        paramd.k(this.buffer, j, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        paramd.a(this.output, j, paramInt);
      }
    }
  }
  
  public static long aG(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
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
  
  public static int bM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59418);
    paramInt1 = gL(paramInt1);
    paramInt2 = gM(paramInt2);
    AppMethodBeat.o(59418);
    return paramInt1 + paramInt2;
  }
  
  public static int bO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59421);
    paramInt1 = gL(paramInt1);
    paramInt2 = gM(paramInt2);
    AppMethodBeat.o(59421);
    return paramInt1 + paramInt2;
  }
  
  public static int c(int paramInt, r paramr)
  {
    AppMethodBeat.i(59419);
    paramInt = gL(paramInt);
    int i = c(paramr);
    AppMethodBeat.o(59419);
    return paramInt + i;
  }
  
  public static int c(d paramd)
  {
    AppMethodBeat.i(59420);
    int i = gL(6);
    int j = d(paramd);
    AppMethodBeat.o(59420);
    return i + j;
  }
  
  public static int c(r paramr)
  {
    AppMethodBeat.i(59425);
    int i = paramr.Ad();
    int j = gR(i);
    AppMethodBeat.o(59425);
    return i + j;
  }
  
  public static int cv(String paramString)
  {
    AppMethodBeat.i(59424);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = gR(paramString.length);
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
    int i = gR(paramd.size());
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
  
  public static int gL(int paramInt)
  {
    AppMethodBeat.i(59436);
    paramInt = gR(aa.bT(paramInt, 0));
    AppMethodBeat.o(59436);
    return paramInt;
  }
  
  public static int gM(int paramInt)
  {
    AppMethodBeat.i(59423);
    if (paramInt >= 0)
    {
      paramInt = gR(paramInt);
      AppMethodBeat.o(59423);
      return paramInt;
    }
    AppMethodBeat.o(59423);
    return 10;
  }
  
  public static int gQ(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
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
  
  private void iNM()
  {
    AppMethodBeat.i(59429);
    if (this.output == null)
    {
      f.a locala = new f.a();
      AppMethodBeat.o(59429);
      throw locala;
    }
    this.output.write(this.buffer, 0, this.position);
    this.position = 0;
    AppMethodBeat.o(59429);
  }
  
  private void l(byte paramByte)
  {
    AppMethodBeat.i(59431);
    if (this.position == this.limit) {
      iNM();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.abgi += 1;
    AppMethodBeat.o(59431);
  }
  
  private void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(59433);
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.abgi += paramInt;
      AppMethodBeat.o(59433);
      return;
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.abgi = (i + this.abgi);
      iNM();
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
  
  public final void Jq(boolean paramBoolean)
  {
    AppMethodBeat.i(59403);
    bI(3, 0);
    br(paramBoolean);
    AppMethodBeat.o(59403);
  }
  
  public final void Xz(long paramLong)
  {
    AppMethodBeat.i(59440);
    l((byte)((int)paramLong & 0xFF));
    l((byte)((int)(paramLong >> 8) & 0xFF));
    l((byte)((int)(paramLong >> 16) & 0xFF));
    l((byte)((int)(paramLong >> 24) & 0xFF));
    l((byte)((int)(paramLong >> 32) & 0xFF));
    l((byte)((int)(paramLong >> 40) & 0xFF));
    l((byte)((int)(paramLong >> 48) & 0xFF));
    l((byte)((int)(paramLong >> 56) & 0xFF));
    AppMethodBeat.o(59440);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(59405);
    bI(paramInt, 2);
    b(paramd);
    AppMethodBeat.o(59405);
  }
  
  public final void a(int paramInt, r paramr)
  {
    AppMethodBeat.i(59404);
    bI(paramInt, 2);
    b(paramr);
    AppMethodBeat.o(59404);
  }
  
  public final void aB(long paramLong)
  {
    AppMethodBeat.i(59417);
    aN(aG(paramLong));
    AppMethodBeat.o(59417);
  }
  
  public final void aFv(int paramInt)
  {
    AppMethodBeat.i(59439);
    l((byte)(paramInt & 0xFF));
    l((byte)(paramInt >> 8 & 0xFF));
    l((byte)(paramInt >> 16 & 0xFF));
    l((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(59439);
  }
  
  public final void aN(long paramLong)
  {
    AppMethodBeat.i(59438);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        l((byte)(int)paramLong);
        AppMethodBeat.o(59438);
        return;
      }
      l((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void ac(float paramFloat)
  {
    AppMethodBeat.i(59409);
    aFv(Float.floatToRawIntBits(paramFloat));
    AppMethodBeat.o(59409);
  }
  
  public final void b(int paramInt, r paramr)
  {
    AppMethodBeat.i(59407);
    bI(1, 3);
    bI(2, 0);
    hT(paramInt);
    a(3, paramr);
    bI(1, 4);
    AppMethodBeat.o(59407);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(59414);
    hT(paramd.size());
    e(paramd);
    AppMethodBeat.o(59414);
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(59413);
    hT(paramr.Ad());
    paramr.a(this);
    AppMethodBeat.o(59413);
  }
  
  public final void bI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59435);
    hT(aa.bT(paramInt1, paramInt2));
    AppMethodBeat.o(59435);
  }
  
  public final void bJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59402);
    bI(paramInt1, 0);
    gD(paramInt2);
    AppMethodBeat.o(59402);
  }
  
  public final void br(boolean paramBoolean)
  {
    AppMethodBeat.i(59411);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      l((byte)i);
      AppMethodBeat.o(59411);
      return;
    }
  }
  
  public final void cu(String paramString)
  {
    AppMethodBeat.i(59412);
    paramString = paramString.getBytes("UTF-8");
    hT(paramString.length);
    s(paramString, paramString.length);
    AppMethodBeat.o(59412);
  }
  
  public final void dH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59415);
    hT(paramArrayOfByte.length);
    s(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(59415);
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(59432);
    a(paramd, paramd.size());
    AppMethodBeat.o(59432);
  }
  
  public final void f(double paramDouble)
  {
    AppMethodBeat.i(59408);
    Xz(Double.doubleToRawLongBits(paramDouble));
    AppMethodBeat.o(59408);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(59430);
    if (this.output != null) {
      iNM();
    }
    AppMethodBeat.o(59430);
  }
  
  public final void gD(int paramInt)
  {
    AppMethodBeat.i(59410);
    if (paramInt >= 0)
    {
      hT(paramInt);
      AppMethodBeat.o(59410);
      return;
    }
    aN(paramInt);
    AppMethodBeat.o(59410);
  }
  
  public final void gF(int paramInt)
  {
    AppMethodBeat.i(59416);
    hT(gQ(paramInt));
    AppMethodBeat.o(59416);
  }
  
  public final void hT(int paramInt)
  {
    AppMethodBeat.i(59437);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        l((byte)paramInt);
        AppMethodBeat.o(59437);
        return;
      }
      l((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void ox(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59406);
    bI(paramInt1, 0);
    gD(paramInt2);
    AppMethodBeat.o(59406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.f
 * JD-Core Version:    0.7.0.1
 */