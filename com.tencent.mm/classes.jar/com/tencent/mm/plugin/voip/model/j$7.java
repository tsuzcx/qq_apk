package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a.a;

final class j$7
  implements Runnable
{
  j$7(j paramj) {}
  
  public final void run()
  {
    if ((j.c(this.pQy) != 4) && (j.c(this.pQy) != 5) && (j.c(this.pQy) != 6))
    {
      a.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + j.c(this.pQy));
      return;
    }
    if (this.pQy.pPB)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
      return;
    }
    this.pQy.pPB = true;
    a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
    int i = this.pQy.pQe.connectToPeerDirect();
    if (i < 0)
    {
      a.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:" + i);
      this.pQy.pQe.pWi.pQU = 14;
      this.pQy.s(1, -9002, "");
      return;
    }
    this.pQy.bQh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j.7
 * JD-Core Version:    0.7.0.1
 */