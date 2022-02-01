package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
  extends c.a
{
  public b(f paramf, c.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220072);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramb.NVG) {}
    for (paramb = ByteOrder.BIG_ENDIAN;; paramb = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramb);
      paramLong = paramInt * 16 + paramLong;
      this.NVE = paramf.d(localByteBuffer, paramLong);
      this.NVF = paramf.d(localByteBuffer, paramLong + 8L);
      AppMethodBeat.o(220072);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.b
 * JD-Core Version:    0.7.0.1
 */