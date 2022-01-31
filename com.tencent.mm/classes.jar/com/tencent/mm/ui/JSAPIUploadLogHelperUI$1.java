package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;

final class JSAPIUploadLogHelperUI$1
  implements bk.a
{
  JSAPIUploadLogHelperUI$1(JSAPIUploadLogHelperUI paramJSAPIUploadLogHelperUI, String paramString, int paramInt) {}
  
  public final void a(e arg1)
  {
    AppMethodBeat.i(29438);
    synchronized (JSAPIUploadLogHelperUI.Qj())
    {
      JSAPIUploadLogHelperUI.qn(true);
      aw.Rc().a(1, "", 0, false);
      ab.dsI();
      aw.Rc().a(2, this.fwC, this.gdN, aw.RG());
      AppMethodBeat.o(29438);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI.1
 * JD-Core Version:    0.7.0.1
 */