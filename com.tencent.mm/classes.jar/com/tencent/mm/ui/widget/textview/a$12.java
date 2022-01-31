package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$12
  implements PopupWindow.OnDismissListener
{
  a$12(a parama) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(138211);
    this.ANs.AMT.setOnTouchListener(this.ANs.kjL);
    AppMethodBeat.o(138211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.12
 * JD-Core Version:    0.7.0.1
 */