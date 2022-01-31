package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;

final class k$5$4
  implements Runnable
{
  k$5$4(k.5 param5, Bundle paramBundle) {}
  
  public final void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9928);
    byte[] arrayOfByte = this.cax.getByteArray("jsapi_control_bytes");
    boolean bool1;
    if ((arrayOfByte == null) || (this.vsJ.vsH.voA == null) || (this.vsJ.vsH.voA.ddV() == null)) {
      if (arrayOfByte != null)
      {
        bool1 = true;
        if (this.vsJ.vsH.voA != null) {
          bool2 = true;
        }
        ab.e("MicroMsg.MMWebViewClient", "has JSAPI_CONTROL_BYTES %b, has wvPerm %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    for (;;)
    {
      if (this.vsJ.vsH.vmp != null) {
        this.vsJ.vsH.vmp.dgk();
      }
      AppMethodBeat.o(9928);
      return;
      bool1 = false;
      break;
      ab.i("MicroMsg.MMWebViewClient", "update control bytes by preverify, %d", new Object[] { Integer.valueOf(arrayOfByte.length) });
      this.vsJ.vsH.voA.ddV().wif = arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.4
 * JD-Core Version:    0.7.0.1
 */