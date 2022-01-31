package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class g$16
  extends n.a
{
  private final byte[] dZg;
  
  g$16(g paramg)
  {
    AppMethodBeat.i(153153);
    this.dZg = new byte[0];
    AppMethodBeat.o(153153);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(153154);
    synchronized (this.dZg)
    {
      if (at.getNetType(ah.getContext()) == 0)
      {
        aq.dcc().setNetWorkState(1);
        g.JW(paramInt);
        AppMethodBeat.o(153154);
        return;
      }
      aq.dcc().setNetWorkState(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.16
 * JD-Core Version:    0.7.0.1
 */