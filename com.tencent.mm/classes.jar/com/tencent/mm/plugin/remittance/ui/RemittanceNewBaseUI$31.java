package com.tencent.mm.plugin.remittance.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class RemittanceNewBaseUI$31
  implements TextView.OnEditorActionListener
{
  RemittanceNewBaseUI$31(RemittanceNewBaseUI paramRemittanceNewBaseUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68241);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ac.i("MicroMsg.RemittanceNewBaseUI", "click enter");
      this.wJE.onClick(null);
      AppMethodBeat.o(68241);
      return true;
    }
    AppMethodBeat.o(68241);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.31
 * JD-Core Version:    0.7.0.1
 */