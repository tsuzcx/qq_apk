package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$15
  implements TextWatcher
{
  SnsUploadUI$15(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(176376);
    AppMethodBeat.o(176376);
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203773);
    if (SnsUploadUI.a(this.EPZ).getText().toString().trim().length() > 10)
    {
      paramCharSequence = this.EPZ.findViewById(2131308135);
      if (paramCharSequence != null) {
        paramCharSequence.setVisibility(8);
      }
    }
    AppMethodBeat.o(203773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.15
 * JD-Core Version:    0.7.0.1
 */