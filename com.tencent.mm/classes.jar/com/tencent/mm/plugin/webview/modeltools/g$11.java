package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

final class g$11
  extends n.a
{
  private final byte[] dhN = new byte[0];
  
  g$11(g paramg) {}
  
  public final void et(int paramInt)
  {
    synchronized (this.dhN)
    {
      if (aq.getNetType(ae.getContext()) == 0)
      {
        al.cbY().setNetWorkState(1);
        g.Cj(paramInt);
        return;
      }
      al.cbY().setNetWorkState(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.11
 * JD-Core Version:    0.7.0.1
 */