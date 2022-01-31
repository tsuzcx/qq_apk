package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
  implements Runnable
{
  boolean tvX = false;
  byte[] tvY = null;
  
  b$c(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135329);
    if ((!this.tvX) && (!b.q(this.tLv)))
    {
      if (this.tvY == null) {
        this.tvY = new byte[c.cQm().tLy.defaultWidth * c.cQm().tLy.defaultHeight * 3 / 2];
      }
      int i;
      int j;
      if (c.cQm().tLy.videoDecode(this.tvY) == 1)
      {
        i = c.cQm().tLy.field_remoteImgWidth;
        j = c.cQm().tLy.field_remoteImgHeight;
        if (OpenGlRender.tGO != 1) {
          break label198;
        }
        if (!b.h(this.tLv)) {
          break label166;
        }
        b.r(this.tLv).a(c.cQm().tLy.tBa, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
      }
      for (;;)
      {
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
        }
        break;
        label166:
        b.s(this.tLv).a(c.cQm().tLy.tBa, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        continue;
        label198:
        if (b.h(this.tLv)) {
          b.r(this.tLv).a(this.tvY, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
        } else {
          b.s(this.tLv).a(this.tvY, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
        }
      }
    }
    AppMethodBeat.o(135329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */