package com.tencent.mm.plugin.wallet_ecard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.cp;
import com.tencent.mm.h.a.cp.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.a;

final class a$1$1$1
  implements c.a
{
  a$1$1$1(a.1.1 param1) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == -1)
    {
      this.qJM.qJJ.bIJ.retCode = 0;
      h.nFQ.f(14954, new Object[] { f.cox(), "openEcard:ok" });
    }
    for (;;)
    {
      this.qJM.qJJ.bII.bFJ.run();
      if (!f.cow()) {
        f.coy();
      }
      return null;
      this.qJM.qJJ.bIJ.retCode = -1;
      if (!f.cow()) {
        h.nFQ.f(14954, new Object[] { f.cox(), "openEcard:fail" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.1.1.1
 * JD-Core Version:    0.7.0.1
 */