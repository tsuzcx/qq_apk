package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i
  extends c.d
{
  public i(f paramf, c.b paramb)
  {
    AppMethodBeat.i(194754);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.abLe) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.abLo = paramf.e(localByteBuffer, paramb.abLg + paramb.abLj * 0 + 28L);
      AppMethodBeat.o(194754);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.extra.a.a.i
 * JD-Core Version:    0.7.0.1
 */