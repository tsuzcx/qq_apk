package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ComposeUI$8
  implements View.OnClickListener
{
  ComposeUI$8(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68176);
    paramView = this.pLX;
    String str1 = this.pLX.getString(2131302123);
    String str2 = this.pLX.getString(2131302120);
    String str3 = this.pLX.getString(2131302121);
    ComposeUI.8.1 local1 = new ComposeUI.8.1(this);
    h.a(paramView, null, new String[] { str1, str2, str3 }, null, local1);
    AppMethodBeat.o(68176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.8
 * JD-Core Version:    0.7.0.1
 */