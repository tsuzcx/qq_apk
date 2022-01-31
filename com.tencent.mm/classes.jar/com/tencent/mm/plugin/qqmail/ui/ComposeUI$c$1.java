package com.tencent.mm.plugin.qqmail.ui;

import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class ComposeUI$c$1
  implements Runnable
{
  ComposeUI$c$1(ComposeUI.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(68211);
    if ((!ComposeUI.e(this.pMl.pLX).pNx.isFocused()) && (!ComposeUI.f(this.pMl.pLX).pNx.isFocused()) && (ComposeUI.e(this.pMl.pLX).getMailAddrs().size() == 0) && (ComposeUI.f(this.pMl.pLX).getMailAddrs().size() == 0) && (ComposeUI.e(this.pMl.pLX).cet()) && (ComposeUI.f(this.pMl.pLX).cet()))
    {
      ComposeUI.z(this.pMl.pLX).setVisibility(0);
      ComposeUI.A(this.pMl.pLX).setVisibility(8);
      ComposeUI.B(this.pMl.pLX).setVisibility(8);
    }
    AppMethodBeat.o(68211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.c.1
 * JD-Core Version:    0.7.0.1
 */