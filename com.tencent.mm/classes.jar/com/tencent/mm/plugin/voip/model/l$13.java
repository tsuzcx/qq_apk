package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.f.g;

final class l$13
  implements Runnable
{
  l$13(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(114897);
    g.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
    if ((this.Uzp.Lkt != null) && (this.Uzp.UyU.UFs != null))
    {
      int i = this.Uzp.UyU.QueryNicWanIp(this.Uzp.UyU.UFs, this.Uzp.UyU.UFs.length);
      if (i != 0) {
        g.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(i)));
      }
    }
    else
    {
      this.Uzp.geB();
      AppMethodBeat.o(114897);
      return;
    }
    AppMethodBeat.o(114897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.13
 * JD-Core Version:    0.7.0.1
 */