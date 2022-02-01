package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class e
  extends c.b
{
  private final f NVR;
  
  public e(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(220077);
    this.NVG = paramBoolean;
    this.NVR = paramf;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramf.f(localByteBuffer, 16L);
      this.NVH = paramf.d(localByteBuffer, 32L);
      this.NVI = paramf.d(localByteBuffer, 40L);
      this.NVJ = paramf.f(localByteBuffer, 54L);
      this.NVK = paramf.f(localByteBuffer, 56L);
      this.NVL = paramf.f(localByteBuffer, 58L);
      this.NVM = paramf.f(localByteBuffer, 60L);
      this.NVN = paramf.f(localByteBuffer, 62L);
      AppMethodBeat.o(220077);
      return;
    }
  }
  
  public final c.c FN(long paramLong)
  {
    AppMethodBeat.i(220079);
    h localh = new h(this.NVR, this, paramLong);
    AppMethodBeat.o(220079);
    return localh;
  }
  
  public final c.a as(long paramLong, int paramInt)
  {
    AppMethodBeat.i(220080);
    b localb = new b(this.NVR, this, paramLong, paramInt);
    AppMethodBeat.o(220080);
    return localb;
  }
  
  public final c.d gym()
  {
    AppMethodBeat.i(220078);
    j localj = new j(this.NVR, this);
    AppMethodBeat.o(220078);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.e
 * JD-Core Version:    0.7.0.1
 */