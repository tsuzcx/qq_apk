package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

final class ModRemarkNameUI$4
  implements View.OnClickListener
{
  ModRemarkNameUI$4(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void onClick(View paramView)
  {
    ModRemarkNameUI.f(this.vML).setVisibility(0);
    ModRemarkNameUI.g(this.vML).setVisibility(8);
    ModRemarkNameUI.h(this.vML).requestFocus();
    this.vML.showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.4
 * JD-Core Version:    0.7.0.1
 */