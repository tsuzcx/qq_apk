package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class g
  extends c.c
{
  public g(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(220091);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.NVG) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.NVH + paramb.NVJ * paramLong;
      this.dle = paramf.e(localByteBuffer, paramLong);
      this.offset = paramf.e(localByteBuffer, 4L + paramLong);
      this.NVO = paramf.e(localByteBuffer, 8L + paramLong);
      this.NVP = paramf.e(localByteBuffer, paramLong + 20L);
      AppMethodBeat.o(220091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.g
 * JD-Core Version:    0.7.0.1
 */