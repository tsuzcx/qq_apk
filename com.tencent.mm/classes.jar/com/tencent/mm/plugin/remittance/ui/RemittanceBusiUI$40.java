package com.tencent.mm.plugin.remittance.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class RemittanceBusiUI$40
  implements TextView.OnEditorActionListener
{
  RemittanceBusiUI$40(RemittanceBusiUI paramRemittanceBusiUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68052);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ac.i("MicroMsg.RemittanceBusiUI", "click enter");
      this.wJE.onClick(null);
      AppMethodBeat.o(68052);
      return true;
    }
    AppMethodBeat.o(68052);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.40
 * JD-Core Version:    0.7.0.1
 */