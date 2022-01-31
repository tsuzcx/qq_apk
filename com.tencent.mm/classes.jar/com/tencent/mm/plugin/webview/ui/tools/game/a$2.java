package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class a$2
  extends c
{
  a$2(a parama) {}
  
  public final void aYy()
  {
    y.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { this.rwe.kMs });
    if ((this.rwe.dYF != null) && (this.rwe.dYF.getParent() != null) && (this.rwe.rwb != null) && (!bk.bl(this.rwe.kMs)))
    {
      this.rwe.dYF.stopLoading();
      this.rwe.rwb.TI(this.rwe.kMs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.2
 * JD-Core Version:    0.7.0.1
 */