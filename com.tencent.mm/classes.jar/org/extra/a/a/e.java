package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class e
  extends c.b
{
  private final f OsW;
  
  public e(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(216831);
    this.OsL = paramBoolean;
    this.OsW = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.OsM = paramf.d(localByteBuffer, 32L);
      this.OsN = paramf.d(localByteBuffer, 40L);
      this.OsO = paramf.f(localByteBuffer, 54L);
      this.OsP = paramf.f(localByteBuffer, 56L);
      this.OsQ = paramf.f(localByteBuffer, 58L);
      this.OsR = paramf.f(localByteBuffer, 60L);
      this.OsS = paramf.f(localByteBuffer, 62L);
      AppMethodBeat.o(216831);
      return;
    }
  }
  
  public final c.c Gp(long paramLong)
  {
    AppMethodBeat.i(216833);
    h localh = new h(this.OsW, this, paramLong);
    AppMethodBeat.o(216833);
    return localh;
  }
  
  public final c.a at(long paramLong, int paramInt)
  {
    AppMethodBeat.i(216834);
    b localb = new b(this.OsW, this, paramLong, paramInt);
    AppMethodBeat.o(216834);
    return localb;
  }
  
  public final c.d gCO()
  {
    AppMethodBeat.i(216832);
    j localj = new j(this.OsW, this);
    AppMethodBeat.o(216832);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.e
 * JD-Core Version:    0.7.0.1
 */