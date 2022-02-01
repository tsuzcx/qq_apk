package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$18
  implements TextWatcher
{
  SnsUploadUI$18(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293262);
    if (SnsUploadUI.a(this.LdU).getText().toString().trim().length() > 0)
    {
      this.LdU.enableOptionMenu(true);
      AppMethodBeat.o(293262);
      return;
    }
    this.LdU.enableOptionMenu(false);
    AppMethodBeat.o(293262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.18
 * JD-Core Version:    0.7.0.1
 */