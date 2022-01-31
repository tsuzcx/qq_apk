package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BtnSwitchFooter$1
  implements View.OnClickListener
{
  BtnSwitchFooter$1(BtnSwitchFooter paramBtnSwitchFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(91560);
    if (BtnSwitchFooter.a(this.uNu) != null) {
      BtnSwitchFooter.a(this.uNu).dar();
    }
    AppMethodBeat.o(91560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter.1
 * JD-Core Version:    0.7.0.1
 */