package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class e
  extends c.b
{
  private final f UhU;
  
  public e(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(236796);
    this.UhJ = paramBoolean;
    this.UhU = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.UhK = paramf.d(localByteBuffer, 32L);
      this.UhL = paramf.d(localByteBuffer, 40L);
      this.UhM = paramf.f(localByteBuffer, 54L);
      this.UhN = paramf.f(localByteBuffer, 56L);
      this.UhO = paramf.f(localByteBuffer, 58L);
      this.UhP = paramf.f(localByteBuffer, 60L);
      this.UhQ = paramf.f(localByteBuffer, 62L);
      AppMethodBeat.o(236796);
      return;
    }
  }
  
  public final c.c Pv(long paramLong)
  {
    AppMethodBeat.i(236798);
    h localh = new h(this.UhU, this, paramLong);
    AppMethodBeat.o(236798);
    return localh;
  }
  
  public final c.a aw(long paramLong, int paramInt)
  {
    AppMethodBeat.i(236799);
    b localb = new b(this.UhU, this, paramLong, paramInt);
    AppMethodBeat.o(236799);
    return localb;
  }
  
  public final c.d hPS()
  {
    AppMethodBeat.i(236797);
    j localj = new j(this.UhU, this);
    AppMethodBeat.o(236797);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.a.e
 * JD-Core Version:    0.7.0.1
 */