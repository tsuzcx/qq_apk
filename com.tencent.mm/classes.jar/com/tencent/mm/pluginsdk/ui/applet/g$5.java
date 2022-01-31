package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class g$5
  implements View.OnClickListener
{
  g$5(q.a parama, View paramView, o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27643);
    if (this.vTq != null) {
      this.vTq.a(true, g.eA(this.val$view), g.eB(this.val$view));
    }
    this.vTs.dismiss();
    this.vTs.setFocusable(false);
    this.vTs.setTouchable(false);
    AppMethodBeat.o(27643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.5
 * JD-Core Version:    0.7.0.1
 */