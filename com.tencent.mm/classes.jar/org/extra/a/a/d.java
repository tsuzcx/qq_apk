package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends c.b
{
  private final f UhU;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(236792);
    this.UhJ = paramBoolean;
    this.UhU = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.UhK = paramf.e(localByteBuffer, 28L);
      this.UhL = paramf.e(localByteBuffer, 32L);
      this.UhM = paramf.f(localByteBuffer, 42L);
      this.UhN = paramf.f(localByteBuffer, 44L);
      this.UhO = paramf.f(localByteBuffer, 46L);
      this.UhP = paramf.f(localByteBuffer, 48L);
      this.UhQ = paramf.f(localByteBuffer, 50L);
      AppMethodBeat.o(236792);
      return;
    }
  }
  
  public final c.c Pv(long paramLong)
  {
    AppMethodBeat.i(236794);
    g localg = new g(this.UhU, this, paramLong);
    AppMethodBeat.o(236794);
    return localg;
  }
  
  public final c.a aw(long paramLong, int paramInt)
  {
    AppMethodBeat.i(236795);
    a locala = new a(this.UhU, this, paramLong, paramInt);
    AppMethodBeat.o(236795);
    return locala;
  }
  
  public final c.d hPS()
  {
    AppMethodBeat.i(236793);
    i locali = new i(this.UhU, this);
    AppMethodBeat.o(236793);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.a.d
 * JD-Core Version:    0.7.0.1
 */