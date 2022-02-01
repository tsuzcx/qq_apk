package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class h
  extends c.c
{
  public h(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(194750);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramb.abLe) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.abLf + paramb.abLh * paramLong;
      this.fwf = paramf.e(localByteBuffer, paramLong);
      this.offset = paramf.d(localByteBuffer, 8L + paramLong);
      this.abLm = paramf.d(localByteBuffer, 16L + paramLong);
      this.abLn = paramf.d(localByteBuffer, paramLong + 40L);
      AppMethodBeat.o(194750);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.h
 * JD-Core Version:    0.7.0.1
 */