package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class j
  extends c.d
{
  public j(f paramf, c.b paramb)
  {
    AppMethodBeat.i(216848);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramb.OsL) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.OsV = paramf.e(localByteBuffer, paramb.OsN + paramb.OsQ * 0 + 44L);
      AppMethodBeat.o(216848);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.j
 * JD-Core Version:    0.7.0.1
 */