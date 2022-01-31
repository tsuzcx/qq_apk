package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a$4(a parama) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(138209);
    this.ANs.AMT.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    if (this.ANs.AMU != null)
    {
      this.ANs.AMT.getLocationInWindow(this.ANs.sfd);
      ak.d("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(this.ANs.sfd[0]), Integer.valueOf(this.ANs.sfd[1]) });
    }
    AppMethodBeat.o(138209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.4
 * JD-Core Version:    0.7.0.1
 */