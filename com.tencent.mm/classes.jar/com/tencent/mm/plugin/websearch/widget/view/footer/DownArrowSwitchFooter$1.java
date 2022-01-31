package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DownArrowSwitchFooter$1
  implements View.OnClickListener
{
  DownArrowSwitchFooter$1(DownArrowSwitchFooter paramDownArrowSwitchFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(91577);
    if (DownArrowSwitchFooter.a(this.uNA) != null) {
      DownArrowSwitchFooter.a(this.uNA).dar();
    }
    AppMethodBeat.o(91577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter.1
 * JD-Core Version:    0.7.0.1
 */