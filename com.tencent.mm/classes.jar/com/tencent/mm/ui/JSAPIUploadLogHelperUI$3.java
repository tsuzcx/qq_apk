package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;

final class JSAPIUploadLogHelperUI$3
  implements aj
{
  JSAPIUploadLogHelperUI$3(JSAPIUploadLogHelperUI paramJSAPIUploadLogHelperUI, ProgressDialog paramProgressDialog, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void hK(int paramInt)
  {
    if (paramInt < 0)
    {
      y.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      au.a(null);
      if (this.noC != null) {
        this.noC.dismiss();
      }
      ??? = com.tencent.mm.ui.base.h.h(this.uKI, R.l.upload_fail, R.l.app_tip);
      if (??? != null) {
        ((c)???).setOnDismissListener(this.uKJ);
      }
      synchronized (JSAPIUploadLogHelperUI.access$000())
      {
        JSAPIUploadLogHelperUI.bp(false);
        return;
      }
    }
    if (paramInt >= 100)
    {
      y.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
      au.a(null);
      if (this.noC != null) {
        this.noC.dismiss();
      }
      ??? = com.tencent.mm.ui.base.h.h(this.uKI, R.l.upload_success, R.l.app_tip);
      if (??? != null) {
        ((c)???).setOnDismissListener(this.uKJ);
      }
      long l = System.currentTimeMillis() / 1000L;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12975, new Object[] { Long.valueOf(l) });
      synchronized (JSAPIUploadLogHelperUI.access$000())
      {
        JSAPIUploadLogHelperUI.bp(false);
        return;
      }
    }
    y.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.noC != null) {
      this.noC.setMessage(this.uKI.getString(R.l.upload_ing) + paramInt + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI.3
 * JD-Core Version:    0.7.0.1
 */