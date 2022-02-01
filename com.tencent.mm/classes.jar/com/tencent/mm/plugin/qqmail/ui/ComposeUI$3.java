package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$3
  implements View.OnClickListener
{
  ComposeUI$3(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(122894);
    ComposeUI.j(this.uOk).getText().clear();
    ComposeUI.j(this.uOk).requestFocus();
    AppMethodBeat.o(122894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.3
 * JD-Core Version:    0.7.0.1
 */