package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends c.b
{
  private final f OsW;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(216827);
    this.OsL = paramBoolean;
    this.OsW = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.OsM = paramf.e(localByteBuffer, 28L);
      this.OsN = paramf.e(localByteBuffer, 32L);
      this.OsO = paramf.f(localByteBuffer, 42L);
      this.OsP = paramf.f(localByteBuffer, 44L);
      this.OsQ = paramf.f(localByteBuffer, 46L);
      this.OsR = paramf.f(localByteBuffer, 48L);
      this.OsS = paramf.f(localByteBuffer, 50L);
      AppMethodBeat.o(216827);
      return;
    }
  }
  
  public final c.c Gp(long paramLong)
  {
    AppMethodBeat.i(216829);
    g localg = new g(this.OsW, this, paramLong);
    AppMethodBeat.o(216829);
    return localg;
  }
  
  public final c.a at(long paramLong, int paramInt)
  {
    AppMethodBeat.i(216830);
    a locala = new a(this.OsW, this, paramLong, paramInt);
    AppMethodBeat.o(216830);
    return locala;
  }
  
  public final c.d gCO()
  {
    AppMethodBeat.i(216828);
    i locali = new i(this.OsW, this);
    AppMethodBeat.o(216828);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.d
 * JD-Core Version:    0.7.0.1
 */