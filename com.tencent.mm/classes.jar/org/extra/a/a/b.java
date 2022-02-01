package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
  extends c.a
{
  public b(f paramf, c.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(194686);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramb.abLe) {}
    for (paramb = ByteOrder.BIG_ENDIAN;; paramb = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramb);
      paramLong = paramInt * 16 + paramLong;
      this.abLc = paramf.d(localByteBuffer, paramLong);
      this.abLd = paramf.d(localByteBuffer, paramLong + 8L);
      AppMethodBeat.o(194686);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.b
 * JD-Core Version:    0.7.0.1
 */