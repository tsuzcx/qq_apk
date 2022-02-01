package com.tencent.mm.plugin.voip.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;

final class VoipMgr$5
  implements Runnable
{
  VoipMgr$5(VoipMgr paramVoipMgr, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    AppMethodBeat.i(114967);
    u localu = c.dRQ();
    byte[] arrayOfByte = this.zlr;
    int i = this.zls;
    int j = this.zlt;
    int k = this.zlu;
    int m = this.zlv;
    new Point(0, 0);
    localu.c(arrayOfByte, i, j, k, m);
    AppMethodBeat.o(114967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.5
 * JD-Core Version:    0.7.0.1
 */