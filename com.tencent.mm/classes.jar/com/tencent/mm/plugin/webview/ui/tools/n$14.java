package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;

final class n$14
  implements Runnable
{
  n$14(n paramn, WebViewUI paramWebViewUI, Bundle paramBundle, k paramk, d paramd) {}
  
  public final void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(7726);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7726);
      return;
    }
    byte[] arrayOfByte = this.cax.getByteArray("jsapi_control_bytes");
    boolean bool1;
    if ((arrayOfByte == null) || (this.vdq == null) || (this.vdq.ddV() == null)) {
      if (arrayOfByte != null)
      {
        bool1 = true;
        if (this.vdq != null) {
          bool2 = true;
        }
        ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "has JSAPI_CONTROL_BYTES %b, has wvPerm %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    for (;;)
    {
      if (this.vdp != null) {
        this.vdp.dgk();
      }
      AppMethodBeat.o(7726);
      return;
      bool1 = false;
      break;
      ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "update control bytes by preverify, %d", new Object[] { Integer.valueOf(arrayOfByte.length) });
      this.vdq.ddV().wif = arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.14
 * JD-Core Version:    0.7.0.1
 */