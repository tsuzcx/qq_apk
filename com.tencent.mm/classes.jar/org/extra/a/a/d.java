package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends c.b
{
  private final f ajYi;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(187263);
    this.ajXX = paramBoolean;
    this.ajYi = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.g(localByteBuffer, 16L);
      this.ajXY = paramf.f(localByteBuffer, 28L);
      this.ajXZ = paramf.f(localByteBuffer, 32L);
      this.ajYa = paramf.g(localByteBuffer, 42L);
      this.ajYb = paramf.g(localByteBuffer, 44L);
      this.ajYc = paramf.g(localByteBuffer, 46L);
      this.ajYd = paramf.g(localByteBuffer, 48L);
      this.ajYe = paramf.g(localByteBuffer, 50L);
      AppMethodBeat.o(187263);
      return;
    }
  }
  
  public final c.c Co(long paramLong)
  {
    AppMethodBeat.i(187275);
    g localg = new g(this.ajYi, this, paramLong);
    AppMethodBeat.o(187275);
    return localg;
  }
  
  public final c.a aW(long paramLong, int paramInt)
  {
    AppMethodBeat.i(187279);
    a locala = new a(this.ajYi, this, paramLong, paramInt);
    AppMethodBeat.o(187279);
    return locala;
  }
  
  public final c.d kJz()
  {
    AppMethodBeat.i(187266);
    i locali = new i(this.ajYi, this);
    AppMethodBeat.o(187266);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.d
 * JD-Core Version:    0.7.0.1
 */