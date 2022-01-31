package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class MMBaseSelectContactUI$3
  implements n.a
{
  MMBaseSelectContactUI$3(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(105216);
    ab.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBoolean) && (paramInt == 0))
    {
      if (!bo.isNullOrNil(paramString))
      {
        MMBaseSelectContactUI.b(this.Adz);
        AppMethodBeat.o(105216);
        return;
      }
      MMBaseSelectContactUI.a(this.Adz);
      AppMethodBeat.o(105216);
      return;
    }
    MMBaseSelectContactUI.c(this.Adz);
    AppMethodBeat.o(105216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */