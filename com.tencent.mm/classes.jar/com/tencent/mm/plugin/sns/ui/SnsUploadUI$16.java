package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$16
  implements TextWatcher
{
  SnsUploadUI$16(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203774);
    if (SnsUploadUI.a(this.EPZ).getText().toString().trim().length() > 0)
    {
      this.EPZ.enableOptionMenu(true);
      AppMethodBeat.o(203774);
      return;
    }
    this.EPZ.enableOptionMenu(false);
    AppMethodBeat.o(203774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.16
 * JD-Core Version:    0.7.0.1
 */