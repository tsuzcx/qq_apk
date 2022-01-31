package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class j$1
  implements Runnable
{
  j$1(j paramj, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    j.uC();
    String str;
    int i;
    if (this.bEe.getType() == 128)
    {
      j.a(this.pvX);
      str = ((e)this.bEe).fileName;
      i = ((e)this.bEe).retCode;
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.pvX.bDU.get(str) != null)
        {
          l1 = ((g.a)this.pvX.bDU.get(str)).zJ();
          this.pvX.bDU.remove(str);
        }
      }
      y.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + this.bEe.getType() + " errtype:" + this.bEf + " errCode:" + this.bEg + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.bEf != 3) || (i == 0)) {
        break label398;
      }
      j.c(this.pvX);
      label214:
      y.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.access$000() + " stop:" + j.d(this.pvX) + " running:" + j.e(this.pvX) + " recving:" + j.f(this.pvX) + " sending:" + j.g(this.pvX));
      if (j.d(this.pvX) <= 0) {
        break label417;
      }
      j.h(this.pvX);
    }
    for (;;)
    {
      j.uD();
      return;
      if (this.bEe.getType() == 329)
      {
        j.b(this.pvX);
        str = ((b)this.bEe).fileName;
        i = ((b)this.bEe).retCode;
        break;
      }
      y.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + this.bEe.getType());
      j.uD();
      return;
      label398:
      if (this.bEf == 0) {
        break label214;
      }
      j.a(this.pvX, 0);
      break label214;
      label417:
      if ((!j.g(this.pvX)) && (!j.f(this.pvX))) {
        j.i(this.pvX);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.1
 * JD-Core Version:    0.7.0.1
 */