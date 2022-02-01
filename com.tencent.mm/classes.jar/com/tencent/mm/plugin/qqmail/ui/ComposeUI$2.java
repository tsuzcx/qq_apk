package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$2
  implements TextWatcher
{
  ComposeUI$2(ComposeUI paramComposeUI, ImageView paramImageView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 4;
    AppMethodBeat.i(122893);
    if (this.uOk.uNO)
    {
      paramCharSequence = this.uOl;
      if (ComposeUI.j(this.uOk).getText().length() > 0) {
        paramInt1 = 0;
      }
      paramCharSequence.setVisibility(paramInt1);
      AppMethodBeat.o(122893);
      return;
    }
    this.uOl.setVisibility(4);
    AppMethodBeat.o(122893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.2
 * JD-Core Version:    0.7.0.1
 */