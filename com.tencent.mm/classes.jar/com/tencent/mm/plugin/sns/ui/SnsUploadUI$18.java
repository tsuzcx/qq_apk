package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.ui.widget.cedit.api.c;

final class SnsUploadUI$18
  implements TextWatcher
{
  SnsUploadUI$18(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(307834);
    if (SnsUploadUI.a(this.REd).getText().toString().trim().length() > 10)
    {
      paramCharSequence = this.REd.findViewById(b.f.sns_img_tips);
      if (paramCharSequence != null) {
        paramCharSequence.setVisibility(8);
      }
    }
    AppMethodBeat.o(307834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.18
 * JD-Core Version:    0.7.0.1
 */