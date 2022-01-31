package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class MMBaseSelectContactUI$3
  implements m.a
{
  MMBaseSelectContactUI$3(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void t(String paramString, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBoolean) && (paramInt == 0))
    {
      if (!bk.bl(paramString))
      {
        MMBaseSelectContactUI.b(this.vLX);
        return;
      }
      MMBaseSelectContactUI.a(this.vLX);
      return;
    }
    MMBaseSelectContactUI.c(this.vLX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */