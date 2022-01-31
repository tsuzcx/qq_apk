package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DirectionSwitchFooter$1
  implements View.OnClickListener
{
  DirectionSwitchFooter$1(DirectionSwitchFooter paramDirectionSwitchFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(91569);
    if (DirectionSwitchFooter.a(this.uNz) != null) {
      DirectionSwitchFooter.a(this.uNz).dat();
    }
    AppMethodBeat.o(91569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter.1
 * JD-Core Version:    0.7.0.1
 */