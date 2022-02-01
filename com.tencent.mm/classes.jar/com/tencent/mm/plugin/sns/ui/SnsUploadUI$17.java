package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$17
  implements TextWatcher
{
  SnsUploadUI$17(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(231025);
    if (SnsUploadUI.a(this.LdU).getText().toString().trim().length() > 10)
    {
      paramCharSequence = this.LdU.findViewById(i.f.sns_img_tips);
      if (paramCharSequence != null) {
        paramCharSequence.setVisibility(8);
      }
    }
    AppMethodBeat.o(231025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.17
 * JD-Core Version:    0.7.0.1
 */