package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;

final class k$7
  implements Runnable
{
  k$7(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(4397);
    if ((this.tvC.mStatus != 4) && (this.tvC.mStatus != 5) && (this.tvC.mStatus != 6))
    {
      a.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + this.tvC.mStatus);
      AppMethodBeat.o(4397);
      return;
    }
    if (this.tvC.tuG)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
      AppMethodBeat.o(4397);
      return;
    }
    this.tvC.tuG = true;
    a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
    int i = this.tvC.tvj.connectToPeerDirect();
    if (i < 0)
    {
      a.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(i)));
      this.tvC.tvj.tBN.twb = 14;
      this.tvC.y(1, -9002, "");
      AppMethodBeat.o(4397);
      return;
    }
    this.tvC.cMl();
    AppMethodBeat.o(4397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k.7
 * JD-Core Version:    0.7.0.1
 */