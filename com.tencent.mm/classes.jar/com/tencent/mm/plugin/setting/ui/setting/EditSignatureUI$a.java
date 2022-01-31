package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.ui.tools.f;

final class EditSignatureUI$a
  implements TextWatcher
{
  private int nRO = 60;
  
  private EditSignatureUI$a(EditSignatureUI paramEditSignatureUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.nRO = f.bi(60, paramEditable.toString());
    if (this.nRO < 0) {
      this.nRO = 0;
    }
    if (EditSignatureUI.e(this.nRN) != null) {
      EditSignatureUI.e(this.nRN).setText(this.nRO);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.nRN.enableOptionMenu(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.a
 * JD-Core Version:    0.7.0.1
 */