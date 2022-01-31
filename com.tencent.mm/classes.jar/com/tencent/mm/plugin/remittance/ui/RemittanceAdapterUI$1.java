package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceAdapterUI$1
  implements am.b.a
{
  RemittanceAdapterUI$1(RemittanceAdapterUI paramRemittanceAdapterUI, long paramLong, w paramw, Intent paramIntent) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bk.UY() - this.iJC) + " ms");
      b.M(paramString, 3);
      o.Kj().kb(paramString);
    }
    for (;;)
    {
      this.nzS.c(this.nzS.djD, this.nzQ.scene, this.nzR);
      return;
      y.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI.1
 * JD-Core Version:    0.7.0.1
 */