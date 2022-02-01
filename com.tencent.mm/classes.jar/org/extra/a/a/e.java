package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class e
  extends c.b
{
  private final f abLp;
  
  public e(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(194708);
    this.abLe = paramBoolean;
    this.abLp = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.abLf = paramf.d(localByteBuffer, 32L);
      this.abLg = paramf.d(localByteBuffer, 40L);
      this.abLh = paramf.f(localByteBuffer, 54L);
      this.abLi = paramf.f(localByteBuffer, 56L);
      this.abLj = paramf.f(localByteBuffer, 58L);
      this.abLk = paramf.f(localByteBuffer, 60L);
      this.abLl = paramf.f(localByteBuffer, 62L);
      AppMethodBeat.o(194708);
      return;
    }
  }
  
  public final c.c XL(long paramLong)
  {
    AppMethodBeat.i(194714);
    h localh = new h(this.abLp, this, paramLong);
    AppMethodBeat.o(194714);
    return localh;
  }
  
  public final c.a aF(long paramLong, int paramInt)
  {
    AppMethodBeat.i(194717);
    b localb = new b(this.abLp, this, paramLong, paramInt);
    AppMethodBeat.o(194717);
    return localb;
  }
  
  public final c.d iVb()
  {
    AppMethodBeat.i(194711);
    j localj = new j(this.abLp, this);
    AppMethodBeat.o(194711);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.e
 * JD-Core Version:    0.7.0.1
 */