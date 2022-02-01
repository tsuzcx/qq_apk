package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class g
  extends c.c
{
  public g(f paramf, c.b paramb, long paramLong)
  {
    AppMethodBeat.i(236810);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.UhJ) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramb.UhK + paramb.UhM * paramLong;
      this.dDw = paramf.e(localByteBuffer, paramLong);
      this.offset = paramf.e(localByteBuffer, 4L + paramLong);
      this.UhR = paramf.e(localByteBuffer, 8L + paramLong);
      this.UhS = paramf.e(localByteBuffer, paramLong + 20L);
      AppMethodBeat.o(236810);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.a.g
 * JD-Core Version:    0.7.0.1
 */