package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceOSRedirect$1
  implements am.b.a
{
  RemittanceOSRedirect$1(RemittanceOSRedirect paramRemittanceOSRedirect, long paramLong, Intent paramIntent) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bk.UY() - this.iJC) + " ms");
      b.M(paramString, 3);
      o.Kj().kb(paramString);
    }
    for (;;)
    {
      this.nDY.startActivity(this.val$intent);
      this.nDY.finish();
      return;
      y.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect.1
 * JD-Core Version:    0.7.0.1
 */