package com.tencent.mm.ui;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am.a;

final class MMAppMgr$9
  implements am.a
{
  MMAppMgr$9(MMAppMgr paramMMAppMgr) {}
  
  public final boolean tC()
  {
    if (this.uNR.uNO >= 30) {
      return false;
    }
    if ((!com.tencent.mm.sdk.platformtools.l.ft(ae.getContext())) && (!this.uNR.uNK) && (g.DN().Dc()))
    {
      this.uNR.uNP = true;
      com.tencent.mm.plugin.webview.ui.tools.bag.l.rss.cfc();
      return false;
    }
    if ((this.uNR.uNK) && (this.uNR.uNP) && (g.DN().Dc()))
    {
      this.uNR.uNP = false;
      com.tencent.mm.plugin.webview.ui.tools.bag.l.rss.lp(true);
      return false;
    }
    MMAppMgr localMMAppMgr = this.uNR;
    localMMAppMgr.uNO += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.9
 * JD-Core Version:    0.7.0.1
 */