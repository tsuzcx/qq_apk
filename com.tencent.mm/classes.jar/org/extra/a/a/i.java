package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i
  extends c.d
{
  public i(f paramf, c.b paramb)
  {
    AppMethodBeat.i(236812);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramb.UhJ) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.UhT = paramf.e(localByteBuffer, paramb.UhL + paramb.UhO * 0 + 28L);
      AppMethodBeat.o(236812);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.a.i
 * JD-Core Version:    0.7.0.1
 */