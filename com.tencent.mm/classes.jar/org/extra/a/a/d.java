package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends c.b
{
  private final f NVR;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(220073);
    this.NVG = paramBoolean;
    this.NVR = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.NVH = paramf.e(localByteBuffer, 28L);
      this.NVI = paramf.e(localByteBuffer, 32L);
      this.NVJ = paramf.f(localByteBuffer, 42L);
      this.NVK = paramf.f(localByteBuffer, 44L);
      this.NVL = paramf.f(localByteBuffer, 46L);
      this.NVM = paramf.f(localByteBuffer, 48L);
      this.NVN = paramf.f(localByteBuffer, 50L);
      AppMethodBeat.o(220073);
      return;
    }
  }
  
  public final c.c FN(long paramLong)
  {
    AppMethodBeat.i(220075);
    g localg = new g(this.NVR, this, paramLong);
    AppMethodBeat.o(220075);
    return localg;
  }
  
  public final c.a as(long paramLong, int paramInt)
  {
    AppMethodBeat.i(220076);
    a locala = new a(this.NVR, this, paramLong, paramInt);
    AppMethodBeat.o(220076);
    return locala;
  }
  
  public final c.d gym()
  {
    AppMethodBeat.i(220074);
    i locali = new i(this.NVR, this);
    AppMethodBeat.o(220074);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.d
 * JD-Core Version:    0.7.0.1
 */