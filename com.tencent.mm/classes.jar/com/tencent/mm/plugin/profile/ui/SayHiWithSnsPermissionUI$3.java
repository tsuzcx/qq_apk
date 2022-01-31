package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;

final class SayHiWithSnsPermissionUI$3
  implements View.OnFocusChangeListener
{
  SayHiWithSnsPermissionUI$3(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (!bk.L(SayHiWithSnsPermissionUI.b(this.mZo).getHint())) && (bk.L(SayHiWithSnsPermissionUI.b(this.mZo).getText())))
    {
      SayHiWithSnsPermissionUI.b(this.mZo).setText(SayHiWithSnsPermissionUI.b(this.mZo).getHint());
      SayHiWithSnsPermissionUI.b(this.mZo).setOnFocusChangeListener(null);
      SayHiWithSnsPermissionUI.b(this.mZo).setHint(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.3
 * JD-Core Version:    0.7.0.1
 */