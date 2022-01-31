package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.ui.base.h;

final class ComposeUI$13
  implements View.OnClickListener
{
  ComposeUI$13(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68187);
    if (!ComposeUI.E(this.pLX).cep())
    {
      ComposeUI.a(this.pLX, h.b(this.pLX, this.pLX.getString(2131302111), true, new ComposeUI.13.1(this)));
      ComposeUI.E(this.pLX).pMT = new ComposeUI.13.2(this);
      AppMethodBeat.o(68187);
      return;
    }
    u.b(ComposeUI.s(this.pLX), ComposeUI.n(this.pLX), ComposeUI.x(this.pLX));
    ComposeUI.I(this.pLX);
    AppMethodBeat.o(68187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.13
 * JD-Core Version:    0.7.0.1
 */