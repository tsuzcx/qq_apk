package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a
  extends c.a
{
  public a(f paramf, c.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220071);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.NVG) {}
    for (paramb = ByteOrder.BIG_ENDIAN;; paramb = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramb);
      paramLong = paramInt * 8 + paramLong;
      this.NVE = paramf.e(localByteBuffer, paramLong);
      this.NVF = paramf.e(localByteBuffer, paramLong + 4L);
      AppMethodBeat.o(220071);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.a
 * JD-Core Version:    0.7.0.1
 */