package com.tencent.mm.plugin.webview.ui.tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R.h;

final class CreateAvatarUI$5
  implements TextWatcher
{
  CreateAvatarUI$5(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!CreateAvatarUI.b(this.rkL).getText().toString().equals(""))
    {
      this.rkL.findViewById(R.h.create_avatar_btn_save).setEnabled(true);
      return;
    }
    this.rkL.findViewById(R.h.create_avatar_btn_save).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.5
 * JD-Core Version:    0.7.0.1
 */