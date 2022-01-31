package com.tencent.mm.plugin.remittance.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceNewBaseUI$23
  implements TextView.OnEditorActionListener
{
  RemittanceNewBaseUI$23(RemittanceNewBaseUI paramRemittanceNewBaseUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142248);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ab.i("MicroMsg.RemittanceNewBaseUI", "click enter");
      this.qoN.onClick(null);
      AppMethodBeat.o(142248);
      return true;
    }
    AppMethodBeat.o(142248);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.23
 * JD-Core Version:    0.7.0.1
 */