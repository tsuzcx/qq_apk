package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class g$52
  implements f
{
  g$52(g paramg, ag paramag, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(154976);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (cpu)this.vqW.fBd.fsW.fta;
      if (paramString.lGK != 0) {
        break label125;
      }
      paramString = paramString.xYC;
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramString = paramString.iterator();
      }
      while (paramString.hasNext())
      {
        paramm = (String)paramString.next();
        g.a(this.vqm, paramm);
        continue;
        this.vqm.a(this.vqX, "startMonitoringBeacons:no uuids", null);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.Rc().b(1702, this);
      AppMethodBeat.o(154976);
      return;
      label125:
      this.vqm.a(this.vqX, "startMonitoringBeacons:system error", null);
      ab.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[] { paramString.lGL });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.52
 * JD-Core Version:    0.7.0.1
 */