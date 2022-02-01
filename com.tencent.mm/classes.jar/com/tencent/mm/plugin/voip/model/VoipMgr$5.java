package com.tencent.mm.plugin.voip.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import java.nio.ByteBuffer;

final class VoipMgr$5
  implements Runnable
{
  VoipMgr$5(VoipMgr paramVoipMgr, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(114967);
    if (this.CuD != null)
    {
      c.eys().c(this.CuD, this.CuE, this.CuF, this.CuG, this.CuH, 0);
      AppMethodBeat.o(114967);
      return;
    }
    if (this.CuI != null)
    {
      u localu = c.eys();
      byte[] arrayOfByte = this.CuI;
      int i = this.CuE;
      int j = this.CuF;
      int k = this.CuG;
      int m = this.CuH;
      new Point(0, 0);
      localu.c(arrayOfByte, i, j, k, m);
    }
    AppMethodBeat.o(114967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.5
 * JD-Core Version:    0.7.0.1
 */