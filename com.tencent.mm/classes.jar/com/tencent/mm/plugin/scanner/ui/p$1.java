package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class p$1
  implements f.a
{
  p$1(p paramp) {}
  
  public final void q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(81200);
    ab.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81200);
      return;
      this.qAf.qzT = false;
      AppMethodBeat.o(81200);
      return;
      this.qAf.qzT = false;
      this.qAf.kn(true);
      AppMethodBeat.o(81200);
      return;
      this.qAf.kn(true);
      AppMethodBeat.o(81200);
      return;
      this.qAf.qzg.ciG();
      AppMethodBeat.o(81200);
      return;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("geta8key_fullurl");
        if ((paramBundle != null) && ((paramBundle.startsWith("http://login.weixin.qq.com")) || (paramBundle.startsWith("https://login.weixin.qq.com")))) {
          this.qAf.cpY = 2;
        }
      }
      this.qAf.qzg.kA(true);
      this.qAf.qzT = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.1
 * JD-Core Version:    0.7.0.1
 */