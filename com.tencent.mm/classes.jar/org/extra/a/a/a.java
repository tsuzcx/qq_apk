package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a
  extends c.a
{
  public a(f paramf, c.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(187270);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.ajXX) {}
    for (paramb = ByteOrder.BIG_ENDIAN;; paramb = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramb);
      paramLong = paramInt * 8 + paramLong;
      this.tag = paramf.f(localByteBuffer, paramLong);
      this.ajXW = paramf.f(localByteBuffer, paramLong + 4L);
      AppMethodBeat.o(187270);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.a
 * JD-Core Version:    0.7.0.1
 */