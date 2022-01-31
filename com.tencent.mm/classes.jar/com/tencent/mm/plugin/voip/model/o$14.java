package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.video.a;
import com.tencent.mm.sdk.platformtools.y;

final class o$14
  implements Runnable
{
  o$14(o paramo) {}
  
  public final void run()
  {
    y.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + o.c(this.pSP));
    if (o.c(this.pSP) != null) {
      o.c(this.pSP).bSr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.14
 * JD-Core Version:    0.7.0.1
 */