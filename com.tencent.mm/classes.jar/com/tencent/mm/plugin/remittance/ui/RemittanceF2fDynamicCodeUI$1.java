package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceF2fDynamicCodeUI$1
  implements x.a
{
  RemittanceF2fDynamicCodeUI$1(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (RemittanceF2fDynamicCodeUI.a(this.nDP) == null)) {}
    while (!paramString.equals(RemittanceF2fDynamicCodeUI.a(this.nDP))) {
      return;
    }
    y.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(this.nDP), paramString });
    this.nDP.runOnUiThread(new RemittanceF2fDynamicCodeUI.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.1
 * JD-Core Version:    0.7.0.1
 */