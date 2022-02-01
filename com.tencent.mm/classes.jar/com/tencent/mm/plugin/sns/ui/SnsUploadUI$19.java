package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$19
  implements TextWatcher
{
  SnsUploadUI$19(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(369905);
    if (SnsUploadUI.a(this.REd).getText().toString().trim().length() > 0)
    {
      this.REd.enableOptionMenu(true);
      AppMethodBeat.o(369905);
      return;
    }
    this.REd.enableOptionMenu(false);
    AppMethodBeat.o(369905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.19
 * JD-Core Version:    0.7.0.1
 */