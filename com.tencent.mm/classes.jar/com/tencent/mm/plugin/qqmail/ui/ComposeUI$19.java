package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$19
  implements View.OnFocusChangeListener
{
  ComposeUI$19(ComposeUI paramComposeUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(122931);
    if (paramBoolean) {
      ComposeUI.j(this.Hpf).setSelection(ComposeUI.j(this.Hpf).getText().length());
    }
    AppMethodBeat.o(122931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.19
 * JD-Core Version:    0.7.0.1
 */