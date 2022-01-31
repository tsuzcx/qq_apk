package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.b;

final class RemittanceBaseUI$19$1
  implements h.b
{
  RemittanceBaseUI$19$1(RemittanceBaseUI.19 param19) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    if (!bk.bl(paramCharSequence.toString()))
    {
      this.nAK.nAH.dkv = paramCharSequence.toString();
      RemittanceBaseUI.b(this.nAK.nAH);
    }
    for (;;)
    {
      return true;
      this.nAK.nAH.dkv = null;
      RemittanceBaseUI.b(this.nAK.nAH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.19.1
 * JD-Core Version:    0.7.0.1
 */