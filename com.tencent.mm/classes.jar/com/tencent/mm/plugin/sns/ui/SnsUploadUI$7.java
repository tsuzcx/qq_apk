package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mm.plugin.sns.i.f;

final class SnsUploadUI$7
  implements TextWatcher
{
  SnsUploadUI$7(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SnsUploadUI.f(this.pjp).getText().toString().trim().length() > 10)
    {
      paramCharSequence = this.pjp.findViewById(i.f.sns_img_tips);
      if (paramCharSequence != null) {
        paramCharSequence.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.7
 * JD-Core Version:    0.7.0.1
 */