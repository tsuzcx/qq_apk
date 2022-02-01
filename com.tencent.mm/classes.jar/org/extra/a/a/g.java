package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class g
  extends c.c
{
  public g(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(187253);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.ajXX) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.ajXY + paramb.ajYa * paramLong;
      this.beV = paramf.f(localByteBuffer, paramLong);
      this.offset = paramf.f(localByteBuffer, 4L + paramLong);
      this.ajYf = paramf.f(localByteBuffer, 8L + paramLong);
      this.ajYg = paramf.f(localByteBuffer, paramLong + 20L);
      AppMethodBeat.o(187253);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.g
 * JD-Core Version:    0.7.0.1
 */