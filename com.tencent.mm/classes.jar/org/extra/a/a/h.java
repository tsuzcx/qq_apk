package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class h
  extends c.c
{
  public h(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(187251);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramb.ajXX) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.ajXY + paramb.ajYa * paramLong;
      this.beV = paramf.f(localByteBuffer, paramLong);
      this.offset = paramf.e(localByteBuffer, 8L + paramLong);
      this.ajYf = paramf.e(localByteBuffer, 16L + paramLong);
      this.ajYg = paramf.e(localByteBuffer, paramLong + 40L);
      AppMethodBeat.o(187251);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.h
 * JD-Core Version:    0.7.0.1
 */