package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class ComposeUI$11
  implements View.OnClickListener
{
  ComposeUI$11(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68183);
    this.pLX.hideVKB();
    ComposeUI.j(this.pLX).getText();
    ComposeUI.D(this.pLX);
    if (!this.pLX.ceg())
    {
      AppMethodBeat.o(68183);
      return;
    }
    paramView = this.pLX;
    ComposeUI localComposeUI = this.pLX;
    this.pLX.getString(2131297087);
    ComposeUI.a(paramView, h.b(localComposeUI, this.pLX.getString(2131302114), true, new ComposeUI.11.1(this)));
    if (!ComposeUI.E(this.pLX).cep())
    {
      ComposeUI.G(this.pLX).setMessage(this.pLX.getString(2131302111));
      ComposeUI.E(this.pLX).pMT = new ComposeUI.11.2(this);
      AppMethodBeat.o(68183);
      return;
    }
    ComposeUI.a(this.pLX, ComposeUI.H(this.pLX));
    AppMethodBeat.o(68183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11
 * JD-Core Version:    0.7.0.1
 */