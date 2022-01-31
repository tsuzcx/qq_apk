package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.y;

final class k$5$4
  implements Runnable
{
  k$5$4(k.5 param5, Bundle paramBundle) {}
  
  public final void run()
  {
    boolean bool2 = false;
    byte[] arrayOfByte = this.byv.getByteArray("jsapi_control_bytes");
    boolean bool1;
    if ((arrayOfByte == null) || (this.rCx.rCv.rxH == null) || (this.rCx.rCv.rxH.cdI() == null)) {
      if (arrayOfByte != null)
      {
        bool1 = true;
        if (this.rCx.rCv.rxH != null) {
          bool2 = true;
        }
        y.e("MicroMsg.MMWebViewClient", "has JSAPI_CONTROL_BYTES %b, has wvPerm %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    for (;;)
    {
      if (this.rCx.rCv.rvZ != null) {
        this.rCx.rCv.rvZ.cfZ();
      }
      return;
      bool1 = false;
      break;
      y.i("MicroMsg.MMWebViewClient", "update control bytes by preverify, %d", new Object[] { Integer.valueOf(arrayOfByte.length) });
      this.rCx.rCv.rxH.cdI().spq = arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.4
 * JD-Core Version:    0.7.0.1
 */