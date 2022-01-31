package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class j$1
  implements Runnable
{
  j$1(j paramj, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(25307);
    j.EU();
    String str;
    int i;
    if (this.ckS.getType() == 128)
    {
      j.a(this.sXD);
      str = ((e)this.ckS).fileName;
      i = ((e)this.ckS).retCode;
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.sXD.ckJ.get(str) != null)
        {
          l1 = ((g.a)this.sXD.ckJ.get(str)).Mm();
          this.sXD.ckJ.remove(str);
        }
      }
      ab.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + this.ckS.getType() + " errtype:" + this.val$errType + " errCode:" + this.val$errCode + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.val$errType != 3) || (i == 0)) {
        break label416;
      }
      j.c(this.sXD);
      label220:
      ab.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.access$000() + " stop:" + j.d(this.sXD) + " running:" + j.e(this.sXD) + " recving:" + j.f(this.sXD) + " sending:" + j.g(this.sXD));
      if (j.d(this.sXD) <= 0) {
        break label435;
      }
      j.h(this.sXD);
    }
    for (;;)
    {
      j.EV();
      AppMethodBeat.o(25307);
      return;
      if (this.ckS.getType() == 329)
      {
        j.b(this.sXD);
        str = ((b)this.ckS).fileName;
        i = ((b)this.ckS).retCode;
        break;
      }
      ab.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + this.ckS.getType());
      j.EV();
      AppMethodBeat.o(25307);
      return;
      label416:
      if (this.val$errType == 0) {
        break label220;
      }
      j.a(this.sXD, 0);
      break label220;
      label435:
      if ((!j.g(this.sXD)) && (!j.f(this.sXD))) {
        j.i(this.sXD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.1
 * JD-Core Version:    0.7.0.1
 */