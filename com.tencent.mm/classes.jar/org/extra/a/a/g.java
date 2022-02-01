package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class g
  extends c.c
{
  public g(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(194748);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.abLe) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.abLf + paramb.abLh * paramLong;
      this.fwf = paramf.e(localByteBuffer, paramLong);
      this.offset = paramf.e(localByteBuffer, 4L + paramLong);
      this.abLm = paramf.e(localByteBuffer, 8L + paramLong);
      this.abLn = paramf.e(localByteBuffer, paramLong + 20L);
      AppMethodBeat.o(194748);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.g
 * JD-Core Version:    0.7.0.1
 */