package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.event.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

final class a$2
  extends b
{
  a$2(a parama) {}
  
  public final void bFx()
  {
    AppMethodBeat.i(8648);
    ab.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { this.vmw.nkp });
    if ((this.vmw.foJ != null) && (this.vmw.foJ.getParent() != null) && (this.vmw.vmr != null) && (!bo.isNullOrNil(this.vmw.nkp)))
    {
      this.vmw.foJ.stopLoading();
      this.vmw.foJ.loadUrl(this.vmw.vmr.dfZ());
    }
    AppMethodBeat.o(8648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.2
 * JD-Core Version:    0.7.0.1
 */