package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends c.b
{
  private final f abLp;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(194692);
    this.abLe = paramBoolean;
    this.abLp = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.abLf = paramf.e(localByteBuffer, 28L);
      this.abLg = paramf.e(localByteBuffer, 32L);
      this.abLh = paramf.f(localByteBuffer, 42L);
      this.abLi = paramf.f(localByteBuffer, 44L);
      this.abLj = paramf.f(localByteBuffer, 46L);
      this.abLk = paramf.f(localByteBuffer, 48L);
      this.abLl = paramf.f(localByteBuffer, 50L);
      AppMethodBeat.o(194692);
      return;
    }
  }
  
  public final c.c XL(long paramLong)
  {
    AppMethodBeat.i(194697);
    g localg = new g(this.abLp, this, paramLong);
    AppMethodBeat.o(194697);
    return localg;
  }
  
  public final c.a aF(long paramLong, int paramInt)
  {
    AppMethodBeat.i(194701);
    a locala = new a(this.abLp, this, paramLong, paramInt);
    AppMethodBeat.o(194701);
    return locala;
  }
  
  public final c.d iVb()
  {
    AppMethodBeat.i(194695);
    i locali = new i(this.abLp, this);
    AppMethodBeat.o(194695);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.d
 * JD-Core Version:    0.7.0.1
 */