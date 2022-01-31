package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;

final class JSAPIUploadLogHelperUI$3
  implements al
{
  JSAPIUploadLogHelperUI$3(JSAPIUploadLogHelperUI paramJSAPIUploadLogHelperUI, ProgressDialog paramProgressDialog, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void kw(int paramInt)
  {
    AppMethodBeat.i(29440);
    if (paramInt < 0)
    {
      ab.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      aw.a(null);
      if (this.pTQ != null) {
        this.pTQ.dismiss();
      }
      ??? = com.tencent.mm.ui.base.h.h(this.yYK, 2131304443, 2131297087);
      if (??? != null) {
        ((c)???).setOnDismissListener(this.yYL);
      }
      synchronized (JSAPIUploadLogHelperUI.Qj())
      {
        JSAPIUploadLogHelperUI.qn(false);
        AppMethodBeat.o(29440);
        return;
      }
    }
    if (paramInt >= 100)
    {
      ab.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
      aw.a(null);
      if (this.pTQ != null) {
        this.pTQ.dismiss();
      }
      ??? = com.tencent.mm.ui.base.h.h(this.yYK, 2131304447, 2131297087);
      if (??? != null) {
        ((c)???).setOnDismissListener(this.yYL);
      }
      long l = System.currentTimeMillis() / 1000L;
      com.tencent.mm.plugin.report.service.h.qsU.e(12975, new Object[] { Long.valueOf(l) });
      synchronized (JSAPIUploadLogHelperUI.Qj())
      {
        JSAPIUploadLogHelperUI.qn(false);
        AppMethodBeat.o(29440);
        return;
      }
    }
    ab.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.pTQ != null) {
      this.pTQ.setMessage(this.yYK.getString(2131304444) + paramInt + "%");
    }
    AppMethodBeat.o(29440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI.3
 * JD-Core Version:    0.7.0.1
 */