package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class e
  extends c.b
{
  private final f ajYi;
  
  public e(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(187272);
    this.ajXX = paramBoolean;
    this.ajYi = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.g(localByteBuffer, 16L);
      this.ajXY = paramf.e(localByteBuffer, 32L);
      this.ajXZ = paramf.e(localByteBuffer, 40L);
      this.ajYa = paramf.g(localByteBuffer, 54L);
      this.ajYb = paramf.g(localByteBuffer, 56L);
      this.ajYc = paramf.g(localByteBuffer, 58L);
      this.ajYd = paramf.g(localByteBuffer, 60L);
      this.ajYe = paramf.g(localByteBuffer, 62L);
      AppMethodBeat.o(187272);
      return;
    }
  }
  
  public final c.c Co(long paramLong)
  {
    AppMethodBeat.i(187292);
    h localh = new h(this.ajYi, this, paramLong);
    AppMethodBeat.o(187292);
    return localh;
  }
  
  public final c.a aW(long paramLong, int paramInt)
  {
    AppMethodBeat.i(187300);
    b localb = new b(this.ajYi, this, paramLong, paramInt);
    AppMethodBeat.o(187300);
    return localb;
  }
  
  public final c.d kJz()
  {
    AppMethodBeat.i(187282);
    j localj = new j(this.ajYi, this);
    AppMethodBeat.o(187282);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.e
 * JD-Core Version:    0.7.0.1
 */