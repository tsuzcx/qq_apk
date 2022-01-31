package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceF2fDynamicCodeUI$1
  implements x.a
{
  RemittanceF2fDynamicCodeUI$1(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(45051);
    if ((paramString == null) || (RemittanceF2fDynamicCodeUI.a(this.qqI) == null))
    {
      AppMethodBeat.o(45051);
      return;
    }
    if (paramString.equals(RemittanceF2fDynamicCodeUI.a(this.qqI)))
    {
      ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[] { RemittanceF2fDynamicCodeUI.a(this.qqI), paramString });
      this.qqI.runOnUiThread(new RemittanceF2fDynamicCodeUI.1.1(this));
    }
    AppMethodBeat.o(45051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.1
 * JD-Core Version:    0.7.0.1
 */