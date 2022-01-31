package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.y;

final class PluginZero$1
  implements com.tencent.mm.kernel.api.g
{
  PluginZero$1(PluginZero paramPluginZero, com.tencent.mm.kernel.b.g paramg) {}
  
  public final void aP(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      l.k(this.bwq.bT, true);
      l.l(this.bwq.bT, true);
    }
    y.cqL();
  }
  
  public final void tj()
  {
    a.j("onStartupDone", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.1
 * JD-Core Version:    0.7.0.1
 */