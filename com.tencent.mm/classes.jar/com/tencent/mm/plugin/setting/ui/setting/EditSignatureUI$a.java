package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;

final class EditSignatureUI$a
  implements TextWatcher
{
  private int JeB = 60;
  
  private EditSignatureUI$a(EditSignatureUI paramEditSignatureUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(73876);
    this.JeB = g.dq(60, paramEditable.toString());
    if (this.JeB < 0) {
      this.JeB = 0;
    }
    if (EditSignatureUI.a(this.JeA) != null) {
      EditSignatureUI.a(this.JeA).setText(this.JeB);
    }
    AppMethodBeat.o(73876);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(73875);
    this.JeA.enableOptionMenu(true);
    AppMethodBeat.o(73875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.a
 * JD-Core Version:    0.7.0.1
 */