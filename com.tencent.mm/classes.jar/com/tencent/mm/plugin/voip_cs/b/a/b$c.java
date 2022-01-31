package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$c
  implements Runnable
{
  boolean pQT = false;
  
  b$c(b paramb) {}
  
  public final void run()
  {
    if ((!this.pQT) && (!b.q(this.qeI)))
    {
      int i;
      int j;
      if (c.bSO().qeL.videoDecode(c.bSO().qeL.pVv) == 1)
      {
        i = c.bSO().qeL.field_remoteImgWidth;
        j = c.bSO().qeL.field_remoteImgHeight;
        if (OpenGlRender.qbn != 1) {
          break label162;
        }
        if (!b.h(this.qeI)) {
          break label130;
        }
        b.r(this.qeI).a(c.bSO().qeL.pVv, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
      }
      for (;;)
      {
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          y.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
        }
        break;
        label130:
        b.s(this.qeI).a(c.bSO().qeL.pVv, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        continue;
        label162:
        if (b.h(this.qeI)) {
          b.r(this.qeI).a(c.bSO().qeL.pVv, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
        } else {
          b.s(this.qeI).a(c.bSO().qeL.pVv, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */